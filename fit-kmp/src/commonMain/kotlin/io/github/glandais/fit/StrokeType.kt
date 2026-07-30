/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from StrokeType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class StrokeType(rawValue: Int) {
    NO_EVENT(0),
    OTHER(1),
    SERVE(2),
    FOREHAND(3),
    BACKHAND(4),
    SMASH(5),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): StrokeType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: StrokeType): String = value.name
    }
}
