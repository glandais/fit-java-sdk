/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ActivitySubtype.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class ActivitySubtype(rawValue: Int) {
    GENERIC(0),
    TREADMILL(1),
    STREET(2),
    TRAIL(3),
    TRACK(4),
    SPIN(5),
    INDOOR_CYCLING(6),
    ROAD(7),
    MOUNTAIN(8),
    DOWNHILL(9),
    RECUMBENT(10),
    CYCLOCROSS(11),
    HAND_CYCLING(12),
    TRACK_CYCLING(13),
    INDOOR_ROWING(14),
    ELLIPTICAL(15),
    STAIR_CLIMBING(16),
    LAP_SWIMMING(17),
    OPEN_WATER(18),
    ALL(254),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): ActivitySubtype {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: ActivitySubtype): String = value.name
    }
}
