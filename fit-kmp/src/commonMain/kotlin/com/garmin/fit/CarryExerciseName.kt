/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CarryExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object CarryExerciseName {
    const val BAR_HOLDS: Int = 0
    const val FARMERS_WALK: Int = 1
    const val FARMERS_WALK_ON_TOES: Int = 2
    const val HEX_DUMBBELL_HOLD: Int = 3
    const val OVERHEAD_CARRY: Int = 4
    const val DUMBBELL_WAITER_CARRY: Int = 5
    const val FARMERS_CARRY_WALK_LUNGE: Int = 6
    const val FARMERS_CARRY: Int = 7
    const val FARMERS_CARRY_ON_TOES: Int = 8
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BAR_HOLDS to "BAR_HOLDS",
        FARMERS_WALK to "FARMERS_WALK",
        FARMERS_WALK_ON_TOES to "FARMERS_WALK_ON_TOES",
        HEX_DUMBBELL_HOLD to "HEX_DUMBBELL_HOLD",
        OVERHEAD_CARRY to "OVERHEAD_CARRY",
        DUMBBELL_WAITER_CARRY to "DUMBBELL_WAITER_CARRY",
        FARMERS_CARRY_WALK_LUNGE to "FARMERS_CARRY_WALK_LUNGE",
        FARMERS_CARRY to "FARMERS_CARRY",
        FARMERS_CARRY_ON_TOES to "FARMERS_CARRY_ON_TOES"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
