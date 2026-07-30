// Multiplatform support file (no Java counterpart).
// Shims homonymes des classes java.io utilisées par le SDK (DESIGN.md §2.1).
package io.github.glandais.fit

import kotlin.jvm.JvmOverloads

open class IOException(message: String? = null, cause: Throwable? = null) :
    Exception(message, cause)

abstract class InputStream {
    /** Retourne l'octet lu (0..255) ou -1 en fin de flux. */
    abstract fun read(): Int

    open fun read(b: ByteArray): Int = read(b, 0, b.size)

    open fun read(b: ByteArray, off: Int, len: Int): Int {
        if (off < 0 || len < 0 || len > b.size - off) {
            throw IndexOutOfBoundsException()
        }
        if (len == 0) {
            return 0
        }
        var i = 0
        while (i < len) {
            val c = read()
            if (c == -1) {
                return if (i == 0) -1 else i
            }
            b[off + i] = c.toByte()
            i++
        }
        return i
    }

    open fun available(): Int = 0

    open fun skip(n: Long): Long {
        var remaining = n
        while (remaining > 0) {
            if (read() == -1) {
                break
            }
            remaining--
        }
        return n - remaining
    }

    open fun mark(readlimit: Int) {}

    open fun reset() {
        throw IOException("mark/reset not supported")
    }

    open fun markSupported(): Boolean = false

    open fun close() {}
}

// @JvmOverloads : sans lui, un appelant Java devrait passer les trois arguments —
// `new ByteArrayInputStream(bytes)` est la forme que tout le monde écrit.
open class ByteArrayInputStream
    @JvmOverloads
    constructor(
        protected val buf: ByteArray,
        offset: Int = 0,
        length: Int = buf.size
    ) : InputStream() {
    protected var pos: Int = offset
    protected var markPos: Int = offset
    protected val count: Int = minOf(offset + length, buf.size)

    override fun read(): Int {
        return if (pos < count) buf[pos++].toInt() and 0xFF else -1
    }

    override fun read(b: ByteArray, off: Int, len: Int): Int {
        if (off < 0 || len < 0 || len > b.size - off) {
            throw IndexOutOfBoundsException()
        }
        if (pos >= count) {
            return -1
        }
        val n = minOf(len, count - pos)
        if (n <= 0) {
            return 0
        }
        buf.copyInto(b, destinationOffset = off, startIndex = pos, endIndex = pos + n)
        pos += n
        return n
    }

    override fun available(): Int = count - pos

    override fun skip(n: Long): Long {
        var k = (count - pos).toLong()
        if (n < k) {
            k = if (n < 0) 0 else n
        }
        pos += k.toInt()
        return k
    }

    override fun mark(readlimit: Int) {
        markPos = pos
    }

    override fun reset() {
        pos = markPos
    }

    override fun markSupported(): Boolean = true
}

abstract class OutputStream {
    /** Écrit l'octet bas de b. */
    abstract fun write(b: Int)

    open fun write(b: ByteArray) = write(b, 0, b.size)

    open fun write(b: ByteArray, off: Int, len: Int) {
        if (off < 0 || len < 0 || len > b.size - off) {
            throw IndexOutOfBoundsException()
        }
        for (i in 0 until len) {
            write(b[off + i].toInt())
        }
    }

    open fun flush() {}

    open fun close() {}
}

open class ByteArrayOutputStream(initialCapacity: Int = 32) : OutputStream() {
    private var buf: ByteArray = ByteArray(if (initialCapacity > 0) initialCapacity else 32)
    private var count: Int = 0

    private fun ensureCapacity(minCapacity: Int) {
        if (minCapacity > buf.size) {
            var newSize = buf.size * 2
            if (newSize < minCapacity) {
                newSize = minCapacity
            }
            buf = buf.copyOf(newSize)
        }
    }

    override fun write(b: Int) {
        ensureCapacity(count + 1)
        buf[count] = b.toByte()
        count++
    }

    override fun write(b: ByteArray, off: Int, len: Int) {
        if (off < 0 || len < 0 || len > b.size - off) {
            throw IndexOutOfBoundsException()
        }
        ensureCapacity(count + len)
        b.copyInto(buf, destinationOffset = count, startIndex = off, endIndex = off + len)
        count += len
    }

    fun toByteArray(): ByteArray = buf.copyOf(count)

    fun size(): Int = count

    fun reset() {
        count = 0
    }
}

class DataOutputStream(private val out: OutputStream) : OutputStream() {
    private var written: Int = 0

    override fun write(b: Int) {
        out.write(b)
        written++
    }

    override fun write(b: ByteArray, off: Int, len: Int) {
        out.write(b, off, len)
        written += len
    }

    fun writeByte(v: Int) = write(v)

    /** Nombre d'octets écrits via ce flux (comme java.io.DataOutputStream.size()). */
    fun size(): Int = written

    override fun flush() = out.flush()

    override fun close() = out.close()
}
