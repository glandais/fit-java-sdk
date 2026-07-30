/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DeviceSettingsMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class DeviceSettingsMesg : Mesg {

    companion object {
        const val ActiveTimeZoneFieldNum = 0
        const val UtcOffsetFieldNum = 1
        const val TimeOffsetFieldNum = 2
        const val TimeModeFieldNum = 4
        const val TimeZoneOffsetFieldNum = 5
        const val BacklightModeFieldNum = 12
        const val ActivityTrackerEnabledFieldNum = 36
        const val ClockTimeFieldNum = 39
        const val PagesEnabledFieldNum = 40
        const val MoveAlertEnabledFieldNum = 46
        const val DateModeFieldNum = 47
        const val DisplayOrientationFieldNum = 55
        const val MountingSideFieldNum = 56
        const val DefaultPageFieldNum = 57
        const val AutosyncMinStepsFieldNum = 58
        const val AutosyncMinTimeFieldNum = 59
        const val LactateThresholdAutodetectEnabledFieldNum = 80
        const val BleAutoUploadEnabledFieldNum = 86
        const val AutoSyncFrequencyFieldNum = 89
        const val AutoActivityDetectFieldNum = 90
        const val NumberOfScreensFieldNum = 94
        const val SmartNotificationDisplayOrientationFieldNum = 95
        const val TapInterfaceFieldNum = 134
        const val TapSensitivityFieldNum = 174

        val deviceSettingsMesg: Mesg = run {
            // device_settings
            val deviceSettingsMesg = Mesg("device_settings", MesgNum.DEVICE_SETTINGS)
            deviceSettingsMesg.addField(Field("active_time_zone", ActiveTimeZoneFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            deviceSettingsMesg.addField(Field("utc_offset", UtcOffsetFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            deviceSettingsMesg.addField(Field("time_offset", TimeOffsetFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            deviceSettingsMesg.addField(Field("time_mode", TimeModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.TIME_MODE))
            deviceSettingsMesg.addField(Field("time_zone_offset", TimeZoneOffsetFieldNum, 1, 4.0, 0.0, "hr", false, Profile.Type.SINT8))
            deviceSettingsMesg.addField(Field("backlight_mode", BacklightModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BACKLIGHT_MODE))
            deviceSettingsMesg.addField(Field("activity_tracker_enabled", ActivityTrackerEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            deviceSettingsMesg.addField(Field("clock_time", ClockTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            deviceSettingsMesg.addField(Field("pages_enabled", PagesEnabledFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            deviceSettingsMesg.addField(Field("move_alert_enabled", MoveAlertEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            deviceSettingsMesg.addField(Field("date_mode", DateModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DATE_MODE))
            deviceSettingsMesg.addField(Field("display_orientation", DisplayOrientationFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_ORIENTATION))
            deviceSettingsMesg.addField(Field("mounting_side", MountingSideFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SIDE))
            deviceSettingsMesg.addField(Field("default_page", DefaultPageFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            deviceSettingsMesg.addField(Field("autosync_min_steps", AutosyncMinStepsFieldNum, 132, 1.0, 0.0, "steps", false, Profile.Type.UINT16))
            deviceSettingsMesg.addField(Field("autosync_min_time", AutosyncMinTimeFieldNum, 132, 1.0, 0.0, "minutes", false, Profile.Type.UINT16))
            deviceSettingsMesg.addField(Field("lactate_threshold_autodetect_enabled", LactateThresholdAutodetectEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            deviceSettingsMesg.addField(Field("ble_auto_upload_enabled", BleAutoUploadEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            deviceSettingsMesg.addField(Field("auto_sync_frequency", AutoSyncFrequencyFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.AUTO_SYNC_FREQUENCY))
            deviceSettingsMesg.addField(Field("auto_activity_detect", AutoActivityDetectFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.AUTO_ACTIVITY_DETECT))
            deviceSettingsMesg.addField(Field("number_of_screens", NumberOfScreensFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            deviceSettingsMesg.addField(Field("smart_notification_display_orientation", SmartNotificationDisplayOrientationFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_ORIENTATION))
            deviceSettingsMesg.addField(Field("tap_interface", TapInterfaceFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SWITCH))
            deviceSettingsMesg.addField(Field("tap_sensitivity", TapSensitivityFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.TAP_SENSITIVITY))
            deviceSettingsMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.DEVICE_SETTINGS))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get active_time_zone field
     * Comment: Index into time zone arrays.
     *
     * @return active_time_zone
     */
    var activeTimeZone: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activeTimeZone) {
            setFieldValue(0, 0, activeTimeZone, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get utc_offset field
     * Comment: Offset from system time. Required to convert timestamp from system time to UTC.
     *
     * @return utc_offset
     */
    var utcOffset: Long?
        get() {
            return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(utcOffset) {
            setFieldValue(1, 0, utcOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getTimeOffset(): Array<Long?>? {
        return getFieldLongValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_offset
     */
    fun getNumTimeOffset(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_offset field
     * Units: s
     * Comment: Offset from system time.
     *
     * @param index of time_offset
     * @return time_offset
     */
    fun getTimeOffset(index: Int): Long? {
        return getFieldLongValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_offset field
     * Units: s
     * Comment: Offset from system time.
     *
     * @param index of time_offset
     * @param timeOffset The new timeOffset value to be set
     */
    fun setTimeOffset(index: Int, timeOffset: Long?) {
        setFieldValue(2, index, timeOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeMode(): Array<TimeMode> {
        val values = getFieldShortValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)!!
        return Array(values.size) { i -> TimeMode.fromValue(values[i]) }
    }

    /**
     * @return number of time_mode
     */
    fun getNumTimeMode(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_mode field
     * Comment: Display mode for the time
     *
     * @param index of time_mode
     * @return time_mode
     */
    fun getTimeMode(index: Int): TimeMode? {
        val value = getFieldShortValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return TimeMode.fromValue(value)
    }

    /**
     * Set time_mode field
     * Comment: Display mode for the time
     *
     * @param index of time_mode
     * @param timeMode The new timeMode value to be set
     */
    fun setTimeMode(index: Int, timeMode: TimeMode?) {
        setFieldValue(4, index, timeMode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTimeZoneOffset(): Array<Float?>? {
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time_zone_offset
     */
    fun getNumTimeZoneOffset(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_zone_offset field
     * Units: hr
     * Comment: timezone offset in 1/4 hour increments
     *
     * @param index of time_zone_offset
     * @return time_zone_offset
     */
    fun getTimeZoneOffset(index: Int): Float? {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time_zone_offset field
     * Units: hr
     * Comment: timezone offset in 1/4 hour increments
     *
     * @param index of time_zone_offset
     * @param timeZoneOffset The new timeZoneOffset value to be set
     */
    fun setTimeZoneOffset(index: Int, timeZoneOffset: Float?) {
        setFieldValue(5, index, timeZoneOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get backlight_mode field
     * Comment: Mode for backlight
     *
     * @return backlight_mode
     */
    var backlightMode: BacklightMode?
        get() {
            val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return BacklightMode.fromValue(value)
        }
        set(backlightMode) {
            setFieldValue(12, 0, backlightMode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_tracker_enabled field
     * Comment: Enabled state of the activity tracker functionality
     *
     * @return activity_tracker_enabled
     */
    var activityTrackerEnabled: Bool?
        get() {
            val value = getFieldShortValue(36, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(activityTrackerEnabled) {
            setFieldValue(36, 0, activityTrackerEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get clock_time field
     * Comment: UTC timestamp used to set the devices clock and date
     *
     * @return clock_time
     */
    var clockTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(39, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(clockTime) {
            setFieldValue(39, 0, clockTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getPagesEnabled(): Array<Int?>? {
        return getFieldIntegerValues(40, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of pages_enabled
     */
    fun getNumPagesEnabled(): Int {
        return getNumFieldValues(40, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pages_enabled field
     * Comment: Bitfield to configure enabled screens for each supported loop
     *
     * @param index of pages_enabled
     * @return pages_enabled
     */
    fun getPagesEnabled(index: Int): Int? {
        return getFieldIntegerValue(40, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set pages_enabled field
     * Comment: Bitfield to configure enabled screens for each supported loop
     *
     * @param index of pages_enabled
     * @param pagesEnabled The new pagesEnabled value to be set
     */
    fun setPagesEnabled(index: Int, pagesEnabled: Int?) {
        setFieldValue(40, index, pagesEnabled, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get move_alert_enabled field
     * Comment: Enabled state of the move alert
     *
     * @return move_alert_enabled
     */
    var moveAlertEnabled: Bool?
        get() {
            val value = getFieldShortValue(46, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(moveAlertEnabled) {
            setFieldValue(46, 0, moveAlertEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get date_mode field
     * Comment: Display mode for the date
     *
     * @return date_mode
     */
    var dateMode: DateMode?
        get() {
            val value = getFieldShortValue(47, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DateMode.fromValue(value)
        }
        set(dateMode) {
            setFieldValue(47, 0, dateMode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get display_orientation field
     *
     * @return display_orientation
     */
    var displayOrientation: DisplayOrientation?
        get() {
            val value = getFieldShortValue(55, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayOrientation.fromValue(value)
        }
        set(displayOrientation) {
            setFieldValue(55, 0, displayOrientation?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get mounting_side field
     *
     * @return mounting_side
     */
    var mountingSide: Side?
        get() {
            val value = getFieldShortValue(56, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Side.fromValue(value)
        }
        set(mountingSide) {
            setFieldValue(56, 0, mountingSide?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getDefaultPage(): Array<Int?>? {
        return getFieldIntegerValues(57, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of default_page
     */
    fun getNumDefaultPage(): Int {
        return getNumFieldValues(57, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get default_page field
     * Comment: Bitfield to indicate one page as default for each supported loop
     *
     * @param index of default_page
     * @return default_page
     */
    fun getDefaultPage(index: Int): Int? {
        return getFieldIntegerValue(57, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set default_page field
     * Comment: Bitfield to indicate one page as default for each supported loop
     *
     * @param index of default_page
     * @param defaultPage The new defaultPage value to be set
     */
    fun setDefaultPage(index: Int, defaultPage: Int?) {
        setFieldValue(57, index, defaultPage, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get autosync_min_steps field
     * Units: steps
     * Comment: Minimum steps before an autosync can occur
     *
     * @return autosync_min_steps
     */
    var autosyncMinSteps: Int?
        get() {
            return getFieldIntegerValue(58, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(autosyncMinSteps) {
            setFieldValue(58, 0, autosyncMinSteps, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get autosync_min_time field
     * Units: minutes
     * Comment: Minimum minutes before an autosync can occur
     *
     * @return autosync_min_time
     */
    var autosyncMinTime: Int?
        get() {
            return getFieldIntegerValue(59, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(autosyncMinTime) {
            setFieldValue(59, 0, autosyncMinTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get lactate_threshold_autodetect_enabled field
     * Comment: Enable auto-detect setting for the lactate threshold feature.
     *
     * @return lactate_threshold_autodetect_enabled
     */
    var lactateThresholdAutodetectEnabled: Bool?
        get() {
            val value = getFieldShortValue(80, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(lactateThresholdAutodetectEnabled) {
            setFieldValue(80, 0, lactateThresholdAutodetectEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ble_auto_upload_enabled field
     * Comment: Automatically upload using BLE
     *
     * @return ble_auto_upload_enabled
     */
    var bleAutoUploadEnabled: Bool?
        get() {
            val value = getFieldShortValue(86, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(bleAutoUploadEnabled) {
            setFieldValue(86, 0, bleAutoUploadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get auto_sync_frequency field
     * Comment: Helps to conserve battery by changing modes
     *
     * @return auto_sync_frequency
     */
    var autoSyncFrequency: AutoSyncFrequency?
        get() {
            val value = getFieldShortValue(89, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return AutoSyncFrequency.fromValue(value)
        }
        set(autoSyncFrequency) {
            setFieldValue(89, 0, autoSyncFrequency?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get auto_activity_detect field
     * Comment: Allows setting specific activities auto-activity detect enabled/disabled settings
     *
     * @return auto_activity_detect
     */
    var autoActivityDetect: Long?
        get() {
            return getFieldLongValue(90, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(autoActivityDetect) {
            setFieldValue(90, 0, autoActivityDetect, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get number_of_screens field
     * Comment: Number of screens configured to display
     *
     * @return number_of_screens
     */
    var numberOfScreens: Short?
        get() {
            return getFieldShortValue(94, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(numberOfScreens) {
            setFieldValue(94, 0, numberOfScreens, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get smart_notification_display_orientation field
     * Comment: Smart Notification display orientation
     *
     * @return smart_notification_display_orientation
     */
    var smartNotificationDisplayOrientation: DisplayOrientation?
        get() {
            val value = getFieldShortValue(95, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayOrientation.fromValue(value)
        }
        set(smartNotificationDisplayOrientation) {
            setFieldValue(95, 0, smartNotificationDisplayOrientation?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get tap_interface field
     *
     * @return tap_interface
     */
    var tapInterface: Switch?
        get() {
            val value = getFieldShortValue(134, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Switch.fromValue(value)
        }
        set(tapInterface) {
            setFieldValue(134, 0, tapInterface?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get tap_sensitivity field
     * Comment: Used to hold the tap threshold setting
     *
     * @return tap_sensitivity
     */
    var tapSensitivity: TapSensitivity?
        get() {
            val value = getFieldShortValue(174, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return TapSensitivity.fromValue(value)
        }
        set(tapSensitivity) {
            setFieldValue(174, 0, tapSensitivity?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
