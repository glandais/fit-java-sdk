/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FitnessEquipmentState.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class FitnessEquipmentState(rawValue: Int) {
    READY(0),
    IN_USE(1),
    PAUSED(2),
    UNKNOWN(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): FitnessEquipmentState {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: FitnessEquipmentState): String = value.name
    }
}
