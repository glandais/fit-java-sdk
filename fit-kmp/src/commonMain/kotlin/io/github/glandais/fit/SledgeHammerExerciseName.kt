/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SledgeHammerExerciseName.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object SledgeHammerExerciseName {
    const val LATERAL_SWING: Int = 0
    const val HAMMER_SLAM: Int = 1
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        LATERAL_SWING to "LATERAL_SWING",
        HAMMER_SLAM to "HAMMER_SLAM"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
