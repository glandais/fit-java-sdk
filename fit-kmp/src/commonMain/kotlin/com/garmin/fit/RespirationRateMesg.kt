/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from RespirationRateMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class RespirationRateMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val RespirationRateFieldNum = 0

        val respirationRateMesg: Mesg = run {
            // respiration_rate
            val respirationRateMesg = Mesg("respiration_rate", MesgNum.RESPIRATION_RATE)
            respirationRateMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            respirationRateMesg.addField(Field("respiration_rate", RespirationRateFieldNum, 131, 100.0, 0.0, "breaths/min", false, Profile.Type.SINT16))
            respirationRateMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.RESPIRATION_RATE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get respiration_rate field
     * Units: breaths/min
     * Comment: Breaths * 100 /min, -300 indicates invalid, -200 indicates large motion, -100 indicates off wrist
     *
     * @return respiration_rate
     */
    fun getRespirationRate(): Float? {
        return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set respiration_rate field
     * Units: breaths/min
     * Comment: Breaths * 100 /min, -300 indicates invalid, -200 indicates large motion, -100 indicates off wrist
     *
     * @param respirationRate The new respirationRate value to be set
     */
    fun setRespirationRate(respirationRate: Float?) {
        setFieldValue(0, 0, respirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
