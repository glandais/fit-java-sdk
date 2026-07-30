package io.github.glandais.fit

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Decoding side of the port: feed the encoder's own output back through [FitDecoder] and check
 * that every value survives the wire format.
 *
 * [GoldenCourseEncodeTest] proves the *bytes* match the Garmin Java SDK; this proves the decoder
 * reads them back into the values that went in, so a symmetric bug in scaling or endianness
 * cannot hide.
 */
class DecodeRoundTripTest {

    private fun decodeReference(): FitMessages =
        FitDecoder().decode(ByteArrayInputStream(GoldenCourseFixture.BYTES))

    @Test
    fun fileIdSurvivesTheRoundTrip() {
        val fileId = decodeReference().fileIdMesgs.single()
        assertEquals(File.COURSE, fileId.type)
        assertEquals(Manufacturer.DYNASTREAM, fileId.manufacturer)
        assertEquals(12345, fileId.product)
        assertEquals(12345L, fileId.serialNumber)
    }

    @Test
    fun courseNameAndSportSurviveTheRoundTrip() {
        val course = decodeReference().courseMesgs.single()
        // Regression guard: `name` on a generated mesg must reach the FIT field, not the
        // message's own identity — see the comment on Mesg.mesgName.
        assertEquals("Col de la Madeleine", course.name)
        assertEquals(Sport.CYCLING, course.sport)
    }

    @Test
    fun lapTotalsSurviveTheRoundTrip() {
        val lap = decodeReference().lapMesgs.single()
        assertEquals(20.0f, lap.totalElapsedTime)
        assertEquals(20.0f, lap.totalTimerTime)
        assertEquals(143.0f, lap.totalDistance)
        assertEquals(0, lap.totalAscent)
        assertEquals(1, lap.totalDescent)
    }

    @Test
    fun recordsSurviveTheRoundTripIncludingScaledFields() {
        val records = decodeReference().recordMesgs
        assertEquals(3, records.size)

        val first = records.first()
        assertNear(0.0, first.distance)
        assertEquals(45, first.power)
        // Altitude is stored as (m + 500) * 5, i.e. quantised to 0.2 m: 350.1 is not
        // representable and comes back as 350.2. Asserting the quantised value on purpose —
        // this is the FIT format, not a rounding bug in the port.
        assertNear(350.2, first.altitude)

        val last = records.last()
        assertNear(143.0, last.distance)
        assertEquals(255, last.power)
        // speed is stored as m/s * 1000, i.e. millimetres per second.
        assertNear(7.15, last.speed)

        // Position is carried in semicircles; convert back and allow one ULP of the unit.
        val degrees = last.positionLat!! / (2147483648.0 / 180.0)
        assertTrue(
            kotlin.math.abs(degrees - 45.681565) < 1e-6,
            "latitude round-tripped to $degrees",
        )
    }

    @Test
    fun timerEventsBracketTheRecords() {
        val events = decodeReference().eventMesgs
        assertEquals(2, events.size)
        assertEquals(Event.TIMER, events.first().event)
        assertEquals(EventType.START, events.first().eventType)
        assertEquals(EventType.STOP_ALL, events.last().eventType)
    }

    @Test
    fun timestampsSurviveTheRoundTrip() {
        val records = decodeReference().recordMesgs
        val first = records.first().timestamp!!
        val last = records.last().timestamp!!
        assertEquals(20L, last.getTimestamp() - first.getTimestamp())
        assertEquals(GoldenCourseFixture.START_UNIX_MS, first.getUnixEpochMillis())
    }

    /** Ported from the Java SDK's own `DecoderTest` / `TestData`. */
    @Test
    fun isFitRecognisesTheSdkSampleAndRejectsGarbage() {
        assertTrue(DecoderBase.isFIT(SDK_SAMPLE_FILE))
        assertFalse(DecoderBase.isFIT(ByteArray(0)))
        assertFalse(DecoderBase.isFIT(ByteArray(32)))
    }

    private companion object {
        /**
         * Compare a scaled float field with a tolerance.
         *
         * Kotlin/JS has no 32-bit float: `Float` is a JS `number` (a double), so the scaled
         * getters' arithmetic keeps double precision there and `350.2f` on the JVM is
         * `350.20000000000005` on JS. Both are the same FIT value; only the representation
         * differs, so an exact comparison would test the target, not the port.
         */
        fun assertNear(
            expected: Double,
            actual: Float?,
            tolerance: Double = 1e-4,
        ) {
            val value = actual?.toDouble()
            assertTrue(
                value != null && kotlin.math.abs(value - expected) < tolerance,
                "expected ~$expected but was $value",
            )
        }

        /** `TestData.fitFileShort` from `src/test/java/com/garmin/fit/TestData.java`. */
        val SDK_SAMPLE_FILE: ByteArray =
            byteArrayOf(
                0x0E, 0x20, 0x8B.toByte(), 0x08, 0x24, 0x00, 0x00, 0x00,
                0x2E, 0x46, 0x49, 0x54, 0x8E.toByte(), 0xA3.toByte(),
                0x40, 0x00, 0x00, 0x00, 0x00, 0x04, 0x00, 0x01, 0x00, 0x01,
                0x02, 0x84.toByte(), 0x04, 0x04, 0x86.toByte(), 0x08, 0x0A, 0x07,
                0x00, 0x04, 0x01, 0x00, 0x00, 0xCA.toByte(), 0x9A.toByte(), 0x3B,
                0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x00,
                0x5D, 0xF2.toByte(),
            )
    }
}
