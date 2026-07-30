/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HrvStatusSummaryMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class HrvStatusSummaryMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val WeeklyAverageFieldNum = 0
        const val LastNightAverageFieldNum = 1
        const val LastNight5MinHighFieldNum = 2
        const val BaselineLowUpperFieldNum = 3
        const val BaselineBalancedLowerFieldNum = 4
        const val BaselineBalancedUpperFieldNum = 5
        const val StatusFieldNum = 6

        val hrvStatusSummaryMesg: Mesg = run {
            // hrv_status_summary
            val hrvStatusSummaryMesg = Mesg("hrv_status_summary", MesgNum.HRV_STATUS_SUMMARY)
            hrvStatusSummaryMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            hrvStatusSummaryMesg.addField(Field("weekly_average", WeeklyAverageFieldNum, 132, 128.0, 0.0, "ms", false, Profile.Type.UINT16))
            hrvStatusSummaryMesg.addField(Field("last_night_average", LastNightAverageFieldNum, 132, 128.0, 0.0, "ms", false, Profile.Type.UINT16))
            hrvStatusSummaryMesg.addField(Field("last_night_5_min_high", LastNight5MinHighFieldNum, 132, 128.0, 0.0, "ms", false, Profile.Type.UINT16))
            hrvStatusSummaryMesg.addField(Field("baseline_low_upper", BaselineLowUpperFieldNum, 132, 128.0, 0.0, "ms", false, Profile.Type.UINT16))
            hrvStatusSummaryMesg.addField(Field("baseline_balanced_lower", BaselineBalancedLowerFieldNum, 132, 128.0, 0.0, "ms", false, Profile.Type.UINT16))
            hrvStatusSummaryMesg.addField(Field("baseline_balanced_upper", BaselineBalancedUpperFieldNum, 132, 128.0, 0.0, "ms", false, Profile.Type.UINT16))
            hrvStatusSummaryMesg.addField(Field("status", StatusFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.HRV_STATUS))
            hrvStatusSummaryMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HRV_STATUS_SUMMARY))

    constructor(mesg: Mesg?) : super(mesg)

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
     * Get weekly_average field
     * Units: ms
     * Comment: 7 day RMSSD average over sleep
     *
     * @return weekly_average
     */
    var weeklyAverage: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(weeklyAverage) {
            setFieldValue(0, 0, weeklyAverage, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get last_night_average field
     * Units: ms
     * Comment: Last night RMSSD average over sleep
     *
     * @return last_night_average
     */
    var lastNightAverage: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(lastNightAverage) {
            setFieldValue(1, 0, lastNightAverage, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get last_night_5_min_high field
     * Units: ms
     * Comment: 5 minute high RMSSD value over sleep
     *
     * @return last_night_5_min_high
     */
    var lastNight5MinHigh: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(lastNight5MinHigh) {
            setFieldValue(2, 0, lastNight5MinHigh, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get baseline_low_upper field
     * Units: ms
     * Comment: 3 week baseline, upper boundary of low HRV status
     *
     * @return baseline_low_upper
     */
    var baselineLowUpper: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(baselineLowUpper) {
            setFieldValue(3, 0, baselineLowUpper, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get baseline_balanced_lower field
     * Units: ms
     * Comment: 3 week baseline, lower boundary of balanced HRV status
     *
     * @return baseline_balanced_lower
     */
    var baselineBalancedLower: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(baselineBalancedLower) {
            setFieldValue(4, 0, baselineBalancedLower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get baseline_balanced_upper field
     * Units: ms
     * Comment: 3 week baseline, upper boundary of balanced HRV status
     *
     * @return baseline_balanced_upper
     */
    var baselineBalancedUpper: Float?
        get() {
            return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(baselineBalancedUpper) {
            setFieldValue(5, 0, baselineBalancedUpper, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get status field
     *
     * @return status
     */
    var status: HrvStatus?
        get() {
            val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return HrvStatus.fromValue(value)
        }
        set(status) {
            setFieldValue(6, 0, status?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
