/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BattleRopeExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object BattleRopeExerciseName {
    const val ALTERNATING_FIGURE_EIGHT: Int = 0
    const val ALTERNATING_JUMP_WAVE: Int = 1
    const val ALTERNATING_KNEELING_TO_STANDING_WAVE: Int = 2
    const val ALTERNATING_LUNGE_WAVE: Int = 3
    const val ALTERNATING_SQUAT_WAVE: Int = 4
    const val ALTERNATING_WAVE: Int = 5
    const val ALTERNATING_WAVE_WITH_LATERAL_SHUFFLE: Int = 6
    const val CLAP_WAVE: Int = 7
    const val DOUBLE_ARM_FIGURE_EIGHT: Int = 8
    const val DOUBLE_ARM_SIDE_TO_SIDE_SNAKE: Int = 9
    const val DOUBLE_ARM_SIDE_WAVE: Int = 10
    const val DOUBLE_ARM_SLAM: Int = 11
    const val DOUBLE_ARM_WAVE: Int = 12
    const val GRAPPLER_TOSS: Int = 13
    const val HIP_TOSS: Int = 14
    const val IN_AND_OUT_WAVE: Int = 15
    const val INSIDE_CIRCLE: Int = 16
    const val JUMPING_JACKS: Int = 17
    const val OUTSIDE_CIRCLE: Int = 18
    const val RAINBOW: Int = 19
    const val SIDE_PLANK_WAVE: Int = 20
    const val SIDEWINDER: Int = 21
    const val SITTING_RUSSIAN_TWIST: Int = 22
    const val SNAKE_WAVE: Int = 23
    const val SPLIT_JACK: Int = 24
    const val STAGE_COACH: Int = 25
    const val ULTIMATE_WARRIOR: Int = 26
    const val UPPER_CUTS: Int = 27
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        ALTERNATING_FIGURE_EIGHT to "ALTERNATING_FIGURE_EIGHT",
        ALTERNATING_JUMP_WAVE to "ALTERNATING_JUMP_WAVE",
        ALTERNATING_KNEELING_TO_STANDING_WAVE to "ALTERNATING_KNEELING_TO_STANDING_WAVE",
        ALTERNATING_LUNGE_WAVE to "ALTERNATING_LUNGE_WAVE",
        ALTERNATING_SQUAT_WAVE to "ALTERNATING_SQUAT_WAVE",
        ALTERNATING_WAVE to "ALTERNATING_WAVE",
        ALTERNATING_WAVE_WITH_LATERAL_SHUFFLE to "ALTERNATING_WAVE_WITH_LATERAL_SHUFFLE",
        CLAP_WAVE to "CLAP_WAVE",
        DOUBLE_ARM_FIGURE_EIGHT to "DOUBLE_ARM_FIGURE_EIGHT",
        DOUBLE_ARM_SIDE_TO_SIDE_SNAKE to "DOUBLE_ARM_SIDE_TO_SIDE_SNAKE",
        DOUBLE_ARM_SIDE_WAVE to "DOUBLE_ARM_SIDE_WAVE",
        DOUBLE_ARM_SLAM to "DOUBLE_ARM_SLAM",
        DOUBLE_ARM_WAVE to "DOUBLE_ARM_WAVE",
        GRAPPLER_TOSS to "GRAPPLER_TOSS",
        HIP_TOSS to "HIP_TOSS",
        IN_AND_OUT_WAVE to "IN_AND_OUT_WAVE",
        INSIDE_CIRCLE to "INSIDE_CIRCLE",
        JUMPING_JACKS to "JUMPING_JACKS",
        OUTSIDE_CIRCLE to "OUTSIDE_CIRCLE",
        RAINBOW to "RAINBOW",
        SIDE_PLANK_WAVE to "SIDE_PLANK_WAVE",
        SIDEWINDER to "SIDEWINDER",
        SITTING_RUSSIAN_TWIST to "SITTING_RUSSIAN_TWIST",
        SNAKE_WAVE to "SNAKE_WAVE",
        SPLIT_JACK to "SPLIT_JACK",
        STAGE_COACH to "STAGE_COACH",
        ULTIMATE_WARRIOR to "ULTIMATE_WARRIOR",
        UPPER_CUTS to "UPPER_CUTS"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
