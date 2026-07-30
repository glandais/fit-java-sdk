/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentSelectionType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class SegmentSelectionType(rawValue: Int) {
    STARRED(0),
    SUGGESTED(1),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SegmentSelectionType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SegmentSelectionType): String = value.name
    }
}
