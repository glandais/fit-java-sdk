/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from GoalRecurrence.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class GoalRecurrence(rawValue: Int) {
    OFF(0),
    DAILY(1),
    WEEKLY(2),
    MONTHLY(3),
    YEARLY(4),
    CUSTOM(5),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): GoalRecurrence {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: GoalRecurrence): String = value.name
    }
}
