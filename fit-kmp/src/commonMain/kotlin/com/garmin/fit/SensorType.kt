/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SensorType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class SensorType(rawValue: Int) {
    ACCELEROMETER(0),
    GYROSCOPE(1),
    COMPASS(2),
    BAROMETER(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SensorType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SensorType): String = value.name
    }
}
