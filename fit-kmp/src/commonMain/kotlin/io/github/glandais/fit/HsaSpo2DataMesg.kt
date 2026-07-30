/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaSpo2DataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class HsaSpo2DataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ProcessingIntervalFieldNum = 0
        const val ReadingSpo2FieldNum = 1
        const val ConfidenceFieldNum = 2

        val hsaSpo2DataMesg: Mesg = run {
            // hsa_spo2_data
            val hsaSpo2DataMesg = Mesg("hsa_spo2_data", MesgNum.HSA_SPO2_DATA)
            hsaSpo2DataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaSpo2DataMesg.addField(Field("processing_interval", ProcessingIntervalFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            hsaSpo2DataMesg.addField(Field("reading_spo2", ReadingSpo2FieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            hsaSpo2DataMesg.addField(Field("confidence", ConfidenceFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            hsaSpo2DataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_SPO2_DATA))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
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
     * Get processing_interval field
     * Units: s
     * Comment: Processing interval length in seconds
     *
     * @return processing_interval
     */
    var processingInterval: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(processingInterval) {
            setFieldValue(0, 0, processingInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getReadingSpo2(): Array<Short?>? {
        return getFieldShortValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of reading_spo2
     */
    fun getNumReadingSpo2(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get reading_spo2 field
     * Units: percent
     * Comment: SpO2 Reading: [70,100] Blank: 240
     *
     * @param index of reading_spo2
     * @return reading_spo2
     */
    fun getReadingSpo2(index: Int): Short? {
        return getFieldShortValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set reading_spo2 field
     * Units: percent
     * Comment: SpO2 Reading: [70,100] Blank: 240
     *
     * @param index of reading_spo2
     * @param readingSpo2 The new readingSpo2 value to be set
     */
    fun setReadingSpo2(index: Int, readingSpo2: Short?) {
        setFieldValue(1, index, readingSpo2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getConfidence(): Array<Short?>? {
        return getFieldShortValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of confidence
     */
    fun getNumConfidence(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get confidence field
     * Comment: SpO2 Confidence: [0,254]
     *
     * @param index of confidence
     * @return confidence
     */
    fun getConfidence(index: Int): Short? {
        return getFieldShortValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set confidence field
     * Comment: SpO2 Confidence: [0,254]
     *
     * @param index of confidence
     * @param confidence The new confidence value to be set
     */
    fun setConfidence(index: Int, confidence: Short?) {
        setFieldValue(2, index, confidence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
