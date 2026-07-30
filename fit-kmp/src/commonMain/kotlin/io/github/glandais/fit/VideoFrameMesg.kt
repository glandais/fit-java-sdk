/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from VideoFrameMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class VideoFrameMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val FrameNumberFieldNum = 1

        val videoFrameMesg: Mesg = run {
            // video_frame
            val videoFrameMesg = Mesg("video_frame", MesgNum.VIDEO_FRAME)
            videoFrameMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            videoFrameMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            videoFrameMesg.addField(Field("frame_number", FrameNumberFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            videoFrameMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.VIDEO_FRAME))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp
     *
     * @return timestamp
     */
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the timestamp.
     *
     * @return timestamp_ms
     */
    var timestampMs: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timestampMs) {
            setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get frame_number field
     * Comment: Number of the frame that the timestamp and timestamp_ms correlate to
     *
     * @return frame_number
     */
    var frameNumber: Long?
        get() {
            return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(frameNumber) {
            setFieldValue(1, 0, frameNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
