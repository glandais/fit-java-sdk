/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SleepDisruptionOvernightSeverityMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SleepDisruptionOvernightSeverityMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val SeverityFieldNum = 0

        val sleepDisruptionOvernightSeverityMesg: Mesg = run {
            // sleep_disruption_overnight_severity
            val sleepDisruptionOvernightSeverityMesg = Mesg("sleep_disruption_overnight_severity", MesgNum.SLEEP_DISRUPTION_OVERNIGHT_SEVERITY)
            sleepDisruptionOvernightSeverityMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            sleepDisruptionOvernightSeverityMesg.addField(Field("severity", SeverityFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SLEEP_DISRUPTION_SEVERITY))
            sleepDisruptionOvernightSeverityMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SLEEP_DISRUPTION_OVERNIGHT_SEVERITY))

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
