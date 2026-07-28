/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LanguageBits0.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object LanguageBits0 {
    const val ENGLISH: Short = 1
    const val FRENCH: Short = 2
    const val ITALIAN: Short = 4
    const val GERMAN: Short = 8
    const val SPANISH: Short = 16
    const val CROATIAN: Short = 32
    const val CZECH: Short = 64
    const val DANISH: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        ENGLISH to "ENGLISH",
        FRENCH to "FRENCH",
        ITALIAN to "ITALIAN",
        GERMAN to "GERMAN",
        SPANISH to "SPANISH",
        CROATIAN to "CROATIAN",
        CZECH to "CZECH",
        DANISH to "DANISH"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
