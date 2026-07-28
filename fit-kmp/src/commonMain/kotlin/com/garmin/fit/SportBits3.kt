/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportBits3.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object SportBits3 {
    const val DRIVING: Short = 1
    const val GOLF: Short = 2
    const val HANG_GLIDING: Short = 4
    const val HORSEBACK_RIDING: Short = 8
    const val HUNTING: Short = 16
    const val FISHING: Short = 32
    const val INLINE_SKATING: Short = 64
    const val ROCK_CLIMBING: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        DRIVING to "DRIVING",
        GOLF to "GOLF",
        HANG_GLIDING to "HANG_GLIDING",
        HORSEBACK_RIDING to "HORSEBACK_RIDING",
        HUNTING to "HUNTING",
        FISHING to "FISHING",
        INLINE_SKATING to "INLINE_SKATING",
        ROCK_CLIMBING to "ROCK_CLIMBING"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
