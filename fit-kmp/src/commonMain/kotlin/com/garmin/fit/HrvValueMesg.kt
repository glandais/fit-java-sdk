/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HrvValueMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HrvValueMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ValueFieldNum = 0

        val hrvValueMesg: Mesg = run {
            // hrv_value
            val hrvValueMesg = Mesg("hrv_value", MesgNum.HRV_VALUE)
            hrvValueMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            hrvValueMesg.addField(Field("value", ValueFieldNum, 132, 128.0, 0.0, "ms", false, Profile.Type.UINT16))
            hrvValueMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HRV_VALUE))

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
     * Get value field
     * Units: ms
     * Comment: 5 minute RMSSD
     *
     * @return value
     */
    fun getValue(): Float? {
        return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set value field
     * Units: ms
     * Comment: 5 minute RMSSD
     *
     * @param value The new value value to be set
     */
    fun setValue(value: Float?) {
        setFieldValue(0, 0, value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
