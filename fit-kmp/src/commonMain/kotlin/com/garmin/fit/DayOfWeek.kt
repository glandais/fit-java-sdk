/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DayOfWeek.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class DayOfWeek(rawValue: Int) {
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DayOfWeek {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DayOfWeek): String = value.name
    }
}
