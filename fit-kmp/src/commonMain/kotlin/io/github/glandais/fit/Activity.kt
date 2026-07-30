/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Activity.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class Activity(rawValue: Int) {
    MANUAL(0),
    AUTO_MULTI_SPORT(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Activity {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Activity): String = value.name
    }
}
