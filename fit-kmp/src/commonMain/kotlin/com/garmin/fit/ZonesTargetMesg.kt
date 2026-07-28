/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ZonesTargetMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ZonesTargetMesg : Mesg {

    companion object {
        const val MaxHeartRateFieldNum = 1
        const val ThresholdHeartRateFieldNum = 2
        const val FunctionalThresholdPowerFieldNum = 3
        const val HrCalcTypeFieldNum = 5
        const val PwrCalcTypeFieldNum = 7

        val zonesTargetMesg: Mesg = run {
            // zones_target
            val zonesTargetMesg = Mesg("zones_target", MesgNum.ZONES_TARGET)
            zonesTargetMesg.addField(Field("max_heart_rate", MaxHeartRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            zonesTargetMesg.addField(Field("threshold_heart_rate", ThresholdHeartRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            zonesTargetMesg.addField(Field("functional_threshold_power", FunctionalThresholdPowerFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            zonesTargetMesg.addField(Field("hr_calc_type", HrCalcTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.HR_ZONE_CALC))
            zonesTargetMesg.addField(Field("pwr_calc_type", PwrCalcTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.PWR_ZONE_CALC))
            zonesTargetMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.ZONES_TARGET))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get max_heart_rate field
     *
     * @return max_heart_rate
     */
    fun getMaxHeartRate(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_heart_rate field
     *
     * @param maxHeartRate The new maxHeartRate value to be set
     */
    fun setMaxHeartRate(maxHeartRate: Short?) {
        setFieldValue(1, 0, maxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get threshold_heart_rate field
     *
     * @return threshold_heart_rate
     */
    fun getThresholdHeartRate(): Short? {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set threshold_heart_rate field
     *
     * @param thresholdHeartRate The new thresholdHeartRate value to be set
     */
    fun setThresholdHeartRate(thresholdHeartRate: Short?) {
        setFieldValue(2, 0, thresholdHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get functional_threshold_power field
     *
     * @return functional_threshold_power
     */
    fun getFunctionalThresholdPower(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set functional_threshold_power field
     *
     * @param functionalThresholdPower The new functionalThresholdPower value to be set
     */
    fun setFunctionalThresholdPower(functionalThresholdPower: Int?) {
        setFieldValue(3, 0, functionalThresholdPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get hr_calc_type field
     *
     * @return hr_calc_type
     */
    fun getHrCalcType(): HrZoneCalc? {
        val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return HrZoneCalc.fromValue(value)
    }

    /**
     * Set hr_calc_type field
     *
     * @param hrCalcType The new hrCalcType value to be set
     */
    fun setHrCalcType(hrCalcType: HrZoneCalc?) {
        setFieldValue(5, 0, hrCalcType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pwr_calc_type field
     *
     * @return pwr_calc_type
     */
    fun getPwrCalcType(): PwrZoneCalc? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return PwrZoneCalc.fromValue(value)
    }

    /**
     * Set pwr_calc_type field
     *
     * @param pwrCalcType The new pwrCalcType value to be set
     */
    fun setPwrCalcType(pwrCalcType: PwrZoneCalc?) {
        setFieldValue(7, 0, pwrCalcType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
