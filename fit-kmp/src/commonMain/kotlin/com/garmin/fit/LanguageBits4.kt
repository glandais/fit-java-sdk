/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LanguageBits4.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object LanguageBits4 {
    const val BRAZILIAN_PORTUGUESE: Short = 1
    const val INDONESIAN: Short = 2
    const val MALAYSIAN: Short = 4
    const val VIETNAMESE: Short = 8
    const val BURMESE: Short = 16
    const val MONGOLIAN: Short = 32
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        BRAZILIAN_PORTUGUESE to "BRAZILIAN_PORTUGUESE",
        INDONESIAN to "INDONESIAN",
        MALAYSIAN to "MALAYSIAN",
        VIETNAMESE to "VIETNAMESE",
        BURMESE to "BURMESE",
        MONGOLIAN to "MONGOLIAN"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
