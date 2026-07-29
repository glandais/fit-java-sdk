/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MesgCapabilitiesMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class MesgCapabilitiesMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val FileFieldNum = 0
        const val MesgNumFieldNum = 1
        const val CountTypeFieldNum = 2
        const val CountFieldNum = 3

        val mesgCapabilitiesMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // mesg_capabilities
            val mesgCapabilitiesMesg = Mesg("mesg_capabilities", MesgNum.MESG_CAPABILITIES)
            mesgCapabilitiesMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            mesgCapabilitiesMesg.addField(Field("file", FileFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.FILE))
            field_index++
            mesgCapabilitiesMesg.addField(Field("mesg_num", MesgNumFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESG_NUM))
            field_index++
            mesgCapabilitiesMesg.addField(Field("count_type", CountTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.MESG_COUNT))
            field_index++
            mesgCapabilitiesMesg.addField(Field("count", CountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            subfield_index = 0
            mesgCapabilitiesMesg.fields[field_index].subFields.add(SubField("num_per_file", 132, 1.0, 0.0, ""))
            mesgCapabilitiesMesg.fields[field_index].subFields[subfield_index].addMap(2, 0L)
            subfield_index++
            mesgCapabilitiesMesg.fields[field_index].subFields.add(SubField("max_per_file", 132, 1.0, 0.0, ""))
            mesgCapabilitiesMesg.fields[field_index].subFields[subfield_index].addMap(2, 1L)
            subfield_index++
            mesgCapabilitiesMesg.fields[field_index].subFields.add(SubField("max_per_file_type", 132, 1.0, 0.0, ""))
            mesgCapabilitiesMesg.fields[field_index].subFields[subfield_index].addMap(2, 2L)
            subfield_index++
            field_index++
            mesgCapabilitiesMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.MESG_CAPABILITIES))

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
     * Get count_type field
     *
     * @return count_type
     */
    var countType: MesgCount?
        get() {
            val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return MesgCount.fromValue(value)
        }
        set(countType) {
            setFieldValue(2, 0, countType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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

    /**
     * Get num_per_file field
     *
     * @return num_per_file
     */
    var numPerFile: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.MESG_CAPABILITIES_MESG_COUNT_FIELD_NUM_PER_FILE)
        }
        set(numPerFile) {
            setFieldValue(3, 0, numPerFile, Profile.SubFields.MESG_CAPABILITIES_MESG_COUNT_FIELD_NUM_PER_FILE)
        }

    /**
     * Get max_per_file field
     *
     * @return max_per_file
     */
    var maxPerFile: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.MESG_CAPABILITIES_MESG_COUNT_FIELD_MAX_PER_FILE)
        }
        set(maxPerFile) {
            setFieldValue(3, 0, maxPerFile, Profile.SubFields.MESG_CAPABILITIES_MESG_COUNT_FIELD_MAX_PER_FILE)
        }

    /**
     * Get max_per_file_type field
     *
     * @return max_per_file_type
     */
    var maxPerFileType: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.MESG_CAPABILITIES_MESG_COUNT_FIELD_MAX_PER_FILE_TYPE)
        }
        set(maxPerFileType) {
            setFieldValue(3, 0, maxPerFileType, Profile.SubFields.MESG_CAPABILITIES_MESG_COUNT_FIELD_MAX_PER_FILE_TYPE)
        }
}
