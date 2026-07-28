/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SkinTempOvernightMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SkinTempOvernightMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val LocalTimestampFieldNum = 0
        const val AverageDeviationFieldNum = 1
        const val Average7DayDeviationFieldNum = 2
        const val NightlyValueFieldNum = 4

        val skinTempOvernightMesg: Mesg = run {
            // skin_temp_overnight
            val skinTempOvernightMesg = Mesg("skin_temp_overnight", MesgNum.SKIN_TEMP_OVERNIGHT)
            skinTempOvernightMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            skinTempOvernightMesg.addField(Field("local_timestamp", LocalTimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.LOCAL_DATE_TIME))
            skinTempOvernightMesg.addField(Field("average_deviation", AverageDeviationFieldNum, 136, 1.0, 0.0, "", false, Profile.Type.FLOAT32))
            skinTempOvernightMesg.addField(Field("average_7_day_deviation", Average7DayDeviationFieldNum, 136, 1.0, 0.0, "", false, Profile.Type.FLOAT32))
            skinTempOvernightMesg.addField(Field("nightly_value", NightlyValueFieldNum, 136, 1.0, 0.0, "", false, Profile.Type.FLOAT32))
            skinTempOvernightMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SKIN_TEMP_OVERNIGHT))

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
     * Get local_timestamp field
     *
     * @return local_timestamp
     */
    fun getLocalTimestamp(): Long? {
        return getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set local_timestamp field
     *
     * @param localTimestamp The new localTimestamp value to be set
     */
    fun setLocalTimestamp(localTimestamp: Long?) {
        setFieldValue(0, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get average_deviation field
     * Comment: The average overnight deviation from baseline temperature in degrees C
     *
     * @return average_deviation
     */
    fun getAverageDeviation(): Float? {
        return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set average_deviation field
     * Comment: The average overnight deviation from baseline temperature in degrees C
     *
     * @param averageDeviation The new averageDeviation value to be set
     */
    fun setAverageDeviation(averageDeviation: Float?) {
        setFieldValue(1, 0, averageDeviation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get average_7_day_deviation field
     * Comment: The average 7 day overnight deviation from baseline temperature in degrees C
     *
     * @return average_7_day_deviation
     */
    fun getAverage7DayDeviation(): Float? {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set average_7_day_deviation field
     * Comment: The average 7 day overnight deviation from baseline temperature in degrees C
     *
     * @param average7DayDeviation The new average7DayDeviation value to be set
     */
    fun setAverage7DayDeviation(average7DayDeviation: Float?) {
        setFieldValue(2, 0, average7DayDeviation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get nightly_value field
     * Comment: Final overnight temperature value
     *
     * @return nightly_value
     */
    fun getNightlyValue(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set nightly_value field
     * Comment: Final overnight temperature value
     *
     * @param nightlyValue The new nightlyValue value to be set
     */
    fun setNightlyValue(nightlyValue: Float?) {
        setFieldValue(4, 0, nightlyValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
