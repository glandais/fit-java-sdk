/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DateMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class DateMode(rawValue: Int) {
    DAY_MONTH(0),
    MONTH_DAY(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DateMode {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DateMode): String = value.name
    }
}
