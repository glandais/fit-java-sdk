/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from PullUpExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object PullUpExerciseName {
    const val BANDED_PULL_UPS: Int = 0
    const val _30_DEGREE_LAT_PULLDOWN: Int = 1
    const val BAND_ASSISTED_CHIN_UP: Int = 2
    const val CLOSE_GRIP_CHIN_UP: Int = 3
    const val WEIGHTED_CLOSE_GRIP_CHIN_UP: Int = 4
    const val CLOSE_GRIP_LAT_PULLDOWN: Int = 5
    const val CROSSOVER_CHIN_UP: Int = 6
    const val WEIGHTED_CROSSOVER_CHIN_UP: Int = 7
    const val EZ_BAR_PULLOVER: Int = 8
    const val HANGING_HURDLE: Int = 9
    const val WEIGHTED_HANGING_HURDLE: Int = 10
    const val KNEELING_LAT_PULLDOWN: Int = 11
    const val KNEELING_UNDERHAND_GRIP_LAT_PULLDOWN: Int = 12
    const val LAT_PULLDOWN: Int = 13
    const val MIXED_GRIP_CHIN_UP: Int = 14
    const val WEIGHTED_MIXED_GRIP_CHIN_UP: Int = 15
    const val MIXED_GRIP_PULL_UP: Int = 16
    const val WEIGHTED_MIXED_GRIP_PULL_UP: Int = 17
    const val REVERSE_GRIP_PULLDOWN: Int = 18
    const val STANDING_CABLE_PULLOVER: Int = 19
    const val STRAIGHT_ARM_PULLDOWN: Int = 20
    const val SWISS_BALL_EZ_BAR_PULLOVER: Int = 21
    const val TOWEL_PULL_UP: Int = 22
    const val WEIGHTED_TOWEL_PULL_UP: Int = 23
    const val WEIGHTED_PULL_UP: Int = 24
    const val WIDE_GRIP_LAT_PULLDOWN: Int = 25
    const val WIDE_GRIP_PULL_UP: Int = 26
    const val WEIGHTED_WIDE_GRIP_PULL_UP: Int = 27
    const val BURPEE_PULL_UP: Int = 28
    const val WEIGHTED_BURPEE_PULL_UP: Int = 29
    const val JUMPING_PULL_UPS: Int = 30
    const val WEIGHTED_JUMPING_PULL_UPS: Int = 31
    const val KIPPING_PULL_UP: Int = 32
    const val WEIGHTED_KIPPING_PULL_UP: Int = 33
    const val L_PULL_UP: Int = 34
    const val WEIGHTED_L_PULL_UP: Int = 35
    const val SUSPENDED_CHIN_UP: Int = 36
    const val WEIGHTED_SUSPENDED_CHIN_UP: Int = 37
    const val PULL_UP: Int = 38
    const val CHIN_UP: Int = 39
    const val NEUTRAL_GRIP_CHIN_UP: Int = 40
    const val WEIGHTED_CHIN_UP: Int = 41
    const val BAND_ASSISTED_PULL_UP: Int = 42
    const val NEUTRAL_GRIP_PULL_UP: Int = 43
    const val WEIGHTED_NEUTRAL_GRIP_CHIN_UP: Int = 44
    const val WEIGHTED_NEUTRAL_GRIP_PULL_UP: Int = 45
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BANDED_PULL_UPS to "BANDED_PULL_UPS",
        _30_DEGREE_LAT_PULLDOWN to "_30_DEGREE_LAT_PULLDOWN",
        BAND_ASSISTED_CHIN_UP to "BAND_ASSISTED_CHIN_UP",
        CLOSE_GRIP_CHIN_UP to "CLOSE_GRIP_CHIN_UP",
        WEIGHTED_CLOSE_GRIP_CHIN_UP to "WEIGHTED_CLOSE_GRIP_CHIN_UP",
        CLOSE_GRIP_LAT_PULLDOWN to "CLOSE_GRIP_LAT_PULLDOWN",
        CROSSOVER_CHIN_UP to "CROSSOVER_CHIN_UP",
        WEIGHTED_CROSSOVER_CHIN_UP to "WEIGHTED_CROSSOVER_CHIN_UP",
        EZ_BAR_PULLOVER to "EZ_BAR_PULLOVER",
        HANGING_HURDLE to "HANGING_HURDLE",
        WEIGHTED_HANGING_HURDLE to "WEIGHTED_HANGING_HURDLE",
        KNEELING_LAT_PULLDOWN to "KNEELING_LAT_PULLDOWN",
        KNEELING_UNDERHAND_GRIP_LAT_PULLDOWN to "KNEELING_UNDERHAND_GRIP_LAT_PULLDOWN",
        LAT_PULLDOWN to "LAT_PULLDOWN",
        MIXED_GRIP_CHIN_UP to "MIXED_GRIP_CHIN_UP",
        WEIGHTED_MIXED_GRIP_CHIN_UP to "WEIGHTED_MIXED_GRIP_CHIN_UP",
        MIXED_GRIP_PULL_UP to "MIXED_GRIP_PULL_UP",
        WEIGHTED_MIXED_GRIP_PULL_UP to "WEIGHTED_MIXED_GRIP_PULL_UP",
        REVERSE_GRIP_PULLDOWN to "REVERSE_GRIP_PULLDOWN",
        STANDING_CABLE_PULLOVER to "STANDING_CABLE_PULLOVER",
        STRAIGHT_ARM_PULLDOWN to "STRAIGHT_ARM_PULLDOWN",
        SWISS_BALL_EZ_BAR_PULLOVER to "SWISS_BALL_EZ_BAR_PULLOVER",
        TOWEL_PULL_UP to "TOWEL_PULL_UP",
        WEIGHTED_TOWEL_PULL_UP to "WEIGHTED_TOWEL_PULL_UP",
        WEIGHTED_PULL_UP to "WEIGHTED_PULL_UP",
        WIDE_GRIP_LAT_PULLDOWN to "WIDE_GRIP_LAT_PULLDOWN",
        WIDE_GRIP_PULL_UP to "WIDE_GRIP_PULL_UP",
        WEIGHTED_WIDE_GRIP_PULL_UP to "WEIGHTED_WIDE_GRIP_PULL_UP",
        BURPEE_PULL_UP to "BURPEE_PULL_UP",
        WEIGHTED_BURPEE_PULL_UP to "WEIGHTED_BURPEE_PULL_UP",
        JUMPING_PULL_UPS to "JUMPING_PULL_UPS",
        WEIGHTED_JUMPING_PULL_UPS to "WEIGHTED_JUMPING_PULL_UPS",
        KIPPING_PULL_UP to "KIPPING_PULL_UP",
        WEIGHTED_KIPPING_PULL_UP to "WEIGHTED_KIPPING_PULL_UP",
        L_PULL_UP to "L_PULL_UP",
        WEIGHTED_L_PULL_UP to "WEIGHTED_L_PULL_UP",
        SUSPENDED_CHIN_UP to "SUSPENDED_CHIN_UP",
        WEIGHTED_SUSPENDED_CHIN_UP to "WEIGHTED_SUSPENDED_CHIN_UP",
        PULL_UP to "PULL_UP",
        CHIN_UP to "CHIN_UP",
        NEUTRAL_GRIP_CHIN_UP to "NEUTRAL_GRIP_CHIN_UP",
        WEIGHTED_CHIN_UP to "WEIGHTED_CHIN_UP",
        BAND_ASSISTED_PULL_UP to "BAND_ASSISTED_PULL_UP",
        NEUTRAL_GRIP_PULL_UP to "NEUTRAL_GRIP_PULL_UP",
        WEIGHTED_NEUTRAL_GRIP_CHIN_UP to "WEIGHTED_NEUTRAL_GRIP_CHIN_UP",
        WEIGHTED_NEUTRAL_GRIP_PULL_UP to "WEIGHTED_NEUTRAL_GRIP_PULL_UP"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
