/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Autoscroll.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class Autoscroll(rawValue: Int) {
    NONE(0),
    SLOW(1),
    MEDIUM(2),
    FAST(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Autoscroll {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Autoscroll): String = value.name
    }
}
