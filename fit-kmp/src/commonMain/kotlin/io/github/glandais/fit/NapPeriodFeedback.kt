/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from NapPeriodFeedback.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class NapPeriodFeedback(rawValue: Int) {
    NONE(0),
    MULTIPLE_NAPS_DURING_DAY(1),
    JETLAG_IDEAL_TIMING_IDEAL_DURATION(2),
    JETLAG_IDEAL_TIMING_LONG_DURATION(3),
    JETLAG_LATE_TIMING_IDEAL_DURATION(4),
    JETLAG_LATE_TIMING_LONG_DURATION(5),
    IDEAL_TIMING_IDEAL_DURATION_LOW_NEED(6),
    IDEAL_TIMING_IDEAL_DURATION_HIGH_NEED(7),
    IDEAL_TIMING_LONG_DURATION_LOW_NEED(8),
    IDEAL_TIMING_LONG_DURATION_HIGH_NEED(9),
    LATE_TIMING_IDEAL_DURATION_LOW_NEED(10),
    LATE_TIMING_IDEAL_DURATION_HIGH_NEED(11),
    LATE_TIMING_LONG_DURATION_LOW_NEED(12),
    LATE_TIMING_LONG_DURATION_HIGH_NEED(13),
    IDEAL_DURATION_LOW_NEED(14),
    IDEAL_DURATION_HIGH_NEED(15),
    LONG_DURATION_LOW_NEED(16),
    LONG_DURATION_HIGH_NEED(17),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): NapPeriodFeedback {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: NapPeriodFeedback): String = value.name
    }
}
