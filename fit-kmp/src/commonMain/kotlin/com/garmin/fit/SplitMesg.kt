/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SplitMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SplitMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val SplitTypeFieldNum = 0
        const val TotalElapsedTimeFieldNum = 1
        const val TotalTimerTimeFieldNum = 2
        const val TotalDistanceFieldNum = 3
        const val AvgSpeedFieldNum = 4
        const val StartTimeFieldNum = 9
        const val TotalAscentFieldNum = 13
        const val TotalDescentFieldNum = 14
        const val StartPositionLatFieldNum = 21
        const val StartPositionLongFieldNum = 22
        const val EndPositionLatFieldNum = 23
        const val EndPositionLongFieldNum = 24
        const val MaxSpeedFieldNum = 25
        const val AvgVertSpeedFieldNum = 26
        const val EndTimeFieldNum = 27
        const val TotalCaloriesFieldNum = 28
        const val StartElevationFieldNum = 74
        const val ActiveTimeFieldNum = 78
        const val TotalMovingTimeFieldNum = 110

        val splitMesg: Mesg = run {
            // split
            val splitMesg = Mesg("split", MesgNum.SPLIT)
            splitMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            splitMesg.addField(Field("split_type", SplitTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPLIT_TYPE))
            splitMesg.addField(Field("total_elapsed_time", TotalElapsedTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            splitMesg.addField(Field("total_timer_time", TotalTimerTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            splitMesg.addField(Field("total_distance", TotalDistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            splitMesg.addField(Field("avg_speed", AvgSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            splitMesg.addField(Field("start_time", StartTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            splitMesg.addField(Field("total_ascent", TotalAscentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            splitMesg.addField(Field("total_descent", TotalDescentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            splitMesg.addField(Field("start_position_lat", StartPositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            splitMesg.addField(Field("start_position_long", StartPositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            splitMesg.addField(Field("end_position_lat", EndPositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            splitMesg.addField(Field("end_position_long", EndPositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            splitMesg.addField(Field("max_speed", MaxSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            splitMesg.addField(Field("avg_vert_speed", AvgVertSpeedFieldNum, 133, 1000.0, 0.0, "m/s", false, Profile.Type.SINT32))
            splitMesg.addField(Field("end_time", EndTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            splitMesg.addField(Field("total_calories", TotalCaloriesFieldNum, 134, 1.0, 0.0, "kcal", false, Profile.Type.UINT32))
            splitMesg.addField(Field("start_elevation", StartElevationFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            splitMesg.addField(Field("active_time", ActiveTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            splitMesg.addField(Field("total_moving_time", TotalMovingTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            splitMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SPLIT))

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
     * Get total_elapsed_time field
     * Units: s
     *
     * @return total_elapsed_time
     */
    fun getTotalElapsedTime(): Float? {
        return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_elapsed_time field
     * Units: s
     *
     * @param totalElapsedTime The new totalElapsedTime value to be set
     */
    fun setTotalElapsedTime(totalElapsedTime: Float?) {
        setFieldValue(1, 0, totalElapsedTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_timer_time field
     * Units: s
     *
     * @return total_timer_time
     */
    fun getTotalTimerTime(): Float? {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_timer_time field
     * Units: s
     *
     * @param totalTimerTime The new totalTimerTime value to be set
     */
    fun setTotalTimerTime(totalTimerTime: Float?) {
        setFieldValue(2, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_distance field
     * Units: m
     *
     * @return total_distance
     */
    fun getTotalDistance(): Float? {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_distance field
     * Units: m
     *
     * @param totalDistance The new totalDistance value to be set
     */
    fun setTotalDistance(totalDistance: Float?) {
        setFieldValue(3, 0, totalDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    fun getAvgSpeed(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_speed field
     * Units: m/s
     *
     * @param avgSpeed The new avgSpeed value to be set
     */
    fun setAvgSpeed(avgSpeed: Float?) {
        setFieldValue(4, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_time field
     *
     * @return start_time
     */
    fun getStartTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set start_time field
     *
     * @param startTime The new startTime value to be set
     */
    fun setStartTime(startTime: DateTime?) {
        setFieldValue(9, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_ascent field
     * Units: m
     *
     * @return total_ascent
     */
    fun getTotalAscent(): Int? {
        return getFieldIntegerValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_ascent field
     * Units: m
     *
     * @param totalAscent The new totalAscent value to be set
     */
    fun setTotalAscent(totalAscent: Int?) {
        setFieldValue(13, 0, totalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_descent field
     * Units: m
     *
     * @return total_descent
     */
    fun getTotalDescent(): Int? {
        return getFieldIntegerValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_descent field
     * Units: m
     *
     * @param totalDescent The new totalDescent value to be set
     */
    fun setTotalDescent(totalDescent: Int?) {
        setFieldValue(14, 0, totalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_position_lat field
     * Units: semicircles
     *
     * @return start_position_lat
     */
    fun getStartPositionLat(): Int? {
        return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_position_lat field
     * Units: semicircles
     *
     * @param startPositionLat The new startPositionLat value to be set
     */
    fun setStartPositionLat(startPositionLat: Int?) {
        setFieldValue(21, 0, startPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_position_long field
     * Units: semicircles
     *
     * @return start_position_long
     */
    fun getStartPositionLong(): Int? {
        return getFieldIntegerValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_position_long field
     * Units: semicircles
     *
     * @param startPositionLong The new startPositionLong value to be set
     */
    fun setStartPositionLong(startPositionLong: Int?) {
        setFieldValue(22, 0, startPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_position_lat field
     * Units: semicircles
     *
     * @return end_position_lat
     */
    fun getEndPositionLat(): Int? {
        return getFieldIntegerValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_position_lat field
     * Units: semicircles
     *
     * @param endPositionLat The new endPositionLat value to be set
     */
    fun setEndPositionLat(endPositionLat: Int?) {
        setFieldValue(23, 0, endPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_position_long field
     * Units: semicircles
     *
     * @return end_position_long
     */
    fun getEndPositionLong(): Int? {
        return getFieldIntegerValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_position_long field
     * Units: semicircles
     *
     * @param endPositionLong The new endPositionLong value to be set
     */
    fun setEndPositionLong(endPositionLong: Int?) {
        setFieldValue(24, 0, endPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_speed field
     * Units: m/s
     *
     * @return max_speed
     */
    fun getMaxSpeed(): Float? {
        return getFieldFloatValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_speed field
     * Units: m/s
     *
     * @param maxSpeed The new maxSpeed value to be set
     */
    fun setMaxSpeed(maxSpeed: Float?) {
        setFieldValue(25, 0, maxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_vert_speed field
     * Units: m/s
     *
     * @return avg_vert_speed
     */
    fun getAvgVertSpeed(): Float? {
        return getFieldFloatValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_vert_speed field
     * Units: m/s
     *
     * @param avgVertSpeed The new avgVertSpeed value to be set
     */
    fun setAvgVertSpeed(avgVertSpeed: Float?) {
        setFieldValue(26, 0, avgVertSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_time field
     *
     * @return end_time
     */
    fun getEndTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set end_time field
     *
     * @param endTime The new endTime value to be set
     */
    fun setEndTime(endTime: DateTime?) {
        setFieldValue(27, 0, endTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_calories field
     * Units: kcal
     *
     * @return total_calories
     */
    fun getTotalCalories(): Long? {
        return getFieldLongValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_calories field
     * Units: kcal
     *
     * @param totalCalories The new totalCalories value to be set
     */
    fun setTotalCalories(totalCalories: Long?) {
        setFieldValue(28, 0, totalCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_elevation field
     * Units: m
     *
     * @return start_elevation
     */
    fun getStartElevation(): Float? {
        return getFieldFloatValue(74, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_elevation field
     * Units: m
     *
     * @param startElevation The new startElevation value to be set
     */
    fun setStartElevation(startElevation: Float?) {
        setFieldValue(74, 0, startElevation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get active_time field
     * Units: s
     * Comment: Active time of split rounds
     *
     * @return active_time
     */
    fun getActiveTime(): Float? {
        return getFieldFloatValue(78, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set active_time field
     * Units: s
     * Comment: Active time of split rounds
     *
     * @param activeTime The new activeTime value to be set
     */
    fun setActiveTime(activeTime: Float?) {
        setFieldValue(78, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_moving_time field
     * Units: s
     *
     * @return total_moving_time
     */
    fun getTotalMovingTime(): Float? {
        return getFieldFloatValue(110, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_moving_time field
     * Units: s
     *
     * @param totalMovingTime The new totalMovingTime value to be set
     */
    fun setTotalMovingTime(totalMovingTime: Float?) {
        setFieldValue(110, 0, totalMovingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
