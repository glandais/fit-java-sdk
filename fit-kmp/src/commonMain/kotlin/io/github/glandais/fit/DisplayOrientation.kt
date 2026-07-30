/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DisplayOrientation.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class DisplayOrientation(rawValue: Int) {
    AUTO(0),
    PORTRAIT(1),
    LANDSCAPE(2),
    PORTRAIT_FLIPPED(3),
    LANDSCAPE_FLIPPED(4),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DisplayOrientation {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DisplayOrientation): String = value.name
    }
}
