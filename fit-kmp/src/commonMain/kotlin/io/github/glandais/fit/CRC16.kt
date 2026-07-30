// Hand-written multiplatform port of CRC16.java — keep in sync (see overrides/hashes.json).
// Note: the java.util.zip.Checksum interface is dropped (DESIGN.md §2.5); the API is otherwise identical.
package io.github.glandais.fit

class CRC16 {

    private var crc: Int = 0

    init {
        reset()
    }

    fun getValue(): Long {
        return crc.toLong()
    }

    fun reset() {
        crc = 0
    }

    fun update(b: Int) {
        var tmp: Int
        // compute checksum of lower four bits of byte
        tmp = crc16_table[crc and 0x0F]
        crc = (crc shr 4) and 0x0FFF
        crc = crc xor tmp xor crc16_table[b and 0x0F]

        // now compute checksum of upper four bits of byte
        tmp = crc16_table[crc and 0x0F]
        crc = (crc shr 4) and 0x0FFF
        crc = crc xor tmp xor crc16_table[(b shr 4) and 0x0F]
    }

    // NOTE: faithful to the Java original, `len` is treated as an END index
    // (the loop runs while off < len), not as a byte count. Every call site in
    // the SDK passes off = 0, so behaviour is identical.
    fun update(bytes: ByteArray, off: Int, len: Int) {
        var i = off
        while (i < len) {
            update(bytes[i].toInt())
            i++
        }
    }

    companion object {
        private val crc16_table = intArrayOf(
            0x0000, 0xCC01, 0xD801, 0x1400, 0xF001, 0x3C00, 0x2800, 0xE401,
            0xA001, 0x6C00, 0x7800, 0xB401, 0x5000, 0x9C01, 0x8801, 0x4400
        )
    }
}
