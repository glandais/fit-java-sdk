/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WeatherAlertMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class WeatherAlertMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ReportIdFieldNum = 0
        const val IssueTimeFieldNum = 1
        const val ExpireTimeFieldNum = 2
        const val SeverityFieldNum = 3
        const val TypeFieldNum = 4

        val weatherAlertMesg: Mesg = run {
            // weather_alert
            val weatherAlertMesg = Mesg("weather_alert", MesgNum.WEATHER_ALERT)
            weatherAlertMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            weatherAlertMesg.addField(Field("report_id", ReportIdFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            weatherAlertMesg.addField(Field("issue_time", IssueTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            weatherAlertMesg.addField(Field("expire_time", ExpireTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            weatherAlertMesg.addField(Field("severity", SeverityFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WEATHER_SEVERITY))
            weatherAlertMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WEATHER_SEVERE_TYPE))
            weatherAlertMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.WEATHER_ALERT))

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
     * Get report_id field
     * Comment: Unique identifier from GCS report ID string, length is 12
     *
     * @return report_id
     */
    fun getReportId(): String? {
        return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set report_id field
     * Comment: Unique identifier from GCS report ID string, length is 12
     *
     * @param reportId The new reportId value to be set
     */
    fun setReportId(reportId: String?) {
        setFieldValue(0, 0, reportId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get issue_time field
     * Comment: Time alert was issued
     *
     * @return issue_time
     */
    fun getIssueTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set issue_time field
     * Comment: Time alert was issued
     *
     * @param issueTime The new issueTime value to be set
     */
    fun setIssueTime(issueTime: DateTime?) {
        setFieldValue(1, 0, issueTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get expire_time field
     * Comment: Time alert expires
     *
     * @return expire_time
     */
    fun getExpireTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set expire_time field
     * Comment: Time alert expires
     *
     * @param expireTime The new expireTime value to be set
     */
    fun setExpireTime(expireTime: DateTime?) {
        setFieldValue(2, 0, expireTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get severity field
     * Comment: Warning, Watch, Advisory, Statement
     *
     * @return severity
     */
    fun getSeverity(): WeatherSeverity? {
        val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return WeatherSeverity.fromValue(value)
    }

    /**
     * Set severity field
     * Comment: Warning, Watch, Advisory, Statement
     *
     * @param severity The new severity value to be set
     */
    fun setSeverity(severity: WeatherSeverity?) {
        setFieldValue(3, 0, severity?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get type field
     * Comment: Tornado, Severe Thunderstorm, etc.
     *
     * @return type
     */
    fun getType(): WeatherSevereType? {
        val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return WeatherSevereType.fromValue(value)
    }

    /**
     * Set type field
     * Comment: Tornado, Severe Thunderstorm, etc.
     *
     * @param type The new type value to be set
     */
    fun setType(type: WeatherSevereType?) {
        setFieldValue(4, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
