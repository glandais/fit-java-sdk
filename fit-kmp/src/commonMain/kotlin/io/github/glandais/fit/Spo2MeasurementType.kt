/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Spo2MeasurementType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class Spo2MeasurementType(rawValue: Int) {
    OFF_WRIST(0),
    SPOT_CHECK(1),
    CONTINUOUS_CHECK(2),
    PERIODIC(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Spo2MeasurementType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Spo2MeasurementType): String = value.name
    }
}
