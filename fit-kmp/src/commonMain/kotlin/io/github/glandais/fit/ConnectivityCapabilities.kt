/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ConnectivityCapabilities.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object ConnectivityCapabilities {
    const val BLUETOOTH: Long = 1L
    const val BLUETOOTH_LE: Long = 2L
    const val ANT: Long = 4L
    const val ACTIVITY_UPLOAD: Long = 8L
    const val COURSE_DOWNLOAD: Long = 16L
    const val WORKOUT_DOWNLOAD: Long = 32L
    const val LIVE_TRACK: Long = 64L
    const val WEATHER_CONDITIONS: Long = 128L
    const val WEATHER_ALERTS: Long = 256L
    const val GPS_EPHEMERIS_DOWNLOAD: Long = 512L
    const val EXPLICIT_ARCHIVE: Long = 1024L
    const val SETUP_INCOMPLETE: Long = 2048L
    const val CONTINUE_SYNC_AFTER_SOFTWARE_UPDATE: Long = 4096L
    const val CONNECT_IQ_APP_DOWNLOAD: Long = 8192L
    const val GOLF_COURSE_DOWNLOAD: Long = 16384L
    const val DEVICE_INITIATES_SYNC: Long = 32768L // Indicates device is in control of initiating all syncs
    const val CONNECT_IQ_WATCH_APP_DOWNLOAD: Long = 65536L
    const val CONNECT_IQ_WIDGET_DOWNLOAD: Long = 131072L
    const val CONNECT_IQ_WATCH_FACE_DOWNLOAD: Long = 262144L
    const val CONNECT_IQ_DATA_FIELD_DOWNLOAD: Long = 524288L
    const val CONNECT_IQ_APP_MANAGMENT: Long = 1048576L // Device supports delete and reorder of apps via GCM
    const val SWING_SENSOR: Long = 2097152L
    const val SWING_SENSOR_REMOTE: Long = 4194304L
    const val INCIDENT_DETECTION: Long = 8388608L // Device supports incident detection
    const val AUDIO_PROMPTS: Long = 16777216L
    const val WIFI_VERIFICATION: Long = 33554432L // Device supports reporting wifi verification via GCM
    const val TRUE_UP: Long = 67108864L // Device supports True Up
    const val FIND_MY_WATCH: Long = 134217728L // Device supports Find My Watch
    const val REMOTE_MANUAL_SYNC: Long = 268435456L
    const val LIVE_TRACK_AUTO_START: Long = 536870912L // Device supports LiveTrack auto start
    const val LIVE_TRACK_MESSAGING: Long = 1073741824L // Device supports LiveTrack Messaging
    const val INSTANT_INPUT: Long = -2147483648L // Device supports instant input feature
    val INVALID: Long = Fit.UINT32Z_INVALID

    private val stringMap: Map<Long, String> = mapOf(
        BLUETOOTH to "BLUETOOTH",
        BLUETOOTH_LE to "BLUETOOTH_LE",
        ANT to "ANT",
        ACTIVITY_UPLOAD to "ACTIVITY_UPLOAD",
        COURSE_DOWNLOAD to "COURSE_DOWNLOAD",
        WORKOUT_DOWNLOAD to "WORKOUT_DOWNLOAD",
        LIVE_TRACK to "LIVE_TRACK",
        WEATHER_CONDITIONS to "WEATHER_CONDITIONS",
        WEATHER_ALERTS to "WEATHER_ALERTS",
        GPS_EPHEMERIS_DOWNLOAD to "GPS_EPHEMERIS_DOWNLOAD",
        EXPLICIT_ARCHIVE to "EXPLICIT_ARCHIVE",
        SETUP_INCOMPLETE to "SETUP_INCOMPLETE",
        CONTINUE_SYNC_AFTER_SOFTWARE_UPDATE to "CONTINUE_SYNC_AFTER_SOFTWARE_UPDATE",
        CONNECT_IQ_APP_DOWNLOAD to "CONNECT_IQ_APP_DOWNLOAD",
        GOLF_COURSE_DOWNLOAD to "GOLF_COURSE_DOWNLOAD",
        DEVICE_INITIATES_SYNC to "DEVICE_INITIATES_SYNC",
        CONNECT_IQ_WATCH_APP_DOWNLOAD to "CONNECT_IQ_WATCH_APP_DOWNLOAD",
        CONNECT_IQ_WIDGET_DOWNLOAD to "CONNECT_IQ_WIDGET_DOWNLOAD",
        CONNECT_IQ_WATCH_FACE_DOWNLOAD to "CONNECT_IQ_WATCH_FACE_DOWNLOAD",
        CONNECT_IQ_DATA_FIELD_DOWNLOAD to "CONNECT_IQ_DATA_FIELD_DOWNLOAD",
        CONNECT_IQ_APP_MANAGMENT to "CONNECT_IQ_APP_MANAGMENT",
        SWING_SENSOR to "SWING_SENSOR",
        SWING_SENSOR_REMOTE to "SWING_SENSOR_REMOTE",
        INCIDENT_DETECTION to "INCIDENT_DETECTION",
        AUDIO_PROMPTS to "AUDIO_PROMPTS",
        WIFI_VERIFICATION to "WIFI_VERIFICATION",
        TRUE_UP to "TRUE_UP",
        FIND_MY_WATCH to "FIND_MY_WATCH",
        REMOTE_MANUAL_SYNC to "REMOTE_MANUAL_SYNC",
        LIVE_TRACK_AUTO_START to "LIVE_TRACK_AUTO_START",
        LIVE_TRACK_MESSAGING to "LIVE_TRACK_MESSAGING",
        INSTANT_INPUT to "INSTANT_INPUT"
    )

    fun getStringFromValue(value: Long?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Long {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
