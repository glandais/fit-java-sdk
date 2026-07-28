/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentLapStatus.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class SegmentLapStatus(rawValue: Int) {
    END(0),
    FAIL(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SegmentLapStatus {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SegmentLapStatus): String = value.name
    }
}
