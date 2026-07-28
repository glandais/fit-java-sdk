/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LanguageBits1.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object LanguageBits1 {
    const val DUTCH: Short = 1
    const val FINNISH: Short = 2
    const val GREEK: Short = 4
    const val HUNGARIAN: Short = 8
    const val NORWEGIAN: Short = 16
    const val POLISH: Short = 32
    const val PORTUGUESE: Short = 64
    const val SLOVAKIAN: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        DUTCH to "DUTCH",
        FINNISH to "FINNISH",
        GREEK to "GREEK",
        HUNGARIAN to "HUNGARIAN",
        NORWEGIAN to "NORWEGIAN",
        POLISH to "POLISH",
        PORTUGUESE to "PORTUGUESE",
        SLOVAKIAN to "SLOVAKIAN"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
