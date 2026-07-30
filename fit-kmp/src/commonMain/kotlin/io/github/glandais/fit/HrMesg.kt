/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HrMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class HrMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val FractionalTimestampFieldNum = 0
        const val Time256FieldNum = 1
        const val FilteredBpmFieldNum = 6
        const val EventTimestampFieldNum = 9
        const val EventTimestamp12FieldNum = 10

        val hrMesg: Mesg = run {
            var field_index = 0
            // hr
            val hrMesg = Mesg("hr", MesgNum.HR)
            hrMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            hrMesg.addField(Field("fractional_timestamp", FractionalTimestampFieldNum, 132, 32768.0, 0.0, "s", false, Profile.Type.UINT16))
            field_index++
            hrMesg.addField(Field("time256", Time256FieldNum, 2, 256.0, 0.0, "s", false, Profile.Type.UINT8))
            hrMesg.fields[field_index].components.add(FieldComponent(0, false, 8, 256.0, 0.0)) // fractional_timestamp
            field_index++
            hrMesg.addField(Field("filtered_bpm", FilteredBpmFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            hrMesg.addField(Field("event_timestamp", EventTimestampFieldNum, 134, 1024.0, 0.0, "s", true, Profile.Type.UINT32))
            field_index++
            hrMesg.addField(Field("event_timestamp_12", EventTimestamp12FieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            hrMesg.fields[field_index].components.add(FieldComponent(9, true, 12, 1024.0, 0.0)) // event_timestamp
            field_index++
            hrMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HR))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
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
     * Get time256 field
     * Units: s
     *
     * @return time256
     */
    var time256: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(time256) {
            setFieldValue(1, 0, time256, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getFilteredBpm(): Array<Short?>? {
        return getFieldShortValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of filtered_bpm
     */
    fun getNumFilteredBpm(): Int {
        return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get filtered_bpm field
     * Units: bpm
     *
     * @param index of filtered_bpm
     * @return filtered_bpm
     */
    fun getFilteredBpm(index: Int): Short? {
        return getFieldShortValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set filtered_bpm field
     * Units: bpm
     *
     * @param index of filtered_bpm
     * @param filteredBpm The new filteredBpm value to be set
     */
    fun setFilteredBpm(index: Int, filteredBpm: Short?) {
        setFieldValue(6, index, filteredBpm, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getEventTimestamp(): Array<Float?>? {
        return getFieldFloatValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of event_timestamp
     */
    fun getNumEventTimestamp(): Int {
        return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event_timestamp field
     * Units: s
     *
     * @param index of event_timestamp
     * @return event_timestamp
     */
    fun getEventTimestamp(index: Int): Float? {
        return getFieldFloatValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set event_timestamp field
     * Units: s
     *
     * @param index of event_timestamp
     * @param eventTimestamp The new eventTimestamp value to be set
     */
    fun setEventTimestamp(index: Int, eventTimestamp: Float?) {
        setFieldValue(9, index, eventTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getEventTimestamp12(): Array<Byte?>? {
        return getFieldByteValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of event_timestamp_12
     */
    fun getNumEventTimestamp12(): Int {
        return getNumFieldValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event_timestamp_12 field
     *
     * @param index of event_timestamp_12
     * @return event_timestamp_12
     */
    fun getEventTimestamp12(index: Int): Byte? {
        return getFieldByteValue(10, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set event_timestamp_12 field
     *
     * @param index of event_timestamp_12
     * @param eventTimestamp12 The new eventTimestamp12 value to be set
     */
    fun setEventTimestamp12(index: Int, eventTimestamp12: Byte?) {
        setFieldValue(10, index, eventTimestamp12, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
