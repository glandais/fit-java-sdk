/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FitBaseUnit.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object FitBaseUnit {
    const val OTHER: Int = 0
    const val KILOGRAM: Int = 1
    const val POUND: Int = 2
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        OTHER to "OTHER",
        KILOGRAM to "KILOGRAM",
        POUND to "POUND"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
