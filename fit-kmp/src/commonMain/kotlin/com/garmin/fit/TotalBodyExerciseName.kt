/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TotalBodyExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object TotalBodyExerciseName {
    const val BURPEE: Int = 0
    const val WEIGHTED_BURPEE: Int = 1
    const val BURPEE_BOX_JUMP: Int = 2
    const val WEIGHTED_BURPEE_BOX_JUMP: Int = 3
    const val HIGH_PULL_BURPEE: Int = 4
    const val MAN_MAKERS: Int = 5
    const val ONE_ARM_BURPEE: Int = 6
    const val SQUAT_THRUSTS: Int = 7
    const val WEIGHTED_SQUAT_THRUSTS: Int = 8
    const val SQUAT_PLANK_PUSH_UP: Int = 9
    const val WEIGHTED_SQUAT_PLANK_PUSH_UP: Int = 10
    const val STANDING_T_ROTATION_BALANCE: Int = 11
    const val WEIGHTED_STANDING_T_ROTATION_BALANCE: Int = 12
    const val BARBELL_BURPEE: Int = 13
    const val BURPEE_BOX_JUMP_OVER_YES_LITERALLY_JUMPING_OVER_THE_BOX: Int = 15
    const val BURPEE_BOX_JUMP_STEP_UP_OVER: Int = 16
    const val LATERAL_BARBELL_BURPEE: Int = 17
    const val TOTAL_BODY_BURPEE_OVER_BAR: Int = 18
    const val BURPEE_BOX_JUMP_OVER: Int = 19
    const val BURPEE_WHEELCHAIR: Int = 20
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BURPEE to "BURPEE",
        WEIGHTED_BURPEE to "WEIGHTED_BURPEE",
        BURPEE_BOX_JUMP to "BURPEE_BOX_JUMP",
        WEIGHTED_BURPEE_BOX_JUMP to "WEIGHTED_BURPEE_BOX_JUMP",
        HIGH_PULL_BURPEE to "HIGH_PULL_BURPEE",
        MAN_MAKERS to "MAN_MAKERS",
        ONE_ARM_BURPEE to "ONE_ARM_BURPEE",
        SQUAT_THRUSTS to "SQUAT_THRUSTS",
        WEIGHTED_SQUAT_THRUSTS to "WEIGHTED_SQUAT_THRUSTS",
        SQUAT_PLANK_PUSH_UP to "SQUAT_PLANK_PUSH_UP",
        WEIGHTED_SQUAT_PLANK_PUSH_UP to "WEIGHTED_SQUAT_PLANK_PUSH_UP",
        STANDING_T_ROTATION_BALANCE to "STANDING_T_ROTATION_BALANCE",
        WEIGHTED_STANDING_T_ROTATION_BALANCE to "WEIGHTED_STANDING_T_ROTATION_BALANCE",
        BARBELL_BURPEE to "BARBELL_BURPEE",
        BURPEE_BOX_JUMP_OVER_YES_LITERALLY_JUMPING_OVER_THE_BOX to "BURPEE_BOX_JUMP_OVER_YES_LITERALLY_JUMPING_OVER_THE_BOX",
        BURPEE_BOX_JUMP_STEP_UP_OVER to "BURPEE_BOX_JUMP_STEP_UP_OVER",
        LATERAL_BARBELL_BURPEE to "LATERAL_BARBELL_BURPEE",
        TOTAL_BODY_BURPEE_OVER_BAR to "TOTAL_BODY_BURPEE_OVER_BAR",
        BURPEE_BOX_JUMP_OVER to "BURPEE_BOX_JUMP_OVER",
        BURPEE_WHEELCHAIR to "BURPEE_WHEELCHAIR"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
