// Hand-written multiplatform port of LocalDateTime.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

class LocalDateTime(private var timestamp: Long) {

    fun equals(dateTime: DateTime): Boolean {
        return this.getTimestamp() == dateTime.getTimestamp()
    }

    fun convertSystemTimeToLocal(offset: Long) {
        if (timestamp < MIN) {
            timestamp += offset
        }
    }

    fun getTimestamp(): Long {
        return timestamp
    }

    /**
     * Replaces getDate(): milliseconds of the local date/time expressed as if it were UTC.
     */
    fun getUnixEpochMillis(): Long {
        return timestamp * 1000 + OFFSET
    }

    /**
     * ISO-8601 representation without zone designator ("yyyy-MM-ddTHH:mm:ss"), the value
     * being a local time. Computed with pure civil-calendar arithmetic.
     */
    override fun toString(): String {
        return formatIso8601(getUnixEpochMillis(), false)
    }

    companion object {
        // if date_time is < 0x10000000 then it is system time (seconds from device power on)
        const val MIN: Long = 0x10000000
        val INVALID: Long = Fit.UINT32_INVALID

        // Offset between Garmin (FIT) time and Unix time in ms (Dec 31, 1989 - 00:00:00 January 1, 1970).
        const val OFFSET: Long = 631065600000L

        private val stringMap: Map<Long, String> = mapOf(
            MIN to "MIN"
        )

        /**
         * Retrieves the String Representation of the Value
         * @param value The enum constant
         * @return The name of this enum contsant
         */
        fun getStringFromValue(value: Long?): String {
            return stringMap[value] ?: ""
        }

        /**
         * Returns the enum constant with the specified name.
         * @param value The enum string value
         * @return The enum constant or INVALID if unknown
         */
        fun getValueFromString(value: String): Long {
            for ((k, v) in stringMap) {
                if (v == value) {
                    return k
                }
            }

            return INVALID
        }

        /**
         * Replaces the LocalDateTime(java.util.Date) constructor.
         */
        fun fromUnixEpochMillis(ms: Long): LocalDateTime {
            return LocalDateTime((ms - OFFSET) / 1000)
        }
    }
}
