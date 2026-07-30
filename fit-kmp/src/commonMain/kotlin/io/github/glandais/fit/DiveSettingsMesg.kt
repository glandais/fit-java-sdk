/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DiveSettingsMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class DiveSettingsMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val MessageIndexFieldNum = 254
        const val NameFieldNum = 0
        const val ModelFieldNum = 1
        const val GfLowFieldNum = 2
        const val GfHighFieldNum = 3
        const val WaterTypeFieldNum = 4
        const val WaterDensityFieldNum = 5
        const val Po2WarnFieldNum = 6
        const val Po2CriticalFieldNum = 7
        const val Po2DecoFieldNum = 8
        const val SafetyStopEnabledFieldNum = 9
        const val BottomDepthFieldNum = 10
        const val BottomTimeFieldNum = 11
        const val ApneaCountdownEnabledFieldNum = 12
        const val ApneaCountdownTimeFieldNum = 13
        const val BacklightModeFieldNum = 14
        const val BacklightBrightnessFieldNum = 15
        const val BacklightTimeoutFieldNum = 16
        const val RepeatDiveIntervalFieldNum = 17
        const val SafetyStopTimeFieldNum = 18
        const val HeartRateSourceTypeFieldNum = 19
        const val HeartRateSourceFieldNum = 20
        const val TravelGasFieldNum = 21
        const val CcrLowSetpointSwitchModeFieldNum = 22
        const val CcrLowSetpointFieldNum = 23
        const val CcrLowSetpointDepthFieldNum = 24
        const val CcrHighSetpointSwitchModeFieldNum = 25
        const val CcrHighSetpointFieldNum = 26
        const val CcrHighSetpointDepthFieldNum = 27
        const val GasConsumptionDisplayFieldNum = 29
        const val UpKeyEnabledFieldNum = 30
        const val DiveSoundsFieldNum = 35
        const val LastStopMultipleFieldNum = 36
        const val NoFlyTimeModeFieldNum = 37

        val diveSettingsMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // dive_settings
            val diveSettingsMesg = Mesg("dive_settings", MesgNum.DIVE_SETTINGS)
            diveSettingsMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            diveSettingsMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            diveSettingsMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            diveSettingsMesg.addField(Field("model", ModelFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.TISSUE_MODEL_TYPE))
            field_index++
            diveSettingsMesg.addField(Field("gf_low", GfLowFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("gf_high", GfHighFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("water_type", WaterTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WATER_TYPE))
            field_index++
            diveSettingsMesg.addField(Field("water_density", WaterDensityFieldNum, 136, 1.0, 0.0, "kg/m^3", false, Profile.Type.FLOAT32))
            field_index++
            diveSettingsMesg.addField(Field("po2_warn", Po2WarnFieldNum, 2, 100.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("po2_critical", Po2CriticalFieldNum, 2, 100.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("po2_deco", Po2DecoFieldNum, 2, 100.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("safety_stop_enabled", SafetyStopEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            field_index++
            diveSettingsMesg.addField(Field("bottom_depth", BottomDepthFieldNum, 136, 1.0, 0.0, "", false, Profile.Type.FLOAT32))
            field_index++
            diveSettingsMesg.addField(Field("bottom_time", BottomTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            field_index++
            diveSettingsMesg.addField(Field("apnea_countdown_enabled", ApneaCountdownEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            field_index++
            diveSettingsMesg.addField(Field("apnea_countdown_time", ApneaCountdownTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            field_index++
            diveSettingsMesg.addField(Field("backlight_mode", BacklightModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DIVE_BACKLIGHT_MODE))
            field_index++
            diveSettingsMesg.addField(Field("backlight_brightness", BacklightBrightnessFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("backlight_timeout", BacklightTimeoutFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.BACKLIGHT_TIMEOUT))
            field_index++
            diveSettingsMesg.addField(Field("repeat_dive_interval", RepeatDiveIntervalFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            field_index++
            diveSettingsMesg.addField(Field("safety_stop_time", SafetyStopTimeFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            field_index++
            diveSettingsMesg.addField(Field("heart_rate_source_type", HeartRateSourceTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SOURCE_TYPE))
            field_index++
            diveSettingsMesg.addField(Field("heart_rate_source", HeartRateSourceFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            subfield_index = 0
            diveSettingsMesg.fields[field_index].subFields.add(SubField("heart_rate_antplus_device_type", 2, 1.0, 0.0, ""))
            diveSettingsMesg.fields[field_index].subFields[subfield_index].addMap(19, 1L)
            subfield_index++
            diveSettingsMesg.fields[field_index].subFields.add(SubField("heart_rate_local_device_type", 2, 1.0, 0.0, ""))
            diveSettingsMesg.fields[field_index].subFields[subfield_index].addMap(19, 5L)
            subfield_index++
            field_index++
            diveSettingsMesg.addField(Field("travel_gas", TravelGasFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            diveSettingsMesg.addField(Field("ccr_low_setpoint_switch_mode", CcrLowSetpointSwitchModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.CCR_SETPOINT_SWITCH_MODE))
            field_index++
            diveSettingsMesg.addField(Field("ccr_low_setpoint", CcrLowSetpointFieldNum, 2, 100.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("ccr_low_setpoint_depth", CcrLowSetpointDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            diveSettingsMesg.addField(Field("ccr_high_setpoint_switch_mode", CcrHighSetpointSwitchModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.CCR_SETPOINT_SWITCH_MODE))
            field_index++
            diveSettingsMesg.addField(Field("ccr_high_setpoint", CcrHighSetpointFieldNum, 2, 100.0, 0.0, "percent", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("ccr_high_setpoint_depth", CcrHighSetpointDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            diveSettingsMesg.addField(Field("gas_consumption_display", GasConsumptionDisplayFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.GAS_CONSUMPTION_RATE_TYPE))
            field_index++
            diveSettingsMesg.addField(Field("up_key_enabled", UpKeyEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            field_index++
            diveSettingsMesg.addField(Field("dive_sounds", DiveSoundsFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.TONE))
            field_index++
            diveSettingsMesg.addField(Field("last_stop_multiple", LastStopMultipleFieldNum, 2, 10.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            diveSettingsMesg.addField(Field("no_fly_time_mode", NoFlyTimeModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.NO_FLY_TIME_MODE))
            field_index++
            diveSettingsMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.DIVE_SETTINGS))

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
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(0, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get model field
     *
     * @return model
     */
    var model: TissueModelType?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return TissueModelType.fromValue(value)
        }
        set(model) {
            setFieldValue(1, 0, model?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get gf_low field
     * Units: percent
     *
     * @return gf_low
     */
    var gfLow: Short?
        get() {
            return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(gfLow) {
            setFieldValue(2, 0, gfLow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get gf_high field
     * Units: percent
     *
     * @return gf_high
     */
    var gfHigh: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(gfHigh) {
            setFieldValue(3, 0, gfHigh, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get water_type field
     *
     * @return water_type
     */
    var waterType: WaterType?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return WaterType.fromValue(value)
        }
        set(waterType) {
            setFieldValue(4, 0, waterType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get water_density field
     * Units: kg/m^3
     * Comment: Fresh water is usually 1000; salt water is usually 1025
     *
     * @return water_density
     */
    var waterDensity: Float?
        get() {
            return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(waterDensity) {
            setFieldValue(5, 0, waterDensity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get po2_warn field
     * Units: percent
     * Comment: Typically 1.40
     *
     * @return po2_warn
     */
    var po2Warn: Float?
        get() {
            return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(po2Warn) {
            setFieldValue(6, 0, po2Warn, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get po2_critical field
     * Units: percent
     * Comment: Typically 1.60
     *
     * @return po2_critical
     */
    var po2Critical: Float?
        get() {
            return getFieldFloatValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(po2Critical) {
            setFieldValue(7, 0, po2Critical, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get po2_deco field
     * Units: percent
     *
     * @return po2_deco
     */
    var po2Deco: Float?
        get() {
            return getFieldFloatValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(po2Deco) {
            setFieldValue(8, 0, po2Deco, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get safety_stop_enabled field
     *
     * @return safety_stop_enabled
     */
    var safetyStopEnabled: Bool?
        get() {
            val value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(safetyStopEnabled) {
            setFieldValue(9, 0, safetyStopEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bottom_depth field
     *
     * @return bottom_depth
     */
    var bottomDepth: Float?
        get() {
            return getFieldFloatValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bottomDepth) {
            setFieldValue(10, 0, bottomDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bottom_time field
     *
     * @return bottom_time
     */
    var bottomTime: Long?
        get() {
            return getFieldLongValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bottomTime) {
            setFieldValue(11, 0, bottomTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get apnea_countdown_enabled field
     *
     * @return apnea_countdown_enabled
     */
    var apneaCountdownEnabled: Bool?
        get() {
            val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(apneaCountdownEnabled) {
            setFieldValue(12, 0, apneaCountdownEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get apnea_countdown_time field
     *
     * @return apnea_countdown_time
     */
    var apneaCountdownTime: Long?
        get() {
            return getFieldLongValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(apneaCountdownTime) {
            setFieldValue(13, 0, apneaCountdownTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get backlight_mode field
     *
     * @return backlight_mode
     */
    var backlightMode: DiveBacklightMode?
        get() {
            val value = getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DiveBacklightMode.fromValue(value)
        }
        set(backlightMode) {
            setFieldValue(14, 0, backlightMode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get backlight_brightness field
     *
     * @return backlight_brightness
     */
    var backlightBrightness: Short?
        get() {
            return getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(backlightBrightness) {
            setFieldValue(15, 0, backlightBrightness, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get backlight_timeout field
     *
     * @return backlight_timeout
     */
    var backlightTimeout: Short?
        get() {
            return getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(backlightTimeout) {
            setFieldValue(16, 0, backlightTimeout, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get repeat_dive_interval field
     * Units: s
     * Comment: Time between surfacing and ending the activity
     *
     * @return repeat_dive_interval
     */
    var repeatDiveInterval: Int?
        get() {
            return getFieldIntegerValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(repeatDiveInterval) {
            setFieldValue(17, 0, repeatDiveInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get safety_stop_time field
     * Units: s
     * Comment: Time at safety stop (if enabled)
     *
     * @return safety_stop_time
     */
    var safetyStopTime: Int?
        get() {
            return getFieldIntegerValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(safetyStopTime) {
            setFieldValue(18, 0, safetyStopTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get heart_rate_source_type field
     *
     * @return heart_rate_source_type
     */
    var heartRateSourceType: SourceType?
        get() {
            val value = getFieldShortValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SourceType.fromValue(value)
        }
        set(heartRateSourceType) {
            setFieldValue(19, 0, heartRateSourceType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get heart_rate_source field
     *
     * @return heart_rate_source
     */
    var heartRateSource: Short?
        get() {
            return getFieldShortValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(heartRateSource) {
            setFieldValue(20, 0, heartRateSource, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get heart_rate_antplus_device_type field
     *
     * @return heart_rate_antplus_device_type
     */
    var heartRateAntplusDeviceType: Short?
        get() {
            return getFieldShortValue(20, 0, Profile.SubFields.DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_ANTPLUS_DEVICE_TYPE)
        }
        set(heartRateAntplusDeviceType) {
            setFieldValue(20, 0, heartRateAntplusDeviceType, Profile.SubFields.DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_ANTPLUS_DEVICE_TYPE)
        }

    /**
     * Get heart_rate_local_device_type field
     *
     * @return heart_rate_local_device_type
     */
    var heartRateLocalDeviceType: Short?
        get() {
            return getFieldShortValue(20, 0, Profile.SubFields.DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_LOCAL_DEVICE_TYPE)
        }
        set(heartRateLocalDeviceType) {
            setFieldValue(20, 0, heartRateLocalDeviceType, Profile.SubFields.DIVE_SETTINGS_MESG_HEART_RATE_SOURCE_FIELD_HEART_RATE_LOCAL_DEVICE_TYPE)
        }

    /**
     * Get travel_gas field
     * Comment: Index of travel dive_gas message
     *
     * @return travel_gas
     */
    var travelGas: Int?
        get() {
            return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(travelGas) {
            setFieldValue(21, 0, travelGas, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ccr_low_setpoint_switch_mode field
     * Comment: If low PO2 should be switched to automatically
     *
     * @return ccr_low_setpoint_switch_mode
     */
    var ccrLowSetpointSwitchMode: CcrSetpointSwitchMode?
        get() {
            val value = getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return CcrSetpointSwitchMode.fromValue(value)
        }
        set(ccrLowSetpointSwitchMode) {
            setFieldValue(22, 0, ccrLowSetpointSwitchMode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ccr_low_setpoint field
     * Units: percent
     * Comment: Target PO2 when using low setpoint
     *
     * @return ccr_low_setpoint
     */
    var ccrLowSetpoint: Float?
        get() {
            return getFieldFloatValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ccrLowSetpoint) {
            setFieldValue(23, 0, ccrLowSetpoint, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ccr_low_setpoint_depth field
     * Units: m
     * Comment: Depth to switch to low setpoint in automatic mode
     *
     * @return ccr_low_setpoint_depth
     */
    var ccrLowSetpointDepth: Float?
        get() {
            return getFieldFloatValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ccrLowSetpointDepth) {
            setFieldValue(24, 0, ccrLowSetpointDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ccr_high_setpoint_switch_mode field
     * Comment: If high PO2 should be switched to automatically
     *
     * @return ccr_high_setpoint_switch_mode
     */
    var ccrHighSetpointSwitchMode: CcrSetpointSwitchMode?
        get() {
            val value = getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return CcrSetpointSwitchMode.fromValue(value)
        }
        set(ccrHighSetpointSwitchMode) {
            setFieldValue(25, 0, ccrHighSetpointSwitchMode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ccr_high_setpoint field
     * Units: percent
     * Comment: Target PO2 when using high setpoint
     *
     * @return ccr_high_setpoint
     */
    var ccrHighSetpoint: Float?
        get() {
            return getFieldFloatValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ccrHighSetpoint) {
            setFieldValue(26, 0, ccrHighSetpoint, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ccr_high_setpoint_depth field
     * Units: m
     * Comment: Depth to switch to high setpoint in automatic mode
     *
     * @return ccr_high_setpoint_depth
     */
    var ccrHighSetpointDepth: Float?
        get() {
            return getFieldFloatValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ccrHighSetpointDepth) {
            setFieldValue(27, 0, ccrHighSetpointDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get gas_consumption_display field
     * Comment: Type of gas consumption rate to display. Some values are only valid if tank volume is known.
     *
     * @return gas_consumption_display
     */
    var gasConsumptionDisplay: GasConsumptionRateType?
        get() {
            val value = getFieldShortValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return GasConsumptionRateType.fromValue(value)
        }
        set(gasConsumptionDisplay) {
            setFieldValue(29, 0, gasConsumptionDisplay?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get up_key_enabled field
     * Comment: Indicates whether the up key is enabled during dives
     *
     * @return up_key_enabled
     */
    var upKeyEnabled: Bool?
        get() {
            val value = getFieldShortValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(upKeyEnabled) {
            setFieldValue(30, 0, upKeyEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get dive_sounds field
     * Comment: Sounds and vibration enabled or disabled in-dive
     *
     * @return dive_sounds
     */
    var diveSounds: Tone?
        get() {
            val value = getFieldShortValue(35, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Tone.fromValue(value)
        }
        set(diveSounds) {
            setFieldValue(35, 0, diveSounds?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get last_stop_multiple field
     * Comment: Usually 1.0/1.5/2.0 representing 3/4.5/6m or 10/15/20ft
     *
     * @return last_stop_multiple
     */
    var lastStopMultiple: Float?
        get() {
            return getFieldFloatValue(36, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(lastStopMultiple) {
            setFieldValue(36, 0, lastStopMultiple, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get no_fly_time_mode field
     * Comment: Indicates which guidelines to use for no-fly surface interval.
     *
     * @return no_fly_time_mode
     */
    var noFlyTimeMode: NoFlyTimeMode?
        get() {
            val value = getFieldShortValue(37, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return NoFlyTimeMode.fromValue(value)
        }
        set(noFlyTimeMode) {
            setFieldValue(37, 0, noFlyTimeMode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
