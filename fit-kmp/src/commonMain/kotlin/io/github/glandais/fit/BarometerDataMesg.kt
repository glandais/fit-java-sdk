/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BarometerDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class BarometerDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val SampleTimeOffsetFieldNum = 1
        const val BaroPresFieldNum = 2

        val barometerDataMesg: Mesg = run {
            // barometer_data
            val barometerDataMesg = Mesg("barometer_data", MesgNum.BAROMETER_DATA)
            barometerDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            barometerDataMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            barometerDataMesg.addField(Field("sample_time_offset", SampleTimeOffsetFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            barometerDataMesg.addField(Field("baro_pres", BaroPresFieldNum, 134, 1.0, 0.0, "Pa", false, Profile.Type.UINT32))
            barometerDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.BAROMETER_DATA))

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

    fun getSampleTimeOffset(): Array<Int?>? {
        return getFieldIntegerValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of sample_time_offset
     */
    fun getNumSampleTimeOffset(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sample_time_offset field
     * Units: ms
     * Comment: Each time in the array describes the time at which the barometer sample with the corrosponding index was taken. The samples may span across seconds. Array size must match the number of samples in baro_cal
     *
     * @param index of sample_time_offset
     * @return sample_time_offset
     */
    fun getSampleTimeOffset(index: Int): Int? {
        return getFieldIntegerValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sample_time_offset field
     * Units: ms
     * Comment: Each time in the array describes the time at which the barometer sample with the corrosponding index was taken. The samples may span across seconds. Array size must match the number of samples in baro_cal
     *
     * @param index of sample_time_offset
     * @param sampleTimeOffset The new sampleTimeOffset value to be set
     */
    fun setSampleTimeOffset(index: Int, sampleTimeOffset: Int?) {
        setFieldValue(1, index, sampleTimeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getBaroPres(): Array<Long?>? {
        return getFieldLongValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of baro_pres
     */
    fun getNumBaroPres(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get baro_pres field
     * Units: Pa
     * Comment: These are the raw ADC reading. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of baro_pres
     * @return baro_pres
     */
    fun getBaroPres(index: Int): Long? {
        return getFieldLongValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set baro_pres field
     * Units: Pa
     * Comment: These are the raw ADC reading. The samples may span across seconds. A conversion will need to be done on this data once read.
     *
     * @param index of baro_pres
     * @param baroPres The new baroPres value to be set
     */
    fun setBaroPres(index: Int, baroPres: Long?) {
        setFieldValue(2, index, baroPres, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
