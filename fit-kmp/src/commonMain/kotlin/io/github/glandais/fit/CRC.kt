// Hand-written multiplatform port of CRC.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

object CRC {
    private val crc16_table = intArrayOf(
        0x0000, 0xCC01, 0xD801, 0x1400, 0xF001, 0x3C00, 0x2800, 0xE401,
        0xA001, 0x6C00, 0x7800, 0xB401, 0x5000, 0x9C01, 0x8801, 0x4400
    )

    fun get16(crc: Int, data: Byte): Int {
        var c = crc
        var tmp: Int

        // compute checksum of lower four bits of byte
        tmp = crc16_table[c and 0x0F]
        c = (c shr 4) and 0x0FFF
        c = c xor tmp xor crc16_table[data.toInt() and 0x0F]

        // now compute checksum of upper four bits of byte
        tmp = crc16_table[c and 0x0F]
        c = (c shr 4) and 0x0FFF
        c = c xor tmp xor crc16_table[(data.toInt() shr 4) and 0x0F]

        return c
    }
}
