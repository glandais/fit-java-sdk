/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaAccelerometerDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class HsaAccelerometerDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val SamplingIntervalFieldNum = 1
        const val AccelXFieldNum = 2
        const val AccelYFieldNum = 3
        const val AccelZFieldNum = 4
        const val Timestamp32kFieldNum = 5

        val hsaAccelerometerDataMesg: Mesg = run {
            // hsa_accelerometer_data
            val hsaAccelerometerDataMesg = Mesg("hsa_accelerometer_data", MesgNum.HSA_ACCELEROMETER_DATA)
            hsaAccelerometerDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaAccelerometerDataMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            hsaAccelerometerDataMesg.addField(Field("sampling_interval", SamplingIntervalFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            hsaAccelerometerDataMesg.addField(Field("accel_x", AccelXFieldNum, 131, 1.024, 0.0, "mG", false, Profile.Type.SINT16))
            hsaAccelerometerDataMesg.addField(Field("accel_y", AccelYFieldNum, 131, 1.024, 0.0, "mG", false, Profile.Type.SINT16))
            hsaAccelerometerDataMesg.addField(Field("accel_z", AccelZFieldNum, 131, 1.024, 0.0, "mG", false, Profile.Type.SINT16))
            hsaAccelerometerDataMesg.addField(Field("timestamp_32k", Timestamp32kFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            hsaAccelerometerDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_ACCELEROMETER_DATA))

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
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond resolution of the timestamp
     *
     * @return timestamp_ms
     */
    var timestampMs: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timestampMs) {
            setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sampling_interval field
     * Units: ms
     * Comment: Sampling Interval in Milliseconds
     *
     * @return sampling_interval
     */
    var samplingInterval: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(samplingInterval) {
            setFieldValue(1, 0, samplingInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getAccelX(): Array<Float?>? {
        return getFieldFloatValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of accel_x
     */
    fun getNumAccelX(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_x field
     * Units: mG
     * Comment: X-Axis Measurement
     *
     * @param index of accel_x
     * @return accel_x
     */
    fun getAccelX(index: Int): Float? {
        return getFieldFloatValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accel_x field
     * Units: mG
     * Comment: X-Axis Measurement
     *
     * @param index of accel_x
     * @param accelX The new accelX value to be set
     */
    fun setAccelX(index: Int, accelX: Float?) {
        setFieldValue(2, index, accelX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAccelY(): Array<Float?>? {
        return getFieldFloatValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of accel_y
     */
    fun getNumAccelY(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_y field
     * Units: mG
     * Comment: Y-Axis Measurement
     *
     * @param index of accel_y
     * @return accel_y
     */
    fun getAccelY(index: Int): Float? {
        return getFieldFloatValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accel_y field
     * Units: mG
     * Comment: Y-Axis Measurement
     *
     * @param index of accel_y
     * @param accelY The new accelY value to be set
     */
    fun setAccelY(index: Int, accelY: Float?) {
        setFieldValue(3, index, accelY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAccelZ(): Array<Float?>? {
        return getFieldFloatValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of accel_z
     */
    fun getNumAccelZ(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_z field
     * Units: mG
     * Comment: Z-Axis Measurement
     *
     * @param index of accel_z
     * @return accel_z
     */
    fun getAccelZ(index: Int): Float? {
        return getFieldFloatValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accel_z field
     * Units: mG
     * Comment: Z-Axis Measurement
     *
     * @param index of accel_z
     * @param accelZ The new accelZ value to be set
     */
    fun setAccelZ(index: Int, accelZ: Float?) {
        setFieldValue(4, index, accelZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp_32k field
     * Comment: 32 kHz timestamp
     *
     * @return timestamp_32k
     */
    var timestamp32k: Long?
        get() {
            return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timestamp32k) {
            setFieldValue(5, 0, timestamp32k, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
