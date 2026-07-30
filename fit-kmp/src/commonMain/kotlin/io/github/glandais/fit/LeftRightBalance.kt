/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LeftRightBalance.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object LeftRightBalance {
    const val MASK: Short = 127 // % contribution
    const val RIGHT: Short = 128 // data corresponds to right if set, otherwise unknown
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        MASK to "MASK",
        RIGHT to "RIGHT"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
