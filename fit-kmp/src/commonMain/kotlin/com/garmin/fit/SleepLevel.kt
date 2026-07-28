/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SleepLevel.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class SleepLevel(rawValue: Int) {
    UNMEASURABLE(0),
    AWAKE(1),
    LIGHT(2),
    DEEP(3),
    REM(4),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SleepLevel {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SleepLevel): String = value.name
    }
}
