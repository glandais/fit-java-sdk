/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WorkoutPower.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object WorkoutPower {
    const val WATTS_OFFSET: Long = 1000L
    val INVALID: Long = Fit.UINT32_INVALID

    private val stringMap: Map<Long, String> = mapOf(
        WATTS_OFFSET to "WATTS_OFFSET"
    )

    fun getStringFromValue(value: Long?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Long {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
