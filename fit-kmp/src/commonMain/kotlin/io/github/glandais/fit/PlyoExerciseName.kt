/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from PlyoExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object PlyoExerciseName {
    const val ALTERNATING_JUMP_LUNGE: Int = 0
    const val WEIGHTED_ALTERNATING_JUMP_LUNGE: Int = 1
    const val BARBELL_JUMP_SQUAT: Int = 2
    const val BODY_WEIGHT_JUMP_SQUAT: Int = 3
    const val WEIGHTED_JUMP_SQUAT: Int = 4
    const val CROSS_KNEE_STRIKE: Int = 5
    const val WEIGHTED_CROSS_KNEE_STRIKE: Int = 6
    const val DEPTH_JUMP: Int = 7
    const val WEIGHTED_DEPTH_JUMP: Int = 8
    const val DUMBBELL_JUMP_SQUAT: Int = 9
    const val DUMBBELL_SPLIT_JUMP: Int = 10
    const val FRONT_KNEE_STRIKE: Int = 11
    const val WEIGHTED_FRONT_KNEE_STRIKE: Int = 12
    const val HIGH_BOX_JUMP: Int = 13
    const val WEIGHTED_HIGH_BOX_JUMP: Int = 14
    const val ISOMETRIC_EXPLOSIVE_BODY_WEIGHT_JUMP_SQUAT: Int = 15
    const val WEIGHTED_ISOMETRIC_EXPLOSIVE_JUMP_SQUAT: Int = 16
    const val LATERAL_LEAP_AND_HOP: Int = 17
    const val WEIGHTED_LATERAL_LEAP_AND_HOP: Int = 18
    const val LATERAL_PLYO_SQUATS: Int = 19
    const val WEIGHTED_LATERAL_PLYO_SQUATS: Int = 20
    const val LATERAL_SLIDE: Int = 21
    const val WEIGHTED_LATERAL_SLIDE: Int = 22
    const val MEDICINE_BALL_OVERHEAD_THROWS: Int = 23
    const val MEDICINE_BALL_SIDE_THROW: Int = 24
    const val MEDICINE_BALL_SLAM: Int = 25
    const val SIDE_TO_SIDE_MEDICINE_BALL_THROWS: Int = 26
    const val SIDE_TO_SIDE_SHUFFLE_JUMP: Int = 27
    const val WEIGHTED_SIDE_TO_SIDE_SHUFFLE_JUMP: Int = 28
    const val SQUAT_JUMP_ONTO_BOX: Int = 29
    const val WEIGHTED_SQUAT_JUMP_ONTO_BOX: Int = 30
    const val SQUAT_JUMPS_IN_AND_OUT: Int = 31
    const val WEIGHTED_SQUAT_JUMPS_IN_AND_OUT: Int = 32
    const val BOX_JUMP: Int = 33
    const val BOX_JUMP_OVERS: Int = 34
    const val BOX_JUMP_OVERS_OVER_THE_BOX: Int = 35
    const val STAR_JUMP_SQUATS: Int = 36
    const val JUMP_SQUAT: Int = 37
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        ALTERNATING_JUMP_LUNGE to "ALTERNATING_JUMP_LUNGE",
        WEIGHTED_ALTERNATING_JUMP_LUNGE to "WEIGHTED_ALTERNATING_JUMP_LUNGE",
        BARBELL_JUMP_SQUAT to "BARBELL_JUMP_SQUAT",
        BODY_WEIGHT_JUMP_SQUAT to "BODY_WEIGHT_JUMP_SQUAT",
        WEIGHTED_JUMP_SQUAT to "WEIGHTED_JUMP_SQUAT",
        CROSS_KNEE_STRIKE to "CROSS_KNEE_STRIKE",
        WEIGHTED_CROSS_KNEE_STRIKE to "WEIGHTED_CROSS_KNEE_STRIKE",
        DEPTH_JUMP to "DEPTH_JUMP",
        WEIGHTED_DEPTH_JUMP to "WEIGHTED_DEPTH_JUMP",
        DUMBBELL_JUMP_SQUAT to "DUMBBELL_JUMP_SQUAT",
        DUMBBELL_SPLIT_JUMP to "DUMBBELL_SPLIT_JUMP",
        FRONT_KNEE_STRIKE to "FRONT_KNEE_STRIKE",
        WEIGHTED_FRONT_KNEE_STRIKE to "WEIGHTED_FRONT_KNEE_STRIKE",
        HIGH_BOX_JUMP to "HIGH_BOX_JUMP",
        WEIGHTED_HIGH_BOX_JUMP to "WEIGHTED_HIGH_BOX_JUMP",
        ISOMETRIC_EXPLOSIVE_BODY_WEIGHT_JUMP_SQUAT to "ISOMETRIC_EXPLOSIVE_BODY_WEIGHT_JUMP_SQUAT",
        WEIGHTED_ISOMETRIC_EXPLOSIVE_JUMP_SQUAT to "WEIGHTED_ISOMETRIC_EXPLOSIVE_JUMP_SQUAT",
        LATERAL_LEAP_AND_HOP to "LATERAL_LEAP_AND_HOP",
        WEIGHTED_LATERAL_LEAP_AND_HOP to "WEIGHTED_LATERAL_LEAP_AND_HOP",
        LATERAL_PLYO_SQUATS to "LATERAL_PLYO_SQUATS",
        WEIGHTED_LATERAL_PLYO_SQUATS to "WEIGHTED_LATERAL_PLYO_SQUATS",
        LATERAL_SLIDE to "LATERAL_SLIDE",
        WEIGHTED_LATERAL_SLIDE to "WEIGHTED_LATERAL_SLIDE",
        MEDICINE_BALL_OVERHEAD_THROWS to "MEDICINE_BALL_OVERHEAD_THROWS",
        MEDICINE_BALL_SIDE_THROW to "MEDICINE_BALL_SIDE_THROW",
        MEDICINE_BALL_SLAM to "MEDICINE_BALL_SLAM",
        SIDE_TO_SIDE_MEDICINE_BALL_THROWS to "SIDE_TO_SIDE_MEDICINE_BALL_THROWS",
        SIDE_TO_SIDE_SHUFFLE_JUMP to "SIDE_TO_SIDE_SHUFFLE_JUMP",
        WEIGHTED_SIDE_TO_SIDE_SHUFFLE_JUMP to "WEIGHTED_SIDE_TO_SIDE_SHUFFLE_JUMP",
        SQUAT_JUMP_ONTO_BOX to "SQUAT_JUMP_ONTO_BOX",
        WEIGHTED_SQUAT_JUMP_ONTO_BOX to "WEIGHTED_SQUAT_JUMP_ONTO_BOX",
        SQUAT_JUMPS_IN_AND_OUT to "SQUAT_JUMPS_IN_AND_OUT",
        WEIGHTED_SQUAT_JUMPS_IN_AND_OUT to "WEIGHTED_SQUAT_JUMPS_IN_AND_OUT",
        BOX_JUMP to "BOX_JUMP",
        BOX_JUMP_OVERS to "BOX_JUMP_OVERS",
        BOX_JUMP_OVERS_OVER_THE_BOX to "BOX_JUMP_OVERS_OVER_THE_BOX",
        STAR_JUMP_SQUATS to "STAR_JUMP_SQUATS",
        JUMP_SQUAT to "JUMP_SQUAT"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
