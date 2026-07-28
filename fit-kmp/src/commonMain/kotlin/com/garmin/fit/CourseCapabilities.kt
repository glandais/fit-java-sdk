/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CourseCapabilities.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object CourseCapabilities {
    const val PROCESSED: Long = 1L
    const val VALID: Long = 2L
    const val TIME: Long = 4L
    const val DISTANCE: Long = 8L
    const val POSITION: Long = 16L
    const val HEART_RATE: Long = 32L
    const val POWER: Long = 64L
    const val CADENCE: Long = 128L
    const val TRAINING: Long = 256L
    const val NAVIGATION: Long = 512L
    const val BIKEWAY: Long = 1024L
    const val AVIATION: Long = 4096L // Denote course files to be used as flight plans
    val INVALID: Long = Fit.UINT32Z_INVALID

    private val stringMap: Map<Long, String> = mapOf(
        PROCESSED to "PROCESSED",
        VALID to "VALID",
        TIME to "TIME",
        DISTANCE to "DISTANCE",
        POSITION to "POSITION",
        HEART_RATE to "HEART_RATE",
        POWER to "POWER",
        CADENCE to "CADENCE",
        TRAINING to "TRAINING",
        NAVIGATION to "NAVIGATION",
        BIKEWAY to "BIKEWAY",
        AVIATION to "AVIATION"
    )

    fun getStringFromValue(value: Long?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Long {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
