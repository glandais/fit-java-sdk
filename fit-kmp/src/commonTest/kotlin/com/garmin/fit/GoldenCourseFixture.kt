package com.garmin.fit

/**
 * The reference Course file, as produced by the Garmin FIT **Java** SDK 21.205.0.
 *
 * These 277 bytes are the port's contract with the reference implementation: they were captured
 * from `com.garmin:fit:21.205.0` driving `BufferEncoder`, and verified against the JavaScript
 * SDK's decoder. [GoldenCourseEncodeTest] rebuilds them from the fit-kmp API;
 * [DecodeRoundTripTest] reads them back.
 *
 * Do not "update" this to match new output — regenerate it from the Java SDK, or the tests stop
 * testing anything.
 */
object GoldenCourseFixture {

    const val COURSE_NAME = "Col de la Madeleine"

    /** 2026-07-28T08:00:00Z in Unix milliseconds — the reference course's start. */
    const val START_UNIX_MS = 1785225600000L

    val BYTES: ByteArray =
        hex(
            "0e20d552050100002e464954bda040000100000600010001028402028403048c" +
                "0502840404860006000f303900003039f14644cb1580410001001f0205140704" +
                "010001436f6c206465206c61204d6164656c65696e6500024200010013080204" +
                "86fd04860704860804860904861502841602840d02840244cb158044cb159400" +
                "004e2000004e20000037dc000000011bee430001001504000100010100040102" +
                "fd04860300000044cb1580440001001407fd0486000485010485050486020284" +
                "0602840702840444cb1580207beac8048c609000000000109b0000002d0444cb" +
                "158a207c0883048c644b00001bee10991bee01040444cb1594207c133b048c68" +
                "c4000037dc10981bee00ff0300040044cb159439d4",
        )

    fun hex(s: String): ByteArray =
        ByteArray(s.length / 2) { i ->
            ((digit(s[2 * i]) shl 4) or digit(s[2 * i + 1])).toByte()
        }

    fun ByteArray.toHexString(): String {
        val digits = "0123456789abcdef"
        val sb = StringBuilder(size * 2)
        for (b in this) {
            val v = b.toInt() and 0xFF
            sb.append(digits[v shr 4]).append(digits[v and 0x0F])
        }
        return sb.toString()
    }

    private fun digit(c: Char): Int =
        when (c) {
            in '0'..'9' -> c - '0'
            in 'a'..'f' -> c - 'a' + 10
            in 'A'..'F' -> c - 'A' + 10
            else -> throw IllegalArgumentException("not a hex digit: $c")
        }
}
