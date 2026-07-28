/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DisplayMeasure.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class DisplayMeasure(rawValue: Int) {
    METRIC(0),
    STATUTE(1),
    NAUTICAL(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DisplayMeasure {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DisplayMeasure): String = value.name
    }
}
