/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BandedExercisesExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object BandedExercisesExerciseName {
    const val AB_TWIST: Int = 1
    const val BACK_EXTENSION: Int = 2
    const val BICYCLE_CRUNCH: Int = 3
    const val CALF_RAISES: Int = 4
    const val CHEST_PRESS: Int = 5
    const val CLAM_SHELLS: Int = 6
    const val CURL: Int = 7
    const val DEADBUG: Int = 8
    const val DEADLIFT: Int = 9
    const val DONKEY_KICK: Int = 10
    const val EXTERNAL_ROTATION: Int = 11
    const val EXTERNAL_ROTATION_AT_90_DEGREE_ABDUCTION: Int = 12
    const val FACE_PULL: Int = 13
    const val FIRE_HYDRANT: Int = 14
    const val FLY: Int = 15
    const val FRONT_RAISE: Int = 16
    const val GLUTE_BRIDGE: Int = 17
    const val HAMSTRING_CURLS: Int = 18
    const val HIGH_PLANK_LEG_LIFTS: Int = 19
    const val HIP_EXTENSION: Int = 20
    const val INTERNAL_ROTATION: Int = 21
    const val JUMPING_JACK: Int = 22
    const val KNEELING_CRUNCH: Int = 23
    const val LATERAL_BAND_WALKS: Int = 24
    const val LATERAL_RAISE: Int = 25
    const val LATPULL: Int = 26
    const val LEG_ABDUCTION: Int = 27
    const val LEG_ADDUCTION: Int = 28
    const val LEG_EXTENSION: Int = 29
    const val LUNGE: Int = 30
    const val PLANK: Int = 31
    const val PULL_APART: Int = 32
    const val PUSH_UPS: Int = 33
    const val REVERSE_CRUNCH: Int = 34
    const val ROW: Int = 35
    const val SHOULDER_ABDUCTION: Int = 36
    const val SHOULDER_EXTENSION: Int = 37
    const val SHOULDER_EXTERNAL_ROTATION: Int = 38
    const val SHOULDER_FLEXION_TO_90_DEGREES: Int = 39
    const val SIDE_PLANK_LEG_LIFTS: Int = 40
    const val SIDE_RAISE: Int = 41
    const val SQUAT: Int = 42
    const val SQUAT_TO_PRESS: Int = 43
    const val TRICEP_EXTENSION: Int = 44
    const val TRICEP_KICKBACK: Int = 45
    const val UPRIGHT_ROW: Int = 46
    const val WALL_CRAWL_WITH_EXTERNAL_ROTATION: Int = 47
    const val LATERAL_RAISE_WHEELCHAIR: Int = 49
    const val TRICEPS_EXTENSION_WHEELCHAIR: Int = 50
    const val CHEST_FLY_INCLINE_WHEELCHAIR: Int = 51
    const val CHEST_FLY_DECLINE_WHEELCHAIR: Int = 52
    const val PULL_DOWN_WHEELCHAIR: Int = 53
    const val STRAIGHT_ARM_PULL_DOWN_WHEELCHAIR: Int = 54
    const val CURL_WHEELCHAIR: Int = 55
    const val OVERHEAD_CURL_WHEELCHAIR: Int = 56
    const val FACE_PULL_WHEELCHAIR: Int = 57
    const val AROUND_THE_WORLD_WHEELCHAIR: Int = 58
    const val PULL_APART_WHEELCHAIR: Int = 59
    const val SIDE_CURL_WHEELCHAIR: Int = 60
    const val OVERHEAD_PRESS_WHEELCHAIR: Int = 61
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        AB_TWIST to "AB_TWIST",
        BACK_EXTENSION to "BACK_EXTENSION",
        BICYCLE_CRUNCH to "BICYCLE_CRUNCH",
        CALF_RAISES to "CALF_RAISES",
        CHEST_PRESS to "CHEST_PRESS",
        CLAM_SHELLS to "CLAM_SHELLS",
        CURL to "CURL",
        DEADBUG to "DEADBUG",
        DEADLIFT to "DEADLIFT",
        DONKEY_KICK to "DONKEY_KICK",
        EXTERNAL_ROTATION to "EXTERNAL_ROTATION",
        EXTERNAL_ROTATION_AT_90_DEGREE_ABDUCTION to "EXTERNAL_ROTATION_AT_90_DEGREE_ABDUCTION",
        FACE_PULL to "FACE_PULL",
        FIRE_HYDRANT to "FIRE_HYDRANT",
        FLY to "FLY",
        FRONT_RAISE to "FRONT_RAISE",
        GLUTE_BRIDGE to "GLUTE_BRIDGE",
        HAMSTRING_CURLS to "HAMSTRING_CURLS",
        HIGH_PLANK_LEG_LIFTS to "HIGH_PLANK_LEG_LIFTS",
        HIP_EXTENSION to "HIP_EXTENSION",
        INTERNAL_ROTATION to "INTERNAL_ROTATION",
        JUMPING_JACK to "JUMPING_JACK",
        KNEELING_CRUNCH to "KNEELING_CRUNCH",
        LATERAL_BAND_WALKS to "LATERAL_BAND_WALKS",
        LATERAL_RAISE to "LATERAL_RAISE",
        LATPULL to "LATPULL",
        LEG_ABDUCTION to "LEG_ABDUCTION",
        LEG_ADDUCTION to "LEG_ADDUCTION",
        LEG_EXTENSION to "LEG_EXTENSION",
        LUNGE to "LUNGE",
        PLANK to "PLANK",
        PULL_APART to "PULL_APART",
        PUSH_UPS to "PUSH_UPS",
        REVERSE_CRUNCH to "REVERSE_CRUNCH",
        ROW to "ROW",
        SHOULDER_ABDUCTION to "SHOULDER_ABDUCTION",
        SHOULDER_EXTENSION to "SHOULDER_EXTENSION",
        SHOULDER_EXTERNAL_ROTATION to "SHOULDER_EXTERNAL_ROTATION",
        SHOULDER_FLEXION_TO_90_DEGREES to "SHOULDER_FLEXION_TO_90_DEGREES",
        SIDE_PLANK_LEG_LIFTS to "SIDE_PLANK_LEG_LIFTS",
        SIDE_RAISE to "SIDE_RAISE",
        SQUAT to "SQUAT",
        SQUAT_TO_PRESS to "SQUAT_TO_PRESS",
        TRICEP_EXTENSION to "TRICEP_EXTENSION",
        TRICEP_KICKBACK to "TRICEP_KICKBACK",
        UPRIGHT_ROW to "UPRIGHT_ROW",
        WALL_CRAWL_WITH_EXTERNAL_ROTATION to "WALL_CRAWL_WITH_EXTERNAL_ROTATION",
        LATERAL_RAISE_WHEELCHAIR to "LATERAL_RAISE_WHEELCHAIR",
        TRICEPS_EXTENSION_WHEELCHAIR to "TRICEPS_EXTENSION_WHEELCHAIR",
        CHEST_FLY_INCLINE_WHEELCHAIR to "CHEST_FLY_INCLINE_WHEELCHAIR",
        CHEST_FLY_DECLINE_WHEELCHAIR to "CHEST_FLY_DECLINE_WHEELCHAIR",
        PULL_DOWN_WHEELCHAIR to "PULL_DOWN_WHEELCHAIR",
        STRAIGHT_ARM_PULL_DOWN_WHEELCHAIR to "STRAIGHT_ARM_PULL_DOWN_WHEELCHAIR",
        CURL_WHEELCHAIR to "CURL_WHEELCHAIR",
        OVERHEAD_CURL_WHEELCHAIR to "OVERHEAD_CURL_WHEELCHAIR",
        FACE_PULL_WHEELCHAIR to "FACE_PULL_WHEELCHAIR",
        AROUND_THE_WORLD_WHEELCHAIR to "AROUND_THE_WORLD_WHEELCHAIR",
        PULL_APART_WHEELCHAIR to "PULL_APART_WHEELCHAIR",
        SIDE_CURL_WHEELCHAIR to "SIDE_CURL_WHEELCHAIR",
        OVERHEAD_PRESS_WHEELCHAIR to "OVERHEAD_PRESS_WHEELCHAIR"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
