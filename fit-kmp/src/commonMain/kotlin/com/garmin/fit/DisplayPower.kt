/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DisplayPower.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class DisplayPower(rawValue: Int) {
    WATTS(0),
    PERCENT_FTP(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DisplayPower {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DisplayPower): String = value.name
    }
}
