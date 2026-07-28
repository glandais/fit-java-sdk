// Hand-written multiplatform port of FileEncoder.java — keep in sync (see overrides/hashes.json).
// JVM-only: relies on java.io.File / FileOutputStream / RandomAccessFile (qualified to avoid
// collisions with the common IO shims declared in Streams.kt).
package com.garmin.fit

/**
 * Encodes message objects into a FIT binary file.
 */
class FileEncoder : MesgListener, MesgDefinitionListener {
    private var file: java.io.File? = null
    private var out: CheckedFileOutputStream? = null
    private var crc16: CRC16? = null
    private val lastMesgDefinition: Array<MesgDefinition?> = arrayOfNulls(Fit.MAX_LOCAL_MESGS)
    private var version: Fit.ProtocolVersion = Fit.ProtocolVersion.V1_0
    private var validator: ProtocolValidator = ProtocolValidatorFactory.getProtocolValidator(Fit.ProtocolVersion.V1_0)

    constructor()

    /**
     * Constructs a new File Encoder for specified file. Forces
     * ProtocolVersion.V1_0
     *
     * Deprecated: Encoder now supports encoding files of differing protocol
     * versions, use FileEncoder(java.io.File, Fit.ProtocolVersion) to ensure
     * the encoder is validating your files correctly
     *
     * @param file
     *           File to write
     */
    @Deprecated("Use FileEncoder(java.io.File, Fit.ProtocolVersion) instead")
    constructor(file: java.io.File) : this(file, Fit.ProtocolVersion.V1_0)

    /**
     * Constructs a new File Encoder for specified file
     *
     * @param file
     *           File to write
     * @param version
     *           Fit Protocol Version to use when writing files
     */
    constructor(file: java.io.File, version: Fit.ProtocolVersion) {
        this.version = version
        validator = ProtocolValidatorFactory.getProtocolValidator(version)
        open(file)
    }

    /**
     * Opens file for writing. If the file already exists it will be overwritten.
     *
     * @param file
     *           file to write
     */
    fun open(file: java.io.File) {

        file.delete()
        crc16 = CRC16()
        this.file = file

        writeFileHeader()
        try {
            // Open output stream to write messages.
            out = CheckedFileOutputStream(java.io.FileOutputStream(this.file, true), crc16!!)
        } catch (e: java.io.IOException) {
            throw FitRuntimeException(e)
        }
    }

    /**
     * Writes the file header.
     */
    private fun writeFileHeader() {
        val file = this.file ?: throw FitRuntimeException("File not open.")

        try {
            val crc = CRC16()
            val raf = java.io.RandomAccessFile(file, "rw")
            var dataSize = file.length() - Fit.FILE_HDR_SIZE
            val crcValue: Long

            if (dataSize < 0) {
                dataSize = 0
            }

            val header = byteArrayOf(
                Fit.FILE_HDR_SIZE.toByte(),
                version.getVersion().toByte(),
                (Fit.PROFILE_VERSION and 0xFF).toByte(),
                (Fit.PROFILE_VERSION shr 8).toByte(),
                (dataSize and 0xFF).toByte(),
                ((dataSize shr 8) and 0xFF).toByte(),
                ((dataSize shr 16) and 0xFF).toByte(),
                ((dataSize shr 24) and 0xFF).toByte(),
                '.'.code.toByte(),
                'F'.code.toByte(),
                'I'.code.toByte(),
                'T'.code.toByte()
            )

            raf.write(header)
            crc.update(header, 0, header.size)
            crcValue = crc.getValue()

            raf.write((crcValue and 0xFF).toInt())
            raf.write(((crcValue shr 8) and 0xFF).toInt())
            raf.close()
        } catch (e: java.io.IOException) {
            throw FitRuntimeException(e)
        }
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
     * Writes a message definition to the file.
     *
     * @param mesgDefinition
     *           message definition object to write
     */
    fun write(mesgDefinition: MesgDefinition) {
        if (file == null) {
            throw FitRuntimeException("File not open.")
        }

        if (!validator.validateMesgDefn(mesgDefinition)) {
            throw FitRuntimeException("Incompatible Protocol Features")
        }

        mesgDefinition.write(out!!)
        lastMesgDefinition[mesgDefinition.localNum] = mesgDefinition
    }

    /**
     * Writes a message to the file.
     * Automatically writes message definition if required.
     *
     * @param mesg
     *           message object to write
     */
    fun write(mesg: Mesg) {
        if (file == null) {
            throw FitRuntimeException("File not open.")
        }

        if (!validator.validateMesg(mesg)) {
            throw FitRuntimeException("Incompatible Protocol Features")
        }

        val lastDefinition = lastMesgDefinition[mesg.localNum]
        if ((lastDefinition == null) || !lastDefinition.supports(mesg)) {
            write(MesgDefinition(mesg))
        }

        mesg.write(out!!, lastMesgDefinition[mesg.localNum])
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
     * Updates the data size in the file header, writes the CRC, and closes the file.
     */
    fun close() {
        if (file == null) {
            throw FitRuntimeException("File not open.")
        }

        try {
            // Set the data size in the file header.
            writeFileHeader()

            // Write the CRC.
            val crc = out!!.getChecksum().getValue()
            out!!.write((crc and 0xFF).toInt())
            out!!.write(((crc shr 8) and 0xFF).toInt())

            out!!.close()
            file = null
        } catch (e: java.io.IOException) {
            throw FitRuntimeException(e)
        }
    }

    /**
     * Replacement for java.util.zip.CheckedOutputStream: it must be a
     * com.garmin.fit.OutputStream (the common shim) so that Mesg.write() and
     * MesgDefinition.write() accept it, while writing through to a java.io stream
     * and updating a CRC16 checksum.
     */
    private class CheckedFileOutputStream(
        private val out: java.io.OutputStream,
        private val checksum: CRC16
    ) : OutputStream() {

        fun getChecksum(): CRC16 = checksum

        override fun write(b: Int) {
            out.write(b)
            checksum.update(b)
        }

        override fun write(b: ByteArray, off: Int, len: Int) {
            out.write(b, off, len)
            checksum.update(b, off, len)
        }

        override fun flush() {
            out.flush()
        }

        override fun close() {
            out.close()
        }
    }
}
