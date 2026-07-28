/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BikeExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object BikeExerciseName {
    const val BIKE: Int = 0
    const val RIDE: Int = 1
    const val SPRINT: Int = 2
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BIKE to "BIKE",
        RIDE to "RIDE",
        SPRINT to "SPRINT"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
