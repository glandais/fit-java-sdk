/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CcrSetpointSwitchMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class CcrSetpointSwitchMode(rawValue: Int) {
    MANUAL(0),
    AUTOMATIC(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): CcrSetpointSwitchMode {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: CcrSetpointSwitchMode): String = value.name
    }
}
