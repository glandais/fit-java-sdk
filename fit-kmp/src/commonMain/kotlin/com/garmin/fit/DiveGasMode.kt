/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DiveGasMode.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class DiveGasMode(rawValue: Int) {
    OPEN_CIRCUIT(0),
    CLOSED_CIRCUIT_DILUENT(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DiveGasMode {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DiveGasMode): String = value.name
    }
}
