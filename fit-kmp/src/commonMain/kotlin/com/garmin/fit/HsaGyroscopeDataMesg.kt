/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaGyroscopeDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HsaGyroscopeDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val SamplingIntervalFieldNum = 1
        const val GyroXFieldNum = 2
        const val GyroYFieldNum = 3
        const val GyroZFieldNum = 4
        const val Timestamp32kFieldNum = 5

        val hsaGyroscopeDataMesg: Mesg = run {
            // hsa_gyroscope_data
            val hsaGyroscopeDataMesg = Mesg("hsa_gyroscope_data", MesgNum.HSA_GYROSCOPE_DATA)
            hsaGyroscopeDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaGyroscopeDataMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            hsaGyroscopeDataMesg.addField(Field("sampling_interval", SamplingIntervalFieldNum, 132, 1.0, 0.0, "1/32768 s", false, Profile.Type.UINT16))
            hsaGyroscopeDataMesg.addField(Field("gyro_x", GyroXFieldNum, 131, 28.57143, 0.0, "deg/s", false, Profile.Type.SINT16))
            hsaGyroscopeDataMesg.addField(Field("gyro_y", GyroYFieldNum, 131, 28.57143, 0.0, "deg/s", false, Profile.Type.SINT16))
            hsaGyroscopeDataMesg.addField(Field("gyro_z", GyroZFieldNum, 131, 28.57143, 0.0, "deg/s", false, Profile.Type.SINT16))
            hsaGyroscopeDataMesg.addField(Field("timestamp_32k", Timestamp32kFieldNum, 134, 1.0, 0.0, "1/32768 s", false, Profile.Type.UINT32))
            hsaGyroscopeDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_GYROSCOPE_DATA))

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
     * Units: 1/32768 s
     * Comment: Sampling Interval in 32 kHz timescale
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

    fun getGyroX(): Array<Float?>? {
        return getFieldFloatValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of gyro_x
     */
    fun getNumGyroX(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gyro_x field
     * Units: deg/s
     * Comment: X-Axis Measurement
     *
     * @param index of gyro_x
     * @return gyro_x
     */
    fun getGyroX(index: Int): Float? {
        return getFieldFloatValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gyro_x field
     * Units: deg/s
     * Comment: X-Axis Measurement
     *
     * @param index of gyro_x
     * @param gyroX The new gyroX value to be set
     */
    fun setGyroX(index: Int, gyroX: Float?) {
        setFieldValue(2, index, gyroX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getGyroY(): Array<Float?>? {
        return getFieldFloatValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of gyro_y
     */
    fun getNumGyroY(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gyro_y field
     * Units: deg/s
     * Comment: Y-Axis Measurement
     *
     * @param index of gyro_y
     * @return gyro_y
     */
    fun getGyroY(index: Int): Float? {
        return getFieldFloatValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gyro_y field
     * Units: deg/s
     * Comment: Y-Axis Measurement
     *
     * @param index of gyro_y
     * @param gyroY The new gyroY value to be set
     */
    fun setGyroY(index: Int, gyroY: Float?) {
        setFieldValue(3, index, gyroY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getGyroZ(): Array<Float?>? {
        return getFieldFloatValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of gyro_z
     */
    fun getNumGyroZ(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gyro_z field
     * Units: deg/s
     * Comment: Z-Axis Measurement
     *
     * @param index of gyro_z
     * @return gyro_z
     */
    fun getGyroZ(index: Int): Float? {
        return getFieldFloatValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gyro_z field
     * Units: deg/s
     * Comment: Z-Axis Measurement
     *
     * @param index of gyro_z
     * @param gyroZ The new gyroZ value to be set
     */
    fun setGyroZ(index: Int, gyroZ: Float?) {
        setFieldValue(4, index, gyroZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp_32k field
     * Units: 1/32768 s
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
