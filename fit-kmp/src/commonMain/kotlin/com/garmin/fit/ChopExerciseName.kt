/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ChopExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object ChopExerciseName {
    const val CABLE_PULL_THROUGH: Int = 0
    const val CABLE_ROTATIONAL_LIFT: Int = 1
    const val CABLE_WOODCHOP: Int = 2
    const val CROSS_CHOP_TO_KNEE: Int = 3
    const val WEIGHTED_CROSS_CHOP_TO_KNEE: Int = 4
    const val DUMBBELL_CHOP: Int = 5
    const val HALF_KNEELING_ROTATION: Int = 6
    const val WEIGHTED_HALF_KNEELING_ROTATION: Int = 7
    const val HALF_KNEELING_ROTATIONAL_CHOP: Int = 8
    const val HALF_KNEELING_ROTATIONAL_REVERSE_CHOP: Int = 9
    const val HALF_KNEELING_STABILITY_CHOP: Int = 10
    const val HALF_KNEELING_STABILITY_REVERSE_CHOP: Int = 11
    const val KNEELING_ROTATIONAL_CHOP: Int = 12
    const val KNEELING_ROTATIONAL_REVERSE_CHOP: Int = 13
    const val KNEELING_STABILITY_CHOP: Int = 14
    const val KNEELING_WOODCHOPPER: Int = 15
    const val MEDICINE_BALL_WOOD_CHOPS: Int = 16
    const val POWER_SQUAT_CHOPS: Int = 17
    const val WEIGHTED_POWER_SQUAT_CHOPS: Int = 18
    const val STANDING_ROTATIONAL_CHOP: Int = 19
    const val STANDING_SPLIT_ROTATIONAL_CHOP: Int = 20
    const val STANDING_SPLIT_ROTATIONAL_REVERSE_CHOP: Int = 21
    const val STANDING_STABILITY_REVERSE_CHOP: Int = 22
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        CABLE_PULL_THROUGH to "CABLE_PULL_THROUGH",
        CABLE_ROTATIONAL_LIFT to "CABLE_ROTATIONAL_LIFT",
        CABLE_WOODCHOP to "CABLE_WOODCHOP",
        CROSS_CHOP_TO_KNEE to "CROSS_CHOP_TO_KNEE",
        WEIGHTED_CROSS_CHOP_TO_KNEE to "WEIGHTED_CROSS_CHOP_TO_KNEE",
        DUMBBELL_CHOP to "DUMBBELL_CHOP",
        HALF_KNEELING_ROTATION to "HALF_KNEELING_ROTATION",
        WEIGHTED_HALF_KNEELING_ROTATION to "WEIGHTED_HALF_KNEELING_ROTATION",
        HALF_KNEELING_ROTATIONAL_CHOP to "HALF_KNEELING_ROTATIONAL_CHOP",
        HALF_KNEELING_ROTATIONAL_REVERSE_CHOP to "HALF_KNEELING_ROTATIONAL_REVERSE_CHOP",
        HALF_KNEELING_STABILITY_CHOP to "HALF_KNEELING_STABILITY_CHOP",
        HALF_KNEELING_STABILITY_REVERSE_CHOP to "HALF_KNEELING_STABILITY_REVERSE_CHOP",
        KNEELING_ROTATIONAL_CHOP to "KNEELING_ROTATIONAL_CHOP",
        KNEELING_ROTATIONAL_REVERSE_CHOP to "KNEELING_ROTATIONAL_REVERSE_CHOP",
        KNEELING_STABILITY_CHOP to "KNEELING_STABILITY_CHOP",
        KNEELING_WOODCHOPPER to "KNEELING_WOODCHOPPER",
        MEDICINE_BALL_WOOD_CHOPS to "MEDICINE_BALL_WOOD_CHOPS",
        POWER_SQUAT_CHOPS to "POWER_SQUAT_CHOPS",
        WEIGHTED_POWER_SQUAT_CHOPS to "WEIGHTED_POWER_SQUAT_CHOPS",
        STANDING_ROTATIONAL_CHOP to "STANDING_ROTATIONAL_CHOP",
        STANDING_SPLIT_ROTATIONAL_CHOP to "STANDING_SPLIT_ROTATIONAL_CHOP",
        STANDING_SPLIT_ROTATIONAL_REVERSE_CHOP to "STANDING_SPLIT_ROTATIONAL_REVERSE_CHOP",
        STANDING_STABILITY_REVERSE_CHOP to "STANDING_STABILITY_REVERSE_CHOP"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
