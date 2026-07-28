/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ActivityType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class ActivityType(rawValue: Int) {
    GENERIC(0),
    RUNNING(1),
    CYCLING(2),
    TRANSITION(3),
    FITNESS_EQUIPMENT(4),
    SWIMMING(5),
    WALKING(6),
    SEDENTARY(8),
    ALL(254),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): ActivityType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: ActivityType): String = value.name
    }
}
