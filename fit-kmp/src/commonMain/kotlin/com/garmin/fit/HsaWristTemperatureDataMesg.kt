/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaWristTemperatureDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HsaWristTemperatureDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ProcessingIntervalFieldNum = 0
        const val ValueFieldNum = 1

        val hsaWristTemperatureDataMesg: Mesg = run {
            // hsa_wrist_temperature_data
            val hsaWristTemperatureDataMesg = Mesg("hsa_wrist_temperature_data", MesgNum.HSA_WRIST_TEMPERATURE_DATA)
            hsaWristTemperatureDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaWristTemperatureDataMesg.addField(Field("processing_interval", ProcessingIntervalFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            hsaWristTemperatureDataMesg.addField(Field("value", ValueFieldNum, 132, 1000.0, 0.0, "C", false, Profile.Type.UINT16))
            hsaWristTemperatureDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_WRIST_TEMPERATURE_DATA))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get processing_interval field
     * Units: s
     * Comment: Processing interval length in seconds
     *
     * @return processing_interval
     */
    fun getProcessingInterval(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set processing_interval field
     * Units: s
     * Comment: Processing interval length in seconds
     *
     * @param processingInterval The new processingInterval value to be set
     */
    fun setProcessingInterval(processingInterval: Int?) {
        setFieldValue(0, 0, processingInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getValue(): Array<Float?>? {
        return getFieldFloatValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of value
     */
    fun getNumValue(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get value field
     * Units: C
     * Comment: Wrist temperature reading
     *
     * @param index of value
     * @return value
     */
    fun getValue(index: Int): Float? {
        return getFieldFloatValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set value field
     * Units: C
     * Comment: Wrist temperature reading
     *
     * @param index of value
     * @param value The new value value to be set
     */
    fun setValue(index: Int, value: Float?) {
        setFieldValue(1, index, value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
