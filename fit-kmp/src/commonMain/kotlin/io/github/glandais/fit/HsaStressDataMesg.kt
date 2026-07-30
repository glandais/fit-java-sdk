/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaStressDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class HsaStressDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ProcessingIntervalFieldNum = 0
        const val StressLevelFieldNum = 1

        val hsaStressDataMesg: Mesg = run {
            // hsa_stress_data
            val hsaStressDataMesg = Mesg("hsa_stress_data", MesgNum.HSA_STRESS_DATA)
            hsaStressDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            hsaStressDataMesg.addField(Field("processing_interval", ProcessingIntervalFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            hsaStressDataMesg.addField(Field("stress_level", StressLevelFieldNum, 1, 1.0, 0.0, "s", false, Profile.Type.SINT8))
            hsaStressDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_STRESS_DATA))

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

    fun getStressLevel(): Array<Byte?>? {
        return getFieldByteValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of stress_level
     */
    fun getNumStressLevel(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get stress_level field
     * Units: s
     * Comment: Stress Level: [0,100] Off wrist: -1 Excess motion: -2 Not enough data: -3 Recovering from exercise: -4 Unidentified: -5 Blank: -16
     *
     * @param index of stress_level
     * @return stress_level
     */
    fun getStressLevel(index: Int): Byte? {
        return getFieldByteValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set stress_level field
     * Units: s
     * Comment: Stress Level: [0,100] Off wrist: -1 Excess motion: -2 Not enough data: -3 Recovering from exercise: -4 Unidentified: -5 Blank: -16
     *
     * @param index of stress_level
     * @param stressLevel The new stressLevel value to be set
     */
    fun setStressLevel(index: Int, stressLevel: Byte?) {
        setFieldValue(1, index, stressLevel, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
