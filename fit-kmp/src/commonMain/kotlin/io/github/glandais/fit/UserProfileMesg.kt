/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from UserProfileMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get friendly_name field
     * Comment: Used for Morning Report greeting
     *
     * @return friendly_name
     */
    var friendlyName: String?
        get() {
            return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(friendlyName) {
            setFieldValue(0, 0, friendlyName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get gender field
     *
     * @return gender
     */
    var gender: Gender?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Gender.fromValue(value)
        }
        set(gender) {
            setFieldValue(1, 0, gender?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get age field
     * Units: years
     *
     * @return age
     */
    var age: Short?
        get() {
            return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(age) {
            setFieldValue(2, 0, age, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get height field
     * Units: m
     *
     * @return height
     */
    var height: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(height) {
            setFieldValue(3, 0, height, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get weight field
     * Units: kg
     *
     * @return weight
     */
    var weight: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(weight) {
            setFieldValue(4, 0, weight, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get language field
     *
     * @return language
     */
    var language: Language?
        get() {
            val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Language.fromValue(value)
        }
        set(language) {
            setFieldValue(5, 0, language?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get elev_setting field
     *
     * @return elev_setting
     */
    var elevSetting: DisplayMeasure?
        get() {
            val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(elevSetting) {
            setFieldValue(6, 0, elevSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get weight_setting field
     *
     * @return weight_setting
     */
    var weightSetting: DisplayMeasure?
        get() {
            val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(weightSetting) {
            setFieldValue(7, 0, weightSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get resting_heart_rate field
     * Units: bpm
     *
     * @return resting_heart_rate
     */
    var restingHeartRate: Short?
        get() {
            return getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(restingHeartRate) {
            setFieldValue(8, 0, restingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get default_max_running_heart_rate field
     * Units: bpm
     *
     * @return default_max_running_heart_rate
     */
    var defaultMaxRunningHeartRate: Short?
        get() {
            return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(defaultMaxRunningHeartRate) {
            setFieldValue(9, 0, defaultMaxRunningHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get default_max_biking_heart_rate field
     * Units: bpm
     *
     * @return default_max_biking_heart_rate
     */
    var defaultMaxBikingHeartRate: Short?
        get() {
            return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(defaultMaxBikingHeartRate) {
            setFieldValue(10, 0, defaultMaxBikingHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get default_max_heart_rate field
     * Units: bpm
     *
     * @return default_max_heart_rate
     */
    var defaultMaxHeartRate: Short?
        get() {
            return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(defaultMaxHeartRate) {
            setFieldValue(11, 0, defaultMaxHeartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get hr_setting field
     *
     * @return hr_setting
     */
    var hrSetting: DisplayHeart?
        get() {
            val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayHeart.fromValue(value)
        }
        set(hrSetting) {
            setFieldValue(12, 0, hrSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get speed_setting field
     *
     * @return speed_setting
     */
    var speedSetting: DisplayMeasure?
        get() {
            val value = getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(speedSetting) {
            setFieldValue(13, 0, speedSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get dist_setting field
     *
     * @return dist_setting
     */
    var distSetting: DisplayMeasure?
        get() {
            val value = getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(distSetting) {
            setFieldValue(14, 0, distSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get power_setting field
     *
     * @return power_setting
     */
    var powerSetting: DisplayPower?
        get() {
            val value = getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayPower.fromValue(value)
        }
        set(powerSetting) {
            setFieldValue(16, 0, powerSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_class field
     *
     * @return activity_class
     */
    var activityClass: ActivityClass?
        get() {
            val value = getFieldShortValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ActivityClass.fromValue(value)
        }
        set(activityClass) {
            setFieldValue(17, 0, activityClass?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get position_setting field
     *
     * @return position_setting
     */
    var positionSetting: DisplayPosition?
        get() {
            val value = getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayPosition.fromValue(value)
        }
        set(positionSetting) {
            setFieldValue(18, 0, positionSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get temperature_setting field
     *
     * @return temperature_setting
     */
    var temperatureSetting: DisplayMeasure?
        get() {
            val value = getFieldShortValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(temperatureSetting) {
            setFieldValue(21, 0, temperatureSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get local_id field
     *
     * @return local_id
     */
    var localId: Int?
        get() {
            return getFieldIntegerValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(localId) {
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
    var wakeTime: Long?
        get() {
            return getFieldLongValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(wakeTime) {
            setFieldValue(28, 0, wakeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sleep_time field
     * Comment: Typical bed time
     *
     * @return sleep_time
     */
    var sleepTime: Long?
        get() {
            return getFieldLongValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sleepTime) {
            setFieldValue(29, 0, sleepTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get height_setting field
     *
     * @return height_setting
     */
    var heightSetting: DisplayMeasure?
        get() {
            val value = getFieldShortValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(heightSetting) {
            setFieldValue(30, 0, heightSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get user_running_step_length field
     * Units: m
     * Comment: User defined running step length set to 0 for auto length
     *
     * @return user_running_step_length
     */
    var userRunningStepLength: Float?
        get() {
            return getFieldFloatValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(userRunningStepLength) {
            setFieldValue(31, 0, userRunningStepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get user_walking_step_length field
     * Units: m
     * Comment: User defined walking step length set to 0 for auto length
     *
     * @return user_walking_step_length
     */
    var userWalkingStepLength: Float?
        get() {
            return getFieldFloatValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(userWalkingStepLength) {
            setFieldValue(32, 0, userWalkingStepLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get depth_setting field
     *
     * @return depth_setting
     */
    var depthSetting: DisplayMeasure?
        get() {
            val value = getFieldShortValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(depthSetting) {
            setFieldValue(47, 0, depthSetting?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get dive_count field
     *
     * @return dive_count
     */
    var diveCount: Long?
        get() {
            return getFieldLongValue(49, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(diveCount) {
            setFieldValue(49, 0, diveCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
