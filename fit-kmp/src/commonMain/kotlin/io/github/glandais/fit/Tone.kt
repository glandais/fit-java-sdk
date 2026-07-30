/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Tone.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class Tone(rawValue: Int) {
    OFF(0),
    TONE(1),
    VIBRATE(2),
    TONE_AND_VIBRATE(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Tone {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Tone): String = value.name
    }
}
