/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SledExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

object SledExerciseName {
    const val BACKWARD_DRAG: Int = 0
    const val CHEST_PRESS: Int = 1
    const val FORWARD_DRAG: Int = 2
    const val LOW_PUSH: Int = 3
    const val PUSH: Int = 4
    const val ROW: Int = 5
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        BACKWARD_DRAG to "BACKWARD_DRAG",
        CHEST_PRESS to "CHEST_PRESS",
        FORWARD_DRAG to "FORWARD_DRAG",
        LOW_PUSH to "LOW_PUSH",
        PUSH to "PUSH",
        ROW to "ROW"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
