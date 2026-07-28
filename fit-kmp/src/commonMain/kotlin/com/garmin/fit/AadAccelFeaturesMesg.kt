/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AadAccelFeaturesMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class AadAccelFeaturesMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimeFieldNum = 0
        const val EnergyTotalFieldNum = 1
        const val ZeroCrossCntFieldNum = 2
        const val InstanceFieldNum = 3
        const val TimeAboveThresholdFieldNum = 4

        val aadAccelFeaturesMesg: Mesg = run {
            // aad_accel_features
            val aadAccelFeaturesMesg = Mesg("aad_accel_features", MesgNum.AAD_ACCEL_FEATURES)
            aadAccelFeaturesMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            aadAccelFeaturesMesg.addField(Field("time", TimeFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            aadAccelFeaturesMesg.addField(Field("energy_total", EnergyTotalFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            aadAccelFeaturesMesg.addField(Field("zero_cross_cnt", ZeroCrossCntFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            aadAccelFeaturesMesg.addField(Field("instance", InstanceFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            aadAccelFeaturesMesg.addField(Field("time_above_threshold", TimeAboveThresholdFieldNum, 132, 25.0, 0.0, "s", false, Profile.Type.UINT16))
            aadAccelFeaturesMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.AAD_ACCEL_FEATURES))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time field
     * Units: s
     * Comment: Time interval length in seconds
     *
     * @return time
     */
    fun getTime(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time field
     * Units: s
     * Comment: Time interval length in seconds
     *
     * @param time The new time value to be set
     */
    fun setTime(time: Int?) {
        setFieldValue(0, 0, time, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get energy_total field
     * Comment: Total accelerometer energy in the interval
     *
     * @return energy_total
     */
    fun getEnergyTotal(): Long? {
        return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set energy_total field
     * Comment: Total accelerometer energy in the interval
     *
     * @param energyTotal The new energyTotal value to be set
     */
    fun setEnergyTotal(energyTotal: Long?) {
        setFieldValue(1, 0, energyTotal, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get zero_cross_cnt field
     * Comment: Count of zero crossings
     *
     * @return zero_cross_cnt
     */
    fun getZeroCrossCnt(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set zero_cross_cnt field
     * Comment: Count of zero crossings
     *
     * @param zeroCrossCnt The new zeroCrossCnt value to be set
     */
    fun setZeroCrossCnt(zeroCrossCnt: Int?) {
        setFieldValue(2, 0, zeroCrossCnt, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get instance field
     * Comment: Instance ID of zero crossing algorithm
     *
     * @return instance
     */
    fun getInstance(): Short? {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set instance field
     * Comment: Instance ID of zero crossing algorithm
     *
     * @param instance The new instance value to be set
     */
    fun setInstance(instance: Short?) {
        setFieldValue(3, 0, instance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_above_threshold field
     * Units: s
     * Comment: Total accelerometer time above threshold in the interval
     *
     * @return time_above_threshold
     */
    fun getTimeAboveThreshold(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_above_threshold field
     * Units: s
     * Comment: Total accelerometer time above threshold in the interval
     *
     * @param timeAboveThreshold The new timeAboveThreshold value to be set
     */
    fun setTimeAboveThreshold(timeAboveThreshold: Float?) {
        setFieldValue(4, 0, timeAboveThreshold, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
