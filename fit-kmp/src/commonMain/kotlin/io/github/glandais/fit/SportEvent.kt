/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportEvent.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class SportEvent(rawValue: Int) {
    UNCATEGORIZED(0),
    GEOCACHING(1),
    FITNESS(2),
    RECREATION(3),
    RACE(4),
    SPECIAL_EVENT(5),
    TRAINING(6),
    TRANSPORTATION(7),
    TOURING(8),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SportEvent {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SportEvent): String = value.name
    }
}
