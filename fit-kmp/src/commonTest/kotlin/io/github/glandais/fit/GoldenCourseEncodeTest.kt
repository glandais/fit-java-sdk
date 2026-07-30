package io.github.glandais.fit

import io.github.glandais.fit.GoldenCourseFixture.toHexString
import kotlin.math.roundToInt
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * The port's reference test: encode a complete Course file and compare it **byte for byte**
 * against output captured from the Garmin FIT *Java* SDK 21.205.0.
 *
 * Why this test and not a round-trip: a round-trip only proves the port agrees with itself, so a
 * shared misunderstanding of the wire format passes it. These 277 bytes were produced by
 * `com.garmin:fit:21.205.0` (via `BufferEncoder`) and verified against the JavaScript SDK's
 * decoder, so they pin the port to the reference implementation rather than to its own opinion.
 *
 * A failure here means the port and the Java SDK disagree about the file format — message order,
 * field order, local message numbers, scaling, endianness or CRC. It is not a "golden file that
 * needs updating"; regenerate it only from the Java SDK itself.
 */
class GoldenCourseEncodeTest {

    @Test
    fun encodesTheReferenceCourseExactlyLikeTheJavaSdk() {
        assertEquals(
            GoldenCourseFixture.BYTES.toHexString(),
            encodeReferenceCourse().toHexString(),
            "fit-kmp and the Garmin Java SDK disagree on the encoded Course file",
        )
    }

    @Test
    fun theEncodedFileIsSelfConsistent() {
        val bytes = encodeReferenceCourse()
        // isFIT checks the header magic and the file-header CRC.
        assertEquals(
            true,
            DecoderBase.isFIT(bytes),
            "encoder produced a file its own decoder rejects",
        )
    }

    /**
     * Rebuilds the file the reference bytes were captured from.
     *
     * Message order is not free in a Course file: file_id, course, the lap, then a TIMER/START
     * event, the record stream and a TIMER/STOP_ALL. Local message numbers are assigned in
     * first-use order.
     */
    private fun encodeReferenceCourse(): ByteArray {
        val encoder = BufferEncoder(Fit.ProtocolVersion.V2_0)

        encoder.write(
            FileIdMesg().apply {
                localNum = LOCAL_FILE_ID
                type = File.COURSE
                manufacturer = Manufacturer.DYNASTREAM
                product = PRODUCT_ID
                serialNumber = SERIAL_NUMBER
                number = GoldenCourseFixture.COURSE_NAME.hashCode() and 0xFFFF
                timeCreated = fitTime(0)
            },
        )

        encoder.write(
            CourseMesg().apply {
                localNum = LOCAL_COURSE
                name = GoldenCourseFixture.COURSE_NAME
                sport = Sport.CYCLING
            },
        )

        encoder.write(
            LapMesg().apply {
                localNum = LOCAL_LAP
                startTime = fitTime(0)
                // A lap's `timestamp` is its END, not its start — a classic FIT trap.
                timestamp = fitTime(20)
                totalElapsedTime = 20.0f
                totalTimerTime = 20.0f
                totalDistance = 143.0f
                totalAscent = 0
                totalDescent = 1
                avgSpeed = (143.0 / 20.0).toFloat()
            },
        )

        encoder.write(timerEvent(0, EventType.START))
        for (record in RECORDS) {
            encoder.write(
                RecordMesg().apply {
                    localNum = LOCAL_RECORD
                    timestamp = fitTime(record.offsetS)
                    positionLat = degreesToSemicircles(record.latitudeDeg)
                    positionLong = degreesToSemicircles(record.longitudeDeg)
                    distance = record.distanceM.toFloat()
                    altitude = record.altitudeM.toFloat()
                    speed = record.speedMs.toFloat()
                    power = record.powerW
                },
            )
        }
        encoder.write(timerEvent(20, EventType.STOP_ALL))

        return encoder.close()
    }

    private fun timerEvent(
        offsetS: Long,
        type: EventType,
    ): EventMesg =
        EventMesg().apply {
            localNum = LOCAL_EVENT
            event = Event.TIMER
            eventType = type
            eventGroup = 0
            timestamp = fitTime(offsetS)
        }

    private data class Point(
        val offsetS: Long,
        val latitudeDeg: Double,
        val longitudeDeg: Double,
        val altitudeM: Double,
        val distanceM: Double,
        val speedMs: Double,
        val powerW: Int,
    )

    private companion object {
        const val LOCAL_FILE_ID = 0
        const val LOCAL_COURSE = 1
        const val LOCAL_LAP = 2
        const val LOCAL_EVENT = 3
        const val LOCAL_RECORD = 4

        const val PRODUCT_ID = 12345
        const val SERIAL_NUMBER = 12345L

        val RECORDS =
            listOf(
                Point(0, 45.680697, 6.396115, 350.1, 0.0, 0.0, 45),
                Point(10, 45.681335, 6.396195, 349.7, 71.5, 7.15, 260),
                Point(20, 45.681565, 6.396291, 349.5, 143.0, 7.15, 255),
            )

        fun fitTime(offsetS: Long): DateTime =
            DateTime.fromUnixEpochMillis(GoldenCourseFixture.START_UNIX_MS + offsetS * 1000L)

        /** `2^31 / 180` semicircles per degree — FIT's position unit. */
        fun degreesToSemicircles(degrees: Double): Int =
            (degrees * (2147483648.0 / 180.0)).roundToInt()

    }
}
