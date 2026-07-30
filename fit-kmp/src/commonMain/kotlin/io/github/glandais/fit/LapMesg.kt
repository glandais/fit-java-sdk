/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LapMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class LapMesg : Mesg, MesgWithEvent {

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
        const val IntensityFieldNum = 23
        const val LapTriggerFieldNum = 24
        const val SportFieldNum = 25
        const val EventGroupFieldNum = 26
        const val NumLengthsFieldNum = 32
        const val NormalizedPowerFieldNum = 33
        const val LeftRightBalanceFieldNum = 34
        const val FirstLengthIndexFieldNum = 35
        const val AvgStrokeDistanceFieldNum = 37
        const val SwimStrokeFieldNum = 38
        const val SubSportFieldNum = 39
        const val NumActiveLengthsFieldNum = 40
        const val TotalWorkFieldNum = 41
        const val AvgAltitudeFieldNum = 42
        const val MaxAltitudeFieldNum = 43
        const val GpsAccuracyFieldNum = 44
        const val AvgGradeFieldNum = 45
        const val AvgPosGradeFieldNum = 46
        const val AvgNegGradeFieldNum = 47
        const val MaxPosGradeFieldNum = 48
        const val MaxNegGradeFieldNum = 49
        const val AvgTemperatureFieldNum = 50
        const val MaxTemperatureFieldNum = 51
        const val TotalMovingTimeFieldNum = 52
        const val AvgPosVerticalSpeedFieldNum = 53
        const val AvgNegVerticalSpeedFieldNum = 54
        const val MaxPosVerticalSpeedFieldNum = 55
        const val MaxNegVerticalSpeedFieldNum = 56
        const val TimeInHrZoneFieldNum = 57
        const val TimeInSpeedZoneFieldNum = 58
        const val TimeInCadenceZoneFieldNum = 59
        const val TimeInPowerZoneFieldNum = 60
        const val RepetitionNumFieldNum = 61
        const val MinAltitudeFieldNum = 62
        const val MinHeartRateFieldNum = 63
        const val ActiveTimeFieldNum = 70
        const val WktStepIndexFieldNum = 71
        const val OpponentScoreFieldNum = 74
        const val StrokeCountFieldNum = 75
        const val ZoneCountFieldNum = 76
        const val AvgVerticalOscillationFieldNum = 77
        const val AvgStanceTimePercentFieldNum = 78
        const val AvgStanceTimeFieldNum = 79
        const val AvgFractionalCadenceFieldNum = 80
        const val MaxFractionalCadenceFieldNum = 81
        const val TotalFractionalCyclesFieldNum = 82
        const val PlayerScoreFieldNum = 83
        const val AvgTotalHemoglobinConcFieldNum = 84
        const val MinTotalHemoglobinConcFieldNum = 85
        const val MaxTotalHemoglobinConcFieldNum = 86
        const val AvgSaturatedHemoglobinPercentFieldNum = 87
        const val MinSaturatedHemoglobinPercentFieldNum = 88
        const val MaxSaturatedHemoglobinPercentFieldNum = 89
        const val AvgLeftTorqueEffectivenessFieldNum = 91
        const val AvgRightTorqueEffectivenessFieldNum = 92
        const val AvgLeftPedalSmoothnessFieldNum = 93
        const val AvgRightPedalSmoothnessFieldNum = 94
        const val AvgCombinedPedalSmoothnessFieldNum = 95
        const val TimeStandingFieldNum = 98
        const val StandCountFieldNum = 99
        const val AvgLeftPcoFieldNum = 100
        const val AvgRightPcoFieldNum = 101
        const val AvgLeftPowerPhaseFieldNum = 102
        const val AvgLeftPowerPhasePeakFieldNum = 103
        const val AvgRightPowerPhaseFieldNum = 104
        const val AvgRightPowerPhasePeakFieldNum = 105
        const val AvgPowerPositionFieldNum = 106
        const val MaxPowerPositionFieldNum = 107
        const val AvgCadencePositionFieldNum = 108
        const val MaxCadencePositionFieldNum = 109
        const val EnhancedAvgSpeedFieldNum = 110
        const val EnhancedMaxSpeedFieldNum = 111
        const val EnhancedAvgAltitudeFieldNum = 112
        const val EnhancedMinAltitudeFieldNum = 113
        const val EnhancedMaxAltitudeFieldNum = 114
        const val AvgLevMotorPowerFieldNum = 115
        const val MaxLevMotorPowerFieldNum = 116
        const val LevBatteryConsumptionFieldNum = 117
        const val AvgVerticalRatioFieldNum = 118
        const val AvgStanceTimeBalanceFieldNum = 119
        const val AvgStepLengthFieldNum = 120
        const val AvgVamFieldNum = 121
        const val AvgDepthFieldNum = 122
        const val MaxDepthFieldNum = 123
        const val MinTemperatureFieldNum = 124
        const val EnhancedAvgRespirationRateFieldNum = 136
        const val EnhancedMaxRespirationRateFieldNum = 137
        const val AvgRespirationRateFieldNum = 147
        const val MaxRespirationRateFieldNum = 148
        const val TotalGritFieldNum = 149
        const val TotalFlowFieldNum = 150
        const val JumpCountFieldNum = 151
        const val AvgGritFieldNum = 153
        const val AvgFlowFieldNum = 154
        const val TotalFractionalAscentFieldNum = 156
        const val TotalFractionalDescentFieldNum = 157
        const val AvgCoreTemperatureFieldNum = 158
        const val MinCoreTemperatureFieldNum = 159
        const val MaxCoreTemperatureFieldNum = 160

        val lapMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // lap
            val lapMesg = Mesg("lap", MesgNum.LAP)
            lapMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            lapMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            lapMesg.addField(Field("event", EventFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT))
            field_index++
            lapMesg.addField(Field("event_type", EventTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT_TYPE))
            field_index++
            lapMesg.addField(Field("start_time", StartTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            lapMesg.addField(Field("start_position_lat", StartPositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            lapMesg.addField(Field("start_position_long", StartPositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            lapMesg.addField(Field("end_position_lat", EndPositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            lapMesg.addField(Field("end_position_long", EndPositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            lapMesg.addField(Field("total_elapsed_time", TotalElapsedTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("total_timer_time", TotalTimerTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("total_distance", TotalDistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("total_cycles", TotalCyclesFieldNum, 134, 1.0, 0.0, "cycles", false, Profile.Type.UINT32))
            subfield_index = 0
            lapMesg.fields[field_index].subFields.add(SubField("total_strides", 134, 1.0, 0.0, "strides"))
            lapMesg.fields[field_index].subFields[subfield_index].addMap(25, 1L)
            lapMesg.fields[field_index].subFields[subfield_index].addMap(25, 11L)
            subfield_index++
            lapMesg.fields[field_index].subFields.add(SubField("total_strokes", 134, 1.0, 0.0, "strokes"))
            lapMesg.fields[field_index].subFields[subfield_index].addMap(25, 2L)
            lapMesg.fields[field_index].subFields[subfield_index].addMap(25, 5L)
            lapMesg.fields[field_index].subFields[subfield_index].addMap(25, 15L)
            lapMesg.fields[field_index].subFields[subfield_index].addMap(25, 37L)
            subfield_index++
            field_index++
            lapMesg.addField(Field("total_calories", TotalCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("total_fat_calories", TotalFatCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_speed", AvgSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            lapMesg.fields[field_index].components.add(FieldComponent(110, false, 16, 1000.0, 0.0)) // enhanced_avg_speed
            field_index++
            lapMesg.addField(Field("max_speed", MaxSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            lapMesg.fields[field_index].components.add(FieldComponent(111, false, 16, 1000.0, 0.0)) // enhanced_max_speed
            field_index++
            lapMesg.addField(Field("avg_heart_rate", AvgHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("max_heart_rate", MaxHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_cadence", AvgCadenceFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            subfield_index = 0
            lapMesg.fields[field_index].subFields.add(SubField("avg_running_cadence", 2, 1.0, 0.0, "strides/min"))
            lapMesg.fields[field_index].subFields[subfield_index].addMap(25, 1L)
            subfield_index++
            field_index++
            lapMesg.addField(Field("max_cadence", MaxCadenceFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            subfield_index = 0
            lapMesg.fields[field_index].subFields.add(SubField("max_running_cadence", 2, 1.0, 0.0, "strides/min"))
            lapMesg.fields[field_index].subFields[subfield_index].addMap(25, 1L)
            subfield_index++
            field_index++
            lapMesg.addField(Field("avg_power", AvgPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("max_power", MaxPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("total_ascent", TotalAscentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("total_descent", TotalDescentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("intensity", IntensityFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.INTENSITY))
            field_index++
            lapMesg.addField(Field("lap_trigger", LapTriggerFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.LAP_TRIGGER))
            field_index++
            lapMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            field_index++
            lapMesg.addField(Field("event_group", EventGroupFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("num_lengths", NumLengthsFieldNum, 132, 1.0, 0.0, "lengths", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("normalized_power", NormalizedPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("left_right_balance", LeftRightBalanceFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.LEFT_RIGHT_BALANCE_100))
            field_index++
            lapMesg.addField(Field("first_length_index", FirstLengthIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_stroke_distance", AvgStrokeDistanceFieldNum, 132, 100.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("swim_stroke", SwimStrokeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SWIM_STROKE))
            field_index++
            lapMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            field_index++
            lapMesg.addField(Field("num_active_lengths", NumActiveLengthsFieldNum, 132, 1.0, 0.0, "lengths", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("total_work", TotalWorkFieldNum, 134, 1.0, 0.0, "J", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("avg_altitude", AvgAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            lapMesg.fields[field_index].components.add(FieldComponent(112, false, 16, 5.0, 500.0)) // enhanced_avg_altitude
            field_index++
            lapMesg.addField(Field("max_altitude", MaxAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            lapMesg.fields[field_index].components.add(FieldComponent(114, false, 16, 5.0, 500.0)) // enhanced_max_altitude
            field_index++
            lapMesg.addField(Field("gps_accuracy", GpsAccuracyFieldNum, 2, 1.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_grade", AvgGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("avg_pos_grade", AvgPosGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("avg_neg_grade", AvgNegGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("max_pos_grade", MaxPosGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("max_neg_grade", MaxNegGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("avg_temperature", AvgTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            lapMesg.addField(Field("max_temperature", MaxTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            lapMesg.addField(Field("total_moving_time", TotalMovingTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("avg_pos_vertical_speed", AvgPosVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("avg_neg_vertical_speed", AvgNegVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("max_pos_vertical_speed", MaxPosVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("max_neg_vertical_speed", MaxNegVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            lapMesg.addField(Field("time_in_hr_zone", TimeInHrZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("time_in_speed_zone", TimeInSpeedZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("time_in_cadence_zone", TimeInCadenceZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("time_in_power_zone", TimeInPowerZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("repetition_num", RepetitionNumFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("min_altitude", MinAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            lapMesg.fields[field_index].components.add(FieldComponent(113, false, 16, 5.0, 500.0)) // enhanced_min_altitude
            field_index++
            lapMesg.addField(Field("min_heart_rate", MinHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("active_time", ActiveTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("wkt_step_index", WktStepIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            lapMesg.addField(Field("opponent_score", OpponentScoreFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("stroke_count", StrokeCountFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("zone_count", ZoneCountFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_vertical_oscillation", AvgVerticalOscillationFieldNum, 132, 10.0, 0.0, "mm", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_stance_time_percent", AvgStanceTimePercentFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_stance_time", AvgStanceTimeFieldNum, 132, 10.0, 0.0, "ms", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_fractional_cadence", AvgFractionalCadenceFieldNum, 2, 128.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("max_fractional_cadence", MaxFractionalCadenceFieldNum, 2, 128.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("total_fractional_cycles", TotalFractionalCyclesFieldNum, 2, 128.0, 0.0, "cycles", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("player_score", PlayerScoreFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_total_hemoglobin_conc", AvgTotalHemoglobinConcFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("min_total_hemoglobin_conc", MinTotalHemoglobinConcFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("max_total_hemoglobin_conc", MaxTotalHemoglobinConcFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_saturated_hemoglobin_percent", AvgSaturatedHemoglobinPercentFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("min_saturated_hemoglobin_percent", MinSaturatedHemoglobinPercentFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("max_saturated_hemoglobin_percent", MaxSaturatedHemoglobinPercentFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_left_torque_effectiveness", AvgLeftTorqueEffectivenessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_right_torque_effectiveness", AvgRightTorqueEffectivenessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_left_pedal_smoothness", AvgLeftPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_right_pedal_smoothness", AvgRightPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_combined_pedal_smoothness", AvgCombinedPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("time_standing", TimeStandingFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("stand_count", StandCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_left_pco", AvgLeftPcoFieldNum, 1, 1.0, 0.0, "mm", false, Profile.Type.SINT8))
            field_index++
            lapMesg.addField(Field("avg_right_pco", AvgRightPcoFieldNum, 1, 1.0, 0.0, "mm", false, Profile.Type.SINT8))
            field_index++
            lapMesg.addField(Field("avg_left_power_phase", AvgLeftPowerPhaseFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_left_power_phase_peak", AvgLeftPowerPhasePeakFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_right_power_phase", AvgRightPowerPhaseFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_right_power_phase_peak", AvgRightPowerPhasePeakFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_power_position", AvgPowerPositionFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("max_power_position", MaxPowerPositionFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_cadence_position", AvgCadencePositionFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("max_cadence_position", MaxCadencePositionFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("enhanced_avg_speed", EnhancedAvgSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("enhanced_max_speed", EnhancedMaxSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("enhanced_avg_altitude", EnhancedAvgAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("enhanced_min_altitude", EnhancedMinAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("enhanced_max_altitude", EnhancedMaxAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("avg_lev_motor_power", AvgLevMotorPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("max_lev_motor_power", MaxLevMotorPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("lev_battery_consumption", LevBatteryConsumptionFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_vertical_ratio", AvgVerticalRatioFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_stance_time_balance", AvgStanceTimeBalanceFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_step_length", AvgStepLengthFieldNum, 132, 10.0, 0.0, "mm", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_vam", AvgVamFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_depth", AvgDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("max_depth", MaxDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            lapMesg.addField(Field("min_temperature", MinTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            lapMesg.addField(Field("enhanced_avg_respiration_rate", EnhancedAvgRespirationRateFieldNum, 132, 100.0, 0.0, "Breaths/min", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("enhanced_max_respiration_rate", EnhancedMaxRespirationRateFieldNum, 132, 100.0, 0.0, "Breaths/min", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_respiration_rate", AvgRespirationRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            lapMesg.fields[field_index].components.add(FieldComponent(136, false, 8, 1.0, 0.0)) // enhanced_avg_respiration_rate
            field_index++
            lapMesg.addField(Field("max_respiration_rate", MaxRespirationRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            lapMesg.fields[field_index].components.add(FieldComponent(137, false, 8, 1.0, 0.0)) // enhanced_max_respiration_rate
            field_index++
            lapMesg.addField(Field("total_grit", TotalGritFieldNum, 136, 1.0, 0.0, "kGrit", false, Profile.Type.FLOAT32))
            field_index++
            lapMesg.addField(Field("total_flow", TotalFlowFieldNum, 136, 1.0, 0.0, "Flow", false, Profile.Type.FLOAT32))
            field_index++
            lapMesg.addField(Field("jump_count", JumpCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("avg_grit", AvgGritFieldNum, 136, 1.0, 0.0, "kGrit", false, Profile.Type.FLOAT32))
            field_index++
            lapMesg.addField(Field("avg_flow", AvgFlowFieldNum, 136, 1.0, 0.0, "Flow", false, Profile.Type.FLOAT32))
            field_index++
            lapMesg.addField(Field("total_fractional_ascent", TotalFractionalAscentFieldNum, 2, 100.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("total_fractional_descent", TotalFractionalDescentFieldNum, 2, 100.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            lapMesg.addField(Field("avg_core_temperature", AvgCoreTemperatureFieldNum, 132, 100.0, 0.0, "C", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("min_core_temperature", MinCoreTemperatureFieldNum, 132, 100.0, 0.0, "C", false, Profile.Type.UINT16))
            field_index++
            lapMesg.addField(Field("max_core_temperature", MaxCoreTemperatureFieldNum, 132, 100.0, 0.0, "C", false, Profile.Type.UINT16))
            field_index++
            lapMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.LAP))

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
     * Get total_strides field
     * Units: strides
     *
     * @return total_strides
     */
    var totalStrides: Long?
        get() {
            return getFieldLongValue(10, 0, Profile.SubFields.LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STRIDES)
        }
        set(totalStrides) {
            setFieldValue(10, 0, totalStrides, Profile.SubFields.LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STRIDES)
        }

    /**
     * Get total_strokes field
     * Units: strokes
     *
     * @return total_strokes
     */
    var totalStrokes: Long?
        get() {
            return getFieldLongValue(10, 0, Profile.SubFields.LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES)
        }
        set(totalStrokes) {
            setFieldValue(10, 0, totalStrokes, Profile.SubFields.LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES)
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
     * Get avg_running_cadence field
     * Units: strides/min
     *
     * @return avg_running_cadence
     */
    var avgRunningCadence: Short?
        get() {
            return getFieldShortValue(17, 0, Profile.SubFields.LAP_MESG_AVG_CADENCE_FIELD_AVG_RUNNING_CADENCE)
        }
        set(avgRunningCadence) {
            setFieldValue(17, 0, avgRunningCadence, Profile.SubFields.LAP_MESG_AVG_CADENCE_FIELD_AVG_RUNNING_CADENCE)
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
     * Get max_running_cadence field
     * Units: strides/min
     *
     * @return max_running_cadence
     */
    var maxRunningCadence: Short?
        get() {
            return getFieldShortValue(18, 0, Profile.SubFields.LAP_MESG_MAX_CADENCE_FIELD_MAX_RUNNING_CADENCE)
        }
        set(maxRunningCadence) {
            setFieldValue(18, 0, maxRunningCadence, Profile.SubFields.LAP_MESG_MAX_CADENCE_FIELD_MAX_RUNNING_CADENCE)
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
     * Get intensity field
     *
     * @return intensity
     */
    var intensity: Intensity?
        get() {
            val value = getFieldShortValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Intensity.fromValue(value)
        }
        set(intensity) {
            setFieldValue(23, 0, intensity?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get lap_trigger field
     *
     * @return lap_trigger
     */
    var lapTrigger: LapTrigger?
        get() {
            val value = getFieldShortValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return LapTrigger.fromValue(value)
        }
        set(lapTrigger) {
            setFieldValue(24, 0, lapTrigger?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sport field
     *
     * @return sport
     */
    var sport: Sport?
        get() {
            val value = getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Sport.fromValue(value)
        }
        set(sport) {
            setFieldValue(25, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override var eventGroup: Short?
        get() {
            return getFieldShortValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(eventGroup) {
            setFieldValue(26, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get num_lengths field
     * Units: lengths
     * Comment: # of lengths of swim pool
     *
     * @return num_lengths
     */
    var numLengths: Int?
        get() {
            return getFieldIntegerValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(numLengths) {
            setFieldValue(32, 0, numLengths, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get normalized_power field
     * Units: watts
     *
     * @return normalized_power
     */
    var normalizedPower: Int?
        get() {
            return getFieldIntegerValue(33, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(normalizedPower) {
            setFieldValue(33, 0, normalizedPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get left_right_balance field
     *
     * @return left_right_balance
     */
    var leftRightBalance: Int?
        get() {
            return getFieldIntegerValue(34, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(leftRightBalance) {
            setFieldValue(34, 0, leftRightBalance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get first_length_index field
     *
     * @return first_length_index
     */
    var firstLengthIndex: Int?
        get() {
            return getFieldIntegerValue(35, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(firstLengthIndex) {
            setFieldValue(35, 0, firstLengthIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_stroke_distance field
     * Units: m
     *
     * @return avg_stroke_distance
     */
    var avgStrokeDistance: Float?
        get() {
            return getFieldFloatValue(37, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgStrokeDistance) {
            setFieldValue(37, 0, avgStrokeDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get swim_stroke field
     *
     * @return swim_stroke
     */
    var swimStroke: SwimStroke?
        get() {
            val value = getFieldShortValue(38, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SwimStroke.fromValue(value)
        }
        set(swimStroke) {
            setFieldValue(38, 0, swimStroke?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    var subSport: SubSport?
        get() {
            val value = getFieldShortValue(39, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SubSport.fromValue(value)
        }
        set(subSport) {
            setFieldValue(39, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get num_active_lengths field
     * Units: lengths
     * Comment: # of active lengths of swim pool
     *
     * @return num_active_lengths
     */
    var numActiveLengths: Int?
        get() {
            return getFieldIntegerValue(40, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(numActiveLengths) {
            setFieldValue(40, 0, numActiveLengths, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_work field
     * Units: J
     *
     * @return total_work
     */
    var totalWork: Long?
        get() {
            return getFieldLongValue(41, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalWork) {
            setFieldValue(41, 0, totalWork, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_altitude field
     * Units: m
     *
     * @return avg_altitude
     */
    var avgAltitude: Float?
        get() {
            return getFieldFloatValue(42, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgAltitude) {
            setFieldValue(42, 0, avgAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_altitude field
     * Units: m
     *
     * @return max_altitude
     */
    var maxAltitude: Float?
        get() {
            return getFieldFloatValue(43, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxAltitude) {
            setFieldValue(43, 0, maxAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get gps_accuracy field
     * Units: m
     *
     * @return gps_accuracy
     */
    var gpsAccuracy: Short?
        get() {
            return getFieldShortValue(44, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(gpsAccuracy) {
            setFieldValue(44, 0, gpsAccuracy, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_grade field
     * Units: %
     *
     * @return avg_grade
     */
    var avgGrade: Float?
        get() {
            return getFieldFloatValue(45, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgGrade) {
            setFieldValue(45, 0, avgGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_pos_grade field
     * Units: %
     *
     * @return avg_pos_grade
     */
    var avgPosGrade: Float?
        get() {
            return getFieldFloatValue(46, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgPosGrade) {
            setFieldValue(46, 0, avgPosGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_neg_grade field
     * Units: %
     *
     * @return avg_neg_grade
     */
    var avgNegGrade: Float?
        get() {
            return getFieldFloatValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgNegGrade) {
            setFieldValue(47, 0, avgNegGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_pos_grade field
     * Units: %
     *
     * @return max_pos_grade
     */
    var maxPosGrade: Float?
        get() {
            return getFieldFloatValue(48, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxPosGrade) {
            setFieldValue(48, 0, maxPosGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_neg_grade field
     * Units: %
     *
     * @return max_neg_grade
     */
    var maxNegGrade: Float?
        get() {
            return getFieldFloatValue(49, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxNegGrade) {
            setFieldValue(49, 0, maxNegGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_temperature field
     * Units: C
     *
     * @return avg_temperature
     */
    var avgTemperature: Byte?
        get() {
            return getFieldByteValue(50, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgTemperature) {
            setFieldValue(50, 0, avgTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_temperature field
     * Units: C
     *
     * @return max_temperature
     */
    var maxTemperature: Byte?
        get() {
            return getFieldByteValue(51, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxTemperature) {
            setFieldValue(51, 0, maxTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_moving_time field
     * Units: s
     *
     * @return total_moving_time
     */
    var totalMovingTime: Float?
        get() {
            return getFieldFloatValue(52, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalMovingTime) {
            setFieldValue(52, 0, totalMovingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_pos_vertical_speed field
     * Units: m/s
     *
     * @return avg_pos_vertical_speed
     */
    var avgPosVerticalSpeed: Float?
        get() {
            return getFieldFloatValue(53, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgPosVerticalSpeed) {
            setFieldValue(53, 0, avgPosVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_neg_vertical_speed field
     * Units: m/s
     *
     * @return avg_neg_vertical_speed
     */
    var avgNegVerticalSpeed: Float?
        get() {
            return getFieldFloatValue(54, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgNegVerticalSpeed) {
            setFieldValue(54, 0, avgNegVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_pos_vertical_speed field
     * Units: m/s
     *
     * @return max_pos_vertical_speed
     */
    var maxPosVerticalSpeed: Float?
        get() {
            return getFieldFloatValue(55, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxPosVerticalSpeed) {
            setFieldValue(55, 0, maxPosVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_neg_vertical_speed field
     * Units: m/s
     *
     * @return max_neg_vertical_speed
     */
    var maxNegVerticalSpeed: Float?
        get() {
            return getFieldFloatValue(56, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxNegVerticalSpeed) {
            setFieldValue(56, 0, maxNegVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getTimeInHrZone(): Array<Float?>? {
        return getFieldFloatValues(57, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_hr_zone
     */
    fun getNumTimeInHrZone(): Int {
        return getNumFieldValues(57, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_hr_zone field
     * Units: s
     *
     * @param index of time_in_hr_zone
     * @return time_in_hr_zone
     */
    fun getTimeInHrZone(index: Int): Float? {
        return getFieldFloatValue(57, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_hr_zone field
     * Units: s
     *
     * @param index of time_in_hr_zone
     * @param timeInHrZone The new timeInHrZone value to be set
     */
    fun setTimeInHrZone(index: Int, timeInHrZone: Float?) {
        setFieldValue(57, index, timeInHrZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInSpeedZone(): Array<Float?>? {
        return getFieldFloatValues(58, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_speed_zone
     */
    fun getNumTimeInSpeedZone(): Int {
        return getNumFieldValues(58, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_speed_zone field
     * Units: s
     *
     * @param index of time_in_speed_zone
     * @return time_in_speed_zone
     */
    fun getTimeInSpeedZone(index: Int): Float? {
        return getFieldFloatValue(58, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_speed_zone field
     * Units: s
     *
     * @param index of time_in_speed_zone
     * @param timeInSpeedZone The new timeInSpeedZone value to be set
     */
    fun setTimeInSpeedZone(index: Int, timeInSpeedZone: Float?) {
        setFieldValue(58, index, timeInSpeedZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInCadenceZone(): Array<Float?>? {
        return getFieldFloatValues(59, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_cadence_zone
     */
    fun getNumTimeInCadenceZone(): Int {
        return getNumFieldValues(59, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_cadence_zone field
     * Units: s
     *
     * @param index of time_in_cadence_zone
     * @return time_in_cadence_zone
     */
    fun getTimeInCadenceZone(index: Int): Float? {
        return getFieldFloatValue(59, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_cadence_zone field
     * Units: s
     *
     * @param index of time_in_cadence_zone
     * @param timeInCadenceZone The new timeInCadenceZone value to be set
     */
    fun setTimeInCadenceZone(index: Int, timeInCadenceZone: Float?) {
        setFieldValue(59, index, timeInCadenceZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInPowerZone(): Array<Float?>? {
        return getFieldFloatValues(60, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_power_zone
     */
    fun getNumTimeInPowerZone(): Int {
        return getNumFieldValues(60, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_power_zone field
     * Units: s
     *
     * @param index of time_in_power_zone
     * @return time_in_power_zone
     */
    fun getTimeInPowerZone(index: Int): Float? {
        return getFieldFloatValue(60, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_power_zone field
     * Units: s
     *
     * @param index of time_in_power_zone
     * @param timeInPowerZone The new timeInPowerZone value to be set
     */
    fun setTimeInPowerZone(index: Int, timeInPowerZone: Float?) {
        setFieldValue(60, index, timeInPowerZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get repetition_num field
     *
     * @return repetition_num
     */
    var repetitionNum: Int?
        get() {
            return getFieldIntegerValue(61, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(repetitionNum) {
            setFieldValue(61, 0, repetitionNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get min_altitude field
     * Units: m
     *
     * @return min_altitude
     */
    var minAltitude: Float?
        get() {
            return getFieldFloatValue(62, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(minAltitude) {
            setFieldValue(62, 0, minAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get min_heart_rate field
     * Units: bpm
     *
     * @return min_heart_rate
     */
    var minHeartRate: Short?
        get() {
            return getFieldShortValue(63, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(minHeartRate) {
            setFieldValue(63, 0, minHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get active_time field
     * Units: s
     *
     * @return active_time
     */
    var activeTime: Float?
        get() {
            return getFieldFloatValue(70, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activeTime) {
            setFieldValue(70, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get wkt_step_index field
     *
     * @return wkt_step_index
     */
    var wktStepIndex: Int?
        get() {
            return getFieldIntegerValue(71, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(wktStepIndex) {
            setFieldValue(71, 0, wktStepIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get opponent_score field
     *
     * @return opponent_score
     */
    var opponentScore: Int?
        get() {
            return getFieldIntegerValue(74, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(opponentScore) {
            setFieldValue(74, 0, opponentScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getStrokeCount(): Array<Int?>? {
        return getFieldIntegerValues(75, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of stroke_count
     */
    fun getNumStrokeCount(): Int {
        return getNumFieldValues(75, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get stroke_count field
     * Units: counts
     * Comment: stroke_type enum used as the index
     *
     * @param index of stroke_count
     * @return stroke_count
     */
    fun getStrokeCount(index: Int): Int? {
        return getFieldIntegerValue(75, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set stroke_count field
     * Units: counts
     * Comment: stroke_type enum used as the index
     *
     * @param index of stroke_count
     * @param strokeCount The new strokeCount value to be set
     */
    fun setStrokeCount(index: Int, strokeCount: Int?) {
        setFieldValue(75, index, strokeCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getZoneCount(): Array<Int?>? {
        return getFieldIntegerValues(76, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of zone_count
     */
    fun getNumZoneCount(): Int {
        return getNumFieldValues(76, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get zone_count field
     * Units: counts
     * Comment: zone number used as the index
     *
     * @param index of zone_count
     * @return zone_count
     */
    fun getZoneCount(index: Int): Int? {
        return getFieldIntegerValue(76, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set zone_count field
     * Units: counts
     * Comment: zone number used as the index
     *
     * @param index of zone_count
     * @param zoneCount The new zoneCount value to be set
     */
    fun setZoneCount(index: Int, zoneCount: Int?) {
        setFieldValue(76, index, zoneCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_vertical_oscillation field
     * Units: mm
     *
     * @return avg_vertical_oscillation
     */
    var avgVerticalOscillation: Float?
        get() {
            return getFieldFloatValue(77, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgVerticalOscillation) {
            setFieldValue(77, 0, avgVerticalOscillation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_stance_time_percent field
     * Units: percent
     *
     * @return avg_stance_time_percent
     */
    var avgStanceTimePercent: Float?
        get() {
            return getFieldFloatValue(78, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgStanceTimePercent) {
            setFieldValue(78, 0, avgStanceTimePercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_stance_time field
     * Units: ms
     *
     * @return avg_stance_time
     */
    var avgStanceTime: Float?
        get() {
            return getFieldFloatValue(79, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgStanceTime) {
            setFieldValue(79, 0, avgStanceTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(80, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgFractionalCadence) {
            setFieldValue(80, 0, avgFractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(81, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxFractionalCadence) {
            setFieldValue(81, 0, maxFractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(82, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFractionalCycles) {
            setFieldValue(82, 0, totalFractionalCycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get player_score field
     *
     * @return player_score
     */
    var playerScore: Int?
        get() {
            return getFieldIntegerValue(83, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(playerScore) {
            setFieldValue(83, 0, playerScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getAvgTotalHemoglobinConc(): Array<Float?>? {
        return getFieldFloatValues(84, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_total_hemoglobin_conc
     */
    fun getNumAvgTotalHemoglobinConc(): Int {
        return getNumFieldValues(84, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_total_hemoglobin_conc field
     * Units: g/dL
     * Comment: Avg saturated and unsaturated hemoglobin
     *
     * @param index of avg_total_hemoglobin_conc
     * @return avg_total_hemoglobin_conc
     */
    fun getAvgTotalHemoglobinConc(index: Int): Float? {
        return getFieldFloatValue(84, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_total_hemoglobin_conc field
     * Units: g/dL
     * Comment: Avg saturated and unsaturated hemoglobin
     *
     * @param index of avg_total_hemoglobin_conc
     * @param avgTotalHemoglobinConc The new avgTotalHemoglobinConc value to be set
     */
    fun setAvgTotalHemoglobinConc(index: Int, avgTotalHemoglobinConc: Float?) {
        setFieldValue(84, index, avgTotalHemoglobinConc, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMinTotalHemoglobinConc(): Array<Float?>? {
        return getFieldFloatValues(85, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of min_total_hemoglobin_conc
     */
    fun getNumMinTotalHemoglobinConc(): Int {
        return getNumFieldValues(85, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_total_hemoglobin_conc field
     * Units: g/dL
     * Comment: Min saturated and unsaturated hemoglobin
     *
     * @param index of min_total_hemoglobin_conc
     * @return min_total_hemoglobin_conc
     */
    fun getMinTotalHemoglobinConc(index: Int): Float? {
        return getFieldFloatValue(85, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_total_hemoglobin_conc field
     * Units: g/dL
     * Comment: Min saturated and unsaturated hemoglobin
     *
     * @param index of min_total_hemoglobin_conc
     * @param minTotalHemoglobinConc The new minTotalHemoglobinConc value to be set
     */
    fun setMinTotalHemoglobinConc(index: Int, minTotalHemoglobinConc: Float?) {
        setFieldValue(85, index, minTotalHemoglobinConc, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxTotalHemoglobinConc(): Array<Float?>? {
        return getFieldFloatValues(86, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_total_hemoglobin_conc
     */
    fun getNumMaxTotalHemoglobinConc(): Int {
        return getNumFieldValues(86, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_total_hemoglobin_conc field
     * Units: g/dL
     * Comment: Max saturated and unsaturated hemoglobin
     *
     * @param index of max_total_hemoglobin_conc
     * @return max_total_hemoglobin_conc
     */
    fun getMaxTotalHemoglobinConc(index: Int): Float? {
        return getFieldFloatValue(86, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_total_hemoglobin_conc field
     * Units: g/dL
     * Comment: Max saturated and unsaturated hemoglobin
     *
     * @param index of max_total_hemoglobin_conc
     * @param maxTotalHemoglobinConc The new maxTotalHemoglobinConc value to be set
     */
    fun setMaxTotalHemoglobinConc(index: Int, maxTotalHemoglobinConc: Float?) {
        setFieldValue(86, index, maxTotalHemoglobinConc, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgSaturatedHemoglobinPercent(): Array<Float?>? {
        return getFieldFloatValues(87, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_saturated_hemoglobin_percent
     */
    fun getNumAvgSaturatedHemoglobinPercent(): Int {
        return getNumFieldValues(87, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_saturated_hemoglobin_percent field
     * Units: %
     * Comment: Avg percentage of hemoglobin saturated with oxygen
     *
     * @param index of avg_saturated_hemoglobin_percent
     * @return avg_saturated_hemoglobin_percent
     */
    fun getAvgSaturatedHemoglobinPercent(index: Int): Float? {
        return getFieldFloatValue(87, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_saturated_hemoglobin_percent field
     * Units: %
     * Comment: Avg percentage of hemoglobin saturated with oxygen
     *
     * @param index of avg_saturated_hemoglobin_percent
     * @param avgSaturatedHemoglobinPercent The new avgSaturatedHemoglobinPercent value to be set
     */
    fun setAvgSaturatedHemoglobinPercent(index: Int, avgSaturatedHemoglobinPercent: Float?) {
        setFieldValue(87, index, avgSaturatedHemoglobinPercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMinSaturatedHemoglobinPercent(): Array<Float?>? {
        return getFieldFloatValues(88, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of min_saturated_hemoglobin_percent
     */
    fun getNumMinSaturatedHemoglobinPercent(): Int {
        return getNumFieldValues(88, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_saturated_hemoglobin_percent field
     * Units: %
     * Comment: Min percentage of hemoglobin saturated with oxygen
     *
     * @param index of min_saturated_hemoglobin_percent
     * @return min_saturated_hemoglobin_percent
     */
    fun getMinSaturatedHemoglobinPercent(index: Int): Float? {
        return getFieldFloatValue(88, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_saturated_hemoglobin_percent field
     * Units: %
     * Comment: Min percentage of hemoglobin saturated with oxygen
     *
     * @param index of min_saturated_hemoglobin_percent
     * @param minSaturatedHemoglobinPercent The new minSaturatedHemoglobinPercent value to be set
     */
    fun setMinSaturatedHemoglobinPercent(index: Int, minSaturatedHemoglobinPercent: Float?) {
        setFieldValue(88, index, minSaturatedHemoglobinPercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxSaturatedHemoglobinPercent(): Array<Float?>? {
        return getFieldFloatValues(89, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_saturated_hemoglobin_percent
     */
    fun getNumMaxSaturatedHemoglobinPercent(): Int {
        return getNumFieldValues(89, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_saturated_hemoglobin_percent field
     * Units: %
     * Comment: Max percentage of hemoglobin saturated with oxygen
     *
     * @param index of max_saturated_hemoglobin_percent
     * @return max_saturated_hemoglobin_percent
     */
    fun getMaxSaturatedHemoglobinPercent(index: Int): Float? {
        return getFieldFloatValue(89, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_saturated_hemoglobin_percent field
     * Units: %
     * Comment: Max percentage of hemoglobin saturated with oxygen
     *
     * @param index of max_saturated_hemoglobin_percent
     * @param maxSaturatedHemoglobinPercent The new maxSaturatedHemoglobinPercent value to be set
     */
    fun setMaxSaturatedHemoglobinPercent(index: Int, maxSaturatedHemoglobinPercent: Float?) {
        setFieldValue(89, index, maxSaturatedHemoglobinPercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_torque_effectiveness field
     * Units: percent
     *
     * @return avg_left_torque_effectiveness
     */
    var avgLeftTorqueEffectiveness: Float?
        get() {
            return getFieldFloatValue(91, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgLeftTorqueEffectiveness) {
            setFieldValue(91, 0, avgLeftTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_right_torque_effectiveness field
     * Units: percent
     *
     * @return avg_right_torque_effectiveness
     */
    var avgRightTorqueEffectiveness: Float?
        get() {
            return getFieldFloatValue(92, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRightTorqueEffectiveness) {
            setFieldValue(92, 0, avgRightTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_left_pedal_smoothness field
     * Units: percent
     *
     * @return avg_left_pedal_smoothness
     */
    var avgLeftPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(93, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgLeftPedalSmoothness) {
            setFieldValue(93, 0, avgLeftPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_right_pedal_smoothness field
     * Units: percent
     *
     * @return avg_right_pedal_smoothness
     */
    var avgRightPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(94, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRightPedalSmoothness) {
            setFieldValue(94, 0, avgRightPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_combined_pedal_smoothness field
     * Units: percent
     *
     * @return avg_combined_pedal_smoothness
     */
    var avgCombinedPedalSmoothness: Float?
        get() {
            return getFieldFloatValue(95, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgCombinedPedalSmoothness) {
            setFieldValue(95, 0, avgCombinedPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(98, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timeStanding) {
            setFieldValue(98, 0, timeStanding, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get stand_count field
     * Comment: Number of transitions to the standing state
     *
     * @return stand_count
     */
    var standCount: Int?
        get() {
            return getFieldIntegerValue(99, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(standCount) {
            setFieldValue(99, 0, standCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldByteValue(100, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgLeftPco) {
            setFieldValue(100, 0, avgLeftPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldByteValue(101, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRightPco) {
            setFieldValue(101, 0, avgRightPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getAvgLeftPowerPhase(): Array<Float?>? {
        return getFieldFloatValues(102, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_left_power_phase
     */
    fun getNumAvgLeftPowerPhase(): Int {
        return getNumFieldValues(102, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(102, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(102, index, avgLeftPowerPhase, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgLeftPowerPhasePeak(): Array<Float?>? {
        return getFieldFloatValues(103, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_left_power_phase_peak
     */
    fun getNumAvgLeftPowerPhasePeak(): Int {
        return getNumFieldValues(103, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(103, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(103, index, avgLeftPowerPhasePeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgRightPowerPhase(): Array<Float?>? {
        return getFieldFloatValues(104, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_right_power_phase
     */
    fun getNumAvgRightPowerPhase(): Int {
        return getNumFieldValues(104, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(104, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(104, index, avgRightPowerPhase, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgRightPowerPhasePeak(): Array<Float?>? {
        return getFieldFloatValues(105, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_right_power_phase_peak
     */
    fun getNumAvgRightPowerPhasePeak(): Int {
        return getNumFieldValues(105, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(105, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(105, index, avgRightPowerPhasePeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgPowerPosition(): Array<Int?>? {
        return getFieldIntegerValues(106, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_power_position
     */
    fun getNumAvgPowerPosition(): Int {
        return getNumFieldValues(106, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldIntegerValue(106, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(106, index, avgPowerPosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxPowerPosition(): Array<Int?>? {
        return getFieldIntegerValues(107, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_power_position
     */
    fun getNumMaxPowerPosition(): Int {
        return getNumFieldValues(107, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldIntegerValue(107, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(107, index, maxPowerPosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgCadencePosition(): Array<Short?>? {
        return getFieldShortValues(108, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_cadence_position
     */
    fun getNumAvgCadencePosition(): Int {
        return getNumFieldValues(108, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldShortValue(108, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(108, index, avgCadencePosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxCadencePosition(): Array<Short?>? {
        return getFieldShortValues(109, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_cadence_position
     */
    fun getNumMaxCadencePosition(): Int {
        return getNumFieldValues(109, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldShortValue(109, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(109, index, maxCadencePosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_avg_speed field
     * Units: m/s
     *
     * @return enhanced_avg_speed
     */
    var enhancedAvgSpeed: Float?
        get() {
            return getFieldFloatValue(110, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedAvgSpeed) {
            setFieldValue(110, 0, enhancedAvgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_max_speed field
     * Units: m/s
     *
     * @return enhanced_max_speed
     */
    var enhancedMaxSpeed: Float?
        get() {
            return getFieldFloatValue(111, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedMaxSpeed) {
            setFieldValue(111, 0, enhancedMaxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_avg_altitude field
     * Units: m
     *
     * @return enhanced_avg_altitude
     */
    var enhancedAvgAltitude: Float?
        get() {
            return getFieldFloatValue(112, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedAvgAltitude) {
            setFieldValue(112, 0, enhancedAvgAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_min_altitude field
     * Units: m
     *
     * @return enhanced_min_altitude
     */
    var enhancedMinAltitude: Float?
        get() {
            return getFieldFloatValue(113, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedMinAltitude) {
            setFieldValue(113, 0, enhancedMinAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_max_altitude field
     * Units: m
     *
     * @return enhanced_max_altitude
     */
    var enhancedMaxAltitude: Float?
        get() {
            return getFieldFloatValue(114, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedMaxAltitude) {
            setFieldValue(114, 0, enhancedMaxAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_lev_motor_power field
     * Units: watts
     * Comment: lev average motor power during lap
     *
     * @return avg_lev_motor_power
     */
    var avgLevMotorPower: Int?
        get() {
            return getFieldIntegerValue(115, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgLevMotorPower) {
            setFieldValue(115, 0, avgLevMotorPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_lev_motor_power field
     * Units: watts
     * Comment: lev maximum motor power during lap
     *
     * @return max_lev_motor_power
     */
    var maxLevMotorPower: Int?
        get() {
            return getFieldIntegerValue(116, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxLevMotorPower) {
            setFieldValue(116, 0, maxLevMotorPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get lev_battery_consumption field
     * Units: percent
     * Comment: lev battery consumption during lap
     *
     * @return lev_battery_consumption
     */
    var levBatteryConsumption: Float?
        get() {
            return getFieldFloatValue(117, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(levBatteryConsumption) {
            setFieldValue(117, 0, levBatteryConsumption, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_vertical_ratio field
     * Units: percent
     *
     * @return avg_vertical_ratio
     */
    var avgVerticalRatio: Float?
        get() {
            return getFieldFloatValue(118, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgVerticalRatio) {
            setFieldValue(118, 0, avgVerticalRatio, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_stance_time_balance field
     * Units: percent
     *
     * @return avg_stance_time_balance
     */
    var avgStanceTimeBalance: Float?
        get() {
            return getFieldFloatValue(119, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgStanceTimeBalance) {
            setFieldValue(119, 0, avgStanceTimeBalance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_step_length field
     * Units: mm
     *
     * @return avg_step_length
     */
    var avgStepLength: Float?
        get() {
            return getFieldFloatValue(120, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgStepLength) {
            setFieldValue(120, 0, avgStepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_vam field
     * Units: m/s
     *
     * @return avg_vam
     */
    var avgVam: Float?
        get() {
            return getFieldFloatValue(121, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgVam) {
            setFieldValue(121, 0, avgVam, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return avg_depth
     */
    var avgDepth: Float?
        get() {
            return getFieldFloatValue(122, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgDepth) {
            setFieldValue(122, 0, avgDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return max_depth
     */
    var maxDepth: Float?
        get() {
            return getFieldFloatValue(123, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxDepth) {
            setFieldValue(123, 0, maxDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get min_temperature field
     * Units: C
     *
     * @return min_temperature
     */
    var minTemperature: Byte?
        get() {
            return getFieldByteValue(124, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(minTemperature) {
            setFieldValue(124, 0, minTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_avg_respiration_rate field
     * Units: Breaths/min
     *
     * @return enhanced_avg_respiration_rate
     */
    var enhancedAvgRespirationRate: Float?
        get() {
            return getFieldFloatValue(136, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedAvgRespirationRate) {
            setFieldValue(136, 0, enhancedAvgRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_max_respiration_rate field
     * Units: Breaths/min
     *
     * @return enhanced_max_respiration_rate
     */
    var enhancedMaxRespirationRate: Float?
        get() {
            return getFieldFloatValue(137, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedMaxRespirationRate) {
            setFieldValue(137, 0, enhancedMaxRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_respiration_rate field
     *
     * @return avg_respiration_rate
     */
    var avgRespirationRate: Short?
        get() {
            return getFieldShortValue(147, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRespirationRate) {
            setFieldValue(147, 0, avgRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_respiration_rate field
     *
     * @return max_respiration_rate
     */
    var maxRespirationRate: Short?
        get() {
            return getFieldShortValue(148, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxRespirationRate) {
            setFieldValue(148, 0, maxRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(149, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalGrit) {
            setFieldValue(149, 0, totalGrit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(150, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFlow) {
            setFieldValue(150, 0, totalFlow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get jump_count field
     *
     * @return jump_count
     */
    var jumpCount: Int?
        get() {
            return getFieldIntegerValue(151, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(jumpCount) {
            setFieldValue(151, 0, jumpCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(153, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgGrit) {
            setFieldValue(153, 0, avgGrit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(154, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgFlow) {
            setFieldValue(154, 0, avgFlow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(156, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFractionalAscent) {
            setFieldValue(156, 0, totalFractionalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
            return getFieldFloatValue(157, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalFractionalDescent) {
            setFieldValue(157, 0, totalFractionalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_core_temperature field
     * Units: C
     *
     * @return avg_core_temperature
     */
    var avgCoreTemperature: Float?
        get() {
            return getFieldFloatValue(158, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgCoreTemperature) {
            setFieldValue(158, 0, avgCoreTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get min_core_temperature field
     * Units: C
     *
     * @return min_core_temperature
     */
    var minCoreTemperature: Float?
        get() {
            return getFieldFloatValue(159, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(minCoreTemperature) {
            setFieldValue(159, 0, minCoreTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_core_temperature field
     * Units: C
     *
     * @return max_core_temperature
     */
    var maxCoreTemperature: Float?
        get() {
            return getFieldFloatValue(160, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxCoreTemperature) {
            setFieldValue(160, 0, maxCoreTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
