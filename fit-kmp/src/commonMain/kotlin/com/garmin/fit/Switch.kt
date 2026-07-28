/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Switch.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class Switch(rawValue: Int) {
    OFF(0),
    ON(1),
    AUTO(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Switch {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Switch): String = value.name
    }
}
