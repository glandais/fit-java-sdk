/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Goal.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class Goal(rawValue: Int) {
    TIME(0),
    DISTANCE(1),
    CALORIES(2),
    FREQUENCY(3),
    STEPS(4),
    ASCENT(5),
    ACTIVE_MINUTES(6),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Goal {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Goal): String = value.name
    }
}
