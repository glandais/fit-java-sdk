/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SplitMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get split_type field
     *
     * @return split_type
     */
    var splitType: SplitType?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SplitType.fromValue(value)
        }
        set(splitType) {
            setFieldValue(0, 0, splitType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_elapsed_time field
     * Units: s
     *
     * @return total_elapsed_time
     */
    var totalElapsedTime: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalElapsedTime) {
            setFieldValue(1, 0, totalElapsedTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_timer_time field
     * Units: s
     *
     * @return total_timer_time
     */
    var totalTimerTime: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalTimerTime) {
            setFieldValue(2, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_distance field
     * Units: m
     *
     * @return total_distance
     */
    var totalDistance: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalDistance) {
            setFieldValue(3, 0, totalDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    var avgSpeed: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgSpeed) {
            setFieldValue(4, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_time field
     *
     * @return start_time
     */
    var startTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(startTime) {
            setFieldValue(9, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_ascent field
     * Units: m
     *
     * @return total_ascent
     */
    var totalAscent: Int?
        get() {
            return getFieldIntegerValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalAscent) {
            setFieldValue(13, 0, totalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_descent field
     * Units: m
     *
     * @return total_descent
     */
    var totalDescent: Int?
        get() {
            return getFieldIntegerValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalDescent) {
            setFieldValue(14, 0, totalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_position_lat field
     * Units: semicircles
     *
     * @return start_position_lat
     */
    var startPositionLat: Int?
        get() {
            return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startPositionLat) {
            setFieldValue(21, 0, startPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_position_long field
     * Units: semicircles
     *
     * @return start_position_long
     */
    var startPositionLong: Int?
        get() {
            return getFieldIntegerValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startPositionLong) {
            setFieldValue(22, 0, startPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_position_lat field
     * Units: semicircles
     *
     * @return end_position_lat
     */
    var endPositionLat: Int?
        get() {
            return getFieldIntegerValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(endPositionLat) {
            setFieldValue(23, 0, endPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_position_long field
     * Units: semicircles
     *
     * @return end_position_long
     */
    var endPositionLong: Int?
        get() {
            return getFieldIntegerValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(endPositionLong) {
            setFieldValue(24, 0, endPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_speed field
     * Units: m/s
     *
     * @return max_speed
     */
    var maxSpeed: Float?
        get() {
            return getFieldFloatValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxSpeed) {
            setFieldValue(25, 0, maxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_vert_speed field
     * Units: m/s
     *
     * @return avg_vert_speed
     */
    var avgVertSpeed: Float?
        get() {
            return getFieldFloatValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgVertSpeed) {
            setFieldValue(26, 0, avgVertSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_time field
     *
     * @return end_time
     */
    var endTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(endTime) {
            setFieldValue(27, 0, endTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_calories field
     * Units: kcal
     *
     * @return total_calories
     */
    var totalCalories: Long?
        get() {
            return getFieldLongValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalCalories) {
            setFieldValue(28, 0, totalCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_elevation field
     * Units: m
     *
     * @return start_elevation
     */
    var startElevation: Float?
        get() {
            return getFieldFloatValue(74, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startElevation) {
            setFieldValue(74, 0, startElevation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get active_time field
     * Units: s
     * Comment: Active time of split rounds
     *
     * @return active_time
     */
    var activeTime: Float?
        get() {
            return getFieldFloatValue(78, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activeTime) {
            setFieldValue(78, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_moving_time field
     * Units: s
     *
     * @return total_moving_time
     */
    var totalMovingTime: Float?
        get() {
            return getFieldFloatValue(110, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalMovingTime) {
            setFieldValue(110, 0, totalMovingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
