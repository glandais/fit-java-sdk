/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ShoulderStabilityExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object ShoulderStabilityExerciseName {
    const val _90_DEGREE_CABLE_EXTERNAL_ROTATION: Int = 0
    const val BAND_EXTERNAL_ROTATION: Int = 1
    const val BAND_INTERNAL_ROTATION: Int = 2
    const val BENT_ARM_LATERAL_RAISE_AND_EXTERNAL_ROTATION: Int = 3
    const val CABLE_EXTERNAL_ROTATION: Int = 4
    const val DUMBBELL_FACE_PULL_WITH_EXTERNAL_ROTATION: Int = 5
    const val FLOOR_I_RAISE: Int = 6
    const val WEIGHTED_FLOOR_I_RAISE: Int = 7
    const val FLOOR_T_RAISE: Int = 8
    const val WEIGHTED_FLOOR_T_RAISE: Int = 9
    const val FLOOR_Y_RAISE: Int = 10
    const val WEIGHTED_FLOOR_Y_RAISE: Int = 11
    const val INCLINE_I_RAISE: Int = 12
    const val WEIGHTED_INCLINE_I_RAISE: Int = 13
    const val INCLINE_L_RAISE: Int = 14
    const val WEIGHTED_INCLINE_L_RAISE: Int = 15
    const val INCLINE_T_RAISE: Int = 16
    const val WEIGHTED_INCLINE_T_RAISE: Int = 17
    const val INCLINE_W_RAISE: Int = 18
    const val WEIGHTED_INCLINE_W_RAISE: Int = 19
    const val INCLINE_Y_RAISE: Int = 20
    const val WEIGHTED_INCLINE_Y_RAISE: Int = 21
    const val LYING_EXTERNAL_ROTATION: Int = 22
    const val SEATED_DUMBBELL_EXTERNAL_ROTATION: Int = 23
    const val STANDING_L_RAISE: Int = 24
    const val SWISS_BALL_I_RAISE: Int = 25
    const val WEIGHTED_SWISS_BALL_I_RAISE: Int = 26
    const val SWISS_BALL_T_RAISE: Int = 27
    const val WEIGHTED_SWISS_BALL_T_RAISE: Int = 28
    const val SWISS_BALL_W_RAISE: Int = 29
    const val WEIGHTED_SWISS_BALL_W_RAISE: Int = 30
    const val SWISS_BALL_Y_RAISE: Int = 31
    const val WEIGHTED_SWISS_BALL_Y_RAISE: Int = 32
    const val CABLE_INTERNAL_ROTATION: Int = 33
    const val LYING_INTERNAL_ROTATION: Int = 34
    const val SEATED_DUMBBELL_INTERNAL_ROTATION: Int = 35
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        _90_DEGREE_CABLE_EXTERNAL_ROTATION to "_90_DEGREE_CABLE_EXTERNAL_ROTATION",
        BAND_EXTERNAL_ROTATION to "BAND_EXTERNAL_ROTATION",
        BAND_INTERNAL_ROTATION to "BAND_INTERNAL_ROTATION",
        BENT_ARM_LATERAL_RAISE_AND_EXTERNAL_ROTATION to "BENT_ARM_LATERAL_RAISE_AND_EXTERNAL_ROTATION",
        CABLE_EXTERNAL_ROTATION to "CABLE_EXTERNAL_ROTATION",
        DUMBBELL_FACE_PULL_WITH_EXTERNAL_ROTATION to "DUMBBELL_FACE_PULL_WITH_EXTERNAL_ROTATION",
        FLOOR_I_RAISE to "FLOOR_I_RAISE",
        WEIGHTED_FLOOR_I_RAISE to "WEIGHTED_FLOOR_I_RAISE",
        FLOOR_T_RAISE to "FLOOR_T_RAISE",
        WEIGHTED_FLOOR_T_RAISE to "WEIGHTED_FLOOR_T_RAISE",
        FLOOR_Y_RAISE to "FLOOR_Y_RAISE",
        WEIGHTED_FLOOR_Y_RAISE to "WEIGHTED_FLOOR_Y_RAISE",
        INCLINE_I_RAISE to "INCLINE_I_RAISE",
        WEIGHTED_INCLINE_I_RAISE to "WEIGHTED_INCLINE_I_RAISE",
        INCLINE_L_RAISE to "INCLINE_L_RAISE",
        WEIGHTED_INCLINE_L_RAISE to "WEIGHTED_INCLINE_L_RAISE",
        INCLINE_T_RAISE to "INCLINE_T_RAISE",
        WEIGHTED_INCLINE_T_RAISE to "WEIGHTED_INCLINE_T_RAISE",
        INCLINE_W_RAISE to "INCLINE_W_RAISE",
        WEIGHTED_INCLINE_W_RAISE to "WEIGHTED_INCLINE_W_RAISE",
        INCLINE_Y_RAISE to "INCLINE_Y_RAISE",
        WEIGHTED_INCLINE_Y_RAISE to "WEIGHTED_INCLINE_Y_RAISE",
        LYING_EXTERNAL_ROTATION to "LYING_EXTERNAL_ROTATION",
        SEATED_DUMBBELL_EXTERNAL_ROTATION to "SEATED_DUMBBELL_EXTERNAL_ROTATION",
        STANDING_L_RAISE to "STANDING_L_RAISE",
        SWISS_BALL_I_RAISE to "SWISS_BALL_I_RAISE",
        WEIGHTED_SWISS_BALL_I_RAISE to "WEIGHTED_SWISS_BALL_I_RAISE",
        SWISS_BALL_T_RAISE to "SWISS_BALL_T_RAISE",
        WEIGHTED_SWISS_BALL_T_RAISE to "WEIGHTED_SWISS_BALL_T_RAISE",
        SWISS_BALL_W_RAISE to "SWISS_BALL_W_RAISE",
        WEIGHTED_SWISS_BALL_W_RAISE to "WEIGHTED_SWISS_BALL_W_RAISE",
        SWISS_BALL_Y_RAISE to "SWISS_BALL_Y_RAISE",
        WEIGHTED_SWISS_BALL_Y_RAISE to "WEIGHTED_SWISS_BALL_Y_RAISE",
        CABLE_INTERNAL_ROTATION to "CABLE_INTERNAL_ROTATION",
        LYING_INTERNAL_ROTATION to "LYING_INTERNAL_ROTATION",
        SEATED_DUMBBELL_INTERNAL_ROTATION to "SEATED_DUMBBELL_INTERNAL_ROTATION"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
