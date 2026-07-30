// Multiplatform support file (no Java counterpart).
// Lecture binaire little/big-endian sur ByteArray, remplace java.nio.ByteBuffer (DESIGN.md §2.2).
package io.github.glandais.fit

internal fun ByteArray.getInt8(off: Int): Byte = this[off]

internal fun ByteArray.getUInt8(off: Int): Short = (this[off].toInt() and 0xFF).toShort()

internal fun ByteArray.getInt16(off: Int, bigEndian: Boolean): Short {
    val b0 = this[off].toInt() and 0xFF
    val b1 = this[off + 1].toInt() and 0xFF
    return if (bigEndian) {
        ((b0 shl 8) or b1).toShort()
    } else {
        ((b1 shl 8) or b0).toShort()
    }
}

internal fun ByteArray.getUInt16(off: Int, bigEndian: Boolean): Int =
    getInt16(off, bigEndian).toInt() and 0xFFFF

internal fun ByteArray.getInt32(off: Int, bigEndian: Boolean): Int {
    val b0 = this[off].toInt() and 0xFF
    val b1 = this[off + 1].toInt() and 0xFF
    val b2 = this[off + 2].toInt() and 0xFF
    val b3 = this[off + 3].toInt() and 0xFF
    return if (bigEndian) {
        (b0 shl 24) or (b1 shl 16) or (b2 shl 8) or b3
    } else {
        (b3 shl 24) or (b2 shl 16) or (b1 shl 8) or b0
    }
}

internal fun ByteArray.getUInt32(off: Int, bigEndian: Boolean): Long =
    getInt32(off, bigEndian).toLong() and 0xFFFFFFFFL

internal fun ByteArray.getInt64(off: Int, bigEndian: Boolean): Long {
    return if (bigEndian) {
        (getUInt32(off, true) shl 32) or getUInt32(off + 4, true)
    } else {
        (getUInt32(off + 4, false) shl 32) or getUInt32(off, false)
    }
}

internal fun ByteArray.getUInt64(off: Int, bigEndian: Boolean): ULong =
    getInt64(off, bigEndian).toULong()

internal fun ByteArray.getFloat32(off: Int, bigEndian: Boolean): Float =
    Float.fromBits(getInt32(off, bigEndian))

internal fun ByteArray.getFloat64(off: Int, bigEndian: Boolean): Double =
    Double.fromBits(getInt64(off, bigEndian))
