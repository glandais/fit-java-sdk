/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SwimStroke.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class SwimStroke(rawValue: Int) {
    FREESTYLE(0),
    BACKSTROKE(1),
    BREASTSTROKE(2),
    BUTTERFLY(3),
    DRILL(4),
    MIXED(5),
    IM(6),
    IM_BY_ROUND(7),
    RIMO(8),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SwimStroke {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SwimStroke): String = value.name
    }
}
