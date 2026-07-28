// Multiplatform support file (no Java counterpart).
// Remplace java.util.UUID (DESIGN.md §2.4).
package com.garmin.fit

class Uuid(val mostSignificantBits: Long, val leastSignificantBits: Long) {

    override fun toString(): String {
        return digits(mostSignificantBits shr 32, 8) + "-" +
            digits(mostSignificantBits shr 16, 4) + "-" +
            digits(mostSignificantBits, 4) + "-" +
            digits(leastSignificantBits shr 48, 4) + "-" +
            digits(leastSignificantBits, 12)
    }

    override fun equals(other: Any?): Boolean {
        if (other !is Uuid) {
            return false
        }
        return mostSignificantBits == other.mostSignificantBits &&
            leastSignificantBits == other.leastSignificantBits
    }

    override fun hashCode(): Int {
        val hilo = mostSignificantBits xor leastSignificantBits
        return (hilo shr 32).toInt() xor hilo.toInt()
    }

    companion object {
        private fun digits(value: Long, count: Int): String {
            val hi = 1L shl (count * 4)
            return (hi or (value and (hi - 1))).toString(16).substring(1)
        }

        fun fromString(name: String): Uuid {
            val parts = name.split("-")
            require(parts.size == 5) { "Invalid UUID string: $name" }
            var msb = parts[0].toLong(16)
            msb = (msb shl 16) or parts[1].toLong(16)
            msb = (msb shl 16) or parts[2].toLong(16)
            var lsb = parts[3].toLong(16)
            lsb = (lsb shl 48) or parts[4].toLong(16)
            return Uuid(msb, lsb)
        }

        /** 16 octets big-endian. */
        fun fromBytes(bytes: ByteArray): Uuid {
            require(bytes.size == 16) { "UUID byte array must be 16 bytes" }
            var msb = 0L
            var lsb = 0L
            for (i in 0..7) {
                msb = (msb shl 8) or (bytes[i].toLong() and 0xFF)
            }
            for (i in 8..15) {
                lsb = (lsb shl 8) or (bytes[i].toLong() and 0xFF)
            }
            return Uuid(msb, lsb)
        }
    }
}
