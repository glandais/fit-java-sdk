/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BacklightTimeout.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object BacklightTimeout {
    const val INFINITE: Short = 0 // Backlight stays on forever.
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        INFINITE to "INFINITE"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
