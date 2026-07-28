// Hand-written multiplatform port of BufferEncoder.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

/**
 * Encodes message objects into a FIT binary file buffer.
 */
class BufferEncoder(
    private val version: Fit.ProtocolVersion,
    private val maxStreamSize: Int
) : MesgListener, MesgDefinitionListener {

    private val byteOutStream: ByteArrayOutputStream = ByteArrayOutputStream()
    private val dataOutStream: DataOutputStream = DataOutputStream(byteOutStream)
    private val lastMesgDefinition: Array<MesgDefinition?> = arrayOfNulls(Fit.MAX_LOCAL_MESGS)
    private val validator: ProtocolValidator = ProtocolValidatorFactory.getProtocolValidator(version)

    /**
     * Constructs a new BufferEncoder. Forces
     * ProtocolVersion.V1_0
     *
     * Deprecated: Encoder now supports encoding files of differing protocol
     * versions, use BufferEncoder(Fit.ProtocolVersion) to ensure
     * the encoder is validating your files correctly
     */
    @Deprecated("Use BufferEncoder(Fit.ProtocolVersion) instead")
    constructor() : this(Fit.ProtocolVersion.V1_0)

    /**
     * Constructs a new File Encoder for specified file.
     *
     * @param version
     *           Fit Protocol Version to use when writing files
     */
    constructor(version: Fit.ProtocolVersion) : this(version, Int.MAX_VALUE)

    init {
        open()
    }

    /**
     * Resets the output stream and writes the file header.
     */
    fun open() {
        byteOutStream.reset()
        writeFileHeader()
    }

    /**
     * Writes the file header.
     */
    private fun writeFileHeader() {
        byteOutStream.write(Fit.FILE_HDR_SIZE)
        byteOutStream.write(version.getVersion())
        byteOutStream.write(Fit.PROFILE_VERSION and 0xFF)
        byteOutStream.write(Fit.PROFILE_VERSION shr 8)
        byteOutStream.write(0) // Data size.
        byteOutStream.write(0)
        byteOutStream.write(0)
        byteOutStream.write(0)
        byteOutStream.write('.'.code)
        byteOutStream.write('F'.code)
        byteOutStream.write('I'.code)
        byteOutStream.write('T'.code)
        byteOutStream.write(0) // File header CRC.
        byteOutStream.write(0)
    }

    /**
     * MesgListener interface.
     */
    override fun onMesg(mesg: Mesg) {
        write(mesg)
    }

    /**
     * MesgDefinitionListener interface.
     */
    override fun onMesgDefinition(mesgDefinition: MesgDefinition) {
        write(mesgDefinition)
    }

    /**
     * Writes a message definition to the buffer.
     *
     * @param mesgDefinition
     *           message definition object to write
     */
    fun write(mesgDefinition: MesgDefinition) {
        if (!validator.validateMesgDefn(mesgDefinition)) {
            throw FitRuntimeException("Incompatible Protocol Features")
        }

        mesgDefinition.write(dataOutStream)

        validateStreamSize()

        lastMesgDefinition[mesgDefinition.localNum] = mesgDefinition
    }

    /**
     * Writes a message to the buffer.
     * Automatically writes message definition if required.
     *
     * @param mesg
     *           message object to write
     */
    fun write(mesg: Mesg) {
        if (!validator.validateMesg(mesg)) {
            throw FitRuntimeException("Incompatible Protocol Features")
        }

        val lastDefinition = lastMesgDefinition[mesg.localNum]
        if ((lastDefinition == null) || !lastDefinition.supports(mesg)) {
            write(MesgDefinition(mesg))
        }

        mesg.write(dataOutStream, lastMesgDefinition[mesg.localNum])

        validateStreamSize()
    }

    /**
     * Writes a list of messages to the file.
     *
     * @param mesgs
     *           list message objects to write
     */
    fun write(mesgs: List<Mesg>) {
        for (mesg in mesgs) {
            write(mesg)
        }
    }

    /**
     * Updates the data size in the file header, writes the CRC, and returns the buffer.
     * The output stream buffer is discarded and re-initialized to start encoding a new file.
     *
     * @return file buffer
     */
    fun close(): ByteArray {

        // Write two dummy bytes as place holder for the CRC.
        byteOutStream.write(0)
        byteOutStream.write(0)

        // Get the buffer of the file.
        val buffer = byteOutStream.toByteArray()
        val dataSize = (buffer.size - Fit.FILE_HDR_SIZE - 2).toLong()

        // Set the data size in the file header.
        buffer[4] = (dataSize and 0xFF).toByte()
        buffer[5] = ((dataSize shr 8) and 0xFF).toByte()
        buffer[6] = ((dataSize shr 16) and 0xFF).toByte()
        buffer[7] = ((dataSize shr 24) and 0xFF).toByte()

        // Compute the CRC of the file header.
        var crc = 0
        for (i in 0 until (Fit.FILE_HDR_SIZE - 2)) {
            crc = CRC.get16(crc, buffer[i])
        }

        // Set the file header CRC in the file buffer.
        buffer[Fit.FILE_HDR_SIZE - 2] = (crc and 0xFF).toByte()
        buffer[Fit.FILE_HDR_SIZE - 1] = ((crc shr 8) and 0xFF).toByte()

        // Compute the CRC of the file.
        crc = 0
        for (i in 0 until (buffer.size - 2)) {
            crc = CRC.get16(crc, buffer[i])
        }

        // Set the file CRC in the file buffer.
        buffer[buffer.size - 2] = (crc and 0xFF).toByte()
        buffer[buffer.size - 1] = ((crc shr 8) and 0xFF).toByte()

        // Discard the output stream and re-initialize.
        open()

        return buffer
    }

    fun size(): Int {
        return dataOutStream.size()
    }

    private fun validateStreamSize() {
        if (size() > maxStreamSize) {
            throw FitRuntimeException("Number of bytes: " + size() + " written to BufferEncoder exceeds maximum limit")
        }
    }
}
