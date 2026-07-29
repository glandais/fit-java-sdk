/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SleepAssessmentMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SleepAssessmentMesg : Mesg {

    companion object {
        const val CombinedAwakeScoreFieldNum = 0
        const val AwakeTimeScoreFieldNum = 1
        const val AwakeningsCountScoreFieldNum = 2
        const val DeepSleepScoreFieldNum = 3
        const val SleepDurationScoreFieldNum = 4
        const val LightSleepScoreFieldNum = 5
        const val OverallSleepScoreFieldNum = 6
        const val SleepQualityScoreFieldNum = 7
        const val SleepRecoveryScoreFieldNum = 8
        const val RemSleepScoreFieldNum = 9
        const val SleepRestlessnessScoreFieldNum = 10
        const val AwakeningsCountFieldNum = 11
        const val InterruptionsScoreFieldNum = 14
        const val AverageStressDuringSleepFieldNum = 15

        val sleepAssessmentMesg: Mesg = run {
            // sleep_assessment
            val sleepAssessmentMesg = Mesg("sleep_assessment", MesgNum.SLEEP_ASSESSMENT)
            sleepAssessmentMesg.addField(Field("combined_awake_score", CombinedAwakeScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("awake_time_score", AwakeTimeScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("awakenings_count_score", AwakeningsCountScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("deep_sleep_score", DeepSleepScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("sleep_duration_score", SleepDurationScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("light_sleep_score", LightSleepScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("overall_sleep_score", OverallSleepScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("sleep_quality_score", SleepQualityScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("sleep_recovery_score", SleepRecoveryScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("rem_sleep_score", RemSleepScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("sleep_restlessness_score", SleepRestlessnessScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("awakenings_count", AwakeningsCountFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("interruptions_score", InterruptionsScoreFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sleepAssessmentMesg.addField(Field("average_stress_during_sleep", AverageStressDuringSleepFieldNum, 132, 100.0, 0.0, "", false, Profile.Type.UINT16))
            sleepAssessmentMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SLEEP_ASSESSMENT))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get combined_awake_score field
     * Comment: Average of awake_time_score and awakenings_count_score. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return combined_awake_score
     */
    var combinedAwakeScore: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(combinedAwakeScore) {
            setFieldValue(0, 0, combinedAwakeScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get awake_time_score field
     * Comment: Score that evaluates the total time spent awake between sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return awake_time_score
     */
    var awakeTimeScore: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(awakeTimeScore) {
            setFieldValue(1, 0, awakeTimeScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get awakenings_count_score field
     * Comment: Score that evaluates the number of awakenings that interrupt sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return awakenings_count_score
     */
    var awakeningsCountScore: Short?
        get() {
            return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(awakeningsCountScore) {
            setFieldValue(2, 0, awakeningsCountScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get deep_sleep_score field
     * Comment: Score that evaluates the amount of deep sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return deep_sleep_score
     */
    var deepSleepScore: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(deepSleepScore) {
            setFieldValue(3, 0, deepSleepScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sleep_duration_score field
     * Comment: Score that evaluates the quality of sleep based on sleep stages, heart-rate variability and possible awakenings during the night. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return sleep_duration_score
     */
    var sleepDurationScore: Short?
        get() {
            return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sleepDurationScore) {
            setFieldValue(4, 0, sleepDurationScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get light_sleep_score field
     * Comment: Score that evaluates the amount of light sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return light_sleep_score
     */
    var lightSleepScore: Short?
        get() {
            return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(lightSleepScore) {
            setFieldValue(5, 0, lightSleepScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get overall_sleep_score field
     * Comment: Total score that summarizes the overall quality of sleep, combining sleep duration and quality. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return overall_sleep_score
     */
    var overallSleepScore: Short?
        get() {
            return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(overallSleepScore) {
            setFieldValue(6, 0, overallSleepScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sleep_quality_score field
     * Comment: Score that evaluates the quality of sleep based on sleep stages, heart-rate variability and possible awakenings during the night. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return sleep_quality_score
     */
    var sleepQualityScore: Short?
        get() {
            return getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sleepQualityScore) {
            setFieldValue(7, 0, sleepQualityScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sleep_recovery_score field
     * Comment: Score that evaluates stress and recovery during sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return sleep_recovery_score
     */
    var sleepRecoveryScore: Short?
        get() {
            return getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sleepRecoveryScore) {
            setFieldValue(8, 0, sleepRecoveryScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get rem_sleep_score field
     * Comment: Score that evaluates the amount of REM sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return rem_sleep_score
     */
    var remSleepScore: Short?
        get() {
            return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(remSleepScore) {
            setFieldValue(9, 0, remSleepScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sleep_restlessness_score field
     * Comment: Score that evaluates the amount of restlessness during sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return sleep_restlessness_score
     */
    var sleepRestlessnessScore: Short?
        get() {
            return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sleepRestlessnessScore) {
            setFieldValue(10, 0, sleepRestlessnessScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get awakenings_count field
     * Comment: The number of awakenings during sleep.
     *
     * @return awakenings_count
     */
    var awakeningsCount: Short?
        get() {
            return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(awakeningsCount) {
            setFieldValue(11, 0, awakeningsCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get interruptions_score field
     * Comment: Score that evaluates the sleep interruptions. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return interruptions_score
     */
    var interruptionsScore: Short?
        get() {
            return getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(interruptionsScore) {
            setFieldValue(14, 0, interruptionsScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get average_stress_during_sleep field
     * Comment: Excludes stress during awake periods in the sleep window
     *
     * @return average_stress_during_sleep
     */
    var averageStressDuringSleep: Float?
        get() {
            return getFieldFloatValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(averageStressDuringSleep) {
            setFieldValue(15, 0, averageStressDuringSleep, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
