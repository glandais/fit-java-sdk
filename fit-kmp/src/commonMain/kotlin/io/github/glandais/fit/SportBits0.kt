/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportBits0.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object SportBits0 {
    const val GENERIC: Short = 1
    const val RUNNING: Short = 2
    const val CYCLING: Short = 4
    const val TRANSITION: Short = 8 // Mulitsport transition
    const val FITNESS_EQUIPMENT: Short = 16
    const val SWIMMING: Short = 32
    const val BASKETBALL: Short = 64
    const val SOCCER: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        GENERIC to "GENERIC",
        RUNNING to "RUNNING",
        CYCLING to "CYCLING",
        TRANSITION to "TRANSITION",
        FITNESS_EQUIPMENT to "FITNESS_EQUIPMENT",
        SWIMMING to "SWIMMING",
        BASKETBALL to "BASKETBALL",
        SOCCER to "SOCCER"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
