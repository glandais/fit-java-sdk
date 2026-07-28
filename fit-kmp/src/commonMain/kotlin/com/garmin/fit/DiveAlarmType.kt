/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DiveAlarmType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class DiveAlarmType(rawValue: Int) {
    DEPTH(0),
    TIME(1),
    SPEED(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DiveAlarmType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DiveAlarmType): String = value.name
    }
}
