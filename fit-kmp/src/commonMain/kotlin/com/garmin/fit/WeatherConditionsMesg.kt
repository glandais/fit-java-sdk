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
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Comment: time of update for current conditions, else forecast time
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get weather_report field
     * Comment: Current or forecast
     *
     * @return weather_report
     */
    fun getWeatherReport(): WeatherReport? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return WeatherReport.fromValue(value)
    }

    /**
     * Set weather_report field
     * Comment: Current or forecast
     *
     * @param weatherReport The new weatherReport value to be set
     */
    fun setWeatherReport(weatherReport: WeatherReport?) {
        setFieldValue(0, 0, weatherReport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get temperature field
     * Units: C
     *
     * @return temperature
     */
    fun getTemperature(): Byte? {
        return getFieldByteValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set temperature field
     * Units: C
     *
     * @param temperature The new temperature value to be set
     */
    fun setTemperature(temperature: Byte?) {
        setFieldValue(1, 0, temperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get condition field
     * Comment: Corresponds to GSC Response weatherIcon field
     *
     * @return condition
     */
    fun getCondition(): WeatherStatus? {
        val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return WeatherStatus.fromValue(value)
    }

    /**
     * Set condition field
     * Comment: Corresponds to GSC Response weatherIcon field
     *
     * @param condition The new condition value to be set
     */
    fun setCondition(condition: WeatherStatus?) {
        setFieldValue(2, 0, condition?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get wind_direction field
     * Units: degrees
     *
     * @return wind_direction
     */
    fun getWindDirection(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set wind_direction field
     * Units: degrees
     *
     * @param windDirection The new windDirection value to be set
     */
    fun setWindDirection(windDirection: Int?) {
        setFieldValue(3, 0, windDirection, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get wind_speed field
     * Units: m/s
     *
     * @return wind_speed
     */
    fun getWindSpeed(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set wind_speed field
     * Units: m/s
     *
     * @param windSpeed The new windSpeed value to be set
     */
    fun setWindSpeed(windSpeed: Float?) {
        setFieldValue(4, 0, windSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get precipitation_probability field
     * Comment: range 0-100
     *
     * @return precipitation_probability
     */
    fun getPrecipitationProbability(): Short? {
        return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set precipitation_probability field
     * Comment: range 0-100
     *
     * @param precipitationProbability The new precipitationProbability value to be set
     */
    fun setPrecipitationProbability(precipitationProbability: Short?) {
        setFieldValue(5, 0, precipitationProbability, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get temperature_feels_like field
     * Units: C
     * Comment: Heat Index if GCS heatIdx above or equal to 90F or wind chill if GCS windChill below or equal to 32F
     *
     * @return temperature_feels_like
     */
    fun getTemperatureFeelsLike(): Byte? {
        return getFieldByteValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set temperature_feels_like field
     * Units: C
     * Comment: Heat Index if GCS heatIdx above or equal to 90F or wind chill if GCS windChill below or equal to 32F
     *
     * @param temperatureFeelsLike The new temperatureFeelsLike value to be set
     */
    fun setTemperatureFeelsLike(temperatureFeelsLike: Byte?) {
        setFieldValue(6, 0, temperatureFeelsLike, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get relative_humidity field
     *
     * @return relative_humidity
     */
    fun getRelativeHumidity(): Short? {
        return getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set relative_humidity field
     *
     * @param relativeHumidity The new relativeHumidity value to be set
     */
    fun setRelativeHumidity(relativeHumidity: Short?) {
        setFieldValue(7, 0, relativeHumidity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get location field
     * Comment: string corresponding to GCS response location string
     *
     * @return location
     */
    fun getLocation(): String? {
        return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set location field
     * Comment: string corresponding to GCS response location string
     *
     * @param location The new location value to be set
     */
    fun setLocation(location: String?) {
        setFieldValue(8, 0, location, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get observed_at_time field
     *
     * @return observed_at_time
     */
    fun getObservedAtTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set observed_at_time field
     *
     * @param observedAtTime The new observedAtTime value to be set
     */
    fun setObservedAtTime(observedAtTime: DateTime?) {
        setFieldValue(9, 0, observedAtTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get observed_location_lat field
     * Units: semicircles
     *
     * @return observed_location_lat
     */
    fun getObservedLocationLat(): Int? {
        return getFieldIntegerValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set observed_location_lat field
     * Units: semicircles
     *
     * @param observedLocationLat The new observedLocationLat value to be set
     */
    fun setObservedLocationLat(observedLocationLat: Int?) {
        setFieldValue(10, 0, observedLocationLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get observed_location_long field
     * Units: semicircles
     *
     * @return observed_location_long
     */
    fun getObservedLocationLong(): Int? {
        return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set observed_location_long field
     * Units: semicircles
     *
     * @param observedLocationLong The new observedLocationLong value to be set
     */
    fun setObservedLocationLong(observedLocationLong: Int?) {
        setFieldValue(11, 0, observedLocationLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get day_of_week field
     *
     * @return day_of_week
     */
    fun getDayOfWeek(): DayOfWeek? {
        val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DayOfWeek.fromValue(value)
    }

    /**
     * Set day_of_week field
     *
     * @param dayOfWeek The new dayOfWeek value to be set
     */
    fun setDayOfWeek(dayOfWeek: DayOfWeek?) {
        setFieldValue(12, 0, dayOfWeek?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get high_temperature field
     * Units: C
     *
     * @return high_temperature
     */
    fun getHighTemperature(): Byte? {
        return getFieldByteValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set high_temperature field
     * Units: C
     *
     * @param highTemperature The new highTemperature value to be set
     */
    fun setHighTemperature(highTemperature: Byte?) {
        setFieldValue(13, 0, highTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get low_temperature field
     * Units: C
     *
     * @return low_temperature
     */
    fun getLowTemperature(): Byte? {
        return getFieldByteValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set low_temperature field
     * Units: C
     *
     * @param lowTemperature The new lowTemperature value to be set
     */
    fun setLowTemperature(lowTemperature: Byte?) {
        setFieldValue(14, 0, lowTemperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
