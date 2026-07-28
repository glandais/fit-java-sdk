/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DisplayHeart.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class DisplayHeart(rawValue: Int) {
    BPM(0),
    MAX(1),
    RESERVE(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DisplayHeart {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DisplayHeart): String = value.name
    }
}
