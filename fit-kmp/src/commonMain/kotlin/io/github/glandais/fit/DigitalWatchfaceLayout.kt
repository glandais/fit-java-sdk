/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DigitalWatchfaceLayout.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class DigitalWatchfaceLayout(rawValue: Int) {
    TRADITIONAL(0),
    MODERN(1),
    BOLD(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DigitalWatchfaceLayout {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DigitalWatchfaceLayout): String = value.name
    }
}
