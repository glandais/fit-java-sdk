/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WaterType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class WaterType(rawValue: Int) {
    FRESH(0),
    SALT(1),
    EN13319(2),
    CUSTOM(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): WaterType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: WaterType): String = value.name
    }
}
