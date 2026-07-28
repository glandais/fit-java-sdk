/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WeightScaleMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class WeightScaleMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val WeightFieldNum = 0
        const val PercentFatFieldNum = 1
        const val PercentHydrationFieldNum = 2
        const val VisceralFatMassFieldNum = 3
        const val BoneMassFieldNum = 4
        const val MuscleMassFieldNum = 5
        const val BasalMetFieldNum = 7
        const val PhysiqueRatingFieldNum = 8
        const val ActiveMetFieldNum = 9
        const val MetabolicAgeFieldNum = 10
        const val VisceralFatRatingFieldNum = 11
        const val UserProfileIndexFieldNum = 12
        const val BmiFieldNum = 13

        val weightScaleMesg: Mesg = run {
            // weight_scale
            val weightScaleMesg = Mesg("weight_scale", MesgNum.WEIGHT_SCALE)
            weightScaleMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            weightScaleMesg.addField(Field("weight", WeightFieldNum, 132, 100.0, 0.0, "kg", false, Profile.Type.WEIGHT))
            weightScaleMesg.addField(Field("percent_fat", PercentFatFieldNum, 132, 100.0, 0.0, "%", false, Profile.Type.UINT16))
            weightScaleMesg.addField(Field("percent_hydration", PercentHydrationFieldNum, 132, 100.0, 0.0, "%", false, Profile.Type.UINT16))
            weightScaleMesg.addField(Field("visceral_fat_mass", VisceralFatMassFieldNum, 132, 100.0, 0.0, "kg", false, Profile.Type.UINT16))
            weightScaleMesg.addField(Field("bone_mass", BoneMassFieldNum, 132, 100.0, 0.0, "kg", false, Profile.Type.UINT16))
            weightScaleMesg.addField(Field("muscle_mass", MuscleMassFieldNum, 132, 100.0, 0.0, "kg", false, Profile.Type.UINT16))
            weightScaleMesg.addField(Field("basal_met", BasalMetFieldNum, 132, 4.0, 0.0, "kcal/day", false, Profile.Type.UINT16))
            weightScaleMesg.addField(Field("physique_rating", PhysiqueRatingFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            weightScaleMesg.addField(Field("active_met", ActiveMetFieldNum, 132, 4.0, 0.0, "kcal/day", false, Profile.Type.UINT16))
            weightScaleMesg.addField(Field("metabolic_age", MetabolicAgeFieldNum, 2, 1.0, 0.0, "years", false, Profile.Type.UINT8))
            weightScaleMesg.addField(Field("visceral_fat_rating", VisceralFatRatingFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            weightScaleMesg.addField(Field("user_profile_index", UserProfileIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            weightScaleMesg.addField(Field("bmi", BmiFieldNum, 132, 10.0, 0.0, "kg/m^2", false, Profile.Type.UINT16))
            weightScaleMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.WEIGHT_SCALE))

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
     * Get weight field
     * Units: kg
     *
     * @return weight
     */
    fun getWeight(): Float? {
        return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set weight field
     * Units: kg
     *
     * @param weight The new weight value to be set
     */
    fun setWeight(weight: Float?) {
        setFieldValue(0, 0, weight, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get percent_fat field
     * Units: %
     *
     * @return percent_fat
     */
    fun getPercentFat(): Float? {
        return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set percent_fat field
     * Units: %
     *
     * @param percentFat The new percentFat value to be set
     */
    fun setPercentFat(percentFat: Float?) {
        setFieldValue(1, 0, percentFat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get percent_hydration field
     * Units: %
     *
     * @return percent_hydration
     */
    fun getPercentHydration(): Float? {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set percent_hydration field
     * Units: %
     *
     * @param percentHydration The new percentHydration value to be set
     */
    fun setPercentHydration(percentHydration: Float?) {
        setFieldValue(2, 0, percentHydration, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get visceral_fat_mass field
     * Units: kg
     *
     * @return visceral_fat_mass
     */
    fun getVisceralFatMass(): Float? {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set visceral_fat_mass field
     * Units: kg
     *
     * @param visceralFatMass The new visceralFatMass value to be set
     */
    fun setVisceralFatMass(visceralFatMass: Float?) {
        setFieldValue(3, 0, visceralFatMass, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get bone_mass field
     * Units: kg
     *
     * @return bone_mass
     */
    fun getBoneMass(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set bone_mass field
     * Units: kg
     *
     * @param boneMass The new boneMass value to be set
     */
    fun setBoneMass(boneMass: Float?) {
        setFieldValue(4, 0, boneMass, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get muscle_mass field
     * Units: kg
     *
     * @return muscle_mass
     */
    fun getMuscleMass(): Float? {
        return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set muscle_mass field
     * Units: kg
     *
     * @param muscleMass The new muscleMass value to be set
     */
    fun setMuscleMass(muscleMass: Float?) {
        setFieldValue(5, 0, muscleMass, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get basal_met field
     * Units: kcal/day
     *
     * @return basal_met
     */
    fun getBasalMet(): Float? {
        return getFieldFloatValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set basal_met field
     * Units: kcal/day
     *
     * @param basalMet The new basalMet value to be set
     */
    fun setBasalMet(basalMet: Float?) {
        setFieldValue(7, 0, basalMet, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get physique_rating field
     *
     * @return physique_rating
     */
    fun getPhysiqueRating(): Short? {
        return getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set physique_rating field
     *
     * @param physiqueRating The new physiqueRating value to be set
     */
    fun setPhysiqueRating(physiqueRating: Short?) {
        setFieldValue(8, 0, physiqueRating, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get active_met field
     * Units: kcal/day
     * Comment: ~4kJ per kcal, 0.25 allows max 16384 kcal
     *
     * @return active_met
     */
    fun getActiveMet(): Float? {
        return getFieldFloatValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set active_met field
     * Units: kcal/day
     * Comment: ~4kJ per kcal, 0.25 allows max 16384 kcal
     *
     * @param activeMet The new activeMet value to be set
     */
    fun setActiveMet(activeMet: Float?) {
        setFieldValue(9, 0, activeMet, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get metabolic_age field
     * Units: years
     *
     * @return metabolic_age
     */
    fun getMetabolicAge(): Short? {
        return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set metabolic_age field
     * Units: years
     *
     * @param metabolicAge The new metabolicAge value to be set
     */
    fun setMetabolicAge(metabolicAge: Short?) {
        setFieldValue(10, 0, metabolicAge, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get visceral_fat_rating field
     *
     * @return visceral_fat_rating
     */
    fun getVisceralFatRating(): Short? {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set visceral_fat_rating field
     *
     * @param visceralFatRating The new visceralFatRating value to be set
     */
    fun setVisceralFatRating(visceralFatRating: Short?) {
        setFieldValue(11, 0, visceralFatRating, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get user_profile_index field
     * Comment: Associates this weight scale message to a user. This corresponds to the index of the user profile message in the weight scale file.
     *
     * @return user_profile_index
     */
    fun getUserProfileIndex(): Int? {
        return getFieldIntegerValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set user_profile_index field
     * Comment: Associates this weight scale message to a user. This corresponds to the index of the user profile message in the weight scale file.
     *
     * @param userProfileIndex The new userProfileIndex value to be set
     */
    fun setUserProfileIndex(userProfileIndex: Int?) {
        setFieldValue(12, 0, userProfileIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get bmi field
     * Units: kg/m^2
     *
     * @return bmi
     */
    fun getBmi(): Float? {
        return getFieldFloatValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set bmi field
     * Units: kg/m^2
     *
     * @param bmi The new bmi value to be set
     */
    fun setBmi(bmi: Float?) {
        setFieldValue(13, 0, bmi, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
