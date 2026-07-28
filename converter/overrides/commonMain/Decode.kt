// Hand-written multiplatform port of Decode.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

import kotlin.math.floor

/**
 * Decodes binary to objects.
 */
class Decode : MesgSource {
    // Public Variables
    enum class RETURN {
        CONTINUE, MESG, MESG_DEF, END_OF_FILE
    }

    // Private Variables
    private enum class STATE {
        FILE_HDR,
        RECORD,
        RESERVED1,
        ARCH,
        MESG_NUM_0,
        MESG_NUM_1,
        NUM_FIELDS,
        FIELD_NUM,
        FIELD_SIZE,
        FIELD_TYPE,
        NUM_DEV_FIELDS,
        DEV_FIELD_NUM,
        DEV_FIELD_SIZE,
        DEV_FIELD_DEV_ID,
        FIELD_DATA,
        DEV_FIELD_DATA,
        FILE_CRC_HIGH
    }

    private class AccumulatedField(
        val mesgNum: Int,
        val destFieldNum: Int // Field# to accumulate into
    ) {
        var lastValue: Long = 0
        var accumulatedValue: Long = 0

        fun accumulate(value: Long, bits: Int): Long {
            val mask = (1L shl bits) - 1

            accumulatedValue += (value - lastValue) and mask
            lastValue = value

            return accumulatedValue
        }

        fun set(value: Long): Long {
            accumulatedValue = value
            lastValue = value
            return accumulatedValue
        }
    }

    // NOTE: this is Decode's private accumulator (as in Java), distinct from the
    // top-level Accumulator class used by DecoderBase.
    private class Accumulator {
        // Index by Mesg# and DestField#
        val accumulatedFields = ArrayList<AccumulatedField>()

        fun set(mesgNum: Int, destFieldNum: Int, value: Long) {
            var accumField: AccumulatedField? = null
            var i = 0

            while (i < accumulatedFields.size) {
                accumField = accumulatedFields[i]

                if ((accumField.mesgNum == mesgNum) && (accumField.destFieldNum == destFieldNum)) {
                    break
                }
                i++
            }

            if (i == accumulatedFields.size) {
                accumField = AccumulatedField(mesgNum, destFieldNum)
                accumulatedFields.add(accumField)
            }

            accumField!!.set(value)
        }

        fun accumulate(mesgNum: Int, destFieldNum: Int, value: Long, bits: Int): Long {
            var accumField: AccumulatedField? = null
            var i = 0

            while (i < accumulatedFields.size) {
                accumField = accumulatedFields[i]

                if ((accumField.mesgNum == mesgNum) && (accumField.destFieldNum == destFieldNum)) {
                    break
                }
                i++
            }

            if (i == accumulatedFields.size) {
                accumField = AccumulatedField(mesgNum, destFieldNum)
                accumulatedFields.add(accumField)
            }

            return accumField!!.accumulate(value, bits)
        }
    }

    companion object {
        private const val DECODE_DATA_RECORDS_ONLY: Long = Long.MAX_VALUE
        private const val FIT_PROTOCOL_VERSION_ONE = 1
        private const val FIT_HEADER_SIZE_WITH_CRC = 14
        private const val FIT_HEADER_SIZE_NO_CRC = 12
        private const val BUFFER_SIZE = 512

        // static in Java: shared across all Decode instances
        private var invalidDataSize = false

        private fun hex(value: Int, width: Int): String {
            return value.toString(16).uppercase().padStart(width, '0')
        }

        internal fun is64BitType(type: Int): Boolean {
            return type == Fit.BASE_TYPE_SINT64 || type == Fit.BASE_TYPE_UINT64 || type == Fit.BASE_TYPE_UINT64Z
        }

        // Rewritten without BigDecimal/BigInteger (DESIGN.md §1.4): the unsigned 64-bit path
        // uses ULong, all scaling is done in Double. Theoretical precision loss beyond 2^53
        // is accepted. Rounding matches Java's RoundingMode.HALF_UP (half away from zero).
        internal fun applyScaleOffset64(
            bitsValue: Long, fieldType: Int,
            componentScale: Double, componentOffset: Double,
            fieldScale: Double, fieldOffset: Double
        ): Any {
            // Recover the true unsigned value when getBitsValue has sign-extended a bit-pattern >= 2^63.
            val isUnsigned = (fieldType == Fit.BASE_TYPE_UINT64 || fieldType == Fit.BASE_TYPE_UINT64Z)

            val d: Double = if (isUnsigned) bitsValue.toULong().toDouble() else bitsValue.toDouble()

            val result = (((d / componentScale) - componentOffset) + fieldOffset) * fieldScale
            val rounded = if (result < 0) -floor(-result + 0.5) else floor(result + 0.5)

            return if (isUnsigned) rounded.toULong() else rounded.toLong()
        }
    }

    private var hasDevData = false
    private var state: STATE = STATE.FILE_HDR
    private var fileHdrOffset: Byte = 0
    private var fileHdrSize: Byte = 0
    private var fileDataSize: Long = 0
    private var fileBytesLeft: Long = 0
    private var crc: Int = 0
    private var mesg: Mesg? = null
    private var localMesgIndex = 0
    private val localMesgDefs: Array<MesgDefinition?> = arrayOfNulls(Fit.MAX_LOCAL_MESGS)
    private val developerDataIds = HashMap<Short, DeveloperDataIdMesg>()
    private val developerFields = HashMap<Short, HashMap<Short, FieldDescriptionMesg>>()
    private var decoderMesgIndex = 0
    private var skipExpandComponents = false

    private var numFields = 0
    private var fieldIndex = 0
    private var fieldDataIndex = 0
    private var fieldBytesLeft = 0
    private val fieldData = ByteArray(Fit.MAX_FIELD_SIZE)
    private var lastTimeOffset = 0
    private var timestamp: Long = 0
    private var systemTimeOffset: Long = 0
    private val accumulator = Accumulator()
    private var pause = false
    private var `in`: InputStream? = null
    private var instreamIsComplete = true
    private var invalidFileDataSize = false
    private var headerException: String? = null
    private var currentByteOffset = 0

    private val mesgListeners = ArrayList<MesgListener>()
    private val mesgDefListeners = ArrayList<MesgDefinitionListener>()
    private val devFieldDescListeners = ArrayList<DeveloperFieldDescriptionListener>()

    private var bytesRead = 0
    private var currentByteIndex = 0
    private val buffer = ByteArray(BUFFER_SIZE)

    init {
        systemTimeOffset = 0
        instreamIsComplete = true
        nextFile()
        bytesRead = 0
        currentByteIndex = 0
        if (Fit.debug) {
            println("Fit.Decode: Starting decode...")
        }
    }

    /**
     * Gets the property that indicates that the file has an invalid data size
     *
     * @return true if file has an invalid data size
     */
    fun getInvalidFileDataSize(): Boolean {
        return invalidFileDataSize
    }

    /**
     * Sets the Invalid Data size Property (so that it can be reset)
     *
     * @param value
     *           boolean value to set
     */
    fun setInvalidFileDataSize(value: Boolean) {
        invalidFileDataSize = value
    }

    fun nextFile() {
        // Only reset the decoder if we have the entire chained file
        if (instreamIsComplete) {
            fileBytesLeft = 3 // Header byte + CRC.
            fileHdrOffset = 0
            crc = 0
            state = STATE.FILE_HDR
            lastTimeOffset = 0
            pause = false
            invalidDataSize = false
            invalidFileDataSize = false
            headerException = null
        }
    }

    override fun addListener(mesgListener: MesgListener) {
        if (!mesgListeners.contains(mesgListener)) {
            mesgListeners.add(mesgListener)
        }
    }

    fun addListener(mesgDefinitionListener: MesgDefinitionListener?) {
        if ((mesgDefinitionListener != null) && !mesgDefListeners.contains(mesgDefinitionListener)) {
            mesgDefListeners.add(mesgDefinitionListener)
        }
    }

    fun addListener(listener: DeveloperFieldDescriptionListener?) {
        if ((listener != null) && !devFieldDescListeners.contains(listener)) {
            devFieldDescListeners.add(listener)
        }
    }

    fun setSystemTimeOffset(systemTimeOffset: Long) {
        this.systemTimeOffset = systemTimeOffset
    }

    /**
     * Override the default read behaviour by skipping header decode.
     * CRC checking is not possible since the datasize is unknown.
     * Decode continues until EOF is encountered or a decode
     * error occurs.
     * May only be called prior to calling read().
     * Can be combined with incompleteStream() option.
     */
    fun skipHeader() {
        // Do not allow changing the settings after read has started
        if (`in` != null) {
            throw FitRuntimeException("Can't set skipHeader option after Decode started!")
        }
        // Skip header decode
        state = STATE.RECORD
        // Decode until we hit EOF, don't consider CRC
        fileBytesLeft = DECODE_DATA_RECORDS_ONLY
    }

    /**
     * Override the default read behaviour allowing decode of partial streams.
     * If EOF is encountered no exception is raised.  Caller may choose to
     * call resume() possibly after more bytes have arrived in the stream.
     * May only be set prior to first calling read().
     *
     */
    fun incompleteStream() {
        // Do not allow changing the settings after read has started
        if (`in` != null) {
            throw FitRuntimeException("Can't set incompleteStream option after Decode started!")
        }
        // Don't raise an error if eof is encountered during decode,
        // caller may try to resume if more bytes arrive
        this.instreamIsComplete = false
    }

    /**
     * Allow for invalid values in messages. Can override setting
     * implied by Fit.ENABLE_LEGACY_BEHAVIOUR. Should only be used by
     * CSV tool to allow for override at the application level. If this
     * behaviour is desired by default, Fit.ENABLE_LEGACY_BEHAVIOUR should
     * be modified instead. Can only be called before calling resume().
     *
     */
    fun showInvalidValues() {
        // Do not allow changing the settings after read has started
        if (`in` != null) {
            throw FitRuntimeException("Can't set showInvalidValues option after Decode started!")
        }

        FieldBase.forceShowInvalids = true
    }

    /**
     * Reads a FIT binary file.
     *
     * @param in
     *           file input stream
     * @param mesgListener
     *           message listener
     * @param mesgDefListener
     *           message definition listener
     * @return true if finished reading file
     */
    fun read(`in`: InputStream, mesgListener: MesgListener?, mesgDefListener: MesgDefinitionListener?): Boolean {
        var status = true
        if (mesgListener != null) {
            addListener(mesgListener)
        }
        addListener(mesgDefListener)
        currentByteOffset = 0
        try {
            while (bytesAvailable(`in`) && status) { // try to read a file while more data is available.
                status = read(`in`)
                nextFile()
            }
        } catch (e: IOException) {
            throw FitRuntimeException(e)
        }

        return status
    }

    /**
     * Reads a FIT binary file.
     *
     * @param in
     *           file input stream
     * @param mesgListener
     *           message listener
     * @return true if finished reading file
     */
    fun read(`in`: InputStream, mesgListener: MesgListener?): Boolean {
        if (mesgListener != null) {
            addListener(mesgListener)
        }
        return read(`in`)
    }

    fun read(`in`: InputStream): Boolean {
        this.`in` = `in`
        return resume()
    }

    fun pause() {
        pause = true
    }

    /**
     * Resumes reading the file.
     *
     * @return true if finished reading file
     */
    fun resume(): Boolean {
        pause = false
        var decodeReturn = RETURN.CONTINUE

        try {
            while (true) {
                if (pause) {
                    return false
                }

                while (currentByteIndex < bytesRead) {
                    decodeReturn = read(buffer[currentByteIndex])

                    when (decodeReturn) {
                        RETURN.CONTINUE -> {
                        }

                        RETURN.MESG -> {
                            when (mesg!!.num) {
                                MesgNum.DEVELOPER_DATA_ID -> {
                                    val devIdMesg = DeveloperDataIdMesg(mesg!!)
                                    val index: Short = devIdMesg.getDeveloperDataIndex()!!
                                    developerDataIds[index] = devIdMesg
                                    developerFields[index] = HashMap()
                                }

                                MesgNum.FIELD_DESCRIPTION -> {
                                    val fieldDescriptionMesg = FieldDescriptionMesg(mesg!!)
                                    val index: Short = fieldDescriptionMesg.getDeveloperDataIndex()!!
                                    if (developerFields.containsKey(index)) {
                                        developerFields[index]!![fieldDescriptionMesg.getFieldDefinitionNumber()!!] = fieldDescriptionMesg

                                        val description = DeveloperFieldDescription(developerDataIds[index]!!, fieldDescriptionMesg)
                                        for (listener in devFieldDescListeners) {
                                            listener.onDescription(description)
                                        }
                                    }
                                }
                            }
                            for (mesgListener in mesgListeners) {
                                mesgListener.onMesg(mesg!!)
                            }
                        }

                        RETURN.MESG_DEF -> {
                            for (mesgDefListener in mesgDefListeners) {
                                mesgDefListener.onMesgDefinition(localMesgDefs[localMesgIndex]!!)
                            }
                        }

                        RETURN.END_OF_FILE -> {
                            // Increment so we do not read the same byte twice in the case of a chained file
                            currentByteIndex++
                            currentByteOffset++
                            return true
                        }
                    }
                    // Increment offset from the start of the file to get byte location for error reporting
                    currentByteOffset++
                    currentByteIndex++
                }
                currentByteIndex = 0
                bytesRead = `in`!!.read(buffer, 0, buffer.size)
                if (bytesRead < 0) {
                    break
                }
            }
        } catch (e: IOException) {
            throw FitRuntimeException(e)
        }

        if (instreamIsComplete && (fileBytesLeft != DECODE_DATA_RECORDS_ONLY)) {
            // When decoding a complete file we should exit via END_OF_FILE state only
            throw FitRuntimeException("FIT decode error: Unexpected end of input stream at byte: $currentByteOffset")
        }
        if (!instreamIsComplete) {
            // If stream is not yet complete caller can resume() when there is more data
            // or decide there was an error.
            if ((decodeReturn == RETURN.MESG) || (decodeReturn == RETURN.MESG_DEF)) {
                // Our stream ended on a complete message, maybe we are done decoding
                return true
            } else {
                // EOF was encountered mid message.  Caller may want to resume once
                // more bytes are available.
                return false
            }
        }
        // if Decoding Records section only, file should end on a complete message
        // (unless incomplete stream option above was also used)
        else {
            if ((decodeReturn == RETURN.MESG) || (decodeReturn == RETURN.MESG_DEF)) {
                // Our stream ended on a complete message, we are done decoding
                return true
            } else {
                if ((!invalidDataSize) || (!invalidFileDataSize)) {
                    throw FitRuntimeException("FIT decode error: Unexpected end of input stream at byte: $currentByteOffset")
                } else {
                    return true
                }
            }
        }
    }

    /**
     * Reads the header to determine if the file is FIT.
     *
     * @param in
     *           file input stream
     *
     * @return true if file is FIT
     */
    fun isFileFit(`in`: InputStream): Boolean {
        try {
            while (true) {
                while (currentByteIndex < bytesRead) {
                    when (this.read(buffer[currentByteIndex])) {
                        RETURN.CONTINUE,
                        RETURN.MESG,
                        RETURN.MESG_DEF -> {
                        }

                        RETURN.END_OF_FILE -> return true
                    }

                    if (this.state != STATE.FILE_HDR) {
                        return true
                    }
                    currentByteIndex++
                }
                currentByteIndex = 0
                bytesRead = `in`.read(buffer, 0, buffer.size)
                if (bytesRead < 0) {
                    break
                }
            }
        } catch (e: IOException) {
            throw FitRuntimeException(e)
        } catch (e: FitRuntimeException) {
            // Fall through and return as not FIT after resetting buffer state.
            bytesRead = 0
            currentByteIndex = 0
        }

        return false
    }

    /**
     * Reads the FIT binary file header and crc to check compatibility and integrity.
     *
     * @param in
     *           file input stream
     *
     * @return true if file is ok (not corrupt)
     */
    fun checkFileIntegrity(`in`: InputStream): Boolean {
        var status = true

        try {
            while (true) {
                while (currentByteIndex < bytesRead) {
                    when (this.read(buffer[currentByteIndex])) {
                        RETURN.CONTINUE,
                        RETURN.MESG,
                        RETURN.MESG_DEF -> {
                        }

                        RETURN.END_OF_FILE -> this.nextFile()
                    }
                    currentByteIndex++
                }
                currentByteIndex = 0
                bytesRead = `in`.read(buffer, 0, buffer.size)
                if (bytesRead < 0) {
                    break
                }
            }
        } catch (e: IOException) {
            throw FitRuntimeException(e)
        } catch (e: FitRuntimeException) {
            // Fall through and return integrity failure.
            status = false
            //If we hit the case where invalid data size, reset file state.
            if (getInvalidFileDataSize()) {
                nextFile()
            }
            // Reset buffer state.
            bytesRead = 0
            currentByteIndex = 0
        }

        return status
    }

    fun read(data: Byte): RETURN {
        if (Fit.debug) {
            if (fileBytesLeft == 2L) {
                println("Fit.Decode: Expecting next 2 bytes to be end of file CRC = 0x" + hex(crc, 4))
            }
            println("Fit.Decode: 0x" + hex(data.toInt() and 0xFF, 2) + " - " + state.toString())
        }

        // Only check crc for source files with header/footer
        if ((fileBytesLeft > 0) && (fileBytesLeft != DECODE_DATA_RECORDS_ONLY)) {
            crc = CRC.get16(crc, data)

            fileBytesLeft--

            if ((fileBytesLeft == 1L) && (state.ordinal > STATE.FILE_HDR.ordinal)) { // CRC low byte.
                if (state != STATE.RECORD) {
                    throw FitRuntimeException("FIT decode error: Decoder not in correct state after last data byte in file.  Check message definitions. Error at byte: $currentByteOffset")
                }

                return RETURN.CONTINUE // Next byte.
            } else if ((fileBytesLeft == 0L) && (state.ordinal > STATE.FILE_HDR.ordinal)) { // CRC high byte.
                if (crc != 0) {
                    throw FitRuntimeException("FIT decode error: File CRC failed. Error at byte: $currentByteOffset")
                }

                return RETURN.END_OF_FILE
            }
        }

        when (state) {
            STATE.FILE_HDR -> {
                val hdrOffset = fileHdrOffset.toInt()
                fileHdrOffset++
                when (hdrOffset) {
                    0 -> {
                        if (data.toInt() == 0) {
                            fileBytesLeft += 1
                            fileHdrOffset = 0
                            headerException = null
                            crc = 0
                        } else if (data < FIT_HEADER_SIZE_NO_CRC) {
                            headerException = "FIT decode error: Header size is invalid. Error at byte: $currentByteOffset"
                        } else {
                            fileHdrSize = data
                            fileBytesLeft = (fileHdrSize + 2).toLong()
                        }
                    }
                    1 -> {
                        if ((data.toInt() and Fit.PROTOCOL_VERSION_MAJOR_MASK) > (Fit.PROTOCOL_VERSION_MAJOR shl Fit.PROTOCOL_VERSION_MAJOR_SHIFT)) {
                            headerException = "FIT decode error: Protocol version " + ((data.toInt() and Fit.PROTOCOL_VERSION_MAJOR_MASK) shr Fit.PROTOCOL_VERSION_MAJOR_SHIFT) + "." + (data.toInt() and Fit.PROTOCOL_VERSION_MINOR_MASK) + " not supported.  Must be " + Fit.PROTOCOL_VERSION_MAJOR + "." + Fit.PROTOCOL_VERSION_MINOR + " or earlier."
                        }
                    }
                    4 -> {
                        fileDataSize = (data.toInt() and 0xFF).toLong()
                    }
                    5 -> {
                        fileDataSize = fileDataSize or ((data.toInt() and 0xFF).toLong() shl 8)
                    }
                    6 -> {
                        fileDataSize = fileDataSize or ((data.toInt() and 0xFF).toLong() shl 16)
                    }
                    7 -> {
                        fileDataSize = fileDataSize or ((data.toInt() and 0xFF).toLong() shl 24)
                        // Check file size
                        if ((fileDataSize == 0L) && ((!invalidDataSize) || (!invalidFileDataSize))) {
                            invalidDataSize = true
                            invalidFileDataSize = true
                            headerException = "FIT decode error: File Size is 0. Error at byte: $currentByteOffset"
                        }
                    }
                    8 -> {
                        if (data != '.'.code.toByte()) {
                            headerException = "FIT decode error: File is not FIT format.  Check file header data type. Error at byte: $currentByteOffset"
                        }
                    }
                    9 -> {
                        if (data != 'F'.code.toByte()) {
                            headerException = "FIT decode error: File is not FIT format.  Check file header data type. Error at byte: $currentByteOffset"
                        }
                    }
                    10 -> {
                        if (data != 'I'.code.toByte()) {
                            headerException = "FIT decode error: File is not FIT format.  Check file header data type. Error at byte: $currentByteOffset"
                        }
                    }
                    11 -> {
                        if (data != 'T'.code.toByte()) {
                            headerException = "FIT decode error: File is not FIT format.  Check file header data type. Error at byte: $currentByteOffset"
                        }
                        if ((headerException != null) && (fileHdrSize.toInt() == FIT_HEADER_SIZE_NO_CRC)) {
                            throw FitRuntimeException(headerException!!)
                        }
                    }
                    12 -> {
                        // CRC byte 1
                    }
                    13 -> {
                        // CRC byte 2
                        if (headerException != null) {
                            // Error at current byte, increment index so we do not attempt to decode it again.
                            currentByteIndex++
                            throw FitRuntimeException(headerException!!)
                        }
                    }
                    else -> {
                    }
                }

                if ((fileHdrOffset == fileHdrSize) && (fileHdrSize.toInt() != 0)) {
                    // We don't care about the CRC when the file size is invalid
                    if (invalidDataSize && invalidFileDataSize) {
                        fileBytesLeft = DECODE_DATA_RECORDS_ONLY
                    } else {
                        fileBytesLeft = fileDataSize + 2 // include crc
                    }
                    state = STATE.RECORD
                }
            }

            STATE.RECORD -> {
                fieldIndex = 0
                fieldBytesLeft = 0

                if (fileBytesLeft > 1) {
                    val b = data.toInt()
                    if ((b and Fit.HDR_TIME_REC_BIT) != 0) {
                        val timeOffset = b and Fit.HDR_TIME_OFFSET_MASK

                        localMesgIndex = (b and Fit.HDR_TIME_TYPE_MASK) shr Fit.HDR_TIME_TYPE_SHIFT

                        val localMesgDef = localMesgDefs[localMesgIndex]
                            ?: throw FitRuntimeException("FIT decode error: Missing message definition for local message number $localMesgIndex. Error at byte: $currentByteOffset")

                        val timestampField = Factory.createField(localMesgDef.num, Fit.FIELD_NUM_TIMESTAMP)
                        timestamp += ((timeOffset - lastTimeOffset) and Fit.HDR_TIME_OFFSET_MASK).toLong()
                        lastTimeOffset = timeOffset
                        timestampField.setValue(timestamp)

                        val newMesg = Factory.createMesg(localMesgDef.num)
                        mesg = newMesg
                        newMesg.localNum = localMesgIndex
                        newMesg.systemTimeOffset = systemTimeOffset
                        newMesg.setDecoderMessageIndex(decoderMesgIndex++)
                        newMesg.addField(timestampField)

                        // Determine where to go next
                        if (localMesgDef.fields.size != 0) {
                            // There is native data to parse
                            state = STATE.FIELD_DATA
                        } else if (localMesgDef.getDeveloperFieldTotalSize() > 0) {
                            // There is no native data to parse but there are developer fields
                            state = STATE.DEV_FIELD_DATA
                        } else {
                            // There is no data to parse return the message
                            return RETURN.MESG
                        }
                    } else {
                        localMesgIndex = b and Fit.HDR_TYPE_MASK

                        if ((b and Fit.HDR_TYPE_DEF_BIT) != 0) {
                            val newDef = MesgDefinition()
                            localMesgDefs[localMesgIndex] = newDef
                            newDef.localNum = localMesgIndex
                            hasDevData = false

                            if ((b and Fit.HDR_DEV_FIELDS_BIT) != 0) {
                                // There is Developer Data in this Header
                                hasDevData = true
                            }

                            state = STATE.RESERVED1
                        } else {
                            val localMesgDef = localMesgDefs[localMesgIndex]
                                ?: throw FitRuntimeException("FIT decode error: Missing message definition for local message number $localMesgIndex. Error at byte: $currentByteOffset")

                            val newMesg = Factory.createMesg(localMesgDef.num)
                            mesg = newMesg
                            newMesg.localNum = localMesgIndex
                            newMesg.systemTimeOffset = systemTimeOffset
                            newMesg.setDecoderMessageIndex(decoderMesgIndex++)

                            // Determine where to go next
                            if (localMesgDef.fields.size != 0) {
                                // There is native data to parse
                                state = STATE.FIELD_DATA
                            } else if (localMesgDef.getDeveloperFieldTotalSize() > 0) {
                                // There is no native data to parse but there are developer fields
                                state = STATE.DEV_FIELD_DATA
                            } else {
                                // There is no data to parse return the message
                                return RETURN.MESG
                            }
                        }
                    }
                } else {
                    // We just got the low byte of the crc.
                    state = STATE.FILE_CRC_HIGH
                }
            }

            STATE.RESERVED1 -> {
                state = STATE.ARCH
            }

            STATE.ARCH -> {
                localMesgDefs[localMesgIndex]!!.arch = (data.toInt() and 0xFF)
                state = STATE.MESG_NUM_0
            }

            STATE.MESG_NUM_0 -> {
                // Read the global message number bytes in as if they are in little
                // endian format.
                localMesgDefs[localMesgIndex]!!.num = (data.toInt() and 0xFF)
                state = STATE.MESG_NUM_1
            }

            STATE.MESG_NUM_1 -> {
                val localMesgDef = localMesgDefs[localMesgIndex]!!
                localMesgDef.num = localMesgDef.num or ((data.toInt() and 0xFF) shl 8)

                // We have to check for endianness.
                if (localMesgDef.arch == Fit.ARCH_ENDIAN_BIG) {
                    localMesgDef.num = (localMesgDef.num shr 8) or ((localMesgDef.num and 0xFF) shl 8)
                } else if (localMesgDef.arch != Fit.ARCH_ENDIAN_LITTLE) {
                    throw FitRuntimeException("FIT decode error: Endian " + localMesgDef.arch + " not supported. Error at byte: " + currentByteOffset)
                }

                state = STATE.NUM_FIELDS
            }

            STATE.NUM_FIELDS -> {
                numFields = (data.toInt() and 0xFF)

                if (numFields == 0) {
                    if (hasDevData) {
                        state = STATE.NUM_DEV_FIELDS
                    } else {
                        state = STATE.RECORD
                        return RETURN.MESG_DEF
                    }
                } else {
                    state = STATE.FIELD_NUM
                }
            }

            STATE.FIELD_NUM -> {
                localMesgDefs[localMesgIndex]!!.fields.add(FieldDefinition())
                localMesgDefs[localMesgIndex]!!.fields[fieldIndex].num = (data.toInt() and 0xFF)
                state = STATE.FIELD_SIZE
            }

            STATE.FIELD_SIZE -> {
                localMesgDefs[localMesgIndex]!!.fields[fieldIndex].size = (data.toInt() and 0xFF)
                state = STATE.FIELD_TYPE
            }

            STATE.FIELD_TYPE -> {
                localMesgDefs[localMesgIndex]!!.fields[fieldIndex].type = (data.toInt() and 0xFF)

                fieldIndex++
                if (fieldIndex >= numFields) {
                    if (hasDevData) {
                        state = STATE.NUM_DEV_FIELDS
                    } else {
                        state = STATE.RECORD
                        return RETURN.MESG_DEF
                    }
                } else {
                    state = STATE.FIELD_NUM
                }
            }

            STATE.NUM_DEV_FIELDS -> {
                fieldIndex = 0
                numFields = (data.toInt() and 0xFF)

                if (numFields == 0) {
                    state = STATE.RECORD
                    return RETURN.MESG_DEF
                }

                state = STATE.DEV_FIELD_NUM
            }

            STATE.DEV_FIELD_NUM -> {
                localMesgDefs[localMesgIndex]!!.developerFields.add(DeveloperFieldDefinition())
                localMesgDefs[localMesgIndex]!!.developerFields[fieldIndex].setNum((data.toInt() and 0xFF).toShort())
                state = STATE.DEV_FIELD_SIZE
            }

            STATE.DEV_FIELD_SIZE -> {
                localMesgDefs[localMesgIndex]!!.developerFields[fieldIndex].setSize(data.toInt() and 0xFF)
                state = STATE.DEV_FIELD_DEV_ID
            }

            STATE.DEV_FIELD_DEV_ID -> {
                val fieldDefinition = localMesgDefs[localMesgIndex]!!.developerFields[fieldIndex]
                val castedData = data.toShort()
                if (developerFields.containsKey(castedData)) {
                    // There is a Developer ID Message for this Field
                    fieldDefinition.setDeveloperDataIdMesg(developerDataIds[castedData])

                    if (developerFields[castedData]!!.containsKey(fieldDefinition.getNum())) {
                        // The Developer has Defined this field number
                        val fieldDescription = developerFields[castedData]!![fieldDefinition.getNum()]
                        fieldDefinition.setFieldDescription(fieldDescription)
                    }
                }

                fieldIndex++
                if (fieldIndex >= numFields) {
                    state = STATE.RECORD
                    return RETURN.MESG_DEF
                } else {
                    state = STATE.DEV_FIELD_NUM
                }
            }

            STATE.FIELD_DATA -> {
                var fieldDef = localMesgDefs[localMesgIndex]!!.fields[fieldIndex]

                while (fieldBytesLeft == 0) {
                    fieldDataIndex = 0
                    fieldBytesLeft = fieldDef.size

                    if (fieldBytesLeft == 0) {
                        if ((fieldIndex + 1) >= localMesgDefs[localMesgIndex]!!.fields.size) {
                            break
                        }
                        fieldIndex++
                        fieldDef = localMesgDefs[localMesgIndex]!!.fields[fieldIndex]
                    }
                }

                fieldData[fieldDataIndex++] = data
                fieldBytesLeft--

                if (fieldBytesLeft == 0) {
                    var read = true

                    if ((fieldDef.type and Fit.BASE_TYPE_NUM_MASK) < Fit.BASE_TYPES) { // Ignore field if base type not supported.
                        val typeSize = Fit.baseTypeSizes[(fieldDef.type and Fit.BASE_TYPE_NUM_MASK)]
                        val elements = fieldDef.size / typeSize

                        if (((fieldDef.type and Fit.BASE_TYPE_ENDIAN_FLAG) != 0) &&
                            ((localMesgDefs[localMesgIndex]!!.arch and Fit.ARCH_ENDIAN_MASK) != Fit.ARCH_ENDIAN_BIG)
                        ) {
                            FlipFieldDataByteOrder(typeSize, elements)
                        }

                        var field = Factory.createField(mesg!!.num, fieldDef.num)

                        // For unknown fields the factory will create a field with the type set to 0, i.e. enum
                        // In this situation we should use the type found in the fieldDef instead
                        if (field.getName() == "unknown") {
                            field = Field("unknown", fieldDef.num, fieldDef.type, 1.0, 0.0, "", false, Profile.Type.fromBaseType(fieldDef.type))
                        }

                        if (field.type != fieldDef.type) {
                            val profileSize = Fit.baseTypeSizes[(field.type and Fit.BASE_TYPE_NUM_MASK)]

                            if (typeSize < profileSize) {
                                field.type = fieldDef.type
                            } else if (typeSize != profileSize) {
                                // Demotion is hard. Don't read the field if the
                                // sizes are different. Use the profile type if the
                                // signedness of the field has changed.
                                read = false
                            }
                        }

                        if (read) {
                            field.read(ByteArrayInputStream(fieldData), fieldDef.size)
                        }

                        if (fieldDef.num == Fit.FIELD_NUM_TIMESTAMP) {
                            val fieldTimestamp = field.getLongValue()

                            if (fieldTimestamp != null) {
                                timestamp = fieldTimestamp
                                lastTimeOffset = (timestamp and Fit.HDR_TIME_OFFSET_MASK.toLong()).toInt()
                            }
                        }
                        // Allow messages containing the accumulated field to set the accumulated value
                        if (field.getIsAccumulated()) {
                            for (i in 0 until field.getNumValues()) {
                                var value = (field.getRawValue(i) as Number).toLong()
                                for (containingField in mesg!!.fields) {
                                    for (component in containingField.components) {
                                        if ((component.fieldNum == field.num) && (component.accumulate)) {
                                            value = ((((value / field.scale) - field.offset) + component.offset) * component.scale).toLong()
                                        }
                                    }
                                }
                                accumulator.set(mesg!!.num, field.getNum(), value)
                            }
                        }

                        if (field.getNumValues() > 0) {
                            mesg!!.addField(field)
                        }
                    }

                    fieldIndex++

                    if (fieldIndex >= localMesgDefs[localMesgIndex]!!.fields.size) {
                        // Now that the entire message is decoded we may evaluate subfields and expand components
                        if (!skipExpandComponents) {
                            for (i in 0 until mesg!!.fields.size) {
                                // Determine the active subfield and expand if it has any components
                                val activeSubfield = mesg!!.getActiveSubFieldIndex(mesg!!.fields[i].getNum())

                                if (activeSubfield == Fit.SUBFIELD_INDEX_MAIN_FIELD) {
                                    if (mesg!!.fields[i].components.size > 0) {
                                        // Expand the main field components
                                        expandComponents(mesg!!.fields[i], mesg!!.fields[i].components)
                                    }
                                } else {
                                    if (mesg!!.fields[i].subFields[activeSubfield].components.size > 0) {
                                        // Expand the subfield components
                                        expandComponents(mesg!!.fields[i], mesg!!.fields[i].subFields[activeSubfield].components)
                                    }
                                }
                            }
                        }

                        // Determine where to go next
                        if (localMesgDefs[localMesgIndex]!!.getDeveloperFieldTotalSize() > 0) {
                            // There is developer data we need to read it
                            fieldIndex = 0
                            fieldBytesLeft = 0
                            state = STATE.DEV_FIELD_DATA
                        } else {
                            // There is no data to parse return the message
                            state = STATE.RECORD
                            return RETURN.MESG
                        }
                    }
                }
            }

            STATE.DEV_FIELD_DATA -> {
                val localMesgDef = localMesgDefs[localMesgIndex]!!
                var fieldDef = localMesgDef.developerFields[fieldIndex]

                while (fieldBytesLeft == 0) {
                    fieldDataIndex = 0
                    fieldBytesLeft = fieldDef.getSize()

                    if (fieldBytesLeft == 0) {
                        if ((fieldIndex + 1) >= localMesgDefs[localMesgIndex]!!.developerFields.size) {
                            break
                        }
                        fieldIndex++
                        fieldBytesLeft = localMesgDefs[localMesgIndex]!!.developerFields[fieldIndex].getSize()
                    }
                }

                fieldData[fieldDataIndex++] = data
                fieldBytesLeft--

                if (fieldBytesLeft == 0) {
                    val field = DeveloperField(fieldDef)

                    // Ignore field if type is not supported.
                    if ((fieldDef.getType() and Fit.BASE_TYPE_NUM_MASK) < Fit.BASE_TYPES) {
                        val typeSize = Fit.baseTypeSizes[(fieldDef.getType() and Fit.BASE_TYPE_NUM_MASK)]
                        val elements = fieldDef.getSize() / typeSize

                        if (((fieldDef.getType() and Fit.BASE_TYPE_ENDIAN_FLAG) != 0) &&
                            ((localMesgDef.arch and Fit.ARCH_ENDIAN_MASK) != Fit.ARCH_ENDIAN_BIG)
                        ) {
                            FlipFieldDataByteOrder(typeSize, elements)
                        }

                        field.read(ByteArrayInputStream(fieldData), fieldDef.getSize())

                        if (field.getNumValues() > 0) {
                            mesg!!.addDeveloperField(field)
                        }
                    }

                    fieldIndex++

                    if (fieldIndex >= localMesgDef.developerFields.size) {
                        // Mesg decode complete
                        state = STATE.RECORD
                        return RETURN.MESG
                    }
                }
            }

            else -> {
            }
        }

        return RETURN.CONTINUE
    }

    private fun FlipFieldDataByteOrder(typeSize: Int, elements: Int) {
        // Swap the bytes for each element.
        for (element in 0 until elements) {
            for (i in 0 until (typeSize / 2)) {
                val tmp = fieldData[element * typeSize + i]
                fieldData[element * typeSize + i] = fieldData[element * typeSize + typeSize - i - 1]
                fieldData[element * typeSize + typeSize - i - 1] = tmp
            }
        }
    }

    protected fun expandComponents(containingField: Field, componentList: ArrayList<FieldComponent>) {
        var offset = 0

        for (i in 0 until componentList.size) {
            val component = componentList[i]

            if (component.fieldNum != Fit.FIELD_NUM_INVALID) {
                val componentField = Factory.createField(mesg!!.num, component.fieldNum)
                val subFieldIndex = mesg!!.getActiveSubFieldIndex(component.fieldNum)
                val subField = componentField.getSubField(subFieldIndex)

                // Mark that this field has been generated through expansion
                componentField.setIsExpanded(true)

                // Get raw bits value
                var bitsValue: Long = containingField.getBitsValue(offset, component.bits, componentField.isSignedInteger())
                    ?: break // No more data for components.

                if (component.accumulate) {
                    bitsValue = accumulator.accumulate(mesg!!.num, component.fieldNum, bitsValue, component.bits)
                }

                // If the component field itself has *one* component apply the scale and offset of the componentField's
                // (nested) component
                if (componentField.components.size == 1) {
                    val nestedRawValue: Any

                    if (is64BitType(componentField.getType())) {
                        nestedRawValue = applyScaleOffset64(bitsValue, componentField.getType(), component.scale, component.offset, componentField.components[0].scale, componentField.components[0].offset)
                    } else {
                        nestedRawValue = (((bitsValue / component.scale) - component.offset) + componentField.components[0].offset) * componentField.components[0].scale
                    }

                    if (mesg!!.hasField(componentField.num)) {
                        mesg!!.getField(componentField.num)!!.addRawValue(nestedRawValue)
                    } else {
                        componentField.addRawValue(nestedRawValue)
                        mesg!!.addField(componentField)
                    }
                }
                // The component field is itself a composite field (more than one component).  Don't use scale/offset, containing
                // field data must already be encoded.  Add elements to it until we have added bitsvalue
                else if (componentField.components.size > 1) {
                    var bitsAdded = 0
                    var mask: Long

                    while (bitsAdded < component.bits) {
                        mask = (1L shl Fit.baseTypeSizes[componentField.type and Fit.BASE_TYPE_NUM_MASK]) - 1
                        if (mesg!!.hasField(componentField.num)) {
                            mesg!!.getField(componentField.num)!!.addValue(bitsValue and mask)
                        } else {
                            componentField.addValue(bitsValue and mask)
                            mesg!!.addField(componentField)
                        }
                        bitsValue = bitsValue ushr Fit.baseTypeSizes[componentField.type and Fit.BASE_TYPE_NUM_MASK]
                        bitsAdded += Fit.baseTypeSizes[componentField.type and Fit.BASE_TYPE_NUM_MASK]
                    }
                }
                // componentField is an ordinary field, apply scale and offset as usual
                else {
                    val compOffset = if (subField == null) componentField.offset else subField.offset
                    val compScale = if (subField == null) componentField.scale else subField.scale
                    val rawValue: Any

                    if (is64BitType(componentField.getType())) {
                        rawValue = applyScaleOffset64(bitsValue, componentField.getType(), component.scale, component.offset, compScale, compOffset)
                    } else {
                        rawValue = (((bitsValue / component.scale) - component.offset) + compOffset) * compScale
                    }

                    if (mesg!!.hasField(componentField.num)) {
                        mesg!!.getField(componentField.num)!!.addRawValue(rawValue)
                    } else {
                        componentField.addRawValue(rawValue)
                        mesg!!.addField(componentField)
                    }
                }
            }
            offset += component.bits
        }
    }

    fun getMesg(): Mesg? {
        return mesg
    }

    fun bytesAvailable(input: InputStream): Boolean {
        var bytesAvailable = false
        if ((currentByteIndex > 0) && (currentByteIndex < bytesRead)) {
            bytesAvailable = true
        } else if (input.available() > 0) {
            bytesAvailable = true
        }
        return bytesAvailable
    }

    /**
     * Skips generating fields from component expansion. Default: false
     *
     * @param enable if true component expansion will be skipped; if false component expansion will be performed and expanded fields added to messages.
     */
    fun enableSkipExpandComponents(enable: Boolean) {
        skipExpandComponents = enable
    }

    /**
     * @return true if skip expand components is enabled
     */
    fun isSkipExpandComponentsEnabled(): Boolean {
        return skipExpandComponents
    }
}
