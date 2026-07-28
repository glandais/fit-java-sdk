/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SandbagExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object SandbagExerciseName {
    const val AROUND_THE_WORLD: Int = 0
    const val BACK_SQUAT: Int = 1
    const val BEAR_CRAWL_PULL_THROUGH: Int = 2
    const val BEAR_HUG_SQUAT: Int = 3
    const val CLEAN: Int = 4
    const val CLEAN_AND_PRESS: Int = 5
    const val CURL: Int = 6
    const val FRONT_CARRY: Int = 7
    const val FRONT_SQUAT: Int = 8
    const val LUNGE: Int = 9
    const val OVERHEAD_PRESS: Int = 10
    const val PLANK_PULL_THROUGH: Int = 11
    const val ROTATIONAL_LUNGE: Int = 12
    const val ROW: Int = 13
    const val RUSSIAN_TWIST: Int = 14
    const val SHOULDERING: Int = 15
    const val SHOVELING: Int = 16
    const val SIDE_LUNGE: Int = 17
    const val SPRINT: Int = 18
    const val ZERCHER_SQUAT: Int = 19
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        AROUND_THE_WORLD to "AROUND_THE_WORLD",
        BACK_SQUAT to "BACK_SQUAT",
        BEAR_CRAWL_PULL_THROUGH to "BEAR_CRAWL_PULL_THROUGH",
        BEAR_HUG_SQUAT to "BEAR_HUG_SQUAT",
        CLEAN to "CLEAN",
        CLEAN_AND_PRESS to "CLEAN_AND_PRESS",
        CURL to "CURL",
        FRONT_CARRY to "FRONT_CARRY",
        FRONT_SQUAT to "FRONT_SQUAT",
        LUNGE to "LUNGE",
        OVERHEAD_PRESS to "OVERHEAD_PRESS",
        PLANK_PULL_THROUGH to "PLANK_PULL_THROUGH",
        ROTATIONAL_LUNGE to "ROTATIONAL_LUNGE",
        ROW to "ROW",
        RUSSIAN_TWIST to "RUSSIAN_TWIST",
        SHOULDERING to "SHOULDERING",
        SHOVELING to "SHOVELING",
        SIDE_LUNGE to "SIDE_LUNGE",
        SPRINT to "SPRINT",
        ZERCHER_SQUAT to "ZERCHER_SQUAT"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
