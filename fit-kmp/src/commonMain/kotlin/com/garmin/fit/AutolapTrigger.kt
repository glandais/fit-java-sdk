/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AutolapTrigger.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class AutolapTrigger(rawValue: Int) {
    TIME(0),
    DISTANCE(1),
    POSITION_START(2),
    POSITION_LAP(3),
    POSITION_WAYPOINT(4),
    POSITION_MARKED(5),
    OFF(6),
    AUTO_SELECT(13),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): AutolapTrigger {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: AutolapTrigger): String = value.name
    }
}
