/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TotalsMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class TotalsMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val TimestampFieldNum = 253
        const val TimerTimeFieldNum = 0
        const val DistanceFieldNum = 1
        const val CaloriesFieldNum = 2
        const val SportFieldNum = 3
        const val ElapsedTimeFieldNum = 4
        const val SessionsFieldNum = 5
        const val ActiveTimeFieldNum = 6
        const val SportIndexFieldNum = 9

        val totalsMesg: Mesg = run {
            // totals
            val totalsMesg = Mesg("totals", MesgNum.TOTALS)
            totalsMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            totalsMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            totalsMesg.addField(Field("timer_time", TimerTimeFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            totalsMesg.addField(Field("distance", DistanceFieldNum, 134, 1.0, 0.0, "m", false, Profile.Type.UINT32))
            totalsMesg.addField(Field("calories", CaloriesFieldNum, 134, 1.0, 0.0, "kcal", false, Profile.Type.UINT32))
            totalsMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            totalsMesg.addField(Field("elapsed_time", ElapsedTimeFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            totalsMesg.addField(Field("sessions", SessionsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            totalsMesg.addField(Field("active_time", ActiveTimeFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            totalsMesg.addField(Field("sport_index", SportIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            totalsMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.TOTALS))

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
     * Units: s
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timer_time field
     * Units: s
     * Comment: Excludes pauses
     *
     * @return timer_time
     */
    fun getTimerTime(): Long? {
        return getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set timer_time field
     * Units: s
     * Comment: Excludes pauses
     *
     * @param timerTime The new timerTime value to be set
     */
    fun setTimerTime(timerTime: Long?) {
        setFieldValue(0, 0, timerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get distance field
     * Units: m
     *
     * @return distance
     */
    fun getDistance(): Long? {
        return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set distance field
     * Units: m
     *
     * @param distance The new distance value to be set
     */
    fun setDistance(distance: Long?) {
        setFieldValue(1, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calories field
     * Units: kcal
     *
     * @return calories
     */
    fun getCalories(): Long? {
        return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calories field
     * Units: kcal
     *
     * @param calories The new calories value to be set
     */
    fun setCalories(calories: Long?) {
        setFieldValue(2, 0, calories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sport field
     *
     * @return sport
     */
    fun getSport(): Sport? {
        val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Sport.fromValue(value)
    }

    /**
     * Set sport field
     *
     * @param sport The new sport value to be set
     */
    fun setSport(sport: Sport?) {
        setFieldValue(3, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get elapsed_time field
     * Units: s
     * Comment: Includes pauses
     *
     * @return elapsed_time
     */
    fun getElapsedTime(): Long? {
        return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set elapsed_time field
     * Units: s
     * Comment: Includes pauses
     *
     * @param elapsedTime The new elapsedTime value to be set
     */
    fun setElapsedTime(elapsedTime: Long?) {
        setFieldValue(4, 0, elapsedTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sessions field
     *
     * @return sessions
     */
    fun getSessions(): Int? {
        return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sessions field
     *
     * @param sessions The new sessions value to be set
     */
    fun setSessions(sessions: Int?) {
        setFieldValue(5, 0, sessions, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get active_time field
     * Units: s
     *
     * @return active_time
     */
    fun getActiveTime(): Long? {
        return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set active_time field
     * Units: s
     *
     * @param activeTime The new activeTime value to be set
     */
    fun setActiveTime(activeTime: Long?) {
        setFieldValue(6, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sport_index field
     *
     * @return sport_index
     */
    fun getSportIndex(): Short? {
        return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sport_index field
     *
     * @param sportIndex The new sportIndex value to be set
     */
    fun setSportIndex(sportIndex: Short?) {
        setFieldValue(9, 0, sportIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
