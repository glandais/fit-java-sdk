/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WeatherReport.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class WeatherReport(rawValue: Int) {
    CURRENT(0),
    FORECAST(1),
    HOURLY_FORECAST(1),
    DAILY_FORECAST(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): WeatherReport {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: WeatherReport): String = value.name
    }
}
