/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from RecordMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class RecordMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val PositionLatFieldNum = 0
        const val PositionLongFieldNum = 1
        const val AltitudeFieldNum = 2
        const val HeartRateFieldNum = 3
        const val CadenceFieldNum = 4
        const val DistanceFieldNum = 5
        const val SpeedFieldNum = 6
        const val PowerFieldNum = 7
        const val CompressedSpeedDistanceFieldNum = 8
        const val GradeFieldNum = 9
        const val ResistanceFieldNum = 10
        const val TimeFromCourseFieldNum = 11
        const val CycleLengthFieldNum = 12
        const val TemperatureFieldNum = 13
        const val Speed1sFieldNum = 17
        const val CyclesFieldNum = 18
        const val TotalCyclesFieldNum = 19
        const val CompressedAccumulatedPowerFieldNum = 28
        const val AccumulatedPowerFieldNum = 29
        const val LeftRightBalanceFieldNum = 30
        const val GpsAccuracyFieldNum = 31
        const val VerticalSpeedFieldNum = 32
        const val CaloriesFieldNum = 33
        const val VerticalOscillationFieldNum = 39
        const val StanceTimePercentFieldNum = 40
        const val StanceTimeFieldNum = 41
        const val ActivityTypeFieldNum = 42
        const val LeftTorqueEffectivenessFieldNum = 43
        const val RightTorqueEffectivenessFieldNum = 44
        const val LeftPedalSmoothnessFieldNum = 45
        const val RightPedalSmoothnessFieldNum = 46
        const val CombinedPedalSmoothnessFieldNum = 47
        const val Time128FieldNum = 48
        const val StrokeTypeFieldNum = 49
        const val ZoneFieldNum = 50
        const val BallSpeedFieldNum = 51
        const val Cadence256FieldNum = 52
        const val FractionalCadenceFieldNum = 53
        const val TotalHemoglobinConcFieldNum = 54
        const val TotalHemoglobinConcMinFieldNum = 55
        const val TotalHemoglobinConcMaxFieldNum = 56
        const val SaturatedHemoglobinPercentFieldNum = 57
        const val SaturatedHemoglobinPercentMinFieldNum = 58
        const val SaturatedHemoglobinPercentMaxFieldNum = 59
        const val DeviceIndexFieldNum = 62
        const val LeftPcoFieldNum = 67
        const val RightPcoFieldNum = 68
        const val LeftPowerPhaseFieldNum = 69
        const val LeftPowerPhasePeakFieldNum = 70
        const val RightPowerPhaseFieldNum = 71
        const val RightPowerPhasePeakFieldNum = 72
        const val EnhancedSpeedFieldNum = 73
        const val EnhancedAltitudeFieldNum = 78
        const val BatterySocFieldNum = 81
        const val MotorPowerFieldNum = 82
        const val VerticalRatioFieldNum = 83
        const val StanceTimeBalanceFieldNum = 84
        const val StepLengthFieldNum = 85
        const val CycleLength16FieldNum = 87
        const val AbsolutePressureFieldNum = 91
        const val DepthFieldNum = 92
        const val NextStopDepthFieldNum = 93
        const val NextStopTimeFieldNum = 94
        const val TimeToSurfaceFieldNum = 95
        const val NdlTimeFieldNum = 96
        const val CnsLoadFieldNum = 97
        const val N2LoadFieldNum = 98
        const val RespirationRateFieldNum = 99
        const val EnhancedRespirationRateFieldNum = 108
        const val GritFieldNum = 114
        const val FlowFieldNum = 115
        const val CurrentStressFieldNum = 116
        const val EbikeTravelRangeFieldNum = 117
        const val EbikeBatteryLevelFieldNum = 118
        const val EbikeAssistModeFieldNum = 119
        const val EbikeAssistLevelPercentFieldNum = 120
        const val AirTimeRemainingFieldNum = 123
        const val PressureSacFieldNum = 124
        const val VolumeSacFieldNum = 125
        const val RmvFieldNum = 126
        const val AscentRateFieldNum = 127
        const val Po2FieldNum = 129
        const val CoreTemperatureFieldNum = 139

        val recordMesg: Mesg = run {
            var field_index = 0
            // record
            val recordMesg = Mesg("record", MesgNum.RECORD)
            recordMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            recordMesg.addField(Field("position_lat", PositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            recordMesg.addField(Field("position_long", PositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            recordMesg.addField(Field("altitude", AltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            recordMesg.fields[field_index].components.add(FieldComponent(78, false, 16, 5.0, 500.0)) // enhanced_altitude
            field_index++
            recordMesg.addField(Field("heart_rate", HeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("cadence", CadenceFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("distance", DistanceFieldNum, 134, 100.0, 0.0, "m", true, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("speed", SpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            recordMesg.fields[field_index].components.add(FieldComponent(73, false, 16, 1000.0, 0.0)) // enhanced_speed
            field_index++
            recordMesg.addField(Field("power", PowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("compressed_speed_distance", CompressedSpeedDistanceFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            recordMesg.fields[field_index].components.add(FieldComponent(6, false, 12, 100.0, 0.0)) // speed
            recordMesg.fields[field_index].components.add(FieldComponent(5, true, 12, 16.0, 0.0)) // distance
            field_index++
            recordMesg.addField(Field("grade", GradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            recordMesg.addField(Field("resistance", ResistanceFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("time_from_course", TimeFromCourseFieldNum, 133, 1000.0, 0.0, "s", false, Profile.Type.SINT32))
            field_index++
            recordMesg.addField(Field("cycle_length", CycleLengthFieldNum, 2, 100.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("temperature", TemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            recordMesg.addField(Field("speed_1s", Speed1sFieldNum, 2, 16.0, 0.0, "m/s", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("cycles", CyclesFieldNum, 2, 1.0, 0.0, "cycles", false, Profile.Type.UINT8))
            recordMesg.fields[field_index].components.add(FieldComponent(19, true, 8, 1.0, 0.0)) // total_cycles
            field_index++
            recordMesg.addField(Field("total_cycles", TotalCyclesFieldNum, 134, 1.0, 0.0, "cycles", true, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("compressed_accumulated_power", CompressedAccumulatedPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            recordMesg.fields[field_index].components.add(FieldComponent(29, true, 16, 1.0, 0.0)) // accumulated_power
            field_index++
            recordMesg.addField(Field("accumulated_power", AccumulatedPowerFieldNum, 134, 1.0, 0.0, "watts", true, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("left_right_balance", LeftRightBalanceFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.LEFT_RIGHT_BALANCE))
            field_index++
            recordMesg.addField(Field("gps_accuracy", GpsAccuracyFieldNum, 2, 1.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("vertical_speed", VerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            recordMesg.addField(Field("calories", CaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("vertical_oscillation", VerticalOscillationFieldNum, 132, 10.0, 0.0, "mm", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("stance_time_percent", StanceTimePercentFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("stance_time", StanceTimeFieldNum, 132, 10.0, 0.0, "ms", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("activity_type", ActivityTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ACTIVITY_TYPE))
            field_index++
            recordMesg.addField(Field("left_torque_effectiveness", LeftTorqueEffectivenessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("right_torque_effectiveness", RightTorqueEffectivenessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("left_pedal_smoothness", LeftPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("right_pedal_smoothness", RightPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("combined_pedal_smoothness", CombinedPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("time128", Time128FieldNum, 2, 128.0, 0.0, "s", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("stroke_type", StrokeTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.STROKE_TYPE))
            field_index++
            recordMesg.addField(Field("zone", ZoneFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("ball_speed", BallSpeedFieldNum, 132, 100.0, 0.0, "m/s", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("cadence256", Cadence256FieldNum, 132, 256.0, 0.0, "rpm", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("fractional_cadence", FractionalCadenceFieldNum, 2, 128.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("total_hemoglobin_conc", TotalHemoglobinConcFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("total_hemoglobin_conc_min", TotalHemoglobinConcMinFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("total_hemoglobin_conc_max", TotalHemoglobinConcMaxFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("saturated_hemoglobin_percent", SaturatedHemoglobinPercentFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("saturated_hemoglobin_percent_min", SaturatedHemoglobinPercentMinFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("saturated_hemoglobin_percent_max", SaturatedHemoglobinPercentMaxFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("device_index", DeviceIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.DEVICE_INDEX))
            field_index++
            recordMesg.addField(Field("left_pco", LeftPcoFieldNum, 1, 1.0, 0.0, "mm", false, Profile.Type.SINT8))
            field_index++
            recordMesg.addField(Field("right_pco", RightPcoFieldNum, 1, 1.0, 0.0, "mm", false, Profile.Type.SINT8))
            field_index++
            recordMesg.addField(Field("left_power_phase", LeftPowerPhaseFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("left_power_phase_peak", LeftPowerPhasePeakFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("right_power_phase", RightPowerPhaseFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("right_power_phase_peak", RightPowerPhasePeakFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("enhanced_speed", EnhancedSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("enhanced_altitude", EnhancedAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("battery_soc", BatterySocFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("motor_power", MotorPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("vertical_ratio", VerticalRatioFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("stance_time_balance", StanceTimeBalanceFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("step_length", StepLengthFieldNum, 132, 10.0, 0.0, "mm", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("cycle_length16", CycleLength16FieldNum, 132, 100.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("absolute_pressure", AbsolutePressureFieldNum, 134, 1.0, 0.0, "Pa", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("depth", DepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("next_stop_depth", NextStopDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("next_stop_time", NextStopTimeFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("time_to_surface", TimeToSurfaceFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("ndl_time", NdlTimeFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("cns_load", CnsLoadFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("n2_load", N2LoadFieldNum, 132, 1.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("respiration_rate", RespirationRateFieldNum, 2, 1.0, 0.0, "s", false, Profile.Type.UINT8))
            recordMesg.fields[field_index].components.add(FieldComponent(108, false, 8, 1.0, 0.0)) // enhanced_respiration_rate
            field_index++
            recordMesg.addField(Field("enhanced_respiration_rate", EnhancedRespirationRateFieldNum, 132, 100.0, 0.0, "Breaths/min", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("grit", GritFieldNum, 136, 1.0, 0.0, "", false, Profile.Type.FLOAT32))
            field_index++
            recordMesg.addField(Field("flow", FlowFieldNum, 136, 1.0, 0.0, "", false, Profile.Type.FLOAT32))
            field_index++
            recordMesg.addField(Field("current_stress", CurrentStressFieldNum, 132, 100.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("ebike_travel_range", EbikeTravelRangeFieldNum, 132, 1.0, 0.0, "km", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("ebike_battery_level", EbikeBatteryLevelFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("ebike_assist_mode", EbikeAssistModeFieldNum, 2, 1.0, 0.0, "depends on sensor", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("ebike_assist_level_percent", EbikeAssistLevelPercentFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("air_time_remaining", AirTimeRemainingFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            recordMesg.addField(Field("pressure_sac", PressureSacFieldNum, 132, 100.0, 0.0, "bar/min", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("volume_sac", VolumeSacFieldNum, 132, 100.0, 0.0, "L/min", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("rmv", RmvFieldNum, 132, 100.0, 0.0, "L/min", false, Profile.Type.UINT16))
            field_index++
            recordMesg.addField(Field("ascent_rate", AscentRateFieldNum, 133, 1000.0, 0.0, "m/s", false, Profile.Type.SINT32))
            field_index++
            recordMesg.addField(Field("po2", Po2FieldNum, 2, 100.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            recordMesg.addField(Field("core_temperature", CoreTemperatureFieldNum, 132, 100.0, 0.0, "C", false, Profile.Type.UINT16))
            field_index++
            recordMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.RECORD))

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
     * Get position_lat field
     * Units: semicircles
     *
     * @return position_lat
     */
    var positionLat: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(positionLat) {
            setFieldValue(0, 0, positionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get position_long field
     * Units: semicircles
     *
     * @return position_long
     */
    var positionLong: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(positionLong) {
            setFieldValue(1, 0, positionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get altitude field
     * Units: m
     *
     * @return altitude
     */
    var altitude: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(altitude) {
            setFieldValue(2, 0, altitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get heart_rate field
     * Units: bpm
     *
     * @return heart_rate
     */
    var heartRate: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(heartRate) {
            setFieldValue(3, 0, heartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cadence field
     * Units: rpm
     *
     * @return cadence
     */
    var cadence: Short?
        get() {
            return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cadence) {
            setFieldValue(4, 0, cadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get distance field
     * Units: m
     *
     * @return distance
     */
    var distance: Float?
        get() {
            return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(distance) {
            setFieldValue(5, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get speed field
     * Units: m/s
     *
     * @return speed
     */
    var speed: Float?
        get() {
            return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(speed) {
            setFieldValue(6, 0, speed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get power field
     * Units: watts
     *
     * @return power
     */
    var power: Int?
        get() {
            return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(power) {
            setFieldValue(7, 0, power, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getCompressedSpeedDistance(): Array<Byte?>? {
        return getFieldByteValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of compressed_speed_distance
     */
    fun getNumCompressedSpeedDistance(): Int {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get compressed_speed_distance field
     *
     * @param index of compressed_speed_distance
     * @return compressed_speed_distance
     */
    fun getCompressedSpeedDistance(index: Int): Byte? {
        return getFieldByteValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set compressed_speed_distance field
     *
     * @param index of compressed_speed_distance
     * @param compressedSpeedDistance The new compressedSpeedDistance value to be set
     */
    fun setCompressedSpeedDistance(index: Int, compressedSpeedDistance: Byte?) {
        setFieldValue(8, index, compressedSpeedDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get grade field
     * Units: %
     *
     * @return grade
     */
    var grade: Float?
        get() {
            return getFieldFloatValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(grade) {
            setFieldValue(9, 0, grade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get resistance field
     * Comment: Relative. 0 is none 254 is Max.
     *
     * @return resistance
     */
    var resistance: Short?
        get() {
            return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(resistance) {
            setFieldValue(10, 0, resistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get time_from_course field
     * Units: s
     *
     * @return time_from_course
     */
    var timeFromCourse: Float?
        get() {
            return getFieldFloatValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timeFromCourse) {
            setFieldValue(11, 0, timeFromCourse, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cycle_length field
     * Units: m
     *
     * @return cycle_length
     */
    var cycleLength: Float?
        get() {
            return getFieldFloatValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cycleLength) {
            setFieldValue(12, 0, cycleLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get temperature field
     * Units: C
     *
     * @return temperature
     */
    var temperature: Byte?
        get() {
            return getFieldByteValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(temperature) {
            setFieldValue(13, 0, temperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getSpeed1s(): Array<Float?>? {
        return getFieldFloatValues(17, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of speed_1s
     */
    fun getNumSpeed1s(): Int {
        return getNumFieldValues(17, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get speed_1s field
     * Units: m/s
     * Comment: Speed at 1s intervals. Timestamp field indicates time of last array element.
     *
     * @param index of speed_1s
     * @return speed_1s
     */
    fun getSpeed1s(index: Int): Float? {
        return getFieldFloatValue(17, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set speed_1s field
     * Units: m/s
     * Comment: Speed at 1s intervals. Timestamp field indicates time of last array element.
     *
     * @param index of speed_1s
     * @param speed1s The new speed1s value to be set
     */
    fun setSpeed1s(index: Int, speed1s: Float?) {
        setFieldValue(17, index, speed1s, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get cycles field
     * Units: cycles
     *
     * @return cycles
     */
    var cycles: Short?
        get() {
            return getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cycles) {
            setFieldValue(18, 0, cycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_cycles field
     * Units: cycles
     *
     * @return total_cycles
     */
    var totalCycles: Long?
        get() {
            return getFieldLongValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalCycles) {
            setFieldValue(19, 0, totalCycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get compressed_accumulated_power field
     * Units: watts
     *
     * @return compressed_accumulated_power
     */
    var compressedAccumulatedPower: Int?
        get() {
            return getFieldIntegerValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(compressedAccumulatedPower) {
            setFieldValue(28, 0, compressedAccumulatedPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get accumulated_power field
     * Units: watts
     *
     * @return accumulated_power
     */
    var accumulatedPower: Long?
        get() {
            return getFieldLongValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(accumulatedPower) {
            setFieldValue(29, 0, accumulatedPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get left_right_balance field
     *
     * @return left_right_balance
     */
    var leftRightBalance: Short?
        get() {
            return getFieldShortValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(leftRightBalance) {
            setFieldValue(30, 0, leftRightBalance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get gps_accuracy field
     * Units: m
     *
     * @return gps_accuracy
     */
    var gpsAccuracy: Short?
        get() {
            return getFieldShortValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(gpsAccuracy) {
            setFieldValue(31, 0, gpsAccuracy, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get vertical_speed field
     * Units: m/s
     *
     * @return vertical_speed
     */
    var verticalSpeed: Float?
        get() {
            return getFieldFloatValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(verticalSpeed) {
            setFieldValue(32, 0, verticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get calories field
     * Units: kcal
     *
     * @return calories
     */
    var calories: Int?
        get() {
            return getFieldIntegerValue(33, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(calories) {
            setFieldValue(33, 0, calories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get vertical_oscillation field
     * Units: mm
     *
     * @return vertical_oscillation
     */
    var verticalOscillation: Float?
        get() {
            return getFieldFloatValue(39, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(verticalOscillation) {
            setFieldValue(39, 0, verticalOscillation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get stance_time_percent field
     * Units: percent
     *
     * @return stance_time_percent
     */
    var stanceTimePercent: Float?
        get() {
            return getFieldFloatValue(40, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(stanceTimePercent) {
            setFieldValue(40, 0, stanceTimePercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get stance_time field
     * Units: ms
     *
     * @return stance_time
     */
    var stanceTime: Float?
        get() {
            return getFieldFloatValue(41, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(stanceTime) {
            setFieldValue(41, 0, stanceTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_type field
     *
     * @return activity_type
     */
    var activityType: ActivityType?
        get() {
            val value = getFieldShortValue(42, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ActivityType.fromValue(value)
        }
        set(activityType) {
            setFieldValue(42, 0, activityType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get left_torque_effectiveness field
     * Units: percent
     *
     * @return left_torque_effectiveness
     */
    var leftTorqueEffectiveness: Float?
        get() {
            return getFieldFloatValue(43, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(leftTorqueEffectiveness) {
            setFieldValue(43, 0, leftTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get right_torque_effectiveness field
     * Units: percent
     *
     * @return right_torque_effectiveness
     */
    var rightTorqueEffectiveness: Float?
        get() {
            return getFieldFloatValue(44, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rightTorqueEffectiveness) {
            setFieldValue(44, 0, rightTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get left_pedal_smoothness field
     * Units: percent
     *
     * @return left_pedal_smoothness
     */
    var leftPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(45, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(leftPedalSmoothness) {
            setFieldValue(45, 0, leftPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get right_pedal_smoothness field
     * Units: percent
     *
     * @return right_pedal_smoothness
     */
    var rightPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(46, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rightPedalSmoothness) {
            setFieldValue(46, 0, rightPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get combined_pedal_smoothness field
     * Units: percent
     *
     * @return combined_pedal_smoothness
     */
    var combinedPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(combinedPedalSmoothness) {
            setFieldValue(47, 0, combinedPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get time128 field
     * Units: s
     *
     * @return time128
     */
    var time128: Float?
        get() {
            return getFieldFloatValue(48, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(time128) {
            setFieldValue(48, 0, time128, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get stroke_type field
     *
     * @return stroke_type
     */
    var strokeType: StrokeType?
        get() {
            val value = getFieldShortValue(49, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return StrokeType.fromValue(value)
        }
        set(strokeType) {
            setFieldValue(49, 0, strokeType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get zone field
     *
     * @return zone
     */
    var zone: Short?
        get() {
            return getFieldShortValue(50, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(zone) {
            setFieldValue(50, 0, zone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ball_speed field
     * Units: m/s
     *
     * @return ball_speed
     */
    var ballSpeed: Float?
        get() {
            return getFieldFloatValue(51, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ballSpeed) {
            setFieldValue(51, 0, ballSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cadence256 field
     * Units: rpm
     * Comment: Log cadence and fractional cadence for backwards compatability
     *
     * @return cadence256
     */
    var cadence256: Float?
        get() {
            return getFieldFloatValue(52, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cadence256) {
            setFieldValue(52, 0, cadence256, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get fractional_cadence field
     * Units: rpm
     *
     * @return fractional_cadence
     */
    var fractionalCadence: Float?
        get() {
            return getFieldFloatValue(53, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fractionalCadence) {
            setFieldValue(53, 0, fractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_hemoglobin_conc field
     * Units: g/dL
     * Comment: Total saturated and unsaturated hemoglobin
     *
     * @return total_hemoglobin_conc
     */
    var totalHemoglobinConc: Float?
        get() {
            return getFieldFloatValue(54, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalHemoglobinConc) {
            setFieldValue(54, 0, totalHemoglobinConc, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_hemoglobin_conc_min field
     * Units: g/dL
     * Comment: Min saturated and unsaturated hemoglobin
     *
     * @return total_hemoglobin_conc_min
     */
    var totalHemoglobinConcMin: Float?
        get() {
            return getFieldFloatValue(55, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalHemoglobinConcMin) {
            setFieldValue(55, 0, totalHemoglobinConcMin, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_hemoglobin_conc_max field
     * Units: g/dL
     * Comment: Max saturated and unsaturated hemoglobin
     *
     * @return total_hemoglobin_conc_max
     */
    var totalHemoglobinConcMax: Float?
        get() {
            return getFieldFloatValue(56, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalHemoglobinConcMax) {
            setFieldValue(56, 0, totalHemoglobinConcMax, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get saturated_hemoglobin_percent field
     * Units: %
     * Comment: Percentage of hemoglobin saturated with oxygen
     *
     * @return saturated_hemoglobin_percent
     */
    var saturatedHemoglobinPercent: Float?
        get() {
            return getFieldFloatValue(57, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(saturatedHemoglobinPercent) {
            setFieldValue(57, 0, saturatedHemoglobinPercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get saturated_hemoglobin_percent_min field
     * Units: %
     * Comment: Min percentage of hemoglobin saturated with oxygen
     *
     * @return saturated_hemoglobin_percent_min
     */
    var saturatedHemoglobinPercentMin: Float?
        get() {
            return getFieldFloatValue(58, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(saturatedHemoglobinPercentMin) {
            setFieldValue(58, 0, saturatedHemoglobinPercentMin, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get saturated_hemoglobin_percent_max field
     * Units: %
     * Comment: Max percentage of hemoglobin saturated with oxygen
     *
     * @return saturated_hemoglobin_percent_max
     */
    var saturatedHemoglobinPercentMax: Float?
        get() {
            return getFieldFloatValue(59, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(saturatedHemoglobinPercentMax) {
            setFieldValue(59, 0, saturatedHemoglobinPercentMax, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    var deviceIndex: Short?
        get() {
            return getFieldShortValue(62, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(deviceIndex) {
            setFieldValue(62, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get left_pco field
     * Units: mm
     * Comment: Left platform center offset
     *
     * @return left_pco
     */
    var leftPco: Byte?
        get() {
            return getFieldByteValue(67, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(leftPco) {
            setFieldValue(67, 0, leftPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get right_pco field
     * Units: mm
     * Comment: Right platform center offset
     *
     * @return right_pco
     */
    var rightPco: Byte?
        get() {
            return getFieldByteValue(68, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rightPco) {
            setFieldValue(68, 0, rightPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getLeftPowerPhase(): Array<Float?>? {
        return getFieldFloatValues(69, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of left_power_phase
     */
    fun getNumLeftPowerPhase(): Int {
        return getNumFieldValues(69, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get left_power_phase field
     * Units: degrees
     * Comment: Left power phase angles. Data value indexes defined by power_phase_type.
     *
     * @param index of left_power_phase
     * @return left_power_phase
     */
    fun getLeftPowerPhase(index: Int): Float? {
        return getFieldFloatValue(69, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set left_power_phase field
     * Units: degrees
     * Comment: Left power phase angles. Data value indexes defined by power_phase_type.
     *
     * @param index of left_power_phase
     * @param leftPowerPhase The new leftPowerPhase value to be set
     */
    fun setLeftPowerPhase(index: Int, leftPowerPhase: Float?) {
        setFieldValue(69, index, leftPowerPhase, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getLeftPowerPhasePeak(): Array<Float?>? {
        return getFieldFloatValues(70, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of left_power_phase_peak
     */
    fun getNumLeftPowerPhasePeak(): Int {
        return getNumFieldValues(70, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get left_power_phase_peak field
     * Units: degrees
     * Comment: Left power phase peak angles. Data value indexes defined by power_phase_type.
     *
     * @param index of left_power_phase_peak
     * @return left_power_phase_peak
     */
    fun getLeftPowerPhasePeak(index: Int): Float? {
        return getFieldFloatValue(70, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set left_power_phase_peak field
     * Units: degrees
     * Comment: Left power phase peak angles. Data value indexes defined by power_phase_type.
     *
     * @param index of left_power_phase_peak
     * @param leftPowerPhasePeak The new leftPowerPhasePeak value to be set
     */
    fun setLeftPowerPhasePeak(index: Int, leftPowerPhasePeak: Float?) {
        setFieldValue(70, index, leftPowerPhasePeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getRightPowerPhase(): Array<Float?>? {
        return getFieldFloatValues(71, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of right_power_phase
     */
    fun getNumRightPowerPhase(): Int {
        return getNumFieldValues(71, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get right_power_phase field
     * Units: degrees
     * Comment: Right power phase angles. Data value indexes defined by power_phase_type.
     *
     * @param index of right_power_phase
     * @return right_power_phase
     */
    fun getRightPowerPhase(index: Int): Float? {
        return getFieldFloatValue(71, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set right_power_phase field
     * Units: degrees
     * Comment: Right power phase angles. Data value indexes defined by power_phase_type.
     *
     * @param index of right_power_phase
     * @param rightPowerPhase The new rightPowerPhase value to be set
     */
    fun setRightPowerPhase(index: Int, rightPowerPhase: Float?) {
        setFieldValue(71, index, rightPowerPhase, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getRightPowerPhasePeak(): Array<Float?>? {
        return getFieldFloatValues(72, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of right_power_phase_peak
     */
    fun getNumRightPowerPhasePeak(): Int {
        return getNumFieldValues(72, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get right_power_phase_peak field
     * Units: degrees
     * Comment: Right power phase peak angles. Data value indexes defined by power_phase_type.
     *
     * @param index of right_power_phase_peak
     * @return right_power_phase_peak
     */
    fun getRightPowerPhasePeak(index: Int): Float? {
        return getFieldFloatValue(72, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set right_power_phase_peak field
     * Units: degrees
     * Comment: Right power phase peak angles. Data value indexes defined by power_phase_type.
     *
     * @param index of right_power_phase_peak
     * @param rightPowerPhasePeak The new rightPowerPhasePeak value to be set
     */
    fun setRightPowerPhasePeak(index: Int, rightPowerPhasePeak: Float?) {
        setFieldValue(72, index, rightPowerPhasePeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_speed field
     * Units: m/s
     *
     * @return enhanced_speed
     */
    var enhancedSpeed: Float?
        get() {
            return getFieldFloatValue(73, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedSpeed) {
            setFieldValue(73, 0, enhancedSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_altitude field
     * Units: m
     *
     * @return enhanced_altitude
     */
    var enhancedAltitude: Float?
        get() {
            return getFieldFloatValue(78, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedAltitude) {
            setFieldValue(78, 0, enhancedAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get battery_soc field
     * Units: percent
     * Comment: lev battery state of charge
     *
     * @return battery_soc
     */
    var batterySoc: Float?
        get() {
            return getFieldFloatValue(81, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(batterySoc) {
            setFieldValue(81, 0, batterySoc, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get motor_power field
     * Units: watts
     * Comment: lev motor power
     *
     * @return motor_power
     */
    var motorPower: Int?
        get() {
            return getFieldIntegerValue(82, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(motorPower) {
            setFieldValue(82, 0, motorPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get vertical_ratio field
     * Units: percent
     *
     * @return vertical_ratio
     */
    var verticalRatio: Float?
        get() {
            return getFieldFloatValue(83, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(verticalRatio) {
            setFieldValue(83, 0, verticalRatio, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get stance_time_balance field
     * Units: percent
     *
     * @return stance_time_balance
     */
    var stanceTimeBalance: Float?
        get() {
            return getFieldFloatValue(84, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(stanceTimeBalance) {
            setFieldValue(84, 0, stanceTimeBalance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get step_length field
     * Units: mm
     *
     * @return step_length
     */
    var stepLength: Float?
        get() {
            return getFieldFloatValue(85, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(stepLength) {
            setFieldValue(85, 0, stepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cycle_length16 field
     * Units: m
     * Comment: Supports larger cycle sizes needed for paddlesports. Max cycle size: 655.35
     *
     * @return cycle_length16
     */
    var cycleLength16: Float?
        get() {
            return getFieldFloatValue(87, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cycleLength16) {
            setFieldValue(87, 0, cycleLength16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get absolute_pressure field
     * Units: Pa
     * Comment: Includes atmospheric pressure
     *
     * @return absolute_pressure
     */
    var absolutePressure: Long?
        get() {
            return getFieldLongValue(91, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(absolutePressure) {
            setFieldValue(91, 0, absolutePressure, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return depth
     */
    var depth: Float?
        get() {
            return getFieldFloatValue(92, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(depth) {
            setFieldValue(92, 0, depth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get next_stop_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return next_stop_depth
     */
    var nextStopDepth: Float?
        get() {
            return getFieldFloatValue(93, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(nextStopDepth) {
            setFieldValue(93, 0, nextStopDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get next_stop_time field
     * Units: s
     *
     * @return next_stop_time
     */
    var nextStopTime: Long?
        get() {
            return getFieldLongValue(94, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(nextStopTime) {
            setFieldValue(94, 0, nextStopTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get time_to_surface field
     * Units: s
     *
     * @return time_to_surface
     */
    var timeToSurface: Long?
        get() {
            return getFieldLongValue(95, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timeToSurface) {
            setFieldValue(95, 0, timeToSurface, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ndl_time field
     * Units: s
     *
     * @return ndl_time
     */
    var ndlTime: Long?
        get() {
            return getFieldLongValue(96, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ndlTime) {
            setFieldValue(96, 0, ndlTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cns_load field
     * Units: percent
     *
     * @return cns_load
     */
    var cnsLoad: Short?
        get() {
            return getFieldShortValue(97, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cnsLoad) {
            setFieldValue(97, 0, cnsLoad, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get n2_load field
     * Units: percent
     *
     * @return n2_load
     */
    var n2Load: Int?
        get() {
            return getFieldIntegerValue(98, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(n2Load) {
            setFieldValue(98, 0, n2Load, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get respiration_rate field
     * Units: s
     *
     * @return respiration_rate
     */
    var respirationRate: Short?
        get() {
            return getFieldShortValue(99, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(respirationRate) {
            setFieldValue(99, 0, respirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_respiration_rate field
     * Units: Breaths/min
     *
     * @return enhanced_respiration_rate
     */
    var enhancedRespirationRate: Float?
        get() {
            return getFieldFloatValue(108, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedRespirationRate) {
            setFieldValue(108, 0, enhancedRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get grit field
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @return grit
     */
    var grit: Float?
        get() {
            return getFieldFloatValue(114, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(grit) {
            setFieldValue(114, 0, grit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get flow field
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @return flow
     */
    var flow: Float?
        get() {
            return getFieldFloatValue(115, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(flow) {
            setFieldValue(115, 0, flow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get current_stress field
     * Comment: Current Stress value
     *
     * @return current_stress
     */
    var currentStress: Float?
        get() {
            return getFieldFloatValue(116, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(currentStress) {
            setFieldValue(116, 0, currentStress, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ebike_travel_range field
     * Units: km
     *
     * @return ebike_travel_range
     */
    var ebikeTravelRange: Int?
        get() {
            return getFieldIntegerValue(117, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ebikeTravelRange) {
            setFieldValue(117, 0, ebikeTravelRange, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ebike_battery_level field
     * Units: percent
     *
     * @return ebike_battery_level
     */
    var ebikeBatteryLevel: Short?
        get() {
            return getFieldShortValue(118, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ebikeBatteryLevel) {
            setFieldValue(118, 0, ebikeBatteryLevel, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ebike_assist_mode field
     * Units: depends on sensor
     *
     * @return ebike_assist_mode
     */
    var ebikeAssistMode: Short?
        get() {
            return getFieldShortValue(119, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ebikeAssistMode) {
            setFieldValue(119, 0, ebikeAssistMode, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ebike_assist_level_percent field
     * Units: percent
     *
     * @return ebike_assist_level_percent
     */
    var ebikeAssistLevelPercent: Short?
        get() {
            return getFieldShortValue(120, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ebikeAssistLevelPercent) {
            setFieldValue(120, 0, ebikeAssistLevelPercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get air_time_remaining field
     * Units: s
     *
     * @return air_time_remaining
     */
    var airTimeRemaining: Long?
        get() {
            return getFieldLongValue(123, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(airTimeRemaining) {
            setFieldValue(123, 0, airTimeRemaining, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get pressure_sac field
     * Units: bar/min
     * Comment: Pressure-based surface air consumption
     *
     * @return pressure_sac
     */
    var pressureSac: Float?
        get() {
            return getFieldFloatValue(124, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(pressureSac) {
            setFieldValue(124, 0, pressureSac, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get volume_sac field
     * Units: L/min
     * Comment: Volumetric surface air consumption
     *
     * @return volume_sac
     */
    var volumeSac: Float?
        get() {
            return getFieldFloatValue(125, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(volumeSac) {
            setFieldValue(125, 0, volumeSac, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get rmv field
     * Units: L/min
     * Comment: Respiratory minute volume
     *
     * @return rmv
     */
    var rmv: Float?
        get() {
            return getFieldFloatValue(126, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rmv) {
            setFieldValue(126, 0, rmv, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ascent_rate field
     * Units: m/s
     *
     * @return ascent_rate
     */
    var ascentRate: Float?
        get() {
            return getFieldFloatValue(127, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ascentRate) {
            setFieldValue(127, 0, ascentRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get po2 field
     * Units: percent
     * Comment: Current partial pressure of oxygen
     *
     * @return po2
     */
    var po2: Float?
        get() {
            return getFieldFloatValue(129, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(po2) {
            setFieldValue(129, 0, po2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get core_temperature field
     * Units: C
     *
     * @return core_temperature
     */
    var coreTemperature: Float?
        get() {
            return getFieldFloatValue(139, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(coreTemperature) {
            setFieldValue(139, 0, coreTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
