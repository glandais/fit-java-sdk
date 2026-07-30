/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MonitoringInfoMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class MonitoringInfoMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val LocalTimestampFieldNum = 0
        const val ActivityTypeFieldNum = 1
        const val CyclesToDistanceFieldNum = 3
        const val CyclesToCaloriesFieldNum = 4
        const val RestingMetabolicRateFieldNum = 5

        val monitoringInfoMesg: Mesg = run {
            // monitoring_info
            val monitoringInfoMesg = Mesg("monitoring_info", MesgNum.MONITORING_INFO)
            monitoringInfoMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            monitoringInfoMesg.addField(Field("local_timestamp", LocalTimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.LOCAL_DATE_TIME))
            monitoringInfoMesg.addField(Field("activity_type", ActivityTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ACTIVITY_TYPE))
            monitoringInfoMesg.addField(Field("cycles_to_distance", CyclesToDistanceFieldNum, 132, 5000.0, 0.0, "m/cycle", false, Profile.Type.UINT16))
            monitoringInfoMesg.addField(Field("cycles_to_calories", CyclesToCaloriesFieldNum, 132, 5000.0, 0.0, "kcal/cycle", false, Profile.Type.UINT16))
            monitoringInfoMesg.addField(Field("resting_metabolic_rate", RestingMetabolicRateFieldNum, 132, 1.0, 0.0, "kcal / day", false, Profile.Type.UINT16))
            monitoringInfoMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.MONITORING_INFO))

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
     * Get local_timestamp field
     * Units: s
     * Comment: Use to convert activity timestamps to local time if device does not support time zone and daylight savings time correction.
     *
     * @return local_timestamp
     */
    var localTimestamp: Long?
        get() {
            return getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(localTimestamp) {
            setFieldValue(0, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getActivityType(): Array<ActivityType> {
        val values = getFieldShortValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)!!
        return Array(values.size) { i -> ActivityType.fromValue(values[i]) }
    }

    /**
     * @return number of activity_type
     */
    fun getNumActivityType(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get activity_type field
     *
     * @param index of activity_type
     * @return activity_type
     */
    fun getActivityType(index: Int): ActivityType? {
        val value = getFieldShortValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return ActivityType.fromValue(value)
    }

    /**
     * Set activity_type field
     *
     * @param index of activity_type
     * @param activityType The new activityType value to be set
     */
    fun setActivityType(index: Int, activityType: ActivityType?) {
        setFieldValue(1, index, activityType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCyclesToDistance(): Array<Float?>? {
        return getFieldFloatValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of cycles_to_distance
     */
    fun getNumCyclesToDistance(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get cycles_to_distance field
     * Units: m/cycle
     * Comment: Indexed by activity_type
     *
     * @param index of cycles_to_distance
     * @return cycles_to_distance
     */
    fun getCyclesToDistance(index: Int): Float? {
        return getFieldFloatValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set cycles_to_distance field
     * Units: m/cycle
     * Comment: Indexed by activity_type
     *
     * @param index of cycles_to_distance
     * @param cyclesToDistance The new cyclesToDistance value to be set
     */
    fun setCyclesToDistance(index: Int, cyclesToDistance: Float?) {
        setFieldValue(3, index, cyclesToDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCyclesToCalories(): Array<Float?>? {
        return getFieldFloatValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of cycles_to_calories
     */
    fun getNumCyclesToCalories(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get cycles_to_calories field
     * Units: kcal/cycle
     * Comment: Indexed by activity_type
     *
     * @param index of cycles_to_calories
     * @return cycles_to_calories
     */
    fun getCyclesToCalories(index: Int): Float? {
        return getFieldFloatValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set cycles_to_calories field
     * Units: kcal/cycle
     * Comment: Indexed by activity_type
     *
     * @param index of cycles_to_calories
     * @param cyclesToCalories The new cyclesToCalories value to be set
     */
    fun setCyclesToCalories(index: Int, cyclesToCalories: Float?) {
        setFieldValue(4, index, cyclesToCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get resting_metabolic_rate field
     * Units: kcal / day
     *
     * @return resting_metabolic_rate
     */
    var restingMetabolicRate: Int?
        get() {
            return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(restingMetabolicRate) {
            setFieldValue(5, 0, restingMetabolicRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
