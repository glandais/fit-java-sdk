/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MaxMetSpeedSource.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class MaxMetSpeedSource(rawValue: Int) {
    ONBOARD_GPS(0),
    CONNECTED_GPS(1),
    CADENCE(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): MaxMetSpeedSource {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: MaxMetSpeedSource): String = value.name
    }
}
