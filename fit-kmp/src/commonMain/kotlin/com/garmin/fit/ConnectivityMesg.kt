/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ConnectivityMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ConnectivityMesg : Mesg {

    companion object {
        const val BluetoothEnabledFieldNum = 0
        const val BluetoothLeEnabledFieldNum = 1
        const val AntEnabledFieldNum = 2
        const val NameFieldNum = 3
        const val LiveTrackingEnabledFieldNum = 4
        const val WeatherConditionsEnabledFieldNum = 5
        const val WeatherAlertsEnabledFieldNum = 6
        const val AutoActivityUploadEnabledFieldNum = 7
        const val CourseDownloadEnabledFieldNum = 8
        const val WorkoutDownloadEnabledFieldNum = 9
        const val GpsEphemerisDownloadEnabledFieldNum = 10
        const val IncidentDetectionEnabledFieldNum = 11
        const val GrouptrackEnabledFieldNum = 12

        val connectivityMesg: Mesg = run {
            // connectivity
            val connectivityMesg = Mesg("connectivity", MesgNum.CONNECTIVITY)
            connectivityMesg.addField(Field("bluetooth_enabled", BluetoothEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("bluetooth_le_enabled", BluetoothLeEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("ant_enabled", AntEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            connectivityMesg.addField(Field("live_tracking_enabled", LiveTrackingEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("weather_conditions_enabled", WeatherConditionsEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("weather_alerts_enabled", WeatherAlertsEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("auto_activity_upload_enabled", AutoActivityUploadEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("course_download_enabled", CourseDownloadEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("workout_download_enabled", WorkoutDownloadEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("gps_ephemeris_download_enabled", GpsEphemerisDownloadEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("incident_detection_enabled", IncidentDetectionEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg.addField(Field("grouptrack_enabled", GrouptrackEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            connectivityMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.CONNECTIVITY))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get bluetooth_enabled field
     * Comment: Use Bluetooth for connectivity features
     *
     * @return bluetooth_enabled
     */
    fun getBluetoothEnabled(): Bool? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set bluetooth_enabled field
     * Comment: Use Bluetooth for connectivity features
     *
     * @param bluetoothEnabled The new bluetoothEnabled value to be set
     */
    fun setBluetoothEnabled(bluetoothEnabled: Bool?) {
        setFieldValue(0, 0, bluetoothEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get bluetooth_le_enabled field
     * Comment: Use Bluetooth Low Energy for connectivity features
     *
     * @return bluetooth_le_enabled
     */
    fun getBluetoothLeEnabled(): Bool? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set bluetooth_le_enabled field
     * Comment: Use Bluetooth Low Energy for connectivity features
     *
     * @param bluetoothLeEnabled The new bluetoothLeEnabled value to be set
     */
    fun setBluetoothLeEnabled(bluetoothLeEnabled: Bool?) {
        setFieldValue(1, 0, bluetoothLeEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get ant_enabled field
     * Comment: Use ANT for connectivity features
     *
     * @return ant_enabled
     */
    fun getAntEnabled(): Bool? {
        val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set ant_enabled field
     * Comment: Use ANT for connectivity features
     *
     * @param antEnabled The new antEnabled value to be set
     */
    fun setAntEnabled(antEnabled: Bool?) {
        setFieldValue(2, 0, antEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get name field
     *
     * @return name
     */
    override fun getName(): String? {
        return getFieldStringValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set name field
     *
     * @param name The new name value to be set
     */
    fun setName(name: String?) {
        setFieldValue(3, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get live_tracking_enabled field
     *
     * @return live_tracking_enabled
     */
    fun getLiveTrackingEnabled(): Bool? {
        val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set live_tracking_enabled field
     *
     * @param liveTrackingEnabled The new liveTrackingEnabled value to be set
     */
    fun setLiveTrackingEnabled(liveTrackingEnabled: Bool?) {
        setFieldValue(4, 0, liveTrackingEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get weather_conditions_enabled field
     *
     * @return weather_conditions_enabled
     */
    fun getWeatherConditionsEnabled(): Bool? {
        val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set weather_conditions_enabled field
     *
     * @param weatherConditionsEnabled The new weatherConditionsEnabled value to be set
     */
    fun setWeatherConditionsEnabled(weatherConditionsEnabled: Bool?) {
        setFieldValue(5, 0, weatherConditionsEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get weather_alerts_enabled field
     *
     * @return weather_alerts_enabled
     */
    fun getWeatherAlertsEnabled(): Bool? {
        val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set weather_alerts_enabled field
     *
     * @param weatherAlertsEnabled The new weatherAlertsEnabled value to be set
     */
    fun setWeatherAlertsEnabled(weatherAlertsEnabled: Bool?) {
        setFieldValue(6, 0, weatherAlertsEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get auto_activity_upload_enabled field
     *
     * @return auto_activity_upload_enabled
     */
    fun getAutoActivityUploadEnabled(): Bool? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set auto_activity_upload_enabled field
     *
     * @param autoActivityUploadEnabled The new autoActivityUploadEnabled value to be set
     */
    fun setAutoActivityUploadEnabled(autoActivityUploadEnabled: Bool?) {
        setFieldValue(7, 0, autoActivityUploadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get course_download_enabled field
     *
     * @return course_download_enabled
     */
    fun getCourseDownloadEnabled(): Bool? {
        val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set course_download_enabled field
     *
     * @param courseDownloadEnabled The new courseDownloadEnabled value to be set
     */
    fun setCourseDownloadEnabled(courseDownloadEnabled: Bool?) {
        setFieldValue(8, 0, courseDownloadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get workout_download_enabled field
     *
     * @return workout_download_enabled
     */
    fun getWorkoutDownloadEnabled(): Bool? {
        val value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set workout_download_enabled field
     *
     * @param workoutDownloadEnabled The new workoutDownloadEnabled value to be set
     */
    fun setWorkoutDownloadEnabled(workoutDownloadEnabled: Bool?) {
        setFieldValue(9, 0, workoutDownloadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get gps_ephemeris_download_enabled field
     *
     * @return gps_ephemeris_download_enabled
     */
    fun getGpsEphemerisDownloadEnabled(): Bool? {
        val value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set gps_ephemeris_download_enabled field
     *
     * @param gpsEphemerisDownloadEnabled The new gpsEphemerisDownloadEnabled value to be set
     */
    fun setGpsEphemerisDownloadEnabled(gpsEphemerisDownloadEnabled: Bool?) {
        setFieldValue(10, 0, gpsEphemerisDownloadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get incident_detection_enabled field
     *
     * @return incident_detection_enabled
     */
    fun getIncidentDetectionEnabled(): Bool? {
        val value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set incident_detection_enabled field
     *
     * @param incidentDetectionEnabled The new incidentDetectionEnabled value to be set
     */
    fun setIncidentDetectionEnabled(incidentDetectionEnabled: Bool?) {
        setFieldValue(11, 0, incidentDetectionEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get grouptrack_enabled field
     *
     * @return grouptrack_enabled
     */
    fun getGrouptrackEnabled(): Bool? {
        val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set grouptrack_enabled field
     *
     * @param grouptrackEnabled The new grouptrackEnabled value to be set
     */
    fun setGrouptrackEnabled(grouptrackEnabled: Bool?) {
        setFieldValue(12, 0, grouptrackEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
