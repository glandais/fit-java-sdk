/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MesgCount.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class MesgCount(rawValue: Int) {
    NUM_PER_FILE(0),
    MAX_PER_FILE(1),
    MAX_PER_FILE_TYPE(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): MesgCount {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: MesgCount): String = value.name
    }
}
