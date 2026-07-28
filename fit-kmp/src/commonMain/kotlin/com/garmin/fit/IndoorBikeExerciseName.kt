/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from IndoorBikeExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object IndoorBikeExerciseName {
    const val AIR_BIKE: Int = 0
    const val ASSAULT_BIKE: Int = 1
    const val STATIONARY_BIKE: Int = 3
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        AIR_BIKE to "AIR_BIKE",
        ASSAULT_BIKE to "ASSAULT_BIKE",
        STATIONARY_BIKE to "STATIONARY_BIKE"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
