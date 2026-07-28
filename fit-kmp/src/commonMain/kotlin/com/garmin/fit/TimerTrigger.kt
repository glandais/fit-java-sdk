/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TimerTrigger.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class TimerTrigger(rawValue: Int) {
    MANUAL(0),
    AUTO(1),
    FITNESS_EQUIPMENT(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): TimerTrigger {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: TimerTrigger): String = value.name
    }
}
