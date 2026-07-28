/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ThreeDSensorCalibrationMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ThreeDSensorCalibrationMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val SensorTypeFieldNum = 0
        const val CalibrationFactorFieldNum = 1
        const val CalibrationDivisorFieldNum = 2
        const val LevelShiftFieldNum = 3
        const val OffsetCalFieldNum = 4
        const val OrientationMatrixFieldNum = 5

        val threeDSensorCalibrationMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // three_d_sensor_calibration
            val threeDSensorCalibrationMesg = Mesg("three_d_sensor_calibration", MesgNum.THREE_D_SENSOR_CALIBRATION)
            threeDSensorCalibrationMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            threeDSensorCalibrationMesg.addField(Field("sensor_type", SensorTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SENSOR_TYPE))
            field_index++
            threeDSensorCalibrationMesg.addField(Field("calibration_factor", CalibrationFactorFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            threeDSensorCalibrationMesg.fields[field_index].subFields.add(SubField("accel_cal_factor", 134, 1.0, 0.0, "g"))
            threeDSensorCalibrationMesg.fields[field_index].subFields[subfield_index].addMap(0, 0L)
            subfield_index++
            threeDSensorCalibrationMesg.fields[field_index].subFields.add(SubField("gyro_cal_factor", 134, 1.0, 0.0, "deg/s"))
            threeDSensorCalibrationMesg.fields[field_index].subFields[subfield_index].addMap(0, 1L)
            subfield_index++
            field_index++
            threeDSensorCalibrationMesg.addField(Field("calibration_divisor", CalibrationDivisorFieldNum, 134, 1.0, 0.0, "counts", false, Profile.Type.UINT32))
            field_index++
            threeDSensorCalibrationMesg.addField(Field("level_shift", LevelShiftFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            field_index++
            threeDSensorCalibrationMesg.addField(Field("offset_cal", OffsetCalFieldNum, 133, 1.0, 0.0, "", false, Profile.Type.SINT32))
            field_index++
            threeDSensorCalibrationMesg.addField(Field("orientation_matrix", OrientationMatrixFieldNum, 133, 65535.0, 0.0, "", false, Profile.Type.SINT32))
            field_index++
            threeDSensorCalibrationMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.THREE_D_SENSOR_CALIBRATION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sensor_type field
     * Comment: Indicates which sensor the calibration is for
     *
     * @return sensor_type
     */
    fun getSensorType(): SensorType? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SensorType.fromValue(value)
    }

    /**
     * Set sensor_type field
     * Comment: Indicates which sensor the calibration is for
     *
     * @param sensorType The new sensorType value to be set
     */
    fun setSensorType(sensorType: SensorType?) {
        setFieldValue(0, 0, sensorType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibration_factor field
     * Comment: Calibration factor used to convert from raw ADC value to degrees, g, etc.
     *
     * @return calibration_factor
     */
    fun getCalibrationFactor(): Long? {
        return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibration_factor field
     * Comment: Calibration factor used to convert from raw ADC value to degrees, g, etc.
     *
     * @param calibrationFactor The new calibrationFactor value to be set
     */
    fun setCalibrationFactor(calibrationFactor: Long?) {
        setFieldValue(1, 0, calibrationFactor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_cal_factor field
     * Units: g
     * Comment: Accelerometer calibration factor
     *
     * @return accel_cal_factor
     */
    fun getAccelCalFactor(): Long? {
        return getFieldLongValue(1, 0, Profile.SubFields.THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_ACCEL_CAL_FACTOR)
    }

    /**
     * Set accel_cal_factor field
     * Units: g
     * Comment: Accelerometer calibration factor
     *
     * @param accelCalFactor The new accelCalFactor value to be set
     */
    fun setAccelCalFactor(accelCalFactor: Long?) {
        setFieldValue(1, 0, accelCalFactor, Profile.SubFields.THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_ACCEL_CAL_FACTOR)
    }

    /**
     * Get gyro_cal_factor field
     * Units: deg/s
     * Comment: Gyro calibration factor
     *
     * @return gyro_cal_factor
     */
    fun getGyroCalFactor(): Long? {
        return getFieldLongValue(1, 0, Profile.SubFields.THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_GYRO_CAL_FACTOR)
    }

    /**
     * Set gyro_cal_factor field
     * Units: deg/s
     * Comment: Gyro calibration factor
     *
     * @param gyroCalFactor The new gyroCalFactor value to be set
     */
    fun setGyroCalFactor(gyroCalFactor: Long?) {
        setFieldValue(1, 0, gyroCalFactor, Profile.SubFields.THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_GYRO_CAL_FACTOR)
    }

    /**
     * Get calibration_divisor field
     * Units: counts
     * Comment: Calibration factor divisor
     *
     * @return calibration_divisor
     */
    fun getCalibrationDivisor(): Long? {
        return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calibration_divisor field
     * Units: counts
     * Comment: Calibration factor divisor
     *
     * @param calibrationDivisor The new calibrationDivisor value to be set
     */
    fun setCalibrationDivisor(calibrationDivisor: Long?) {
        setFieldValue(2, 0, calibrationDivisor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get level_shift field
     * Comment: Level shift value used to shift the ADC value back into range
     *
     * @return level_shift
     */
    fun getLevelShift(): Long? {
        return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set level_shift field
     * Comment: Level shift value used to shift the ADC value back into range
     *
     * @param levelShift The new levelShift value to be set
     */
    fun setLevelShift(levelShift: Long?) {
        setFieldValue(3, 0, levelShift, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getOffsetCal(): Array<Int?>? {
        return getFieldIntegerValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of offset_cal
     */
    fun getNumOffsetCal(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get offset_cal field
     * Comment: Internal calibration factors, one for each: xy, yx, zx
     *
     * @param index of offset_cal
     * @return offset_cal
     */
    fun getOffsetCal(index: Int): Int? {
        return getFieldIntegerValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set offset_cal field
     * Comment: Internal calibration factors, one for each: xy, yx, zx
     *
     * @param index of offset_cal
     * @param offsetCal The new offsetCal value to be set
     */
    fun setOffsetCal(index: Int, offsetCal: Int?) {
        setFieldValue(4, index, offsetCal, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getOrientationMatrix(): Array<Float?>? {
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of orientation_matrix
     */
    fun getNumOrientationMatrix(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get orientation_matrix field
     * Comment: 3 x 3 rotation matrix (row major)
     *
     * @param index of orientation_matrix
     * @return orientation_matrix
     */
    fun getOrientationMatrix(index: Int): Float? {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set orientation_matrix field
     * Comment: 3 x 3 rotation matrix (row major)
     *
     * @param index of orientation_matrix
     * @param orientationMatrix The new orientationMatrix value to be set
     */
    fun setOrientationMatrix(index: Int, orientationMatrix: Float?) {
        setFieldValue(5, index, orientationMatrix, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
