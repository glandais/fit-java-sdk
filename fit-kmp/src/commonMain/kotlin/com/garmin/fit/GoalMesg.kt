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
     * Get sport field
     *
     * @return sport
     */
    fun getSport(): Sport? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Sport.fromValue(value)
    }

    /**
     * Set sport field
     *
     * @param sport The new sport value to be set
     */
    fun setSport(sport: Sport?) {
        setFieldValue(0, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    fun getSubSport(): SubSport? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SubSport.fromValue(value)
    }

    /**
     * Set sub_sport field
     *
     * @param subSport The new subSport value to be set
     */
    fun setSubSport(subSport: SubSport?) {
        setFieldValue(1, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_date field
     *
     * @return start_date
     */
    fun getStartDate(): DateTime? {
        return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set start_date field
     *
     * @param startDate The new startDate value to be set
     */
    fun setStartDate(startDate: DateTime?) {
        setFieldValue(2, 0, startDate?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_date field
     *
     * @return end_date
     */
    fun getEndDate(): DateTime? {
        return timestampToDateTime(getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set end_date field
     *
     * @param endDate The new endDate value to be set
     */
    fun setEndDate(endDate: DateTime?) {
        setFieldValue(3, 0, endDate?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get type field
     *
     * @return type
     */
    fun getType(): Goal? {
        val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Goal.fromValue(value)
    }

    /**
     * Set type field
     *
     * @param type The new type value to be set
     */
    fun setType(type: Goal?) {
        setFieldValue(4, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get value field
     *
     * @return value
     */
    fun getValue(): Long? {
        return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set value field
     *
     * @param value The new value value to be set
     */
    fun setValue(value: Long?) {
        setFieldValue(5, 0, value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get repeat field
     *
     * @return repeat
     */
    fun getRepeat(): Bool? {
        val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set repeat field
     *
     * @param repeat The new repeat value to be set
     */
    fun setRepeat(repeat: Bool?) {
        setFieldValue(6, 0, repeat?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get target_value field
     *
     * @return target_value
     */
    fun getTargetValue(): Long? {
        return getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set target_value field
     *
     * @param targetValue The new targetValue value to be set
     */
    fun setTargetValue(targetValue: Long?) {
        setFieldValue(7, 0, targetValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get recurrence field
     *
     * @return recurrence
     */
    fun getRecurrence(): GoalRecurrence? {
        val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return GoalRecurrence.fromValue(value)
    }

    /**
     * Set recurrence field
     *
     * @param recurrence The new recurrence value to be set
     */
    fun setRecurrence(recurrence: GoalRecurrence?) {
        setFieldValue(8, 0, recurrence?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get recurrence_value field
     *
     * @return recurrence_value
     */
    fun getRecurrenceValue(): Int? {
        return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set recurrence_value field
     *
     * @param recurrenceValue The new recurrenceValue value to be set
     */
    fun setRecurrenceValue(recurrenceValue: Int?) {
        setFieldValue(9, 0, recurrenceValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enabled field
     *
     * @return enabled
     */
    fun getEnabled(): Bool? {
        val value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set enabled field
     *
     * @param enabled The new enabled value to be set
     */
    fun setEnabled(enabled: Bool?) {
        setFieldValue(10, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get source field
     *
     * @return source
     */
    fun getSource(): GoalSource? {
        val value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return GoalSource.fromValue(value)
    }

    /**
     * Set source field
     *
     * @param source The new source value to be set
     */
    fun setSource(source: GoalSource?) {
        setFieldValue(11, 0, source?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
