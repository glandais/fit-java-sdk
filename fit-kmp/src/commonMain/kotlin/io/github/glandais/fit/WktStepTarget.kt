/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WktStepTarget.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class WktStepTarget(rawValue: Int) {
    SPEED(0),
    HEART_RATE(1),
    OPEN(2),
    CADENCE(3),
    POWER(4),
    GRADE(5),
    RESISTANCE(6),
    POWER_3S(7),
    POWER_10S(8),
    POWER_30S(9),
    POWER_LAP(10),
    SWIM_STROKE(11),
    SPEED_LAP(12),
    HEART_RATE_LAP(13),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): WktStepTarget {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: WktStepTarget): String = value.name
    }
}
