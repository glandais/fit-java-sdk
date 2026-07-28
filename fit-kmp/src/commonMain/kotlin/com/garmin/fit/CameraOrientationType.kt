/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CameraOrientationType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class CameraOrientationType(rawValue: Int) {
    CAMERA_ORIENTATION_0(0),
    CAMERA_ORIENTATION_90(1),
    CAMERA_ORIENTATION_180(2),
    CAMERA_ORIENTATION_270(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): CameraOrientationType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: CameraOrientationType): String = value.name
    }
}
