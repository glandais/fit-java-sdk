/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TapSensitivity.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class TapSensitivity(rawValue: Int) {
    HIGH(0),
    MEDIUM(1),
    LOW(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): TapSensitivity {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: TapSensitivity): String = value.name
    }
}
