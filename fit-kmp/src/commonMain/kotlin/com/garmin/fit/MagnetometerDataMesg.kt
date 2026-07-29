/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MagnetometerDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class MagnetometerDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val SampleTimeOffsetFieldNum = 1
        const val MagXFieldNum = 2
        const val MagYFieldNum = 3
        const val MagZFieldNum = 4
        const val CalibratedMagXFieldNum = 5
        const val CalibratedMagYFieldNum = 6
        const val CalibratedMagZFieldNum = 7

        val magnetometerDataMesg: Mesg = run {
            // magnetometer_data
            val magnetometerDataMesg = Mesg("magnetometer_data", MesgNum.MAGNETOMETER_DATA)
            magnetometerDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            magnetometerDataMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            magnetometerDataMesg.addField(Field("sample_time_offset", SampleTimeOffsetFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            magnetometerDataMesg.addField(Field("mag_x", MagXFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            magnetometerDataMesg.addField(Field("mag_y", MagYFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            magnetometerDataMesg.addField(Field("mag_z", MagZFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            magnetometerDataMesg.addField(Field("calibrated_mag_x", CalibratedMagXFieldNum, 136, 1.0, 0.0, "G", false, Profile.Type.FLOAT32))
            magnetometerDataMesg.addField(Field("calibrated_mag_y", CalibratedMagYFieldNum, 136, 1.0, 0.0, "G", false, Profile.Type.FLOAT32))
            magnetometerDataMesg.addField(Field("calibrated_mag_z", CalibratedMagZFieldNum, 136, 1.0, 0.0, "G", false, Profile.Type.FLOAT32))
            magnetometerDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.MAGNETOMETER_DATA))

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
     * Comment: Each time in the array describes the time at which the compass sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in cmps_x and cmps_y and cmps_z
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
     * Comment: Each time in the array describes the time at which the compass sample with the corrosponding index was taken. Limited to 30 samples in each message. The samples may span across seconds. Array size must match the number of samples in cmps_x and cmps_y and cmps_z
     *
     * @param index of sample_time_offset
     * @param sampleTimeOffset The new sampleTimeOffset value to be set
     */
    fun setSampleTimeOffset(index: Int, sampleTimeOffset: Int?) {
        setFieldValue(1, index, sampleTimeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMagX(): Array<Int?>? {
        return getFieldIntegerValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of mag_x
     */
    fun getNumMagX(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get mag_x field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of mag_x
     * @return mag_x
     */
    fun getMagX(index: Int): Int? {
        return getFieldIntegerValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set mag_x field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of mag_x
     * @param magX The new magX value to be set
     */
    fun setMagX(index: Int, magX: Int?) {
        setFieldValue(2, index, magX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMagY(): Array<Int?>? {
        return getFieldIntegerValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of mag_y
     */
    fun getNumMagY(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get mag_y field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of mag_y
     * @return mag_y
     */
    fun getMagY(index: Int): Int? {
        return getFieldIntegerValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set mag_y field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of mag_y
     * @param magY The new magY value to be set
     */
    fun setMagY(index: Int, magY: Int?) {
        setFieldValue(3, index, magY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMagZ(): Array<Int?>? {
        return getFieldIntegerValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of mag_z
     */
    fun getNumMagZ(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get mag_z field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of mag_z
     * @return mag_z
     */
    fun getMagZ(index: Int): Int? {
        return getFieldIntegerValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set mag_z field
     * Units: counts
     * Comment: These are the raw ADC reading. Maximum number of samples is 30 in each message. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of mag_z
     * @param magZ The new magZ value to be set
     */
    fun setMagZ(index: Int, magZ: Int?) {
        setFieldValue(4, index, magZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedMagX(): Array<Float?>? {
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_mag_x
     */
    fun getNumCalibratedMagX(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_mag_x field
     * Units: G
     * Comment: Calibrated Magnetometer reading
     *
     * @param index of calibrated_mag_x
     * @return calibrated_mag_x
     */
    fun getCalibratedMagX(index: Int): Float? {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_mag_x field
     * Units: G
     * Comment: Calibrated Magnetometer reading
     *
     * @param index of calibrated_mag_x
     * @param calibratedMagX The new calibratedMagX value to be set
     */
    fun setCalibratedMagX(index: Int, calibratedMagX: Float?) {
        setFieldValue(5, index, calibratedMagX, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedMagY(): Array<Float?>? {
        return getFieldFloatValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_mag_y
     */
    fun getNumCalibratedMagY(): Int {
        return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_mag_y field
     * Units: G
     * Comment: Calibrated Magnetometer reading
     *
     * @param index of calibrated_mag_y
     * @return calibrated_mag_y
     */
    fun getCalibratedMagY(index: Int): Float? {
        return getFieldFloatValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_mag_y field
     * Units: G
     * Comment: Calibrated Magnetometer reading
     *
     * @param index of calibrated_mag_y
     * @param calibratedMagY The new calibratedMagY value to be set
     */
    fun setCalibratedMagY(index: Int, calibratedMagY: Float?) {
        setFieldValue(6, index, calibratedMagY, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCalibratedMagZ(): Array<Float?>? {
        return getFieldFloatValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of calibrated_mag_z
     */
    fun getNumCalibratedMagZ(): Int {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_mag_z field
     * Units: G
     * Comment: Calibrated Magnetometer reading
     *
     * @param index of calibrated_mag_z
     * @return calibrated_mag_z
     */
    fun getCalibratedMagZ(index: Int): Float? {
        return getFieldFloatValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibrated_mag_z field
     * Units: G
     * Comment: Calibrated Magnetometer reading
     *
     * @param index of calibrated_mag_z
     * @param calibratedMagZ The new calibratedMagZ value to be set
     */
    fun setCalibratedMagZ(index: Int, calibratedMagZ: Float?) {
        setFieldValue(7, index, calibratedMagZ, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
