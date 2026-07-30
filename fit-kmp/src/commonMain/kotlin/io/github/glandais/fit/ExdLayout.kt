/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ExdLayout.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class ExdLayout(rawValue: Int) {
    FULL_SCREEN(0),
    HALF_VERTICAL(1),
    HALF_HORIZONTAL(2),
    HALF_VERTICAL_RIGHT_SPLIT(3),
    HALF_HORIZONTAL_BOTTOM_SPLIT(4),
    FULL_QUARTER_SPLIT(5),
    HALF_VERTICAL_LEFT_SPLIT(6),
    HALF_HORIZONTAL_TOP_SPLIT(7),
    DYNAMIC(8),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): ExdLayout {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: ExdLayout): String = value.name
    }
}
