/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MaxMetDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class MaxMetDataMesg : Mesg {

    companion object {
        const val UpdateTimeFieldNum = 0
        const val Vo2MaxFieldNum = 2
        const val SportFieldNum = 5
        const val SubSportFieldNum = 6
        const val MaxMetCategoryFieldNum = 8
        const val CalibratedDataFieldNum = 9
        const val HrSourceFieldNum = 12
        const val SpeedSourceFieldNum = 13

        val maxMetDataMesg: Mesg = run {
            // max_met_data
            val maxMetDataMesg = Mesg("max_met_data", MesgNum.MAX_MET_DATA)
            maxMetDataMesg.addField(Field("update_time", UpdateTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            maxMetDataMesg.addField(Field("vo2_max", Vo2MaxFieldNum, 132, 10.0, 0.0, "mL/kg/min", false, Profile.Type.UINT16))
            maxMetDataMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            maxMetDataMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            maxMetDataMesg.addField(Field("max_met_category", MaxMetCategoryFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.MAX_MET_CATEGORY))
            maxMetDataMesg.addField(Field("calibrated_data", CalibratedDataFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            maxMetDataMesg.addField(Field("hr_source", HrSourceFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.MAX_MET_HEART_RATE_SOURCE))
            maxMetDataMesg.addField(Field("speed_source", SpeedSourceFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.MAX_MET_SPEED_SOURCE))
            maxMetDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.MAX_MET_DATA))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get update_time field
     * Comment: Time maxMET and vo2 were calculated
     *
     * @return update_time
     */
    fun getUpdateTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set update_time field
     * Comment: Time maxMET and vo2 were calculated
     *
     * @param updateTime The new updateTime value to be set
     */
    fun setUpdateTime(updateTime: DateTime?) {
        setFieldValue(0, 0, updateTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get vo2_max field
     * Units: mL/kg/min
     *
     * @return vo2_max
     */
    fun getVo2Max(): Float? {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set vo2_max field
     * Units: mL/kg/min
     *
     * @param vo2Max The new vo2Max value to be set
     */
    fun setVo2Max(vo2Max: Float?) {
        setFieldValue(2, 0, vo2Max, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sport field
     *
     * @return sport
     */
    fun getSport(): Sport? {
        val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Sport.fromValue(value)
    }

    /**
     * Set sport field
     *
     * @param sport The new sport value to be set
     */
    fun setSport(sport: Sport?) {
        setFieldValue(5, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    fun getSubSport(): SubSport? {
        val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SubSport.fromValue(value)
    }

    /**
     * Set sub_sport field
     *
     * @param subSport The new subSport value to be set
     */
    fun setSubSport(subSport: SubSport?) {
        setFieldValue(6, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_met_category field
     *
     * @return max_met_category
     */
    fun getMaxMetCategory(): MaxMetCategory? {
        val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return MaxMetCategory.fromValue(value)
    }

    /**
     * Set max_met_category field
     *
     * @param maxMetCategory The new maxMetCategory value to be set
     */
    fun setMaxMetCategory(maxMetCategory: MaxMetCategory?) {
        setFieldValue(8, 0, maxMetCategory?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calibrated_data field
     * Comment: Indicates if calibrated data was used in the calculation
     *
     * @return calibrated_data
     */
    fun getCalibratedData(): Bool? {
        val value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set calibrated_data field
     * Comment: Indicates if calibrated data was used in the calculation
     *
     * @param calibratedData The new calibratedData value to be set
     */
    fun setCalibratedData(calibratedData: Bool?) {
        setFieldValue(9, 0, calibratedData?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get hr_source field
     * Comment: Indicates if the estimate was obtained using a chest strap or wrist heart rate
     *
     * @return hr_source
     */
    fun getHrSource(): MaxMetHeartRateSource? {
        val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return MaxMetHeartRateSource.fromValue(value)
    }

    /**
     * Set hr_source field
     * Comment: Indicates if the estimate was obtained using a chest strap or wrist heart rate
     *
     * @param hrSource The new hrSource value to be set
     */
    fun setHrSource(hrSource: MaxMetHeartRateSource?) {
        setFieldValue(12, 0, hrSource?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get speed_source field
     * Comment: Indidcates if the estimate was obtained using onboard GPS or connected GPS
     *
     * @return speed_source
     */
    fun getSpeedSource(): MaxMetSpeedSource? {
        val value = getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return MaxMetSpeedSource.fromValue(value)
    }

    /**
     * Set speed_source field
     * Comment: Indidcates if the estimate was obtained using onboard GPS or connected GPS
     *
     * @param speedSource The new speedSource value to be set
     */
    fun setSpeedSource(speedSource: MaxMetSpeedSource?) {
        setFieldValue(13, 0, speedSource?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
