/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from NapEventMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class NapEventMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val TimestampFieldNum = 253
        const val StartTimeFieldNum = 0
        const val StartTimezoneOffsetFieldNum = 1
        const val EndTimeFieldNum = 2
        const val EndTimezoneOffsetFieldNum = 3
        const val FeedbackFieldNum = 4
        const val IsDeletedFieldNum = 5
        const val SourceFieldNum = 6
        const val UpdateTimestampFieldNum = 7

        val napEventMesg: Mesg = run {
            // nap_event
            val napEventMesg = Mesg("nap_event", MesgNum.NAP_EVENT)
            napEventMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            napEventMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            napEventMesg.addField(Field("start_time", StartTimeFieldNum, 134, 1.0, 0.0, "seconds", false, Profile.Type.DATE_TIME))
            napEventMesg.addField(Field("start_timezone_offset", StartTimezoneOffsetFieldNum, 131, 1.0, 0.0, "minutes", false, Profile.Type.SINT16))
            napEventMesg.addField(Field("end_time", EndTimeFieldNum, 134, 1.0, 0.0, "seconds", false, Profile.Type.DATE_TIME))
            napEventMesg.addField(Field("end_timezone_offset", EndTimezoneOffsetFieldNum, 131, 1.0, 0.0, "minutes", false, Profile.Type.SINT16))
            napEventMesg.addField(Field("feedback", FeedbackFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.NAP_PERIOD_FEEDBACK))
            napEventMesg.addField(Field("is_deleted", IsDeletedFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            napEventMesg.addField(Field("source", SourceFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.NAP_SOURCE))
            napEventMesg.addField(Field("update_timestamp", UpdateTimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            napEventMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.NAP_EVENT))

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
     * Get timestamp field
     *
     * @return timestamp
     */
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_time field
     * Units: seconds
     *
     * @return start_time
     */
    var startTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(startTime) {
            setFieldValue(0, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_timezone_offset field
     * Units: minutes
     *
     * @return start_timezone_offset
     */
    var startTimezoneOffset: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startTimezoneOffset) {
            setFieldValue(1, 0, startTimezoneOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_time field
     * Units: seconds
     *
     * @return end_time
     */
    var endTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(endTime) {
            setFieldValue(2, 0, endTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_timezone_offset field
     * Units: minutes
     *
     * @return end_timezone_offset
     */
    var endTimezoneOffset: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(endTimezoneOffset) {
            setFieldValue(3, 0, endTimezoneOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get feedback field
     *
     * @return feedback
     */
    var feedback: NapPeriodFeedback?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return NapPeriodFeedback.fromValue(value)
        }
        set(feedback) {
            setFieldValue(4, 0, feedback?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get is_deleted field
     *
     * @return is_deleted
     */
    var isDeleted: Bool?
        get() {
            val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(isDeleted) {
            setFieldValue(5, 0, isDeleted?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get source field
     *
     * @return source
     */
    var source: NapSource?
        get() {
            val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return NapSource.fromValue(value)
        }
        set(source) {
            setFieldValue(6, 0, source?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get update_timestamp field
     * Comment: The timestamp representing when this nap event was last updated
     *
     * @return update_timestamp
     */
    var updateTimestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(updateTimestamp) {
            setFieldValue(7, 0, updateTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
