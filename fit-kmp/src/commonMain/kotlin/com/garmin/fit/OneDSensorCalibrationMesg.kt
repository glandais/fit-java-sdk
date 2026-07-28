/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from OneDSensorCalibrationMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class OneDSensorCalibrationMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val SensorTypeFieldNum = 0
        const val CalibrationFactorFieldNum = 1
        const val CalibrationDivisorFieldNum = 2
        const val LevelShiftFieldNum = 3
        const val OffsetCalFieldNum = 4

        val oneDSensorCalibrationMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // one_d_sensor_calibration
            val oneDSensorCalibrationMesg = Mesg("one_d_sensor_calibration", MesgNum.ONE_D_SENSOR_CALIBRATION)
            oneDSensorCalibrationMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            oneDSensorCalibrationMesg.addField(Field("sensor_type", SensorTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SENSOR_TYPE))
            field_index++
            oneDSensorCalibrationMesg.addField(Field("calibration_factor", CalibrationFactorFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            oneDSensorCalibrationMesg.fields[field_index].subFields.add(SubField("baro_cal_factor", 134, 1.0, 0.0, "Pa"))
            oneDSensorCalibrationMesg.fields[field_index].subFields[subfield_index].addMap(0, 3L)
            subfield_index++
            field_index++
            oneDSensorCalibrationMesg.addField(Field("calibration_divisor", CalibrationDivisorFieldNum, 134, 1.0, 0.0, "counts", false, Profile.Type.UINT32))
            field_index++
            oneDSensorCalibrationMesg.addField(Field("level_shift", LevelShiftFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            field_index++
            oneDSensorCalibrationMesg.addField(Field("offset_cal", OffsetCalFieldNum, 133, 1.0, 0.0, "", false, Profile.Type.SINT32))
            field_index++
            oneDSensorCalibrationMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.ONE_D_SENSOR_CALIBRATION))

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
     * Get baro_cal_factor field
     * Units: Pa
     * Comment: Barometer calibration factor
     *
     * @return baro_cal_factor
     */
    fun getBaroCalFactor(): Long? {
        return getFieldLongValue(1, 0, Profile.SubFields.ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_BARO_CAL_FACTOR)
    }

    /**
     * Set baro_cal_factor field
     * Units: Pa
     * Comment: Barometer calibration factor
     *
     * @param baroCalFactor The new baroCalFactor value to be set
     */
    fun setBaroCalFactor(baroCalFactor: Long?) {
        setFieldValue(1, 0, baroCalFactor, Profile.SubFields.ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_BARO_CAL_FACTOR)
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

    /**
     * Get offset_cal field
     * Comment: Internal Calibration factor
     *
     * @return offset_cal
     */
    fun getOffsetCal(): Int? {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set offset_cal field
     * Comment: Internal Calibration factor
     *
     * @param offsetCal The new offsetCal value to be set
     */
    fun setOffsetCal(offsetCal: Int?) {
        setFieldValue(4, 0, offsetCal, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
