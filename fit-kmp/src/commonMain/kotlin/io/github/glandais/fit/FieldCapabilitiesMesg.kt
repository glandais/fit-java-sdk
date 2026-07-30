/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FieldCapabilitiesMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get file field
     *
     * @return file
     */
    var file: File?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return File.fromValue(value)
        }
        set(file) {
            setFieldValue(0, 0, file?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get mesg_num field
     *
     * @return mesg_num
     */
    var mesgNum: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(mesgNum) {
            setFieldValue(1, 0, mesgNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get field_num field
     *
     * @return field_num
     */
    var fieldNum: Short?
        get() {
            return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fieldNum) {
            setFieldValue(2, 0, fieldNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get count field
     *
     * @return count
     */
    var count: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(count) {
            setFieldValue(3, 0, count, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
