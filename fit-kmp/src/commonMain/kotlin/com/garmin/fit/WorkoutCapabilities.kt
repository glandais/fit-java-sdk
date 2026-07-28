/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WorkoutCapabilities.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object WorkoutCapabilities {
    const val INTERVAL: Long = 1L
    const val CUSTOM: Long = 2L
    const val FITNESS_EQUIPMENT: Long = 4L
    const val FIRSTBEAT: Long = 8L
    const val NEW_LEAF: Long = 16L
    const val TCX: Long = 32L // For backwards compatibility. Watch should add missing id fields then clear flag.
    const val SPEED: Long = 128L // Speed source required for workout step.
    const val HEART_RATE: Long = 256L // Heart rate source required for workout step.
    const val DISTANCE: Long = 512L // Distance source required for workout step.
    const val CADENCE: Long = 1024L // Cadence source required for workout step.
    const val POWER: Long = 2048L // Power source required for workout step.
    const val GRADE: Long = 4096L // Grade source required for workout step.
    const val RESISTANCE: Long = 8192L // Resistance source required for workout step.
    const val PROTECTED: Long = 16384L
    val INVALID: Long = Fit.UINT32Z_INVALID

    private val stringMap: Map<Long, String> = mapOf(
        INTERVAL to "INTERVAL",
        CUSTOM to "CUSTOM",
        FITNESS_EQUIPMENT to "FITNESS_EQUIPMENT",
        FIRSTBEAT to "FIRSTBEAT",
        NEW_LEAF to "NEW_LEAF",
        TCX to "TCX",
        SPEED to "SPEED",
        HEART_RATE to "HEART_RATE",
        DISTANCE to "DISTANCE",
        CADENCE to "CADENCE",
        POWER to "POWER",
        GRADE to "GRADE",
        RESISTANCE to "RESISTANCE",
        PROTECTED to "PROTECTED"
    )

    fun getStringFromValue(value: Long?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Long {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
