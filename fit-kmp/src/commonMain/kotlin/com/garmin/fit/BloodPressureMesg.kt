/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BloodPressureMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class BloodPressureMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val SystolicPressureFieldNum = 0
        const val DiastolicPressureFieldNum = 1
        const val MeanArterialPressureFieldNum = 2
        const val Map3SampleMeanFieldNum = 3
        const val MapMorningValuesFieldNum = 4
        const val MapEveningValuesFieldNum = 5
        const val HeartRateFieldNum = 6
        const val HeartRateTypeFieldNum = 7
        const val StatusFieldNum = 8
        const val UserProfileIndexFieldNum = 9

        val bloodPressureMesg: Mesg = run {
            // blood_pressure
            val bloodPressureMesg = Mesg("blood_pressure", MesgNum.BLOOD_PRESSURE)
            bloodPressureMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            bloodPressureMesg.addField(Field("systolic_pressure", SystolicPressureFieldNum, 132, 1.0, 0.0, "mmHg", false, Profile.Type.UINT16))
            bloodPressureMesg.addField(Field("diastolic_pressure", DiastolicPressureFieldNum, 132, 1.0, 0.0, "mmHg", false, Profile.Type.UINT16))
            bloodPressureMesg.addField(Field("mean_arterial_pressure", MeanArterialPressureFieldNum, 132, 1.0, 0.0, "mmHg", false, Profile.Type.UINT16))
            bloodPressureMesg.addField(Field("map_3_sample_mean", Map3SampleMeanFieldNum, 132, 1.0, 0.0, "mmHg", false, Profile.Type.UINT16))
            bloodPressureMesg.addField(Field("map_morning_values", MapMorningValuesFieldNum, 132, 1.0, 0.0, "mmHg", false, Profile.Type.UINT16))
            bloodPressureMesg.addField(Field("map_evening_values", MapEveningValuesFieldNum, 132, 1.0, 0.0, "mmHg", false, Profile.Type.UINT16))
            bloodPressureMesg.addField(Field("heart_rate", HeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            bloodPressureMesg.addField(Field("heart_rate_type", HeartRateTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.HR_TYPE))
            bloodPressureMesg.addField(Field("status", StatusFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BP_STATUS))
            bloodPressureMesg.addField(Field("user_profile_index", UserProfileIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            bloodPressureMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.BLOOD_PRESSURE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get systolic_pressure field
     * Units: mmHg
     *
     * @return systolic_pressure
     */
    fun getSystolicPressure(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set systolic_pressure field
     * Units: mmHg
     *
     * @param systolicPressure The new systolicPressure value to be set
     */
    fun setSystolicPressure(systolicPressure: Int?) {
        setFieldValue(0, 0, systolicPressure, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get diastolic_pressure field
     * Units: mmHg
     *
     * @return diastolic_pressure
     */
    fun getDiastolicPressure(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set diastolic_pressure field
     * Units: mmHg
     *
     * @param diastolicPressure The new diastolicPressure value to be set
     */
    fun setDiastolicPressure(diastolicPressure: Int?) {
        setFieldValue(1, 0, diastolicPressure, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get mean_arterial_pressure field
     * Units: mmHg
     *
     * @return mean_arterial_pressure
     */
    fun getMeanArterialPressure(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set mean_arterial_pressure field
     * Units: mmHg
     *
     * @param meanArterialPressure The new meanArterialPressure value to be set
     */
    fun setMeanArterialPressure(meanArterialPressure: Int?) {
        setFieldValue(2, 0, meanArterialPressure, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get map_3_sample_mean field
     * Units: mmHg
     *
     * @return map_3_sample_mean
     */
    fun getMap3SampleMean(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set map_3_sample_mean field
     * Units: mmHg
     *
     * @param map3SampleMean The new map3SampleMean value to be set
     */
    fun setMap3SampleMean(map3SampleMean: Int?) {
        setFieldValue(3, 0, map3SampleMean, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get map_morning_values field
     * Units: mmHg
     *
     * @return map_morning_values
     */
    fun getMapMorningValues(): Int? {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set map_morning_values field
     * Units: mmHg
     *
     * @param mapMorningValues The new mapMorningValues value to be set
     */
    fun setMapMorningValues(mapMorningValues: Int?) {
        setFieldValue(4, 0, mapMorningValues, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get map_evening_values field
     * Units: mmHg
     *
     * @return map_evening_values
     */
    fun getMapEveningValues(): Int? {
        return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set map_evening_values field
     * Units: mmHg
     *
     * @param mapEveningValues The new mapEveningValues value to be set
     */
    fun setMapEveningValues(mapEveningValues: Int?) {
        setFieldValue(5, 0, mapEveningValues, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get heart_rate field
     * Units: bpm
     *
     * @return heart_rate
     */
    fun getHeartRate(): Short? {
        return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set heart_rate field
     * Units: bpm
     *
     * @param heartRate The new heartRate value to be set
     */
    fun setHeartRate(heartRate: Short?) {
        setFieldValue(6, 0, heartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get heart_rate_type field
     *
     * @return heart_rate_type
     */
    fun getHeartRateType(): HrType? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return HrType.fromValue(value)
    }

    /**
     * Set heart_rate_type field
     *
     * @param heartRateType The new heartRateType value to be set
     */
    fun setHeartRateType(heartRateType: HrType?) {
        setFieldValue(7, 0, heartRateType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get status field
     *
     * @return status
     */
    fun getStatus(): BpStatus? {
        val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return BpStatus.fromValue(value)
    }

    /**
     * Set status field
     *
     * @param status The new status value to be set
     */
    fun setStatus(status: BpStatus?) {
        setFieldValue(8, 0, status?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get user_profile_index field
     * Comment: Associates this blood pressure message to a user. This corresponds to the index of the user profile message in the blood pressure file.
     *
     * @return user_profile_index
     */
    fun getUserProfileIndex(): Int? {
        return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set user_profile_index field
     * Comment: Associates this blood pressure message to a user. This corresponds to the index of the user profile message in the blood pressure file.
     *
     * @param userProfileIndex The new userProfileIndex value to be set
     */
    fun setUserProfileIndex(userProfileIndex: Int?) {
        setFieldValue(9, 0, userProfileIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
