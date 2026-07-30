/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BikeLightNetworkConfigType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class BikeLightNetworkConfigType(rawValue: Int) {
    AUTO(0),
    INDIVIDUAL(4),
    HIGH_VISIBILITY(5),
    TRAIL(6),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): BikeLightNetworkConfigType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: BikeLightNetworkConfigType): String = value.name
    }
}
