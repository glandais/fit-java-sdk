/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Factory.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit


object Factory {
    fun createMesg(mesg: Mesg): Mesg {
        return when (mesg.getNum()) {
            MesgNum.FILE_ID -> FileIdMesg(mesg)
            MesgNum.FILE_CREATOR -> FileCreatorMesg(mesg)
            MesgNum.TIMESTAMP_CORRELATION -> TimestampCorrelationMesg(mesg)
            MesgNum.SOFTWARE -> SoftwareMesg(mesg)
            MesgNum.SLAVE_DEVICE -> SlaveDeviceMesg(mesg)
            MesgNum.CAPABILITIES -> CapabilitiesMesg(mesg)
            MesgNum.FILE_CAPABILITIES -> FileCapabilitiesMesg(mesg)
            MesgNum.MESG_CAPABILITIES -> MesgCapabilitiesMesg(mesg)
            MesgNum.FIELD_CAPABILITIES -> FieldCapabilitiesMesg(mesg)
            MesgNum.DEVICE_SETTINGS -> DeviceSettingsMesg(mesg)
            MesgNum.USER_PROFILE -> UserProfileMesg(mesg)
            MesgNum.HRM_PROFILE -> HrmProfileMesg(mesg)
            MesgNum.SDM_PROFILE -> SdmProfileMesg(mesg)
            MesgNum.BIKE_PROFILE -> BikeProfileMesg(mesg)
            MesgNum.CONNECTIVITY -> ConnectivityMesg(mesg)
            MesgNum.WATCHFACE_SETTINGS -> WatchfaceSettingsMesg(mesg)
            MesgNum.OHR_SETTINGS -> OhrSettingsMesg(mesg)
            MesgNum.TIME_IN_ZONE -> TimeInZoneMesg(mesg)
            MesgNum.ZONES_TARGET -> ZonesTargetMesg(mesg)
            MesgNum.SPORT -> SportMesg(mesg)
            MesgNum.HR_ZONE -> HrZoneMesg(mesg)
            MesgNum.SPEED_ZONE -> SpeedZoneMesg(mesg)
            MesgNum.CADENCE_ZONE -> CadenceZoneMesg(mesg)
            MesgNum.POWER_ZONE -> PowerZoneMesg(mesg)
            MesgNum.MET_ZONE -> MetZoneMesg(mesg)
            MesgNum.TRAINING_SETTINGS -> TrainingSettingsMesg(mesg)
            MesgNum.DIVE_SETTINGS -> DiveSettingsMesg(mesg)
            MesgNum.DIVE_ALARM -> DiveAlarmMesg(mesg)
            MesgNum.DIVE_APNEA_ALARM -> DiveApneaAlarmMesg(mesg)
            MesgNum.DIVE_GAS -> DiveGasMesg(mesg)
            MesgNum.GOAL -> GoalMesg(mesg)
            MesgNum.ACTIVITY -> ActivityMesg(mesg)
            MesgNum.SESSION -> SessionMesg(mesg)
            MesgNum.LAP -> LapMesg(mesg)
            MesgNum.LENGTH -> LengthMesg(mesg)
            MesgNum.RECORD -> RecordMesg(mesg)
            MesgNum.EVENT -> EventMesg(mesg)
            MesgNum.DEVICE_INFO -> DeviceInfoMesg(mesg)
            MesgNum.DEVICE_AUX_BATTERY_INFO -> DeviceAuxBatteryInfoMesg(mesg)
            MesgNum.TRAINING_FILE -> TrainingFileMesg(mesg)
            MesgNum.WEATHER_CONDITIONS -> WeatherConditionsMesg(mesg)
            MesgNum.WEATHER_ALERT -> WeatherAlertMesg(mesg)
            MesgNum.GPS_METADATA -> GpsMetadataMesg(mesg)
            MesgNum.CAMERA_EVENT -> CameraEventMesg(mesg)
            MesgNum.GYROSCOPE_DATA -> GyroscopeDataMesg(mesg)
            MesgNum.ACCELEROMETER_DATA -> AccelerometerDataMesg(mesg)
            MesgNum.MAGNETOMETER_DATA -> MagnetometerDataMesg(mesg)
            MesgNum.BAROMETER_DATA -> BarometerDataMesg(mesg)
            MesgNum.THREE_D_SENSOR_CALIBRATION -> ThreeDSensorCalibrationMesg(mesg)
            MesgNum.ONE_D_SENSOR_CALIBRATION -> OneDSensorCalibrationMesg(mesg)
            MesgNum.VIDEO_FRAME -> VideoFrameMesg(mesg)
            MesgNum.OBDII_DATA -> ObdiiDataMesg(mesg)
            MesgNum.NMEA_SENTENCE -> NmeaSentenceMesg(mesg)
            MesgNum.AVIATION_ATTITUDE -> AviationAttitudeMesg(mesg)
            MesgNum.VIDEO -> VideoMesg(mesg)
            MesgNum.VIDEO_TITLE -> VideoTitleMesg(mesg)
            MesgNum.VIDEO_DESCRIPTION -> VideoDescriptionMesg(mesg)
            MesgNum.VIDEO_CLIP -> VideoClipMesg(mesg)
            MesgNum.SET -> SetMesg(mesg)
            MesgNum.JUMP -> JumpMesg(mesg)
            MesgNum.SPLIT -> SplitMesg(mesg)
            MesgNum.SPLIT_SUMMARY -> SplitSummaryMesg(mesg)
            MesgNum.CLIMB_PRO -> ClimbProMesg(mesg)
            MesgNum.FIELD_DESCRIPTION -> FieldDescriptionMesg(mesg)
            MesgNum.DEVELOPER_DATA_ID -> DeveloperDataIdMesg(mesg)
            MesgNum.COURSE -> CourseMesg(mesg)
            MesgNum.COURSE_POINT -> CoursePointMesg(mesg)
            MesgNum.SEGMENT_ID -> SegmentIdMesg(mesg)
            MesgNum.SEGMENT_LEADERBOARD_ENTRY -> SegmentLeaderboardEntryMesg(mesg)
            MesgNum.SEGMENT_POINT -> SegmentPointMesg(mesg)
            MesgNum.SEGMENT_LAP -> SegmentLapMesg(mesg)
            MesgNum.SEGMENT_FILE -> SegmentFileMesg(mesg)
            MesgNum.WORKOUT -> WorkoutMesg(mesg)
            MesgNum.WORKOUT_SESSION -> WorkoutSessionMesg(mesg)
            MesgNum.WORKOUT_STEP -> WorkoutStepMesg(mesg)
            MesgNum.EXERCISE_TITLE -> ExerciseTitleMesg(mesg)
            MesgNum.SCHEDULE -> ScheduleMesg(mesg)
            MesgNum.TOTALS -> TotalsMesg(mesg)
            MesgNum.WEIGHT_SCALE -> WeightScaleMesg(mesg)
            MesgNum.BLOOD_PRESSURE -> BloodPressureMesg(mesg)
            MesgNum.MONITORING_INFO -> MonitoringInfoMesg(mesg)
            MesgNum.MONITORING -> MonitoringMesg(mesg)
            MesgNum.MONITORING_HR_DATA -> MonitoringHrDataMesg(mesg)
            MesgNum.SPO2_DATA -> Spo2DataMesg(mesg)
            MesgNum.HR -> HrMesg(mesg)
            MesgNum.STRESS_LEVEL -> StressLevelMesg(mesg)
            MesgNum.MAX_MET_DATA -> MaxMetDataMesg(mesg)
            MesgNum.HSA_BODY_BATTERY_DATA -> HsaBodyBatteryDataMesg(mesg)
            MesgNum.HSA_EVENT -> HsaEventMesg(mesg)
            MesgNum.HSA_ACCELEROMETER_DATA -> HsaAccelerometerDataMesg(mesg)
            MesgNum.HSA_GYROSCOPE_DATA -> HsaGyroscopeDataMesg(mesg)
            MesgNum.HSA_STEP_DATA -> HsaStepDataMesg(mesg)
            MesgNum.HSA_SPO2_DATA -> HsaSpo2DataMesg(mesg)
            MesgNum.HSA_STRESS_DATA -> HsaStressDataMesg(mesg)
            MesgNum.HSA_RESPIRATION_DATA -> HsaRespirationDataMesg(mesg)
            MesgNum.HSA_HEART_RATE_DATA -> HsaHeartRateDataMesg(mesg)
            MesgNum.HSA_CONFIGURATION_DATA -> HsaConfigurationDataMesg(mesg)
            MesgNum.HSA_WRIST_TEMPERATURE_DATA -> HsaWristTemperatureDataMesg(mesg)
            MesgNum.MEMO_GLOB -> MemoGlobMesg(mesg)
            MesgNum.SLEEP_LEVEL -> SleepLevelMesg(mesg)
            MesgNum.ANT_CHANNEL_ID -> AntChannelIdMesg(mesg)
            MesgNum.ANT_RX -> AntRxMesg(mesg)
            MesgNum.ANT_TX -> AntTxMesg(mesg)
            MesgNum.EXD_SCREEN_CONFIGURATION -> ExdScreenConfigurationMesg(mesg)
            MesgNum.EXD_DATA_FIELD_CONFIGURATION -> ExdDataFieldConfigurationMesg(mesg)
            MesgNum.EXD_DATA_CONCEPT_CONFIGURATION -> ExdDataConceptConfigurationMesg(mesg)
            MesgNum.DIVE_SUMMARY -> DiveSummaryMesg(mesg)
            MesgNum.AAD_ACCEL_FEATURES -> AadAccelFeaturesMesg(mesg)
            MesgNum.HRV -> HrvMesg(mesg)
            MesgNum.BEAT_INTERVALS -> BeatIntervalsMesg(mesg)
            MesgNum.HRV_STATUS_SUMMARY -> HrvStatusSummaryMesg(mesg)
            MesgNum.HRV_VALUE -> HrvValueMesg(mesg)
            MesgNum.RAW_BBI -> RawBbiMesg(mesg)
            MesgNum.RESPIRATION_RATE -> RespirationRateMesg(mesg)
            MesgNum.CHRONO_SHOT_SESSION -> ChronoShotSessionMesg(mesg)
            MesgNum.CHRONO_SHOT_DATA -> ChronoShotDataMesg(mesg)
            MesgNum.TANK_UPDATE -> TankUpdateMesg(mesg)
            MesgNum.TANK_SUMMARY -> TankSummaryMesg(mesg)
            MesgNum.SLEEP_ASSESSMENT -> SleepAssessmentMesg(mesg)
            MesgNum.SLEEP_DISRUPTION_SEVERITY_PERIOD -> SleepDisruptionSeverityPeriodMesg(mesg)
            MesgNum.SLEEP_DISRUPTION_OVERNIGHT_SEVERITY -> SleepDisruptionOvernightSeverityMesg(mesg)
            MesgNum.NAP_EVENT -> NapEventMesg(mesg)
            MesgNum.SKIN_TEMP_OVERNIGHT -> SkinTempOvernightMesg(mesg)
            MesgNum.PAD -> PadMesg(mesg)
            else -> Mesg("unknown", MesgNum.INVALID)
        }
    }

    fun createMesg(mesgNum: Int): Mesg {
        for (i in mesgs.indices) {
            if (mesgs[i].num == mesgNum) {
                return Mesg(mesgs[i])
            }
        }
        return Mesg("unknown", mesgNum)
    }

    fun createMesg(mesgName: String?): Mesg {
        for (i in mesgs.indices) {
            if (mesgs[i].name == mesgName) {
                return Mesg(mesgs[i])
            }
        }
        return Mesg(mesgName ?: "unknown", MesgNum.INVALID)
    }

    fun createField(mesgName: String?, fieldName: String?): Field {
        for (i in mesgs.indices) {
            if (mesgs[i].name == mesgName) {
                return Field(mesgs[i].getField(fieldName, false))
            }
        }
        return Field(fieldName ?: "unknown", Fit.FIELD_NUM_INVALID, 0, 1.0, 0.0, "", false, Profile.Type.ENUM)
    }

    fun createField(mesgName: String?, fieldNum: Int): Field {
        for (i in mesgs.indices) {
            if (mesgs[i].name == mesgName) {
                return Field(mesgs[i].getField(fieldNum))
            }
        }
        return Field("unknown", fieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ENUM)
    }

    fun createField(mesgNum: Int, fieldNum: Int): Field {
        for (i in mesgs.indices) {
            if (mesgs[i].num == mesgNum) {
                return Field(mesgs[i].getField(fieldNum))
            }
        }
        return Field("unknown", fieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ENUM)
    }

    fun createField(mesgNum: Int, fieldName: String?): Field {
        for (i in mesgs.indices) {
            if (mesgs[i].num == mesgNum) {
                return Field(mesgs[i].getField(fieldName, false))
            }
        }
        return Field(fieldName ?: "unknown", Fit.FIELD_NUM_INVALID, 0, 1.0, 0.0, "", false, Profile.Type.ENUM)
    }

    fun createField(mesgName: String?, fieldName: String?, values: ArrayList<Any?>): Field {
        val field = createField(mesgName, fieldName)
        field.values = values
        return field
    }

    private val mesgs: Array<Mesg> = arrayOf(
        FileIdMesg.fileIdMesg,
        FileCreatorMesg.fileCreatorMesg,
        TimestampCorrelationMesg.timestampCorrelationMesg,
        SoftwareMesg.softwareMesg,
        SlaveDeviceMesg.slaveDeviceMesg,
        CapabilitiesMesg.capabilitiesMesg,
        FileCapabilitiesMesg.fileCapabilitiesMesg,
        MesgCapabilitiesMesg.mesgCapabilitiesMesg,
        FieldCapabilitiesMesg.fieldCapabilitiesMesg,
        DeviceSettingsMesg.deviceSettingsMesg,
        UserProfileMesg.userProfileMesg,
        HrmProfileMesg.hrmProfileMesg,
        SdmProfileMesg.sdmProfileMesg,
        BikeProfileMesg.bikeProfileMesg,
        ConnectivityMesg.connectivityMesg,
        WatchfaceSettingsMesg.watchfaceSettingsMesg,
        OhrSettingsMesg.ohrSettingsMesg,
        TimeInZoneMesg.timeInZoneMesg,
        ZonesTargetMesg.zonesTargetMesg,
        SportMesg.sportMesg,
        HrZoneMesg.hrZoneMesg,
        SpeedZoneMesg.speedZoneMesg,
        CadenceZoneMesg.cadenceZoneMesg,
        PowerZoneMesg.powerZoneMesg,
        MetZoneMesg.metZoneMesg,
        TrainingSettingsMesg.trainingSettingsMesg,
        DiveSettingsMesg.diveSettingsMesg,
        DiveAlarmMesg.diveAlarmMesg,
        DiveApneaAlarmMesg.diveApneaAlarmMesg,
        DiveGasMesg.diveGasMesg,
        GoalMesg.goalMesg,
        ActivityMesg.activityMesg,
        SessionMesg.sessionMesg,
        LapMesg.lapMesg,
        LengthMesg.lengthMesg,
        RecordMesg.recordMesg,
        EventMesg.eventMesg,
        DeviceInfoMesg.deviceInfoMesg,
        DeviceAuxBatteryInfoMesg.deviceAuxBatteryInfoMesg,
        TrainingFileMesg.trainingFileMesg,
        WeatherConditionsMesg.weatherConditionsMesg,
        WeatherAlertMesg.weatherAlertMesg,
        GpsMetadataMesg.gpsMetadataMesg,
        CameraEventMesg.cameraEventMesg,
        GyroscopeDataMesg.gyroscopeDataMesg,
        AccelerometerDataMesg.accelerometerDataMesg,
        MagnetometerDataMesg.magnetometerDataMesg,
        BarometerDataMesg.barometerDataMesg,
        ThreeDSensorCalibrationMesg.threeDSensorCalibrationMesg,
        OneDSensorCalibrationMesg.oneDSensorCalibrationMesg,
        VideoFrameMesg.videoFrameMesg,
        ObdiiDataMesg.obdiiDataMesg,
        NmeaSentenceMesg.nmeaSentenceMesg,
        AviationAttitudeMesg.aviationAttitudeMesg,
        VideoMesg.videoMesg,
        VideoTitleMesg.videoTitleMesg,
        VideoDescriptionMesg.videoDescriptionMesg,
        VideoClipMesg.videoClipMesg,
        SetMesg.setMesg,
        JumpMesg.jumpMesg,
        SplitMesg.splitMesg,
        SplitSummaryMesg.splitSummaryMesg,
        ClimbProMesg.climbProMesg,
        FieldDescriptionMesg.fieldDescriptionMesg,
        DeveloperDataIdMesg.developerDataIdMesg,
        CourseMesg.courseMesg,
        CoursePointMesg.coursePointMesg,
        SegmentIdMesg.segmentIdMesg,
        SegmentLeaderboardEntryMesg.segmentLeaderboardEntryMesg,
        SegmentPointMesg.segmentPointMesg,
        SegmentLapMesg.segmentLapMesg,
        SegmentFileMesg.segmentFileMesg,
        WorkoutMesg.workoutMesg,
        WorkoutSessionMesg.workoutSessionMesg,
        WorkoutStepMesg.workoutStepMesg,
        ExerciseTitleMesg.exerciseTitleMesg,
        ScheduleMesg.scheduleMesg,
        TotalsMesg.totalsMesg,
        WeightScaleMesg.weightScaleMesg,
        BloodPressureMesg.bloodPressureMesg,
        MonitoringInfoMesg.monitoringInfoMesg,
        MonitoringMesg.monitoringMesg,
        MonitoringHrDataMesg.monitoringHrDataMesg,
        Spo2DataMesg.spo2DataMesg,
        HrMesg.hrMesg,
        StressLevelMesg.stressLevelMesg,
        MaxMetDataMesg.maxMetDataMesg,
        HsaBodyBatteryDataMesg.hsaBodyBatteryDataMesg,
        HsaEventMesg.hsaEventMesg,
        HsaAccelerometerDataMesg.hsaAccelerometerDataMesg,
        HsaGyroscopeDataMesg.hsaGyroscopeDataMesg,
        HsaStepDataMesg.hsaStepDataMesg,
        HsaSpo2DataMesg.hsaSpo2DataMesg,
        HsaStressDataMesg.hsaStressDataMesg,
        HsaRespirationDataMesg.hsaRespirationDataMesg,
        HsaHeartRateDataMesg.hsaHeartRateDataMesg,
        HsaConfigurationDataMesg.hsaConfigurationDataMesg,
        HsaWristTemperatureDataMesg.hsaWristTemperatureDataMesg,
        MemoGlobMesg.memoGlobMesg,
        SleepLevelMesg.sleepLevelMesg,
        AntChannelIdMesg.antChannelIdMesg,
        AntRxMesg.antRxMesg,
        AntTxMesg.antTxMesg,
        ExdScreenConfigurationMesg.exdScreenConfigurationMesg,
        ExdDataFieldConfigurationMesg.exdDataFieldConfigurationMesg,
        ExdDataConceptConfigurationMesg.exdDataConceptConfigurationMesg,
        DiveSummaryMesg.diveSummaryMesg,
        AadAccelFeaturesMesg.aadAccelFeaturesMesg,
        HrvMesg.hrvMesg,
        BeatIntervalsMesg.beatIntervalsMesg,
        HrvStatusSummaryMesg.hrvStatusSummaryMesg,
        HrvValueMesg.hrvValueMesg,
        RawBbiMesg.rawBbiMesg,
        RespirationRateMesg.respirationRateMesg,
        ChronoShotSessionMesg.chronoShotSessionMesg,
        ChronoShotDataMesg.chronoShotDataMesg,
        TankUpdateMesg.tankUpdateMesg,
        TankSummaryMesg.tankSummaryMesg,
        SleepAssessmentMesg.sleepAssessmentMesg,
        SleepDisruptionSeverityPeriodMesg.sleepDisruptionSeverityPeriodMesg,
        SleepDisruptionOvernightSeverityMesg.sleepDisruptionOvernightSeverityMesg,
        NapEventMesg.napEventMesg,
        SkinTempOvernightMesg.skinTempOvernightMesg,
        PadMesg.padMesg,
    )
}
