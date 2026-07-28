/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from UserProfileMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class UserProfileMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val FriendlyNameFieldNum = 0
        const val GenderFieldNum = 1
        const val AgeFieldNum = 2
        const val HeightFieldNum = 3
        const val WeightFieldNum = 4
        const val LanguageFieldNum = 5
        const val ElevSettingFieldNum = 6
        const val WeightSettingFieldNum = 7
        const val RestingHeartRateFieldNum = 8
        const val DefaultMaxRunningHeartRateFieldNum = 9
        const val DefaultMaxBikingHeartRateFieldNum = 10
        const val DefaultMaxHeartRateFieldNum = 11
        const val HrSettingFieldNum = 12
        const val SpeedSettingFieldNum = 13
        const val DistSettingFieldNum = 14
        const val PowerSettingFieldNum = 16
        const val ActivityClassFieldNum = 17
        const val PositionSettingFieldNum = 18
        const val TemperatureSettingFieldNum = 21
        const val LocalIdFieldNum = 22
        const val GlobalIdFieldNum = 23
        const val WakeTimeFieldNum = 28
        const val SleepTimeFieldNum = 29
        const val HeightSettingFieldNum = 30
        const val UserRunningStepLengthFieldNum = 31
        const val UserWalkingStepLengthFieldNum = 32
        const val DepthSettingFieldNum = 47
        const val DiveCountFieldNum = 49

        val userProfileMesg: Mesg = run {
            // user_profile
            val userProfileMesg = Mesg("user_profile", MesgNum.USER_PROFILE)
            userProfileMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            userProfileMesg.addField(Field("friendly_name", FriendlyNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            userProfileMesg.addField(Field("gender", GenderFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.GENDER))
            userProfileMesg.addField(Field("age", AgeFieldNum, 2, 1.0, 0.0, "years", false, Profile.Type.UINT8))
            userProfileMesg.addField(Field("height", HeightFieldNum, 2, 100.0, 0.0, "m", false, Profile.Type.UINT8))
            userProfileMesg.addField(Field("weight", WeightFieldNum, 132, 10.0, 0.0, "kg", false, Profile.Type.UINT16))
            userProfileMesg.addField(Field("language", LanguageFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.LANGUAGE))
            userProfileMesg.addField(Field("elev_setting", ElevSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            userProfileMesg.addField(Field("weight_setting", WeightSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            userProfileMesg.addField(Field("resting_heart_rate", RestingHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            userProfileMesg.addField(Field("default_max_running_heart_rate", DefaultMaxRunningHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            userProfileMesg.addField(Field("default_max_biking_heart_rate", DefaultMaxBikingHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            userProfileMesg.addField(Field("default_max_heart_rate", DefaultMaxHeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            userProfileMesg.addField(Field("hr_setting", HrSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_HEART))
            userProfileMesg.addField(Field("speed_setting", SpeedSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            userProfileMesg.addField(Field("dist_setting", DistSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            userProfileMesg.addField(Field("power_setting", PowerSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_POWER))
            userProfileMesg.addField(Field("activity_class", ActivityClassFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ACTIVITY_CLASS))
            userProfileMesg.addField(Field("position_setting", PositionSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_POSITION))
            userProfileMesg.addField(Field("temperature_setting", TemperatureSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            userProfileMesg.addField(Field("local_id", LocalIdFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.USER_LOCAL_ID))
            userProfileMesg.addField(Field("global_id", GlobalIdFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            userProfileMesg.addField(Field("wake_time", WakeTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.LOCALTIME_INTO_DAY))
            userProfileMesg.addField(Field("sleep_time", SleepTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.LOCALTIME_INTO_DAY))
            userProfileMesg.addField(Field("height_setting", HeightSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            userProfileMesg.addField(Field("user_running_step_length", UserRunningStepLengthFieldNum, 132, 1000.0, 0.0, "m", false, Profile.Type.UINT16))
            userProfileMesg.addField(Field("user_walking_step_length", UserWalkingStepLengthFieldNum, 132, 1000.0, 0.0, "m", false, Profile.Type.UINT16))
            userProfileMesg.addField(Field("depth_setting", DepthSettingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            userProfileMesg.addField(Field("dive_count", DiveCountFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            userProfileMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.USER_PROFILE))

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
     * Get friendly_name field
     * Comment: Used for Morning Report greeting
     *
     * @return friendly_name
     */
    fun getFriendlyName(): String? {
        return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set friendly_name field
     * Comment: Used for Morning Report greeting
     *
     * @param friendlyName The new friendlyName value to be set
     */
    fun setFriendlyName(friendlyName: String?) {
        setFieldValue(0, 0, friendlyName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gender field
     *
     * @return gender
     */
    fun getGender(): Gender? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Gender.fromValue(value)
    }

    /**
     * Set gender field
     *
     * @param gender The new gender value to be set
     */
    fun setGender(gender: Gender?) {
        setFieldValue(1, 0, gender?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get age field
     * Units: years
     *
     * @return age
     */
    fun getAge(): Short? {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set age field
     * Units: years
     *
     * @param age The new age value to be set
     */
    fun setAge(age: Short?) {
        setFieldValue(2, 0, age, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get height field
     * Units: m
     *
     * @return height
     */
    fun getHeight(): Float? {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set height field
     * Units: m
     *
     * @param height The new height value to be set
     */
    fun setHeight(height: Float?) {
        setFieldValue(3, 0, height, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get weight field
     * Units: kg
     *
     * @return weight
     */
    fun getWeight(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set weight field
     * Units: kg
     *
     * @param weight The new weight value to be set
     */
    fun setWeight(weight: Float?) {
        setFieldValue(4, 0, weight, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get language field
     *
     * @return language
     */
    fun getLanguage(): Language? {
        val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Language.fromValue(value)
    }

    /**
     * Set language field
     *
     * @param language The new language value to be set
     */
    fun setLanguage(language: Language?) {
        setFieldValue(5, 0, language?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get elev_setting field
     *
     * @return elev_setting
     */
    fun getElevSetting(): DisplayMeasure? {
        val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set elev_setting field
     *
     * @param elevSetting The new elevSetting value to be set
     */
    fun setElevSetting(elevSetting: DisplayMeasure?) {
        setFieldValue(6, 0, elevSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get weight_setting field
     *
     * @return weight_setting
     */
    fun getWeightSetting(): DisplayMeasure? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set weight_setting field
     *
     * @param weightSetting The new weightSetting value to be set
     */
    fun setWeightSetting(weightSetting: DisplayMeasure?) {
        setFieldValue(7, 0, weightSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get resting_heart_rate field
     * Units: bpm
     *
     * @return resting_heart_rate
     */
    fun getRestingHeartRate(): Short? {
        return getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set resting_heart_rate field
     * Units: bpm
     *
     * @param restingHeartRate The new restingHeartRate value to be set
     */
    fun setRestingHeartRate(restingHeartRate: Short?) {
        setFieldValue(8, 0, restingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get default_max_running_heart_rate field
     * Units: bpm
     *
     * @return default_max_running_heart_rate
     */
    fun getDefaultMaxRunningHeartRate(): Short? {
        return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set default_max_running_heart_rate field
     * Units: bpm
     *
     * @param defaultMaxRunningHeartRate The new defaultMaxRunningHeartRate value to be set
     */
    fun setDefaultMaxRunningHeartRate(defaultMaxRunningHeartRate: Short?) {
        setFieldValue(9, 0, defaultMaxRunningHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get default_max_biking_heart_rate field
     * Units: bpm
     *
     * @return default_max_biking_heart_rate
     */
    fun getDefaultMaxBikingHeartRate(): Short? {
        return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set default_max_biking_heart_rate field
     * Units: bpm
     *
     * @param defaultMaxBikingHeartRate The new defaultMaxBikingHeartRate value to be set
     */
    fun setDefaultMaxBikingHeartRate(defaultMaxBikingHeartRate: Short?) {
        setFieldValue(10, 0, defaultMaxBikingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get default_max_heart_rate field
     * Units: bpm
     *
     * @return default_max_heart_rate
     */
    fun getDefaultMaxHeartRate(): Short? {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set default_max_heart_rate field
     * Units: bpm
     *
     * @param defaultMaxHeartRate The new defaultMaxHeartRate value to be set
     */
    fun setDefaultMaxHeartRate(defaultMaxHeartRate: Short?) {
        setFieldValue(11, 0, defaultMaxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get hr_setting field
     *
     * @return hr_setting
     */
    fun getHrSetting(): DisplayHeart? {
        val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayHeart.fromValue(value)
    }

    /**
     * Set hr_setting field
     *
     * @param hrSetting The new hrSetting value to be set
     */
    fun setHrSetting(hrSetting: DisplayHeart?) {
        setFieldValue(12, 0, hrSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get speed_setting field
     *
     * @return speed_setting
     */
    fun getSpeedSetting(): DisplayMeasure? {
        val value = getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set speed_setting field
     *
     * @param speedSetting The new speedSetting value to be set
     */
    fun setSpeedSetting(speedSetting: DisplayMeasure?) {
        setFieldValue(13, 0, speedSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get dist_setting field
     *
     * @return dist_setting
     */
    fun getDistSetting(): DisplayMeasure? {
        val value = getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set dist_setting field
     *
     * @param distSetting The new distSetting value to be set
     */
    fun setDistSetting(distSetting: DisplayMeasure?) {
        setFieldValue(14, 0, distSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get power_setting field
     *
     * @return power_setting
     */
    fun getPowerSetting(): DisplayPower? {
        val value = getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayPower.fromValue(value)
    }

    /**
     * Set power_setting field
     *
     * @param powerSetting The new powerSetting value to be set
     */
    fun setPowerSetting(powerSetting: DisplayPower?) {
        setFieldValue(16, 0, powerSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get activity_class field
     *
     * @return activity_class
     */
    fun getActivityClass(): ActivityClass? {
        val value = getFieldShortValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return ActivityClass.fromValue(value)
    }

    /**
     * Set activity_class field
     *
     * @param activityClass The new activityClass value to be set
     */
    fun setActivityClass(activityClass: ActivityClass?) {
        setFieldValue(17, 0, activityClass?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get position_setting field
     *
     * @return position_setting
     */
    fun getPositionSetting(): DisplayPosition? {
        val value = getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayPosition.fromValue(value)
    }

    /**
     * Set position_setting field
     *
     * @param positionSetting The new positionSetting value to be set
     */
    fun setPositionSetting(positionSetting: DisplayPosition?) {
        setFieldValue(18, 0, positionSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get temperature_setting field
     *
     * @return temperature_setting
     */
    fun getTemperatureSetting(): DisplayMeasure? {
        val value = getFieldShortValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set temperature_setting field
     *
     * @param temperatureSetting The new temperatureSetting value to be set
     */
    fun setTemperatureSetting(temperatureSetting: DisplayMeasure?) {
        setFieldValue(21, 0, temperatureSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get local_id field
     *
     * @return local_id
     */
    fun getLocalId(): Int? {
        return getFieldIntegerValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set local_id field
     *
     * @param localId The new localId value to be set
     */
    fun setLocalId(localId: Int?) {
        setFieldValue(22, 0, localId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getGlobalId(): Array<Byte?>? {
        return getFieldByteValues(23, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of global_id
     */
    fun getNumGlobalId(): Int {
        return getNumFieldValues(23, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get global_id field
     *
     * @param index of global_id
     * @return global_id
     */
    fun getGlobalId(index: Int): Byte? {
        return getFieldByteValue(23, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set global_id field
     *
     * @param index of global_id
     * @param globalId The new globalId value to be set
     */
    fun setGlobalId(index: Int, globalId: Byte?) {
        setFieldValue(23, index, globalId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get wake_time field
     * Comment: Typical wake time
     *
     * @return wake_time
     */
    fun getWakeTime(): Long? {
        return getFieldLongValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set wake_time field
     * Comment: Typical wake time
     *
     * @param wakeTime The new wakeTime value to be set
     */
    fun setWakeTime(wakeTime: Long?) {
        setFieldValue(28, 0, wakeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sleep_time field
     * Comment: Typical bed time
     *
     * @return sleep_time
     */
    fun getSleepTime(): Long? {
        return getFieldLongValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sleep_time field
     * Comment: Typical bed time
     *
     * @param sleepTime The new sleepTime value to be set
     */
    fun setSleepTime(sleepTime: Long?) {
        setFieldValue(29, 0, sleepTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get height_setting field
     *
     * @return height_setting
     */
    fun getHeightSetting(): DisplayMeasure? {
        val value = getFieldShortValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set height_setting field
     *
     * @param heightSetting The new heightSetting value to be set
     */
    fun setHeightSetting(heightSetting: DisplayMeasure?) {
        setFieldValue(30, 0, heightSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get user_running_step_length field
     * Units: m
     * Comment: User defined running step length set to 0 for auto length
     *
     * @return user_running_step_length
     */
    fun getUserRunningStepLength(): Float? {
        return getFieldFloatValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set user_running_step_length field
     * Units: m
     * Comment: User defined running step length set to 0 for auto length
     *
     * @param userRunningStepLength The new userRunningStepLength value to be set
     */
    fun setUserRunningStepLength(userRunningStepLength: Float?) {
        setFieldValue(31, 0, userRunningStepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get user_walking_step_length field
     * Units: m
     * Comment: User defined walking step length set to 0 for auto length
     *
     * @return user_walking_step_length
     */
    fun getUserWalkingStepLength(): Float? {
        return getFieldFloatValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set user_walking_step_length field
     * Units: m
     * Comment: User defined walking step length set to 0 for auto length
     *
     * @param userWalkingStepLength The new userWalkingStepLength value to be set
     */
    fun setUserWalkingStepLength(userWalkingStepLength: Float?) {
        setFieldValue(32, 0, userWalkingStepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get depth_setting field
     *
     * @return depth_setting
     */
    fun getDepthSetting(): DisplayMeasure? {
        val value = getFieldShortValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set depth_setting field
     *
     * @param depthSetting The new depthSetting value to be set
     */
    fun setDepthSetting(depthSetting: DisplayMeasure?) {
        setFieldValue(47, 0, depthSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get dive_count field
     *
     * @return dive_count
     */
    fun getDiveCount(): Long? {
        return getFieldLongValue(49, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set dive_count field
     *
     * @param diveCount The new diveCount value to be set
     */
    fun setDiveCount(diveCount: Long?) {
        setFieldValue(49, 0, diveCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
