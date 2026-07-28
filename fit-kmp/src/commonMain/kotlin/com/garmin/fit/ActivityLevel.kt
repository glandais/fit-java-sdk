/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ActivityLevel.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class ActivityLevel(rawValue: Int) {
    LOW(0),
    MEDIUM(1),
    HIGH(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): ActivityLevel {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: ActivityLevel): String = value.name
    }
}
