/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SleepDisruptionSeverityPeriodMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SleepDisruptionSeverityPeriodMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val TimestampFieldNum = 253
        const val SeverityFieldNum = 0

        val sleepDisruptionSeverityPeriodMesg: Mesg = run {
            // sleep_disruption_severity_period
            val sleepDisruptionSeverityPeriodMesg = Mesg("sleep_disruption_severity_period", MesgNum.SLEEP_DISRUPTION_SEVERITY_PERIOD)
            sleepDisruptionSeverityPeriodMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            sleepDisruptionSeverityPeriodMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            sleepDisruptionSeverityPeriodMesg.addField(Field("severity", SeverityFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SLEEP_DISRUPTION_SEVERITY))
            sleepDisruptionSeverityPeriodMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SLEEP_DISRUPTION_SEVERITY_PERIOD))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     *
     * @return message_index
     */
    fun getMessageIndex(): Int? {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_index field
     *
     * @param messageIndex The new messageIndex value to be set
     */
    fun setMessageIndex(messageIndex: Int?) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

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
     * Get severity field
     *
     * @return severity
     */
    fun getSeverity(): SleepDisruptionSeverity? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SleepDisruptionSeverity.fromValue(value)
    }

    /**
     * Set severity field
     *
     * @param severity The new severity value to be set
     */
    fun setSeverity(severity: SleepDisruptionSeverity?) {
        setFieldValue(0, 0, severity?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
