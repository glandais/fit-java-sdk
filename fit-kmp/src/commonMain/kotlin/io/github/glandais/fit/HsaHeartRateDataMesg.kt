/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaHeartRateDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class HsaHeartRateDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ProcessingIntervalFieldNum = 0
        const val StatusFieldNum = 1
        const val HeartRateFieldNum = 2

        val hsaHeartRateDataMesg: Mesg = run {
            // hsa_heart_rate_data
            val hsaHeartRateDataMesg = Mesg("hsa_heart_rate_data", MesgNum.HSA_HEART_RATE_DATA)
            hsaHeartRateDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaHeartRateDataMesg.addField(Field("processing_interval", ProcessingIntervalFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            hsaHeartRateDataMesg.addField(Field("status", StatusFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            hsaHeartRateDataMesg.addField(Field("heart_rate", HeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            hsaHeartRateDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_HEART_RATE_DATA))

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

    /**
     * Get status field
     * Comment: Status of measurements in buffer - 0 indicates SEARCHING 1 indicates LOCKED
     *
     * @return status
     */
    var status: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(status) {
            setFieldValue(1, 0, status, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getHeartRate(): Array<Short?>? {
        return getFieldShortValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of heart_rate
     */
    fun getNumHeartRate(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get heart_rate field
     * Units: bpm
     * Comment: Beats / min. Blank: 0
     *
     * @param index of heart_rate
     * @return heart_rate
     */
    fun getHeartRate(index: Int): Short? {
        return getFieldShortValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set heart_rate field
     * Units: bpm
     * Comment: Beats / min. Blank: 0
     *
     * @param index of heart_rate
     * @param heartRate The new heartRate value to be set
     */
    fun setHeartRate(index: Int, heartRate: Short?) {
        setFieldValue(2, index, heartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
