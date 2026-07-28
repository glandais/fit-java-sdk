/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SplitSummaryMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SplitSummaryMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val SplitTypeFieldNum = 0
        const val NumSplitsFieldNum = 3
        const val TotalTimerTimeFieldNum = 4
        const val TotalDistanceFieldNum = 5
        const val AvgSpeedFieldNum = 6
        const val MaxSpeedFieldNum = 7
        const val TotalAscentFieldNum = 8
        const val TotalDescentFieldNum = 9
        const val AvgHeartRateFieldNum = 10
        const val MaxHeartRateFieldNum = 11
        const val AvgVertSpeedFieldNum = 12
        const val TotalCaloriesFieldNum = 13
        const val ActiveTimeFieldNum = 65
        const val TotalMovingTimeFieldNum = 77

        val splitSummaryMesg: Mesg = run {
            // split_summary
            val splitSummaryMesg = Mesg("split_summary", MesgNum.SPLIT_SUMMARY)
            splitSummaryMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            splitSummaryMesg.addField(Field("split_type", SplitTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPLIT_TYPE))
            splitSummaryMesg.addField(Field("num_splits", NumSplitsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            splitSummaryMesg.addField(Field("total_timer_time", TotalTimerTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            splitSummaryMesg.addField(Field("total_distance", TotalDistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            splitSummaryMesg.addField(Field("avg_speed", AvgSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            splitSummaryMesg.addField(Field("max_speed", MaxSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            splitSummaryMesg.addField(Field("total_ascent", TotalAscentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            splitSummaryMesg.addField(Field("total_descent", TotalDescentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            splitSummaryMesg.addField(Field("avg_heart_rate", AvgHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            splitSummaryMesg.addField(Field("max_heart_rate", MaxHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            splitSummaryMesg.addField(Field("avg_vert_speed", AvgVertSpeedFieldNum, 133, 1000.0, 0.0, "m/s", false, Profile.Type.SINT32))
            splitSummaryMesg.addField(Field("total_calories", TotalCaloriesFieldNum, 134, 1.0, 0.0, "kcal", false, Profile.Type.UINT32))
            splitSummaryMesg.addField(Field("active_time", ActiveTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            splitSummaryMesg.addField(Field("total_moving_time", TotalMovingTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            splitSummaryMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SPLIT_SUMMARY))

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
     * Get split_type field
     *
     * @return split_type
     */
    fun getSplitType(): SplitType? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SplitType.fromValue(value)
    }

    /**
     * Set split_type field
     *
     * @param splitType The new splitType value to be set
     */
    fun setSplitType(splitType: SplitType?) {
        setFieldValue(0, 0, splitType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get num_splits field
     *
     * @return num_splits
     */
    fun getNumSplits(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set num_splits field
     *
     * @param numSplits The new numSplits value to be set
     */
    fun setNumSplits(numSplits: Int?) {
        setFieldValue(3, 0, numSplits, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_timer_time field
     * Units: s
     *
     * @return total_timer_time
     */
    fun getTotalTimerTime(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_timer_time field
     * Units: s
     *
     * @param totalTimerTime The new totalTimerTime value to be set
     */
    fun setTotalTimerTime(totalTimerTime: Float?) {
        setFieldValue(4, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_distance field
     * Units: m
     *
     * @return total_distance
     */
    fun getTotalDistance(): Float? {
        return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_distance field
     * Units: m
     *
     * @param totalDistance The new totalDistance value to be set
     */
    fun setTotalDistance(totalDistance: Float?) {
        setFieldValue(5, 0, totalDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    fun getAvgSpeed(): Float? {
        return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_speed field
     * Units: m/s
     *
     * @param avgSpeed The new avgSpeed value to be set
     */
    fun setAvgSpeed(avgSpeed: Float?) {
        setFieldValue(6, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_speed field
     * Units: m/s
     *
     * @return max_speed
     */
    fun getMaxSpeed(): Float? {
        return getFieldFloatValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_speed field
     * Units: m/s
     *
     * @param maxSpeed The new maxSpeed value to be set
     */
    fun setMaxSpeed(maxSpeed: Float?) {
        setFieldValue(7, 0, maxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_ascent field
     * Units: m
     *
     * @return total_ascent
     */
    fun getTotalAscent(): Int? {
        return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_ascent field
     * Units: m
     *
     * @param totalAscent The new totalAscent value to be set
     */
    fun setTotalAscent(totalAscent: Int?) {
        setFieldValue(8, 0, totalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_descent field
     * Units: m
     *
     * @return total_descent
     */
    fun getTotalDescent(): Int? {
        return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_descent field
     * Units: m
     *
     * @param totalDescent The new totalDescent value to be set
     */
    fun setTotalDescent(totalDescent: Int?) {
        setFieldValue(9, 0, totalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_heart_rate field
     * Units: bpm
     *
     * @return avg_heart_rate
     */
    fun getAvgHeartRate(): Short? {
        return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_heart_rate field
     * Units: bpm
     *
     * @param avgHeartRate The new avgHeartRate value to be set
     */
    fun setAvgHeartRate(avgHeartRate: Short?) {
        setFieldValue(10, 0, avgHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_heart_rate field
     * Units: bpm
     *
     * @return max_heart_rate
     */
    fun getMaxHeartRate(): Short? {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_heart_rate field
     * Units: bpm
     *
     * @param maxHeartRate The new maxHeartRate value to be set
     */
    fun setMaxHeartRate(maxHeartRate: Short?) {
        setFieldValue(11, 0, maxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_vert_speed field
     * Units: m/s
     *
     * @return avg_vert_speed
     */
    fun getAvgVertSpeed(): Float? {
        return getFieldFloatValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_vert_speed field
     * Units: m/s
     *
     * @param avgVertSpeed The new avgVertSpeed value to be set
     */
    fun setAvgVertSpeed(avgVertSpeed: Float?) {
        setFieldValue(12, 0, avgVertSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_calories field
     * Units: kcal
     *
     * @return total_calories
     */
    fun getTotalCalories(): Long? {
        return getFieldLongValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_calories field
     * Units: kcal
     *
     * @param totalCalories The new totalCalories value to be set
     */
    fun setTotalCalories(totalCalories: Long?) {
        setFieldValue(13, 0, totalCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get active_time field
     * Units: s
     * Comment: total active time in all split rounds
     *
     * @return active_time
     */
    fun getActiveTime(): Float? {
        return getFieldFloatValue(65, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set active_time field
     * Units: s
     * Comment: total active time in all split rounds
     *
     * @param activeTime The new activeTime value to be set
     */
    fun setActiveTime(activeTime: Float?) {
        setFieldValue(65, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_moving_time field
     * Units: s
     *
     * @return total_moving_time
     */
    fun getTotalMovingTime(): Float? {
        return getFieldFloatValue(77, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_moving_time field
     * Units: s
     *
     * @param totalMovingTime The new totalMovingTime value to be set
     */
    fun setTotalMovingTime(totalMovingTime: Float?) {
        setFieldValue(77, 0, totalMovingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
