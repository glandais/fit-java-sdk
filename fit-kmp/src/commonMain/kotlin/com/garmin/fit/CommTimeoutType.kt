/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CommTimeoutType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object CommTimeoutType {
    const val WILDCARD_PAIRING_TIMEOUT: Int = 0 // Timeout pairing to any device
    const val PAIRING_TIMEOUT: Int = 1 // Timeout pairing to previously paired device
    const val CONNECTION_LOST: Int = 2 // Temporary loss of communications
    const val CONNECTION_TIMEOUT: Int = 3 // Connection closed due to extended bad communications
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        WILDCARD_PAIRING_TIMEOUT to "WILDCARD_PAIRING_TIMEOUT",
        PAIRING_TIMEOUT to "PAIRING_TIMEOUT",
        CONNECTION_LOST to "CONNECTION_LOST",
        CONNECTION_TIMEOUT to "CONNECTION_TIMEOUT"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
