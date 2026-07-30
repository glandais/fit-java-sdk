/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LanguageBits3.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object LanguageBits3 {
    const val BULGARIAN: Short = 1
    const val ROMANIAN: Short = 2
    const val CHINESE: Short = 4
    const val JAPANESE: Short = 8
    const val KOREAN: Short = 16
    const val TAIWANESE: Short = 32
    const val THAI: Short = 64
    const val HEBREW: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        BULGARIAN to "BULGARIAN",
        ROMANIAN to "ROMANIAN",
        CHINESE to "CHINESE",
        JAPANESE to "JAPANESE",
        KOREAN to "KOREAN",
        TAIWANESE to "TAIWANESE",
        THAI to "THAI",
        HEBREW to "HEBREW"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
