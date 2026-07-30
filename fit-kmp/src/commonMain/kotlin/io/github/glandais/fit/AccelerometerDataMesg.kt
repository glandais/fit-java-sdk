/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AccelerometerDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class AccelerometerDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val SampleTimeOffsetFieldNum = 1
        const val AccelXFieldNum = 2
        const val AccelYFieldNum = 3
        const val AccelZFieldNum = 4
        const val CalibratedAccelXFieldNum = 5
        const val CalibratedAccelYFieldNum = 6
        const val CalibratedAccelZFieldNum = 7
        const val CompressedCalibratedAccelXFieldNum = 8
        const val CompressedCalibratedAccelYFieldNum = 9
        const val CompressedCalibratedAccelZFieldNum = 10

        val accelerometerDataMesg: Mesg = run {
            // accelerometer_data
            val accelerometerDataMesg = Mesg("accelerometer_data", MesgNum.ACCELEROMETER_DATA)
            accelerometerDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            accelerometerDataMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            accelerometerDataMesg.addField(Field("sample_time_offset", SampleTimeOffsetFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            accelerometerDataMesg.addField(Field("accel_x", AccelXFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            accelerometerDataMesg.addField(Field("accel_y", AccelYFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            accelerometerDataMesg.addField(Field("accel_z", AccelZFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            accelerometerDataMesg.addField(Field("calibrated_accel_x", CalibratedAccelXFieldNum, 136, 1.0, 0.0, "g", false, Profile.Type.FLOAT32))
            accelerometerDataMesg.addField(Field("calibrated_accel_y", CalibratedAccelYFieldNum, 136, 1.0, 0.0, "g", false, Profile.Type.FLOAT32))
            accelerometerDataMesg.addField(Field("calibrated_accel_z", CalibratedAccelZFieldNum, 136, 1.0, 0.0, "g", false, Profile.Type.FLOAT32))
            accelerometerDataMesg.addField(Field("compressed_calibrated_accel_x", CompressedCalibratedAccelXFieldNum, 131, 1.0, 0.0, "mG", false, Profile.Type.SINT16))
            accelerometerDataMesg.addField(Field("compressed_calibrated_accel_y", CompressedCalibratedAccelYFieldNum, 131, 1.0, 0.0, "mG", false, Profile.Type.SINT16))
            accelerometerDataMesg.addField(Field("compressed_calibrated_accel_z", CompressedCalibratedAccelZFieldNum, 131, 1.0, 0.0, "mG", false, Profile.Type.SINT16))
            accelerometerDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.ACCELEROMETER_DATA))

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
     * Comment: Each time in the array describes the time at which the accelerometer sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in accel_x and accel_y and accel_z
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
     * Comment: Each time in the array describes the time at which the accelerometer sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in accel_x and accel_y and accel_z
     *
     * @param index of sample_time_offset
     * @param sampleTimeOffset The new sampleTimeOffset value to be set
     */
    fun setSampleTimeOffset(index: Int, sampleTimeOffset: Int?) {
        setFieldValue(1, index, sampleTimeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAccelX(): Array<Int?>? {
        return getFieldIntegerValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of accel_x
     */
    fun getNumAccelX(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_x field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of accel_x
     * @return accel_x
     */
    fun getAccelX(index: Int): Int? {
        return getFieldIntegerValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accel_x field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of accel_x
     * @param accelX The new accelX value to be set
     */
    fun setAccelX(index: Int, accelX: Int?) {
        setFieldValue(2, index, accelX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAccelY(): Array<Int?>? {
        return getFieldIntegerValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of accel_y
     */
    fun getNumAccelY(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_y field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of accel_y
     * @return accel_y
     */
    fun getAccelY(index: Int): Int? {
        return getFieldIntegerValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accel_y field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of accel_y
     * @param accelY The new accelY value to be set
     */
    fun setAccelY(index: Int, accelY: Int?) {
        setFieldValue(3, index, accelY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAccelZ(): Array<Int?>? {
        return getFieldIntegerValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of accel_z
     */
    fun getNumAccelZ(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_z field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of accel_z
     * @return accel_z
     */
    fun getAccelZ(index: Int): Int? {
        return getFieldIntegerValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accel_z field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of accel_z
     * @param accelZ The new accelZ value to be set
     */
    fun setAccelZ(index: Int, accelZ: Int?) {
        setFieldValue(4, index, accelZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedAccelX(): Array<Float?>? {
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_accel_x
     */
    fun getNumCalibratedAccelX(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_accel_x field
     * Units: g
     * Comment: Calibrated accel reading
     *
     * @param index of calibrated_accel_x
     * @return calibrated_accel_x
     */
    fun getCalibratedAccelX(index: Int): Float? {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_accel_x field
     * Units: g
     * Comment: Calibrated accel reading
     *
     * @param index of calibrated_accel_x
     * @param calibratedAccelX The new calibratedAccelX value to be set
     */
    fun setCalibratedAccelX(index: Int, calibratedAccelX: Float?) {
        setFieldValue(5, index, calibratedAccelX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedAccelY(): Array<Float?>? {
        return getFieldFloatValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_accel_y
     */
    fun getNumCalibratedAccelY(): Int {
        return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_accel_y field
     * Units: g
     * Comment: Calibrated accel reading
     *
     * @param index of calibrated_accel_y
     * @return calibrated_accel_y
     */
    fun getCalibratedAccelY(index: Int): Float? {
        return getFieldFloatValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_accel_y field
     * Units: g
     * Comment: Calibrated accel reading
     *
     * @param index of calibrated_accel_y
     * @param calibratedAccelY The new calibratedAccelY value to be set
     */
    fun setCalibratedAccelY(index: Int, calibratedAccelY: Float?) {
        setFieldValue(6, index, calibratedAccelY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedAccelZ(): Array<Float?>? {
        return getFieldFloatValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_accel_z
     */
    fun getNumCalibratedAccelZ(): Int {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_accel_z field
     * Units: g
     * Comment: Calibrated accel reading
     *
     * @param index of calibrated_accel_z
     * @return calibrated_accel_z
     */
    fun getCalibratedAccelZ(index: Int): Float? {
        return getFieldFloatValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_accel_z field
     * Units: g
     * Comment: Calibrated accel reading
     *
     * @param index of calibrated_accel_z
     * @param calibratedAccelZ The new calibratedAccelZ value to be set
     */
    fun setCalibratedAccelZ(index: Int, calibratedAccelZ: Float?) {
        setFieldValue(7, index, calibratedAccelZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCompressedCalibratedAccelX(): Array<Short?>? {
        return getFieldShortValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of compressed_calibrated_accel_x
     */
    fun getNumCompressedCalibratedAccelX(): Int {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get compressed_calibrated_accel_x field
     * Units: mG
     * Comment: Calibrated accel reading
     *
     * @param index of compressed_calibrated_accel_x
     * @return compressed_calibrated_accel_x
     */
    fun getCompressedCalibratedAccelX(index: Int): Short? {
        return getFieldShortValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set compressed_calibrated_accel_x field
     * Units: mG
     * Comment: Calibrated accel reading
     *
     * @param index of compressed_calibrated_accel_x
     * @param compressedCalibratedAccelX The new compressedCalibratedAccelX value to be set
     */
    fun setCompressedCalibratedAccelX(index: Int, compressedCalibratedAccelX: Short?) {
        setFieldValue(8, index, compressedCalibratedAccelX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCompressedCalibratedAccelY(): Array<Short?>? {
        return getFieldShortValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of compressed_calibrated_accel_y
     */
    fun getNumCompressedCalibratedAccelY(): Int {
        return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get compressed_calibrated_accel_y field
     * Units: mG
     * Comment: Calibrated accel reading
     *
     * @param index of compressed_calibrated_accel_y
     * @return compressed_calibrated_accel_y
     */
    fun getCompressedCalibratedAccelY(index: Int): Short? {
        return getFieldShortValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set compressed_calibrated_accel_y field
     * Units: mG
     * Comment: Calibrated accel reading
     *
     * @param index of compressed_calibrated_accel_y
     * @param compressedCalibratedAccelY The new compressedCalibratedAccelY value to be set
     */
    fun setCompressedCalibratedAccelY(index: Int, compressedCalibratedAccelY: Short?) {
        setFieldValue(9, index, compressedCalibratedAccelY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCompressedCalibratedAccelZ(): Array<Short?>? {
        return getFieldShortValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of compressed_calibrated_accel_z
     */
    fun getNumCompressedCalibratedAccelZ(): Int {
        return getNumFieldValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get compressed_calibrated_accel_z field
     * Units: mG
     * Comment: Calibrated accel reading
     *
     * @param index of compressed_calibrated_accel_z
     * @return compressed_calibrated_accel_z
     */
    fun getCompressedCalibratedAccelZ(index: Int): Short? {
        return getFieldShortValue(10, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set compressed_calibrated_accel_z field
     * Units: mG
     * Comment: Calibrated accel reading
     *
     * @param index of compressed_calibrated_accel_z
     * @param compressedCalibratedAccelZ The new compressedCalibratedAccelZ value to be set
     */
    fun setCompressedCalibratedAccelZ(index: Int, compressedCalibratedAccelZ: Short?) {
        setFieldValue(10, index, compressedCalibratedAccelZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
