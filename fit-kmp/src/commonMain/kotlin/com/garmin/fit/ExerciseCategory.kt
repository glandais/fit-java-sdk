/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ExerciseCategory.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object ExerciseCategory {
    const val BENCH_PRESS: Int = 0
    const val CALF_RAISE: Int = 1
    const val CARDIO: Int = 2
    const val CARRY: Int = 3
    const val CHOP: Int = 4
    const val CORE: Int = 5
    const val CRUNCH: Int = 6
    const val CURL: Int = 7
    const val DEADLIFT: Int = 8
    const val FLYE: Int = 9
    const val HIP_RAISE: Int = 10
    const val HIP_STABILITY: Int = 11
    const val HIP_SWING: Int = 12
    const val HYPEREXTENSION: Int = 13
    const val LATERAL_RAISE: Int = 14
    const val LEG_CURL: Int = 15
    const val LEG_RAISE: Int = 16
    const val LUNGE: Int = 17
    const val OLYMPIC_LIFT: Int = 18
    const val PLANK: Int = 19
    const val PLYO: Int = 20
    const val PULL_UP: Int = 21
    const val PUSH_UP: Int = 22
    const val ROW: Int = 23
    const val SHOULDER_PRESS: Int = 24
    const val SHOULDER_STABILITY: Int = 25
    const val SHRUG: Int = 26
    const val SIT_UP: Int = 27
    const val SQUAT: Int = 28
    const val TOTAL_BODY: Int = 29
    const val TRICEPS_EXTENSION: Int = 30
    const val WARM_UP: Int = 31
    const val RUN: Int = 32
    const val BIKE: Int = 33
    const val CARDIO_SENSORS: Int = 34 // Exercises within workouts that use GPS/sensors rather than rep counting
    const val MOVE: Int = 35
    const val POSE: Int = 36
    const val BANDED_EXERCISES: Int = 37
    const val BATTLE_ROPE: Int = 38
    const val ELLIPTICAL: Int = 39
    const val FLOOR_CLIMB: Int = 40
    const val INDOOR_BIKE: Int = 41
    const val INDOOR_ROW: Int = 42
    const val LADDER: Int = 43
    const val SANDBAG: Int = 44
    const val SLED: Int = 45
    const val SLEDGE_HAMMER: Int = 46
    const val STAIR_STEPPER: Int = 47
    const val SUSPENSION: Int = 49
    const val TIRE: Int = 50
    const val RUN_INDOOR: Int = 52
    const val BIKE_OUTDOOR: Int = 53
    const val UNKNOWN: Int = 65534
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BENCH_PRESS to "BENCH_PRESS",
        CALF_RAISE to "CALF_RAISE",
        CARDIO to "CARDIO",
        CARRY to "CARRY",
        CHOP to "CHOP",
        CORE to "CORE",
        CRUNCH to "CRUNCH",
        CURL to "CURL",
        DEADLIFT to "DEADLIFT",
        FLYE to "FLYE",
        HIP_RAISE to "HIP_RAISE",
        HIP_STABILITY to "HIP_STABILITY",
        HIP_SWING to "HIP_SWING",
        HYPEREXTENSION to "HYPEREXTENSION",
        LATERAL_RAISE to "LATERAL_RAISE",
        LEG_CURL to "LEG_CURL",
        LEG_RAISE to "LEG_RAISE",
        LUNGE to "LUNGE",
        OLYMPIC_LIFT to "OLYMPIC_LIFT",
        PLANK to "PLANK",
        PLYO to "PLYO",
        PULL_UP to "PULL_UP",
        PUSH_UP to "PUSH_UP",
        ROW to "ROW",
        SHOULDER_PRESS to "SHOULDER_PRESS",
        SHOULDER_STABILITY to "SHOULDER_STABILITY",
        SHRUG to "SHRUG",
        SIT_UP to "SIT_UP",
        SQUAT to "SQUAT",
        TOTAL_BODY to "TOTAL_BODY",
        TRICEPS_EXTENSION to "TRICEPS_EXTENSION",
        WARM_UP to "WARM_UP",
        RUN to "RUN",
        BIKE to "BIKE",
        CARDIO_SENSORS to "CARDIO_SENSORS",
        MOVE to "MOVE",
        POSE to "POSE",
        BANDED_EXERCISES to "BANDED_EXERCISES",
        BATTLE_ROPE to "BATTLE_ROPE",
        ELLIPTICAL to "ELLIPTICAL",
        FLOOR_CLIMB to "FLOOR_CLIMB",
        INDOOR_BIKE to "INDOOR_BIKE",
        INDOOR_ROW to "INDOOR_ROW",
        LADDER to "LADDER",
        SANDBAG to "SANDBAG",
        SLED to "SLED",
        SLEDGE_HAMMER to "SLEDGE_HAMMER",
        STAIR_STEPPER to "STAIR_STEPPER",
        SUSPENSION to "SUSPENSION",
        TIRE to "TIRE",
        RUN_INDOOR to "RUN_INDOOR",
        BIKE_OUTDOOR to "BIKE_OUTDOOR",
        UNKNOWN to "UNKNOWN"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
