/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SessionTrigger.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class SessionTrigger(rawValue: Int) {
    ACTIVITY_END(0),
    MANUAL(1),
    AUTO_MULTI_SPORT(2),
    FITNESS_EQUIPMENT(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SessionTrigger {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SessionTrigger): String = value.name
    }
}
