/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DiveBacklightMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class DiveBacklightMode(rawValue: Int) {
    AT_DEPTH(0),
    ALWAYS_ON(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DiveBacklightMode {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DiveBacklightMode): String = value.name
    }
}
