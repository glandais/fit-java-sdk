/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TissueModelType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class TissueModelType(rawValue: Int) {
    ZHL_16C(0),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): TissueModelType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: TissueModelType): String = value.name
    }
}
