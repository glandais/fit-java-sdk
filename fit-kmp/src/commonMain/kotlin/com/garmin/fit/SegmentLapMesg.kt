/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentLapMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

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
    fun getMessageIndex(): Int? {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_index field
     *
     * @param messageIndex The new messageIndex value to be set
     */
    fun setMessageIndex(messageIndex: Int?) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    override fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    override fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event field
     *
     * @return event
     */
    override fun getEvent(): Event? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Event.fromValue(value)
    }

    /**
     * Set event field
     *
     * @param event The new event value to be set
     */
    override fun setEvent(event: Event?) {
        setFieldValue(0, 0, event?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event_type field
     *
     * @return event_type
     */
    override fun getEventType(): EventType? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return EventType.fromValue(value)
    }

    /**
     * Set event_type field
     *
     * @param eventType The new eventType value to be set
     */
    override fun setEventType(eventType: EventType?) {
        setFieldValue(1, 0, eventType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_time field
     *
     * @return start_time
     */
    fun getStartTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set start_time field
     *
     * @param startTime The new startTime value to be set
     */
    fun setStartTime(startTime: DateTime?) {
        setFieldValue(2, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_position_lat field
     * Units: semicircles
     *
     * @return start_position_lat
     */
    fun getStartPositionLat(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_position_lat field
     * Units: semicircles
     *
     * @param startPositionLat The new startPositionLat value to be set
     */
    fun setStartPositionLat(startPositionLat: Int?) {
        setFieldValue(3, 0, startPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_position_long field
     * Units: semicircles
     *
     * @return start_position_long
     */
    fun getStartPositionLong(): Int? {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_position_long field
     * Units: semicircles
     *
     * @param startPositionLong The new startPositionLong value to be set
     */
    fun setStartPositionLong(startPositionLong: Int?) {
        setFieldValue(4, 0, startPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_position_lat field
     * Units: semicircles
     *
     * @return end_position_lat
     */
    fun getEndPositionLat(): Int? {
        return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_position_lat field
     * Units: semicircles
     *
     * @param endPositionLat The new endPositionLat value to be set
     */
    fun setEndPositionLat(endPositionLat: Int?) {
        setFieldValue(5, 0, endPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_position_long field
     * Units: semicircles
     *
     * @return end_position_long
     */
    fun getEndPositionLong(): Int? {
        return getFieldIntegerValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_position_long field
     * Units: semicircles
     *
     * @param endPositionLong The new endPositionLong value to be set
     */
    fun setEndPositionLong(endPositionLong: Int?) {
        setFieldValue(6, 0, endPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_elapsed_time field
     * Units: s
     * Comment: Time (includes pauses)
     *
     * @return total_elapsed_time
     */
    fun getTotalElapsedTime(): Float? {
        return getFieldFloatValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_elapsed_time field
     * Units: s
     * Comment: Time (includes pauses)
     *
     * @param totalElapsedTime The new totalElapsedTime value to be set
     */
    fun setTotalElapsedTime(totalElapsedTime: Float?) {
        setFieldValue(7, 0, totalElapsedTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_timer_time field
     * Units: s
     * Comment: Timer Time (excludes pauses)
     *
     * @return total_timer_time
     */
    fun getTotalTimerTime(): Float? {
        return getFieldFloatValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_timer_time field
     * Units: s
     * Comment: Timer Time (excludes pauses)
     *
     * @param totalTimerTime The new totalTimerTime value to be set
     */
    fun setTotalTimerTime(totalTimerTime: Float?) {
        setFieldValue(8, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_distance field
     * Units: m
     *
     * @return total_distance
     */
    fun getTotalDistance(): Float? {
        return getFieldFloatValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_distance field
     * Units: m
     *
     * @param totalDistance The new totalDistance value to be set
     */
    fun setTotalDistance(totalDistance: Float?) {
        setFieldValue(9, 0, totalDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_cycles field
     * Units: cycles
     *
     * @return total_cycles
     */
    fun getTotalCycles(): Long? {
        return getFieldLongValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_cycles field
     * Units: cycles
     *
     * @param totalCycles The new totalCycles value to be set
     */
    fun setTotalCycles(totalCycles: Long?) {
        setFieldValue(10, 0, totalCycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_strokes field
     * Units: strokes
     *
     * @return total_strokes
     */
    fun getTotalStrokes(): Long? {
        return getFieldLongValue(10, 0, Profile.SubFields.SEGMENT_LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES)
    }

    /**
     * Set total_strokes field
     * Units: strokes
     *
     * @param totalStrokes The new totalStrokes value to be set
     */
    fun setTotalStrokes(totalStrokes: Long?) {
        setFieldValue(10, 0, totalStrokes, Profile.SubFields.SEGMENT_LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES)
    }

    /**
     * Get total_calories field
     * Units: kcal
     *
     * @return total_calories
     */
    fun getTotalCalories(): Int? {
        return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_calories field
     * Units: kcal
     *
     * @param totalCalories The new totalCalories value to be set
     */
    fun setTotalCalories(totalCalories: Int?) {
        setFieldValue(11, 0, totalCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_fat_calories field
     * Units: kcal
     * Comment: If New Leaf
     *
     * @return total_fat_calories
     */
    fun getTotalFatCalories(): Int? {
        return getFieldIntegerValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_fat_calories field
     * Units: kcal
     * Comment: If New Leaf
     *
     * @param totalFatCalories The new totalFatCalories value to be set
     */
    fun setTotalFatCalories(totalFatCalories: Int?) {
        setFieldValue(12, 0, totalFatCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    fun getAvgSpeed(): Float? {
        return getFieldFloatValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_speed field
     * Units: m/s
     *
     * @param avgSpeed The new avgSpeed value to be set
     */
    fun setAvgSpeed(avgSpeed: Float?) {
        setFieldValue(13, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_speed field
     * Units: m/s
     *
     * @return max_speed
     */
    fun getMaxSpeed(): Float? {
        return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_speed field
     * Units: m/s
     *
     * @param maxSpeed The new maxSpeed value to be set
     */
    fun setMaxSpeed(maxSpeed: Float?) {
        setFieldValue(14, 0, maxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_heart_rate field
     * Units: bpm
     *
     * @return avg_heart_rate
     */
    fun getAvgHeartRate(): Short? {
        return getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_heart_rate field
     * Units: bpm
     *
     * @param avgHeartRate The new avgHeartRate value to be set
     */
    fun setAvgHeartRate(avgHeartRate: Short?) {
        setFieldValue(15, 0, avgHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_heart_rate field
     * Units: bpm
     *
     * @return max_heart_rate
     */
    fun getMaxHeartRate(): Short? {
        return getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_heart_rate field
     * Units: bpm
     *
     * @param maxHeartRate The new maxHeartRate value to be set
     */
    fun setMaxHeartRate(maxHeartRate: Short?) {
        setFieldValue(16, 0, maxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_cadence field
     * Units: rpm
     * Comment: total_cycles / total_timer_time if non_zero_avg_cadence otherwise total_cycles / total_elapsed_time
     *
     * @return avg_cadence
     */
    fun getAvgCadence(): Short? {
        return getFieldShortValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_cadence field
     * Units: rpm
     * Comment: total_cycles / total_timer_time if non_zero_avg_cadence otherwise total_cycles / total_elapsed_time
     *
     * @param avgCadence The new avgCadence value to be set
     */
    fun setAvgCadence(avgCadence: Short?) {
        setFieldValue(17, 0, avgCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_cadence field
     * Units: rpm
     *
     * @return max_cadence
     */
    fun getMaxCadence(): Short? {
        return getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_cadence field
     * Units: rpm
     *
     * @param maxCadence The new maxCadence value to be set
     */
    fun setMaxCadence(maxCadence: Short?) {
        setFieldValue(18, 0, maxCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_power field
     * Units: watts
     * Comment: total_power / total_timer_time if non_zero_avg_power otherwise total_power / total_elapsed_time
     *
     * @return avg_power
     */
    fun getAvgPower(): Int? {
        return getFieldIntegerValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_power field
     * Units: watts
     * Comment: total_power / total_timer_time if non_zero_avg_power otherwise total_power / total_elapsed_time
     *
     * @param avgPower The new avgPower value to be set
     */
    fun setAvgPower(avgPower: Int?) {
        setFieldValue(19, 0, avgPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_power field
     * Units: watts
     *
     * @return max_power
     */
    fun getMaxPower(): Int? {
        return getFieldIntegerValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_power field
     * Units: watts
     *
     * @param maxPower The new maxPower value to be set
     */
    fun setMaxPower(maxPower: Int?) {
        setFieldValue(20, 0, maxPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_ascent field
     * Units: m
     *
     * @return total_ascent
     */
    fun getTotalAscent(): Int? {
        return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_ascent field
     * Units: m
     *
     * @param totalAscent The new totalAscent value to be set
     */
    fun setTotalAscent(totalAscent: Int?) {
        setFieldValue(21, 0, totalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_descent field
     * Units: m
     *
     * @return total_descent
     */
    fun getTotalDescent(): Int? {
        return getFieldIntegerValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_descent field
     * Units: m
     *
     * @param totalDescent The new totalDescent value to be set
     */
    fun setTotalDescent(totalDescent: Int?) {
        setFieldValue(22, 0, totalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sport field
     *
     * @return sport
     */
    fun getSport(): Sport? {
        val value = getFieldShortValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Sport.fromValue(value)
    }

    /**
     * Set sport field
     *
     * @param sport The new sport value to be set
     */
    fun setSport(sport: Sport?) {
        setFieldValue(23, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override fun getEventGroup(): Short? {
        return getFieldShortValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set event_group field
     *
     * @param eventGroup The new eventGroup value to be set
     */
    override fun setEventGroup(eventGroup: Short?) {
        setFieldValue(24, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get nec_lat field
     * Units: semicircles
     * Comment: North east corner latitude.
     *
     * @return nec_lat
     */
    fun getNecLat(): Int? {
        return getFieldIntegerValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set nec_lat field
     * Units: semicircles
     * Comment: North east corner latitude.
     *
     * @param necLat The new necLat value to be set
     */
    fun setNecLat(necLat: Int?) {
        setFieldValue(25, 0, necLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get nec_long field
     * Units: semicircles
     * Comment: North east corner longitude.
     *
     * @return nec_long
     */
    fun getNecLong(): Int? {
        return getFieldIntegerValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set nec_long field
     * Units: semicircles
     * Comment: North east corner longitude.
     *
     * @param necLong The new necLong value to be set
     */
    fun setNecLong(necLong: Int?) {
        setFieldValue(26, 0, necLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get swc_lat field
     * Units: semicircles
     * Comment: South west corner latitude.
     *
     * @return swc_lat
     */
    fun getSwcLat(): Int? {
        return getFieldIntegerValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set swc_lat field
     * Units: semicircles
     * Comment: South west corner latitude.
     *
     * @param swcLat The new swcLat value to be set
     */
    fun setSwcLat(swcLat: Int?) {
        setFieldValue(27, 0, swcLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get swc_long field
     * Units: semicircles
     * Comment: South west corner latitude.
     *
     * @return swc_long
     */
    fun getSwcLong(): Int? {
        return getFieldIntegerValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set swc_long field
     * Units: semicircles
     * Comment: South west corner latitude.
     *
     * @param swcLong The new swcLong value to be set
     */
    fun setSwcLong(swcLong: Int?) {
        setFieldValue(28, 0, swcLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get name field
     *
     * @return name
     */
    override fun getName(): String? {
        return getFieldStringValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set name field
     *
     * @param name The new name value to be set
     */
    fun setName(name: String?) {
        setFieldValue(29, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get normalized_power field
     * Units: watts
     *
     * @return normalized_power
     */
    fun getNormalizedPower(): Int? {
        return getFieldIntegerValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set normalized_power field
     * Units: watts
     *
     * @param normalizedPower The new normalizedPower value to be set
     */
    fun setNormalizedPower(normalizedPower: Int?) {
        setFieldValue(30, 0, normalizedPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get left_right_balance field
     *
     * @return left_right_balance
     */
    fun getLeftRightBalance(): Int? {
        return getFieldIntegerValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set left_right_balance field
     *
     * @param leftRightBalance The new leftRightBalance value to be set
     */
    fun setLeftRightBalance(leftRightBalance: Int?) {
        setFieldValue(31, 0, leftRightBalance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    fun getSubSport(): SubSport? {
        val value = getFieldShortValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SubSport.fromValue(value)
    }

    /**
     * Set sub_sport field
     *
     * @param subSport The new subSport value to be set
     */
    fun setSubSport(subSport: SubSport?) {
        setFieldValue(32, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_work field
     * Units: J
     *
     * @return total_work
     */
    fun getTotalWork(): Long? {
        return getFieldLongValue(33, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_work field
     * Units: J
     *
     * @param totalWork The new totalWork value to be set
     */
    fun setTotalWork(totalWork: Long?) {
        setFieldValue(33, 0, totalWork, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_altitude field
     * Units: m
     *
     * @return avg_altitude
     */
    fun getAvgAltitude(): Float? {
        return getFieldFloatValue(34, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_altitude field
     * Units: m
     *
     * @param avgAltitude The new avgAltitude value to be set
     */
    fun setAvgAltitude(avgAltitude: Float?) {
        setFieldValue(34, 0, avgAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_altitude field
     * Units: m
     *
     * @return max_altitude
     */
    fun getMaxAltitude(): Float? {
        return getFieldFloatValue(35, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_altitude field
     * Units: m
     *
     * @param maxAltitude The new maxAltitude value to be set
     */
    fun setMaxAltitude(maxAltitude: Float?) {
        setFieldValue(35, 0, maxAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gps_accuracy field
     * Units: m
     *
     * @return gps_accuracy
     */
    fun getGpsAccuracy(): Short? {
        return getFieldShortValue(36, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gps_accuracy field
     * Units: m
     *
     * @param gpsAccuracy The new gpsAccuracy value to be set
     */
    fun setGpsAccuracy(gpsAccuracy: Short?) {
        setFieldValue(36, 0, gpsAccuracy, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_grade field
     * Units: %
     *
     * @return avg_grade
     */
    fun getAvgGrade(): Float? {
        return getFieldFloatValue(37, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_grade field
     * Units: %
     *
     * @param avgGrade The new avgGrade value to be set
     */
    fun setAvgGrade(avgGrade: Float?) {
        setFieldValue(37, 0, avgGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_pos_grade field
     * Units: %
     *
     * @return avg_pos_grade
     */
    fun getAvgPosGrade(): Float? {
        return getFieldFloatValue(38, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_pos_grade field
     * Units: %
     *
     * @param avgPosGrade The new avgPosGrade value to be set
     */
    fun setAvgPosGrade(avgPosGrade: Float?) {
        setFieldValue(38, 0, avgPosGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_neg_grade field
     * Units: %
     *
     * @return avg_neg_grade
     */
    fun getAvgNegGrade(): Float? {
        return getFieldFloatValue(39, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_neg_grade field
     * Units: %
     *
     * @param avgNegGrade The new avgNegGrade value to be set
     */
    fun setAvgNegGrade(avgNegGrade: Float?) {
        setFieldValue(39, 0, avgNegGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_pos_grade field
     * Units: %
     *
     * @return max_pos_grade
     */
    fun getMaxPosGrade(): Float? {
        return getFieldFloatValue(40, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_pos_grade field
     * Units: %
     *
     * @param maxPosGrade The new maxPosGrade value to be set
     */
    fun setMaxPosGrade(maxPosGrade: Float?) {
        setFieldValue(40, 0, maxPosGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_neg_grade field
     * Units: %
     *
     * @return max_neg_grade
     */
    fun getMaxNegGrade(): Float? {
        return getFieldFloatValue(41, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_neg_grade field
     * Units: %
     *
     * @param maxNegGrade The new maxNegGrade value to be set
     */
    fun setMaxNegGrade(maxNegGrade: Float?) {
        setFieldValue(41, 0, maxNegGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_temperature field
     * Units: C
     *
     * @return avg_temperature
     */
    fun getAvgTemperature(): Byte? {
        return getFieldByteValue(42, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_temperature field
     * Units: C
     *
     * @param avgTemperature The new avgTemperature value to be set
     */
    fun setAvgTemperature(avgTemperature: Byte?) {
        setFieldValue(42, 0, avgTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_temperature field
     * Units: C
     *
     * @return max_temperature
     */
    fun getMaxTemperature(): Byte? {
        return getFieldByteValue(43, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_temperature field
     * Units: C
     *
     * @param maxTemperature The new maxTemperature value to be set
     */
    fun setMaxTemperature(maxTemperature: Byte?) {
        setFieldValue(43, 0, maxTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_moving_time field
     * Units: s
     *
     * @return total_moving_time
     */
    fun getTotalMovingTime(): Float? {
        return getFieldFloatValue(44, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_moving_time field
     * Units: s
     *
     * @param totalMovingTime The new totalMovingTime value to be set
     */
    fun setTotalMovingTime(totalMovingTime: Float?) {
        setFieldValue(44, 0, totalMovingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_pos_vertical_speed field
     * Units: m/s
     *
     * @return avg_pos_vertical_speed
     */
    fun getAvgPosVerticalSpeed(): Float? {
        return getFieldFloatValue(45, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_pos_vertical_speed field
     * Units: m/s
     *
     * @param avgPosVerticalSpeed The new avgPosVerticalSpeed value to be set
     */
    fun setAvgPosVerticalSpeed(avgPosVerticalSpeed: Float?) {
        setFieldValue(45, 0, avgPosVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_neg_vertical_speed field
     * Units: m/s
     *
     * @return avg_neg_vertical_speed
     */
    fun getAvgNegVerticalSpeed(): Float? {
        return getFieldFloatValue(46, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_neg_vertical_speed field
     * Units: m/s
     *
     * @param avgNegVerticalSpeed The new avgNegVerticalSpeed value to be set
     */
    fun setAvgNegVerticalSpeed(avgNegVerticalSpeed: Float?) {
        setFieldValue(46, 0, avgNegVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_pos_vertical_speed field
     * Units: m/s
     *
     * @return max_pos_vertical_speed
     */
    fun getMaxPosVerticalSpeed(): Float? {
        return getFieldFloatValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_pos_vertical_speed field
     * Units: m/s
     *
     * @param maxPosVerticalSpeed The new maxPosVerticalSpeed value to be set
     */
    fun setMaxPosVerticalSpeed(maxPosVerticalSpeed: Float?) {
        setFieldValue(47, 0, maxPosVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_neg_vertical_speed field
     * Units: m/s
     *
     * @return max_neg_vertical_speed
     */
    fun getMaxNegVerticalSpeed(): Float? {
        return getFieldFloatValue(48, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_neg_vertical_speed field
     * Units: m/s
     *
     * @param maxNegVerticalSpeed The new maxNegVerticalSpeed value to be set
     */
    fun setMaxNegVerticalSpeed(maxNegVerticalSpeed: Float?) {
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
    fun getRepetitionNum(): Int? {
        return getFieldIntegerValue(53, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set repetition_num field
     *
     * @param repetitionNum The new repetitionNum value to be set
     */
    fun setRepetitionNum(repetitionNum: Int?) {
        setFieldValue(53, 0, repetitionNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_altitude field
     * Units: m
     *
     * @return min_altitude
     */
    fun getMinAltitude(): Float? {
        return getFieldFloatValue(54, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_altitude field
     * Units: m
     *
     * @param minAltitude The new minAltitude value to be set
     */
    fun setMinAltitude(minAltitude: Float?) {
        setFieldValue(54, 0, minAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_heart_rate field
     * Units: bpm
     *
     * @return min_heart_rate
     */
    fun getMinHeartRate(): Short? {
        return getFieldShortValue(55, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_heart_rate field
     * Units: bpm
     *
     * @param minHeartRate The new minHeartRate value to be set
     */
    fun setMinHeartRate(minHeartRate: Short?) {
        setFieldValue(55, 0, minHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get active_time field
     * Units: s
     *
     * @return active_time
     */
    fun getActiveTime(): Float? {
        return getFieldFloatValue(56, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set active_time field
     * Units: s
     *
     * @param activeTime The new activeTime value to be set
     */
    fun setActiveTime(activeTime: Float?) {
        setFieldValue(56, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get wkt_step_index field
     *
     * @return wkt_step_index
     */
    fun getWktStepIndex(): Int? {
        return getFieldIntegerValue(57, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set wkt_step_index field
     *
     * @param wktStepIndex The new wktStepIndex value to be set
     */
    fun setWktStepIndex(wktStepIndex: Int?) {
        setFieldValue(57, 0, wktStepIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sport_event field
     *
     * @return sport_event
     */
    fun getSportEvent(): SportEvent? {
        val value = getFieldShortValue(58, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SportEvent.fromValue(value)
    }

    /**
     * Set sport_event field
     *
     * @param sportEvent The new sportEvent value to be set
     */
    fun setSportEvent(sportEvent: SportEvent?) {
        setFieldValue(58, 0, sportEvent?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_torque_effectiveness field
     * Units: percent
     *
     * @return avg_left_torque_effectiveness
     */
    fun getAvgLeftTorqueEffectiveness(): Float? {
        return getFieldFloatValue(59, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_torque_effectiveness field
     * Units: percent
     *
     * @param avgLeftTorqueEffectiveness The new avgLeftTorqueEffectiveness value to be set
     */
    fun setAvgLeftTorqueEffectiveness(avgLeftTorqueEffectiveness: Float?) {
        setFieldValue(59, 0, avgLeftTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_torque_effectiveness field
     * Units: percent
     *
     * @return avg_right_torque_effectiveness
     */
    fun getAvgRightTorqueEffectiveness(): Float? {
        return getFieldFloatValue(60, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_torque_effectiveness field
     * Units: percent
     *
     * @param avgRightTorqueEffectiveness The new avgRightTorqueEffectiveness value to be set
     */
    fun setAvgRightTorqueEffectiveness(avgRightTorqueEffectiveness: Float?) {
        setFieldValue(60, 0, avgRightTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_pedal_smoothness field
     * Units: percent
     *
     * @return avg_left_pedal_smoothness
     */
    fun getAvgLeftPedalSmoothness(): Float? {
        return getFieldFloatValue(61, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_pedal_smoothness field
     * Units: percent
     *
     * @param avgLeftPedalSmoothness The new avgLeftPedalSmoothness value to be set
     */
    fun setAvgLeftPedalSmoothness(avgLeftPedalSmoothness: Float?) {
        setFieldValue(61, 0, avgLeftPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_pedal_smoothness field
     * Units: percent
     *
     * @return avg_right_pedal_smoothness
     */
    fun getAvgRightPedalSmoothness(): Float? {
        return getFieldFloatValue(62, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_pedal_smoothness field
     * Units: percent
     *
     * @param avgRightPedalSmoothness The new avgRightPedalSmoothness value to be set
     */
    fun setAvgRightPedalSmoothness(avgRightPedalSmoothness: Float?) {
        setFieldValue(62, 0, avgRightPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_combined_pedal_smoothness field
     * Units: percent
     *
     * @return avg_combined_pedal_smoothness
     */
    fun getAvgCombinedPedalSmoothness(): Float? {
        return getFieldFloatValue(63, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_combined_pedal_smoothness field
     * Units: percent
     *
     * @param avgCombinedPedalSmoothness The new avgCombinedPedalSmoothness value to be set
     */
    fun setAvgCombinedPedalSmoothness(avgCombinedPedalSmoothness: Float?) {
        setFieldValue(63, 0, avgCombinedPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get status field
     *
     * @return status
     */
    fun getStatus(): SegmentLapStatus? {
        val value = getFieldShortValue(64, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SegmentLapStatus.fromValue(value)
    }

    /**
     * Set status field
     *
     * @param status The new status value to be set
     */
    fun setStatus(status: SegmentLapStatus?) {
        setFieldValue(64, 0, status?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get uuid field
     *
     * @return uuid
     */
    fun getUuid(): String? {
        return getFieldStringValue(65, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set uuid field
     *
     * @param uuid The new uuid value to be set
     */
    fun setUuid(uuid: String?) {
        setFieldValue(65, 0, uuid, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the avg_cadence
     *
     * @return avg_fractional_cadence
     */
    fun getAvgFractionalCadence(): Float? {
        return getFieldFloatValue(66, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the avg_cadence
     *
     * @param avgFractionalCadence The new avgFractionalCadence value to be set
     */
    fun setAvgFractionalCadence(avgFractionalCadence: Float?) {
        setFieldValue(66, 0, avgFractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the max_cadence
     *
     * @return max_fractional_cadence
     */
    fun getMaxFractionalCadence(): Float? {
        return getFieldFloatValue(67, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the max_cadence
     *
     * @param maxFractionalCadence The new maxFractionalCadence value to be set
     */
    fun setMaxFractionalCadence(maxFractionalCadence: Float?) {
        setFieldValue(67, 0, maxFractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_fractional_cycles field
     * Units: cycles
     * Comment: fractional part of the total_cycles
     *
     * @return total_fractional_cycles
     */
    fun getTotalFractionalCycles(): Float? {
        return getFieldFloatValue(68, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_fractional_cycles field
     * Units: cycles
     * Comment: fractional part of the total_cycles
     *
     * @param totalFractionalCycles The new totalFractionalCycles value to be set
     */
    fun setTotalFractionalCycles(totalFractionalCycles: Float?) {
        setFieldValue(68, 0, totalFractionalCycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get front_gear_shift_count field
     *
     * @return front_gear_shift_count
     */
    fun getFrontGearShiftCount(): Int? {
        return getFieldIntegerValue(69, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set front_gear_shift_count field
     *
     * @param frontGearShiftCount The new frontGearShiftCount value to be set
     */
    fun setFrontGearShiftCount(frontGearShiftCount: Int?) {
        setFieldValue(69, 0, frontGearShiftCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get rear_gear_shift_count field
     *
     * @return rear_gear_shift_count
     */
    fun getRearGearShiftCount(): Int? {
        return getFieldIntegerValue(70, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set rear_gear_shift_count field
     *
     * @param rearGearShiftCount The new rearGearShiftCount value to be set
     */
    fun setRearGearShiftCount(rearGearShiftCount: Int?) {
        setFieldValue(70, 0, rearGearShiftCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_standing field
     * Units: s
     * Comment: Total time spent in the standing position
     *
     * @return time_standing
     */
    fun getTimeStanding(): Float? {
        return getFieldFloatValue(71, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_standing field
     * Units: s
     * Comment: Total time spent in the standing position
     *
     * @param timeStanding The new timeStanding value to be set
     */
    fun setTimeStanding(timeStanding: Float?) {
        setFieldValue(71, 0, timeStanding, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get stand_count field
     * Comment: Number of transitions to the standing state
     *
     * @return stand_count
     */
    fun getStandCount(): Int? {
        return getFieldIntegerValue(72, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set stand_count field
     * Comment: Number of transitions to the standing state
     *
     * @param standCount The new standCount value to be set
     */
    fun setStandCount(standCount: Int?) {
        setFieldValue(72, 0, standCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_pco field
     * Units: mm
     * Comment: Average left platform center offset
     *
     * @return avg_left_pco
     */
    fun getAvgLeftPco(): Byte? {
        return getFieldByteValue(73, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_pco field
     * Units: mm
     * Comment: Average left platform center offset
     *
     * @param avgLeftPco The new avgLeftPco value to be set
     */
    fun setAvgLeftPco(avgLeftPco: Byte?) {
        setFieldValue(73, 0, avgLeftPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_pco field
     * Units: mm
     * Comment: Average right platform center offset
     *
     * @return avg_right_pco
     */
    fun getAvgRightPco(): Byte? {
        return getFieldByteValue(74, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_pco field
     * Units: mm
     * Comment: Average right platform center offset
     *
     * @param avgRightPco The new avgRightPco value to be set
     */
    fun setAvgRightPco(avgRightPco: Byte?) {
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
    fun getManufacturer(): Int? {
        return getFieldIntegerValue(83, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set manufacturer field
     * Comment: Manufacturer that produced the segment
     *
     * @param manufacturer The new manufacturer value to be set
     */
    fun setManufacturer(manufacturer: Int?) {
        setFieldValue(83, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @return total_grit
     */
    fun getTotalGrit(): Float? {
        return getFieldFloatValue(84, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @param totalGrit The new totalGrit value to be set
     */
    fun setTotalGrit(totalGrit: Float?) {
        setFieldValue(84, 0, totalGrit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @return total_flow
     */
    fun getTotalFlow(): Float? {
        return getFieldFloatValue(85, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @param totalFlow The new totalFlow value to be set
     */
    fun setTotalFlow(totalFlow: Float?) {
        setFieldValue(85, 0, totalFlow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @return avg_grit
     */
    fun getAvgGrit(): Float? {
        return getFieldFloatValue(86, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @param avgGrit The new avgGrit value to be set
     */
    fun setAvgGrit(avgGrit: Float?) {
        setFieldValue(86, 0, avgGrit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @return avg_flow
     */
    fun getAvgFlow(): Float? {
        return getFieldFloatValue(87, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @param avgFlow The new avgFlow value to be set
     */
    fun setAvgFlow(avgFlow: Float?) {
        setFieldValue(87, 0, avgFlow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_fractional_ascent field
     * Units: m
     * Comment: fractional part of total_ascent
     *
     * @return total_fractional_ascent
     */
    fun getTotalFractionalAscent(): Float? {
        return getFieldFloatValue(89, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_fractional_ascent field
     * Units: m
     * Comment: fractional part of total_ascent
     *
     * @param totalFractionalAscent The new totalFractionalAscent value to be set
     */
    fun setTotalFractionalAscent(totalFractionalAscent: Float?) {
        setFieldValue(89, 0, totalFractionalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_fractional_descent field
     * Units: m
     * Comment: fractional part of total_descent
     *
     * @return total_fractional_descent
     */
    fun getTotalFractionalDescent(): Float? {
        return getFieldFloatValue(90, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_fractional_descent field
     * Units: m
     * Comment: fractional part of total_descent
     *
     * @param totalFractionalDescent The new totalFractionalDescent value to be set
     */
    fun setTotalFractionalDescent(totalFractionalDescent: Float?) {
        setFieldValue(90, 0, totalFractionalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_avg_altitude field
     * Units: m
     *
     * @return enhanced_avg_altitude
     */
    fun getEnhancedAvgAltitude(): Float? {
        return getFieldFloatValue(91, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_avg_altitude field
     * Units: m
     *
     * @param enhancedAvgAltitude The new enhancedAvgAltitude value to be set
     */
    fun setEnhancedAvgAltitude(enhancedAvgAltitude: Float?) {
        setFieldValue(91, 0, enhancedAvgAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_max_altitude field
     * Units: m
     *
     * @return enhanced_max_altitude
     */
    fun getEnhancedMaxAltitude(): Float? {
        return getFieldFloatValue(92, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_max_altitude field
     * Units: m
     *
     * @param enhancedMaxAltitude The new enhancedMaxAltitude value to be set
     */
    fun setEnhancedMaxAltitude(enhancedMaxAltitude: Float?) {
        setFieldValue(92, 0, enhancedMaxAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_min_altitude field
     * Units: m
     *
     * @return enhanced_min_altitude
     */
    fun getEnhancedMinAltitude(): Float? {
        return getFieldFloatValue(93, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_min_altitude field
     * Units: m
     *
     * @param enhancedMinAltitude The new enhancedMinAltitude value to be set
     */
    fun setEnhancedMinAltitude(enhancedMinAltitude: Float?) {
        setFieldValue(93, 0, enhancedMinAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
