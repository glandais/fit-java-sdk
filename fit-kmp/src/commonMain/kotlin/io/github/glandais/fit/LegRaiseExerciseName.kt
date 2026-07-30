/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LegRaiseExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object LegRaiseExerciseName {
    const val HANGING_KNEE_RAISE: Int = 0
    const val HANGING_LEG_RAISE: Int = 1
    const val WEIGHTED_HANGING_LEG_RAISE: Int = 2
    const val HANGING_SINGLE_LEG_RAISE: Int = 3
    const val WEIGHTED_HANGING_SINGLE_LEG_RAISE: Int = 4
    const val KETTLEBELL_LEG_RAISES: Int = 5
    const val LEG_LOWERING_DRILL: Int = 6
    const val WEIGHTED_LEG_LOWERING_DRILL: Int = 7
    const val LYING_STRAIGHT_LEG_RAISE: Int = 8
    const val WEIGHTED_LYING_STRAIGHT_LEG_RAISE: Int = 9
    const val MEDICINE_BALL_LEG_DROPS: Int = 10
    const val QUADRUPED_LEG_RAISE: Int = 11
    const val WEIGHTED_QUADRUPED_LEG_RAISE: Int = 12
    const val REVERSE_LEG_RAISE: Int = 13
    const val WEIGHTED_REVERSE_LEG_RAISE: Int = 14
    const val REVERSE_LEG_RAISE_ON_SWISS_BALL: Int = 15
    const val WEIGHTED_REVERSE_LEG_RAISE_ON_SWISS_BALL: Int = 16
    const val SINGLE_LEG_LOWERING_DRILL: Int = 17
    const val WEIGHTED_SINGLE_LEG_LOWERING_DRILL: Int = 18
    const val WEIGHTED_HANGING_KNEE_RAISE: Int = 19
    const val LATERAL_STEPOVER: Int = 20
    const val WEIGHTED_LATERAL_STEPOVER: Int = 21
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        HANGING_KNEE_RAISE to "HANGING_KNEE_RAISE",
        HANGING_LEG_RAISE to "HANGING_LEG_RAISE",
        WEIGHTED_HANGING_LEG_RAISE to "WEIGHTED_HANGING_LEG_RAISE",
        HANGING_SINGLE_LEG_RAISE to "HANGING_SINGLE_LEG_RAISE",
        WEIGHTED_HANGING_SINGLE_LEG_RAISE to "WEIGHTED_HANGING_SINGLE_LEG_RAISE",
        KETTLEBELL_LEG_RAISES to "KETTLEBELL_LEG_RAISES",
        LEG_LOWERING_DRILL to "LEG_LOWERING_DRILL",
        WEIGHTED_LEG_LOWERING_DRILL to "WEIGHTED_LEG_LOWERING_DRILL",
        LYING_STRAIGHT_LEG_RAISE to "LYING_STRAIGHT_LEG_RAISE",
        WEIGHTED_LYING_STRAIGHT_LEG_RAISE to "WEIGHTED_LYING_STRAIGHT_LEG_RAISE",
        MEDICINE_BALL_LEG_DROPS to "MEDICINE_BALL_LEG_DROPS",
        QUADRUPED_LEG_RAISE to "QUADRUPED_LEG_RAISE",
        WEIGHTED_QUADRUPED_LEG_RAISE to "WEIGHTED_QUADRUPED_LEG_RAISE",
        REVERSE_LEG_RAISE to "REVERSE_LEG_RAISE",
        WEIGHTED_REVERSE_LEG_RAISE to "WEIGHTED_REVERSE_LEG_RAISE",
        REVERSE_LEG_RAISE_ON_SWISS_BALL to "REVERSE_LEG_RAISE_ON_SWISS_BALL",
        WEIGHTED_REVERSE_LEG_RAISE_ON_SWISS_BALL to "WEIGHTED_REVERSE_LEG_RAISE_ON_SWISS_BALL",
        SINGLE_LEG_LOWERING_DRILL to "SINGLE_LEG_LOWERING_DRILL",
        WEIGHTED_SINGLE_LEG_LOWERING_DRILL to "WEIGHTED_SINGLE_LEG_LOWERING_DRILL",
        WEIGHTED_HANGING_KNEE_RAISE to "WEIGHTED_HANGING_KNEE_RAISE",
        LATERAL_STEPOVER to "LATERAL_STEPOVER",
        WEIGHTED_LATERAL_STEPOVER to "WEIGHTED_LATERAL_STEPOVER"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
