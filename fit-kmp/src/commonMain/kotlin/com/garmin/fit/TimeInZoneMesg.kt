/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TimeInZoneMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class TimeInZoneMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ReferenceMesgFieldNum = 0
        const val ReferenceIndexFieldNum = 1
        const val TimeInHrZoneFieldNum = 2
        const val TimeInSpeedZoneFieldNum = 3
        const val TimeInCadenceZoneFieldNum = 4
        const val TimeInPowerZoneFieldNum = 5
        const val HrZoneHighBoundaryFieldNum = 6
        const val SpeedZoneHighBoundaryFieldNum = 7
        const val CadenceZoneHighBondaryFieldNum = 8
        const val PowerZoneHighBoundaryFieldNum = 9
        const val HrCalcTypeFieldNum = 10
        const val MaxHeartRateFieldNum = 11
        const val RestingHeartRateFieldNum = 12
        const val ThresholdHeartRateFieldNum = 13
        const val PwrCalcTypeFieldNum = 14
        const val FunctionalThresholdPowerFieldNum = 15

        val timeInZoneMesg: Mesg = run {
            // time_in_zone
            val timeInZoneMesg = Mesg("time_in_zone", MesgNum.TIME_IN_ZONE)
            timeInZoneMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            timeInZoneMesg.addField(Field("reference_mesg", ReferenceMesgFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESG_NUM))
            timeInZoneMesg.addField(Field("reference_index", ReferenceIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            timeInZoneMesg.addField(Field("time_in_hr_zone", TimeInHrZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            timeInZoneMesg.addField(Field("time_in_speed_zone", TimeInSpeedZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            timeInZoneMesg.addField(Field("time_in_cadence_zone", TimeInCadenceZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            timeInZoneMesg.addField(Field("time_in_power_zone", TimeInPowerZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            timeInZoneMesg.addField(Field("hr_zone_high_boundary", HrZoneHighBoundaryFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            timeInZoneMesg.addField(Field("speed_zone_high_boundary", SpeedZoneHighBoundaryFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            timeInZoneMesg.addField(Field("cadence_zone_high_bondary", CadenceZoneHighBondaryFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            timeInZoneMesg.addField(Field("power_zone_high_boundary", PowerZoneHighBoundaryFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            timeInZoneMesg.addField(Field("hr_calc_type", HrCalcTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.HR_ZONE_CALC))
            timeInZoneMesg.addField(Field("max_heart_rate", MaxHeartRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            timeInZoneMesg.addField(Field("resting_heart_rate", RestingHeartRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            timeInZoneMesg.addField(Field("threshold_heart_rate", ThresholdHeartRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            timeInZoneMesg.addField(Field("pwr_calc_type", PwrCalcTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.PWR_ZONE_CALC))
            timeInZoneMesg.addField(Field("functional_threshold_power", FunctionalThresholdPowerFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            timeInZoneMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.TIME_IN_ZONE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
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
     * Get reference_mesg field
     *
     * @return reference_mesg
     */
    var referenceMesg: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(referenceMesg) {
            setFieldValue(0, 0, referenceMesg, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get reference_index field
     *
     * @return reference_index
     */
    var referenceIndex: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(referenceIndex) {
            setFieldValue(1, 0, referenceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getTimeInHrZone(): Array<Float?>? {
        return getFieldFloatValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_hr_zone
     */
    fun getNumTimeInHrZone(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_hr_zone field
     * Units: s
     *
     * @param index of time_in_hr_zone
     * @return time_in_hr_zone
     */
    fun getTimeInHrZone(index: Int): Float? {
        return getFieldFloatValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_hr_zone field
     * Units: s
     *
     * @param index of time_in_hr_zone
     * @param timeInHrZone The new timeInHrZone value to be set
     */
    fun setTimeInHrZone(index: Int, timeInHrZone: Float?) {
        setFieldValue(2, index, timeInHrZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInSpeedZone(): Array<Float?>? {
        return getFieldFloatValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_speed_zone
     */
    fun getNumTimeInSpeedZone(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_speed_zone field
     * Units: s
     *
     * @param index of time_in_speed_zone
     * @return time_in_speed_zone
     */
    fun getTimeInSpeedZone(index: Int): Float? {
        return getFieldFloatValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_speed_zone field
     * Units: s
     *
     * @param index of time_in_speed_zone
     * @param timeInSpeedZone The new timeInSpeedZone value to be set
     */
    fun setTimeInSpeedZone(index: Int, timeInSpeedZone: Float?) {
        setFieldValue(3, index, timeInSpeedZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInCadenceZone(): Array<Float?>? {
        return getFieldFloatValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_cadence_zone
     */
    fun getNumTimeInCadenceZone(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_cadence_zone field
     * Units: s
     *
     * @param index of time_in_cadence_zone
     * @return time_in_cadence_zone
     */
    fun getTimeInCadenceZone(index: Int): Float? {
        return getFieldFloatValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_cadence_zone field
     * Units: s
     *
     * @param index of time_in_cadence_zone
     * @param timeInCadenceZone The new timeInCadenceZone value to be set
     */
    fun setTimeInCadenceZone(index: Int, timeInCadenceZone: Float?) {
        setFieldValue(4, index, timeInCadenceZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInPowerZone(): Array<Float?>? {
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_power_zone
     */
    fun getNumTimeInPowerZone(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_power_zone field
     * Units: s
     *
     * @param index of time_in_power_zone
     * @return time_in_power_zone
     */
    fun getTimeInPowerZone(index: Int): Float? {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_power_zone field
     * Units: s
     *
     * @param index of time_in_power_zone
     * @param timeInPowerZone The new timeInPowerZone value to be set
     */
    fun setTimeInPowerZone(index: Int, timeInPowerZone: Float?) {
        setFieldValue(5, index, timeInPowerZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getHrZoneHighBoundary(): Array<Short?>? {
        return getFieldShortValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of hr_zone_high_boundary
     */
    fun getNumHrZoneHighBoundary(): Int {
        return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get hr_zone_high_boundary field
     * Units: bpm
     *
     * @param index of hr_zone_high_boundary
     * @return hr_zone_high_boundary
     */
    fun getHrZoneHighBoundary(index: Int): Short? {
        return getFieldShortValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set hr_zone_high_boundary field
     * Units: bpm
     *
     * @param index of hr_zone_high_boundary
     * @param hrZoneHighBoundary The new hrZoneHighBoundary value to be set
     */
    fun setHrZoneHighBoundary(index: Int, hrZoneHighBoundary: Short?) {
        setFieldValue(6, index, hrZoneHighBoundary, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getSpeedZoneHighBoundary(): Array<Float?>? {
        return getFieldFloatValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of speed_zone_high_boundary
     */
    fun getNumSpeedZoneHighBoundary(): Int {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get speed_zone_high_boundary field
     * Units: m/s
     *
     * @param index of speed_zone_high_boundary
     * @return speed_zone_high_boundary
     */
    fun getSpeedZoneHighBoundary(index: Int): Float? {
        return getFieldFloatValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set speed_zone_high_boundary field
     * Units: m/s
     *
     * @param index of speed_zone_high_boundary
     * @param speedZoneHighBoundary The new speedZoneHighBoundary value to be set
     */
    fun setSpeedZoneHighBoundary(index: Int, speedZoneHighBoundary: Float?) {
        setFieldValue(7, index, speedZoneHighBoundary, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCadenceZoneHighBondary(): Array<Short?>? {
        return getFieldShortValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of cadence_zone_high_bondary
     */
    fun getNumCadenceZoneHighBondary(): Int {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get cadence_zone_high_bondary field
     * Units: rpm
     *
     * @param index of cadence_zone_high_bondary
     * @return cadence_zone_high_bondary
     */
    fun getCadenceZoneHighBondary(index: Int): Short? {
        return getFieldShortValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set cadence_zone_high_bondary field
     * Units: rpm
     *
     * @param index of cadence_zone_high_bondary
     * @param cadenceZoneHighBondary The new cadenceZoneHighBondary value to be set
     */
    fun setCadenceZoneHighBondary(index: Int, cadenceZoneHighBondary: Short?) {
        setFieldValue(8, index, cadenceZoneHighBondary, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getPowerZoneHighBoundary(): Array<Int?>? {
        return getFieldIntegerValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of power_zone_high_boundary
     */
    fun getNumPowerZoneHighBoundary(): Int {
        return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get power_zone_high_boundary field
     * Units: watts
     *
     * @param index of power_zone_high_boundary
     * @return power_zone_high_boundary
     */
    fun getPowerZoneHighBoundary(index: Int): Int? {
        return getFieldIntegerValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set power_zone_high_boundary field
     * Units: watts
     *
     * @param index of power_zone_high_boundary
     * @param powerZoneHighBoundary The new powerZoneHighBoundary value to be set
     */
    fun setPowerZoneHighBoundary(index: Int, powerZoneHighBoundary: Int?) {
        setFieldValue(9, index, powerZoneHighBoundary, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get hr_calc_type field
     *
     * @return hr_calc_type
     */
    var hrCalcType: HrZoneCalc?
        get() {
            val value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return HrZoneCalc.fromValue(value)
        }
        set(hrCalcType) {
            setFieldValue(10, 0, hrCalcType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_heart_rate field
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
     * Get resting_heart_rate field
     *
     * @return resting_heart_rate
     */
    var restingHeartRate: Short?
        get() {
            return getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(restingHeartRate) {
            setFieldValue(12, 0, restingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get threshold_heart_rate field
     *
     * @return threshold_heart_rate
     */
    var thresholdHeartRate: Short?
        get() {
            return getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(thresholdHeartRate) {
            setFieldValue(13, 0, thresholdHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get pwr_calc_type field
     *
     * @return pwr_calc_type
     */
    var pwrCalcType: PwrZoneCalc?
        get() {
            val value = getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return PwrZoneCalc.fromValue(value)
        }
        set(pwrCalcType) {
            setFieldValue(14, 0, pwrCalcType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get functional_threshold_power field
     *
     * @return functional_threshold_power
     */
    var functionalThresholdPower: Int?
        get() {
            return getFieldIntegerValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(functionalThresholdPower) {
            setFieldValue(15, 0, functionalThresholdPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
