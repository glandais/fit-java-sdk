/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BacklightMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class BacklightMode(rawValue: Int) {
    OFF(0),
    MANUAL(1),
    KEY_AND_MESSAGES(2),
    AUTO_BRIGHTNESS(3),
    SMART_NOTIFICATIONS(4),
    KEY_AND_MESSAGES_NIGHT(5),
    KEY_AND_MESSAGES_AND_SMART_NOTIFICATIONS(6),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): BacklightMode {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: BacklightMode): String = value.name
    }
}
