/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaStepDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HsaStepDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ProcessingIntervalFieldNum = 0
        const val StepsFieldNum = 1

        val hsaStepDataMesg: Mesg = run {
            // hsa_step_data
            val hsaStepDataMesg = Mesg("hsa_step_data", MesgNum.HSA_STEP_DATA)
            hsaStepDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaStepDataMesg.addField(Field("processing_interval", ProcessingIntervalFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            hsaStepDataMesg.addField(Field("steps", StepsFieldNum, 134, 1.0, 0.0, "steps", false, Profile.Type.UINT32))
            hsaStepDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_STEP_DATA))

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
     * Comment: Processing interval length in seconds. File start: 0xFFFFFFEF File stop: 0xFFFFFFEE
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

    fun getSteps(): Array<Long?>? {
        return getFieldLongValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of steps
     */
    fun getNumSteps(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get steps field
     * Units: steps
     * Comment: Total step sum
     *
     * @param index of steps
     * @return steps
     */
    fun getSteps(index: Int): Long? {
        return getFieldLongValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set steps field
     * Units: steps
     * Comment: Total step sum
     *
     * @param index of steps
     * @param steps The new steps value to be set
     */
    fun setSteps(index: Int, steps: Long?) {
        setFieldValue(1, index, steps, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
