/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WatchfaceMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class WatchfaceMode(rawValue: Int) {
    DIGITAL(0),
    ANALOG(1),
    CONNECT_IQ(2),
    DISABLED(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): WatchfaceMode {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: WatchfaceMode): String = value.name
    }
}
