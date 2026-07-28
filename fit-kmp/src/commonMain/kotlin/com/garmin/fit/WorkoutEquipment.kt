/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WorkoutEquipment.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class WorkoutEquipment(rawValue: Int) {
    NONE(0),
    SWIM_FINS(1),
    SWIM_KICKBOARD(2),
    SWIM_PADDLES(3),
    SWIM_PULL_BUOY(4),
    SWIM_SNORKEL(5),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): WorkoutEquipment {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: WorkoutEquipment): String = value.name
    }
}
