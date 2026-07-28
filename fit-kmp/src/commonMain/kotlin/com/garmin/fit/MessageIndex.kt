/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MessageIndex.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object MessageIndex {
    const val SELECTED: Int = 32768 // message is selected if set
    const val RESERVED: Int = 28672 // reserved (default 0)
    const val MASK: Int = 4095 // index
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        SELECTED to "SELECTED",
        RESERVED to "RESERVED",
        MASK to "MASK"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
