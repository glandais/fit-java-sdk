/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SuspensionExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object SuspensionExerciseName {
    const val CHEST_FLY: Int = 0
    const val CHEST_PRESS: Int = 1
    const val CRUNCH: Int = 2
    const val CURL: Int = 3
    const val DIP: Int = 4
    const val FACE_PULL: Int = 5
    const val GLUTE_BRIDGE: Int = 6
    const val HAMSTRING_CURL: Int = 7
    const val HIP_DROP: Int = 8
    const val INVERTED_ROW: Int = 9
    const val KNEE_DRIVE_JUMP: Int = 10
    const val KNEE_TO_CHEST: Int = 11
    const val LAT_PULLOVER: Int = 12
    const val LUNGE: Int = 13
    const val MOUNTAIN_CLIMBER: Int = 14
    const val PENDULUM: Int = 15
    const val PIKE: Int = 16
    const val PLANK: Int = 17
    const val POWER_PULL: Int = 18
    const val PULL_UP: Int = 19
    const val PUSH_UP: Int = 20
    const val REVERSE_MOUNTAIN_CLIMBER: Int = 21
    const val REVERSE_PLANK: Int = 22
    const val ROLLOUT: Int = 23
    const val ROW: Int = 24
    const val SIDE_LUNGE: Int = 25
    const val SIDE_PLANK: Int = 26
    const val SINGLE_LEG_DEADLIFT: Int = 27
    const val SINGLE_LEG_SQUAT: Int = 28
    const val SIT_UP: Int = 29
    const val SPLIT: Int = 30
    const val SQUAT: Int = 31
    const val SQUAT_JUMP: Int = 32
    const val TRICEP_PRESS: Int = 33
    const val Y_FLY: Int = 34
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        CHEST_FLY to "CHEST_FLY",
        CHEST_PRESS to "CHEST_PRESS",
        CRUNCH to "CRUNCH",
        CURL to "CURL",
        DIP to "DIP",
        FACE_PULL to "FACE_PULL",
        GLUTE_BRIDGE to "GLUTE_BRIDGE",
        HAMSTRING_CURL to "HAMSTRING_CURL",
        HIP_DROP to "HIP_DROP",
        INVERTED_ROW to "INVERTED_ROW",
        KNEE_DRIVE_JUMP to "KNEE_DRIVE_JUMP",
        KNEE_TO_CHEST to "KNEE_TO_CHEST",
        LAT_PULLOVER to "LAT_PULLOVER",
        LUNGE to "LUNGE",
        MOUNTAIN_CLIMBER to "MOUNTAIN_CLIMBER",
        PENDULUM to "PENDULUM",
        PIKE to "PIKE",
        PLANK to "PLANK",
        POWER_PULL to "POWER_PULL",
        PULL_UP to "PULL_UP",
        PUSH_UP to "PUSH_UP",
        REVERSE_MOUNTAIN_CLIMBER to "REVERSE_MOUNTAIN_CLIMBER",
        REVERSE_PLANK to "REVERSE_PLANK",
        ROLLOUT to "ROLLOUT",
        ROW to "ROW",
        SIDE_LUNGE to "SIDE_LUNGE",
        SIDE_PLANK to "SIDE_PLANK",
        SINGLE_LEG_DEADLIFT to "SINGLE_LEG_DEADLIFT",
        SINGLE_LEG_SQUAT to "SINGLE_LEG_SQUAT",
        SIT_UP to "SIT_UP",
        SPLIT to "SPLIT",
        SQUAT to "SQUAT",
        SQUAT_JUMP to "SQUAT_JUMP",
        TRICEP_PRESS to "TRICEP_PRESS",
        Y_FLY to "Y_FLY"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
