/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentLeaderboardType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class SegmentLeaderboardType(rawValue: Int) {
    OVERALL(0),
    PERSONAL_BEST(1),
    CONNECTIONS(2),
    GROUP(3),
    CHALLENGER(4),
    KOM(5),
    QOM(6),
    PR(7),
    GOAL(8),
    CARROT(9),
    CLUB_LEADER(10),
    RIVAL(11),
    LAST(12),
    RECENT_BEST(13),
    COURSE_RECORD(14),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SegmentLeaderboardType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SegmentLeaderboardType): String = value.name
    }
}
