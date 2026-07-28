// Hand-written multiplatform port of ByteArrayDataInputStream.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

/**
 * ByteArrayInputStream with added functionality similar to the Data InputStream class
 */
class ByteArrayDataInputStream(buf: ByteArray) : ByteArrayInputStream(buf) {

    /**
     * Returns the current stream position
     *
     * @return the current stream position
     */
    fun getPosition(): Int {
        return pos
    }

    /**
     * Returns the next available byte without changing the current stream position
     *
     * @return A byte representing the next value to be read
     */
    fun peek(): Byte {
        return buf[pos]
    }

    /**
     * Reads an unsigned short value from the stream as little endian
     *
     * @return an int value representing an unsigned short value read from the stream as little endian
     */
    fun readUShort(): Int {
        var value = read() and 0xFF
        value = value or ((read() and 0xFF) shl 8)
        return value and 0xFFFF
    }
}
