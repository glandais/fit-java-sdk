/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DiveGasStatus.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class DiveGasStatus(rawValue: Int) {
    DISABLED(0),
    ENABLED(1),
    BACKUP_ONLY(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): DiveGasStatus {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: DiveGasStatus): String = value.name
    }
}
