/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportBits4.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object SportBits4 {
    const val SAILING: Short = 1
    const val ICE_SKATING: Short = 2
    const val SKY_DIVING: Short = 4
    const val SNOWSHOEING: Short = 8
    const val SNOWMOBILING: Short = 16
    const val STAND_UP_PADDLEBOARDING: Short = 32
    const val SURFING: Short = 64
    const val WAKEBOARDING: Short = 128
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        SAILING to "SAILING",
        ICE_SKATING to "ICE_SKATING",
        SKY_DIVING to "SKY_DIVING",
        SNOWSHOEING to "SNOWSHOEING",
        SNOWMOBILING to "SNOWMOBILING",
        STAND_UP_PADDLEBOARDING to "STAND_UP_PADDLEBOARDING",
        SURFING to "SURFING",
        WAKEBOARDING to "WAKEBOARDING"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
