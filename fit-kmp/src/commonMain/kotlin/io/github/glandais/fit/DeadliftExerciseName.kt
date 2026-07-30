/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DeadliftExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object DeadliftExerciseName {
    const val BARBELL_DEADLIFT: Int = 0
    const val BARBELL_STRAIGHT_LEG_DEADLIFT: Int = 1
    const val DUMBBELL_DEADLIFT: Int = 2
    const val DUMBBELL_SINGLE_LEG_DEADLIFT_TO_ROW: Int = 3
    const val DUMBBELL_STRAIGHT_LEG_DEADLIFT: Int = 4
    const val KETTLEBELL_FLOOR_TO_SHELF: Int = 5
    const val ONE_ARM_ONE_LEG_DEADLIFT: Int = 6
    const val RACK_PULL: Int = 7
    const val ROTATIONAL_DUMBBELL_STRAIGHT_LEG_DEADLIFT: Int = 8
    const val SINGLE_ARM_DEADLIFT: Int = 9
    const val SINGLE_LEG_BARBELL_DEADLIFT: Int = 10
    const val SINGLE_LEG_BARBELL_STRAIGHT_LEG_DEADLIFT: Int = 11
    const val SINGLE_LEG_DEADLIFT_WITH_BARBELL: Int = 12
    const val SINGLE_LEG_RDL_CIRCUIT: Int = 13
    const val SINGLE_LEG_ROMANIAN_DEADLIFT_WITH_DUMBBELL: Int = 14
    const val SUMO_DEADLIFT: Int = 15
    const val SUMO_DEADLIFT_HIGH_PULL: Int = 16
    const val TRAP_BAR_DEADLIFT: Int = 17
    const val WIDE_GRIP_BARBELL_DEADLIFT: Int = 18
    const val KETTLEBELL_DEADLIFT: Int = 20
    const val KETTLEBELL_SUMO_DEADLIFT: Int = 21
    const val ROMANIAN_DEADLIFT: Int = 23
    const val SINGLE_LEG_ROMANIAN_DEADLIFT_CIRCUIT: Int = 24
    const val STRAIGHT_LEG_DEADLIFT: Int = 25
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BARBELL_DEADLIFT to "BARBELL_DEADLIFT",
        BARBELL_STRAIGHT_LEG_DEADLIFT to "BARBELL_STRAIGHT_LEG_DEADLIFT",
        DUMBBELL_DEADLIFT to "DUMBBELL_DEADLIFT",
        DUMBBELL_SINGLE_LEG_DEADLIFT_TO_ROW to "DUMBBELL_SINGLE_LEG_DEADLIFT_TO_ROW",
        DUMBBELL_STRAIGHT_LEG_DEADLIFT to "DUMBBELL_STRAIGHT_LEG_DEADLIFT",
        KETTLEBELL_FLOOR_TO_SHELF to "KETTLEBELL_FLOOR_TO_SHELF",
        ONE_ARM_ONE_LEG_DEADLIFT to "ONE_ARM_ONE_LEG_DEADLIFT",
        RACK_PULL to "RACK_PULL",
        ROTATIONAL_DUMBBELL_STRAIGHT_LEG_DEADLIFT to "ROTATIONAL_DUMBBELL_STRAIGHT_LEG_DEADLIFT",
        SINGLE_ARM_DEADLIFT to "SINGLE_ARM_DEADLIFT",
        SINGLE_LEG_BARBELL_DEADLIFT to "SINGLE_LEG_BARBELL_DEADLIFT",
        SINGLE_LEG_BARBELL_STRAIGHT_LEG_DEADLIFT to "SINGLE_LEG_BARBELL_STRAIGHT_LEG_DEADLIFT",
        SINGLE_LEG_DEADLIFT_WITH_BARBELL to "SINGLE_LEG_DEADLIFT_WITH_BARBELL",
        SINGLE_LEG_RDL_CIRCUIT to "SINGLE_LEG_RDL_CIRCUIT",
        SINGLE_LEG_ROMANIAN_DEADLIFT_WITH_DUMBBELL to "SINGLE_LEG_ROMANIAN_DEADLIFT_WITH_DUMBBELL",
        SUMO_DEADLIFT to "SUMO_DEADLIFT",
        SUMO_DEADLIFT_HIGH_PULL to "SUMO_DEADLIFT_HIGH_PULL",
        TRAP_BAR_DEADLIFT to "TRAP_BAR_DEADLIFT",
        WIDE_GRIP_BARBELL_DEADLIFT to "WIDE_GRIP_BARBELL_DEADLIFT",
        KETTLEBELL_DEADLIFT to "KETTLEBELL_DEADLIFT",
        KETTLEBELL_SUMO_DEADLIFT to "KETTLEBELL_SUMO_DEADLIFT",
        ROMANIAN_DEADLIFT to "ROMANIAN_DEADLIFT",
        SINGLE_LEG_ROMANIAN_DEADLIFT_CIRCUIT to "SINGLE_LEG_ROMANIAN_DEADLIFT_CIRCUIT",
        STRAIGHT_LEG_DEADLIFT to "STRAIGHT_LEG_DEADLIFT"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
