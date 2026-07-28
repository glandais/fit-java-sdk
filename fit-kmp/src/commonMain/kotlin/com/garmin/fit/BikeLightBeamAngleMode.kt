/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BikeLightBeamAngleMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object BikeLightBeamAngleMode {
    const val MANUAL: Short = 0
    const val AUTO: Short = 1
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        MANUAL to "MANUAL",
        AUTO to "AUTO"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
