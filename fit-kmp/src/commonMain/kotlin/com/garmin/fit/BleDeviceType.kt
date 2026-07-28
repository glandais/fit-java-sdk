/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BleDeviceType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object BleDeviceType {
    const val CONNECTED_GPS: Short = 0 // GPS that is provided over a proprietary bluetooth service
    const val HEART_RATE: Short = 1
    const val BIKE_POWER: Short = 2
    const val BIKE_SPEED_CADENCE: Short = 3
    const val BIKE_SPEED: Short = 4
    const val BIKE_CADENCE: Short = 5
    const val FOOTPOD: Short = 6
    const val BIKE_TRAINER: Short = 7 // Indoor-Bike FTMS protocol
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        CONNECTED_GPS to "CONNECTED_GPS",
        HEART_RATE to "HEART_RATE",
        BIKE_POWER to "BIKE_POWER",
        BIKE_SPEED_CADENCE to "BIKE_SPEED_CADENCE",
        BIKE_SPEED to "BIKE_SPEED",
        BIKE_CADENCE to "BIKE_CADENCE",
        FOOTPOD to "FOOTPOD",
        BIKE_TRAINER to "BIKE_TRAINER"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
