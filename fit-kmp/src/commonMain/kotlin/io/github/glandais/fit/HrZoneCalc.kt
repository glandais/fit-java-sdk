/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HrZoneCalc.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class HrZoneCalc(rawValue: Int) {
    CUSTOM(0),
    PERCENT_MAX_HR(1),
    PERCENT_HRR(2),
    PERCENT_LTHR(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): HrZoneCalc {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: HrZoneCalc): String = value.name
    }
}
