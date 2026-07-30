/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from OlympicLiftExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object OlympicLiftExerciseName {
    const val BARBELL_HANG_POWER_CLEAN: Int = 0
    const val BARBELL_HANG_SQUAT_CLEAN: Int = 1
    const val BARBELL_POWER_CLEAN: Int = 2
    const val BARBELL_POWER_SNATCH: Int = 3
    const val BARBELL_SQUAT_CLEAN: Int = 4
    const val CLEAN_AND_JERK: Int = 5
    const val BARBELL_HANG_POWER_SNATCH: Int = 6
    const val BARBELL_HANG_PULL: Int = 7
    const val BARBELL_HIGH_PULL: Int = 8
    const val BARBELL_SNATCH: Int = 9
    const val BARBELL_SPLIT_JERK: Int = 10
    const val CLEAN: Int = 11
    const val DUMBBELL_CLEAN: Int = 12
    const val DUMBBELL_HANG_PULL: Int = 13
    const val ONE_HAND_DUMBBELL_SPLIT_SNATCH: Int = 14
    const val PUSH_JERK: Int = 15
    const val SINGLE_ARM_DUMBBELL_SNATCH: Int = 16
    const val SINGLE_ARM_HANG_SNATCH: Int = 17
    const val SINGLE_ARM_KETTLEBELL_SNATCH: Int = 18
    const val SPLIT_JERK: Int = 19
    const val SQUAT_CLEAN_AND_JERK: Int = 20
    const val DUMBBELL_HANG_SNATCH: Int = 21
    const val DUMBBELL_POWER_CLEAN_AND_JERK: Int = 22
    const val DUMBBELL_POWER_CLEAN_AND_PUSH_PRESS: Int = 23
    const val DUMBBELL_POWER_CLEAN_AND_STRICT_PRESS: Int = 24
    const val DUMBBELL_SNATCH: Int = 25
    const val MEDICINE_BALL_CLEAN: Int = 26
    const val CLEAN_AND_PRESS: Int = 27
    const val SNATCH: Int = 28
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BARBELL_HANG_POWER_CLEAN to "BARBELL_HANG_POWER_CLEAN",
        BARBELL_HANG_SQUAT_CLEAN to "BARBELL_HANG_SQUAT_CLEAN",
        BARBELL_POWER_CLEAN to "BARBELL_POWER_CLEAN",
        BARBELL_POWER_SNATCH to "BARBELL_POWER_SNATCH",
        BARBELL_SQUAT_CLEAN to "BARBELL_SQUAT_CLEAN",
        CLEAN_AND_JERK to "CLEAN_AND_JERK",
        BARBELL_HANG_POWER_SNATCH to "BARBELL_HANG_POWER_SNATCH",
        BARBELL_HANG_PULL to "BARBELL_HANG_PULL",
        BARBELL_HIGH_PULL to "BARBELL_HIGH_PULL",
        BARBELL_SNATCH to "BARBELL_SNATCH",
        BARBELL_SPLIT_JERK to "BARBELL_SPLIT_JERK",
        CLEAN to "CLEAN",
        DUMBBELL_CLEAN to "DUMBBELL_CLEAN",
        DUMBBELL_HANG_PULL to "DUMBBELL_HANG_PULL",
        ONE_HAND_DUMBBELL_SPLIT_SNATCH to "ONE_HAND_DUMBBELL_SPLIT_SNATCH",
        PUSH_JERK to "PUSH_JERK",
        SINGLE_ARM_DUMBBELL_SNATCH to "SINGLE_ARM_DUMBBELL_SNATCH",
        SINGLE_ARM_HANG_SNATCH to "SINGLE_ARM_HANG_SNATCH",
        SINGLE_ARM_KETTLEBELL_SNATCH to "SINGLE_ARM_KETTLEBELL_SNATCH",
        SPLIT_JERK to "SPLIT_JERK",
        SQUAT_CLEAN_AND_JERK to "SQUAT_CLEAN_AND_JERK",
        DUMBBELL_HANG_SNATCH to "DUMBBELL_HANG_SNATCH",
        DUMBBELL_POWER_CLEAN_AND_JERK to "DUMBBELL_POWER_CLEAN_AND_JERK",
        DUMBBELL_POWER_CLEAN_AND_PUSH_PRESS to "DUMBBELL_POWER_CLEAN_AND_PUSH_PRESS",
        DUMBBELL_POWER_CLEAN_AND_STRICT_PRESS to "DUMBBELL_POWER_CLEAN_AND_STRICT_PRESS",
        DUMBBELL_SNATCH to "DUMBBELL_SNATCH",
        MEDICINE_BALL_CLEAN to "MEDICINE_BALL_CLEAN",
        CLEAN_AND_PRESS to "CLEAN_AND_PRESS",
        SNATCH to "SNATCH"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
