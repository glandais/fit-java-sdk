/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from GasConsumptionRateType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class GasConsumptionRateType(rawValue: Int) {
    PRESSURE_SAC(0),
    VOLUME_SAC(1),
    RMV(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): GasConsumptionRateType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: GasConsumptionRateType): String = value.name
    }
}
