/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FileFlags.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object FileFlags {
    const val READ: Short = 2
    const val WRITE: Short = 4
    const val ERASE: Short = 8
    val INVALID: Short = Fit.UINT8Z_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        READ to "READ",
        WRITE to "WRITE",
        ERASE to "ERASE"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
