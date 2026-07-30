/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LateralRaiseExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object LateralRaiseExerciseName {
    const val _45_DEGREE_CABLE_EXTERNAL_ROTATION: Int = 0
    const val ALTERNATING_LATERAL_RAISE_WITH_STATIC_HOLD: Int = 1
    const val BAR_MUSCLE_UP: Int = 2
    const val BENT_OVER_LATERAL_RAISE: Int = 3
    const val CABLE_DIAGONAL_RAISE: Int = 4
    const val CABLE_FRONT_RAISE: Int = 5
    const val CALORIE_ROW: Int = 6
    const val COMBO_SHOULDER_RAISE: Int = 7
    const val DUMBBELL_DIAGONAL_RAISE: Int = 8
    const val DUMBBELL_V_RAISE: Int = 9
    const val FRONT_RAISE: Int = 10
    const val LEANING_DUMBBELL_LATERAL_RAISE: Int = 11
    const val LYING_DUMBBELL_RAISE: Int = 12
    const val MUSCLE_UP: Int = 13
    const val ONE_ARM_CABLE_LATERAL_RAISE: Int = 14
    const val OVERHAND_GRIP_REAR_LATERAL_RAISE: Int = 15
    const val PLATE_RAISES: Int = 16
    const val RING_DIP: Int = 17
    const val WEIGHTED_RING_DIP: Int = 18
    const val RING_MUSCLE_UP: Int = 19
    const val WEIGHTED_RING_MUSCLE_UP: Int = 20
    const val ROPE_CLIMB: Int = 21
    const val WEIGHTED_ROPE_CLIMB: Int = 22
    const val SCAPTION: Int = 23
    const val SEATED_LATERAL_RAISE: Int = 24
    const val SEATED_REAR_LATERAL_RAISE: Int = 25
    const val SIDE_LYING_LATERAL_RAISE: Int = 26
    const val STANDING_LIFT: Int = 27
    const val SUSPENDED_ROW: Int = 28
    const val UNDERHAND_GRIP_REAR_LATERAL_RAISE: Int = 29
    const val WALL_SLIDE: Int = 30
    const val WEIGHTED_WALL_SLIDE: Int = 31
    const val ARM_CIRCLES: Int = 32
    const val SHAVING_THE_HEAD: Int = 33
    const val DUMBBELL_LATERAL_RAISE: Int = 34
    const val RING_DIP_KIPPING: Int = 36
    const val WALL_WALK: Int = 37
    const val DUMBBELL_FRONT_RAISE_WHEELCHAIR: Int = 38
    const val DUMBBELL_LATERAL_RAISE_WHEELCHAIR: Int = 39
    const val POLE_DOUBLE_ARM_OVERHEAD_AND_FORWARD_WHEELCHAIR: Int = 40
    const val POLE_STRAIGHT_ARM_OVERHEAD_WHEELCHAIR: Int = 41
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        _45_DEGREE_CABLE_EXTERNAL_ROTATION to "_45_DEGREE_CABLE_EXTERNAL_ROTATION",
        ALTERNATING_LATERAL_RAISE_WITH_STATIC_HOLD to "ALTERNATING_LATERAL_RAISE_WITH_STATIC_HOLD",
        BAR_MUSCLE_UP to "BAR_MUSCLE_UP",
        BENT_OVER_LATERAL_RAISE to "BENT_OVER_LATERAL_RAISE",
        CABLE_DIAGONAL_RAISE to "CABLE_DIAGONAL_RAISE",
        CABLE_FRONT_RAISE to "CABLE_FRONT_RAISE",
        CALORIE_ROW to "CALORIE_ROW",
        COMBO_SHOULDER_RAISE to "COMBO_SHOULDER_RAISE",
        DUMBBELL_DIAGONAL_RAISE to "DUMBBELL_DIAGONAL_RAISE",
        DUMBBELL_V_RAISE to "DUMBBELL_V_RAISE",
        FRONT_RAISE to "FRONT_RAISE",
        LEANING_DUMBBELL_LATERAL_RAISE to "LEANING_DUMBBELL_LATERAL_RAISE",
        LYING_DUMBBELL_RAISE to "LYING_DUMBBELL_RAISE",
        MUSCLE_UP to "MUSCLE_UP",
        ONE_ARM_CABLE_LATERAL_RAISE to "ONE_ARM_CABLE_LATERAL_RAISE",
        OVERHAND_GRIP_REAR_LATERAL_RAISE to "OVERHAND_GRIP_REAR_LATERAL_RAISE",
        PLATE_RAISES to "PLATE_RAISES",
        RING_DIP to "RING_DIP",
        WEIGHTED_RING_DIP to "WEIGHTED_RING_DIP",
        RING_MUSCLE_UP to "RING_MUSCLE_UP",
        WEIGHTED_RING_MUSCLE_UP to "WEIGHTED_RING_MUSCLE_UP",
        ROPE_CLIMB to "ROPE_CLIMB",
        WEIGHTED_ROPE_CLIMB to "WEIGHTED_ROPE_CLIMB",
        SCAPTION to "SCAPTION",
        SEATED_LATERAL_RAISE to "SEATED_LATERAL_RAISE",
        SEATED_REAR_LATERAL_RAISE to "SEATED_REAR_LATERAL_RAISE",
        SIDE_LYING_LATERAL_RAISE to "SIDE_LYING_LATERAL_RAISE",
        STANDING_LIFT to "STANDING_LIFT",
        SUSPENDED_ROW to "SUSPENDED_ROW",
        UNDERHAND_GRIP_REAR_LATERAL_RAISE to "UNDERHAND_GRIP_REAR_LATERAL_RAISE",
        WALL_SLIDE to "WALL_SLIDE",
        WEIGHTED_WALL_SLIDE to "WEIGHTED_WALL_SLIDE",
        ARM_CIRCLES to "ARM_CIRCLES",
        SHAVING_THE_HEAD to "SHAVING_THE_HEAD",
        DUMBBELL_LATERAL_RAISE to "DUMBBELL_LATERAL_RAISE",
        RING_DIP_KIPPING to "RING_DIP_KIPPING",
        WALL_WALK to "WALL_WALK",
        DUMBBELL_FRONT_RAISE_WHEELCHAIR to "DUMBBELL_FRONT_RAISE_WHEELCHAIR",
        DUMBBELL_LATERAL_RAISE_WHEELCHAIR to "DUMBBELL_LATERAL_RAISE_WHEELCHAIR",
        POLE_DOUBLE_ARM_OVERHEAD_AND_FORWARD_WHEELCHAIR to "POLE_DOUBLE_ARM_OVERHEAD_AND_FORWARD_WHEELCHAIR",
        POLE_STRAIGHT_ARM_OVERHEAD_WHEELCHAIR to "POLE_STRAIGHT_ARM_OVERHEAD_WHEELCHAIR"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
