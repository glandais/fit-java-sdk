/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WorkoutHr.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object WorkoutHr {
    const val BPM_OFFSET: Long = 100L
    val INVALID: Long = Fit.UINT32_INVALID

    private val stringMap: Map<Long, String> = mapOf(
        BPM_OFFSET to "BPM_OFFSET"
    )

    fun getStringFromValue(value: Long?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Long {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
