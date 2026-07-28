/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AnalogWatchfaceLayout.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class AnalogWatchfaceLayout(rawValue: Int) {
    MINIMAL(0),
    TRADITIONAL(1),
    MODERN(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): AnalogWatchfaceLayout {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: AnalogWatchfaceLayout): String = value.name
    }
}
