/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SplitSummaryMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
     * Get num_splits field
     *
     * @return num_splits
     */
    var numSplits: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(numSplits) {
            setFieldValue(3, 0, numSplits, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_timer_time field
     * Units: s
     *
     * @return total_timer_time
     */
    var totalTimerTime: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalTimerTime) {
            setFieldValue(4, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_distance field
     * Units: m
     *
     * @return total_distance
     */
    var totalDistance: Float?
        get() {
            return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalDistance) {
            setFieldValue(5, 0, totalDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    var avgSpeed: Float?
        get() {
            return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgSpeed) {
            setFieldValue(6, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_speed field
     * Units: m/s
     *
     * @return max_speed
     */
    var maxSpeed: Float?
        get() {
            return getFieldFloatValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxSpeed) {
            setFieldValue(7, 0, maxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_ascent field
     * Units: m
     *
     * @return total_ascent
     */
    var totalAscent: Int?
        get() {
            return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalAscent) {
            setFieldValue(8, 0, totalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_descent field
     * Units: m
     *
     * @return total_descent
     */
    var totalDescent: Int?
        get() {
            return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalDescent) {
            setFieldValue(9, 0, totalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_heart_rate field
     * Units: bpm
     *
     * @return avg_heart_rate
     */
    var avgHeartRate: Short?
        get() {
            return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgHeartRate) {
            setFieldValue(10, 0, avgHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_heart_rate field
     * Units: bpm
     *
     * @return max_heart_rate
     */
    var maxHeartRate: Short?
        get() {
            return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxHeartRate) {
            setFieldValue(11, 0, maxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_vert_speed field
     * Units: m/s
     *
     * @return avg_vert_speed
     */
    var avgVertSpeed: Float?
        get() {
            return getFieldFloatValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgVertSpeed) {
            setFieldValue(12, 0, avgVertSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_calories field
     * Units: kcal
     *
     * @return total_calories
     */
    var totalCalories: Long?
        get() {
            return getFieldLongValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalCalories) {
            setFieldValue(13, 0, totalCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get active_time field
     * Units: s
     * Comment: total active time in all split rounds
     *
     * @return active_time
     */
    var activeTime: Float?
        get() {
            return getFieldFloatValue(65, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activeTime) {
            setFieldValue(65, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_moving_time field
     * Units: s
     *
     * @return total_moving_time
     */
    var totalMovingTime: Float?
        get() {
            return getFieldFloatValue(77, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalMovingTime) {
            setFieldValue(77, 0, totalMovingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
