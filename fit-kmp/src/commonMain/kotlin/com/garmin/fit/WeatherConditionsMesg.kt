/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WeatherConditionsMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class WeatherConditionsMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val WeatherReportFieldNum = 0
        const val TemperatureFieldNum = 1
        const val ConditionFieldNum = 2
        const val WindDirectionFieldNum = 3
        const val WindSpeedFieldNum = 4
        const val PrecipitationProbabilityFieldNum = 5
        const val TemperatureFeelsLikeFieldNum = 6
        const val RelativeHumidityFieldNum = 7
        const val LocationFieldNum = 8
        const val ObservedAtTimeFieldNum = 9
        const val ObservedLocationLatFieldNum = 10
        const val ObservedLocationLongFieldNum = 11
        const val DayOfWeekFieldNum = 12
        const val HighTemperatureFieldNum = 13
        const val LowTemperatureFieldNum = 14

        val weatherConditionsMesg: Mesg = run {
            // weather_conditions
            val weatherConditionsMesg = Mesg("weather_conditions", MesgNum.WEATHER_CONDITIONS)
            weatherConditionsMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            weatherConditionsMesg.addField(Field("weather_report", WeatherReportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WEATHER_REPORT))
            weatherConditionsMesg.addField(Field("temperature", TemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            weatherConditionsMesg.addField(Field("condition", ConditionFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WEATHER_STATUS))
            weatherConditionsMesg.addField(Field("wind_direction", WindDirectionFieldNum, 132, 1.0, 0.0, "degrees", false, Profile.Type.UINT16))
            weatherConditionsMesg.addField(Field("wind_speed", WindSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            weatherConditionsMesg.addField(Field("precipitation_probability", PrecipitationProbabilityFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            weatherConditionsMesg.addField(Field("temperature_feels_like", TemperatureFeelsLikeFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            weatherConditionsMesg.addField(Field("relative_humidity", RelativeHumidityFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            weatherConditionsMesg.addField(Field("location", LocationFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            weatherConditionsMesg.addField(Field("observed_at_time", ObservedAtTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            weatherConditionsMesg.addField(Field("observed_location_lat", ObservedLocationLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            weatherConditionsMesg.addField(Field("observed_location_long", ObservedLocationLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            weatherConditionsMesg.addField(Field("day_of_week", DayOfWeekFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DAY_OF_WEEK))
            weatherConditionsMesg.addField(Field("high_temperature", HighTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            weatherConditionsMesg.addField(Field("low_temperature", LowTemperatureFieldNum, 1, 1.0, 0.0, "C", false, Profile.Type.SINT8))
            weatherConditionsMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.WEATHER_CONDITIONS))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Comment: time of update for current conditions, else forecast time
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
     * Get weather_report field
     * Comment: Current or forecast
     *
     * @return weather_report
     */
    var weatherReport: WeatherReport?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return WeatherReport.fromValue(value)
        }
        set(weatherReport) {
            setFieldValue(0, 0, weatherReport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get temperature field
     * Units: C
     *
     * @return temperature
     */
    var temperature: Byte?
        get() {
            return getFieldByteValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(temperature) {
            setFieldValue(1, 0, temperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get condition field
     * Comment: Corresponds to GSC Response weatherIcon field
     *
     * @return condition
     */
    var condition: WeatherStatus?
        get() {
            val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return WeatherStatus.fromValue(value)
        }
        set(condition) {
            setFieldValue(2, 0, condition?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get wind_direction field
     * Units: degrees
     *
     * @return wind_direction
     */
    var windDirection: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(windDirection) {
            setFieldValue(3, 0, windDirection, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get wind_speed field
     * Units: m/s
     *
     * @return wind_speed
     */
    var windSpeed: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(windSpeed) {
            setFieldValue(4, 0, windSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get precipitation_probability field
     * Comment: range 0-100
     *
     * @return precipitation_probability
     */
    var precipitationProbability: Short?
        get() {
            return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(precipitationProbability) {
            setFieldValue(5, 0, precipitationProbability, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get temperature_feels_like field
     * Units: C
     * Comment: Heat Index if GCS heatIdx above or equal to 90F or wind chill if GCS windChill below or equal to 32F
     *
     * @return temperature_feels_like
     */
    var temperatureFeelsLike: Byte?
        get() {
            return getFieldByteValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(temperatureFeelsLike) {
            setFieldValue(6, 0, temperatureFeelsLike, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get relative_humidity field
     *
     * @return relative_humidity
     */
    var relativeHumidity: Short?
        get() {
            return getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(relativeHumidity) {
            setFieldValue(7, 0, relativeHumidity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get location field
     * Comment: string corresponding to GCS response location string
     *
     * @return location
     */
    var location: String?
        get() {
            return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(location) {
            setFieldValue(8, 0, location, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get observed_at_time field
     *
     * @return observed_at_time
     */
    var observedAtTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(observedAtTime) {
            setFieldValue(9, 0, observedAtTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get observed_location_lat field
     * Units: semicircles
     *
     * @return observed_location_lat
     */
    var observedLocationLat: Int?
        get() {
            return getFieldIntegerValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(observedLocationLat) {
            setFieldValue(10, 0, observedLocationLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get observed_location_long field
     * Units: semicircles
     *
     * @return observed_location_long
     */
    var observedLocationLong: Int?
        get() {
            return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(observedLocationLong) {
            setFieldValue(11, 0, observedLocationLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get day_of_week field
     *
     * @return day_of_week
     */
    var dayOfWeek: DayOfWeek?
        get() {
            val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DayOfWeek.fromValue(value)
        }
        set(dayOfWeek) {
            setFieldValue(12, 0, dayOfWeek?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get high_temperature field
     * Units: C
     *
     * @return high_temperature
     */
    var highTemperature: Byte?
        get() {
            return getFieldByteValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(highTemperature) {
            setFieldValue(13, 0, highTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get low_temperature field
     * Units: C
     *
     * @return low_temperature
     */
    var lowTemperature: Byte?
        get() {
            return getFieldByteValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(lowTemperature) {
            setFieldValue(14, 0, lowTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
