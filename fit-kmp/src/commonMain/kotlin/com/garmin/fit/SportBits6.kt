/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportBits6.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object SportBits6 {
    const val FLOOR_CLIMBING: Short = 1
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        FLOOR_CLIMBING to "FLOOR_CLIMBING"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
