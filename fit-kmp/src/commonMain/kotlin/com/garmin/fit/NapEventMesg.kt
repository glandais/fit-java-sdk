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
     * Get timestamp field
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_time field
     * Units: seconds
     *
     * @return start_time
     */
    fun getStartTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set start_time field
     * Units: seconds
     *
     * @param startTime The new startTime value to be set
     */
    fun setStartTime(startTime: DateTime?) {
        setFieldValue(0, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_timezone_offset field
     * Units: minutes
     *
     * @return start_timezone_offset
     */
    fun getStartTimezoneOffset(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_timezone_offset field
     * Units: minutes
     *
     * @param startTimezoneOffset The new startTimezoneOffset value to be set
     */
    fun setStartTimezoneOffset(startTimezoneOffset: Short?) {
        setFieldValue(1, 0, startTimezoneOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_time field
     * Units: seconds
     *
     * @return end_time
     */
    fun getEndTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set end_time field
     * Units: seconds
     *
     * @param endTime The new endTime value to be set
     */
    fun setEndTime(endTime: DateTime?) {
        setFieldValue(2, 0, endTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_timezone_offset field
     * Units: minutes
     *
     * @return end_timezone_offset
     */
    fun getEndTimezoneOffset(): Short? {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_timezone_offset field
     * Units: minutes
     *
     * @param endTimezoneOffset The new endTimezoneOffset value to be set
     */
    fun setEndTimezoneOffset(endTimezoneOffset: Short?) {
        setFieldValue(3, 0, endTimezoneOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get feedback field
     *
     * @return feedback
     */
    fun getFeedback(): NapPeriodFeedback? {
        val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return NapPeriodFeedback.fromValue(value)
    }

    /**
     * Set feedback field
     *
     * @param feedback The new feedback value to be set
     */
    fun setFeedback(feedback: NapPeriodFeedback?) {
        setFieldValue(4, 0, feedback?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get is_deleted field
     *
     * @return is_deleted
     */
    fun getIsDeleted(): Bool? {
        val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set is_deleted field
     *
     * @param isDeleted The new isDeleted value to be set
     */
    fun setIsDeleted(isDeleted: Bool?) {
        setFieldValue(5, 0, isDeleted?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get source field
     *
     * @return source
     */
    fun getSource(): NapSource? {
        val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return NapSource.fromValue(value)
    }

    /**
     * Set source field
     *
     * @param source The new source value to be set
     */
    fun setSource(source: NapSource?) {
        setFieldValue(6, 0, source?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get update_timestamp field
     * Comment: The timestamp representing when this nap event was last updated
     *
     * @return update_timestamp
     */
    fun getUpdateTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set update_timestamp field
     * Comment: The timestamp representing when this nap event was last updated
     *
     * @param updateTimestamp The new updateTimestamp value to be set
     */
    fun setUpdateTimestamp(updateTimestamp: DateTime?) {
        setFieldValue(7, 0, updateTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
