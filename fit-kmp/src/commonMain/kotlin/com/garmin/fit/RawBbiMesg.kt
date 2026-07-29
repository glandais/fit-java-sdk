/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from RawBbiMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class RawBbiMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val DataFieldNum = 1
        const val TimeFieldNum = 2
        const val QualityFieldNum = 3
        const val GapFieldNum = 4

        val rawBbiMesg: Mesg = run {
            var field_index = 0
            // raw_bbi
            val rawBbiMesg = Mesg("raw_bbi", MesgNum.RAW_BBI)
            rawBbiMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            rawBbiMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            field_index++
            rawBbiMesg.addField(Field("data", DataFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            rawBbiMesg.fields[field_index].components.add(FieldComponent(2, false, 14, 1.0, 0.0)) // time
            rawBbiMesg.fields[field_index].components.add(FieldComponent(3, false, 1, 1.0, 0.0)) // quality
            rawBbiMesg.fields[field_index].components.add(FieldComponent(4, false, 1, 1.0, 0.0)) // gap
            field_index++
            rawBbiMesg.addField(Field("time", TimeFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            field_index++
            rawBbiMesg.addField(Field("quality", QualityFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            rawBbiMesg.addField(Field("gap", GapFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            rawBbiMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.RAW_BBI))

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
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond resolution of the timestamp
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

    fun getData(): Array<Int?>? {
        return getFieldIntegerValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of data
     */
    fun getNumData(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data field
     * Comment: 1 bit for gap indicator, 1 bit for quality indicator, and 14 bits for Beat-to-Beat interval values in whole-integer millisecond resolution
     *
     * @param index of data
     * @return data
     */
    fun getData(index: Int): Int? {
        return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set data field
     * Comment: 1 bit for gap indicator, 1 bit for quality indicator, and 14 bits for Beat-to-Beat interval values in whole-integer millisecond resolution
     *
     * @param index of data
     * @param data The new data value to be set
     */
    fun setData(index: Int, data: Int?) {
        setFieldValue(1, index, data, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTime(): Array<Int?>? {
        return getFieldIntegerValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time
     */
    fun getNumTime(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        return getFieldIntegerValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
        setFieldValue(2, index, time, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getQuality(): Array<Short?>? {
        return getFieldShortValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of quality
     */
    fun getNumQuality(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get quality field
     * Comment: 1 = high confidence. 0 = low confidence. N/A when gap = 1
     *
     * @param index of quality
     * @return quality
     */
    fun getQuality(index: Int): Short? {
        return getFieldShortValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set quality field
     * Comment: 1 = high confidence. 0 = low confidence. N/A when gap = 1
     *
     * @param index of quality
     * @param quality The new quality value to be set
     */
    fun setQuality(index: Int, quality: Short?) {
        setFieldValue(3, index, quality, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getGap(): Array<Short?>? {
        return getFieldShortValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of gap
     */
    fun getNumGap(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gap field
     * Comment: 1 = gap (time represents ms gap length). 0 = BBI data
     *
     * @param index of gap
     * @return gap
     */
    fun getGap(index: Int): Short? {
        return getFieldShortValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set gap field
     * Comment: 1 = gap (time represents ms gap length). 0 = BBI data
     *
     * @param index of gap
     * @param gap The new gap value to be set
     */
    fun setGap(index: Int, gap: Short?) {
        setFieldValue(4, index, gap, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
