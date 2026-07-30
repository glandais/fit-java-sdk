/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FitBaseType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object FitBaseType {
    const val ENUM: Short = 0
    const val SINT8: Short = 1
    const val UINT8: Short = 2
    const val SINT16: Short = 131
    const val UINT16: Short = 132
    const val SINT32: Short = 133
    const val UINT32: Short = 134
    const val STRING: Short = 7
    const val FLOAT32: Short = 136
    const val FLOAT64: Short = 137
    const val UINT8Z: Short = 10
    const val UINT16Z: Short = 139
    const val UINT32Z: Short = 140
    const val BYTE: Short = 13
    const val SINT64: Short = 142
    const val UINT64: Short = 143
    const val UINT64Z: Short = 144
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        ENUM to "ENUM",
        SINT8 to "SINT8",
        UINT8 to "UINT8",
        SINT16 to "SINT16",
        UINT16 to "UINT16",
        SINT32 to "SINT32",
        UINT32 to "UINT32",
        STRING to "STRING",
        FLOAT32 to "FLOAT32",
        FLOAT64 to "FLOAT64",
        UINT8Z to "UINT8Z",
        UINT16Z to "UINT16Z",
        UINT32Z to "UINT32Z",
        BYTE to "BYTE",
        SINT64 to "SINT64",
        UINT64 to "UINT64",
        UINT64Z to "UINT64Z"
    )

    fun getStringFromValue(value: Short?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
