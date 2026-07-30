/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ActivityClass.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class ActivityClass(rawValue: Int) {
    LEVEL(0x7F),
    LEVEL_MAX(100),
    ATHLETE(0x80),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): ActivityClass {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: ActivityClass): String = value.name
    }
}
