/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LocalDeviceType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object LocalDeviceType {
    const val GPS: Short = 0 // Onboard gps receiver
    const val GLONASS: Short = 1 // Onboard glonass receiver
    const val GPS_GLONASS: Short = 2 // Onboard gps glonass receiver
    const val ACCELEROMETER: Short = 3 // Onboard sensor
    const val BAROMETER: Short = 4 // Onboard sensor
    const val TEMPERATURE: Short = 5 // Onboard sensor
    const val WHR: Short = 10 // Onboard wrist HR sensor
    const val SENSOR_HUB: Short = 12 // Onboard software package
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        GPS to "GPS",
        GLONASS to "GLONASS",
        GPS_GLONASS to "GPS_GLONASS",
        ACCELEROMETER to "ACCELEROMETER",
        BAROMETER to "BAROMETER",
        TEMPERATURE to "TEMPERATURE",
        WHR to "WHR",
        SENSOR_HUB to "SENSOR_HUB"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
