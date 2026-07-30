/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SupportedExdScreenLayouts.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object SupportedExdScreenLayouts {
    const val FULL_SCREEN: Long = 1L
    const val HALF_VERTICAL: Long = 2L
    const val HALF_HORIZONTAL: Long = 4L
    const val HALF_VERTICAL_RIGHT_SPLIT: Long = 8L
    const val HALF_HORIZONTAL_BOTTOM_SPLIT: Long = 16L
    const val FULL_QUARTER_SPLIT: Long = 32L
    const val HALF_VERTICAL_LEFT_SPLIT: Long = 64L
    const val HALF_HORIZONTAL_TOP_SPLIT: Long = 128L
    val INVALID: Long = Fit.UINT32Z_INVALID

    private val stringMap: Map<Long, String> = mapOf(
        FULL_SCREEN to "FULL_SCREEN",
        HALF_VERTICAL to "HALF_VERTICAL",
        HALF_HORIZONTAL to "HALF_HORIZONTAL",
        HALF_VERTICAL_RIGHT_SPLIT to "HALF_VERTICAL_RIGHT_SPLIT",
        HALF_HORIZONTAL_BOTTOM_SPLIT to "HALF_HORIZONTAL_BOTTOM_SPLIT",
        FULL_QUARTER_SPLIT to "FULL_QUARTER_SPLIT",
        HALF_VERTICAL_LEFT_SPLIT to "HALF_VERTICAL_LEFT_SPLIT",
        HALF_HORIZONTAL_TOP_SPLIT to "HALF_HORIZONTAL_TOP_SPLIT"
    )

    fun getStringFromValue(value: Long?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Long {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
