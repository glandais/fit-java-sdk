/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SitUpExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object SitUpExerciseName {
    const val ALTERNATING_SIT_UP: Int = 0
    const val WEIGHTED_ALTERNATING_SIT_UP: Int = 1
    const val BENT_KNEE_V_UP: Int = 2
    const val WEIGHTED_BENT_KNEE_V_UP: Int = 3
    const val BUTTERFLY_SIT_UP: Int = 4
    const val WEIGHTED_BUTTERFLY_SITUP: Int = 5
    const val CROSS_PUNCH_ROLL_UP: Int = 6
    const val WEIGHTED_CROSS_PUNCH_ROLL_UP: Int = 7
    const val CROSSED_ARMS_SIT_UP: Int = 8
    const val WEIGHTED_CROSSED_ARMS_SIT_UP: Int = 9
    const val GET_UP_SIT_UP: Int = 10
    const val WEIGHTED_GET_UP_SIT_UP: Int = 11
    const val HOVERING_SIT_UP: Int = 12
    const val WEIGHTED_HOVERING_SIT_UP: Int = 13
    const val KETTLEBELL_SIT_UP: Int = 14
    const val MEDICINE_BALL_ALTERNATING_V_UP: Int = 15
    const val MEDICINE_BALL_SIT_UP: Int = 16
    const val MEDICINE_BALL_V_UP: Int = 17
    const val MODIFIED_SIT_UP: Int = 18
    const val NEGATIVE_SIT_UP: Int = 19
    const val ONE_ARM_FULL_SIT_UP: Int = 20
    const val RECLINING_CIRCLE: Int = 21
    const val WEIGHTED_RECLINING_CIRCLE: Int = 22
    const val REVERSE_CURL_UP: Int = 23
    const val WEIGHTED_REVERSE_CURL_UP: Int = 24
    const val SINGLE_LEG_SWISS_BALL_JACKKNIFE: Int = 25
    const val WEIGHTED_SINGLE_LEG_SWISS_BALL_JACKKNIFE: Int = 26
    const val THE_TEASER: Int = 27
    const val THE_TEASER_WEIGHTED: Int = 28
    const val THREE_PART_ROLL_DOWN: Int = 29
    const val WEIGHTED_THREE_PART_ROLL_DOWN: Int = 30
    const val V_UP: Int = 31
    const val WEIGHTED_V_UP: Int = 32
    const val WEIGHTED_RUSSIAN_TWIST_ON_SWISS_BALL: Int = 33
    const val WEIGHTED_SIT_UP: Int = 34
    const val X_ABS: Int = 35
    const val WEIGHTED_X_ABS: Int = 36
    const val SIT_UP: Int = 37
    const val GHD_SIT_UPS: Int = 38
    const val SIT_UP_TURKISH_GET_UP: Int = 39
    const val RUSSIAN_TWIST_ON_SWISS_BALL: Int = 40
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        ALTERNATING_SIT_UP to "ALTERNATING_SIT_UP",
        WEIGHTED_ALTERNATING_SIT_UP to "WEIGHTED_ALTERNATING_SIT_UP",
        BENT_KNEE_V_UP to "BENT_KNEE_V_UP",
        WEIGHTED_BENT_KNEE_V_UP to "WEIGHTED_BENT_KNEE_V_UP",
        BUTTERFLY_SIT_UP to "BUTTERFLY_SIT_UP",
        WEIGHTED_BUTTERFLY_SITUP to "WEIGHTED_BUTTERFLY_SITUP",
        CROSS_PUNCH_ROLL_UP to "CROSS_PUNCH_ROLL_UP",
        WEIGHTED_CROSS_PUNCH_ROLL_UP to "WEIGHTED_CROSS_PUNCH_ROLL_UP",
        CROSSED_ARMS_SIT_UP to "CROSSED_ARMS_SIT_UP",
        WEIGHTED_CROSSED_ARMS_SIT_UP to "WEIGHTED_CROSSED_ARMS_SIT_UP",
        GET_UP_SIT_UP to "GET_UP_SIT_UP",
        WEIGHTED_GET_UP_SIT_UP to "WEIGHTED_GET_UP_SIT_UP",
        HOVERING_SIT_UP to "HOVERING_SIT_UP",
        WEIGHTED_HOVERING_SIT_UP to "WEIGHTED_HOVERING_SIT_UP",
        KETTLEBELL_SIT_UP to "KETTLEBELL_SIT_UP",
        MEDICINE_BALL_ALTERNATING_V_UP to "MEDICINE_BALL_ALTERNATING_V_UP",
        MEDICINE_BALL_SIT_UP to "MEDICINE_BALL_SIT_UP",
        MEDICINE_BALL_V_UP to "MEDICINE_BALL_V_UP",
        MODIFIED_SIT_UP to "MODIFIED_SIT_UP",
        NEGATIVE_SIT_UP to "NEGATIVE_SIT_UP",
        ONE_ARM_FULL_SIT_UP to "ONE_ARM_FULL_SIT_UP",
        RECLINING_CIRCLE to "RECLINING_CIRCLE",
        WEIGHTED_RECLINING_CIRCLE to "WEIGHTED_RECLINING_CIRCLE",
        REVERSE_CURL_UP to "REVERSE_CURL_UP",
        WEIGHTED_REVERSE_CURL_UP to "WEIGHTED_REVERSE_CURL_UP",
        SINGLE_LEG_SWISS_BALL_JACKKNIFE to "SINGLE_LEG_SWISS_BALL_JACKKNIFE",
        WEIGHTED_SINGLE_LEG_SWISS_BALL_JACKKNIFE to "WEIGHTED_SINGLE_LEG_SWISS_BALL_JACKKNIFE",
        THE_TEASER to "THE_TEASER",
        THE_TEASER_WEIGHTED to "THE_TEASER_WEIGHTED",
        THREE_PART_ROLL_DOWN to "THREE_PART_ROLL_DOWN",
        WEIGHTED_THREE_PART_ROLL_DOWN to "WEIGHTED_THREE_PART_ROLL_DOWN",
        V_UP to "V_UP",
        WEIGHTED_V_UP to "WEIGHTED_V_UP",
        WEIGHTED_RUSSIAN_TWIST_ON_SWISS_BALL to "WEIGHTED_RUSSIAN_TWIST_ON_SWISS_BALL",
        WEIGHTED_SIT_UP to "WEIGHTED_SIT_UP",
        X_ABS to "X_ABS",
        WEIGHTED_X_ABS to "WEIGHTED_X_ABS",
        SIT_UP to "SIT_UP",
        GHD_SIT_UPS to "GHD_SIT_UPS",
        SIT_UP_TURKISH_GET_UP to "SIT_UP_TURKISH_GET_UP",
        RUSSIAN_TWIST_ON_SWISS_BALL to "RUSSIAN_TWIST_ON_SWISS_BALL"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
