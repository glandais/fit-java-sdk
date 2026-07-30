/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SkinTempOvernightMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get local_timestamp field
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

    /**
     * Get average_deviation field
     * Comment: The average overnight deviation from baseline temperature in degrees C
     *
     * @return average_deviation
     */
    var averageDeviation: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(averageDeviation) {
            setFieldValue(1, 0, averageDeviation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get average_7_day_deviation field
     * Comment: The average 7 day overnight deviation from baseline temperature in degrees C
     *
     * @return average_7_day_deviation
     */
    var average7DayDeviation: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(average7DayDeviation) {
            setFieldValue(2, 0, average7DayDeviation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get nightly_value field
     * Comment: Final overnight temperature value
     *
     * @return nightly_value
     */
    var nightlyValue: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(nightlyValue) {
            setFieldValue(4, 0, nightlyValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
