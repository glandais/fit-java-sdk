/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MonitoringHrDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class MonitoringHrDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val RestingHeartRateFieldNum = 0
        const val CurrentDayRestingHeartRateFieldNum = 1

        val monitoringHrDataMesg: Mesg = run {
            // monitoring_hr_data
            val monitoringHrDataMesg = Mesg("monitoring_hr_data", MesgNum.MONITORING_HR_DATA)
            monitoringHrDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            monitoringHrDataMesg.addField(Field("resting_heart_rate", RestingHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            monitoringHrDataMesg.addField(Field("current_day_resting_heart_rate", CurrentDayRestingHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            monitoringHrDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.MONITORING_HR_DATA))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Must align to logging interval, for example, time must be 00:00:00 for daily log.
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
     * Get resting_heart_rate field
     * Units: bpm
     * Comment: 7-day rolling average
     *
     * @return resting_heart_rate
     */
    var restingHeartRate: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(restingHeartRate) {
            setFieldValue(0, 0, restingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get current_day_resting_heart_rate field
     * Units: bpm
     * Comment: RHR for today only. (Feeds into 7-day average)
     *
     * @return current_day_resting_heart_rate
     */
    var currentDayRestingHeartRate: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(currentDayRestingHeartRate) {
            setFieldValue(1, 0, currentDayRestingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
