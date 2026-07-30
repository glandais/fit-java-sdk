/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from File.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class File(rawValue: Int) {
    DEVICE(1),
    SETTINGS(2),
    SPORT(3),
    ACTIVITY(4),
    WORKOUT(5),
    COURSE(6),
    SCHEDULES(7),
    WEIGHT(9),
    TOTALS(10),
    GOALS(11),
    BLOOD_PRESSURE(14),
    MONITORING_A(15),
    ACTIVITY_SUMMARY(20),
    MONITORING_DAILY(28),
    MONITORING_B(32),
    SEGMENT(34),
    SEGMENT_LIST(35),
    EXD_CONFIGURATION(40),
    MFG_RANGE_MIN(0xF7),
    MFG_RANGE_MAX(0xFE),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): File {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: File): String = value.name
    }
}
