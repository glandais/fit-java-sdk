/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from RadarThreatLevelType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class RadarThreatLevelType(rawValue: Int) {
    THREAT_UNKNOWN(0),
    THREAT_NONE(1),
    THREAT_APPROACHING(2),
    THREAT_APPROACHING_FAST(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): RadarThreatLevelType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: RadarThreatLevelType): String = value.name
    }
}
