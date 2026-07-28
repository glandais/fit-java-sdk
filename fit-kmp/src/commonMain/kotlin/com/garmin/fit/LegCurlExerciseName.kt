/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LegCurlExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object LegCurlExerciseName {
    const val LEG_CURL: Int = 0
    const val WEIGHTED_LEG_CURL: Int = 1
    const val GOOD_MORNING: Int = 2
    const val SEATED_BARBELL_GOOD_MORNING: Int = 3
    const val SINGLE_LEG_BARBELL_GOOD_MORNING: Int = 4
    const val SINGLE_LEG_SLIDING_LEG_CURL: Int = 5
    const val SLIDING_LEG_CURL: Int = 6
    const val SPLIT_BARBELL_GOOD_MORNING: Int = 7
    const val SPLIT_STANCE_EXTENSION: Int = 8
    const val STAGGERED_STANCE_GOOD_MORNING: Int = 9
    const val SWISS_BALL_HIP_RAISE_AND_LEG_CURL: Int = 10
    const val ZERCHER_GOOD_MORNING: Int = 11
    const val BAND_GOOD_MORNING: Int = 12
    const val BAR_GOOD_MORNING: Int = 13
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        LEG_CURL to "LEG_CURL",
        WEIGHTED_LEG_CURL to "WEIGHTED_LEG_CURL",
        GOOD_MORNING to "GOOD_MORNING",
        SEATED_BARBELL_GOOD_MORNING to "SEATED_BARBELL_GOOD_MORNING",
        SINGLE_LEG_BARBELL_GOOD_MORNING to "SINGLE_LEG_BARBELL_GOOD_MORNING",
        SINGLE_LEG_SLIDING_LEG_CURL to "SINGLE_LEG_SLIDING_LEG_CURL",
        SLIDING_LEG_CURL to "SLIDING_LEG_CURL",
        SPLIT_BARBELL_GOOD_MORNING to "SPLIT_BARBELL_GOOD_MORNING",
        SPLIT_STANCE_EXTENSION to "SPLIT_STANCE_EXTENSION",
        STAGGERED_STANCE_GOOD_MORNING to "STAGGERED_STANCE_GOOD_MORNING",
        SWISS_BALL_HIP_RAISE_AND_LEG_CURL to "SWISS_BALL_HIP_RAISE_AND_LEG_CURL",
        ZERCHER_GOOD_MORNING to "ZERCHER_GOOD_MORNING",
        BAND_GOOD_MORNING to "BAND_GOOD_MORNING",
        BAR_GOOD_MORNING to "BAR_GOOD_MORNING"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
