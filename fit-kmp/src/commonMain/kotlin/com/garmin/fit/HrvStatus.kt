/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HrvStatus.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class HrvStatus(rawValue: Int) {
    NONE(0),
    POOR(1),
    LOW(2),
    UNBALANCED(3),
    BALANCED(4),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): HrvStatus {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: HrvStatus): String = value.name
    }
}
