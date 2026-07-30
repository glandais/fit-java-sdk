/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AutoActivityDetect.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object AutoActivityDetect {
    const val NONE: Long = 0L
    const val RUNNING: Long = 1L
    const val CYCLING: Long = 2L
    const val SWIMMING: Long = 4L
    const val WALKING: Long = 8L
    const val ELLIPTICAL: Long = 32L
    const val SEDENTARY: Long = 1024L
    val INVALID: Long = Fit.UINT32_INVALID

    private val stringMap: Map<Long, String> = mapOf(
        NONE to "NONE",
        RUNNING to "RUNNING",
        CYCLING to "CYCLING",
        SWIMMING to "SWIMMING",
        WALKING to "WALKING",
        ELLIPTICAL to "ELLIPTICAL",
        SEDENTARY to "SEDENTARY"
    )

    fun getStringFromValue(value: Long?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Long {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
