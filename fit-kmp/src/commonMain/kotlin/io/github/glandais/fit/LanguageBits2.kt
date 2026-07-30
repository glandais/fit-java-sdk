/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LanguageBits2.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object LanguageBits2 {
    const val SLOVENIAN: Short = 1
    const val SWEDISH: Short = 2
    const val RUSSIAN: Short = 4
    const val TURKISH: Short = 8
    const val LATVIAN: Short = 16
    const val UKRAINIAN: Short = 32
    const val ARABIC: Short = 64
    const val FARSI: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        SLOVENIAN to "SLOVENIAN",
        SWEDISH to "SWEDISH",
        RUSSIAN to "RUSSIAN",
        TURKISH to "TURKISH",
        LATVIAN to "LATVIAN",
        UKRAINIAN to "UKRAINIAN",
        ARABIC to "ARABIC",
        FARSI to "FARSI"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
