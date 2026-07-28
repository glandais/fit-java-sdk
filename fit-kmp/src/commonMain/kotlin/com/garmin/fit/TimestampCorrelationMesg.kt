/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TimestampCorrelationMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class TimestampCorrelationMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val FractionalTimestampFieldNum = 0
        const val SystemTimestampFieldNum = 1
        const val FractionalSystemTimestampFieldNum = 2
        const val LocalTimestampFieldNum = 3
        const val TimestampMsFieldNum = 4
        const val SystemTimestampMsFieldNum = 5

        val timestampCorrelationMesg: Mesg = run {
            // timestamp_correlation
            val timestampCorrelationMesg = Mesg("timestamp_correlation", MesgNum.TIMESTAMP_CORRELATION)
            timestampCorrelationMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            timestampCorrelationMesg.addField(Field("fractional_timestamp", FractionalTimestampFieldNum, 132, 32768.0, 0.0, "s", false, Profile.Type.UINT16))
            timestampCorrelationMesg.addField(Field("system_timestamp", SystemTimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            timestampCorrelationMesg.addField(Field("fractional_system_timestamp", FractionalSystemTimestampFieldNum, 132, 32768.0, 0.0, "s", false, Profile.Type.UINT16))
            timestampCorrelationMesg.addField(Field("local_timestamp", LocalTimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.LOCAL_DATE_TIME))
            timestampCorrelationMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            timestampCorrelationMesg.addField(Field("system_timestamp_ms", SystemTimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            timestampCorrelationMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.TIMESTAMP_CORRELATION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of UTC timestamp at the time the system timestamp was recorded.
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Whole second part of UTC timestamp at the time the system timestamp was recorded.
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get fractional_timestamp field
     * Units: s
     * Comment: Fractional part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @return fractional_timestamp
     */
    fun getFractionalTimestamp(): Float? {
        return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set fractional_timestamp field
     * Units: s
     * Comment: Fractional part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @param fractionalTimestamp The new fractionalTimestamp value to be set
     */
    fun setFractionalTimestamp(fractionalTimestamp: Float?) {
        setFieldValue(0, 0, fractionalTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get system_timestamp field
     * Units: s
     * Comment: Whole second part of the system timestamp
     *
     * @return system_timestamp
     */
    fun getSystemTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set system_timestamp field
     * Units: s
     * Comment: Whole second part of the system timestamp
     *
     * @param systemTimestamp The new systemTimestamp value to be set
     */
    fun setSystemTimestamp(systemTimestamp: DateTime?) {
        setFieldValue(1, 0, systemTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get fractional_system_timestamp field
     * Units: s
     * Comment: Fractional part of the system timestamp
     *
     * @return fractional_system_timestamp
     */
    fun getFractionalSystemTimestamp(): Float? {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set fractional_system_timestamp field
     * Units: s
     * Comment: Fractional part of the system timestamp
     *
     * @param fractionalSystemTimestamp The new fractionalSystemTimestamp value to be set
     */
    fun setFractionalSystemTimestamp(fractionalSystemTimestamp: Float?) {
        setFieldValue(2, 0, fractionalSystemTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get local_timestamp field
     * Units: s
     * Comment: timestamp epoch expressed in local time used to convert timestamps to local time
     *
     * @return local_timestamp
     */
    fun getLocalTimestamp(): Long? {
        return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set local_timestamp field
     * Units: s
     * Comment: timestamp epoch expressed in local time used to convert timestamps to local time
     *
     * @param localTimestamp The new localTimestamp value to be set
     */
    fun setLocalTimestamp(localTimestamp: Long?) {
        setFieldValue(3, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @return timestamp_ms
     */
    fun getTimestampMs(): Int? {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @param timestampMs The new timestampMs value to be set
     */
    fun setTimestampMs(timestampMs: Int?) {
        setFieldValue(4, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get system_timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the system timestamp
     *
     * @return system_timestamp_ms
     */
    fun getSystemTimestampMs(): Int? {
        return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set system_timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the system timestamp
     *
     * @param systemTimestampMs The new systemTimestampMs value to be set
     */
    fun setSystemTimestampMs(systemTimestampMs: Int?) {
        setFieldValue(5, 0, systemTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
