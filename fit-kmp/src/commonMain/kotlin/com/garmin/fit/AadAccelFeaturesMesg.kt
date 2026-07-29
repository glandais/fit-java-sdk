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
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get time field
     * Units: s
     * Comment: Time interval length in seconds
     *
     * @return time
     */
    var time: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(time) {
            setFieldValue(0, 0, time, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get energy_total field
     * Comment: Total accelerometer energy in the interval
     *
     * @return energy_total
     */
    var energyTotal: Long?
        get() {
            return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(energyTotal) {
            setFieldValue(1, 0, energyTotal, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get zero_cross_cnt field
     * Comment: Count of zero crossings
     *
     * @return zero_cross_cnt
     */
    var zeroCrossCnt: Int?
        get() {
            return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(zeroCrossCnt) {
            setFieldValue(2, 0, zeroCrossCnt, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get instance field
     * Comment: Instance ID of zero crossing algorithm
     *
     * @return instance
     */
    var instance: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(instance) {
            setFieldValue(3, 0, instance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get time_above_threshold field
     * Units: s
     * Comment: Total accelerometer time above threshold in the interval
     *
     * @return time_above_threshold
     */
    var timeAboveThreshold: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timeAboveThreshold) {
            setFieldValue(4, 0, timeAboveThreshold, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
