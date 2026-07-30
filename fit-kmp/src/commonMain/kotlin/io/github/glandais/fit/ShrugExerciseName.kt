/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ShrugExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object ShrugExerciseName {
    const val BARBELL_JUMP_SHRUG: Int = 0
    const val BARBELL_SHRUG: Int = 1
    const val BARBELL_UPRIGHT_ROW: Int = 2
    const val BEHIND_THE_BACK_SMITH_MACHINE_SHRUG: Int = 3
    const val DUMBBELL_JUMP_SHRUG: Int = 4
    const val DUMBBELL_SHRUG: Int = 5
    const val DUMBBELL_UPRIGHT_ROW: Int = 6
    const val INCLINE_DUMBBELL_SHRUG: Int = 7
    const val OVERHEAD_BARBELL_SHRUG: Int = 8
    const val OVERHEAD_DUMBBELL_SHRUG: Int = 9
    const val SCAPTION_AND_SHRUG: Int = 10
    const val SCAPULAR_RETRACTION: Int = 11
    const val SERRATUS_CHAIR_SHRUG: Int = 12
    const val WEIGHTED_SERRATUS_CHAIR_SHRUG: Int = 13
    const val SERRATUS_SHRUG: Int = 14
    const val WEIGHTED_SERRATUS_SHRUG: Int = 15
    const val WIDE_GRIP_JUMP_SHRUG: Int = 16
    const val WIDE_GRIP_BARBELL_SHRUG: Int = 17
    const val BEHIND_THE_BACK_SHRUG: Int = 18
    const val DUMBBELL_SHRUG_WHEELCHAIR: Int = 19
    const val SHRUG_WHEELCHAIR: Int = 20
    const val SHRUG_ARM_DOWN_WHEELCHAIR: Int = 21
    const val SHRUG_ARM_MID_WHEELCHAIR: Int = 22
    const val SHRUG_ARM_UP_WHEELCHAIR: Int = 23
    const val UPRIGHT_ROW: Int = 24
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BARBELL_JUMP_SHRUG to "BARBELL_JUMP_SHRUG",
        BARBELL_SHRUG to "BARBELL_SHRUG",
        BARBELL_UPRIGHT_ROW to "BARBELL_UPRIGHT_ROW",
        BEHIND_THE_BACK_SMITH_MACHINE_SHRUG to "BEHIND_THE_BACK_SMITH_MACHINE_SHRUG",
        DUMBBELL_JUMP_SHRUG to "DUMBBELL_JUMP_SHRUG",
        DUMBBELL_SHRUG to "DUMBBELL_SHRUG",
        DUMBBELL_UPRIGHT_ROW to "DUMBBELL_UPRIGHT_ROW",
        INCLINE_DUMBBELL_SHRUG to "INCLINE_DUMBBELL_SHRUG",
        OVERHEAD_BARBELL_SHRUG to "OVERHEAD_BARBELL_SHRUG",
        OVERHEAD_DUMBBELL_SHRUG to "OVERHEAD_DUMBBELL_SHRUG",
        SCAPTION_AND_SHRUG to "SCAPTION_AND_SHRUG",
        SCAPULAR_RETRACTION to "SCAPULAR_RETRACTION",
        SERRATUS_CHAIR_SHRUG to "SERRATUS_CHAIR_SHRUG",
        WEIGHTED_SERRATUS_CHAIR_SHRUG to "WEIGHTED_SERRATUS_CHAIR_SHRUG",
        SERRATUS_SHRUG to "SERRATUS_SHRUG",
        WEIGHTED_SERRATUS_SHRUG to "WEIGHTED_SERRATUS_SHRUG",
        WIDE_GRIP_JUMP_SHRUG to "WIDE_GRIP_JUMP_SHRUG",
        WIDE_GRIP_BARBELL_SHRUG to "WIDE_GRIP_BARBELL_SHRUG",
        BEHIND_THE_BACK_SHRUG to "BEHIND_THE_BACK_SHRUG",
        DUMBBELL_SHRUG_WHEELCHAIR to "DUMBBELL_SHRUG_WHEELCHAIR",
        SHRUG_WHEELCHAIR to "SHRUG_WHEELCHAIR",
        SHRUG_ARM_DOWN_WHEELCHAIR to "SHRUG_ARM_DOWN_WHEELCHAIR",
        SHRUG_ARM_MID_WHEELCHAIR to "SHRUG_ARM_MID_WHEELCHAIR",
        SHRUG_ARM_UP_WHEELCHAIR to "SHRUG_ARM_UP_WHEELCHAIR",
        UPRIGHT_ROW to "UPRIGHT_ROW"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
