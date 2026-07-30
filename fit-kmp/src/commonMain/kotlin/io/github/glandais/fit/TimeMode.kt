/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TimeMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class TimeMode(rawValue: Int) {
    HOUR12(0),
    HOUR24(1),
    MILITARY(2),
    HOUR_12_WITH_SECONDS(3),
    HOUR_24_WITH_SECONDS(4),
    UTC(5),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): TimeMode {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: TimeMode): String = value.name
    }
}
