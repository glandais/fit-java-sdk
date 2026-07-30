/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AntNetwork.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

enum class AntNetwork(rawValue: Int) {
    PUBLIC(0),
    ANTPLUS(1),
    ANTFS(2),
    PRIVATE(3),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): AntNetwork {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: AntNetwork): String = value.name
    }
}
