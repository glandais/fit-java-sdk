/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SleepDisruptionSeverity.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class SleepDisruptionSeverity(rawValue: Int) {
    NONE(0),
    LOW(1),
    MEDIUM(2),
    HIGH(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SleepDisruptionSeverity {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SleepDisruptionSeverity): String = value.name
    }
}
