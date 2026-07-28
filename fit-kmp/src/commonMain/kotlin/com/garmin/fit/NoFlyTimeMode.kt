/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from NoFlyTimeMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class NoFlyTimeMode(rawValue: Int) {
    STANDARD(0),
    FLAT_24_HOURS(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): NoFlyTimeMode {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: NoFlyTimeMode): String = value.name
    }
}
