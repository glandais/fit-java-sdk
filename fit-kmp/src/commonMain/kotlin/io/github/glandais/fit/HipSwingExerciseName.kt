/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HipSwingExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object HipSwingExerciseName {
    const val SINGLE_ARM_KETTLEBELL_SWING: Int = 0
    const val SINGLE_ARM_DUMBBELL_SWING: Int = 1
    const val STEP_OUT_SWING: Int = 2
    const val ONE_ARM_SWING: Int = 3
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        SINGLE_ARM_KETTLEBELL_SWING to "SINGLE_ARM_KETTLEBELL_SWING",
        SINGLE_ARM_DUMBBELL_SWING to "SINGLE_ARM_DUMBBELL_SWING",
        STEP_OUT_SWING to "STEP_OUT_SWING",
        ONE_ARM_SWING to "ONE_ARM_SWING"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
