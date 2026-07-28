/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BeatIntervalsMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class BeatIntervalsMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val TimeFieldNum = 1

        val beatIntervalsMesg: Mesg = run {
            // beat_intervals
            val beatIntervalsMesg = Mesg("beat_intervals", MesgNum.BEAT_INTERVALS)
            beatIntervalsMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            beatIntervalsMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            beatIntervalsMesg.addField(Field("time", TimeFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            beatIntervalsMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.BEAT_INTERVALS))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Milliseconds past date_time
     *
     * @return timestamp_ms
     */
    fun getTimestampMs(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Milliseconds past date_time
     *
     * @param timestampMs The new timestampMs value to be set
     */
    fun setTimestampMs(timestampMs: Int?) {
        setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTime(): Array<Int?>? {
        return getFieldIntegerValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time
     */
    fun getNumTime(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time field
     * Units: ms
     * Comment: Array of millisecond times between beats
     *
     * @param index of time
     * @return time
     */
    fun getTime(index: Int): Int? {
        return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time field
     * Units: ms
     * Comment: Array of millisecond times between beats
     *
     * @param index of time
     * @param time The new time value to be set
     */
    fun setTime(index: Int, time: Int?) {
        setFieldValue(1, index, time, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
