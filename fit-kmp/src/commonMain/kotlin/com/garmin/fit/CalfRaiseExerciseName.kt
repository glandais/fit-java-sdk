/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CalfRaiseExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object CalfRaiseExerciseName {
    const val _3_WAY_CALF_RAISE: Int = 0
    const val _3_WAY_WEIGHTED_CALF_RAISE: Int = 1
    const val _3_WAY_SINGLE_LEG_CALF_RAISE: Int = 2
    const val _3_WAY_WEIGHTED_SINGLE_LEG_CALF_RAISE: Int = 3
    const val DONKEY_CALF_RAISE: Int = 4
    const val WEIGHTED_DONKEY_CALF_RAISE: Int = 5
    const val SEATED_CALF_RAISE: Int = 6
    const val WEIGHTED_SEATED_CALF_RAISE: Int = 7
    const val SEATED_DUMBBELL_TOE_RAISE: Int = 8
    const val SINGLE_LEG_BENT_KNEE_CALF_RAISE: Int = 9
    const val WEIGHTED_SINGLE_LEG_BENT_KNEE_CALF_RAISE: Int = 10
    const val SINGLE_LEG_DECLINE_PUSH_UP: Int = 11
    const val SINGLE_LEG_DONKEY_CALF_RAISE: Int = 12
    const val WEIGHTED_SINGLE_LEG_DONKEY_CALF_RAISE: Int = 13
    const val SINGLE_LEG_HIP_RAISE_WITH_KNEE_HOLD: Int = 14
    const val SINGLE_LEG_STANDING_CALF_RAISE: Int = 15
    const val SINGLE_LEG_STANDING_DUMBBELL_CALF_RAISE: Int = 16
    const val STANDING_BARBELL_CALF_RAISE: Int = 17
    const val STANDING_CALF_RAISE: Int = 18
    const val WEIGHTED_STANDING_CALF_RAISE: Int = 19
    const val STANDING_DUMBBELL_CALF_RAISE: Int = 20
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        _3_WAY_CALF_RAISE to "_3_WAY_CALF_RAISE",
        _3_WAY_WEIGHTED_CALF_RAISE to "_3_WAY_WEIGHTED_CALF_RAISE",
        _3_WAY_SINGLE_LEG_CALF_RAISE to "_3_WAY_SINGLE_LEG_CALF_RAISE",
        _3_WAY_WEIGHTED_SINGLE_LEG_CALF_RAISE to "_3_WAY_WEIGHTED_SINGLE_LEG_CALF_RAISE",
        DONKEY_CALF_RAISE to "DONKEY_CALF_RAISE",
        WEIGHTED_DONKEY_CALF_RAISE to "WEIGHTED_DONKEY_CALF_RAISE",
        SEATED_CALF_RAISE to "SEATED_CALF_RAISE",
        WEIGHTED_SEATED_CALF_RAISE to "WEIGHTED_SEATED_CALF_RAISE",
        SEATED_DUMBBELL_TOE_RAISE to "SEATED_DUMBBELL_TOE_RAISE",
        SINGLE_LEG_BENT_KNEE_CALF_RAISE to "SINGLE_LEG_BENT_KNEE_CALF_RAISE",
        WEIGHTED_SINGLE_LEG_BENT_KNEE_CALF_RAISE to "WEIGHTED_SINGLE_LEG_BENT_KNEE_CALF_RAISE",
        SINGLE_LEG_DECLINE_PUSH_UP to "SINGLE_LEG_DECLINE_PUSH_UP",
        SINGLE_LEG_DONKEY_CALF_RAISE to "SINGLE_LEG_DONKEY_CALF_RAISE",
        WEIGHTED_SINGLE_LEG_DONKEY_CALF_RAISE to "WEIGHTED_SINGLE_LEG_DONKEY_CALF_RAISE",
        SINGLE_LEG_HIP_RAISE_WITH_KNEE_HOLD to "SINGLE_LEG_HIP_RAISE_WITH_KNEE_HOLD",
        SINGLE_LEG_STANDING_CALF_RAISE to "SINGLE_LEG_STANDING_CALF_RAISE",
        SINGLE_LEG_STANDING_DUMBBELL_CALF_RAISE to "SINGLE_LEG_STANDING_DUMBBELL_CALF_RAISE",
        STANDING_BARBELL_CALF_RAISE to "STANDING_BARBELL_CALF_RAISE",
        STANDING_CALF_RAISE to "STANDING_CALF_RAISE",
        WEIGHTED_STANDING_CALF_RAISE to "WEIGHTED_STANDING_CALF_RAISE",
        STANDING_DUMBBELL_CALF_RAISE to "STANDING_DUMBBELL_CALF_RAISE"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
