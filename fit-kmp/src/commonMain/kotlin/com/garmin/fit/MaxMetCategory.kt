/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MaxMetCategory.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class MaxMetCategory(rawValue: Int) {
    GENERIC(0),
    CYCLING(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): MaxMetCategory {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: MaxMetCategory): String = value.name
    }
}
