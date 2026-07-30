/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentLapMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class SegmentLapMesg : Mesg, MesgWithEvent {

    companion object {
        const val MessageIndexFieldNum = 254
        const val TimestampFieldNum = 253
        const val EventFieldNum = 0
        const val EventTypeFieldNum = 1
        const val StartTimeFieldNum = 2
        const val StartPositionLatFieldNum = 3
        const val StartPositionLongFieldNum = 4
        const val EndPositionLatFieldNum = 5
        const val EndPositionLongFieldNum = 6
        const val TotalElapsedTimeFieldNum = 7
        const val TotalTimerTimeFieldNum = 8
        const val TotalDistanceFieldNum = 9
        const val TotalCyclesFieldNum = 10
        const val TotalCaloriesFieldNum = 11
        const val TotalFatCaloriesFieldNum = 12
        const val AvgSpeedFieldNum = 13
        const val MaxSpeedFieldNum = 14
        const val AvgHeartRateFieldNum = 15
        const val MaxHeartRateFieldNum = 16
        const val AvgCadenceFieldNum = 17
        const val MaxCadenceFieldNum = 18
        const val AvgPowerFieldNum = 19
        const val MaxPowerFieldNum = 20
        const val TotalAscentFieldNum = 21
        const val TotalDescentFieldNum = 22
        const val SportFieldNum = 23
        const val EventGroupFieldNum = 24
        const val NecLatFieldNum = 25
        const val NecLongFieldNum = 26
        const val SwcLatFieldNum = 27
        const val SwcLongFieldNum = 28
        const val NameFieldNum = 29
        const val NormalizedPowerFieldNum = 30
        const val LeftRightBalanceFieldNum = 31
        const val SubSportFieldNum = 32
        const val TotalWorkFieldNum = 33
        const val AvgAltitudeFieldNum = 34
        const val MaxAltitudeFieldNum = 35
        const val GpsAccuracyFieldNum = 36
        const val AvgGradeFieldNum = 37
        const val AvgPosGradeFieldNum = 38
        const val AvgNegGradeFieldNum = 39
        const val MaxPosGradeFieldNum = 40
        const val MaxNegGradeFieldNum = 41
        const val AvgTemperatureFieldNum = 42
        const val MaxTemperatureFieldNum = 43
        const val TotalMovingTimeFieldNum = 44
        const val AvgPosVerticalSpeedFieldNum = 45
        const val AvgNegVerticalSpeedFieldNum = 46
        const val MaxPosVerticalSpeedFieldNum = 47
        const val MaxNegVerticalSpeedFieldNum = 48
        const val TimeInHrZoneFieldNum = 49
        const val TimeInSpeedZoneFieldNum = 50
        const val TimeInCadenceZoneFieldNum = 51
        const val TimeInPowerZoneFieldNum = 52
        const val RepetitionNumFieldNum = 53
        const val MinAltitudeFieldNum = 54
        const val MinHeartRateFieldNum = 55
        const val ActiveTimeFieldNum = 56
        const val WktStepIndexFieldNum = 57
        const val SportEventFieldNum = 58
        const val AvgLeftTorqueEffectivenessFieldNum = 59
        const val AvgRightTorqueEffectivenessFieldNum = 60
        const val AvgLeftPedalSmoothnessFieldNum = 61
        const val AvgRightPedalSmoothnessFieldNum = 62
        const val AvgCombinedPedalSmoothnessFieldNum = 63
        const val StatusFieldNum = 64
        const val UuidFieldNum = 65
        const val AvgFractionalCadenceFieldNum = 66
        const val MaxFractionalCadenceFieldNum = 67
        const val TotalFractionalCyclesFieldNum = 68
        const val FrontGearShiftCountFieldNum = 69
        const val RearGearShiftCountFieldNum = 70
        const val TimeStandingFieldNum = 71
        const val StandCountFieldNum = 72
        const val AvgLeftPcoFieldNum = 73
        const val AvgRightPcoFieldNum = 74
        const val AvgLeftPowerPhaseFieldNum = 75
        const val AvgLeftPowerPhasePeakFieldNum = 76
        const val AvgRightPowerPhaseFieldNum = 77
        const val AvgRightPowerPhasePeakFieldNum = 78
        const val AvgPowerPositionFieldNum = 79
        const val MaxPowerPositionFieldNum = 80
        const val AvgCadencePositionFieldNum = 81
        const val MaxCadencePositionFieldNum = 82
        const val ManufacturerFieldNum = 83
        const val TotalGritFieldNum = 84
        const val TotalFlowFieldNum = 85
        const val AvgGritFieldNum = 86
        const val AvgFlowFieldNum = 87
        const val TotalFractionalAscentFieldNum = 89
        const val TotalFractionalDescentFieldNum = 90
        const val EnhancedAvgAltitudeFieldNum = 91
        const val EnhancedMaxAltitudeFieldNum = 92
        const val EnhancedMinAltitudeFieldNum = 93

        val segmentLapMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // segment_lap
            val segmentLapMesg = Mesg("segment_lap", MesgNum.SEGMENT_LAP)
            segmentLapMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            segmentLapMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            segmentLapMesg.addField(Field("event", EventFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT))
            field_index++
            segmentLapMesg.addField(Field("event_type", EventTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT_TYPE))
            field_index++
            segmentLapMesg.addField(Field("start_time", StartTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            segmentLapMesg.addField(Field("start_position_lat", StartPositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentLapMesg.addField(Field("start_position_long", StartPositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentLapMesg.addField(Field("end_position_lat", EndPositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentLapMesg.addField(Field("end_position_long", EndPositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentLapMesg.addField(Field("total_elapsed_time", TotalElapsedTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("total_timer_time", TotalTimerTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("total_distance", TotalDistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("total_cycles", TotalCyclesFieldNum, 134, 1.0, 0.0, "cycles", false, Profile.Type.UINT32))
            subfield_index = 0
            segmentLapMesg.fields[field_index].subFields.add(SubField("total_strokes", 134, 1.0, 0.0, "strokes"))
            segmentLapMesg.fields[field_index].subFields[subfield_index].addMap(23, 2L)
            subfield_index++
            field_index++
            segmentLapMesg.addField(Field("total_calories", TotalCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("total_fat_calories", TotalFatCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("avg_speed", AvgSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("max_speed", MaxSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("avg_heart_rate", AvgHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("max_heart_rate", MaxHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_cadence", AvgCadenceFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("max_cadence", MaxCadenceFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_power", AvgPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("max_power", MaxPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("total_ascent", TotalAscentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("total_descent", TotalDescentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            field_index++
            segmentLapMesg.addField(Field("event_group", EventGroupFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("nec_lat", NecLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentLapMesg.addField(Field("nec_long", NecLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentLapMesg.addField(Field("swc_lat", SwcLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentLapMesg.addField(Field("swc_long", SwcLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentLapMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            segmentLapMesg.addField(Field("normalized_power", NormalizedPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("left_right_balance", LeftRightBalanceFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.LEFT_RIGHT_BALANCE_100))
            field_index++
            segmentLapMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            field_index++
            segmentLapMesg.addField(Field("total_work", TotalWorkFieldNum, 134, 1.0, 0.0, "J", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("avg_altitude", AvgAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            segmentLapMesg.fields[field_index].components.add(FieldComponent(91, false, 16, 5.0, 500.0)) // enhanced_avg_altitude
            field_index++
            segmentLapMesg.addField(Field("max_altitude", MaxAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            segmentLapMesg.fields[field_index].components.add(FieldComponent(92, false, 16, 5.0, 500.0)) // enhanced_max_altitude
            field_index++
            segmentLapMesg.addField(Field("gps_accuracy", GpsAccuracyFieldNum, 2, 1.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_grade", AvgGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("avg_pos_grade", AvgPosGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("avg_neg_grade", AvgNegGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("max_pos_grade", MaxPosGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("max_neg_grade", MaxNegGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("avg_temperature", AvgTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            segmentLapMesg.addField(Field("max_temperature", MaxTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            segmentLapMesg.addField(Field("total_moving_time", TotalMovingTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("avg_pos_vertical_speed", AvgPosVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("avg_neg_vertical_speed", AvgNegVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("max_pos_vertical_speed", MaxPosVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("max_neg_vertical_speed", MaxNegVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            segmentLapMesg.addField(Field("time_in_hr_zone", TimeInHrZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("time_in_speed_zone", TimeInSpeedZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("time_in_cadence_zone", TimeInCadenceZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("time_in_power_zone", TimeInPowerZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("repetition_num", RepetitionNumFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("min_altitude", MinAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            segmentLapMesg.fields[field_index].components.add(FieldComponent(93, false, 16, 5.0, 500.0)) // enhanced_min_altitude
            field_index++
            segmentLapMesg.addField(Field("min_heart_rate", MinHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("active_time", ActiveTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("wkt_step_index", WktStepIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            segmentLapMesg.addField(Field("sport_event", SportEventFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT_EVENT))
            field_index++
            segmentLapMesg.addField(Field("avg_left_torque_effectiveness", AvgLeftTorqueEffectivenessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_right_torque_effectiveness", AvgRightTorqueEffectivenessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_left_pedal_smoothness", AvgLeftPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_right_pedal_smoothness", AvgRightPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_combined_pedal_smoothness", AvgCombinedPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("status", StatusFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SEGMENT_LAP_STATUS))
            field_index++
            segmentLapMesg.addField(Field("uuid", UuidFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            segmentLapMesg.addField(Field("avg_fractional_cadence", AvgFractionalCadenceFieldNum, 2, 128.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("max_fractional_cadence", MaxFractionalCadenceFieldNum, 2, 128.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("total_fractional_cycles", TotalFractionalCyclesFieldNum, 2, 128.0, 0.0, "cycles", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("front_gear_shift_count", FrontGearShiftCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("rear_gear_shift_count", RearGearShiftCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("time_standing", TimeStandingFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("stand_count", StandCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("avg_left_pco", AvgLeftPcoFieldNum, 1, 1.0, 0.0, "mm", false, Profile.Type.SINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_right_pco", AvgRightPcoFieldNum, 1, 1.0, 0.0, "mm", false, Profile.Type.SINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_left_power_phase", AvgLeftPowerPhaseFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_left_power_phase_peak", AvgLeftPowerPhasePeakFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_right_power_phase", AvgRightPowerPhaseFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_right_power_phase_peak", AvgRightPowerPhasePeakFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("avg_power_position", AvgPowerPositionFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("max_power_position", MaxPowerPositionFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            segmentLapMesg.addField(Field("avg_cadence_position", AvgCadencePositionFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("max_cadence_position", MaxCadencePositionFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("manufacturer", ManufacturerFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MANUFACTURER))
            field_index++
            segmentLapMesg.addField(Field("total_grit", TotalGritFieldNum, 136, 1.0, 0.0, "kGrit", false, Profile.Type.FLOAT32))
            field_index++
            segmentLapMesg.addField(Field("total_flow", TotalFlowFieldNum, 136, 1.0, 0.0, "Flow", false, Profile.Type.FLOAT32))
            field_index++
            segmentLapMesg.addField(Field("avg_grit", AvgGritFieldNum, 136, 1.0, 0.0, "kGrit", false, Profile.Type.FLOAT32))
            field_index++
            segmentLapMesg.addField(Field("avg_flow", AvgFlowFieldNum, 136, 1.0, 0.0, "Flow", false, Profile.Type.FLOAT32))
            field_index++
            segmentLapMesg.addField(Field("total_fractional_ascent", TotalFractionalAscentFieldNum, 2, 100.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("total_fractional_descent", TotalFractionalDescentFieldNum, 2, 100.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            segmentLapMesg.addField(Field("enhanced_avg_altitude", EnhancedAvgAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("enhanced_max_altitude", EnhancedMaxAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg.addField(Field("enhanced_min_altitude", EnhancedMinAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            segmentLapMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SEGMENT_LAP))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     *
     * @return message_index
     */
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    override var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event field
     *
     * @return event
     */
    override var event: Event?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Event.fromValue(value)
        }
        set(event) {
            setFieldValue(0, 0, event?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event_type field
     *
     * @return event_type
     */
    override var eventType: EventType?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return EventType.fromValue(value)
        }
        set(eventType) {
            setFieldValue(1, 0, eventType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_time field
     *
     * @return start_time
     */
    var startTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(startTime) {
            setFieldValue(2, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_position_lat field
     * Units: semicircles
     *
     * @return start_position_lat
     */
    var startPositionLat: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startPositionLat) {
            setFieldValue(3, 0, startPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_position_long field
     * Units: semicircles
     *
     * @return start_position_long
     */
    var startPositionLong: Int?
        get() {
            return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startPositionLong) {
            setFieldValue(4, 0, startPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_position_lat field
     * Units: semicircles
     *
     * @return end_position_lat
     */
    var endPositionLat: Int?
        get() {
            return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(endPositionLat) {
            setFieldValue(5, 0, endPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_position_long field
     * Units: semicircles
     *
     * @return end_position_long
     */
    var endPositionLong: Int?
        get() {
            return getFieldIntegerValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(endPositionLong) {
            setFieldValue(6, 0, endPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_elapsed_time field
     * Units: s
     * Comment: Time (includes pauses)
     *
     * @return total_elapsed_time
     */
    var totalElapsedTime: Float?
        get() {
            return getFieldFloatValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalElapsedTime) {
            setFieldValue(7, 0, totalElapsedTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_timer_time field
     * Units: s
     * Comment: Timer Time (excludes pauses)
     *
     * @return total_timer_time
     */
    var totalTimerTime: Float?
        get() {
            return getFieldFloatValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalTimerTime) {
            setFieldValue(8, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_distance field
     * Units: m
     *
     * @return total_distance
     */
    var totalDistance: Float?
        get() {
            return getFieldFloatValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalDistance) {
            setFieldValue(9, 0, totalDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_cycles field
     * Units: cycles
     *
     * @return total_cycles
     */
    var totalCycles: Long?
        get() {
            return getFieldLongValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalCycles) {
            setFieldValue(10, 0, totalCycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_strokes field
     * Units: strokes
     *
     * @return total_strokes
     */
    var totalStrokes: Long?
        get() {
            return getFieldLongValue(10, 0, Profile.SubFields.SEGMENT_LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES)
        }
        set(totalStrokes) {
            setFieldValue(10, 0, totalStrokes, Profile.SubFields.SEGMENT_LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES)
        }

    /**
     * Get total_calories field
     * Units: kcal
     *
     * @return total_calories
     */
    var totalCalories: Int?
        get() {
            return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalCalories) {
            setFieldValue(11, 0, totalCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_fat_calories field
     * Units: kcal
     * Comment: If New Leaf
     *
     * @return total_fat_calories
     */
    var totalFatCalories: Int?
        get() {
            return getFieldIntegerValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFatCalories) {
            setFieldValue(12, 0, totalFatCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    var avgSpeed: Float?
        get() {
            return getFieldFloatValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgSpeed) {
            setFieldValue(13, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_speed field
     * Units: m/s
     *
     * @return max_speed
     */
    var maxSpeed: Float?
        get() {
            return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxSpeed) {
            setFieldValue(14, 0, maxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_heart_rate field
     * Units: bpm
     *
     * @return avg_heart_rate
     */
    var avgHeartRate: Short?
        get() {
            return getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgHeartRate) {
            setFieldValue(15, 0, avgHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_heart_rate field
     * Units: bpm
     *
     * @return max_heart_rate
     */
    var maxHeartRate: Short?
        get() {
            return getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxHeartRate) {
            setFieldValue(16, 0, maxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_cadence field
     * Units: rpm
     * Comment: total_cycles / total_timer_time if non_zero_avg_cadence otherwise total_cycles / total_elapsed_time
     *
     * @return avg_cadence
     */
    var avgCadence: Short?
        get() {
            return getFieldShortValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgCadence) {
            setFieldValue(17, 0, avgCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_cadence field
     * Units: rpm
     *
     * @return max_cadence
     */
    var maxCadence: Short?
        get() {
            return getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxCadence) {
            setFieldValue(18, 0, maxCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_power field
     * Units: watts
     * Comment: total_power / total_timer_time if non_zero_avg_power otherwise total_power / total_elapsed_time
     *
     * @return avg_power
     */
    var avgPower: Int?
        get() {
            return getFieldIntegerValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgPower) {
            setFieldValue(19, 0, avgPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_power field
     * Units: watts
     *
     * @return max_power
     */
    var maxPower: Int?
        get() {
            return getFieldIntegerValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxPower) {
            setFieldValue(20, 0, maxPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_ascent field
     * Units: m
     *
     * @return total_ascent
     */
    var totalAscent: Int?
        get() {
            return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalAscent) {
            setFieldValue(21, 0, totalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_descent field
     * Units: m
     *
     * @return total_descent
     */
    var totalDescent: Int?
        get() {
            return getFieldIntegerValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalDescent) {
            setFieldValue(22, 0, totalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sport field
     *
     * @return sport
     */
    var sport: Sport?
        get() {
            val value = getFieldShortValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Sport.fromValue(value)
        }
        set(sport) {
            setFieldValue(23, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override var eventGroup: Short?
        get() {
            return getFieldShortValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(eventGroup) {
            setFieldValue(24, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get nec_lat field
     * Units: semicircles
     * Comment: North east corner latitude.
     *
     * @return nec_lat
     */
    var necLat: Int?
        get() {
            return getFieldIntegerValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(necLat) {
            setFieldValue(25, 0, necLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get nec_long field
     * Units: semicircles
     * Comment: North east corner longitude.
     *
     * @return nec_long
     */
    var necLong: Int?
        get() {
            return getFieldIntegerValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(necLong) {
            setFieldValue(26, 0, necLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get swc_lat field
     * Units: semicircles
     * Comment: South west corner latitude.
     *
     * @return swc_lat
     */
    var swcLat: Int?
        get() {
            return getFieldIntegerValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(swcLat) {
            setFieldValue(27, 0, swcLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get swc_long field
     * Units: semicircles
     * Comment: South west corner latitude.
     *
     * @return swc_long
     */
    var swcLong: Int?
        get() {
            return getFieldIntegerValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(swcLong) {
            setFieldValue(28, 0, swcLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(29, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get normalized_power field
     * Units: watts
     *
     * @return normalized_power
     */
    var normalizedPower: Int?
        get() {
            return getFieldIntegerValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(normalizedPower) {
            setFieldValue(30, 0, normalizedPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get left_right_balance field
     *
     * @return left_right_balance
     */
    var leftRightBalance: Int?
        get() {
            return getFieldIntegerValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(leftRightBalance) {
            setFieldValue(31, 0, leftRightBalance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    var subSport: SubSport?
        get() {
            val value = getFieldShortValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SubSport.fromValue(value)
        }
        set(subSport) {
            setFieldValue(32, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_work field
     * Units: J
     *
     * @return total_work
     */
    var totalWork: Long?
        get() {
            return getFieldLongValue(33, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalWork) {
            setFieldValue(33, 0, totalWork, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_altitude field
     * Units: m
     *
     * @return avg_altitude
     */
    var avgAltitude: Float?
        get() {
            return getFieldFloatValue(34, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgAltitude) {
            setFieldValue(34, 0, avgAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_altitude field
     * Units: m
     *
     * @return max_altitude
     */
    var maxAltitude: Float?
        get() {
            return getFieldFloatValue(35, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxAltitude) {
            setFieldValue(35, 0, maxAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get gps_accuracy field
     * Units: m
     *
     * @return gps_accuracy
     */
    var gpsAccuracy: Short?
        get() {
            return getFieldShortValue(36, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(gpsAccuracy) {
            setFieldValue(36, 0, gpsAccuracy, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_grade field
     * Units: %
     *
     * @return avg_grade
     */
    var avgGrade: Float?
        get() {
            return getFieldFloatValue(37, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgGrade) {
            setFieldValue(37, 0, avgGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_pos_grade field
     * Units: %
     *
     * @return avg_pos_grade
     */
    var avgPosGrade: Float?
        get() {
            return getFieldFloatValue(38, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgPosGrade) {
            setFieldValue(38, 0, avgPosGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_neg_grade field
     * Units: %
     *
     * @return avg_neg_grade
     */
    var avgNegGrade: Float?
        get() {
            return getFieldFloatValue(39, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgNegGrade) {
            setFieldValue(39, 0, avgNegGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_pos_grade field
     * Units: %
     *
     * @return max_pos_grade
     */
    var maxPosGrade: Float?
        get() {
            return getFieldFloatValue(40, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxPosGrade) {
            setFieldValue(40, 0, maxPosGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_neg_grade field
     * Units: %
     *
     * @return max_neg_grade
     */
    var maxNegGrade: Float?
        get() {
            return getFieldFloatValue(41, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxNegGrade) {
            setFieldValue(41, 0, maxNegGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_temperature field
     * Units: C
     *
     * @return avg_temperature
     */
    var avgTemperature: Byte?
        get() {
            return getFieldByteValue(42, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgTemperature) {
            setFieldValue(42, 0, avgTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_temperature field
     * Units: C
     *
     * @return max_temperature
     */
    var maxTemperature: Byte?
        get() {
            return getFieldByteValue(43, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxTemperature) {
            setFieldValue(43, 0, maxTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_moving_time field
     * Units: s
     *
     * @return total_moving_time
     */
    var totalMovingTime: Float?
        get() {
            return getFieldFloatValue(44, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalMovingTime) {
            setFieldValue(44, 0, totalMovingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_pos_vertical_speed field
     * Units: m/s
     *
     * @return avg_pos_vertical_speed
     */
    var avgPosVerticalSpeed: Float?
        get() {
            return getFieldFloatValue(45, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgPosVerticalSpeed) {
            setFieldValue(45, 0, avgPosVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_neg_vertical_speed field
     * Units: m/s
     *
     * @return avg_neg_vertical_speed
     */
    var avgNegVerticalSpeed: Float?
        get() {
            return getFieldFloatValue(46, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgNegVerticalSpeed) {
            setFieldValue(46, 0, avgNegVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_pos_vertical_speed field
     * Units: m/s
     *
     * @return max_pos_vertical_speed
     */
    var maxPosVerticalSpeed: Float?
        get() {
            return getFieldFloatValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxPosVerticalSpeed) {
            setFieldValue(47, 0, maxPosVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_neg_vertical_speed field
     * Units: m/s
     *
     * @return max_neg_vertical_speed
     */
    var maxNegVerticalSpeed: Float?
        get() {
            return getFieldFloatValue(48, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxNegVerticalSpeed) {
            setFieldValue(48, 0, maxNegVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getTimeInHrZone(): Array<Float?>? {
        return getFieldFloatValues(49, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_hr_zone
     */
    fun getNumTimeInHrZone(): Int {
        return getNumFieldValues(49, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_hr_zone field
     * Units: s
     *
     * @param index of time_in_hr_zone
     * @return time_in_hr_zone
     */
    fun getTimeInHrZone(index: Int): Float? {
        return getFieldFloatValue(49, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_hr_zone field
     * Units: s
     *
     * @param index of time_in_hr_zone
     * @param timeInHrZone The new timeInHrZone value to be set
     */
    fun setTimeInHrZone(index: Int, timeInHrZone: Float?) {
        setFieldValue(49, index, timeInHrZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInSpeedZone(): Array<Float?>? {
        return getFieldFloatValues(50, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_speed_zone
     */
    fun getNumTimeInSpeedZone(): Int {
        return getNumFieldValues(50, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_speed_zone field
     * Units: s
     *
     * @param index of time_in_speed_zone
     * @return time_in_speed_zone
     */
    fun getTimeInSpeedZone(index: Int): Float? {
        return getFieldFloatValue(50, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_speed_zone field
     * Units: s
     *
     * @param index of time_in_speed_zone
     * @param timeInSpeedZone The new timeInSpeedZone value to be set
     */
    fun setTimeInSpeedZone(index: Int, timeInSpeedZone: Float?) {
        setFieldValue(50, index, timeInSpeedZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInCadenceZone(): Array<Float?>? {
        return getFieldFloatValues(51, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_cadence_zone
     */
    fun getNumTimeInCadenceZone(): Int {
        return getNumFieldValues(51, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_cadence_zone field
     * Units: s
     *
     * @param index of time_in_cadence_zone
     * @return time_in_cadence_zone
     */
    fun getTimeInCadenceZone(index: Int): Float? {
        return getFieldFloatValue(51, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_cadence_zone field
     * Units: s
     *
     * @param index of time_in_cadence_zone
     * @param timeInCadenceZone The new timeInCadenceZone value to be set
     */
    fun setTimeInCadenceZone(index: Int, timeInCadenceZone: Float?) {
        setFieldValue(51, index, timeInCadenceZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInPowerZone(): Array<Float?>? {
        return getFieldFloatValues(52, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_power_zone
     */
    fun getNumTimeInPowerZone(): Int {
        return getNumFieldValues(52, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_power_zone field
     * Units: s
     *
     * @param index of time_in_power_zone
     * @return time_in_power_zone
     */
    fun getTimeInPowerZone(index: Int): Float? {
        return getFieldFloatValue(52, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_power_zone field
     * Units: s
     *
     * @param index of time_in_power_zone
     * @param timeInPowerZone The new timeInPowerZone value to be set
     */
    fun setTimeInPowerZone(index: Int, timeInPowerZone: Float?) {
        setFieldValue(52, index, timeInPowerZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get repetition_num field
     *
     * @return repetition_num
     */
    var repetitionNum: Int?
        get() {
            return getFieldIntegerValue(53, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(repetitionNum) {
            setFieldValue(53, 0, repetitionNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get min_altitude field
     * Units: m
     *
     * @return min_altitude
     */
    var minAltitude: Float?
        get() {
            return getFieldFloatValue(54, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(minAltitude) {
            setFieldValue(54, 0, minAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get min_heart_rate field
     * Units: bpm
     *
     * @return min_heart_rate
     */
    var minHeartRate: Short?
        get() {
            return getFieldShortValue(55, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(minHeartRate) {
            setFieldValue(55, 0, minHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get active_time field
     * Units: s
     *
     * @return active_time
     */
    var activeTime: Float?
        get() {
            return getFieldFloatValue(56, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activeTime) {
            setFieldValue(56, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get wkt_step_index field
     *
     * @return wkt_step_index
     */
    var wktStepIndex: Int?
        get() {
            return getFieldIntegerValue(57, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(wktStepIndex) {
            setFieldValue(57, 0, wktStepIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sport_event field
     *
     * @return sport_event
     */
    var sportEvent: SportEvent?
        get() {
            val value = getFieldShortValue(58, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SportEvent.fromValue(value)
        }
        set(sportEvent) {
            setFieldValue(58, 0, sportEvent?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_left_torque_effectiveness field
     * Units: percent
     *
     * @return avg_left_torque_effectiveness
     */
    var avgLeftTorqueEffectiveness: Float?
        get() {
            return getFieldFloatValue(59, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgLeftTorqueEffectiveness) {
            setFieldValue(59, 0, avgLeftTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_right_torque_effectiveness field
     * Units: percent
     *
     * @return avg_right_torque_effectiveness
     */
    var avgRightTorqueEffectiveness: Float?
        get() {
            return getFieldFloatValue(60, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRightTorqueEffectiveness) {
            setFieldValue(60, 0, avgRightTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_left_pedal_smoothness field
     * Units: percent
     *
     * @return avg_left_pedal_smoothness
     */
    var avgLeftPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(61, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgLeftPedalSmoothness) {
            setFieldValue(61, 0, avgLeftPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_right_pedal_smoothness field
     * Units: percent
     *
     * @return avg_right_pedal_smoothness
     */
    var avgRightPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(62, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRightPedalSmoothness) {
            setFieldValue(62, 0, avgRightPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_combined_pedal_smoothness field
     * Units: percent
     *
     * @return avg_combined_pedal_smoothness
     */
    var avgCombinedPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(63, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgCombinedPedalSmoothness) {
            setFieldValue(63, 0, avgCombinedPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get status field
     *
     * @return status
     */
    var status: SegmentLapStatus?
        get() {
            val value = getFieldShortValue(64, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SegmentLapStatus.fromValue(value)
        }
        set(status) {
            setFieldValue(64, 0, status?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get uuid field
     *
     * @return uuid
     */
    var uuid: String?
        get() {
            return getFieldStringValue(65, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(uuid) {
            setFieldValue(65, 0, uuid, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the avg_cadence
     *
     * @return avg_fractional_cadence
     */
    var avgFractionalCadence: Float?
        get() {
            return getFieldFloatValue(66, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgFractionalCadence) {
            setFieldValue(66, 0, avgFractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the max_cadence
     *
     * @return max_fractional_cadence
     */
    var maxFractionalCadence: Float?
        get() {
            return getFieldFloatValue(67, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxFractionalCadence) {
            setFieldValue(67, 0, maxFractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_fractional_cycles field
     * Units: cycles
     * Comment: fractional part of the total_cycles
     *
     * @return total_fractional_cycles
     */
    var totalFractionalCycles: Float?
        get() {
            return getFieldFloatValue(68, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFractionalCycles) {
            setFieldValue(68, 0, totalFractionalCycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get front_gear_shift_count field
     *
     * @return front_gear_shift_count
     */
    var frontGearShiftCount: Int?
        get() {
            return getFieldIntegerValue(69, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(frontGearShiftCount) {
            setFieldValue(69, 0, frontGearShiftCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get rear_gear_shift_count field
     *
     * @return rear_gear_shift_count
     */
    var rearGearShiftCount: Int?
        get() {
            return getFieldIntegerValue(70, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rearGearShiftCount) {
            setFieldValue(70, 0, rearGearShiftCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get time_standing field
     * Units: s
     * Comment: Total time spent in the standing position
     *
     * @return time_standing
     */
    var timeStanding: Float?
        get() {
            return getFieldFloatValue(71, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timeStanding) {
            setFieldValue(71, 0, timeStanding, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get stand_count field
     * Comment: Number of transitions to the standing state
     *
     * @return stand_count
     */
    var standCount: Int?
        get() {
            return getFieldIntegerValue(72, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(standCount) {
            setFieldValue(72, 0, standCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_left_pco field
     * Units: mm
     * Comment: Average left platform center offset
     *
     * @return avg_left_pco
     */
    var avgLeftPco: Byte?
        get() {
            return getFieldByteValue(73, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgLeftPco) {
            setFieldValue(73, 0, avgLeftPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_right_pco field
     * Units: mm
     * Comment: Average right platform center offset
     *
     * @return avg_right_pco
     */
    var avgRightPco: Byte?
        get() {
            return getFieldByteValue(74, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRightPco) {
            setFieldValue(74, 0, avgRightPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getAvgLeftPowerPhase(): Array<Float?>? {
        return getFieldFloatValues(75, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_left_power_phase
     */
    fun getNumAvgLeftPowerPhase(): Int {
        return getNumFieldValues(75, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_power_phase field
     * Units: degrees
     * Comment: Average left power phase angles. Data value indexes defined by power_phase_type.
     *
     * @param index of avg_left_power_phase
     * @return avg_left_power_phase
     */
    fun getAvgLeftPowerPhase(index: Int): Float? {
        return getFieldFloatValue(75, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_power_phase field
     * Units: degrees
     * Comment: Average left power phase angles. Data value indexes defined by power_phase_type.
     *
     * @param index of avg_left_power_phase
     * @param avgLeftPowerPhase The new avgLeftPowerPhase value to be set
     */
    fun setAvgLeftPowerPhase(index: Int, avgLeftPowerPhase: Float?) {
        setFieldValue(75, index, avgLeftPowerPhase, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgLeftPowerPhasePeak(): Array<Float?>? {
        return getFieldFloatValues(76, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_left_power_phase_peak
     */
    fun getNumAvgLeftPowerPhasePeak(): Int {
        return getNumFieldValues(76, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_power_phase_peak field
     * Units: degrees
     * Comment: Average left power phase peak angles. Data value indexes defined by power_phase_type.
     *
     * @param index of avg_left_power_phase_peak
     * @return avg_left_power_phase_peak
     */
    fun getAvgLeftPowerPhasePeak(index: Int): Float? {
        return getFieldFloatValue(76, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_power_phase_peak field
     * Units: degrees
     * Comment: Average left power phase peak angles. Data value indexes defined by power_phase_type.
     *
     * @param index of avg_left_power_phase_peak
     * @param avgLeftPowerPhasePeak The new avgLeftPowerPhasePeak value to be set
     */
    fun setAvgLeftPowerPhasePeak(index: Int, avgLeftPowerPhasePeak: Float?) {
        setFieldValue(76, index, avgLeftPowerPhasePeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgRightPowerPhase(): Array<Float?>? {
        return getFieldFloatValues(77, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_right_power_phase
     */
    fun getNumAvgRightPowerPhase(): Int {
        return getNumFieldValues(77, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_power_phase field
     * Units: degrees
     * Comment: Average right power phase angles. Data value indexes defined by power_phase_type.
     *
     * @param index of avg_right_power_phase
     * @return avg_right_power_phase
     */
    fun getAvgRightPowerPhase(index: Int): Float? {
        return getFieldFloatValue(77, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_power_phase field
     * Units: degrees
     * Comment: Average right power phase angles. Data value indexes defined by power_phase_type.
     *
     * @param index of avg_right_power_phase
     * @param avgRightPowerPhase The new avgRightPowerPhase value to be set
     */
    fun setAvgRightPowerPhase(index: Int, avgRightPowerPhase: Float?) {
        setFieldValue(77, index, avgRightPowerPhase, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgRightPowerPhasePeak(): Array<Float?>? {
        return getFieldFloatValues(78, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_right_power_phase_peak
     */
    fun getNumAvgRightPowerPhasePeak(): Int {
        return getNumFieldValues(78, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_power_phase_peak field
     * Units: degrees
     * Comment: Average right power phase peak angles. Data value indexes defined by power_phase_type.
     *
     * @param index of avg_right_power_phase_peak
     * @return avg_right_power_phase_peak
     */
    fun getAvgRightPowerPhasePeak(index: Int): Float? {
        return getFieldFloatValue(78, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_power_phase_peak field
     * Units: degrees
     * Comment: Average right power phase peak angles. Data value indexes defined by power_phase_type.
     *
     * @param index of avg_right_power_phase_peak
     * @param avgRightPowerPhasePeak The new avgRightPowerPhasePeak value to be set
     */
    fun setAvgRightPowerPhasePeak(index: Int, avgRightPowerPhasePeak: Float?) {
        setFieldValue(78, index, avgRightPowerPhasePeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgPowerPosition(): Array<Int?>? {
        return getFieldIntegerValues(79, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_power_position
     */
    fun getNumAvgPowerPosition(): Int {
        return getNumFieldValues(79, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_power_position field
     * Units: watts
     * Comment: Average power by position. Data value indexes defined by rider_position_type.
     *
     * @param index of avg_power_position
     * @return avg_power_position
     */
    fun getAvgPowerPosition(index: Int): Int? {
        return getFieldIntegerValue(79, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_power_position field
     * Units: watts
     * Comment: Average power by position. Data value indexes defined by rider_position_type.
     *
     * @param index of avg_power_position
     * @param avgPowerPosition The new avgPowerPosition value to be set
     */
    fun setAvgPowerPosition(index: Int, avgPowerPosition: Int?) {
        setFieldValue(79, index, avgPowerPosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxPowerPosition(): Array<Int?>? {
        return getFieldIntegerValues(80, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_power_position
     */
    fun getNumMaxPowerPosition(): Int {
        return getNumFieldValues(80, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_power_position field
     * Units: watts
     * Comment: Maximum power by position. Data value indexes defined by rider_position_type.
     *
     * @param index of max_power_position
     * @return max_power_position
     */
    fun getMaxPowerPosition(index: Int): Int? {
        return getFieldIntegerValue(80, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_power_position field
     * Units: watts
     * Comment: Maximum power by position. Data value indexes defined by rider_position_type.
     *
     * @param index of max_power_position
     * @param maxPowerPosition The new maxPowerPosition value to be set
     */
    fun setMaxPowerPosition(index: Int, maxPowerPosition: Int?) {
        setFieldValue(80, index, maxPowerPosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgCadencePosition(): Array<Short?>? {
        return getFieldShortValues(81, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_cadence_position
     */
    fun getNumAvgCadencePosition(): Int {
        return getNumFieldValues(81, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_cadence_position field
     * Units: rpm
     * Comment: Average cadence by position. Data value indexes defined by rider_position_type.
     *
     * @param index of avg_cadence_position
     * @return avg_cadence_position
     */
    fun getAvgCadencePosition(index: Int): Short? {
        return getFieldShortValue(81, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_cadence_position field
     * Units: rpm
     * Comment: Average cadence by position. Data value indexes defined by rider_position_type.
     *
     * @param index of avg_cadence_position
     * @param avgCadencePosition The new avgCadencePosition value to be set
     */
    fun setAvgCadencePosition(index: Int, avgCadencePosition: Short?) {
        setFieldValue(81, index, avgCadencePosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxCadencePosition(): Array<Short?>? {
        return getFieldShortValues(82, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_cadence_position
     */
    fun getNumMaxCadencePosition(): Int {
        return getNumFieldValues(82, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_cadence_position field
     * Units: rpm
     * Comment: Maximum cadence by position. Data value indexes defined by rider_position_type.
     *
     * @param index of max_cadence_position
     * @return max_cadence_position
     */
    fun getMaxCadencePosition(index: Int): Short? {
        return getFieldShortValue(82, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_cadence_position field
     * Units: rpm
     * Comment: Maximum cadence by position. Data value indexes defined by rider_position_type.
     *
     * @param index of max_cadence_position
     * @param maxCadencePosition The new maxCadencePosition value to be set
     */
    fun setMaxCadencePosition(index: Int, maxCadencePosition: Short?) {
        setFieldValue(82, index, maxCadencePosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get manufacturer field
     * Comment: Manufacturer that produced the segment
     *
     * @return manufacturer
     */
    var manufacturer: Int?
        get() {
            return getFieldIntegerValue(83, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(manufacturer) {
            setFieldValue(83, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @return total_grit
     */
    var totalGrit: Float?
        get() {
            return getFieldFloatValue(84, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalGrit) {
            setFieldValue(84, 0, totalGrit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @return total_flow
     */
    var totalFlow: Float?
        get() {
            return getFieldFloatValue(85, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFlow) {
            setFieldValue(85, 0, totalFlow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @return avg_grit
     */
    var avgGrit: Float?
        get() {
            return getFieldFloatValue(86, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgGrit) {
            setFieldValue(86, 0, avgGrit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @return avg_flow
     */
    var avgFlow: Float?
        get() {
            return getFieldFloatValue(87, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgFlow) {
            setFieldValue(87, 0, avgFlow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_fractional_ascent field
     * Units: m
     * Comment: fractional part of total_ascent
     *
     * @return total_fractional_ascent
     */
    var totalFractionalAscent: Float?
        get() {
            return getFieldFloatValue(89, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFractionalAscent) {
            setFieldValue(89, 0, totalFractionalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_fractional_descent field
     * Units: m
     * Comment: fractional part of total_descent
     *
     * @return total_fractional_descent
     */
    var totalFractionalDescent: Float?
        get() {
            return getFieldFloatValue(90, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFractionalDescent) {
            setFieldValue(90, 0, totalFractionalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_avg_altitude field
     * Units: m
     *
     * @return enhanced_avg_altitude
     */
    var enhancedAvgAltitude: Float?
        get() {
            return getFieldFloatValue(91, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedAvgAltitude) {
            setFieldValue(91, 0, enhancedAvgAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_max_altitude field
     * Units: m
     *
     * @return enhanced_max_altitude
     */
    var enhancedMaxAltitude: Float?
        get() {
            return getFieldFloatValue(92, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedMaxAltitude) {
            setFieldValue(92, 0, enhancedMaxAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_min_altitude field
     * Units: m
     *
     * @return enhanced_min_altitude
     */
    var enhancedMinAltitude: Float?
        get() {
            return getFieldFloatValue(93, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedMinAltitude) {
            setFieldValue(93, 0, enhancedMinAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
