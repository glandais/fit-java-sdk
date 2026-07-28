/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportBits1.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object SportBits1 {
    const val TENNIS: Short = 1
    const val AMERICAN_FOOTBALL: Short = 2
    const val TRAINING: Short = 4
    const val WALKING: Short = 8
    const val CROSS_COUNTRY_SKIING: Short = 16
    const val ALPINE_SKIING: Short = 32
    const val SNOWBOARDING: Short = 64
    const val ROWING: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        TENNIS to "TENNIS",
        AMERICAN_FOOTBALL to "AMERICAN_FOOTBALL",
        TRAINING to "TRAINING",
        WALKING to "WALKING",
        CROSS_COUNTRY_SKIING to "CROSS_COUNTRY_SKIING",
        ALPINE_SKIING to "ALPINE_SKIING",
        SNOWBOARDING to "SNOWBOARDING",
        ROWING to "ROWING"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
