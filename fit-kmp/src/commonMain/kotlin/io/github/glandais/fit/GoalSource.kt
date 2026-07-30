/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from GoalSource.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class GoalSource(rawValue: Int) {
    AUTO(0),
    COMMUNITY(1),
    USER(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): GoalSource {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: GoalSource): String = value.name
    }
}
