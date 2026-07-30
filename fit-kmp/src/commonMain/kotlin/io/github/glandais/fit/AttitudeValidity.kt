/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AttitudeValidity.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object AttitudeValidity {
    const val TRACK_ANGLE_HEADING_VALID: Int = 1
    const val PITCH_VALID: Int = 2
    const val ROLL_VALID: Int = 4
    const val LATERAL_BODY_ACCEL_VALID: Int = 8
    const val NORMAL_BODY_ACCEL_VALID: Int = 16
    const val TURN_RATE_VALID: Int = 32
    const val HW_FAIL: Int = 64
    const val MAG_INVALID: Int = 128
    const val NO_GPS: Int = 256
    const val GPS_INVALID: Int = 512
    const val SOLUTION_COASTING: Int = 1024
    const val TRUE_TRACK_ANGLE: Int = 2048
    const val MAGNETIC_HEADING: Int = 4096
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        TRACK_ANGLE_HEADING_VALID to "TRACK_ANGLE_HEADING_VALID",
        PITCH_VALID to "PITCH_VALID",
        ROLL_VALID to "ROLL_VALID",
        LATERAL_BODY_ACCEL_VALID to "LATERAL_BODY_ACCEL_VALID",
        NORMAL_BODY_ACCEL_VALID to "NORMAL_BODY_ACCEL_VALID",
        TURN_RATE_VALID to "TURN_RATE_VALID",
        HW_FAIL to "HW_FAIL",
        MAG_INVALID to "MAG_INVALID",
        NO_GPS to "NO_GPS",
        GPS_INVALID to "GPS_INVALID",
        SOLUTION_COASTING to "SOLUTION_COASTING",
        TRUE_TRACK_ANGLE to "TRUE_TRACK_ANGLE",
        MAGNETIC_HEADING to "MAGNETIC_HEADING"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
