/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from GoalMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class GoalMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val SportFieldNum = 0
        const val SubSportFieldNum = 1
        const val StartDateFieldNum = 2
        const val EndDateFieldNum = 3
        const val TypeFieldNum = 4
        const val ValueFieldNum = 5
        const val RepeatFieldNum = 6
        const val TargetValueFieldNum = 7
        const val RecurrenceFieldNum = 8
        const val RecurrenceValueFieldNum = 9
        const val EnabledFieldNum = 10
        const val SourceFieldNum = 11

        val goalMesg: Mesg = run {
            // goal
            val goalMesg = Mesg("goal", MesgNum.GOAL)
            goalMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            goalMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            goalMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            goalMesg.addField(Field("start_date", StartDateFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            goalMesg.addField(Field("end_date", EndDateFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            goalMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.GOAL))
            goalMesg.addField(Field("value", ValueFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            goalMesg.addField(Field("repeat", RepeatFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            goalMesg.addField(Field("target_value", TargetValueFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            goalMesg.addField(Field("recurrence", RecurrenceFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.GOAL_RECURRENCE))
            goalMesg.addField(Field("recurrence_value", RecurrenceValueFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            goalMesg.addField(Field("enabled", EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            goalMesg.addField(Field("source", SourceFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.GOAL_SOURCE))
            goalMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.GOAL))

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
     * Get sport field
     *
     * @return sport
     */
    var sport: Sport?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Sport.fromValue(value)
        }
        set(sport) {
            setFieldValue(0, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    var subSport: SubSport?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SubSport.fromValue(value)
        }
        set(subSport) {
            setFieldValue(1, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_date field
     *
     * @return start_date
     */
    var startDate: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(startDate) {
            setFieldValue(2, 0, startDate?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_date field
     *
     * @return end_date
     */
    var endDate: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(endDate) {
            setFieldValue(3, 0, endDate?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get type field
     *
     * @return type
     */
    var type: Goal?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Goal.fromValue(value)
        }
        set(type) {
            setFieldValue(4, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get value field
     *
     * @return value
     */
    var value: Long?
        get() {
            return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(value) {
            setFieldValue(5, 0, value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get repeat field
     *
     * @return repeat
     */
    var repeat: Bool?
        get() {
            val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(repeat) {
            setFieldValue(6, 0, repeat?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get target_value field
     *
     * @return target_value
     */
    var targetValue: Long?
        get() {
            return getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(targetValue) {
            setFieldValue(7, 0, targetValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get recurrence field
     *
     * @return recurrence
     */
    var recurrence: GoalRecurrence?
        get() {
            val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return GoalRecurrence.fromValue(value)
        }
        set(recurrence) {
            setFieldValue(8, 0, recurrence?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get recurrence_value field
     *
     * @return recurrence_value
     */
    var recurrenceValue: Int?
        get() {
            return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(recurrenceValue) {
            setFieldValue(9, 0, recurrenceValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enabled field
     *
     * @return enabled
     */
    var enabled: Bool?
        get() {
            val value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(enabled) {
            setFieldValue(10, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get source field
     *
     * @return source
     */
    var source: GoalSource?
        get() {
            val value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return GoalSource.fromValue(value)
        }
        set(source) {
            setFieldValue(11, 0, source?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
