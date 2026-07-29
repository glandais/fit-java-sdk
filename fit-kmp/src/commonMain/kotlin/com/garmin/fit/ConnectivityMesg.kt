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
    var bluetoothEnabled: Bool?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(bluetoothEnabled) {
            setFieldValue(0, 0, bluetoothEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bluetooth_le_enabled field
     * Comment: Use Bluetooth Low Energy for connectivity features
     *
     * @return bluetooth_le_enabled
     */
    var bluetoothLeEnabled: Bool?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(bluetoothLeEnabled) {
            setFieldValue(1, 0, bluetoothLeEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ant_enabled field
     * Comment: Use ANT for connectivity features
     *
     * @return ant_enabled
     */
    var antEnabled: Bool?
        get() {
            val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(antEnabled) {
            setFieldValue(2, 0, antEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(3, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get live_tracking_enabled field
     *
     * @return live_tracking_enabled
     */
    var liveTrackingEnabled: Bool?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(liveTrackingEnabled) {
            setFieldValue(4, 0, liveTrackingEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get weather_conditions_enabled field
     *
     * @return weather_conditions_enabled
     */
    var weatherConditionsEnabled: Bool?
        get() {
            val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(weatherConditionsEnabled) {
            setFieldValue(5, 0, weatherConditionsEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get weather_alerts_enabled field
     *
     * @return weather_alerts_enabled
     */
    var weatherAlertsEnabled: Bool?
        get() {
            val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(weatherAlertsEnabled) {
            setFieldValue(6, 0, weatherAlertsEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get auto_activity_upload_enabled field
     *
     * @return auto_activity_upload_enabled
     */
    var autoActivityUploadEnabled: Bool?
        get() {
            val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(autoActivityUploadEnabled) {
            setFieldValue(7, 0, autoActivityUploadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get course_download_enabled field
     *
     * @return course_download_enabled
     */
    var courseDownloadEnabled: Bool?
        get() {
            val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(courseDownloadEnabled) {
            setFieldValue(8, 0, courseDownloadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get workout_download_enabled field
     *
     * @return workout_download_enabled
     */
    var workoutDownloadEnabled: Bool?
        get() {
            val value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(workoutDownloadEnabled) {
            setFieldValue(9, 0, workoutDownloadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get gps_ephemeris_download_enabled field
     *
     * @return gps_ephemeris_download_enabled
     */
    var gpsEphemerisDownloadEnabled: Bool?
        get() {
            val value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(gpsEphemerisDownloadEnabled) {
            setFieldValue(10, 0, gpsEphemerisDownloadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get incident_detection_enabled field
     *
     * @return incident_detection_enabled
     */
    var incidentDetectionEnabled: Bool?
        get() {
            val value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(incidentDetectionEnabled) {
            setFieldValue(11, 0, incidentDetectionEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get grouptrack_enabled field
     *
     * @return grouptrack_enabled
     */
    var grouptrackEnabled: Bool?
        get() {
            val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(grouptrackEnabled) {
            setFieldValue(12, 0, grouptrackEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
