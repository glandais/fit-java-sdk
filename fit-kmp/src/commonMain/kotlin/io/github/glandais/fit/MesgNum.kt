/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MesgNum.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object MesgNum {
    const val FILE_ID: Int = 0
    const val CAPABILITIES: Int = 1
    const val DEVICE_SETTINGS: Int = 2
    const val USER_PROFILE: Int = 3
    const val HRM_PROFILE: Int = 4
    const val SDM_PROFILE: Int = 5
    const val BIKE_PROFILE: Int = 6
    const val ZONES_TARGET: Int = 7
    const val HR_ZONE: Int = 8
    const val POWER_ZONE: Int = 9
    const val MET_ZONE: Int = 10
    const val SPORT: Int = 12
    const val TRAINING_SETTINGS: Int = 13
    const val GOAL: Int = 15
    const val SESSION: Int = 18
    const val LAP: Int = 19
    const val RECORD: Int = 20
    const val EVENT: Int = 21
    const val DEVICE_INFO: Int = 23
    const val WORKOUT: Int = 26
    const val WORKOUT_STEP: Int = 27
    const val SCHEDULE: Int = 28
    const val WEIGHT_SCALE: Int = 30
    const val COURSE: Int = 31
    const val COURSE_POINT: Int = 32
    const val TOTALS: Int = 33
    const val ACTIVITY: Int = 34
    const val SOFTWARE: Int = 35
    const val FILE_CAPABILITIES: Int = 37
    const val MESG_CAPABILITIES: Int = 38
    const val FIELD_CAPABILITIES: Int = 39
    const val FILE_CREATOR: Int = 49
    const val BLOOD_PRESSURE: Int = 51
    const val SPEED_ZONE: Int = 53
    const val MONITORING: Int = 55
    const val TRAINING_FILE: Int = 72
    const val HRV: Int = 78
    const val ANT_RX: Int = 80
    const val ANT_TX: Int = 81
    const val ANT_CHANNEL_ID: Int = 82
    const val LENGTH: Int = 101
    const val MONITORING_INFO: Int = 103
    const val PAD: Int = 105
    const val SLAVE_DEVICE: Int = 106
    const val CONNECTIVITY: Int = 127
    const val WEATHER_CONDITIONS: Int = 128
    const val WEATHER_ALERT: Int = 129
    const val CADENCE_ZONE: Int = 131
    const val HR: Int = 132
    const val SEGMENT_LAP: Int = 142
    const val MEMO_GLOB: Int = 145
    const val SEGMENT_ID: Int = 148
    const val SEGMENT_LEADERBOARD_ENTRY: Int = 149
    const val SEGMENT_POINT: Int = 150
    const val SEGMENT_FILE: Int = 151
    const val WORKOUT_SESSION: Int = 158
    const val WATCHFACE_SETTINGS: Int = 159
    const val GPS_METADATA: Int = 160
    const val CAMERA_EVENT: Int = 161
    const val TIMESTAMP_CORRELATION: Int = 162
    const val GYROSCOPE_DATA: Int = 164
    const val ACCELEROMETER_DATA: Int = 165
    const val THREE_D_SENSOR_CALIBRATION: Int = 167
    const val VIDEO_FRAME: Int = 169
    const val OBDII_DATA: Int = 174
    const val NMEA_SENTENCE: Int = 177
    const val AVIATION_ATTITUDE: Int = 178
    const val VIDEO: Int = 184
    const val VIDEO_TITLE: Int = 185
    const val VIDEO_DESCRIPTION: Int = 186
    const val VIDEO_CLIP: Int = 187
    const val OHR_SETTINGS: Int = 188
    const val EXD_SCREEN_CONFIGURATION: Int = 200
    const val EXD_DATA_FIELD_CONFIGURATION: Int = 201
    const val EXD_DATA_CONCEPT_CONFIGURATION: Int = 202
    const val FIELD_DESCRIPTION: Int = 206
    const val DEVELOPER_DATA_ID: Int = 207
    const val MAGNETOMETER_DATA: Int = 208
    const val BAROMETER_DATA: Int = 209
    const val ONE_D_SENSOR_CALIBRATION: Int = 210
    const val MONITORING_HR_DATA: Int = 211
    const val TIME_IN_ZONE: Int = 216
    const val SET: Int = 225
    const val STRESS_LEVEL: Int = 227
    const val MAX_MET_DATA: Int = 229
    const val DIVE_SETTINGS: Int = 258
    const val DIVE_GAS: Int = 259
    const val DIVE_ALARM: Int = 262
    const val EXERCISE_TITLE: Int = 264
    const val DIVE_SUMMARY: Int = 268
    const val SPO2_DATA: Int = 269
    const val SLEEP_LEVEL: Int = 275
    const val JUMP: Int = 285
    const val AAD_ACCEL_FEATURES: Int = 289
    const val BEAT_INTERVALS: Int = 290
    const val RESPIRATION_RATE: Int = 297
    const val HSA_ACCELEROMETER_DATA: Int = 302
    const val HSA_STEP_DATA: Int = 304
    const val HSA_SPO2_DATA: Int = 305
    const val HSA_STRESS_DATA: Int = 306
    const val HSA_RESPIRATION_DATA: Int = 307
    const val HSA_HEART_RATE_DATA: Int = 308
    const val SPLIT: Int = 312
    const val SPLIT_SUMMARY: Int = 313
    const val HSA_BODY_BATTERY_DATA: Int = 314
    const val HSA_EVENT: Int = 315
    const val CLIMB_PRO: Int = 317
    const val TANK_UPDATE: Int = 319
    const val TANK_SUMMARY: Int = 323
    const val SLEEP_ASSESSMENT: Int = 346
    const val HRV_STATUS_SUMMARY: Int = 370
    const val HRV_VALUE: Int = 371
    const val RAW_BBI: Int = 372
    const val DEVICE_AUX_BATTERY_INFO: Int = 375
    const val HSA_GYROSCOPE_DATA: Int = 376
    const val CHRONO_SHOT_SESSION: Int = 387
    const val CHRONO_SHOT_DATA: Int = 388
    const val HSA_CONFIGURATION_DATA: Int = 389
    const val DIVE_APNEA_ALARM: Int = 393
    const val SKIN_TEMP_OVERNIGHT: Int = 398
    const val HSA_WRIST_TEMPERATURE_DATA: Int = 409 // Message number for the HSA wrist temperature data message
    const val NAP_EVENT: Int = 412
    const val SLEEP_DISRUPTION_SEVERITY_PERIOD: Int = 470
    const val SLEEP_DISRUPTION_OVERNIGHT_SEVERITY: Int = 471
    const val MFG_RANGE_MIN: Int = 65280 // 0xFF00 - 0xFFFE reserved for manufacturer specific messages
    const val MFG_RANGE_MAX: Int = 65534 // 0xFF00 - 0xFFFE reserved for manufacturer specific messages
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        FILE_ID to "FILE_ID",
        CAPABILITIES to "CAPABILITIES",
        DEVICE_SETTINGS to "DEVICE_SETTINGS",
        USER_PROFILE to "USER_PROFILE",
        HRM_PROFILE to "HRM_PROFILE",
        SDM_PROFILE to "SDM_PROFILE",
        BIKE_PROFILE to "BIKE_PROFILE",
        ZONES_TARGET to "ZONES_TARGET",
        HR_ZONE to "HR_ZONE",
        POWER_ZONE to "POWER_ZONE",
        MET_ZONE to "MET_ZONE",
        SPORT to "SPORT",
        TRAINING_SETTINGS to "TRAINING_SETTINGS",
        GOAL to "GOAL",
        SESSION to "SESSION",
        LAP to "LAP",
        RECORD to "RECORD",
        EVENT to "EVENT",
        DEVICE_INFO to "DEVICE_INFO",
        WORKOUT to "WORKOUT",
        WORKOUT_STEP to "WORKOUT_STEP",
        SCHEDULE to "SCHEDULE",
        WEIGHT_SCALE to "WEIGHT_SCALE",
        COURSE to "COURSE",
        COURSE_POINT to "COURSE_POINT",
        TOTALS to "TOTALS",
        ACTIVITY to "ACTIVITY",
        SOFTWARE to "SOFTWARE",
        FILE_CAPABILITIES to "FILE_CAPABILITIES",
        MESG_CAPABILITIES to "MESG_CAPABILITIES",
        FIELD_CAPABILITIES to "FIELD_CAPABILITIES",
        FILE_CREATOR to "FILE_CREATOR",
        BLOOD_PRESSURE to "BLOOD_PRESSURE",
        SPEED_ZONE to "SPEED_ZONE",
        MONITORING to "MONITORING",
        TRAINING_FILE to "TRAINING_FILE",
        HRV to "HRV",
        ANT_RX to "ANT_RX",
        ANT_TX to "ANT_TX",
        ANT_CHANNEL_ID to "ANT_CHANNEL_ID",
        LENGTH to "LENGTH",
        MONITORING_INFO to "MONITORING_INFO",
        PAD to "PAD",
        SLAVE_DEVICE to "SLAVE_DEVICE",
        CONNECTIVITY to "CONNECTIVITY",
        WEATHER_CONDITIONS to "WEATHER_CONDITIONS",
        WEATHER_ALERT to "WEATHER_ALERT",
        CADENCE_ZONE to "CADENCE_ZONE",
        HR to "HR",
        SEGMENT_LAP to "SEGMENT_LAP",
        MEMO_GLOB to "MEMO_GLOB",
        SEGMENT_ID to "SEGMENT_ID",
        SEGMENT_LEADERBOARD_ENTRY to "SEGMENT_LEADERBOARD_ENTRY",
        SEGMENT_POINT to "SEGMENT_POINT",
        SEGMENT_FILE to "SEGMENT_FILE",
        WORKOUT_SESSION to "WORKOUT_SESSION",
        WATCHFACE_SETTINGS to "WATCHFACE_SETTINGS",
        GPS_METADATA to "GPS_METADATA",
        CAMERA_EVENT to "CAMERA_EVENT",
        TIMESTAMP_CORRELATION to "TIMESTAMP_CORRELATION",
        GYROSCOPE_DATA to "GYROSCOPE_DATA",
        ACCELEROMETER_DATA to "ACCELEROMETER_DATA",
        THREE_D_SENSOR_CALIBRATION to "THREE_D_SENSOR_CALIBRATION",
        VIDEO_FRAME to "VIDEO_FRAME",
        OBDII_DATA to "OBDII_DATA",
        NMEA_SENTENCE to "NMEA_SENTENCE",
        AVIATION_ATTITUDE to "AVIATION_ATTITUDE",
        VIDEO to "VIDEO",
        VIDEO_TITLE to "VIDEO_TITLE",
        VIDEO_DESCRIPTION to "VIDEO_DESCRIPTION",
        VIDEO_CLIP to "VIDEO_CLIP",
        OHR_SETTINGS to "OHR_SETTINGS",
        EXD_SCREEN_CONFIGURATION to "EXD_SCREEN_CONFIGURATION",
        EXD_DATA_FIELD_CONFIGURATION to "EXD_DATA_FIELD_CONFIGURATION",
        EXD_DATA_CONCEPT_CONFIGURATION to "EXD_DATA_CONCEPT_CONFIGURATION",
        FIELD_DESCRIPTION to "FIELD_DESCRIPTION",
        DEVELOPER_DATA_ID to "DEVELOPER_DATA_ID",
        MAGNETOMETER_DATA to "MAGNETOMETER_DATA",
        BAROMETER_DATA to "BAROMETER_DATA",
        ONE_D_SENSOR_CALIBRATION to "ONE_D_SENSOR_CALIBRATION",
        MONITORING_HR_DATA to "MONITORING_HR_DATA",
        TIME_IN_ZONE to "TIME_IN_ZONE",
        SET to "SET",
        STRESS_LEVEL to "STRESS_LEVEL",
        MAX_MET_DATA to "MAX_MET_DATA",
        DIVE_SETTINGS to "DIVE_SETTINGS",
        DIVE_GAS to "DIVE_GAS",
        DIVE_ALARM to "DIVE_ALARM",
        EXERCISE_TITLE to "EXERCISE_TITLE",
        DIVE_SUMMARY to "DIVE_SUMMARY",
        SPO2_DATA to "SPO2_DATA",
        SLEEP_LEVEL to "SLEEP_LEVEL",
        JUMP to "JUMP",
        AAD_ACCEL_FEATURES to "AAD_ACCEL_FEATURES",
        BEAT_INTERVALS to "BEAT_INTERVALS",
        RESPIRATION_RATE to "RESPIRATION_RATE",
        HSA_ACCELEROMETER_DATA to "HSA_ACCELEROMETER_DATA",
        HSA_STEP_DATA to "HSA_STEP_DATA",
        HSA_SPO2_DATA to "HSA_SPO2_DATA",
        HSA_STRESS_DATA to "HSA_STRESS_DATA",
        HSA_RESPIRATION_DATA to "HSA_RESPIRATION_DATA",
        HSA_HEART_RATE_DATA to "HSA_HEART_RATE_DATA",
        SPLIT to "SPLIT",
        SPLIT_SUMMARY to "SPLIT_SUMMARY",
        HSA_BODY_BATTERY_DATA to "HSA_BODY_BATTERY_DATA",
        HSA_EVENT to "HSA_EVENT",
        CLIMB_PRO to "CLIMB_PRO",
        TANK_UPDATE to "TANK_UPDATE",
        TANK_SUMMARY to "TANK_SUMMARY",
        SLEEP_ASSESSMENT to "SLEEP_ASSESSMENT",
        HRV_STATUS_SUMMARY to "HRV_STATUS_SUMMARY",
        HRV_VALUE to "HRV_VALUE",
        RAW_BBI to "RAW_BBI",
        DEVICE_AUX_BATTERY_INFO to "DEVICE_AUX_BATTERY_INFO",
        HSA_GYROSCOPE_DATA to "HSA_GYROSCOPE_DATA",
        CHRONO_SHOT_SESSION to "CHRONO_SHOT_SESSION",
        CHRONO_SHOT_DATA to "CHRONO_SHOT_DATA",
        HSA_CONFIGURATION_DATA to "HSA_CONFIGURATION_DATA",
        DIVE_APNEA_ALARM to "DIVE_APNEA_ALARM",
        SKIN_TEMP_OVERNIGHT to "SKIN_TEMP_OVERNIGHT",
        HSA_WRIST_TEMPERATURE_DATA to "HSA_WRIST_TEMPERATURE_DATA",
        NAP_EVENT to "NAP_EVENT",
        SLEEP_DISRUPTION_SEVERITY_PERIOD to "SLEEP_DISRUPTION_SEVERITY_PERIOD",
        SLEEP_DISRUPTION_OVERNIGHT_SEVERITY to "SLEEP_DISRUPTION_OVERNIGHT_SEVERITY",
        MFG_RANGE_MIN to "MFG_RANGE_MIN",
        MFG_RANGE_MAX to "MFG_RANGE_MAX"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
