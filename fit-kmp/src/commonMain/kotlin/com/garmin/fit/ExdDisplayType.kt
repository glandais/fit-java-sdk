/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ExdDisplayType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class ExdDisplayType(rawValue: Int) {
    NUMERICAL(0),
    SIMPLE(1),
    GRAPH(2),
    BAR(3),
    CIRCLE_GRAPH(4),
    VIRTUAL_PARTNER(5),
    BALANCE(6),
    STRING_LIST(7),
    STRING(8),
    SIMPLE_DYNAMIC_ICON(9),
    GAUGE(10),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): ExdDisplayType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: ExdDisplayType): String = value.name
    }
}
