/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Profile.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit


object Profile {
    object SubFields {

        // file_id message, product field
        const val FILE_ID_MESG_PRODUCT_FIELD_FAVERO_PRODUCT = 0
        const val FILE_ID_MESG_PRODUCT_FIELD_GARMIN_PRODUCT = 1
        const val FILE_ID_MESG_PRODUCT_FIELD_SUBFIELDS = 2
        val FILE_ID_MESG_PRODUCT_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val FILE_ID_MESG_PRODUCT_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // slave_device message, product field
        const val SLAVE_DEVICE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT = 0
        const val SLAVE_DEVICE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT = 1
        const val SLAVE_DEVICE_MESG_PRODUCT_FIELD_SUBFIELDS = 2
        val SLAVE_DEVICE_MESG_PRODUCT_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val SLAVE_DEVICE_MESG_PRODUCT_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // mesg_capabilities message, count field
        const val MESG_CAPABILITIES_MESG_COUNT_FIELD_NUM_PER_FILE = 0
        const val MESG_CAPABILITIES_MESG_COUNT_FIELD_MAX_PER_FILE = 1
        const val MESG_CAPABILITIES_MESG_COUNT_FIELD_MAX_PER_FILE_TYPE = 2
        const val MESG_CAPABILITIES_MESG_COUNT_FIELD_SUBFIELDS = 3
        val MESG_CAPABILITIES_MESG_COUNT_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val MESG_CAPABILITIES_MESG_COUNT_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // watchface_settings message, layout field
        const val WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_DIGITAL_LAYOUT = 0
        const val WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_ANALOG_LAYOUT = 1
        const val WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_SUBFIELDS = 2
        val WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // dive_settings message, heart_rate_source field
        const val DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_ANTPLUS_DEVICE_TYPE = 0
        const val DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_LOCAL_DEVICE_TYPE = 1
        const val DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_SUBFIELDS = 2
        val DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // session message, total_cycles field
        const val SESSION_MESG_TOTAL_CYCLES_FIELD_TOTAL_STRIDES = 0
        const val SESSION_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES = 1
        const val SESSION_MESG_TOTAL_CYCLES_FIELD_SUBFIELDS = 2
        val SESSION_MESG_TOTAL_CYCLES_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val SESSION_MESG_TOTAL_CYCLES_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // session message, avg_cadence field
        const val SESSION_MESG_AVG_CADENCE_FIELD_AVG_RUNNING_CADENCE = 0
        const val SESSION_MESG_AVG_CADENCE_FIELD_SUBFIELDS = 1
        val SESSION_MESG_AVG_CADENCE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val SESSION_MESG_AVG_CADENCE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // session message, max_cadence field
        const val SESSION_MESG_MAX_CADENCE_FIELD_MAX_RUNNING_CADENCE = 0
        const val SESSION_MESG_MAX_CADENCE_FIELD_SUBFIELDS = 1
        val SESSION_MESG_MAX_CADENCE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val SESSION_MESG_MAX_CADENCE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // lap message, total_cycles field
        const val LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STRIDES = 0
        const val LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES = 1
        const val LAP_MESG_TOTAL_CYCLES_FIELD_SUBFIELDS = 2
        val LAP_MESG_TOTAL_CYCLES_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val LAP_MESG_TOTAL_CYCLES_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // lap message, avg_cadence field
        const val LAP_MESG_AVG_CADENCE_FIELD_AVG_RUNNING_CADENCE = 0
        const val LAP_MESG_AVG_CADENCE_FIELD_SUBFIELDS = 1
        val LAP_MESG_AVG_CADENCE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val LAP_MESG_AVG_CADENCE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // lap message, max_cadence field
        const val LAP_MESG_MAX_CADENCE_FIELD_MAX_RUNNING_CADENCE = 0
        const val LAP_MESG_MAX_CADENCE_FIELD_SUBFIELDS = 1
        val LAP_MESG_MAX_CADENCE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val LAP_MESG_MAX_CADENCE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // event message, data field
        const val EVENT_MESG_DATA_FIELD_TIMER_TRIGGER = 0
        const val EVENT_MESG_DATA_FIELD_COURSE_POINT_INDEX = 1
        const val EVENT_MESG_DATA_FIELD_BATTERY_LEVEL = 2
        const val EVENT_MESG_DATA_FIELD_VIRTUAL_PARTNER_SPEED = 3
        const val EVENT_MESG_DATA_FIELD_HR_HIGH_ALERT = 4
        const val EVENT_MESG_DATA_FIELD_HR_LOW_ALERT = 5
        const val EVENT_MESG_DATA_FIELD_SPEED_HIGH_ALERT = 6
        const val EVENT_MESG_DATA_FIELD_SPEED_LOW_ALERT = 7
        const val EVENT_MESG_DATA_FIELD_CAD_HIGH_ALERT = 8
        const val EVENT_MESG_DATA_FIELD_CAD_LOW_ALERT = 9
        const val EVENT_MESG_DATA_FIELD_POWER_HIGH_ALERT = 10
        const val EVENT_MESG_DATA_FIELD_POWER_LOW_ALERT = 11
        const val EVENT_MESG_DATA_FIELD_TIME_DURATION_ALERT = 12
        const val EVENT_MESG_DATA_FIELD_DISTANCE_DURATION_ALERT = 13
        const val EVENT_MESG_DATA_FIELD_CALORIE_DURATION_ALERT = 14
        const val EVENT_MESG_DATA_FIELD_FITNESS_EQUIPMENT_STATE = 15
        const val EVENT_MESG_DATA_FIELD_SPORT_POINT = 16
        const val EVENT_MESG_DATA_FIELD_GEAR_CHANGE_DATA = 17
        const val EVENT_MESG_DATA_FIELD_RIDER_POSITION = 18
        const val EVENT_MESG_DATA_FIELD_COMM_TIMEOUT = 19
        const val EVENT_MESG_DATA_FIELD_DIVE_ALERT = 20
        const val EVENT_MESG_DATA_FIELD_AUTO_ACTIVITY_DETECT_DURATION = 21
        const val EVENT_MESG_DATA_FIELD_RADAR_THREAT_ALERT = 22
        const val EVENT_MESG_DATA_FIELD_SUBFIELDS = 23
        val EVENT_MESG_DATA_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val EVENT_MESG_DATA_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // event message, start_timestamp field
        const val EVENT_MESG_START_TIMESTAMP_FIELD_AUTO_ACTIVITY_DETECT_START_TIMESTAMP = 0
        const val EVENT_MESG_START_TIMESTAMP_FIELD_SUBFIELDS = 1
        val EVENT_MESG_START_TIMESTAMP_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val EVENT_MESG_START_TIMESTAMP_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // device_info message, device_type field
        const val DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_BLE_DEVICE_TYPE = 0
        const val DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANTPLUS_DEVICE_TYPE = 1
        const val DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANT_DEVICE_TYPE = 2
        const val DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_LOCAL_DEVICE_TYPE = 3
        const val DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_SUBFIELDS = 4
        val DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // device_info message, product field
        const val DEVICE_INFO_MESG_PRODUCT_FIELD_FAVERO_PRODUCT = 0
        const val DEVICE_INFO_MESG_PRODUCT_FIELD_GARMIN_PRODUCT = 1
        const val DEVICE_INFO_MESG_PRODUCT_FIELD_SUBFIELDS = 2
        val DEVICE_INFO_MESG_PRODUCT_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val DEVICE_INFO_MESG_PRODUCT_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // training_file message, product field
        const val TRAINING_FILE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT = 0
        const val TRAINING_FILE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT = 1
        const val TRAINING_FILE_MESG_PRODUCT_FIELD_SUBFIELDS = 2
        val TRAINING_FILE_MESG_PRODUCT_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val TRAINING_FILE_MESG_PRODUCT_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // three_d_sensor_calibration message, calibration_factor field
        const val THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_ACCEL_CAL_FACTOR = 0
        const val THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_GYRO_CAL_FACTOR = 1
        const val THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_SUBFIELDS = 2
        val THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val THREE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // one_d_sensor_calibration message, calibration_factor field
        const val ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_BARO_CAL_FACTOR = 0
        const val ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_SUBFIELDS = 1
        val ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val ONE_D_SENSOR_CALIBRATION_MESG_CALIBRATION_FACTOR_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // segment_lap message, total_cycles field
        const val SEGMENT_LAP_MESG_TOTAL_CYCLES_FIELD_TOTAL_STROKES = 0
        const val SEGMENT_LAP_MESG_TOTAL_CYCLES_FIELD_SUBFIELDS = 1
        val SEGMENT_LAP_MESG_TOTAL_CYCLES_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val SEGMENT_LAP_MESG_TOTAL_CYCLES_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // workout_step message, duration_value field
        const val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_TIME = 0
        const val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_DISTANCE = 1
        const val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_HR = 2
        const val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_CALORIES = 3
        const val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_STEP = 4
        const val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_POWER = 5
        const val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_REPS = 6
        const val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_SUBFIELDS = 7
        val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // workout_step message, target_value field
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_SPEED_ZONE = 0
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_HR_ZONE = 1
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_CADENCE_ZONE = 2
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_POWER_ZONE = 3
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_STEPS = 4
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_TIME = 5
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_DISTANCE = 6
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_CALORIES = 7
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_HR = 8
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_POWER = 9
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_STROKE_TYPE = 10
        const val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_SUBFIELDS = 11
        val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // workout_step message, custom_target_value_low field
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_SPEED_LOW = 0
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_HEART_RATE_LOW = 1
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_CADENCE_LOW = 2
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_POWER_LOW = 3
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_SUBFIELDS = 4
        val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // workout_step message, custom_target_value_high field
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_SPEED_HIGH = 0
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_HEART_RATE_HIGH = 1
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_CADENCE_HIGH = 2
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_POWER_HIGH = 3
        const val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_SUBFIELDS = 4
        val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // workout_step message, secondary_target_value field
        const val WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_SPEED_ZONE = 0
        const val WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_HR_ZONE = 1
        const val WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_CADENCE_ZONE = 2
        const val WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_POWER_ZONE = 3
        const val WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_STROKE_TYPE = 4
        const val WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SUBFIELDS = 5
        val WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // workout_step message, secondary_custom_target_value_low field
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_LOW = 0
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_LOW = 1
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_LOW = 2
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_POWER_LOW = 3
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SUBFIELDS = 4
        val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // workout_step message, secondary_custom_target_value_high field
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_HIGH = 0
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_HIGH = 1
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_HIGH = 2
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_POWER_HIGH = 3
        const val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SUBFIELDS = 4
        val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // schedule message, product field
        const val SCHEDULE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT = 0
        const val SCHEDULE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT = 1
        const val SCHEDULE_MESG_PRODUCT_FIELD_SUBFIELDS = 2
        val SCHEDULE_MESG_PRODUCT_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val SCHEDULE_MESG_PRODUCT_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD

        // monitoring message, cycles field
        const val MONITORING_MESG_CYCLES_FIELD_STEPS = 0
        const val MONITORING_MESG_CYCLES_FIELD_STROKES = 1
        const val MONITORING_MESG_CYCLES_FIELD_SUBFIELDS = 2
        val MONITORING_MESG_CYCLES_FIELD_ACTIVE_SUBFIELD = Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD
        val MONITORING_MESG_CYCLES_FIELD_MAIN_FIELD = Fit.SUBFIELD_INDEX_MAIN_FIELD
    }

    /**
     * Returns the string name associated with a given enum value. If there is no such
     * label, returns the string representation of the numerical value instead.
     *
     * @param enumType the type of the enum
     * @param enumVal the numerical value of the enum
     * @return the enum label associated with this value for the given enum type, or the
     *         string representation of the numerical value if there is no such label.
     */
    fun enumValueName(enumType: Type, enumVal: Long): String {
        var retVal = ""
        val shortVal = enumVal.toShort()

        when (enumType) {
            Type.FILE -> retVal = File.getStringFromValue(File.fromValue(shortVal))
            Type.MESG_NUM -> retVal = MesgNum.getStringFromValue(enumVal.toInt())
            Type.CHECKSUM -> retVal = Checksum.getStringFromValue(enumVal.toShort())
            Type.FILE_FLAGS -> retVal = FileFlags.getStringFromValue(enumVal.toShort())
            Type.MESG_COUNT -> retVal = MesgCount.getStringFromValue(MesgCount.fromValue(shortVal))
            Type.DATE_TIME -> retVal = DateTime.getStringFromValue(enumVal)
            Type.LOCAL_DATE_TIME -> retVal = LocalDateTime.getStringFromValue(enumVal)
            Type.MESSAGE_INDEX -> retVal = MessageIndex.getStringFromValue(enumVal.toInt())
            Type.DEVICE_INDEX -> retVal = DeviceIndex.getStringFromValue(enumVal.toShort())
            Type.GENDER -> retVal = Gender.getStringFromValue(Gender.fromValue(shortVal))
            Type.LANGUAGE -> retVal = Language.getStringFromValue(Language.fromValue(shortVal))
            Type.LANGUAGE_BITS_0 -> retVal = LanguageBits0.getStringFromValue(enumVal.toShort())
            Type.LANGUAGE_BITS_1 -> retVal = LanguageBits1.getStringFromValue(enumVal.toShort())
            Type.LANGUAGE_BITS_2 -> retVal = LanguageBits2.getStringFromValue(enumVal.toShort())
            Type.LANGUAGE_BITS_3 -> retVal = LanguageBits3.getStringFromValue(enumVal.toShort())
            Type.LANGUAGE_BITS_4 -> retVal = LanguageBits4.getStringFromValue(enumVal.toShort())
            Type.TIME_ZONE -> retVal = TimeZone.getStringFromValue(TimeZone.fromValue(shortVal))
            Type.DISPLAY_MEASURE -> retVal = DisplayMeasure.getStringFromValue(DisplayMeasure.fromValue(shortVal))
            Type.DISPLAY_HEART -> retVal = DisplayHeart.getStringFromValue(DisplayHeart.fromValue(shortVal))
            Type.DISPLAY_POWER -> retVal = DisplayPower.getStringFromValue(DisplayPower.fromValue(shortVal))
            Type.DISPLAY_POSITION -> retVal = DisplayPosition.getStringFromValue(DisplayPosition.fromValue(shortVal))
            Type.SWITCH -> retVal = Switch.getStringFromValue(Switch.fromValue(shortVal))
            Type.SPORT -> retVal = Sport.getStringFromValue(Sport.fromValue(shortVal))
            Type.SPORT_BITS_0 -> retVal = SportBits0.getStringFromValue(enumVal.toShort())
            Type.SPORT_BITS_1 -> retVal = SportBits1.getStringFromValue(enumVal.toShort())
            Type.SPORT_BITS_2 -> retVal = SportBits2.getStringFromValue(enumVal.toShort())
            Type.SPORT_BITS_3 -> retVal = SportBits3.getStringFromValue(enumVal.toShort())
            Type.SPORT_BITS_4 -> retVal = SportBits4.getStringFromValue(enumVal.toShort())
            Type.SPORT_BITS_5 -> retVal = SportBits5.getStringFromValue(enumVal.toShort())
            Type.SPORT_BITS_6 -> retVal = SportBits6.getStringFromValue(enumVal.toShort())
            Type.SUB_SPORT -> retVal = SubSport.getStringFromValue(SubSport.fromValue(shortVal))
            Type.SPORT_EVENT -> retVal = SportEvent.getStringFromValue(SportEvent.fromValue(shortVal))
            Type.ACTIVITY -> retVal = Activity.getStringFromValue(Activity.fromValue(shortVal))
            Type.INTENSITY -> retVal = Intensity.getStringFromValue(Intensity.fromValue(shortVal))
            Type.SESSION_TRIGGER -> retVal = SessionTrigger.getStringFromValue(SessionTrigger.fromValue(shortVal))
            Type.AUTOLAP_TRIGGER -> retVal = AutolapTrigger.getStringFromValue(AutolapTrigger.fromValue(shortVal))
            Type.LAP_TRIGGER -> retVal = LapTrigger.getStringFromValue(LapTrigger.fromValue(shortVal))
            Type.TIME_MODE -> retVal = TimeMode.getStringFromValue(TimeMode.fromValue(shortVal))
            Type.BACKLIGHT_MODE -> retVal = BacklightMode.getStringFromValue(BacklightMode.fromValue(shortVal))
            Type.DATE_MODE -> retVal = DateMode.getStringFromValue(DateMode.fromValue(shortVal))
            Type.BACKLIGHT_TIMEOUT -> retVal = BacklightTimeout.getStringFromValue(enumVal.toShort())
            Type.EVENT -> retVal = Event.getStringFromValue(Event.fromValue(shortVal))
            Type.EVENT_TYPE -> retVal = EventType.getStringFromValue(EventType.fromValue(shortVal))
            Type.TIMER_TRIGGER -> retVal = TimerTrigger.getStringFromValue(TimerTrigger.fromValue(shortVal))
            Type.FITNESS_EQUIPMENT_STATE -> retVal = FitnessEquipmentState.getStringFromValue(FitnessEquipmentState.fromValue(shortVal))
            Type.TONE -> retVal = Tone.getStringFromValue(Tone.fromValue(shortVal))
            Type.AUTOSCROLL -> retVal = Autoscroll.getStringFromValue(Autoscroll.fromValue(shortVal))
            Type.ACTIVITY_CLASS -> retVal = ActivityClass.getStringFromValue(ActivityClass.fromValue(shortVal))
            Type.HR_ZONE_CALC -> retVal = HrZoneCalc.getStringFromValue(HrZoneCalc.fromValue(shortVal))
            Type.PWR_ZONE_CALC -> retVal = PwrZoneCalc.getStringFromValue(PwrZoneCalc.fromValue(shortVal))
            Type.WKT_STEP_DURATION -> retVal = WktStepDuration.getStringFromValue(WktStepDuration.fromValue(shortVal))
            Type.WKT_STEP_TARGET -> retVal = WktStepTarget.getStringFromValue(WktStepTarget.fromValue(shortVal))
            Type.GOAL -> retVal = Goal.getStringFromValue(Goal.fromValue(shortVal))
            Type.GOAL_RECURRENCE -> retVal = GoalRecurrence.getStringFromValue(GoalRecurrence.fromValue(shortVal))
            Type.GOAL_SOURCE -> retVal = GoalSource.getStringFromValue(GoalSource.fromValue(shortVal))
            Type.SCHEDULE -> retVal = Schedule.getStringFromValue(Schedule.fromValue(shortVal))
            Type.COURSE_POINT -> retVal = CoursePoint.getStringFromValue(CoursePoint.fromValue(shortVal))
            Type.MANUFACTURER -> retVal = Manufacturer.getStringFromValue(enumVal.toInt())
            Type.GARMIN_PRODUCT -> retVal = GarminProduct.getStringFromValue(enumVal.toInt())
            Type.ANTPLUS_DEVICE_TYPE -> retVal = AntplusDeviceType.getStringFromValue(enumVal.toShort())
            Type.ANT_NETWORK -> retVal = AntNetwork.getStringFromValue(AntNetwork.fromValue(shortVal))
            Type.WORKOUT_CAPABILITIES -> retVal = WorkoutCapabilities.getStringFromValue(enumVal)
            Type.BATTERY_STATUS -> retVal = BatteryStatus.getStringFromValue(enumVal.toShort())
            Type.HR_TYPE -> retVal = HrType.getStringFromValue(HrType.fromValue(shortVal))
            Type.COURSE_CAPABILITIES -> retVal = CourseCapabilities.getStringFromValue(enumVal)
            Type.WEIGHT -> retVal = Weight.getStringFromValue(enumVal.toInt())
            Type.WORKOUT_HR -> retVal = WorkoutHr.getStringFromValue(enumVal)
            Type.WORKOUT_POWER -> retVal = WorkoutPower.getStringFromValue(enumVal)
            Type.BP_STATUS -> retVal = BpStatus.getStringFromValue(BpStatus.fromValue(shortVal))
            Type.USER_LOCAL_ID -> retVal = UserLocalId.getStringFromValue(enumVal.toInt())
            Type.SWIM_STROKE -> retVal = SwimStroke.getStringFromValue(SwimStroke.fromValue(shortVal))
            Type.ACTIVITY_TYPE -> retVal = ActivityType.getStringFromValue(ActivityType.fromValue(shortVal))
            Type.ACTIVITY_SUBTYPE -> retVal = ActivitySubtype.getStringFromValue(ActivitySubtype.fromValue(shortVal))
            Type.ACTIVITY_LEVEL -> retVal = ActivityLevel.getStringFromValue(ActivityLevel.fromValue(shortVal))
            Type.SIDE -> retVal = Side.getStringFromValue(Side.fromValue(shortVal))
            Type.LEFT_RIGHT_BALANCE -> retVal = LeftRightBalance.getStringFromValue(enumVal.toShort())
            Type.LEFT_RIGHT_BALANCE_100 -> retVal = LeftRightBalance100.getStringFromValue(enumVal.toInt())
            Type.LENGTH_TYPE -> retVal = LengthType.getStringFromValue(LengthType.fromValue(shortVal))
            Type.DAY_OF_WEEK -> retVal = DayOfWeek.getStringFromValue(DayOfWeek.fromValue(shortVal))
            Type.CONNECTIVITY_CAPABILITIES -> retVal = ConnectivityCapabilities.getStringFromValue(enumVal)
            Type.WEATHER_REPORT -> retVal = WeatherReport.getStringFromValue(WeatherReport.fromValue(shortVal))
            Type.WEATHER_STATUS -> retVal = WeatherStatus.getStringFromValue(WeatherStatus.fromValue(shortVal))
            Type.WEATHER_SEVERITY -> retVal = WeatherSeverity.getStringFromValue(WeatherSeverity.fromValue(shortVal))
            Type.WEATHER_SEVERE_TYPE -> retVal = WeatherSevereType.getStringFromValue(WeatherSevereType.fromValue(shortVal))
            Type.TIME_INTO_DAY -> retVal = TimeIntoDay.getStringFromValue(enumVal)
            Type.LOCALTIME_INTO_DAY -> retVal = LocaltimeIntoDay.getStringFromValue(enumVal)
            Type.STROKE_TYPE -> retVal = StrokeType.getStringFromValue(StrokeType.fromValue(shortVal))
            Type.BODY_LOCATION -> retVal = BodyLocation.getStringFromValue(BodyLocation.fromValue(shortVal))
            Type.SEGMENT_LAP_STATUS -> retVal = SegmentLapStatus.getStringFromValue(SegmentLapStatus.fromValue(shortVal))
            Type.SEGMENT_LEADERBOARD_TYPE -> retVal = SegmentLeaderboardType.getStringFromValue(SegmentLeaderboardType.fromValue(shortVal))
            Type.SEGMENT_DELETE_STATUS -> retVal = SegmentDeleteStatus.getStringFromValue(SegmentDeleteStatus.fromValue(shortVal))
            Type.SEGMENT_SELECTION_TYPE -> retVal = SegmentSelectionType.getStringFromValue(SegmentSelectionType.fromValue(shortVal))
            Type.SOURCE_TYPE -> retVal = SourceType.getStringFromValue(SourceType.fromValue(shortVal))
            Type.LOCAL_DEVICE_TYPE -> retVal = LocalDeviceType.getStringFromValue(enumVal.toShort())
            Type.BLE_DEVICE_TYPE -> retVal = BleDeviceType.getStringFromValue(enumVal.toShort())
            Type.ANT_CHANNEL_ID -> retVal = AntChannelId.getStringFromValue(enumVal)
            Type.DISPLAY_ORIENTATION -> retVal = DisplayOrientation.getStringFromValue(DisplayOrientation.fromValue(shortVal))
            Type.WORKOUT_EQUIPMENT -> retVal = WorkoutEquipment.getStringFromValue(WorkoutEquipment.fromValue(shortVal))
            Type.WATCHFACE_MODE -> retVal = WatchfaceMode.getStringFromValue(WatchfaceMode.fromValue(shortVal))
            Type.DIGITAL_WATCHFACE_LAYOUT -> retVal = DigitalWatchfaceLayout.getStringFromValue(DigitalWatchfaceLayout.fromValue(shortVal))
            Type.ANALOG_WATCHFACE_LAYOUT -> retVal = AnalogWatchfaceLayout.getStringFromValue(AnalogWatchfaceLayout.fromValue(shortVal))
            Type.RIDER_POSITION_TYPE -> retVal = RiderPositionType.getStringFromValue(RiderPositionType.fromValue(shortVal))
            Type.POWER_PHASE_TYPE -> retVal = PowerPhaseType.getStringFromValue(PowerPhaseType.fromValue(shortVal))
            Type.CAMERA_EVENT_TYPE -> retVal = CameraEventType.getStringFromValue(CameraEventType.fromValue(shortVal))
            Type.SENSOR_TYPE -> retVal = SensorType.getStringFromValue(SensorType.fromValue(shortVal))
            Type.BIKE_LIGHT_NETWORK_CONFIG_TYPE -> retVal = BikeLightNetworkConfigType.getStringFromValue(BikeLightNetworkConfigType.fromValue(shortVal))
            Type.COMM_TIMEOUT_TYPE -> retVal = CommTimeoutType.getStringFromValue(enumVal.toInt())
            Type.CAMERA_ORIENTATION_TYPE -> retVal = CameraOrientationType.getStringFromValue(CameraOrientationType.fromValue(shortVal))
            Type.ATTITUDE_STAGE -> retVal = AttitudeStage.getStringFromValue(AttitudeStage.fromValue(shortVal))
            Type.ATTITUDE_VALIDITY -> retVal = AttitudeValidity.getStringFromValue(enumVal.toInt())
            Type.AUTO_SYNC_FREQUENCY -> retVal = AutoSyncFrequency.getStringFromValue(AutoSyncFrequency.fromValue(shortVal))
            Type.EXD_LAYOUT -> retVal = ExdLayout.getStringFromValue(ExdLayout.fromValue(shortVal))
            Type.EXD_DISPLAY_TYPE -> retVal = ExdDisplayType.getStringFromValue(ExdDisplayType.fromValue(shortVal))
            Type.EXD_DATA_UNITS -> retVal = ExdDataUnits.getStringFromValue(ExdDataUnits.fromValue(shortVal))
            Type.EXD_QUALIFIERS -> retVal = ExdQualifiers.getStringFromValue(ExdQualifiers.fromValue(shortVal))
            Type.EXD_DESCRIPTORS -> retVal = ExdDescriptors.getStringFromValue(ExdDescriptors.fromValue(shortVal))
            Type.AUTO_ACTIVITY_DETECT -> retVal = AutoActivityDetect.getStringFromValue(enumVal)
            Type.SUPPORTED_EXD_SCREEN_LAYOUTS -> retVal = SupportedExdScreenLayouts.getStringFromValue(enumVal)
            Type.FIT_BASE_TYPE -> retVal = FitBaseType.getStringFromValue(enumVal.toShort())
            Type.TURN_TYPE -> retVal = TurnType.getStringFromValue(TurnType.fromValue(shortVal))
            Type.BIKE_LIGHT_BEAM_ANGLE_MODE -> retVal = BikeLightBeamAngleMode.getStringFromValue(enumVal.toShort())
            Type.FIT_BASE_UNIT -> retVal = FitBaseUnit.getStringFromValue(enumVal.toInt())
            Type.SET_TYPE -> retVal = SetType.getStringFromValue(enumVal.toShort())
            Type.MAX_MET_CATEGORY -> retVal = MaxMetCategory.getStringFromValue(MaxMetCategory.fromValue(shortVal))
            Type.EXERCISE_CATEGORY -> retVal = ExerciseCategory.getStringFromValue(enumVal.toInt())
            Type.BENCH_PRESS_EXERCISE_NAME -> retVal = BenchPressExerciseName.getStringFromValue(enumVal.toInt())
            Type.CALF_RAISE_EXERCISE_NAME -> retVal = CalfRaiseExerciseName.getStringFromValue(enumVal.toInt())
            Type.CARDIO_EXERCISE_NAME -> retVal = CardioExerciseName.getStringFromValue(enumVal.toInt())
            Type.CARRY_EXERCISE_NAME -> retVal = CarryExerciseName.getStringFromValue(enumVal.toInt())
            Type.CHOP_EXERCISE_NAME -> retVal = ChopExerciseName.getStringFromValue(enumVal.toInt())
            Type.CORE_EXERCISE_NAME -> retVal = CoreExerciseName.getStringFromValue(enumVal.toInt())
            Type.CRUNCH_EXERCISE_NAME -> retVal = CrunchExerciseName.getStringFromValue(enumVal.toInt())
            Type.CURL_EXERCISE_NAME -> retVal = CurlExerciseName.getStringFromValue(enumVal.toInt())
            Type.DEADLIFT_EXERCISE_NAME -> retVal = DeadliftExerciseName.getStringFromValue(enumVal.toInt())
            Type.FLYE_EXERCISE_NAME -> retVal = FlyeExerciseName.getStringFromValue(enumVal.toInt())
            Type.HIP_RAISE_EXERCISE_NAME -> retVal = HipRaiseExerciseName.getStringFromValue(enumVal.toInt())
            Type.HIP_STABILITY_EXERCISE_NAME -> retVal = HipStabilityExerciseName.getStringFromValue(enumVal.toInt())
            Type.HIP_SWING_EXERCISE_NAME -> retVal = HipSwingExerciseName.getStringFromValue(enumVal.toInt())
            Type.HYPEREXTENSION_EXERCISE_NAME -> retVal = HyperextensionExerciseName.getStringFromValue(enumVal.toInt())
            Type.LATERAL_RAISE_EXERCISE_NAME -> retVal = LateralRaiseExerciseName.getStringFromValue(enumVal.toInt())
            Type.LEG_CURL_EXERCISE_NAME -> retVal = LegCurlExerciseName.getStringFromValue(enumVal.toInt())
            Type.LEG_RAISE_EXERCISE_NAME -> retVal = LegRaiseExerciseName.getStringFromValue(enumVal.toInt())
            Type.LUNGE_EXERCISE_NAME -> retVal = LungeExerciseName.getStringFromValue(enumVal.toInt())
            Type.OLYMPIC_LIFT_EXERCISE_NAME -> retVal = OlympicLiftExerciseName.getStringFromValue(enumVal.toInt())
            Type.PLANK_EXERCISE_NAME -> retVal = PlankExerciseName.getStringFromValue(enumVal.toInt())
            Type.PLYO_EXERCISE_NAME -> retVal = PlyoExerciseName.getStringFromValue(enumVal.toInt())
            Type.PULL_UP_EXERCISE_NAME -> retVal = PullUpExerciseName.getStringFromValue(enumVal.toInt())
            Type.PUSH_UP_EXERCISE_NAME -> retVal = PushUpExerciseName.getStringFromValue(enumVal.toInt())
            Type.ROW_EXERCISE_NAME -> retVal = RowExerciseName.getStringFromValue(enumVal.toInt())
            Type.SHOULDER_PRESS_EXERCISE_NAME -> retVal = ShoulderPressExerciseName.getStringFromValue(enumVal.toInt())
            Type.SHOULDER_STABILITY_EXERCISE_NAME -> retVal = ShoulderStabilityExerciseName.getStringFromValue(enumVal.toInt())
            Type.SHRUG_EXERCISE_NAME -> retVal = ShrugExerciseName.getStringFromValue(enumVal.toInt())
            Type.SIT_UP_EXERCISE_NAME -> retVal = SitUpExerciseName.getStringFromValue(enumVal.toInt())
            Type.SQUAT_EXERCISE_NAME -> retVal = SquatExerciseName.getStringFromValue(enumVal.toInt())
            Type.TOTAL_BODY_EXERCISE_NAME -> retVal = TotalBodyExerciseName.getStringFromValue(enumVal.toInt())
            Type.MOVE_EXERCISE_NAME -> retVal = MoveExerciseName.getStringFromValue(enumVal.toInt())
            Type.POSE_EXERCISE_NAME -> retVal = PoseExerciseName.getStringFromValue(enumVal.toInt())
            Type.TRICEPS_EXTENSION_EXERCISE_NAME -> retVal = TricepsExtensionExerciseName.getStringFromValue(enumVal.toInt())
            Type.WARM_UP_EXERCISE_NAME -> retVal = WarmUpExerciseName.getStringFromValue(enumVal.toInt())
            Type.RUN_EXERCISE_NAME -> retVal = RunExerciseName.getStringFromValue(enumVal.toInt())
            Type.BIKE_EXERCISE_NAME -> retVal = BikeExerciseName.getStringFromValue(enumVal.toInt())
            Type.BANDED_EXERCISES_EXERCISE_NAME -> retVal = BandedExercisesExerciseName.getStringFromValue(enumVal.toInt())
            Type.BATTLE_ROPE_EXERCISE_NAME -> retVal = BattleRopeExerciseName.getStringFromValue(enumVal.toInt())
            Type.ELLIPTICAL_EXERCISE_NAME -> retVal = EllipticalExerciseName.getStringFromValue(enumVal.toInt())
            Type.FLOOR_CLIMB_EXERCISE_NAME -> retVal = FloorClimbExerciseName.getStringFromValue(enumVal.toInt())
            Type.INDOOR_BIKE_EXERCISE_NAME -> retVal = IndoorBikeExerciseName.getStringFromValue(enumVal.toInt())
            Type.INDOOR_ROW_EXERCISE_NAME -> retVal = IndoorRowExerciseName.getStringFromValue(enumVal.toInt())
            Type.LADDER_EXERCISE_NAME -> retVal = LadderExerciseName.getStringFromValue(enumVal.toInt())
            Type.SANDBAG_EXERCISE_NAME -> retVal = SandbagExerciseName.getStringFromValue(enumVal.toInt())
            Type.SLED_EXERCISE_NAME -> retVal = SledExerciseName.getStringFromValue(enumVal.toInt())
            Type.SLEDGE_HAMMER_EXERCISE_NAME -> retVal = SledgeHammerExerciseName.getStringFromValue(enumVal.toInt())
            Type.STAIR_STEPPER_EXERCISE_NAME -> retVal = StairStepperExerciseName.getStringFromValue(enumVal.toInt())
            Type.SUSPENSION_EXERCISE_NAME -> retVal = SuspensionExerciseName.getStringFromValue(enumVal.toInt())
            Type.TIRE_EXERCISE_NAME -> retVal = TireExerciseName.getStringFromValue(enumVal.toInt())
            Type.BIKE_OUTDOOR_EXERCISE_NAME -> retVal = BikeOutdoorExerciseName.getStringFromValue(enumVal.toInt())
            Type.RUN_INDOOR_EXERCISE_NAME -> retVal = RunIndoorExerciseName.getStringFromValue(enumVal.toInt())
            Type.WATER_TYPE -> retVal = WaterType.getStringFromValue(WaterType.fromValue(shortVal))
            Type.TISSUE_MODEL_TYPE -> retVal = TissueModelType.getStringFromValue(TissueModelType.fromValue(shortVal))
            Type.DIVE_GAS_STATUS -> retVal = DiveGasStatus.getStringFromValue(DiveGasStatus.fromValue(shortVal))
            Type.DIVE_ALERT -> retVal = DiveAlert.getStringFromValue(DiveAlert.fromValue(shortVal))
            Type.DIVE_ALARM_TYPE -> retVal = DiveAlarmType.getStringFromValue(DiveAlarmType.fromValue(shortVal))
            Type.DIVE_BACKLIGHT_MODE -> retVal = DiveBacklightMode.getStringFromValue(DiveBacklightMode.fromValue(shortVal))
            Type.SLEEP_LEVEL -> retVal = SleepLevel.getStringFromValue(SleepLevel.fromValue(shortVal))
            Type.SPO2_MEASUREMENT_TYPE -> retVal = Spo2MeasurementType.getStringFromValue(Spo2MeasurementType.fromValue(shortVal))
            Type.CCR_SETPOINT_SWITCH_MODE -> retVal = CcrSetpointSwitchMode.getStringFromValue(CcrSetpointSwitchMode.fromValue(shortVal))
            Type.DIVE_GAS_MODE -> retVal = DiveGasMode.getStringFromValue(DiveGasMode.fromValue(shortVal))
            Type.PROJECTILE_TYPE -> retVal = ProjectileType.getStringFromValue(ProjectileType.fromValue(shortVal))
            Type.FAVERO_PRODUCT -> retVal = FaveroProduct.getStringFromValue(enumVal.toInt())
            Type.SPLIT_TYPE -> retVal = SplitType.getStringFromValue(SplitType.fromValue(shortVal))
            Type.CLIMB_PRO_EVENT -> retVal = ClimbProEvent.getStringFromValue(ClimbProEvent.fromValue(shortVal))
            Type.GAS_CONSUMPTION_RATE_TYPE -> retVal = GasConsumptionRateType.getStringFromValue(GasConsumptionRateType.fromValue(shortVal))
            Type.TAP_SENSITIVITY -> retVal = TapSensitivity.getStringFromValue(TapSensitivity.fromValue(shortVal))
            Type.RADAR_THREAT_LEVEL_TYPE -> retVal = RadarThreatLevelType.getStringFromValue(RadarThreatLevelType.fromValue(shortVal))
            Type.SLEEP_DISRUPTION_SEVERITY -> retVal = SleepDisruptionSeverity.getStringFromValue(SleepDisruptionSeverity.fromValue(shortVal))
            Type.NAP_PERIOD_FEEDBACK -> retVal = NapPeriodFeedback.getStringFromValue(NapPeriodFeedback.fromValue(shortVal))
            Type.NAP_SOURCE -> retVal = NapSource.getStringFromValue(NapSource.fromValue(shortVal))
            Type.MAX_MET_SPEED_SOURCE -> retVal = MaxMetSpeedSource.getStringFromValue(MaxMetSpeedSource.fromValue(shortVal))
            Type.MAX_MET_HEART_RATE_SOURCE -> retVal = MaxMetHeartRateSource.getStringFromValue(MaxMetHeartRateSource.fromValue(shortVal))
            Type.HRV_STATUS -> retVal = HrvStatus.getStringFromValue(HrvStatus.fromValue(shortVal))
            Type.NO_FLY_TIME_MODE -> retVal = NoFlyTimeMode.getStringFromValue(NoFlyTimeMode.fromValue(shortVal))
            else -> {}
        }

        // If we fail to convert this to a named enum value, return the string representation
        // of the numerical value.
        if (retVal == "") {
            retVal = enumVal.toString()
        }

        return retVal
    }

    enum class Type {
        ENUM,
        SINT8,
        UINT8,
        SINT16,
        UINT16,
        SINT32,
        UINT32,
        STRING,
        FLOAT32,
        FLOAT64,
        UINT8Z,
        UINT16Z,
        UINT32Z,
        BYTE,
        SINT64,
        UINT64,
        UINT64Z,
        BOOL,
        FILE,
        MESG_NUM,
        CHECKSUM,
        FILE_FLAGS,
        MESG_COUNT,
        DATE_TIME,
        LOCAL_DATE_TIME,
        MESSAGE_INDEX,
        DEVICE_INDEX,
        GENDER,
        LANGUAGE,
        LANGUAGE_BITS_0,
        LANGUAGE_BITS_1,
        LANGUAGE_BITS_2,
        LANGUAGE_BITS_3,
        LANGUAGE_BITS_4,
        TIME_ZONE,
        DISPLAY_MEASURE,
        DISPLAY_HEART,
        DISPLAY_POWER,
        DISPLAY_POSITION,
        SWITCH,
        SPORT,
        SPORT_BITS_0,
        SPORT_BITS_1,
        SPORT_BITS_2,
        SPORT_BITS_3,
        SPORT_BITS_4,
        SPORT_BITS_5,
        SPORT_BITS_6,
        SUB_SPORT,
        SPORT_EVENT,
        ACTIVITY,
        INTENSITY,
        SESSION_TRIGGER,
        AUTOLAP_TRIGGER,
        LAP_TRIGGER,
        TIME_MODE,
        BACKLIGHT_MODE,
        DATE_MODE,
        BACKLIGHT_TIMEOUT,
        EVENT,
        EVENT_TYPE,
        TIMER_TRIGGER,
        FITNESS_EQUIPMENT_STATE,
        TONE,
        AUTOSCROLL,
        ACTIVITY_CLASS,
        HR_ZONE_CALC,
        PWR_ZONE_CALC,
        WKT_STEP_DURATION,
        WKT_STEP_TARGET,
        GOAL,
        GOAL_RECURRENCE,
        GOAL_SOURCE,
        SCHEDULE,
        COURSE_POINT,
        MANUFACTURER,
        GARMIN_PRODUCT,
        ANTPLUS_DEVICE_TYPE,
        ANT_NETWORK,
        WORKOUT_CAPABILITIES,
        BATTERY_STATUS,
        HR_TYPE,
        COURSE_CAPABILITIES,
        WEIGHT,
        WORKOUT_HR,
        WORKOUT_POWER,
        BP_STATUS,
        USER_LOCAL_ID,
        SWIM_STROKE,
        ACTIVITY_TYPE,
        ACTIVITY_SUBTYPE,
        ACTIVITY_LEVEL,
        SIDE,
        LEFT_RIGHT_BALANCE,
        LEFT_RIGHT_BALANCE_100,
        LENGTH_TYPE,
        DAY_OF_WEEK,
        CONNECTIVITY_CAPABILITIES,
        WEATHER_REPORT,
        WEATHER_STATUS,
        WEATHER_SEVERITY,
        WEATHER_SEVERE_TYPE,
        TIME_INTO_DAY,
        LOCALTIME_INTO_DAY,
        STROKE_TYPE,
        BODY_LOCATION,
        SEGMENT_LAP_STATUS,
        SEGMENT_LEADERBOARD_TYPE,
        SEGMENT_DELETE_STATUS,
        SEGMENT_SELECTION_TYPE,
        SOURCE_TYPE,
        LOCAL_DEVICE_TYPE,
        BLE_DEVICE_TYPE,
        ANT_CHANNEL_ID,
        DISPLAY_ORIENTATION,
        WORKOUT_EQUIPMENT,
        WATCHFACE_MODE,
        DIGITAL_WATCHFACE_LAYOUT,
        ANALOG_WATCHFACE_LAYOUT,
        RIDER_POSITION_TYPE,
        POWER_PHASE_TYPE,
        CAMERA_EVENT_TYPE,
        SENSOR_TYPE,
        BIKE_LIGHT_NETWORK_CONFIG_TYPE,
        COMM_TIMEOUT_TYPE,
        CAMERA_ORIENTATION_TYPE,
        ATTITUDE_STAGE,
        ATTITUDE_VALIDITY,
        AUTO_SYNC_FREQUENCY,
        EXD_LAYOUT,
        EXD_DISPLAY_TYPE,
        EXD_DATA_UNITS,
        EXD_QUALIFIERS,
        EXD_DESCRIPTORS,
        AUTO_ACTIVITY_DETECT,
        SUPPORTED_EXD_SCREEN_LAYOUTS,
        FIT_BASE_TYPE,
        TURN_TYPE,
        BIKE_LIGHT_BEAM_ANGLE_MODE,
        FIT_BASE_UNIT,
        SET_TYPE,
        MAX_MET_CATEGORY,
        EXERCISE_CATEGORY,
        BENCH_PRESS_EXERCISE_NAME,
        CALF_RAISE_EXERCISE_NAME,
        CARDIO_EXERCISE_NAME,
        CARRY_EXERCISE_NAME,
        CHOP_EXERCISE_NAME,
        CORE_EXERCISE_NAME,
        CRUNCH_EXERCISE_NAME,
        CURL_EXERCISE_NAME,
        DEADLIFT_EXERCISE_NAME,
        FLYE_EXERCISE_NAME,
        HIP_RAISE_EXERCISE_NAME,
        HIP_STABILITY_EXERCISE_NAME,
        HIP_SWING_EXERCISE_NAME,
        HYPEREXTENSION_EXERCISE_NAME,
        LATERAL_RAISE_EXERCISE_NAME,
        LEG_CURL_EXERCISE_NAME,
        LEG_RAISE_EXERCISE_NAME,
        LUNGE_EXERCISE_NAME,
        OLYMPIC_LIFT_EXERCISE_NAME,
        PLANK_EXERCISE_NAME,
        PLYO_EXERCISE_NAME,
        PULL_UP_EXERCISE_NAME,
        PUSH_UP_EXERCISE_NAME,
        ROW_EXERCISE_NAME,
        SHOULDER_PRESS_EXERCISE_NAME,
        SHOULDER_STABILITY_EXERCISE_NAME,
        SHRUG_EXERCISE_NAME,
        SIT_UP_EXERCISE_NAME,
        SQUAT_EXERCISE_NAME,
        TOTAL_BODY_EXERCISE_NAME,
        MOVE_EXERCISE_NAME,
        POSE_EXERCISE_NAME,
        TRICEPS_EXTENSION_EXERCISE_NAME,
        WARM_UP_EXERCISE_NAME,
        RUN_EXERCISE_NAME,
        BIKE_EXERCISE_NAME,
        BANDED_EXERCISES_EXERCISE_NAME,
        BATTLE_ROPE_EXERCISE_NAME,
        ELLIPTICAL_EXERCISE_NAME,
        FLOOR_CLIMB_EXERCISE_NAME,
        INDOOR_BIKE_EXERCISE_NAME,
        INDOOR_ROW_EXERCISE_NAME,
        LADDER_EXERCISE_NAME,
        SANDBAG_EXERCISE_NAME,
        SLED_EXERCISE_NAME,
        SLEDGE_HAMMER_EXERCISE_NAME,
        STAIR_STEPPER_EXERCISE_NAME,
        SUSPENSION_EXERCISE_NAME,
        TIRE_EXERCISE_NAME,
        BIKE_OUTDOOR_EXERCISE_NAME,
        RUN_INDOOR_EXERCISE_NAME,
        WATER_TYPE,
        TISSUE_MODEL_TYPE,
        DIVE_GAS_STATUS,
        DIVE_ALERT,
        DIVE_ALARM_TYPE,
        DIVE_BACKLIGHT_MODE,
        SLEEP_LEVEL,
        SPO2_MEASUREMENT_TYPE,
        CCR_SETPOINT_SWITCH_MODE,
        DIVE_GAS_MODE,
        PROJECTILE_TYPE,
        FAVERO_PRODUCT,
        SPLIT_TYPE,
        CLIMB_PRO_EVENT,
        GAS_CONSUMPTION_RATE_TYPE,
        TAP_SENSITIVITY,
        RADAR_THREAT_LEVEL_TYPE,
        SLEEP_DISRUPTION_SEVERITY,
        NAP_PERIOD_FEEDBACK,
        NAP_SOURCE,
        MAX_MET_SPEED_SOURCE,
        MAX_MET_HEART_RATE_SOURCE,
        HRV_STATUS,
        NO_FLY_TIME_MODE,
        NUM_TYPES;

        companion object {
            fun fromBaseType(baseType: Int): Type {
                return when (baseType) {
                    Fit.BASE_TYPE_SINT8 -> SINT8
                    Fit.BASE_TYPE_UINT8 -> UINT8
                    Fit.BASE_TYPE_SINT16 -> SINT16
                    Fit.BASE_TYPE_UINT16 -> UINT16
                    Fit.BASE_TYPE_SINT32 -> SINT32
                    Fit.BASE_TYPE_UINT32 -> UINT32
                    Fit.BASE_TYPE_STRING -> STRING
                    Fit.BASE_TYPE_FLOAT32 -> FLOAT32
                    Fit.BASE_TYPE_FLOAT64 -> FLOAT64
                    Fit.BASE_TYPE_UINT8Z -> UINT8Z
                    Fit.BASE_TYPE_UINT16Z -> UINT16Z
                    Fit.BASE_TYPE_UINT32Z -> UINT32Z
                    Fit.BASE_TYPE_UINT64 -> UINT64
                    Fit.BASE_TYPE_SINT64 -> SINT64
                    Fit.BASE_TYPE_UINT64Z -> UINT64Z
                    else -> ENUM
                }
            }
        }
    }
}
