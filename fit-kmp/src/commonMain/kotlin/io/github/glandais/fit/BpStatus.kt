/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BpStatus.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class BpStatus(rawValue: Int) {
    NO_ERROR(0),
    ERROR_INCOMPLETE_DATA(1),
    ERROR_NO_MEASUREMENT(2),
    ERROR_DATA_OUT_OF_RANGE(3),
    ERROR_IRREGULAR_HEART_RATE(4),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): BpStatus {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: BpStatus): String = value.name
    }
}
