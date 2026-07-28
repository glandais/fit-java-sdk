/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LeftRightBalance100.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object LeftRightBalance100 {
    const val MASK: Int = 16383 // % contribution scaled by 100
    const val RIGHT: Int = 32768 // data corresponds to right if set, otherwise unknown
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        MASK to "MASK",
        RIGHT to "RIGHT"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
