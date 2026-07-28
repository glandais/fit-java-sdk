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
    fun getCombinedAwakeScore(): Short? {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set combined_awake_score field
     * Comment: Average of awake_time_score and awakenings_count_score. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param combinedAwakeScore The new combinedAwakeScore value to be set
     */
    fun setCombinedAwakeScore(combinedAwakeScore: Short?) {
        setFieldValue(0, 0, combinedAwakeScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get awake_time_score field
     * Comment: Score that evaluates the total time spent awake between sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return awake_time_score
     */
    fun getAwakeTimeScore(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set awake_time_score field
     * Comment: Score that evaluates the total time spent awake between sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param awakeTimeScore The new awakeTimeScore value to be set
     */
    fun setAwakeTimeScore(awakeTimeScore: Short?) {
        setFieldValue(1, 0, awakeTimeScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get awakenings_count_score field
     * Comment: Score that evaluates the number of awakenings that interrupt sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return awakenings_count_score
     */
    fun getAwakeningsCountScore(): Short? {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set awakenings_count_score field
     * Comment: Score that evaluates the number of awakenings that interrupt sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param awakeningsCountScore The new awakeningsCountScore value to be set
     */
    fun setAwakeningsCountScore(awakeningsCountScore: Short?) {
        setFieldValue(2, 0, awakeningsCountScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get deep_sleep_score field
     * Comment: Score that evaluates the amount of deep sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return deep_sleep_score
     */
    fun getDeepSleepScore(): Short? {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set deep_sleep_score field
     * Comment: Score that evaluates the amount of deep sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param deepSleepScore The new deepSleepScore value to be set
     */
    fun setDeepSleepScore(deepSleepScore: Short?) {
        setFieldValue(3, 0, deepSleepScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sleep_duration_score field
     * Comment: Score that evaluates the quality of sleep based on sleep stages, heart-rate variability and possible awakenings during the night. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return sleep_duration_score
     */
    fun getSleepDurationScore(): Short? {
        return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sleep_duration_score field
     * Comment: Score that evaluates the quality of sleep based on sleep stages, heart-rate variability and possible awakenings during the night. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param sleepDurationScore The new sleepDurationScore value to be set
     */
    fun setSleepDurationScore(sleepDurationScore: Short?) {
        setFieldValue(4, 0, sleepDurationScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get light_sleep_score field
     * Comment: Score that evaluates the amount of light sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return light_sleep_score
     */
    fun getLightSleepScore(): Short? {
        return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set light_sleep_score field
     * Comment: Score that evaluates the amount of light sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param lightSleepScore The new lightSleepScore value to be set
     */
    fun setLightSleepScore(lightSleepScore: Short?) {
        setFieldValue(5, 0, lightSleepScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get overall_sleep_score field
     * Comment: Total score that summarizes the overall quality of sleep, combining sleep duration and quality. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return overall_sleep_score
     */
    fun getOverallSleepScore(): Short? {
        return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set overall_sleep_score field
     * Comment: Total score that summarizes the overall quality of sleep, combining sleep duration and quality. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param overallSleepScore The new overallSleepScore value to be set
     */
    fun setOverallSleepScore(overallSleepScore: Short?) {
        setFieldValue(6, 0, overallSleepScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sleep_quality_score field
     * Comment: Score that evaluates the quality of sleep based on sleep stages, heart-rate variability and possible awakenings during the night. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return sleep_quality_score
     */
    fun getSleepQualityScore(): Short? {
        return getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sleep_quality_score field
     * Comment: Score that evaluates the quality of sleep based on sleep stages, heart-rate variability and possible awakenings during the night. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param sleepQualityScore The new sleepQualityScore value to be set
     */
    fun setSleepQualityScore(sleepQualityScore: Short?) {
        setFieldValue(7, 0, sleepQualityScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sleep_recovery_score field
     * Comment: Score that evaluates stress and recovery during sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return sleep_recovery_score
     */
    fun getSleepRecoveryScore(): Short? {
        return getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sleep_recovery_score field
     * Comment: Score that evaluates stress and recovery during sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param sleepRecoveryScore The new sleepRecoveryScore value to be set
     */
    fun setSleepRecoveryScore(sleepRecoveryScore: Short?) {
        setFieldValue(8, 0, sleepRecoveryScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get rem_sleep_score field
     * Comment: Score that evaluates the amount of REM sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return rem_sleep_score
     */
    fun getRemSleepScore(): Short? {
        return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set rem_sleep_score field
     * Comment: Score that evaluates the amount of REM sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param remSleepScore The new remSleepScore value to be set
     */
    fun setRemSleepScore(remSleepScore: Short?) {
        setFieldValue(9, 0, remSleepScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sleep_restlessness_score field
     * Comment: Score that evaluates the amount of restlessness during sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return sleep_restlessness_score
     */
    fun getSleepRestlessnessScore(): Short? {
        return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sleep_restlessness_score field
     * Comment: Score that evaluates the amount of restlessness during sleep. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param sleepRestlessnessScore The new sleepRestlessnessScore value to be set
     */
    fun setSleepRestlessnessScore(sleepRestlessnessScore: Short?) {
        setFieldValue(10, 0, sleepRestlessnessScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get awakenings_count field
     * Comment: The number of awakenings during sleep.
     *
     * @return awakenings_count
     */
    fun getAwakeningsCount(): Short? {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set awakenings_count field
     * Comment: The number of awakenings during sleep.
     *
     * @param awakeningsCount The new awakeningsCount value to be set
     */
    fun setAwakeningsCount(awakeningsCount: Short?) {
        setFieldValue(11, 0, awakeningsCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get interruptions_score field
     * Comment: Score that evaluates the sleep interruptions. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @return interruptions_score
     */
    fun getInterruptionsScore(): Short? {
        return getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set interruptions_score field
     * Comment: Score that evaluates the sleep interruptions. If valid: 0 (worst) to 100 (best). If unknown: FIT_UINT8_INVALID.
     *
     * @param interruptionsScore The new interruptionsScore value to be set
     */
    fun setInterruptionsScore(interruptionsScore: Short?) {
        setFieldValue(14, 0, interruptionsScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get average_stress_during_sleep field
     * Comment: Excludes stress during awake periods in the sleep window
     *
     * @return average_stress_during_sleep
     */
    fun getAverageStressDuringSleep(): Float? {
        return getFieldFloatValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set average_stress_during_sleep field
     * Comment: Excludes stress during awake periods in the sleep window
     *
     * @param averageStressDuringSleep The new averageStressDuringSleep value to be set
     */
    fun setAverageStressDuringSleep(averageStressDuringSleep: Float?) {
        setFieldValue(15, 0, averageStressDuringSleep, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
