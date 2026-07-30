/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Intensity.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class Intensity(rawValue: Int) {
    ACTIVE(0),
    REST(1),
    WARMUP(2),
    COOLDOWN(3),
    RECOVERY(4),
    INTERVAL(5),
    OTHER(6),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Intensity {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Intensity): String = value.name
    }
}
