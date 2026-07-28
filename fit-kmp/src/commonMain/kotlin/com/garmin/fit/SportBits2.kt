/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportBits2.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object SportBits2 {
    const val MOUNTAINEERING: Short = 1
    const val HIKING: Short = 2
    const val MULTISPORT: Short = 4
    const val PADDLING: Short = 8
    const val FLYING: Short = 16
    const val E_BIKING: Short = 32
    const val MOTORCYCLING: Short = 64
    const val BOATING: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        MOUNTAINEERING to "MOUNTAINEERING",
        HIKING to "HIKING",
        MULTISPORT to "MULTISPORT",
        PADDLING to "PADDLING",
        FLYING to "FLYING",
        E_BIKING to "E_BIKING",
        MOTORCYCLING to "MOTORCYCLING",
        BOATING to "BOATING"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
