/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from RiderPositionType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class RiderPositionType(rawValue: Int) {
    SEATED(0),
    STANDING(1),
    TRANSITION_TO_SEATED(2),
    TRANSITION_TO_STANDING(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): RiderPositionType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: RiderPositionType): String = value.name
    }
}
