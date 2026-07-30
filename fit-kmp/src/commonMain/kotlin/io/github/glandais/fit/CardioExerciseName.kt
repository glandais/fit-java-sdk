/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CardioExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object CardioExerciseName {
    const val BOB_AND_WEAVE_CIRCLE: Int = 0
    const val WEIGHTED_BOB_AND_WEAVE_CIRCLE: Int = 1
    const val CARDIO_CORE_CRAWL: Int = 2
    const val WEIGHTED_CARDIO_CORE_CRAWL: Int = 3
    const val DOUBLE_UNDER: Int = 4
    const val WEIGHTED_DOUBLE_UNDER: Int = 5
    const val JUMP_ROPE: Int = 6
    const val WEIGHTED_JUMP_ROPE: Int = 7
    const val JUMP_ROPE_CROSSOVER: Int = 8
    const val WEIGHTED_JUMP_ROPE_CROSSOVER: Int = 9
    const val JUMP_ROPE_JOG: Int = 10
    const val WEIGHTED_JUMP_ROPE_JOG: Int = 11
    const val JUMPING_JACKS: Int = 12
    const val WEIGHTED_JUMPING_JACKS: Int = 13
    const val SKI_MOGULS: Int = 14
    const val WEIGHTED_SKI_MOGULS: Int = 15
    const val SPLIT_JACKS: Int = 16
    const val WEIGHTED_SPLIT_JACKS: Int = 17
    const val SQUAT_JACKS: Int = 18
    const val WEIGHTED_SQUAT_JACKS: Int = 19
    const val TRIPLE_UNDER: Int = 20
    const val WEIGHTED_TRIPLE_UNDER: Int = 21
    const val ELLIPTICAL: Int = 22
    const val SPINNING: Int = 23
    const val POLE_PADDLE_FORWARD_WHEELCHAIR: Int = 24
    const val POLE_PADDLE_BACKWARD_WHEELCHAIR: Int = 25
    const val POLE_HANDCYCLE_FORWARD_WHEELCHAIR: Int = 26
    const val POLE_HANDCYCLE_BACKWARD_WHEELCHAIR: Int = 27
    const val POLE_RAINBOW_WHEELCHAIR: Int = 28
    const val DOUBLE_PUNCH_FORWARD_WHEELCHAIR: Int = 29
    const val DOUBLE_PUNCH_DOWN_WHEELCHAIR: Int = 30
    const val DOUBLE_PUNCH_SIDEWAYS_WHEELCHAIR: Int = 31
    const val DOUBLE_PUNCH_UP_WHEELCHAIR: Int = 32
    const val SIT_SKI_WHEELCHAIR: Int = 33
    const val SITTING_JACKS_WHEELCHAIR: Int = 34
    const val PUNCH_FORWARD_WHEELCHAIR: Int = 35
    const val PUNCH_DOWN_WHEELCHAIR: Int = 36
    const val PUNCH_SIDEWAYS_WHEELCHAIR: Int = 37
    const val PUNCH_UP_WHEELCHAIR: Int = 38
    const val PUNCH_BAG_WHEELCHAIR: Int = 39
    const val POLE_DD_FF_UU_WHEELCHAIR: Int = 40
    const val BUTTERFLY_ARMS_WHEELCHAIR: Int = 41
    const val PUNCH: Int = 42
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BOB_AND_WEAVE_CIRCLE to "BOB_AND_WEAVE_CIRCLE",
        WEIGHTED_BOB_AND_WEAVE_CIRCLE to "WEIGHTED_BOB_AND_WEAVE_CIRCLE",
        CARDIO_CORE_CRAWL to "CARDIO_CORE_CRAWL",
        WEIGHTED_CARDIO_CORE_CRAWL to "WEIGHTED_CARDIO_CORE_CRAWL",
        DOUBLE_UNDER to "DOUBLE_UNDER",
        WEIGHTED_DOUBLE_UNDER to "WEIGHTED_DOUBLE_UNDER",
        JUMP_ROPE to "JUMP_ROPE",
        WEIGHTED_JUMP_ROPE to "WEIGHTED_JUMP_ROPE",
        JUMP_ROPE_CROSSOVER to "JUMP_ROPE_CROSSOVER",
        WEIGHTED_JUMP_ROPE_CROSSOVER to "WEIGHTED_JUMP_ROPE_CROSSOVER",
        JUMP_ROPE_JOG to "JUMP_ROPE_JOG",
        WEIGHTED_JUMP_ROPE_JOG to "WEIGHTED_JUMP_ROPE_JOG",
        JUMPING_JACKS to "JUMPING_JACKS",
        WEIGHTED_JUMPING_JACKS to "WEIGHTED_JUMPING_JACKS",
        SKI_MOGULS to "SKI_MOGULS",
        WEIGHTED_SKI_MOGULS to "WEIGHTED_SKI_MOGULS",
        SPLIT_JACKS to "SPLIT_JACKS",
        WEIGHTED_SPLIT_JACKS to "WEIGHTED_SPLIT_JACKS",
        SQUAT_JACKS to "SQUAT_JACKS",
        WEIGHTED_SQUAT_JACKS to "WEIGHTED_SQUAT_JACKS",
        TRIPLE_UNDER to "TRIPLE_UNDER",
        WEIGHTED_TRIPLE_UNDER to "WEIGHTED_TRIPLE_UNDER",
        ELLIPTICAL to "ELLIPTICAL",
        SPINNING to "SPINNING",
        POLE_PADDLE_FORWARD_WHEELCHAIR to "POLE_PADDLE_FORWARD_WHEELCHAIR",
        POLE_PADDLE_BACKWARD_WHEELCHAIR to "POLE_PADDLE_BACKWARD_WHEELCHAIR",
        POLE_HANDCYCLE_FORWARD_WHEELCHAIR to "POLE_HANDCYCLE_FORWARD_WHEELCHAIR",
        POLE_HANDCYCLE_BACKWARD_WHEELCHAIR to "POLE_HANDCYCLE_BACKWARD_WHEELCHAIR",
        POLE_RAINBOW_WHEELCHAIR to "POLE_RAINBOW_WHEELCHAIR",
        DOUBLE_PUNCH_FORWARD_WHEELCHAIR to "DOUBLE_PUNCH_FORWARD_WHEELCHAIR",
        DOUBLE_PUNCH_DOWN_WHEELCHAIR to "DOUBLE_PUNCH_DOWN_WHEELCHAIR",
        DOUBLE_PUNCH_SIDEWAYS_WHEELCHAIR to "DOUBLE_PUNCH_SIDEWAYS_WHEELCHAIR",
        DOUBLE_PUNCH_UP_WHEELCHAIR to "DOUBLE_PUNCH_UP_WHEELCHAIR",
        SIT_SKI_WHEELCHAIR to "SIT_SKI_WHEELCHAIR",
        SITTING_JACKS_WHEELCHAIR to "SITTING_JACKS_WHEELCHAIR",
        PUNCH_FORWARD_WHEELCHAIR to "PUNCH_FORWARD_WHEELCHAIR",
        PUNCH_DOWN_WHEELCHAIR to "PUNCH_DOWN_WHEELCHAIR",
        PUNCH_SIDEWAYS_WHEELCHAIR to "PUNCH_SIDEWAYS_WHEELCHAIR",
        PUNCH_UP_WHEELCHAIR to "PUNCH_UP_WHEELCHAIR",
        PUNCH_BAG_WHEELCHAIR to "PUNCH_BAG_WHEELCHAIR",
        POLE_DD_FF_UU_WHEELCHAIR to "POLE_DD_FF_UU_WHEELCHAIR",
        BUTTERFLY_ARMS_WHEELCHAIR to "BUTTERFLY_ARMS_WHEELCHAIR",
        PUNCH to "PUNCH"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
