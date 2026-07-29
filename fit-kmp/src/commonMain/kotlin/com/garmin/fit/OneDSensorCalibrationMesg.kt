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
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sensor_type field
     * Comment: Indicates which sensor the calibration is for
     *
     * @return sensor_type
     */
    var sensorType: SensorType?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SensorType.fromValue(value)
        }
        set(sensorType) {
            setFieldValue(0, 0, sensorType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get calibration_factor field
     * Comment: Calibration factor used to convert from raw ADC value to degrees, g, etc.
     *
     * @return calibration_factor
     */
    var calibrationFactor: Long?
        get() {
            return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(calibrationFactor) {
            setFieldValue(1, 0, calibrationFactor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get baro_cal_factor field
     * Units: Pa
     * Comment: Barometer calibration factor
     *
     * @return baro_cal_factor
     */
    var baroCalFactor: Long?
        get() {
            return getFieldLongValue(1, 0, Profile.SubFields.ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_BARO_CAL_FACTOR)
        }
        set(baroCalFactor) {
            setFieldValue(1, 0, baroCalFactor, Profile.SubFields.ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_BARO_CAL_FACTOR)
        }

    /**
     * Get calibration_divisor field
     * Units: counts
     * Comment: Calibration factor divisor
     *
     * @return calibration_divisor
     */
    var calibrationDivisor: Long?
        get() {
            return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(calibrationDivisor) {
            setFieldValue(2, 0, calibrationDivisor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get level_shift field
     * Comment: Level shift value used to shift the ADC value back into range
     *
     * @return level_shift
     */
    var levelShift: Long?
        get() {
            return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(levelShift) {
            setFieldValue(3, 0, levelShift, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get offset_cal field
     * Comment: Internal Calibration factor
     *
     * @return offset_cal
     */
    var offsetCal: Int?
        get() {
            return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(offsetCal) {
            setFieldValue(4, 0, offsetCal, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
