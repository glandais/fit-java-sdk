/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FieldCapabilitiesMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class FieldCapabilitiesMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val FileFieldNum = 0
        const val MesgNumFieldNum = 1
        const val FieldNumFieldNum = 2
        const val CountFieldNum = 3

        val fieldCapabilitiesMesg: Mesg = run {
            // field_capabilities
            val fieldCapabilitiesMesg = Mesg("field_capabilities", MesgNum.FIELD_CAPABILITIES)
            fieldCapabilitiesMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            fieldCapabilitiesMesg.addField(Field("file", FileFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.FILE))
            fieldCapabilitiesMesg.addField(Field("mesg_num", MesgNumFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESG_NUM))
            fieldCapabilitiesMesg.addField(Field("field_num", FieldNumFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            fieldCapabilitiesMesg.addField(Field("count", CountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            fieldCapabilitiesMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.FIELD_CAPABILITIES))

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
     * Get file field
     *
     * @return file
     */
    fun getFile(): File? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return File.fromValue(value)
    }

    /**
     * Set file field
     *
     * @param file The new file value to be set
     */
    fun setFile(file: File?) {
        setFieldValue(0, 0, file?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get mesg_num field
     *
     * @return mesg_num
     */
    fun getMesgNum(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set mesg_num field
     *
     * @param mesgNum The new mesgNum value to be set
     */
    fun setMesgNum(mesgNum: Int?) {
        setFieldValue(1, 0, mesgNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get field_num field
     *
     * @return field_num
     */
    fun getFieldNum(): Short? {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set field_num field
     *
     * @param fieldNum The new fieldNum value to be set
     */
    fun setFieldNum(fieldNum: Short?) {
        setFieldValue(2, 0, fieldNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get count field
     *
     * @return count
     */
    fun getCount(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set count field
     *
     * @param count The new count value to be set
     */
    fun setCount(count: Int?) {
        setFieldValue(3, 0, count, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
