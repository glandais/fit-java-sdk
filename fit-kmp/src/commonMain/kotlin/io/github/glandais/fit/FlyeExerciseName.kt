/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FlyeExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object FlyeExerciseName {
    const val CABLE_CROSSOVER: Int = 0
    const val DECLINE_DUMBBELL_FLYE: Int = 1
    const val DUMBBELL_FLYE: Int = 2
    const val INCLINE_DUMBBELL_FLYE: Int = 3
    const val KETTLEBELL_FLYE: Int = 4
    const val KNEELING_REAR_FLYE: Int = 5
    const val SINGLE_ARM_STANDING_CABLE_REVERSE_FLYE: Int = 6
    const val SWISS_BALL_DUMBBELL_FLYE: Int = 7
    const val ARM_ROTATIONS: Int = 8
    const val HUG_A_TREE: Int = 9
    const val FACE_DOWN_INCLINE_REVERSE_FLYE: Int = 10
    const val INCLINE_REVERSE_FLYE: Int = 11
    const val REAR_DELT_FLY_WHEELCHAIR: Int = 12
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        CABLE_CROSSOVER to "CABLE_CROSSOVER",
        DECLINE_DUMBBELL_FLYE to "DECLINE_DUMBBELL_FLYE",
        DUMBBELL_FLYE to "DUMBBELL_FLYE",
        INCLINE_DUMBBELL_FLYE to "INCLINE_DUMBBELL_FLYE",
        KETTLEBELL_FLYE to "KETTLEBELL_FLYE",
        KNEELING_REAR_FLYE to "KNEELING_REAR_FLYE",
        SINGLE_ARM_STANDING_CABLE_REVERSE_FLYE to "SINGLE_ARM_STANDING_CABLE_REVERSE_FLYE",
        SWISS_BALL_DUMBBELL_FLYE to "SWISS_BALL_DUMBBELL_FLYE",
        ARM_ROTATIONS to "ARM_ROTATIONS",
        HUG_A_TREE to "HUG_A_TREE",
        FACE_DOWN_INCLINE_REVERSE_FLYE to "FACE_DOWN_INCLINE_REVERSE_FLYE",
        INCLINE_REVERSE_FLYE to "INCLINE_REVERSE_FLYE",
        REAR_DELT_FLY_WHEELCHAIR to "REAR_DELT_FLY_WHEELCHAIR"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
