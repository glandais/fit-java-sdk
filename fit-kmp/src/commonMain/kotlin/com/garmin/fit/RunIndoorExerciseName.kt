/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from RunIndoorExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object RunIndoorExerciseName {
    const val INDOOR_TRACK_RUN: Int = 0
    const val TREADMILL: Int = 1
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        INDOOR_TRACK_RUN to "INDOOR_TRACK_RUN",
        TREADMILL to "TREADMILL"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
