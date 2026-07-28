/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CameraEventType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class CameraEventType(rawValue: Int) {
    VIDEO_START(0),
    VIDEO_SPLIT(1),
    VIDEO_END(2),
    PHOTO_TAKEN(3),
    VIDEO_SECOND_STREAM_START(4),
    VIDEO_SECOND_STREAM_SPLIT(5),
    VIDEO_SECOND_STREAM_END(6),
    VIDEO_SPLIT_START(7),
    VIDEO_SECOND_STREAM_SPLIT_START(8),
    VIDEO_PAUSE(11),
    VIDEO_SECOND_STREAM_PAUSE(12),
    VIDEO_RESUME(13),
    VIDEO_SECOND_STREAM_RESUME(14),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): CameraEventType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: CameraEventType): String = value.name
    }
}
