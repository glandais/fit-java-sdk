/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AttitudeStage.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class AttitudeStage(rawValue: Int) {
    FAILED(0),
    ALIGNING(1),
    DEGRADED(2),
    VALID(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): AttitudeStage {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: AttitudeStage): String = value.name
    }
}
