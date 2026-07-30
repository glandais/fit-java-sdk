// Hand-written multiplatform port of Checksum.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

object Checksum {
    const val CLEAR: Short = 0 // Allows clear of checksum for flash memory where can only write 1 to 0 without erasing sector.
    const val OK: Short = 1 // Set to mark checksum as valid if computes to invalid values 0 or 0xFF. Checksum can also be set to ok to save encoding computation time.
    val INVALID: Short = Fit.UINT8_INVALID

    private val stringMap: Map<Short, String> = mapOf(
        CLEAR to "CLEAR",
        OK to "OK"
    )

    /**
     * Retrieves the String Representation of the Value
     * @param value The enum constant
     * @return The name of this enum contsant
     */
    fun getStringFromValue(value: Short?): String {
        return stringMap[value] ?: ""
    }

    /**
     * Returns the enum constant with the specified name.
     * @param value The enum string value
     * @return The enum constant or INVALID if unknown
     */
    fun getValueFromString(value: String): Short {
        for ((k, v) in stringMap) {
            if (v == value) {
                return k
            }
        }
        return INVALID
    }
}
