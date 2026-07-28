/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SessionMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SessionMesg : Mesg, MesgWithEvent {

    companion object {
        const val MessageIndexFieldNum = 254
        const val TimestampFieldNum = 253
        const val EventFieldNum = 0
        const val EventTypeFieldNum = 1
        const val StartTimeFieldNum = 2
        const val StartPositionLatFieldNum = 3
        const val StartPositionLongFieldNum = 4
        const val SportFieldNum = 5
        const val SubSportFieldNum = 6
        const val TotalElapsedTimeFieldNum = 7
        const val TotalTimerTimeFieldNum = 8
        const val TotalDistanceFieldNum = 9
        const val TotalCyclesFieldNum = 10
        const val TotalCaloriesFieldNum = 11
        const val TotalFatCaloriesFieldNum = 13
        const val AvgSpeedFieldNum = 14
        const val MaxSpeedFieldNum = 15
        const val AvgHeartRateFieldNum = 16
        const val MaxHeartRateFieldNum = 17
        const val AvgCadenceFieldNum = 18
        const val MaxCadenceFieldNum = 19
        const val AvgPowerFieldNum = 20
        const val MaxPowerFieldNum = 21
        const val TotalAscentFieldNum = 22
        const val TotalDescentFieldNum = 23
        const val TotalTrainingEffectFieldNum = 24
        const val FirstLapIndexFieldNum = 25
        const val NumLapsFieldNum = 26
        const val EventGroupFieldNum = 27
        const val TriggerFieldNum = 28
        const val NecLatFieldNum = 29
        const val NecLongFieldNum = 30
        const val SwcLatFieldNum = 31
        const val SwcLongFieldNum = 32
        const val NumLengthsFieldNum = 33
        const val NormalizedPowerFieldNum = 34
        const val TrainingStressScoreFieldNum = 35
        const val IntensityFactorFieldNum = 36
        const val LeftRightBalanceFieldNum = 37
        const val EndPositionLatFieldNum = 38
        const val EndPositionLongFieldNum = 39
        const val AvgStrokeCountFieldNum = 41
        const val AvgStrokeDistanceFieldNum = 42
        const val SwimStrokeFieldNum = 43
        const val PoolLengthFieldNum = 44
        const val ThresholdPowerFieldNum = 45
        const val PoolLengthUnitFieldNum = 46
        const val NumActiveLengthsFieldNum = 47
        const val TotalWorkFieldNum = 48
        const val AvgAltitudeFieldNum = 49
        const val MaxAltitudeFieldNum = 50
        const val GpsAccuracyFieldNum = 51
        const val AvgGradeFieldNum = 52
        const val AvgPosGradeFieldNum = 53
        const val AvgNegGradeFieldNum = 54
        const val MaxPosGradeFieldNum = 55
        const val MaxNegGradeFieldNum = 56
        const val AvgTemperatureFieldNum = 57
        const val MaxTemperatureFieldNum = 58
        const val TotalMovingTimeFieldNum = 59
        const val AvgPosVerticalSpeedFieldNum = 60
        const val AvgNegVerticalSpeedFieldNum = 61
        const val MaxPosVerticalSpeedFieldNum = 62
        const val MaxNegVerticalSpeedFieldNum = 63
        const val MinHeartRateFieldNum = 64
        const val TimeInHrZoneFieldNum = 65
        const val TimeInSpeedZoneFieldNum = 66
        const val TimeInCadenceZoneFieldNum = 67
        const val TimeInPowerZoneFieldNum = 68
        const val AvgLapTimeFieldNum = 69
        const val BestLapIndexFieldNum = 70
        const val MinAltitudeFieldNum = 71
        const val ActiveTimeFieldNum = 78
        const val PlayerScoreFieldNum = 82
        const val OpponentScoreFieldNum = 83
        const val OpponentNameFieldNum = 84
        const val StrokeCountFieldNum = 85
        const val ZoneCountFieldNum = 86
        const val MaxBallSpeedFieldNum = 87
        const val AvgBallSpeedFieldNum = 88
        const val AvgVerticalOscillationFieldNum = 89
        const val AvgStanceTimePercentFieldNum = 90
        const val AvgStanceTimeFieldNum = 91
        const val AvgFractionalCadenceFieldNum = 92
        const val MaxFractionalCadenceFieldNum = 93
        const val TotalFractionalCyclesFieldNum = 94
        const val AvgTotalHemoglobinConcFieldNum = 95
        const val MinTotalHemoglobinConcFieldNum = 96
        const val MaxTotalHemoglobinConcFieldNum = 97
        const val AvgSaturatedHemoglobinPercentFieldNum = 98
        const val MinSaturatedHemoglobinPercentFieldNum = 99
        const val MaxSaturatedHemoglobinPercentFieldNum = 100
        const val AvgLeftTorqueEffectivenessFieldNum = 101
        const val AvgRightTorqueEffectivenessFieldNum = 102
        const val AvgLeftPedalSmoothnessFieldNum = 103
        const val AvgRightPedalSmoothnessFieldNum = 104
        const val AvgCombinedPedalSmoothnessFieldNum = 105
        const val SportProfileNameFieldNum = 110
        const val SportIndexFieldNum = 111
        const val TimeStandingFieldNum = 112
        const val StandCountFieldNum = 113
        const val AvgLeftPcoFieldNum = 114
        const val AvgRightPcoFieldNum = 115
        const val AvgLeftPowerPhaseFieldNum = 116
        const val AvgLeftPowerPhasePeakFieldNum = 117
        const val AvgRightPowerPhaseFieldNum = 118
        const val AvgRightPowerPhasePeakFieldNum = 119
        const val AvgPowerPositionFieldNum = 120
        const val MaxPowerPositionFieldNum = 121
        const val AvgCadencePositionFieldNum = 122
        const val MaxCadencePositionFieldNum = 123
        const val EnhancedAvgSpeedFieldNum = 124
        const val EnhancedMaxSpeedFieldNum = 125
        const val EnhancedAvgAltitudeFieldNum = 126
        const val EnhancedMinAltitudeFieldNum = 127
        const val EnhancedMaxAltitudeFieldNum = 128
        const val AvgLevMotorPowerFieldNum = 129
        const val MaxLevMotorPowerFieldNum = 130
        const val LevBatteryConsumptionFieldNum = 131
        const val AvgVerticalRatioFieldNum = 132
        const val AvgStanceTimeBalanceFieldNum = 133
        const val AvgStepLengthFieldNum = 134
        const val TotalAnaerobicTrainingEffectFieldNum = 137
        const val AvgVamFieldNum = 139
        const val AvgDepthFieldNum = 140
        const val MaxDepthFieldNum = 141
        const val SurfaceIntervalFieldNum = 142
        const val StartCnsFieldNum = 143
        const val EndCnsFieldNum = 144
        const val StartN2FieldNum = 145
        const val EndN2FieldNum = 146
        const val AvgRespirationRateFieldNum = 147
        const val MaxRespirationRateFieldNum = 148
        const val MinRespirationRateFieldNum = 149
        const val MinTemperatureFieldNum = 150
        const val O2ToxicityFieldNum = 155
        const val DiveNumberFieldNum = 156
        const val TrainingLoadPeakFieldNum = 168
        const val EnhancedAvgRespirationRateFieldNum = 169
        const val EnhancedMaxRespirationRateFieldNum = 170
        const val EnhancedMinRespirationRateFieldNum = 180
        const val TotalGritFieldNum = 181
        const val TotalFlowFieldNum = 182
        const val JumpCountFieldNum = 183
        const val AvgGritFieldNum = 186
        const val AvgFlowFieldNum = 187
        const val WorkoutFeelFieldNum = 192
        const val WorkoutRpeFieldNum = 193
        const val AvgSpo2FieldNum = 194
        const val AvgStressFieldNum = 195
        const val MetabolicCaloriesFieldNum = 196
        const val SdrrHrvFieldNum = 197
        const val RmssdHrvFieldNum = 198
        const val TotalFractionalAscentFieldNum = 199
        const val TotalFractionalDescentFieldNum = 200
        const val AvgCoreTemperatureFieldNum = 208
        const val MinCoreTemperatureFieldNum = 209
        const val MaxCoreTemperatureFieldNum = 210

        val sessionMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // session
            val sessionMesg = Mesg("session", MesgNum.SESSION)
            sessionMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            sessionMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            sessionMesg.addField(Field("event", EventFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT))
            field_index++
            sessionMesg.addField(Field("event_type", EventTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT_TYPE))
            field_index++
            sessionMesg.addField(Field("start_time", StartTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            sessionMesg.addField(Field("start_position_lat", StartPositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("start_position_long", StartPositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            field_index++
            sessionMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            field_index++
            sessionMesg.addField(Field("total_elapsed_time", TotalElapsedTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("total_timer_time", TotalTimerTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("total_distance", TotalDistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("total_cycles", TotalCyclesFieldNum, 134, 1.0, 0.0, "cycles", false, Profile.Type.UINT32))
            subfield_index = 0
            sessionMesg.fields[field_index].subFields.add(SubField("total_strides", 134, 1.0, 0.0, "strides"))
            sessionMesg.fields[field_index].subFields[subfield_index].addMap(5, 1L)
            sessionMesg.fields[field_index].subFields[subfield_index].addMap(5, 11L)
            subfield_index++
            sessionMesg.fields[field_index].subFields.add(SubField("total_strokes", 134, 1.0, 0.0, "strokes"))
            sessionMesg.fields[field_index].subFields[subfield_index].addMap(5, 2L)
            sessionMesg.fields[field_index].subFields[subfield_index].addMap(5, 5L)
            sessionMesg.fields[field_index].subFields[subfield_index].addMap(5, 15L)
            sessionMesg.fields[field_index].subFields[subfield_index].addMap(5, 37L)
            subfield_index++
            field_index++
            sessionMesg.addField(Field("total_calories", TotalCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("total_fat_calories", TotalFatCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_speed", AvgSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            sessionMesg.fields[field_index].components.add(FieldComponent(124, false, 16, 1000.0, 0.0)) // enhanced_avg_speed
            field_index++
            sessionMesg.addField(Field("max_speed", MaxSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            sessionMesg.fields[field_index].components.add(FieldComponent(125, false, 16, 1000.0, 0.0)) // enhanced_max_speed
            field_index++
            sessionMesg.addField(Field("avg_heart_rate", AvgHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("max_heart_rate", MaxHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_cadence", AvgCadenceFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            subfield_index = 0
            sessionMesg.fields[field_index].subFields.add(SubField("avg_running_cadence", 2, 1.0, 0.0, "strides/min"))
            sessionMesg.fields[field_index].subFields[subfield_index].addMap(5, 1L)
            subfield_index++
            field_index++
            sessionMesg.addField(Field("max_cadence", MaxCadenceFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            subfield_index = 0
            sessionMesg.fields[field_index].subFields.add(SubField("max_running_cadence", 2, 1.0, 0.0, "strides/min"))
            sessionMesg.fields[field_index].subFields[subfield_index].addMap(5, 1L)
            subfield_index++
            field_index++
            sessionMesg.addField(Field("avg_power", AvgPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("max_power", MaxPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("total_ascent", TotalAscentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("total_descent", TotalDescentFieldNum, 132, 1.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("total_training_effect", TotalTrainingEffectFieldNum, 2, 10.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("first_lap_index", FirstLapIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("num_laps", NumLapsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("event_group", EventGroupFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("trigger", TriggerFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SESSION_TRIGGER))
            field_index++
            sessionMesg.addField(Field("nec_lat", NecLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("nec_long", NecLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("swc_lat", SwcLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("swc_long", SwcLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("num_lengths", NumLengthsFieldNum, 132, 1.0, 0.0, "lengths", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("normalized_power", NormalizedPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("training_stress_score", TrainingStressScoreFieldNum, 132, 10.0, 0.0, "tss", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("intensity_factor", IntensityFactorFieldNum, 132, 1000.0, 0.0, "if", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("left_right_balance", LeftRightBalanceFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.LEFT_RIGHT_BALANCE_100))
            field_index++
            sessionMesg.addField(Field("end_position_lat", EndPositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("end_position_long", EndPositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("avg_stroke_count", AvgStrokeCountFieldNum, 134, 10.0, 0.0, "strokes/lap", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("avg_stroke_distance", AvgStrokeDistanceFieldNum, 132, 100.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("swim_stroke", SwimStrokeFieldNum, 0, 1.0, 0.0, "swim_stroke", false, Profile.Type.SWIM_STROKE))
            field_index++
            sessionMesg.addField(Field("pool_length", PoolLengthFieldNum, 132, 100.0, 0.0, "m", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("threshold_power", ThresholdPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("pool_length_unit", PoolLengthUnitFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            field_index++
            sessionMesg.addField(Field("num_active_lengths", NumActiveLengthsFieldNum, 132, 1.0, 0.0, "lengths", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("total_work", TotalWorkFieldNum, 134, 1.0, 0.0, "J", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("avg_altitude", AvgAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            sessionMesg.fields[field_index].components.add(FieldComponent(126, false, 16, 5.0, 500.0)) // enhanced_avg_altitude
            field_index++
            sessionMesg.addField(Field("max_altitude", MaxAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            sessionMesg.fields[field_index].components.add(FieldComponent(128, false, 16, 5.0, 500.0)) // enhanced_max_altitude
            field_index++
            sessionMesg.addField(Field("gps_accuracy", GpsAccuracyFieldNum, 2, 1.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_grade", AvgGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("avg_pos_grade", AvgPosGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("avg_neg_grade", AvgNegGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("max_pos_grade", MaxPosGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("max_neg_grade", MaxNegGradeFieldNum, 131, 100.0, 0.0, "%", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("avg_temperature", AvgTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            sessionMesg.addField(Field("max_temperature", MaxTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            sessionMesg.addField(Field("total_moving_time", TotalMovingTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("avg_pos_vertical_speed", AvgPosVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("avg_neg_vertical_speed", AvgNegVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("max_pos_vertical_speed", MaxPosVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("max_neg_vertical_speed", MaxNegVerticalSpeedFieldNum, 131, 1000.0, 0.0, "m/s", false, Profile.Type.SINT16))
            field_index++
            sessionMesg.addField(Field("min_heart_rate", MinHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("time_in_hr_zone", TimeInHrZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("time_in_speed_zone", TimeInSpeedZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("time_in_cadence_zone", TimeInCadenceZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("time_in_power_zone", TimeInPowerZoneFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("avg_lap_time", AvgLapTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("best_lap_index", BestLapIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("min_altitude", MinAltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            sessionMesg.fields[field_index].components.add(FieldComponent(127, false, 16, 5.0, 500.0)) // enhanced_min_altitude
            field_index++
            sessionMesg.addField(Field("active_time", ActiveTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("player_score", PlayerScoreFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("opponent_score", OpponentScoreFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("opponent_name", OpponentNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            sessionMesg.addField(Field("stroke_count", StrokeCountFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("zone_count", ZoneCountFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("max_ball_speed", MaxBallSpeedFieldNum, 132, 100.0, 0.0, "m/s", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_ball_speed", AvgBallSpeedFieldNum, 132, 100.0, 0.0, "m/s", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_vertical_oscillation", AvgVerticalOscillationFieldNum, 132, 10.0, 0.0, "mm", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_stance_time_percent", AvgStanceTimePercentFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_stance_time", AvgStanceTimeFieldNum, 132, 10.0, 0.0, "ms", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_fractional_cadence", AvgFractionalCadenceFieldNum, 2, 128.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("max_fractional_cadence", MaxFractionalCadenceFieldNum, 2, 128.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("total_fractional_cycles", TotalFractionalCyclesFieldNum, 2, 128.0, 0.0, "cycles", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_total_hemoglobin_conc", AvgTotalHemoglobinConcFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("min_total_hemoglobin_conc", MinTotalHemoglobinConcFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("max_total_hemoglobin_conc", MaxTotalHemoglobinConcFieldNum, 132, 100.0, 0.0, "g/dL", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_saturated_hemoglobin_percent", AvgSaturatedHemoglobinPercentFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("min_saturated_hemoglobin_percent", MinSaturatedHemoglobinPercentFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("max_saturated_hemoglobin_percent", MaxSaturatedHemoglobinPercentFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_left_torque_effectiveness", AvgLeftTorqueEffectivenessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_right_torque_effectiveness", AvgRightTorqueEffectivenessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_left_pedal_smoothness", AvgLeftPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_right_pedal_smoothness", AvgRightPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_combined_pedal_smoothness", AvgCombinedPedalSmoothnessFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("sport_profile_name", SportProfileNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            sessionMesg.addField(Field("sport_index", SportIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("time_standing", TimeStandingFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("stand_count", StandCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_left_pco", AvgLeftPcoFieldNum, 1, 1.0, 0.0, "mm", false, Profile.Type.SINT8))
            field_index++
            sessionMesg.addField(Field("avg_right_pco", AvgRightPcoFieldNum, 1, 1.0, 0.0, "mm", false, Profile.Type.SINT8))
            field_index++
            sessionMesg.addField(Field("avg_left_power_phase", AvgLeftPowerPhaseFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_left_power_phase_peak", AvgLeftPowerPhasePeakFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_right_power_phase", AvgRightPowerPhaseFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_right_power_phase_peak", AvgRightPowerPhasePeakFieldNum, 2, 0.7111111, 0.0, "degrees", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_power_position", AvgPowerPositionFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("max_power_position", MaxPowerPositionFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_cadence_position", AvgCadencePositionFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("max_cadence_position", MaxCadencePositionFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("enhanced_avg_speed", EnhancedAvgSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("enhanced_max_speed", EnhancedMaxSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("enhanced_avg_altitude", EnhancedAvgAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("enhanced_min_altitude", EnhancedMinAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("enhanced_max_altitude", EnhancedMaxAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("avg_lev_motor_power", AvgLevMotorPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("max_lev_motor_power", MaxLevMotorPowerFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("lev_battery_consumption", LevBatteryConsumptionFieldNum, 2, 2.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_vertical_ratio", AvgVerticalRatioFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_stance_time_balance", AvgStanceTimeBalanceFieldNum, 132, 100.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_step_length", AvgStepLengthFieldNum, 132, 10.0, 0.0, "mm", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("total_anaerobic_training_effect", TotalAnaerobicTrainingEffectFieldNum, 2, 10.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_vam", AvgVamFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_depth", AvgDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("max_depth", MaxDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("surface_interval", SurfaceIntervalFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("start_cns", StartCnsFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("end_cns", EndCnsFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("start_n2", StartN2FieldNum, 132, 1.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("end_n2", EndN2FieldNum, 132, 1.0, 0.0, "percent", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_respiration_rate", AvgRespirationRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sessionMesg.fields[field_index].components.add(FieldComponent(169, false, 8, 1.0, 0.0)) // enhanced_avg_respiration_rate
            field_index++
            sessionMesg.addField(Field("max_respiration_rate", MaxRespirationRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sessionMesg.fields[field_index].components.add(FieldComponent(170, false, 8, 1.0, 0.0)) // enhanced_max_respiration_rate
            field_index++
            sessionMesg.addField(Field("min_respiration_rate", MinRespirationRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sessionMesg.fields[field_index].components.add(FieldComponent(180, false, 8, 1.0, 0.0)) // enhanced_min_respiration_rate
            field_index++
            sessionMesg.addField(Field("min_temperature", MinTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            field_index++
            sessionMesg.addField(Field("o2_toxicity", O2ToxicityFieldNum, 132, 1.0, 0.0, "OTUs", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("dive_number", DiveNumberFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            field_index++
            sessionMesg.addField(Field("training_load_peak", TrainingLoadPeakFieldNum, 133, 65536.0, 0.0, "", false, Profile.Type.SINT32))
            field_index++
            sessionMesg.addField(Field("enhanced_avg_respiration_rate", EnhancedAvgRespirationRateFieldNum, 132, 100.0, 0.0, "Breaths/min", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("enhanced_max_respiration_rate", EnhancedMaxRespirationRateFieldNum, 132, 100.0, 0.0, "Breaths/min", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("enhanced_min_respiration_rate", EnhancedMinRespirationRateFieldNum, 132, 100.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("total_grit", TotalGritFieldNum, 136, 1.0, 0.0, "kGrit", false, Profile.Type.FLOAT32))
            field_index++
            sessionMesg.addField(Field("total_flow", TotalFlowFieldNum, 136, 1.0, 0.0, "Flow", false, Profile.Type.FLOAT32))
            field_index++
            sessionMesg.addField(Field("jump_count", JumpCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("avg_grit", AvgGritFieldNum, 136, 1.0, 0.0, "kGrit", false, Profile.Type.FLOAT32))
            field_index++
            sessionMesg.addField(Field("avg_flow", AvgFlowFieldNum, 136, 1.0, 0.0, "Flow", false, Profile.Type.FLOAT32))
            field_index++
            sessionMesg.addField(Field("workout_feel", WorkoutFeelFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("workout_rpe", WorkoutRpeFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_spo2", AvgSpo2FieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_stress", AvgStressFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("metabolic_calories", MetabolicCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("sdrr_hrv", SdrrHrvFieldNum, 2, 1.0, 0.0, "mS", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("rmssd_hrv", RmssdHrvFieldNum, 2, 1.0, 0.0, "mS", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("total_fractional_ascent", TotalFractionalAscentFieldNum, 2, 100.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("total_fractional_descent", TotalFractionalDescentFieldNum, 2, 100.0, 0.0, "m", false, Profile.Type.UINT8))
            field_index++
            sessionMesg.addField(Field("avg_core_temperature", AvgCoreTemperatureFieldNum, 132, 100.0, 0.0, "C", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("min_core_temperature", MinCoreTemperatureFieldNum, 132, 100.0, 0.0, "C", false, Profile.Type.UINT16))
            field_index++
            sessionMesg.addField(Field("max_core_temperature", MaxCoreTemperatureFieldNum, 132, 100.0, 0.0, "C", false, Profile.Type.UINT16))
            field_index++
            sessionMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SESSION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     * Comment: Selected bit is set for the current session.
     *
     * @return message_index
     */
    fun getMessageIndex(): Int? {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_index field
     * Comment: Selected bit is set for the current session.
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
     * Comment: session
     *
     * @return event
     */
    override fun getEvent(): Event? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Event.fromValue(value)
    }

    /**
     * Set event field
     * Comment: session
     *
     * @param event The new event value to be set
     */
    override fun setEvent(event: Event?) {
        setFieldValue(0, 0, event?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event_type field
     * Comment: stop
     *
     * @return event_type
     */
    override fun getEventType(): EventType? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return EventType.fromValue(value)
    }

    /**
     * Set event_type field
     * Comment: stop
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
     * Get sport field
     *
     * @return sport
     */
    fun getSport(): Sport? {
        val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Sport.fromValue(value)
    }

    /**
     * Set sport field
     *
     * @param sport The new sport value to be set
     */
    fun setSport(sport: Sport?) {
        setFieldValue(5, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    fun getSubSport(): SubSport? {
        val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SubSport.fromValue(value)
    }

    /**
     * Set sub_sport field
     *
     * @param subSport The new subSport value to be set
     */
    fun setSubSport(subSport: SubSport?) {
        setFieldValue(6, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
     * Get total_strides field
     * Units: strides
     *
     * @return total_strides
     */
    fun getTotalStrides(): Long? {
        return getFieldLongValue(10, 0, Profile.SubFields.SESSION_MESG_TOTAL_CYCLES_FIELD_TOTAL_STRIDES)
    }

    /**
     * Set total_strides field
     * Units: strides
     *
     * @param totalStrides The new totalStrides value to be set
     */
    fun setTotalStrides(totalStrides: Long?) {
        setFieldValue(10, 0, totalStrides, Profile.SubFields.SESSION_MESG_TOTAL_CYCLES_FIELD_TOTAL_STRIDES)
    }

    /**
     * Get total_strokes field
     * Units: strokes
     *
     * @return total_strokes
     */
    fun getTotalStrokes(): Long? {
        return getFieldLongValue(10, 0, Profile.SubFields.SESSION_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES)
    }

    /**
     * Set total_strokes field
     * Units: strokes
     *
     * @param totalStrokes The new totalStrokes value to be set
     */
    fun setTotalStrokes(totalStrokes: Long?) {
        setFieldValue(10, 0, totalStrokes, Profile.SubFields.SESSION_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES)
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
     *
     * @return total_fat_calories
     */
    fun getTotalFatCalories(): Int? {
        return getFieldIntegerValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_fat_calories field
     * Units: kcal
     *
     * @param totalFatCalories The new totalFatCalories value to be set
     */
    fun setTotalFatCalories(totalFatCalories: Int?) {
        setFieldValue(13, 0, totalFatCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_speed field
     * Units: m/s
     * Comment: total_distance / total_timer_time
     *
     * @return avg_speed
     */
    fun getAvgSpeed(): Float? {
        return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_speed field
     * Units: m/s
     * Comment: total_distance / total_timer_time
     *
     * @param avgSpeed The new avgSpeed value to be set
     */
    fun setAvgSpeed(avgSpeed: Float?) {
        setFieldValue(14, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_speed field
     * Units: m/s
     *
     * @return max_speed
     */
    fun getMaxSpeed(): Float? {
        return getFieldFloatValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_speed field
     * Units: m/s
     *
     * @param maxSpeed The new maxSpeed value to be set
     */
    fun setMaxSpeed(maxSpeed: Float?) {
        setFieldValue(15, 0, maxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_heart_rate field
     * Units: bpm
     * Comment: average heart rate (excludes pause time)
     *
     * @return avg_heart_rate
     */
    fun getAvgHeartRate(): Short? {
        return getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_heart_rate field
     * Units: bpm
     * Comment: average heart rate (excludes pause time)
     *
     * @param avgHeartRate The new avgHeartRate value to be set
     */
    fun setAvgHeartRate(avgHeartRate: Short?) {
        setFieldValue(16, 0, avgHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_heart_rate field
     * Units: bpm
     *
     * @return max_heart_rate
     */
    fun getMaxHeartRate(): Short? {
        return getFieldShortValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_heart_rate field
     * Units: bpm
     *
     * @param maxHeartRate The new maxHeartRate value to be set
     */
    fun setMaxHeartRate(maxHeartRate: Short?) {
        setFieldValue(17, 0, maxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_cadence field
     * Units: rpm
     * Comment: total_cycles / total_timer_time if non_zero_avg_cadence otherwise total_cycles / total_elapsed_time
     *
     * @return avg_cadence
     */
    fun getAvgCadence(): Short? {
        return getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_cadence field
     * Units: rpm
     * Comment: total_cycles / total_timer_time if non_zero_avg_cadence otherwise total_cycles / total_elapsed_time
     *
     * @param avgCadence The new avgCadence value to be set
     */
    fun setAvgCadence(avgCadence: Short?) {
        setFieldValue(18, 0, avgCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_running_cadence field
     * Units: strides/min
     *
     * @return avg_running_cadence
     */
    fun getAvgRunningCadence(): Short? {
        return getFieldShortValue(18, 0, Profile.SubFields.SESSION_MESG_AVG_CADENCE_FIELD_AVG_RUNNING_CADENCE)
    }

    /**
     * Set avg_running_cadence field
     * Units: strides/min
     *
     * @param avgRunningCadence The new avgRunningCadence value to be set
     */
    fun setAvgRunningCadence(avgRunningCadence: Short?) {
        setFieldValue(18, 0, avgRunningCadence, Profile.SubFields.SESSION_MESG_AVG_CADENCE_FIELD_AVG_RUNNING_CADENCE)
    }

    /**
     * Get max_cadence field
     * Units: rpm
     *
     * @return max_cadence
     */
    fun getMaxCadence(): Short? {
        return getFieldShortValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_cadence field
     * Units: rpm
     *
     * @param maxCadence The new maxCadence value to be set
     */
    fun setMaxCadence(maxCadence: Short?) {
        setFieldValue(19, 0, maxCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_running_cadence field
     * Units: strides/min
     *
     * @return max_running_cadence
     */
    fun getMaxRunningCadence(): Short? {
        return getFieldShortValue(19, 0, Profile.SubFields.SESSION_MESG_MAX_CADENCE_FIELD_MAX_RUNNING_CADENCE)
    }

    /**
     * Set max_running_cadence field
     * Units: strides/min
     *
     * @param maxRunningCadence The new maxRunningCadence value to be set
     */
    fun setMaxRunningCadence(maxRunningCadence: Short?) {
        setFieldValue(19, 0, maxRunningCadence, Profile.SubFields.SESSION_MESG_MAX_CADENCE_FIELD_MAX_RUNNING_CADENCE)
    }

    /**
     * Get avg_power field
     * Units: watts
     * Comment: total_power / total_timer_time if non_zero_avg_power otherwise total_power / total_elapsed_time
     *
     * @return avg_power
     */
    fun getAvgPower(): Int? {
        return getFieldIntegerValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_power field
     * Units: watts
     * Comment: total_power / total_timer_time if non_zero_avg_power otherwise total_power / total_elapsed_time
     *
     * @param avgPower The new avgPower value to be set
     */
    fun setAvgPower(avgPower: Int?) {
        setFieldValue(20, 0, avgPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_power field
     * Units: watts
     *
     * @return max_power
     */
    fun getMaxPower(): Int? {
        return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_power field
     * Units: watts
     *
     * @param maxPower The new maxPower value to be set
     */
    fun setMaxPower(maxPower: Int?) {
        setFieldValue(21, 0, maxPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_ascent field
     * Units: m
     *
     * @return total_ascent
     */
    fun getTotalAscent(): Int? {
        return getFieldIntegerValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_ascent field
     * Units: m
     *
     * @param totalAscent The new totalAscent value to be set
     */
    fun setTotalAscent(totalAscent: Int?) {
        setFieldValue(22, 0, totalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_descent field
     * Units: m
     *
     * @return total_descent
     */
    fun getTotalDescent(): Int? {
        return getFieldIntegerValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_descent field
     * Units: m
     *
     * @param totalDescent The new totalDescent value to be set
     */
    fun setTotalDescent(totalDescent: Int?) {
        setFieldValue(23, 0, totalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_training_effect field
     *
     * @return total_training_effect
     */
    fun getTotalTrainingEffect(): Float? {
        return getFieldFloatValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_training_effect field
     *
     * @param totalTrainingEffect The new totalTrainingEffect value to be set
     */
    fun setTotalTrainingEffect(totalTrainingEffect: Float?) {
        setFieldValue(24, 0, totalTrainingEffect, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get first_lap_index field
     *
     * @return first_lap_index
     */
    fun getFirstLapIndex(): Int? {
        return getFieldIntegerValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set first_lap_index field
     *
     * @param firstLapIndex The new firstLapIndex value to be set
     */
    fun setFirstLapIndex(firstLapIndex: Int?) {
        setFieldValue(25, 0, firstLapIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get num_laps field
     *
     * @return num_laps
     */
    fun getNumLaps(): Int? {
        return getFieldIntegerValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set num_laps field
     *
     * @param numLaps The new numLaps value to be set
     */
    fun setNumLaps(numLaps: Int?) {
        setFieldValue(26, 0, numLaps, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override fun getEventGroup(): Short? {
        return getFieldShortValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set event_group field
     *
     * @param eventGroup The new eventGroup value to be set
     */
    override fun setEventGroup(eventGroup: Short?) {
        setFieldValue(27, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get trigger field
     *
     * @return trigger
     */
    fun getTrigger(): SessionTrigger? {
        val value = getFieldShortValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SessionTrigger.fromValue(value)
    }

    /**
     * Set trigger field
     *
     * @param trigger The new trigger value to be set
     */
    fun setTrigger(trigger: SessionTrigger?) {
        setFieldValue(28, 0, trigger?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get nec_lat field
     * Units: semicircles
     * Comment: North east corner latitude
     *
     * @return nec_lat
     */
    fun getNecLat(): Int? {
        return getFieldIntegerValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set nec_lat field
     * Units: semicircles
     * Comment: North east corner latitude
     *
     * @param necLat The new necLat value to be set
     */
    fun setNecLat(necLat: Int?) {
        setFieldValue(29, 0, necLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get nec_long field
     * Units: semicircles
     * Comment: North east corner longitude
     *
     * @return nec_long
     */
    fun getNecLong(): Int? {
        return getFieldIntegerValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set nec_long field
     * Units: semicircles
     * Comment: North east corner longitude
     *
     * @param necLong The new necLong value to be set
     */
    fun setNecLong(necLong: Int?) {
        setFieldValue(30, 0, necLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get swc_lat field
     * Units: semicircles
     * Comment: South west corner latitude
     *
     * @return swc_lat
     */
    fun getSwcLat(): Int? {
        return getFieldIntegerValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set swc_lat field
     * Units: semicircles
     * Comment: South west corner latitude
     *
     * @param swcLat The new swcLat value to be set
     */
    fun setSwcLat(swcLat: Int?) {
        setFieldValue(31, 0, swcLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get swc_long field
     * Units: semicircles
     * Comment: South west corner longitude
     *
     * @return swc_long
     */
    fun getSwcLong(): Int? {
        return getFieldIntegerValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set swc_long field
     * Units: semicircles
     * Comment: South west corner longitude
     *
     * @param swcLong The new swcLong value to be set
     */
    fun setSwcLong(swcLong: Int?) {
        setFieldValue(32, 0, swcLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get num_lengths field
     * Units: lengths
     * Comment: # of lengths of swim pool
     *
     * @return num_lengths
     */
    fun getNumLengths(): Int? {
        return getFieldIntegerValue(33, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set num_lengths field
     * Units: lengths
     * Comment: # of lengths of swim pool
     *
     * @param numLengths The new numLengths value to be set
     */
    fun setNumLengths(numLengths: Int?) {
        setFieldValue(33, 0, numLengths, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get normalized_power field
     * Units: watts
     *
     * @return normalized_power
     */
    fun getNormalizedPower(): Int? {
        return getFieldIntegerValue(34, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set normalized_power field
     * Units: watts
     *
     * @param normalizedPower The new normalizedPower value to be set
     */
    fun setNormalizedPower(normalizedPower: Int?) {
        setFieldValue(34, 0, normalizedPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get training_stress_score field
     * Units: tss
     *
     * @return training_stress_score
     */
    fun getTrainingStressScore(): Float? {
        return getFieldFloatValue(35, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set training_stress_score field
     * Units: tss
     *
     * @param trainingStressScore The new trainingStressScore value to be set
     */
    fun setTrainingStressScore(trainingStressScore: Float?) {
        setFieldValue(35, 0, trainingStressScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get intensity_factor field
     * Units: if
     *
     * @return intensity_factor
     */
    fun getIntensityFactor(): Float? {
        return getFieldFloatValue(36, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set intensity_factor field
     * Units: if
     *
     * @param intensityFactor The new intensityFactor value to be set
     */
    fun setIntensityFactor(intensityFactor: Float?) {
        setFieldValue(36, 0, intensityFactor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get left_right_balance field
     *
     * @return left_right_balance
     */
    fun getLeftRightBalance(): Int? {
        return getFieldIntegerValue(37, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set left_right_balance field
     *
     * @param leftRightBalance The new leftRightBalance value to be set
     */
    fun setLeftRightBalance(leftRightBalance: Int?) {
        setFieldValue(37, 0, leftRightBalance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_position_lat field
     * Units: semicircles
     *
     * @return end_position_lat
     */
    fun getEndPositionLat(): Int? {
        return getFieldIntegerValue(38, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_position_lat field
     * Units: semicircles
     *
     * @param endPositionLat The new endPositionLat value to be set
     */
    fun setEndPositionLat(endPositionLat: Int?) {
        setFieldValue(38, 0, endPositionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_position_long field
     * Units: semicircles
     *
     * @return end_position_long
     */
    fun getEndPositionLong(): Int? {
        return getFieldIntegerValue(39, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_position_long field
     * Units: semicircles
     *
     * @param endPositionLong The new endPositionLong value to be set
     */
    fun setEndPositionLong(endPositionLong: Int?) {
        setFieldValue(39, 0, endPositionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_stroke_count field
     * Units: strokes/lap
     *
     * @return avg_stroke_count
     */
    fun getAvgStrokeCount(): Float? {
        return getFieldFloatValue(41, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_stroke_count field
     * Units: strokes/lap
     *
     * @param avgStrokeCount The new avgStrokeCount value to be set
     */
    fun setAvgStrokeCount(avgStrokeCount: Float?) {
        setFieldValue(41, 0, avgStrokeCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_stroke_distance field
     * Units: m
     *
     * @return avg_stroke_distance
     */
    fun getAvgStrokeDistance(): Float? {
        return getFieldFloatValue(42, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_stroke_distance field
     * Units: m
     *
     * @param avgStrokeDistance The new avgStrokeDistance value to be set
     */
    fun setAvgStrokeDistance(avgStrokeDistance: Float?) {
        setFieldValue(42, 0, avgStrokeDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get swim_stroke field
     * Units: swim_stroke
     *
     * @return swim_stroke
     */
    fun getSwimStroke(): SwimStroke? {
        val value = getFieldShortValue(43, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SwimStroke.fromValue(value)
    }

    /**
     * Set swim_stroke field
     * Units: swim_stroke
     *
     * @param swimStroke The new swimStroke value to be set
     */
    fun setSwimStroke(swimStroke: SwimStroke?) {
        setFieldValue(43, 0, swimStroke?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pool_length field
     * Units: m
     *
     * @return pool_length
     */
    fun getPoolLength(): Float? {
        return getFieldFloatValue(44, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set pool_length field
     * Units: m
     *
     * @param poolLength The new poolLength value to be set
     */
    fun setPoolLength(poolLength: Float?) {
        setFieldValue(44, 0, poolLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get threshold_power field
     * Units: watts
     *
     * @return threshold_power
     */
    fun getThresholdPower(): Int? {
        return getFieldIntegerValue(45, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set threshold_power field
     * Units: watts
     *
     * @param thresholdPower The new thresholdPower value to be set
     */
    fun setThresholdPower(thresholdPower: Int?) {
        setFieldValue(45, 0, thresholdPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pool_length_unit field
     *
     * @return pool_length_unit
     */
    fun getPoolLengthUnit(): DisplayMeasure? {
        val value = getFieldShortValue(46, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set pool_length_unit field
     *
     * @param poolLengthUnit The new poolLengthUnit value to be set
     */
    fun setPoolLengthUnit(poolLengthUnit: DisplayMeasure?) {
        setFieldValue(46, 0, poolLengthUnit?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get num_active_lengths field
     * Units: lengths
     * Comment: # of active lengths of swim pool
     *
     * @return num_active_lengths
     */
    fun getNumActiveLengths(): Int? {
        return getFieldIntegerValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set num_active_lengths field
     * Units: lengths
     * Comment: # of active lengths of swim pool
     *
     * @param numActiveLengths The new numActiveLengths value to be set
     */
    fun setNumActiveLengths(numActiveLengths: Int?) {
        setFieldValue(47, 0, numActiveLengths, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_work field
     * Units: J
     *
     * @return total_work
     */
    fun getTotalWork(): Long? {
        return getFieldLongValue(48, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_work field
     * Units: J
     *
     * @param totalWork The new totalWork value to be set
     */
    fun setTotalWork(totalWork: Long?) {
        setFieldValue(48, 0, totalWork, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_altitude field
     * Units: m
     *
     * @return avg_altitude
     */
    fun getAvgAltitude(): Float? {
        return getFieldFloatValue(49, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_altitude field
     * Units: m
     *
     * @param avgAltitude The new avgAltitude value to be set
     */
    fun setAvgAltitude(avgAltitude: Float?) {
        setFieldValue(49, 0, avgAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_altitude field
     * Units: m
     *
     * @return max_altitude
     */
    fun getMaxAltitude(): Float? {
        return getFieldFloatValue(50, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_altitude field
     * Units: m
     *
     * @param maxAltitude The new maxAltitude value to be set
     */
    fun setMaxAltitude(maxAltitude: Float?) {
        setFieldValue(50, 0, maxAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gps_accuracy field
     * Units: m
     *
     * @return gps_accuracy
     */
    fun getGpsAccuracy(): Short? {
        return getFieldShortValue(51, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gps_accuracy field
     * Units: m
     *
     * @param gpsAccuracy The new gpsAccuracy value to be set
     */
    fun setGpsAccuracy(gpsAccuracy: Short?) {
        setFieldValue(51, 0, gpsAccuracy, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_grade field
     * Units: %
     *
     * @return avg_grade
     */
    fun getAvgGrade(): Float? {
        return getFieldFloatValue(52, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_grade field
     * Units: %
     *
     * @param avgGrade The new avgGrade value to be set
     */
    fun setAvgGrade(avgGrade: Float?) {
        setFieldValue(52, 0, avgGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_pos_grade field
     * Units: %
     *
     * @return avg_pos_grade
     */
    fun getAvgPosGrade(): Float? {
        return getFieldFloatValue(53, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_pos_grade field
     * Units: %
     *
     * @param avgPosGrade The new avgPosGrade value to be set
     */
    fun setAvgPosGrade(avgPosGrade: Float?) {
        setFieldValue(53, 0, avgPosGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_neg_grade field
     * Units: %
     *
     * @return avg_neg_grade
     */
    fun getAvgNegGrade(): Float? {
        return getFieldFloatValue(54, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_neg_grade field
     * Units: %
     *
     * @param avgNegGrade The new avgNegGrade value to be set
     */
    fun setAvgNegGrade(avgNegGrade: Float?) {
        setFieldValue(54, 0, avgNegGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_pos_grade field
     * Units: %
     *
     * @return max_pos_grade
     */
    fun getMaxPosGrade(): Float? {
        return getFieldFloatValue(55, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_pos_grade field
     * Units: %
     *
     * @param maxPosGrade The new maxPosGrade value to be set
     */
    fun setMaxPosGrade(maxPosGrade: Float?) {
        setFieldValue(55, 0, maxPosGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_neg_grade field
     * Units: %
     *
     * @return max_neg_grade
     */
    fun getMaxNegGrade(): Float? {
        return getFieldFloatValue(56, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_neg_grade field
     * Units: %
     *
     * @param maxNegGrade The new maxNegGrade value to be set
     */
    fun setMaxNegGrade(maxNegGrade: Float?) {
        setFieldValue(56, 0, maxNegGrade, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_temperature field
     * Units: C
     *
     * @return avg_temperature
     */
    fun getAvgTemperature(): Byte? {
        return getFieldByteValue(57, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_temperature field
     * Units: C
     *
     * @param avgTemperature The new avgTemperature value to be set
     */
    fun setAvgTemperature(avgTemperature: Byte?) {
        setFieldValue(57, 0, avgTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_temperature field
     * Units: C
     *
     * @return max_temperature
     */
    fun getMaxTemperature(): Byte? {
        return getFieldByteValue(58, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_temperature field
     * Units: C
     *
     * @param maxTemperature The new maxTemperature value to be set
     */
    fun setMaxTemperature(maxTemperature: Byte?) {
        setFieldValue(58, 0, maxTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_moving_time field
     * Units: s
     *
     * @return total_moving_time
     */
    fun getTotalMovingTime(): Float? {
        return getFieldFloatValue(59, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_moving_time field
     * Units: s
     *
     * @param totalMovingTime The new totalMovingTime value to be set
     */
    fun setTotalMovingTime(totalMovingTime: Float?) {
        setFieldValue(59, 0, totalMovingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_pos_vertical_speed field
     * Units: m/s
     *
     * @return avg_pos_vertical_speed
     */
    fun getAvgPosVerticalSpeed(): Float? {
        return getFieldFloatValue(60, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_pos_vertical_speed field
     * Units: m/s
     *
     * @param avgPosVerticalSpeed The new avgPosVerticalSpeed value to be set
     */
    fun setAvgPosVerticalSpeed(avgPosVerticalSpeed: Float?) {
        setFieldValue(60, 0, avgPosVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_neg_vertical_speed field
     * Units: m/s
     *
     * @return avg_neg_vertical_speed
     */
    fun getAvgNegVerticalSpeed(): Float? {
        return getFieldFloatValue(61, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_neg_vertical_speed field
     * Units: m/s
     *
     * @param avgNegVerticalSpeed The new avgNegVerticalSpeed value to be set
     */
    fun setAvgNegVerticalSpeed(avgNegVerticalSpeed: Float?) {
        setFieldValue(61, 0, avgNegVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_pos_vertical_speed field
     * Units: m/s
     *
     * @return max_pos_vertical_speed
     */
    fun getMaxPosVerticalSpeed(): Float? {
        return getFieldFloatValue(62, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_pos_vertical_speed field
     * Units: m/s
     *
     * @param maxPosVerticalSpeed The new maxPosVerticalSpeed value to be set
     */
    fun setMaxPosVerticalSpeed(maxPosVerticalSpeed: Float?) {
        setFieldValue(62, 0, maxPosVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_neg_vertical_speed field
     * Units: m/s
     *
     * @return max_neg_vertical_speed
     */
    fun getMaxNegVerticalSpeed(): Float? {
        return getFieldFloatValue(63, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_neg_vertical_speed field
     * Units: m/s
     *
     * @param maxNegVerticalSpeed The new maxNegVerticalSpeed value to be set
     */
    fun setMaxNegVerticalSpeed(maxNegVerticalSpeed: Float?) {
        setFieldValue(63, 0, maxNegVerticalSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_heart_rate field
     * Units: bpm
     *
     * @return min_heart_rate
     */
    fun getMinHeartRate(): Short? {
        return getFieldShortValue(64, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_heart_rate field
     * Units: bpm
     *
     * @param minHeartRate The new minHeartRate value to be set
     */
    fun setMinHeartRate(minHeartRate: Short?) {
        setFieldValue(64, 0, minHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInHrZone(): Array<Float?>? {
        return getFieldFloatValues(65, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_hr_zone
     */
    fun getNumTimeInHrZone(): Int {
        return getNumFieldValues(65, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_hr_zone field
     * Units: s
     *
     * @param index of time_in_hr_zone
     * @return time_in_hr_zone
     */
    fun getTimeInHrZone(index: Int): Float? {
        return getFieldFloatValue(65, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_hr_zone field
     * Units: s
     *
     * @param index of time_in_hr_zone
     * @param timeInHrZone The new timeInHrZone value to be set
     */
    fun setTimeInHrZone(index: Int, timeInHrZone: Float?) {
        setFieldValue(65, index, timeInHrZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInSpeedZone(): Array<Float?>? {
        return getFieldFloatValues(66, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_speed_zone
     */
    fun getNumTimeInSpeedZone(): Int {
        return getNumFieldValues(66, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_speed_zone field
     * Units: s
     *
     * @param index of time_in_speed_zone
     * @return time_in_speed_zone
     */
    fun getTimeInSpeedZone(index: Int): Float? {
        return getFieldFloatValue(66, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_speed_zone field
     * Units: s
     *
     * @param index of time_in_speed_zone
     * @param timeInSpeedZone The new timeInSpeedZone value to be set
     */
    fun setTimeInSpeedZone(index: Int, timeInSpeedZone: Float?) {
        setFieldValue(66, index, timeInSpeedZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInCadenceZone(): Array<Float?>? {
        return getFieldFloatValues(67, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_cadence_zone
     */
    fun getNumTimeInCadenceZone(): Int {
        return getNumFieldValues(67, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_cadence_zone field
     * Units: s
     *
     * @param index of time_in_cadence_zone
     * @return time_in_cadence_zone
     */
    fun getTimeInCadenceZone(index: Int): Float? {
        return getFieldFloatValue(67, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_cadence_zone field
     * Units: s
     *
     * @param index of time_in_cadence_zone
     * @param timeInCadenceZone The new timeInCadenceZone value to be set
     */
    fun setTimeInCadenceZone(index: Int, timeInCadenceZone: Float?) {
        setFieldValue(67, index, timeInCadenceZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeInPowerZone(): Array<Float?>? {
        return getFieldFloatValues(68, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_in_power_zone
     */
    fun getNumTimeInPowerZone(): Int {
        return getNumFieldValues(68, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_in_power_zone field
     * Units: s
     *
     * @param index of time_in_power_zone
     * @return time_in_power_zone
     */
    fun getTimeInPowerZone(index: Int): Float? {
        return getFieldFloatValue(68, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_in_power_zone field
     * Units: s
     *
     * @param index of time_in_power_zone
     * @param timeInPowerZone The new timeInPowerZone value to be set
     */
    fun setTimeInPowerZone(index: Int, timeInPowerZone: Float?) {
        setFieldValue(68, index, timeInPowerZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_lap_time field
     * Units: s
     *
     * @return avg_lap_time
     */
    fun getAvgLapTime(): Float? {
        return getFieldFloatValue(69, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_lap_time field
     * Units: s
     *
     * @param avgLapTime The new avgLapTime value to be set
     */
    fun setAvgLapTime(avgLapTime: Float?) {
        setFieldValue(69, 0, avgLapTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get best_lap_index field
     *
     * @return best_lap_index
     */
    fun getBestLapIndex(): Int? {
        return getFieldIntegerValue(70, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set best_lap_index field
     *
     * @param bestLapIndex The new bestLapIndex value to be set
     */
    fun setBestLapIndex(bestLapIndex: Int?) {
        setFieldValue(70, 0, bestLapIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_altitude field
     * Units: m
     *
     * @return min_altitude
     */
    fun getMinAltitude(): Float? {
        return getFieldFloatValue(71, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_altitude field
     * Units: m
     *
     * @param minAltitude The new minAltitude value to be set
     */
    fun setMinAltitude(minAltitude: Float?) {
        setFieldValue(71, 0, minAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get active_time field
     * Units: s
     *
     * @return active_time
     */
    fun getActiveTime(): Float? {
        return getFieldFloatValue(78, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set active_time field
     * Units: s
     *
     * @param activeTime The new activeTime value to be set
     */
    fun setActiveTime(activeTime: Float?) {
        setFieldValue(78, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get player_score field
     *
     * @return player_score
     */
    fun getPlayerScore(): Int? {
        return getFieldIntegerValue(82, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set player_score field
     *
     * @param playerScore The new playerScore value to be set
     */
    fun setPlayerScore(playerScore: Int?) {
        setFieldValue(82, 0, playerScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get opponent_score field
     *
     * @return opponent_score
     */
    fun getOpponentScore(): Int? {
        return getFieldIntegerValue(83, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set opponent_score field
     *
     * @param opponentScore The new opponentScore value to be set
     */
    fun setOpponentScore(opponentScore: Int?) {
        setFieldValue(83, 0, opponentScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get opponent_name field
     *
     * @return opponent_name
     */
    fun getOpponentName(): String? {
        return getFieldStringValue(84, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set opponent_name field
     *
     * @param opponentName The new opponentName value to be set
     */
    fun setOpponentName(opponentName: String?) {
        setFieldValue(84, 0, opponentName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getStrokeCount(): Array<Int?>? {
        return getFieldIntegerValues(85, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of stroke_count
     */
    fun getNumStrokeCount(): Int {
        return getNumFieldValues(85, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldIntegerValue(85, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(85, index, strokeCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getZoneCount(): Array<Int?>? {
        return getFieldIntegerValues(86, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of zone_count
     */
    fun getNumZoneCount(): Int {
        return getNumFieldValues(86, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldIntegerValue(86, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(86, index, zoneCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_ball_speed field
     * Units: m/s
     *
     * @return max_ball_speed
     */
    fun getMaxBallSpeed(): Float? {
        return getFieldFloatValue(87, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_ball_speed field
     * Units: m/s
     *
     * @param maxBallSpeed The new maxBallSpeed value to be set
     */
    fun setMaxBallSpeed(maxBallSpeed: Float?) {
        setFieldValue(87, 0, maxBallSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_ball_speed field
     * Units: m/s
     *
     * @return avg_ball_speed
     */
    fun getAvgBallSpeed(): Float? {
        return getFieldFloatValue(88, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_ball_speed field
     * Units: m/s
     *
     * @param avgBallSpeed The new avgBallSpeed value to be set
     */
    fun setAvgBallSpeed(avgBallSpeed: Float?) {
        setFieldValue(88, 0, avgBallSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_vertical_oscillation field
     * Units: mm
     *
     * @return avg_vertical_oscillation
     */
    fun getAvgVerticalOscillation(): Float? {
        return getFieldFloatValue(89, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_vertical_oscillation field
     * Units: mm
     *
     * @param avgVerticalOscillation The new avgVerticalOscillation value to be set
     */
    fun setAvgVerticalOscillation(avgVerticalOscillation: Float?) {
        setFieldValue(89, 0, avgVerticalOscillation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_stance_time_percent field
     * Units: percent
     *
     * @return avg_stance_time_percent
     */
    fun getAvgStanceTimePercent(): Float? {
        return getFieldFloatValue(90, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_stance_time_percent field
     * Units: percent
     *
     * @param avgStanceTimePercent The new avgStanceTimePercent value to be set
     */
    fun setAvgStanceTimePercent(avgStanceTimePercent: Float?) {
        setFieldValue(90, 0, avgStanceTimePercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_stance_time field
     * Units: ms
     *
     * @return avg_stance_time
     */
    fun getAvgStanceTime(): Float? {
        return getFieldFloatValue(91, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_stance_time field
     * Units: ms
     *
     * @param avgStanceTime The new avgStanceTime value to be set
     */
    fun setAvgStanceTime(avgStanceTime: Float?) {
        setFieldValue(91, 0, avgStanceTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the avg_cadence
     *
     * @return avg_fractional_cadence
     */
    fun getAvgFractionalCadence(): Float? {
        return getFieldFloatValue(92, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the avg_cadence
     *
     * @param avgFractionalCadence The new avgFractionalCadence value to be set
     */
    fun setAvgFractionalCadence(avgFractionalCadence: Float?) {
        setFieldValue(92, 0, avgFractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the max_cadence
     *
     * @return max_fractional_cadence
     */
    fun getMaxFractionalCadence(): Float? {
        return getFieldFloatValue(93, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_fractional_cadence field
     * Units: rpm
     * Comment: fractional part of the max_cadence
     *
     * @param maxFractionalCadence The new maxFractionalCadence value to be set
     */
    fun setMaxFractionalCadence(maxFractionalCadence: Float?) {
        setFieldValue(93, 0, maxFractionalCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_fractional_cycles field
     * Units: cycles
     * Comment: fractional part of the total_cycles
     *
     * @return total_fractional_cycles
     */
    fun getTotalFractionalCycles(): Float? {
        return getFieldFloatValue(94, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_fractional_cycles field
     * Units: cycles
     * Comment: fractional part of the total_cycles
     *
     * @param totalFractionalCycles The new totalFractionalCycles value to be set
     */
    fun setTotalFractionalCycles(totalFractionalCycles: Float?) {
        setFieldValue(94, 0, totalFractionalCycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgTotalHemoglobinConc(): Array<Float?>? {
        return getFieldFloatValues(95, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_total_hemoglobin_conc
     */
    fun getNumAvgTotalHemoglobinConc(): Int {
        return getNumFieldValues(95, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(95, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(95, index, avgTotalHemoglobinConc, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMinTotalHemoglobinConc(): Array<Float?>? {
        return getFieldFloatValues(96, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of min_total_hemoglobin_conc
     */
    fun getNumMinTotalHemoglobinConc(): Int {
        return getNumFieldValues(96, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(96, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(96, index, minTotalHemoglobinConc, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxTotalHemoglobinConc(): Array<Float?>? {
        return getFieldFloatValues(97, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_total_hemoglobin_conc
     */
    fun getNumMaxTotalHemoglobinConc(): Int {
        return getNumFieldValues(97, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(97, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(97, index, maxTotalHemoglobinConc, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgSaturatedHemoglobinPercent(): Array<Float?>? {
        return getFieldFloatValues(98, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_saturated_hemoglobin_percent
     */
    fun getNumAvgSaturatedHemoglobinPercent(): Int {
        return getNumFieldValues(98, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(98, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(98, index, avgSaturatedHemoglobinPercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMinSaturatedHemoglobinPercent(): Array<Float?>? {
        return getFieldFloatValues(99, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of min_saturated_hemoglobin_percent
     */
    fun getNumMinSaturatedHemoglobinPercent(): Int {
        return getNumFieldValues(99, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(99, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(99, index, minSaturatedHemoglobinPercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxSaturatedHemoglobinPercent(): Array<Float?>? {
        return getFieldFloatValues(100, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_saturated_hemoglobin_percent
     */
    fun getNumMaxSaturatedHemoglobinPercent(): Int {
        return getNumFieldValues(100, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(100, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(100, index, maxSaturatedHemoglobinPercent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_torque_effectiveness field
     * Units: percent
     *
     * @return avg_left_torque_effectiveness
     */
    fun getAvgLeftTorqueEffectiveness(): Float? {
        return getFieldFloatValue(101, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_torque_effectiveness field
     * Units: percent
     *
     * @param avgLeftTorqueEffectiveness The new avgLeftTorqueEffectiveness value to be set
     */
    fun setAvgLeftTorqueEffectiveness(avgLeftTorqueEffectiveness: Float?) {
        setFieldValue(101, 0, avgLeftTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_torque_effectiveness field
     * Units: percent
     *
     * @return avg_right_torque_effectiveness
     */
    fun getAvgRightTorqueEffectiveness(): Float? {
        return getFieldFloatValue(102, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_torque_effectiveness field
     * Units: percent
     *
     * @param avgRightTorqueEffectiveness The new avgRightTorqueEffectiveness value to be set
     */
    fun setAvgRightTorqueEffectiveness(avgRightTorqueEffectiveness: Float?) {
        setFieldValue(102, 0, avgRightTorqueEffectiveness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_pedal_smoothness field
     * Units: percent
     *
     * @return avg_left_pedal_smoothness
     */
    fun getAvgLeftPedalSmoothness(): Float? {
        return getFieldFloatValue(103, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_pedal_smoothness field
     * Units: percent
     *
     * @param avgLeftPedalSmoothness The new avgLeftPedalSmoothness value to be set
     */
    fun setAvgLeftPedalSmoothness(avgLeftPedalSmoothness: Float?) {
        setFieldValue(103, 0, avgLeftPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_pedal_smoothness field
     * Units: percent
     *
     * @return avg_right_pedal_smoothness
     */
    fun getAvgRightPedalSmoothness(): Float? {
        return getFieldFloatValue(104, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_pedal_smoothness field
     * Units: percent
     *
     * @param avgRightPedalSmoothness The new avgRightPedalSmoothness value to be set
     */
    fun setAvgRightPedalSmoothness(avgRightPedalSmoothness: Float?) {
        setFieldValue(104, 0, avgRightPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_combined_pedal_smoothness field
     * Units: percent
     *
     * @return avg_combined_pedal_smoothness
     */
    fun getAvgCombinedPedalSmoothness(): Float? {
        return getFieldFloatValue(105, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_combined_pedal_smoothness field
     * Units: percent
     *
     * @param avgCombinedPedalSmoothness The new avgCombinedPedalSmoothness value to be set
     */
    fun setAvgCombinedPedalSmoothness(avgCombinedPedalSmoothness: Float?) {
        setFieldValue(105, 0, avgCombinedPedalSmoothness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sport_profile_name field
     * Comment: Sport name from associated sport mesg
     *
     * @return sport_profile_name
     */
    fun getSportProfileName(): String? {
        return getFieldStringValue(110, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sport_profile_name field
     * Comment: Sport name from associated sport mesg
     *
     * @param sportProfileName The new sportProfileName value to be set
     */
    fun setSportProfileName(sportProfileName: String?) {
        setFieldValue(110, 0, sportProfileName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sport_index field
     *
     * @return sport_index
     */
    fun getSportIndex(): Short? {
        return getFieldShortValue(111, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sport_index field
     *
     * @param sportIndex The new sportIndex value to be set
     */
    fun setSportIndex(sportIndex: Short?) {
        setFieldValue(111, 0, sportIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_standing field
     * Units: s
     * Comment: Total time spend in the standing position
     *
     * @return time_standing
     */
    fun getTimeStanding(): Float? {
        return getFieldFloatValue(112, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_standing field
     * Units: s
     * Comment: Total time spend in the standing position
     *
     * @param timeStanding The new timeStanding value to be set
     */
    fun setTimeStanding(timeStanding: Float?) {
        setFieldValue(112, 0, timeStanding, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get stand_count field
     * Comment: Number of transitions to the standing state
     *
     * @return stand_count
     */
    fun getStandCount(): Int? {
        return getFieldIntegerValue(113, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set stand_count field
     * Comment: Number of transitions to the standing state
     *
     * @param standCount The new standCount value to be set
     */
    fun setStandCount(standCount: Int?) {
        setFieldValue(113, 0, standCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_pco field
     * Units: mm
     * Comment: Average platform center offset Left
     *
     * @return avg_left_pco
     */
    fun getAvgLeftPco(): Byte? {
        return getFieldByteValue(114, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_pco field
     * Units: mm
     * Comment: Average platform center offset Left
     *
     * @param avgLeftPco The new avgLeftPco value to be set
     */
    fun setAvgLeftPco(avgLeftPco: Byte?) {
        setFieldValue(114, 0, avgLeftPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_pco field
     * Units: mm
     * Comment: Average platform center offset Right
     *
     * @return avg_right_pco
     */
    fun getAvgRightPco(): Byte? {
        return getFieldByteValue(115, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_pco field
     * Units: mm
     * Comment: Average platform center offset Right
     *
     * @param avgRightPco The new avgRightPco value to be set
     */
    fun setAvgRightPco(avgRightPco: Byte?) {
        setFieldValue(115, 0, avgRightPco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgLeftPowerPhase(): Array<Float?>? {
        return getFieldFloatValues(116, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_left_power_phase
     */
    fun getNumAvgLeftPowerPhase(): Int {
        return getNumFieldValues(116, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_left_power_phase field
     * Units: degrees
     * Comment: Average left power phase angles. Indexes defined by power_phase_type.
     *
     * @param index of avg_left_power_phase
     * @return avg_left_power_phase
     */
    fun getAvgLeftPowerPhase(index: Int): Float? {
        return getFieldFloatValue(116, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_left_power_phase field
     * Units: degrees
     * Comment: Average left power phase angles. Indexes defined by power_phase_type.
     *
     * @param index of avg_left_power_phase
     * @param avgLeftPowerPhase The new avgLeftPowerPhase value to be set
     */
    fun setAvgLeftPowerPhase(index: Int, avgLeftPowerPhase: Float?) {
        setFieldValue(116, index, avgLeftPowerPhase, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgLeftPowerPhasePeak(): Array<Float?>? {
        return getFieldFloatValues(117, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_left_power_phase_peak
     */
    fun getNumAvgLeftPowerPhasePeak(): Int {
        return getNumFieldValues(117, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(117, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(117, index, avgLeftPowerPhasePeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgRightPowerPhase(): Array<Float?>? {
        return getFieldFloatValues(118, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_right_power_phase
     */
    fun getNumAvgRightPowerPhase(): Int {
        return getNumFieldValues(118, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldFloatValue(118, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(118, index, avgRightPowerPhase, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgRightPowerPhasePeak(): Array<Float?>? {
        return getFieldFloatValues(119, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_right_power_phase_peak
     */
    fun getNumAvgRightPowerPhasePeak(): Int {
        return getNumFieldValues(119, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_right_power_phase_peak field
     * Units: degrees
     * Comment: Average right power phase peak angles data value indexes defined by power_phase_type.
     *
     * @param index of avg_right_power_phase_peak
     * @return avg_right_power_phase_peak
     */
    fun getAvgRightPowerPhasePeak(index: Int): Float? {
        return getFieldFloatValue(119, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_right_power_phase_peak field
     * Units: degrees
     * Comment: Average right power phase peak angles data value indexes defined by power_phase_type.
     *
     * @param index of avg_right_power_phase_peak
     * @param avgRightPowerPhasePeak The new avgRightPowerPhasePeak value to be set
     */
    fun setAvgRightPowerPhasePeak(index: Int, avgRightPowerPhasePeak: Float?) {
        setFieldValue(119, index, avgRightPowerPhasePeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgPowerPosition(): Array<Int?>? {
        return getFieldIntegerValues(120, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_power_position
     */
    fun getNumAvgPowerPosition(): Int {
        return getNumFieldValues(120, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldIntegerValue(120, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(120, index, avgPowerPosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxPowerPosition(): Array<Int?>? {
        return getFieldIntegerValues(121, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_power_position
     */
    fun getNumMaxPowerPosition(): Int {
        return getNumFieldValues(121, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldIntegerValue(121, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(121, index, maxPowerPosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAvgCadencePosition(): Array<Short?>? {
        return getFieldShortValues(122, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of avg_cadence_position
     */
    fun getNumAvgCadencePosition(): Int {
        return getNumFieldValues(122, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldShortValue(122, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(122, index, avgCadencePosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getMaxCadencePosition(): Array<Short?>? {
        return getFieldShortValues(123, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of max_cadence_position
     */
    fun getNumMaxCadencePosition(): Int {
        return getNumFieldValues(123, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldShortValue(123, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(123, index, maxCadencePosition, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_avg_speed field
     * Units: m/s
     * Comment: total_distance / total_timer_time
     *
     * @return enhanced_avg_speed
     */
    fun getEnhancedAvgSpeed(): Float? {
        return getFieldFloatValue(124, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_avg_speed field
     * Units: m/s
     * Comment: total_distance / total_timer_time
     *
     * @param enhancedAvgSpeed The new enhancedAvgSpeed value to be set
     */
    fun setEnhancedAvgSpeed(enhancedAvgSpeed: Float?) {
        setFieldValue(124, 0, enhancedAvgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_max_speed field
     * Units: m/s
     *
     * @return enhanced_max_speed
     */
    fun getEnhancedMaxSpeed(): Float? {
        return getFieldFloatValue(125, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_max_speed field
     * Units: m/s
     *
     * @param enhancedMaxSpeed The new enhancedMaxSpeed value to be set
     */
    fun setEnhancedMaxSpeed(enhancedMaxSpeed: Float?) {
        setFieldValue(125, 0, enhancedMaxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_avg_altitude field
     * Units: m
     *
     * @return enhanced_avg_altitude
     */
    fun getEnhancedAvgAltitude(): Float? {
        return getFieldFloatValue(126, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_avg_altitude field
     * Units: m
     *
     * @param enhancedAvgAltitude The new enhancedAvgAltitude value to be set
     */
    fun setEnhancedAvgAltitude(enhancedAvgAltitude: Float?) {
        setFieldValue(126, 0, enhancedAvgAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_min_altitude field
     * Units: m
     *
     * @return enhanced_min_altitude
     */
    fun getEnhancedMinAltitude(): Float? {
        return getFieldFloatValue(127, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_min_altitude field
     * Units: m
     *
     * @param enhancedMinAltitude The new enhancedMinAltitude value to be set
     */
    fun setEnhancedMinAltitude(enhancedMinAltitude: Float?) {
        setFieldValue(127, 0, enhancedMinAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_max_altitude field
     * Units: m
     *
     * @return enhanced_max_altitude
     */
    fun getEnhancedMaxAltitude(): Float? {
        return getFieldFloatValue(128, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_max_altitude field
     * Units: m
     *
     * @param enhancedMaxAltitude The new enhancedMaxAltitude value to be set
     */
    fun setEnhancedMaxAltitude(enhancedMaxAltitude: Float?) {
        setFieldValue(128, 0, enhancedMaxAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_lev_motor_power field
     * Units: watts
     * Comment: lev average motor power during session
     *
     * @return avg_lev_motor_power
     */
    fun getAvgLevMotorPower(): Int? {
        return getFieldIntegerValue(129, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_lev_motor_power field
     * Units: watts
     * Comment: lev average motor power during session
     *
     * @param avgLevMotorPower The new avgLevMotorPower value to be set
     */
    fun setAvgLevMotorPower(avgLevMotorPower: Int?) {
        setFieldValue(129, 0, avgLevMotorPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_lev_motor_power field
     * Units: watts
     * Comment: lev maximum motor power during session
     *
     * @return max_lev_motor_power
     */
    fun getMaxLevMotorPower(): Int? {
        return getFieldIntegerValue(130, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_lev_motor_power field
     * Units: watts
     * Comment: lev maximum motor power during session
     *
     * @param maxLevMotorPower The new maxLevMotorPower value to be set
     */
    fun setMaxLevMotorPower(maxLevMotorPower: Int?) {
        setFieldValue(130, 0, maxLevMotorPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get lev_battery_consumption field
     * Units: percent
     * Comment: lev battery consumption during session
     *
     * @return lev_battery_consumption
     */
    fun getLevBatteryConsumption(): Float? {
        return getFieldFloatValue(131, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set lev_battery_consumption field
     * Units: percent
     * Comment: lev battery consumption during session
     *
     * @param levBatteryConsumption The new levBatteryConsumption value to be set
     */
    fun setLevBatteryConsumption(levBatteryConsumption: Float?) {
        setFieldValue(131, 0, levBatteryConsumption, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_vertical_ratio field
     * Units: percent
     *
     * @return avg_vertical_ratio
     */
    fun getAvgVerticalRatio(): Float? {
        return getFieldFloatValue(132, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_vertical_ratio field
     * Units: percent
     *
     * @param avgVerticalRatio The new avgVerticalRatio value to be set
     */
    fun setAvgVerticalRatio(avgVerticalRatio: Float?) {
        setFieldValue(132, 0, avgVerticalRatio, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_stance_time_balance field
     * Units: percent
     *
     * @return avg_stance_time_balance
     */
    fun getAvgStanceTimeBalance(): Float? {
        return getFieldFloatValue(133, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_stance_time_balance field
     * Units: percent
     *
     * @param avgStanceTimeBalance The new avgStanceTimeBalance value to be set
     */
    fun setAvgStanceTimeBalance(avgStanceTimeBalance: Float?) {
        setFieldValue(133, 0, avgStanceTimeBalance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_step_length field
     * Units: mm
     *
     * @return avg_step_length
     */
    fun getAvgStepLength(): Float? {
        return getFieldFloatValue(134, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_step_length field
     * Units: mm
     *
     * @param avgStepLength The new avgStepLength value to be set
     */
    fun setAvgStepLength(avgStepLength: Float?) {
        setFieldValue(134, 0, avgStepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_anaerobic_training_effect field
     *
     * @return total_anaerobic_training_effect
     */
    fun getTotalAnaerobicTrainingEffect(): Float? {
        return getFieldFloatValue(137, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_anaerobic_training_effect field
     *
     * @param totalAnaerobicTrainingEffect The new totalAnaerobicTrainingEffect value to be set
     */
    fun setTotalAnaerobicTrainingEffect(totalAnaerobicTrainingEffect: Float?) {
        setFieldValue(137, 0, totalAnaerobicTrainingEffect, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_vam field
     * Units: m/s
     *
     * @return avg_vam
     */
    fun getAvgVam(): Float? {
        return getFieldFloatValue(139, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_vam field
     * Units: m/s
     *
     * @param avgVam The new avgVam value to be set
     */
    fun setAvgVam(avgVam: Float?) {
        setFieldValue(139, 0, avgVam, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return avg_depth
     */
    fun getAvgDepth(): Float? {
        return getFieldFloatValue(140, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @param avgDepth The new avgDepth value to be set
     */
    fun setAvgDepth(avgDepth: Float?) {
        setFieldValue(140, 0, avgDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return max_depth
     */
    fun getMaxDepth(): Float? {
        return getFieldFloatValue(141, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @param maxDepth The new maxDepth value to be set
     */
    fun setMaxDepth(maxDepth: Float?) {
        setFieldValue(141, 0, maxDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get surface_interval field
     * Units: s
     * Comment: Time since end of last dive
     *
     * @return surface_interval
     */
    fun getSurfaceInterval(): Long? {
        return getFieldLongValue(142, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set surface_interval field
     * Units: s
     * Comment: Time since end of last dive
     *
     * @param surfaceInterval The new surfaceInterval value to be set
     */
    fun setSurfaceInterval(surfaceInterval: Long?) {
        setFieldValue(142, 0, surfaceInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_cns field
     * Units: percent
     *
     * @return start_cns
     */
    fun getStartCns(): Short? {
        return getFieldShortValue(143, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_cns field
     * Units: percent
     *
     * @param startCns The new startCns value to be set
     */
    fun setStartCns(startCns: Short?) {
        setFieldValue(143, 0, startCns, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_cns field
     * Units: percent
     *
     * @return end_cns
     */
    fun getEndCns(): Short? {
        return getFieldShortValue(144, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_cns field
     * Units: percent
     *
     * @param endCns The new endCns value to be set
     */
    fun setEndCns(endCns: Short?) {
        setFieldValue(144, 0, endCns, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_n2 field
     * Units: percent
     *
     * @return start_n2
     */
    fun getStartN2(): Int? {
        return getFieldIntegerValue(145, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_n2 field
     * Units: percent
     *
     * @param startN2 The new startN2 value to be set
     */
    fun setStartN2(startN2: Int?) {
        setFieldValue(145, 0, startN2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_n2 field
     * Units: percent
     *
     * @return end_n2
     */
    fun getEndN2(): Int? {
        return getFieldIntegerValue(146, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_n2 field
     * Units: percent
     *
     * @param endN2 The new endN2 value to be set
     */
    fun setEndN2(endN2: Int?) {
        setFieldValue(146, 0, endN2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_respiration_rate field
     *
     * @return avg_respiration_rate
     */
    fun getAvgRespirationRate(): Short? {
        return getFieldShortValue(147, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_respiration_rate field
     *
     * @param avgRespirationRate The new avgRespirationRate value to be set
     */
    fun setAvgRespirationRate(avgRespirationRate: Short?) {
        setFieldValue(147, 0, avgRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_respiration_rate field
     *
     * @return max_respiration_rate
     */
    fun getMaxRespirationRate(): Short? {
        return getFieldShortValue(148, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_respiration_rate field
     *
     * @param maxRespirationRate The new maxRespirationRate value to be set
     */
    fun setMaxRespirationRate(maxRespirationRate: Short?) {
        setFieldValue(148, 0, maxRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_respiration_rate field
     *
     * @return min_respiration_rate
     */
    fun getMinRespirationRate(): Short? {
        return getFieldShortValue(149, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_respiration_rate field
     *
     * @param minRespirationRate The new minRespirationRate value to be set
     */
    fun setMinRespirationRate(minRespirationRate: Short?) {
        setFieldValue(149, 0, minRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_temperature field
     * Units: C
     *
     * @return min_temperature
     */
    fun getMinTemperature(): Byte? {
        return getFieldByteValue(150, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_temperature field
     * Units: C
     *
     * @param minTemperature The new minTemperature value to be set
     */
    fun setMinTemperature(minTemperature: Byte?) {
        setFieldValue(150, 0, minTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get o2_toxicity field
     * Units: OTUs
     *
     * @return o2_toxicity
     */
    fun getO2Toxicity(): Int? {
        return getFieldIntegerValue(155, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set o2_toxicity field
     * Units: OTUs
     *
     * @param o2Toxicity The new o2Toxicity value to be set
     */
    fun setO2Toxicity(o2Toxicity: Int?) {
        setFieldValue(155, 0, o2Toxicity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get dive_number field
     *
     * @return dive_number
     */
    fun getDiveNumber(): Long? {
        return getFieldLongValue(156, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set dive_number field
     *
     * @param diveNumber The new diveNumber value to be set
     */
    fun setDiveNumber(diveNumber: Long?) {
        setFieldValue(156, 0, diveNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get training_load_peak field
     *
     * @return training_load_peak
     */
    fun getTrainingLoadPeak(): Float? {
        return getFieldFloatValue(168, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set training_load_peak field
     *
     * @param trainingLoadPeak The new trainingLoadPeak value to be set
     */
    fun setTrainingLoadPeak(trainingLoadPeak: Float?) {
        setFieldValue(168, 0, trainingLoadPeak, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_avg_respiration_rate field
     * Units: Breaths/min
     *
     * @return enhanced_avg_respiration_rate
     */
    fun getEnhancedAvgRespirationRate(): Float? {
        return getFieldFloatValue(169, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_avg_respiration_rate field
     * Units: Breaths/min
     *
     * @param enhancedAvgRespirationRate The new enhancedAvgRespirationRate value to be set
     */
    fun setEnhancedAvgRespirationRate(enhancedAvgRespirationRate: Float?) {
        setFieldValue(169, 0, enhancedAvgRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_max_respiration_rate field
     * Units: Breaths/min
     *
     * @return enhanced_max_respiration_rate
     */
    fun getEnhancedMaxRespirationRate(): Float? {
        return getFieldFloatValue(170, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_max_respiration_rate field
     * Units: Breaths/min
     *
     * @param enhancedMaxRespirationRate The new enhancedMaxRespirationRate value to be set
     */
    fun setEnhancedMaxRespirationRate(enhancedMaxRespirationRate: Float?) {
        setFieldValue(170, 0, enhancedMaxRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_min_respiration_rate field
     *
     * @return enhanced_min_respiration_rate
     */
    fun getEnhancedMinRespirationRate(): Float? {
        return getFieldFloatValue(180, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_min_respiration_rate field
     *
     * @param enhancedMinRespirationRate The new enhancedMinRespirationRate value to be set
     */
    fun setEnhancedMinRespirationRate(enhancedMinRespirationRate: Float?) {
        setFieldValue(180, 0, enhancedMinRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @return total_grit
     */
    fun getTotalGrit(): Float? {
        return getFieldFloatValue(181, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @param totalGrit The new totalGrit value to be set
     */
    fun setTotalGrit(totalGrit: Float?) {
        setFieldValue(181, 0, totalGrit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @return total_flow
     */
    fun getTotalFlow(): Float? {
        return getFieldFloatValue(182, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @param totalFlow The new totalFlow value to be set
     */
    fun setTotalFlow(totalFlow: Float?) {
        setFieldValue(182, 0, totalFlow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get jump_count field
     *
     * @return jump_count
     */
    fun getJumpCount(): Int? {
        return getFieldIntegerValue(183, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set jump_count field
     *
     * @param jumpCount The new jumpCount value to be set
     */
    fun setJumpCount(jumpCount: Int?) {
        setFieldValue(183, 0, jumpCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @return avg_grit
     */
    fun getAvgGrit(): Float? {
        return getFieldFloatValue(186, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_grit field
     * Units: kGrit
     * Comment: The grit score estimates how challenging a route could be for a cyclist in terms of time spent going over sharp turns or large grade slopes.
     *
     * @param avgGrit The new avgGrit value to be set
     */
    fun setAvgGrit(avgGrit: Float?) {
        setFieldValue(186, 0, avgGrit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @return avg_flow
     */
    fun getAvgFlow(): Float? {
        return getFieldFloatValue(187, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_flow field
     * Units: Flow
     * Comment: The flow score estimates how long distance wise a cyclist deaccelerates over intervals where deacceleration is unnecessary such as smooth turns or small grade angle intervals.
     *
     * @param avgFlow The new avgFlow value to be set
     */
    fun setAvgFlow(avgFlow: Float?) {
        setFieldValue(187, 0, avgFlow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get workout_feel field
     * Comment: A 0-100 scale representing how a user felt while performing a workout. Low values are considered feeling bad, while high values are good.
     *
     * @return workout_feel
     */
    fun getWorkoutFeel(): Short? {
        return getFieldShortValue(192, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set workout_feel field
     * Comment: A 0-100 scale representing how a user felt while performing a workout. Low values are considered feeling bad, while high values are good.
     *
     * @param workoutFeel The new workoutFeel value to be set
     */
    fun setWorkoutFeel(workoutFeel: Short?) {
        setFieldValue(192, 0, workoutFeel, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get workout_rpe field
     * Comment: Common Borg CR10 / 0-10 RPE scale, multiplied 10x.. Aggregate score for all workouts in a single session.
     *
     * @return workout_rpe
     */
    fun getWorkoutRpe(): Short? {
        return getFieldShortValue(193, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set workout_rpe field
     * Comment: Common Borg CR10 / 0-10 RPE scale, multiplied 10x.. Aggregate score for all workouts in a single session.
     *
     * @param workoutRpe The new workoutRpe value to be set
     */
    fun setWorkoutRpe(workoutRpe: Short?) {
        setFieldValue(193, 0, workoutRpe, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_spo2 field
     * Units: percent
     * Comment: Average SPO2 for the monitoring session
     *
     * @return avg_spo2
     */
    fun getAvgSpo2(): Short? {
        return getFieldShortValue(194, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_spo2 field
     * Units: percent
     * Comment: Average SPO2 for the monitoring session
     *
     * @param avgSpo2 The new avgSpo2 value to be set
     */
    fun setAvgSpo2(avgSpo2: Short?) {
        setFieldValue(194, 0, avgSpo2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_stress field
     * Units: percent
     * Comment: Average stress for the monitoring session
     *
     * @return avg_stress
     */
    fun getAvgStress(): Short? {
        return getFieldShortValue(195, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_stress field
     * Units: percent
     * Comment: Average stress for the monitoring session
     *
     * @param avgStress The new avgStress value to be set
     */
    fun setAvgStress(avgStress: Short?) {
        setFieldValue(195, 0, avgStress, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get metabolic_calories field
     * Units: kcal
     *
     * @return metabolic_calories
     */
    fun getMetabolicCalories(): Int? {
        return getFieldIntegerValue(196, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set metabolic_calories field
     * Units: kcal
     *
     * @param metabolicCalories The new metabolicCalories value to be set
     */
    fun setMetabolicCalories(metabolicCalories: Int?) {
        setFieldValue(196, 0, metabolicCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sdrr_hrv field
     * Units: mS
     * Comment: Standard deviation of R-R interval (SDRR) - Heart rate variability measure most useful for wellness users.
     *
     * @return sdrr_hrv
     */
    fun getSdrrHrv(): Short? {
        return getFieldShortValue(197, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sdrr_hrv field
     * Units: mS
     * Comment: Standard deviation of R-R interval (SDRR) - Heart rate variability measure most useful for wellness users.
     *
     * @param sdrrHrv The new sdrrHrv value to be set
     */
    fun setSdrrHrv(sdrrHrv: Short?) {
        setFieldValue(197, 0, sdrrHrv, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get rmssd_hrv field
     * Units: mS
     * Comment: Root mean square successive difference (RMSSD) - Heart rate variability measure most useful for athletes
     *
     * @return rmssd_hrv
     */
    fun getRmssdHrv(): Short? {
        return getFieldShortValue(198, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set rmssd_hrv field
     * Units: mS
     * Comment: Root mean square successive difference (RMSSD) - Heart rate variability measure most useful for athletes
     *
     * @param rmssdHrv The new rmssdHrv value to be set
     */
    fun setRmssdHrv(rmssdHrv: Short?) {
        setFieldValue(198, 0, rmssdHrv, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_fractional_ascent field
     * Units: m
     * Comment: fractional part of total_ascent
     *
     * @return total_fractional_ascent
     */
    fun getTotalFractionalAscent(): Float? {
        return getFieldFloatValue(199, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_fractional_ascent field
     * Units: m
     * Comment: fractional part of total_ascent
     *
     * @param totalFractionalAscent The new totalFractionalAscent value to be set
     */
    fun setTotalFractionalAscent(totalFractionalAscent: Float?) {
        setFieldValue(199, 0, totalFractionalAscent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_fractional_descent field
     * Units: m
     * Comment: fractional part of total_descent
     *
     * @return total_fractional_descent
     */
    fun getTotalFractionalDescent(): Float? {
        return getFieldFloatValue(200, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_fractional_descent field
     * Units: m
     * Comment: fractional part of total_descent
     *
     * @param totalFractionalDescent The new totalFractionalDescent value to be set
     */
    fun setTotalFractionalDescent(totalFractionalDescent: Float?) {
        setFieldValue(200, 0, totalFractionalDescent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_core_temperature field
     * Units: C
     *
     * @return avg_core_temperature
     */
    fun getAvgCoreTemperature(): Float? {
        return getFieldFloatValue(208, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_core_temperature field
     * Units: C
     *
     * @param avgCoreTemperature The new avgCoreTemperature value to be set
     */
    fun setAvgCoreTemperature(avgCoreTemperature: Float?) {
        setFieldValue(208, 0, avgCoreTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get min_core_temperature field
     * Units: C
     *
     * @return min_core_temperature
     */
    fun getMinCoreTemperature(): Float? {
        return getFieldFloatValue(209, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set min_core_temperature field
     * Units: C
     *
     * @param minCoreTemperature The new minCoreTemperature value to be set
     */
    fun setMinCoreTemperature(minCoreTemperature: Float?) {
        setFieldValue(209, 0, minCoreTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_core_temperature field
     * Units: C
     *
     * @return max_core_temperature
     */
    fun getMaxCoreTemperature(): Float? {
        return getFieldFloatValue(210, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_core_temperature field
     * Units: C
     *
     * @param maxCoreTemperature The new maxCoreTemperature value to be set
     */
    fun setMaxCoreTemperature(maxCoreTemperature: Float?) {
        setFieldValue(210, 0, maxCoreTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
