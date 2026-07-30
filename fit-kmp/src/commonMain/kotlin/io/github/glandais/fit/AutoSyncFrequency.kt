/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AutoSyncFrequency.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class AutoSyncFrequency(rawValue: Int) {
    NEVER(0),
    OCCASIONALLY(1),
    FREQUENT(2),
    ONCE_A_DAY(3),
    REMOTE(4),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): AutoSyncFrequency {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: AutoSyncFrequency): String = value.name
    }
}
