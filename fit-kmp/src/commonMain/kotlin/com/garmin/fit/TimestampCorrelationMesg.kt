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
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get fractional_timestamp field
     * Units: s
     * Comment: Fractional part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @return fractional_timestamp
     */
    var fractionalTimestamp: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fractionalTimestamp) {
            setFieldValue(0, 0, fractionalTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get system_timestamp field
     * Units: s
     * Comment: Whole second part of the system timestamp
     *
     * @return system_timestamp
     */
    var systemTimestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(systemTimestamp) {
            setFieldValue(1, 0, systemTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get fractional_system_timestamp field
     * Units: s
     * Comment: Fractional part of the system timestamp
     *
     * @return fractional_system_timestamp
     */
    var fractionalSystemTimestamp: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fractionalSystemTimestamp) {
            setFieldValue(2, 0, fractionalSystemTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get local_timestamp field
     * Units: s
     * Comment: timestamp epoch expressed in local time used to convert timestamps to local time
     *
     * @return local_timestamp
     */
    var localTimestamp: Long?
        get() {
            return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(localTimestamp) {
            setFieldValue(3, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the UTC timestamp at the time the system timestamp was recorded.
     *
     * @return timestamp_ms
     */
    var timestampMs: Int?
        get() {
            return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timestampMs) {
            setFieldValue(4, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get system_timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the system timestamp
     *
     * @return system_timestamp_ms
     */
    var systemTimestampMs: Int?
        get() {
            return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(systemTimestampMs) {
            setFieldValue(5, 0, systemTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
