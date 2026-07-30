/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaRespirationDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class HsaRespirationDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ProcessingIntervalFieldNum = 0
        const val RespirationRateFieldNum = 1

        val hsaRespirationDataMesg: Mesg = run {
            // hsa_respiration_data
            val hsaRespirationDataMesg = Mesg("hsa_respiration_data", MesgNum.HSA_RESPIRATION_DATA)
            hsaRespirationDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaRespirationDataMesg.addField(Field("processing_interval", ProcessingIntervalFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            hsaRespirationDataMesg.addField(Field("respiration_rate", RespirationRateFieldNum, 131, 100.0, 0.0, "breaths/min", false, Profile.Type.SINT16))
            hsaRespirationDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_RESPIRATION_DATA))

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

    fun getRespirationRate(): Array<Float?>? {
        return getFieldFloatValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of respiration_rate
     */
    fun getNumRespirationRate(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get respiration_rate field
     * Units: breaths/min
     * Comment: Breaths / min: [1,100] Invalid: 255 Excess motion: 254 Off wrist: 253 Not available: 252 Blank: 2.4
     *
     * @param index of respiration_rate
     * @return respiration_rate
     */
    fun getRespirationRate(index: Int): Float? {
        return getFieldFloatValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set respiration_rate field
     * Units: breaths/min
     * Comment: Breaths / min: [1,100] Invalid: 255 Excess motion: 254 Off wrist: 253 Not available: 252 Blank: 2.4
     *
     * @param index of respiration_rate
     * @param respirationRate The new respirationRate value to be set
     */
    fun setRespirationRate(index: Int, respirationRate: Float?) {
        setFieldValue(1, index, respirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
