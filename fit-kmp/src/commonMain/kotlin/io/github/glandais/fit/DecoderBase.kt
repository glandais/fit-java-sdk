// Hand-written multiplatform port of DecoderBase.java — keep in sync (see overrides/hashes.json).
// Java visibility note: DecoderBase is package-private in Java; it is public here because the
// public class Decoder extends it (Kotlin forbids a public class exposing an internal supertype).
package io.github.glandais.fit

import kotlin.math.floor

abstract class DecoderBase : MesgSource {

    protected val CompressedHeaderMask: Int = Fit.HDR_TIME_REC_BIT
    protected val MesgDefinitionMask: Int = Fit.HDR_TYPE_DEF_BIT
    protected val DevDataMask: Int = Fit.HDR_DEV_FIELDS_BIT
    protected val MesgHeaderMask: Int = 0x00
    protected val LocalMesgNumMask: Int = Fit.HDR_TYPE_MASK
    protected val localMesgDefs: Array<MesgDefinition?> = arrayOfNulls(Fit.MAX_LOCAL_MESGS)
    protected val fieldData: ByteArray = ByteArray(Fit.MAX_FIELD_SIZE)
    protected val mesgListeners: ArrayList<MesgListener> = ArrayList()
    internal val accumulator: Accumulator = Accumulator()
    protected var stream: ByteArrayDataInputStream? = null
    protected var mesgDefListeners: ArrayList<MesgDefinitionListener> = ArrayList()
    protected var devFieldDescListeners: ArrayList<DeveloperFieldDescriptionListener> = ArrayList()
    private var crc: CRC16? = null
    protected var decoderMesgIndex: Int = 0
    protected var skipExpandComponents: Boolean = false

    protected constructor()

    protected constructor(bytes: ByteArray) {
        stream = ByteArrayDataInputStream(bytes)
    }

    companion object {
        /**
         * Reads the FIT file header from the input stream and checks that the input
         * is a valid .FIT file. The position of the input stream is not changed.
         *
         * @param stream representing the FIT file to be checked
         * @return true if the input is a FIT file, false if it is not
         */
        fun isFIT(stream: ByteArrayInputStream): Boolean {
            try {
                stream.mark(0)

                val fileHeader = readHeader(stream)
                val dotFIT = fileHeader.copyOfRange(8, 12).decodeToString()

                return dotFIT == ".FIT"
            } catch (e: Exception) {
                return false
            } finally {
                stream.reset()
            }
        }

        /**
         * Reads the FIT file header from the input stream and checks that the input
         * is a valid .FIT file. The position of the input stream is not changed.
         *
         * @param bytes representing the FIT file to be checked
         * @return true if the input is a FIT file, false if it is not
         */
        fun isFIT(bytes: ByteArray): Boolean {
            val stream = ByteArrayInputStream(bytes)
            return isFIT(stream)
        }

        /**
         * Reads the FIT file header from the input stream and checks that the input
         * is a valid .FIT file and checks the integrity file.
         *
         * @param stream representing the FIT file to be checked
         * @return true if the integrity of the FIT file is good, false if it is not
         */
        private fun checkIntegrity(stream: ByteArrayDataInputStream): Boolean {
            try {
                while (stream.available() > 0) {
                    if (!isFIT(stream)) {
                        throw Exception()
                    }

                    stream.mark(0)

                    val fileHeader = readHeader(stream)
                    stream.reset()

                    val headerSize = fileHeader[0].toInt()
                    val dataSize = fileHeader.getInt32(4, false) // little endian

                    if (stream.available() < headerSize + dataSize + Fit.CRC_SIZE) {
                        throw Exception()
                    }

                    val crc = CRC16()

                    val data = ByteArray(headerSize + dataSize)
                    stream.read(data, 0, headerSize + dataSize)
                    crc.update(data, 0, data.size)

                    val fileCrc = stream.readUShort()
                    if (fileCrc.toLong() != crc.getValue()) {
                        throw Exception()
                    }
                }
                return true
            } catch (e: Exception) {
                return false
            } finally {
                stream.reset()
            }
        }

        /**
         * Reads the FIT file header from the input stream and checks that the input
         * is a valid .FIT file and checks the integrity file.
         *
         * @param bytes representing the FIT file to be checked
         * @return true if the integrity of the FIT file is good, false if it is not
         */
        fun checkIntegrity(bytes: ByteArray): Boolean {
            val stream = ByteArrayDataInputStream(bytes)
            return checkIntegrity(stream)
        }

        /**
         * Reads the FIT file header from the input stream and returns the byte array containing the header.
         *
         * @param stream representing the FIT file to read the header from
         * @return a byte array containing the bytes of the header
         * @throws FitRuntimeException if the file header is invalid
         */
        protected fun readHeader(stream: InputStream): ByteArray {
            val fileHeader = ByteArray(14)

            fileHeader[0] = stream.read().toByte()
            val headerSize = fileHeader[0]

            if (headerSize.toInt() != 12 && headerSize.toInt() != 14) {
                throw FitRuntimeException("Invalid Header Size")
            }

            val bytesRead = stream.read(fileHeader, 1, headerSize - 1)

            if (bytesRead != headerSize - 1) {
                throw FitRuntimeException("Invalid Header - File Size less than Header Size")
            }

            return fileHeader
        }

        protected fun is64BitType(type: Int): Boolean {
            return type == Fit.BASE_TYPE_SINT64 || type == Fit.BASE_TYPE_UINT64 || type == Fit.BASE_TYPE_UINT64Z
        }

        // Rewritten without BigDecimal/BigInteger (DESIGN.md §1.4): the unsigned 64-bit path
        // uses ULong, all scaling is done in Double. Theoretical precision loss beyond 2^53
        // is accepted and documented here. Rounding matches Java's RoundingMode.HALF_UP
        // (half away from zero).
        protected fun applyScaleOffset64(
            bitsValue: Long, fieldType: Int,
            componentScale: Double, componentOffset: Double,
            fieldScale: Double, fieldOffset: Double
        ): Any {
            // Recover the true unsigned value when getBitsValue has sign-extended a bit-pattern >= 2^63.
            val isUnsigned = (fieldType == Fit.BASE_TYPE_UINT64 || fieldType == Fit.BASE_TYPE_UINT64Z)

            val d: Double = if (isUnsigned) bitsValue.toULong().toDouble() else bitsValue.toDouble()

            val result = (((d / componentScale) - componentOffset) + fieldOffset) * fieldScale
            val rounded = roundHalfUp(result)

            return if (isUnsigned) rounded.toULong() else rounded.toLong()
        }

        private fun roundHalfUp(value: Double): Double {
            return if (value < 0) -floor(-value + 0.5) else floor(value + 0.5)
        }
    }

    protected fun readHeader(): ByteArray {
        val fileHeader = readHeader(stream!!)
        val headerSize = fileHeader[0]

        crc!!.update(fileHeader, 0, headerSize.toInt())

        return fileHeader
    }

    fun readByte(): Int {
        val value = stream!!.read()
        crc!!.update(value)

        return value
    }

    fun readUShort(): Int {
        val value = stream!!.readUShort()
        crc!!.update(value and 0xFF)
        crc!!.update((value shr 8) and 0xFF)

        return value
    }

    fun readBytes(bytes: ByteArray, off: Int, len: Int): Int {
        val bytesRead = stream!!.read(bytes, off, len)

        crc!!.update(bytes, off, len)

        return bytesRead
    }

    protected fun getCrcValue(): Long {
        return crc!!.getValue()
    }

    protected fun resetCrc() {
        crc = CRC16()
    }

    /**
     * Add a MesgListener observer
     *
     * @param mesgListener to add as an observer
     */
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

    protected fun expandComponents(mesg: Mesg, containingField: Field, componentList: ArrayList<FieldComponent>) {
        var offset = 0

        for (i in 0 until componentList.size) {
            val component = componentList[i]

            if (component.fieldNum != Fit.FIELD_NUM_INVALID) {
                val componentField = Factory.createField(mesg.num, component.fieldNum)
                val subFieldIndex = mesg.getActiveSubFieldIndex(component.fieldNum)
                val subField = componentField.getSubField(subFieldIndex)

                // Mark that this field has been generated through expansion
                componentField.setIsExpanded(true)

                // Get raw bits value
                var bitsValue: Long = containingField.getBitsValue(offset, component.bits, componentField.isSignedInteger())
                    ?: break // No more data for components.

                if (component.accumulate) {
                    bitsValue = accumulator.accumulate(mesg.num, component.fieldNum, bitsValue, component.bits)
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

                    if (mesg.hasField(componentField.num)) {
                        mesg.getField(componentField.num)!!.addRawValue(nestedRawValue)
                    } else {
                        componentField.addRawValue(nestedRawValue)
                        mesg.addField(componentField)
                    }
                }
                // The component field is itself a composite field (more than one component).  Don't use scale/offset, containing
                // field data must already be encoded.  Add elements to it until we have added bitsvalue
                else if (componentField.components.size > 1) {
                    var bitsAdded = 0
                    var mask: Long

                    while (bitsAdded < component.bits) {
                        mask = (1L shl Fit.baseTypeSizes[componentField.type and Fit.BASE_TYPE_NUM_MASK]) - 1
                        if (mesg.hasField(componentField.num)) {
                            mesg.getField(componentField.num)!!.addValue(bitsValue and mask)
                        } else {
                            componentField.addValue(bitsValue and mask)
                            mesg.addField(componentField)
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

                    if (mesg.hasField(componentField.num)) {
                        mesg.getField(componentField.num)!!.addRawValue(rawValue)
                    } else {
                        componentField.addRawValue(rawValue)
                        mesg.addField(componentField)
                    }
                }
            }
            offset += component.bits
        }
    }

    protected fun decodeCompressedTimestampDataMessage() {
        val recordHeader = stream!!.read()
        throw FitRuntimeException("Compressed timestamp messages are not currently supported.")
    }

    protected fun flipFieldDataByteOrder(typeSize: Int, elements: Int) {
        // Swap the bytes for each element.
        for (element in 0 until elements) {
            for (i in 0 until (typeSize / 2)) {
                val tmp = fieldData[element * typeSize + i]
                fieldData[element * typeSize + i] = fieldData[element * typeSize + typeSize - i - 1]
                fieldData[element * typeSize + typeSize - i - 1] = tmp
            }
        }
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
