/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WeatherSeverity.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class WeatherSeverity(rawValue: Int) {
    UNKNOWN(0),
    WARNING(1),
    WATCH(2),
    ADVISORY(3),
    STATEMENT(4),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): WeatherSeverity {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: WeatherSeverity): String = value.name
    }
}
