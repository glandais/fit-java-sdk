/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from VideoClipMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class VideoClipMesg : Mesg {

    companion object {
        const val ClipNumberFieldNum = 0
        const val StartTimestampFieldNum = 1
        const val StartTimestampMsFieldNum = 2
        const val EndTimestampFieldNum = 3
        const val EndTimestampMsFieldNum = 4
        const val ClipStartFieldNum = 6
        const val ClipEndFieldNum = 7

        val videoClipMesg: Mesg = run {
            // video_clip
            val videoClipMesg = Mesg("video_clip", MesgNum.VIDEO_CLIP)
            videoClipMesg.addField(Field("clip_number", ClipNumberFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            videoClipMesg.addField(Field("start_timestamp", StartTimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            videoClipMesg.addField(Field("start_timestamp_ms", StartTimestampMsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            videoClipMesg.addField(Field("end_timestamp", EndTimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            videoClipMesg.addField(Field("end_timestamp_ms", EndTimestampMsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            videoClipMesg.addField(Field("clip_start", ClipStartFieldNum, 134, 1.0, 0.0, "ms", false, Profile.Type.UINT32))
            videoClipMesg.addField(Field("clip_end", ClipEndFieldNum, 134, 1.0, 0.0, "ms", false, Profile.Type.UINT32))
            videoClipMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.VIDEO_CLIP))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get clip_number field
     *
     * @return clip_number
     */
    fun getClipNumber(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set clip_number field
     *
     * @param clipNumber The new clipNumber value to be set
     */
    fun setClipNumber(clipNumber: Int?) {
        setFieldValue(0, 0, clipNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_timestamp field
     *
     * @return start_timestamp
     */
    fun getStartTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set start_timestamp field
     *
     * @param startTimestamp The new startTimestamp value to be set
     */
    fun setStartTimestamp(startTimestamp: DateTime?) {
        setFieldValue(1, 0, startTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_timestamp_ms field
     *
     * @return start_timestamp_ms
     */
    fun getStartTimestampMs(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set start_timestamp_ms field
     *
     * @param startTimestampMs The new startTimestampMs value to be set
     */
    fun setStartTimestampMs(startTimestampMs: Int?) {
        setFieldValue(2, 0, startTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_timestamp field
     *
     * @return end_timestamp
     */
    fun getEndTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set end_timestamp field
     *
     * @param endTimestamp The new endTimestamp value to be set
     */
    fun setEndTimestamp(endTimestamp: DateTime?) {
        setFieldValue(3, 0, endTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get end_timestamp_ms field
     *
     * @return end_timestamp_ms
     */
    fun getEndTimestampMs(): Int? {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set end_timestamp_ms field
     *
     * @param endTimestampMs The new endTimestampMs value to be set
     */
    fun setEndTimestampMs(endTimestampMs: Int?) {
        setFieldValue(4, 0, endTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get clip_start field
     * Units: ms
     * Comment: Start of clip in video time
     *
     * @return clip_start
     */
    fun getClipStart(): Long? {
        return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set clip_start field
     * Units: ms
     * Comment: Start of clip in video time
     *
     * @param clipStart The new clipStart value to be set
     */
    fun setClipStart(clipStart: Long?) {
        setFieldValue(6, 0, clipStart, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get clip_end field
     * Units: ms
     * Comment: End of clip in video time
     *
     * @return clip_end
     */
    fun getClipEnd(): Long? {
        return getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set clip_end field
     * Units: ms
     * Comment: End of clip in video time
     *
     * @param clipEnd The new clipEnd value to be set
     */
    fun setClipEnd(clipEnd: Long?) {
        setFieldValue(7, 0, clipEnd, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
