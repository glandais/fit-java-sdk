// Hand-written multiplatform port of DateTime.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

import kotlin.math.floor
import kotlin.math.roundToLong

class DateTime : Comparable<DateTime> {
    private var timestamp: Long
    private var fractionalTimestamp: Double

    constructor(timestamp: Long) {
        this.timestamp = timestamp
        this.fractionalTimestamp = 0.0
    }

    constructor(timestamp: Long, fractionalTimestamp: Double) {
        this.timestamp = timestamp + floor(fractionalTimestamp).toLong()
        this.fractionalTimestamp = fractionalTimestamp - floor(fractionalTimestamp)
    }

    constructor(timestamp: DateTime) : this(timestamp.getTimestamp(), timestamp.getFractionalTimestamp())

    fun equals(dateTime: DateTime): Boolean {
        return this.getTimestamp() == dateTime.getTimestamp() &&
            this.getFractionalTimestamp() == dateTime.getFractionalTimestamp()
    }

    fun convertSystemTimeToUTC(offset: Long) {
        if (timestamp < MIN) {
            timestamp += offset
        }
    }

    fun getFractionalTimestamp(): Double {
        return this.fractionalTimestamp
    }

    fun getTimestamp(): Long {
        return timestamp
    }

    /**
     * Replaces getDate() / getInstant(): milliseconds since the Unix epoch.
     */
    fun getUnixEpochMillis(): Long {
        // Express fractional component in (nearest) ms
        val fractionalMs = (fractionalTimestamp * 1000).roundToLong()

        return (timestamp * 1000) + fractionalMs + OFFSET
    }

    /**
     * ISO-8601 UTC representation ("yyyy-MM-ddTHH:mm:ssZ"), computed with pure
     * civil-calendar arithmetic (no java.time / java.util.Date).
     */
    override fun toString(): String {
        return formatIso8601(getUnixEpochMillis(), true)
    }

    fun add(dateTime: DateTime) {
        this.timestamp += dateTime.getTimestamp()
        this.fractionalTimestamp += dateTime.getFractionalTimestamp()

        // Adjust fractional part to be less that 1
        this.timestamp += floor(this.fractionalTimestamp).toLong()
        this.fractionalTimestamp -= floor(this.fractionalTimestamp).toFloat()
    }

    fun add(timestamp: Long) {
        this.add(DateTime(timestamp))
    }

    fun add(fractionalTimestamp: Double) {
        this.add(DateTime(0, fractionalTimestamp))
    }

    // returns 0 if t1 is equal to target object; a value less that 0 if target object is numerically less t1
    // a value greater than 0 if target object is numerically greater than t1
    override fun compareTo(other: DateTime): Int {
        // fractional_timestamp is guaranteed to be less that 1 which allows simplified comparison below
        return if (this.timestamp == other.getTimestamp()) {
            // Timestamps are equal; must compare fractional part.
            this.fractionalTimestamp.compareTo(other.getFractionalTimestamp())
        } else if (this.timestamp > other.getTimestamp()) {
            1
        } else {
            -1
        }
    }

    fun after(t1: DateTime): Boolean {
        return compareTo(t1) > 0
    }

    fun before(t1: DateTime): Boolean {
        return compareTo(t1) < 0
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
         * Replaces the DateTime(java.util.Date) / DateTime(Instant) constructors.
         */
        fun fromUnixEpochMillis(ms: Long): DateTime {
            return DateTime((ms - OFFSET) / 1000, ((ms - OFFSET) % 1000) / 1000.0)
        }
    }
}

/**
 * Formats a Unix epoch millisecond value as "yyyy-MM-ddTHH:mm:ss" (+ "Z" when [utc]).
 * Pure civil arithmetic (Howard Hinnant's days_from_civil inverse), no platform date API.
 */
internal fun formatIso8601(epochMillis: Long, utc: Boolean): String {
    val msPerDay = 86400000L
    var days = epochMillis / msPerDay
    var msOfDay = epochMillis % msPerDay
    if (msOfDay < 0) {
        msOfDay += msPerDay
        days -= 1
    }

    var z = days + 719468
    val era = (if (z >= 0) z else z - 146096) / 146097
    val doe = z - era * 146097
    val yoe = (doe - doe / 1460 + doe / 36524 - doe / 146096) / 365
    var y = yoe + era * 400
    val doy = doe - (365 * yoe + yoe / 4 - yoe / 100)
    val mp = (5 * doy + 2) / 153
    val d = doy - (153 * mp + 2) / 5 + 1
    val m = if (mp < 10) mp + 3 else mp - 9
    if (m <= 2) {
        y += 1
    }

    val secOfDay = msOfDay / 1000
    val hh = secOfDay / 3600
    val mm = (secOfDay % 3600) / 60
    val ss = secOfDay % 60

    val sb = StringBuilder()
    sb.append(pad(y, 4)).append('-').append(pad(m, 2)).append('-').append(pad(d, 2))
    sb.append('T')
    sb.append(pad(hh, 2)).append(':').append(pad(mm, 2)).append(':').append(pad(ss, 2))
    if (utc) {
        sb.append('Z')
    }
    return sb.toString()
}

private fun pad(value: Long, width: Int): String {
    val negative = value < 0
    var s = (if (negative) -value else value).toString()
    while (s.length < width) {
        s = "0$s"
    }
    return if (negative) "-$s" else s
}
