/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from RunExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object RunExerciseName {
    const val RUN: Int = 0
    const val WALK: Int = 1
    const val JOG: Int = 2
    const val SPRINT: Int = 3
    const val RUN_OR_WALK: Int = 4
    const val SPEED_WALK: Int = 5
    const val WARM_UP: Int = 6
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        RUN to "RUN",
        WALK to "WALK",
        JOG to "JOG",
        SPRINT to "SPRINT",
        RUN_OR_WALK to "RUN_OR_WALK",
        SPEED_WALK to "SPEED_WALK",
        WARM_UP to "WARM_UP"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
