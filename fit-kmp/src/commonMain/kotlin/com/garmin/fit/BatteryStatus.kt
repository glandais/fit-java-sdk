/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BatteryStatus.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object BatteryStatus {
    const val NEW: Short = 1
    const val GOOD: Short = 2
    const val OK: Short = 3
    const val LOW: Short = 4
    const val CRITICAL: Short = 5
    const val CHARGING: Short = 6
    const val UNKNOWN: Short = 7
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        NEW to "NEW",
        GOOD to "GOOD",
        OK to "OK",
        LOW to "LOW",
        CRITICAL to "CRITICAL",
        CHARGING to "CHARGING",
        UNKNOWN to "UNKNOWN"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
