/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportBits5.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object SportBits5 {
    const val WATER_SKIING: Short = 1
    const val KAYAKING: Short = 2
    const val RAFTING: Short = 4
    const val WINDSURFING: Short = 8
    const val KITESURFING: Short = 16
    const val TACTICAL: Short = 32
    const val JUMPMASTER: Short = 64
    const val BOXING: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        WATER_SKIING to "WATER_SKIING",
        KAYAKING to "KAYAKING",
        RAFTING to "RAFTING",
        WINDSURFING to "WINDSURFING",
        KITESURFING to "KITESURFING",
        TACTICAL to "TACTICAL",
        JUMPMASTER to "JUMPMASTER",
        BOXING to "BOXING"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
