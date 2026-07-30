/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FaveroProduct.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object FaveroProduct {
    const val ASSIOMA_UNO: Int = 10
    const val ASSIOMA_DUO: Int = 12
    val INVALID: Int = Fit.UINT16_INVALID

    private val stringMap: Map<Int, String> = mapOf(
        ASSIOMA_UNO to "ASSIOMA_UNO",
        ASSIOMA_DUO to "ASSIOMA_DUO"
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
