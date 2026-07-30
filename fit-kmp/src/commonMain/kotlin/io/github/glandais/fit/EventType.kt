/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from EventType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class EventType(rawValue: Int) {
    START(0),
    STOP(1),
    CONSECUTIVE_DEPRECIATED(2),
    MARKER(3),
    STOP_ALL(4),
    BEGIN_DEPRECIATED(5),
    END_DEPRECIATED(6),
    END_ALL_DEPRECIATED(7),
    STOP_DISABLE(8),
    STOP_DISABLE_ALL(9),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): EventType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: EventType): String = value.name
    }
}
