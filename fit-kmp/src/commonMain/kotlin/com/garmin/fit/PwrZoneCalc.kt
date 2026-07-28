/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from PwrZoneCalc.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class PwrZoneCalc(rawValue: Int) {
    CUSTOM(0),
    PERCENT_FTP(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): PwrZoneCalc {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: PwrZoneCalc): String = value.name
    }
}
