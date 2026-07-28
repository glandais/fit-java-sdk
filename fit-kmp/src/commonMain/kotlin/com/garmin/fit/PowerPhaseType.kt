/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from PowerPhaseType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class PowerPhaseType(rawValue: Int) {
    POWER_PHASE_START_ANGLE(0),
    POWER_PHASE_END_ANGLE(1),
    POWER_PHASE_ARC_LENGTH(2),
    POWER_PHASE_CENTER(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): PowerPhaseType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: PowerPhaseType): String = value.name
    }
}
