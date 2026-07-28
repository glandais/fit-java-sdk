/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WeatherStatus.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class WeatherStatus(rawValue: Int) {
    CLEAR(0),
    PARTLY_CLOUDY(1),
    MOSTLY_CLOUDY(2),
    RAIN(3),
    SNOW(4),
    WINDY(5),
    THUNDERSTORMS(6),
    WINTRY_MIX(7),
    FOG(8),
    HAZY(11),
    HAIL(12),
    SCATTERED_SHOWERS(13),
    SCATTERED_THUNDERSTORMS(14),
    UNKNOWN_PRECIPITATION(15),
    LIGHT_RAIN(16),
    HEAVY_RAIN(17),
    LIGHT_SNOW(18),
    HEAVY_SNOW(19),
    LIGHT_RAIN_SNOW(20),
    HEAVY_RAIN_SNOW(21),
    CLOUDY(22),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): WeatherStatus {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: WeatherStatus): String = value.name
    }
}
