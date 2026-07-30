/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AntplusDeviceType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object AntplusDeviceType {
    const val ANTFS: Short = 1
    const val BIKE_POWER: Short = 11
    const val ENVIRONMENT_SENSOR_LEGACY: Short = 12
    const val MULTI_SPORT_SPEED_DISTANCE: Short = 15
    const val CONTROL: Short = 16
    const val FITNESS_EQUIPMENT: Short = 17
    const val BLOOD_PRESSURE: Short = 18
    const val GEOCACHE_NODE: Short = 19
    const val LIGHT_ELECTRIC_VEHICLE: Short = 20
    const val ENV_SENSOR: Short = 25
    const val RACQUET: Short = 26
    const val CONTROL_HUB: Short = 27
    const val MUSCLE_OXYGEN: Short = 31
    const val SHIFTING: Short = 34
    const val BIKE_LIGHT_MAIN: Short = 35
    const val BIKE_LIGHT_SHARED: Short = 36
    const val EXD: Short = 38
    const val BIKE_RADAR: Short = 40
    const val BIKE_AERO: Short = 46
    const val WEIGHT_SCALE: Short = 119
    const val HEART_RATE: Short = 120
    const val BIKE_SPEED_CADENCE: Short = 121
    const val BIKE_CADENCE: Short = 122
    const val BIKE_SPEED: Short = 123
    const val STRIDE_SPEED_DISTANCE: Short = 124
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        ANTFS to "ANTFS",
        BIKE_POWER to "BIKE_POWER",
        ENVIRONMENT_SENSOR_LEGACY to "ENVIRONMENT_SENSOR_LEGACY",
        MULTI_SPORT_SPEED_DISTANCE to "MULTI_SPORT_SPEED_DISTANCE",
        CONTROL to "CONTROL",
        FITNESS_EQUIPMENT to "FITNESS_EQUIPMENT",
        BLOOD_PRESSURE to "BLOOD_PRESSURE",
        GEOCACHE_NODE to "GEOCACHE_NODE",
        LIGHT_ELECTRIC_VEHICLE to "LIGHT_ELECTRIC_VEHICLE",
        ENV_SENSOR to "ENV_SENSOR",
        RACQUET to "RACQUET",
        CONTROL_HUB to "CONTROL_HUB",
        MUSCLE_OXYGEN to "MUSCLE_OXYGEN",
        SHIFTING to "SHIFTING",
        BIKE_LIGHT_MAIN to "BIKE_LIGHT_MAIN",
        BIKE_LIGHT_SHARED to "BIKE_LIGHT_SHARED",
        EXD to "EXD",
        BIKE_RADAR to "BIKE_RADAR",
        BIKE_AERO to "BIKE_AERO",
        WEIGHT_SCALE to "WEIGHT_SCALE",
        HEART_RATE to "HEART_RATE",
        BIKE_SPEED_CADENCE to "BIKE_SPEED_CADENCE",
        BIKE_CADENCE to "BIKE_CADENCE",
        BIKE_SPEED to "BIKE_SPEED",
        STRIDE_SPEED_DISTANCE to "STRIDE_SPEED_DISTANCE"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
