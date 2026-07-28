/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FileCapabilitiesMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class FileCapabilitiesMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val TypeFieldNum = 0
        const val FlagsFieldNum = 1
        const val DirectoryFieldNum = 2
        const val MaxCountFieldNum = 3
        const val MaxSizeFieldNum = 4

        val fileCapabilitiesMesg: Mesg = run {
            // file_capabilities
            val fileCapabilitiesMesg = Mesg("file_capabilities", MesgNum.FILE_CAPABILITIES)
            fileCapabilitiesMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            fileCapabilitiesMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.FILE))
            fileCapabilitiesMesg.addField(Field("flags", FlagsFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.FILE_FLAGS))
            fileCapabilitiesMesg.addField(Field("directory", DirectoryFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            fileCapabilitiesMesg.addField(Field("max_count", MaxCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            fileCapabilitiesMesg.addField(Field("max_size", MaxSizeFieldNum, 134, 1.0, 0.0, "bytes", false, Profile.Type.UINT32))
            fileCapabilitiesMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.FILE_CAPABILITIES))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     *
     * @return message_index
     */
    fun getMessageIndex(): Int? {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_index field
     *
     * @param messageIndex The new messageIndex value to be set
     */
    fun setMessageIndex(messageIndex: Int?) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get type field
     *
     * @return type
     */
    fun getType(): File? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return File.fromValue(value)
    }

    /**
     * Set type field
     *
     * @param type The new type value to be set
     */
    fun setType(type: File?) {
        setFieldValue(0, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get flags field
     *
     * @return flags
     */
    fun getFlags(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set flags field
     *
     * @param flags The new flags value to be set
     */
    fun setFlags(flags: Short?) {
        setFieldValue(1, 0, flags, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get directory field
     *
     * @return directory
     */
    fun getDirectory(): String? {
        return getFieldStringValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set directory field
     *
     * @param directory The new directory value to be set
     */
    fun setDirectory(directory: String?) {
        setFieldValue(2, 0, directory, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_count field
     *
     * @return max_count
     */
    fun getMaxCount(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_count field
     *
     * @param maxCount The new maxCount value to be set
     */
    fun setMaxCount(maxCount: Int?) {
        setFieldValue(3, 0, maxCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_size field
     * Units: bytes
     *
     * @return max_size
     */
    fun getMaxSize(): Long? {
        return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_size field
     * Units: bytes
     *
     * @param maxSize The new maxSize value to be set
     */
    fun setMaxSize(maxSize: Long?) {
        setFieldValue(4, 0, maxSize, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
