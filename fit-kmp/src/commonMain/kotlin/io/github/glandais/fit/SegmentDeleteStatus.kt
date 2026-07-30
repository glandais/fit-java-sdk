/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentDeleteStatus.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class SegmentDeleteStatus(rawValue: Int) {
    DO_NOT_DELETE(0),
    DELETE_ONE(1),
    DELETE_ALL(2),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): SegmentDeleteStatus {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: SegmentDeleteStatus): String = value.name
    }
}
