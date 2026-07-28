/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from UserLocalId.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object UserLocalId {
    const val LOCAL_MIN: Int = 0
    const val LOCAL_MAX: Int = 15
    const val STATIONARY_MIN: Int = 16
    const val STATIONARY_MAX: Int = 255
    const val PORTABLE_MIN: Int = 256
    const val PORTABLE_MAX: Int = 65534
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        LOCAL_MIN to "LOCAL_MIN",
        LOCAL_MAX to "LOCAL_MAX",
        STATIONARY_MIN to "STATIONARY_MIN",
        STATIONARY_MAX to "STATIONARY_MAX",
        PORTABLE_MIN to "PORTABLE_MIN",
        PORTABLE_MAX to "PORTABLE_MAX"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
