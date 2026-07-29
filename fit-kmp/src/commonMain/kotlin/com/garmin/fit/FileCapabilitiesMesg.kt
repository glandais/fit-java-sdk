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
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get type field
     *
     * @return type
     */
    var type: File?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return File.fromValue(value)
        }
        set(type) {
            setFieldValue(0, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get flags field
     *
     * @return flags
     */
    var flags: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(flags) {
            setFieldValue(1, 0, flags, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get directory field
     *
     * @return directory
     */
    var directory: String?
        get() {
            return getFieldStringValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(directory) {
            setFieldValue(2, 0, directory, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_count field
     *
     * @return max_count
     */
    var maxCount: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxCount) {
            setFieldValue(3, 0, maxCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_size field
     * Units: bytes
     *
     * @return max_size
     */
    var maxSize: Long?
        get() {
            return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxSize) {
            setFieldValue(4, 0, maxSize, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
