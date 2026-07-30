/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AntChannelId.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

object AntChannelId {
    const val ANT_EXTENDED_DEVICE_NUMBER_UPPER_NIBBLE: Long = -268435456L
    const val ANT_TRANSMISSION_TYPE_LOWER_NIBBLE: Long = 251658240L
    const val ANT_DEVICE_TYPE: Long = 16711680L
    const val ANT_DEVICE_NUMBER: Long = 65535L
    val INVALID: Long = Fit.UINT32Z_INVALID

    private val stringMap: Map<Long, String> = mapOf(
        ANT_EXTENDED_DEVICE_NUMBER_UPPER_NIBBLE to "ANT_EXTENDED_DEVICE_NUMBER_UPPER_NIBBLE",
        ANT_TRANSMISSION_TYPE_LOWER_NIBBLE to "ANT_TRANSMISSION_TYPE_LOWER_NIBBLE",
        ANT_DEVICE_TYPE to "ANT_DEVICE_TYPE",
        ANT_DEVICE_NUMBER to "ANT_DEVICE_NUMBER"
    )

    fun getStringFromValue(value: Long?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Long {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
