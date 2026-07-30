/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ActivityMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class ActivityMesg : Mesg, MesgWithEvent {

    companion object {
        const val TimestampFieldNum = 253
        const val TotalTimerTimeFieldNum = 0
        const val NumSessionsFieldNum = 1
        const val TypeFieldNum = 2
        const val EventFieldNum = 3
        const val EventTypeFieldNum = 4
        const val LocalTimestampFieldNum = 5
        const val EventGroupFieldNum = 6

        val activityMesg: Mesg = run {
            // activity
            val activityMesg = Mesg("activity", MesgNum.ACTIVITY)
            activityMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            activityMesg.addField(Field("total_timer_time", TotalTimerTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            activityMesg.addField(Field("num_sessions", NumSessionsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            activityMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ACTIVITY))
            activityMesg.addField(Field("event", EventFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT))
            activityMesg.addField(Field("event_type", EventTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT_TYPE))
            activityMesg.addField(Field("local_timestamp", LocalTimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.LOCAL_DATE_TIME))
            activityMesg.addField(Field("event_group", EventGroupFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            activityMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.ACTIVITY))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    override var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_timer_time field
     * Units: s
     * Comment: Exclude pauses
     *
     * @return total_timer_time
     */
    var totalTimerTime: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalTimerTime) {
            setFieldValue(0, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get num_sessions field
     *
     * @return num_sessions
     */
    var numSessions: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(numSessions) {
            setFieldValue(1, 0, numSessions, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get type field
     *
     * @return type
     */
    var type: Activity?
        get() {
            val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Activity.fromValue(value)
        }
        set(type) {
            setFieldValue(2, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event field
     *
     * @return event
     */
    override var event: Event?
        get() {
            val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Event.fromValue(value)
        }
        set(event) {
            setFieldValue(3, 0, event?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event_type field
     *
     * @return event_type
     */
    override var eventType: EventType?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return EventType.fromValue(value)
        }
        set(eventType) {
            setFieldValue(4, 0, eventType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get local_timestamp field
     * Comment: timestamp epoch expressed in local time, used to convert activity timestamps to local time
     *
     * @return local_timestamp
     */
    var localTimestamp: Long?
        get() {
            return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(localTimestamp) {
            setFieldValue(5, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override var eventGroup: Short?
        get() {
            return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(eventGroup) {
            setFieldValue(6, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
