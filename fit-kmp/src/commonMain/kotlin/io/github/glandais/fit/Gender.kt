/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Gender.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class Gender(rawValue: Int) {
    FEMALE(0),
    MALE(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Gender {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Gender): String = value.name
    }
}
