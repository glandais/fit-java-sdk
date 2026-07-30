/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LapTrigger.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class LapTrigger(rawValue: Int) {
    MANUAL(0),
    TIME(1),
    DISTANCE(2),
    POSITION_START(3),
    POSITION_LAP(4),
    POSITION_WAYPOINT(5),
    POSITION_MARKED(6),
    SESSION_END(7),
    FITNESS_EQUIPMENT(8),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): LapTrigger {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: LapTrigger): String = value.name
    }
}
