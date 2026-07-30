/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from GyroscopeDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class GyroscopeDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val SampleTimeOffsetFieldNum = 1
        const val GyroXFieldNum = 2
        const val GyroYFieldNum = 3
        const val GyroZFieldNum = 4
        const val CalibratedGyroXFieldNum = 5
        const val CalibratedGyroYFieldNum = 6
        const val CalibratedGyroZFieldNum = 7

        val gyroscopeDataMesg: Mesg = run {
            // gyroscope_data
            val gyroscopeDataMesg = Mesg("gyroscope_data", MesgNum.GYROSCOPE_DATA)
            gyroscopeDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            gyroscopeDataMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            gyroscopeDataMesg.addField(Field("sample_time_offset", SampleTimeOffsetFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            gyroscopeDataMesg.addField(Field("gyro_x", GyroXFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            gyroscopeDataMesg.addField(Field("gyro_y", GyroYFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            gyroscopeDataMesg.addField(Field("gyro_z", GyroZFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            gyroscopeDataMesg.addField(Field("calibrated_gyro_x", CalibratedGyroXFieldNum, 136, 1.0, 0.0, "deg/s", false, Profile.Type.FLOAT32))
            gyroscopeDataMesg.addField(Field("calibrated_gyro_y", CalibratedGyroYFieldNum, 136, 1.0, 0.0, "deg/s", false, Profile.Type.FLOAT32))
            gyroscopeDataMesg.addField(Field("calibrated_gyro_z", CalibratedGyroZFieldNum, 136, 1.0, 0.0, "deg/s", false, Profile.Type.FLOAT32))
            gyroscopeDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.GYROSCOPE_DATA))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp
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
     * Comment: Millisecond part of the timestamp.
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

    fun getSampleTimeOffset(): Array<Int?>? {
        return getFieldIntegerValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of sample_time_offset
     */
    fun getNumSampleTimeOffset(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sample_time_offset field
     * Units: ms
     * Comment: Each time in the array describes the time at which the gyro sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in gyro_x and gyro_y and gyro_z
     *
     * @param index of sample_time_offset
     * @return sample_time_offset
     */
    fun getSampleTimeOffset(index: Int): Int? {
        return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sample_time_offset field
     * Units: ms
     * Comment: Each time in the array describes the time at which the gyro sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in gyro_x and gyro_y and gyro_z
     *
     * @param index of sample_time_offset
     * @param sampleTimeOffset The new sampleTimeOffset value to be set
     */
    fun setSampleTimeOffset(index: Int, sampleTimeOffset: Int?) {
        setFieldValue(1, index, sampleTimeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getGyroX(): Array<Int?>? {
        return getFieldIntegerValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of gyro_x
     */
    fun getNumGyroX(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gyro_x field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of gyro_x
     * @return gyro_x
     */
    fun getGyroX(index: Int): Int? {
        return getFieldIntegerValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gyro_x field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of gyro_x
     * @param gyroX The new gyroX value to be set
     */
    fun setGyroX(index: Int, gyroX: Int?) {
        setFieldValue(2, index, gyroX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getGyroY(): Array<Int?>? {
        return getFieldIntegerValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of gyro_y
     */
    fun getNumGyroY(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gyro_y field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of gyro_y
     * @return gyro_y
     */
    fun getGyroY(index: Int): Int? {
        return getFieldIntegerValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gyro_y field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of gyro_y
     * @param gyroY The new gyroY value to be set
     */
    fun setGyroY(index: Int, gyroY: Int?) {
        setFieldValue(3, index, gyroY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getGyroZ(): Array<Int?>? {
        return getFieldIntegerValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of gyro_z
     */
    fun getNumGyroZ(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gyro_z field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of gyro_z
     * @return gyro_z
     */
    fun getGyroZ(index: Int): Int? {
        return getFieldIntegerValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gyro_z field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of gyro_z
     * @param gyroZ The new gyroZ value to be set
     */
    fun setGyroZ(index: Int, gyroZ: Int?) {
        setFieldValue(4, index, gyroZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedGyroX(): Array<Float?>? {
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_gyro_x
     */
    fun getNumCalibratedGyroX(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_gyro_x field
     * Units: deg/s
     * Comment: Calibrated gyro reading
     *
     * @param index of calibrated_gyro_x
     * @return calibrated_gyro_x
     */
    fun getCalibratedGyroX(index: Int): Float? {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_gyro_x field
     * Units: deg/s
     * Comment: Calibrated gyro reading
     *
     * @param index of calibrated_gyro_x
     * @param calibratedGyroX The new calibratedGyroX value to be set
     */
    fun setCalibratedGyroX(index: Int, calibratedGyroX: Float?) {
        setFieldValue(5, index, calibratedGyroX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedGyroY(): Array<Float?>? {
        return getFieldFloatValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_gyro_y
     */
    fun getNumCalibratedGyroY(): Int {
        return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_gyro_y field
     * Units: deg/s
     * Comment: Calibrated gyro reading
     *
     * @param index of calibrated_gyro_y
     * @return calibrated_gyro_y
     */
    fun getCalibratedGyroY(index: Int): Float? {
        return getFieldFloatValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_gyro_y field
     * Units: deg/s
     * Comment: Calibrated gyro reading
     *
     * @param index of calibrated_gyro_y
     * @param calibratedGyroY The new calibratedGyroY value to be set
     */
    fun setCalibratedGyroY(index: Int, calibratedGyroY: Float?) {
        setFieldValue(6, index, calibratedGyroY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedGyroZ(): Array<Float?>? {
        return getFieldFloatValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_gyro_z
     */
    fun getNumCalibratedGyroZ(): Int {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_gyro_z field
     * Units: deg/s
     * Comment: Calibrated gyro reading
     *
     * @param index of calibrated_gyro_z
     * @return calibrated_gyro_z
     */
    fun getCalibratedGyroZ(index: Int): Float? {
        return getFieldFloatValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_gyro_z field
     * Units: deg/s
     * Comment: Calibrated gyro reading
     *
     * @param index of calibrated_gyro_z
     * @param calibratedGyroZ The new calibratedGyroZ value to be set
     */
    fun setCalibratedGyroZ(index: Int, calibratedGyroZ: Float?) {
        setFieldValue(7, index, calibratedGyroZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
