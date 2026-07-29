/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ObdiiDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ObdiiDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val TimeOffsetFieldNum = 1
        const val PidFieldNum = 2
        const val RawDataFieldNum = 3
        const val PidDataSizeFieldNum = 4
        const val SystemTimeFieldNum = 5
        const val StartTimestampFieldNum = 6
        const val StartTimestampMsFieldNum = 7

        val obdiiDataMesg: Mesg = run {
            // obdii_data
            val obdiiDataMesg = Mesg("obdii_data", MesgNum.OBDII_DATA)
            obdiiDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            obdiiDataMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            obdiiDataMesg.addField(Field("time_offset", TimeOffsetFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            obdiiDataMesg.addField(Field("pid", PidFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            obdiiDataMesg.addField(Field("raw_data", RawDataFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            obdiiDataMesg.addField(Field("pid_data_size", PidDataSizeFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            obdiiDataMesg.addField(Field("system_time", SystemTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            obdiiDataMesg.addField(Field("start_timestamp", StartTimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            obdiiDataMesg.addField(Field("start_timestamp_ms", StartTimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            obdiiDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.OBDII_DATA))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Timestamp message was output
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
     * Comment: Fractional part of timestamp, added to timestamp
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

    fun getTimeOffset(): Array<Int?>? {
        return getFieldIntegerValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_offset
     */
    fun getNumTimeOffset(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_offset field
     * Units: ms
     * Comment: Offset of PID reading [i] from start_timestamp+start_timestamp_ms. Readings may span accross seconds.
     *
     * @param index of time_offset
     * @return time_offset
     */
    fun getTimeOffset(index: Int): Int? {
        return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_offset field
     * Units: ms
     * Comment: Offset of PID reading [i] from start_timestamp+start_timestamp_ms. Readings may span accross seconds.
     *
     * @param index of time_offset
     * @param timeOffset The new timeOffset value to be set
     */
    fun setTimeOffset(index: Int, timeOffset: Int?) {
        setFieldValue(1, index, timeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pid field
     * Comment: Parameter ID
     *
     * @return pid
     */
    var pid: Byte?
        get() {
            return getFieldByteValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(pid) {
            setFieldValue(2, 0, pid, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getRawData(): Array<Byte?>? {
        return getFieldByteValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of raw_data
     */
    fun getNumRawData(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get raw_data field
     * Comment: Raw parameter data
     *
     * @param index of raw_data
     * @return raw_data
     */
    fun getRawData(index: Int): Byte? {
        return getFieldByteValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set raw_data field
     * Comment: Raw parameter data
     *
     * @param index of raw_data
     * @param rawData The new rawData value to be set
     */
    fun setRawData(index: Int, rawData: Byte?) {
        setFieldValue(3, index, rawData, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getPidDataSize(): Array<Short?>? {
        return getFieldShortValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of pid_data_size
     */
    fun getNumPidDataSize(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pid_data_size field
     * Comment: Optional, data size of PID[i]. If not specified refer to SAE J1979.
     *
     * @param index of pid_data_size
     * @return pid_data_size
     */
    fun getPidDataSize(index: Int): Short? {
        return getFieldShortValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set pid_data_size field
     * Comment: Optional, data size of PID[i]. If not specified refer to SAE J1979.
     *
     * @param index of pid_data_size
     * @param pidDataSize The new pidDataSize value to be set
     */
    fun setPidDataSize(index: Int, pidDataSize: Short?) {
        setFieldValue(4, index, pidDataSize, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getSystemTime(): Array<Long?>? {
        return getFieldLongValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of system_time
     */
    fun getNumSystemTime(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get system_time field
     * Comment: System time associated with sample expressed in ms, can be used instead of time_offset. There will be a system_time value for each raw_data element. For multibyte pids the system_time is repeated.
     *
     * @param index of system_time
     * @return system_time
     */
    fun getSystemTime(index: Int): Long? {
        return getFieldLongValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set system_time field
     * Comment: System time associated with sample expressed in ms, can be used instead of time_offset. There will be a system_time value for each raw_data element. For multibyte pids the system_time is repeated.
     *
     * @param index of system_time
     * @param systemTime The new systemTime value to be set
     */
    fun setSystemTime(index: Int, systemTime: Long?) {
        setFieldValue(5, index, systemTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_timestamp field
     * Comment: Timestamp of first sample recorded in the message. Used with time_offset to generate time of each sample
     *
     * @return start_timestamp
     */
    var startTimestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(startTimestamp) {
            setFieldValue(6, 0, startTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_timestamp_ms field
     * Units: ms
     * Comment: Fractional part of start_timestamp
     *
     * @return start_timestamp_ms
     */
    var startTimestampMs: Int?
        get() {
            return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startTimestampMs) {
            setFieldValue(7, 0, startTimestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
