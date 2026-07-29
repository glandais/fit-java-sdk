/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MonitoringMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class MonitoringMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val DeviceIndexFieldNum = 0
        const val CaloriesFieldNum = 1
        const val DistanceFieldNum = 2
        const val CyclesFieldNum = 3
        const val ActiveTimeFieldNum = 4
        const val ActivityTypeFieldNum = 5
        const val ActivitySubtypeFieldNum = 6
        const val ActivityLevelFieldNum = 7
        const val Distance16FieldNum = 8
        const val Cycles16FieldNum = 9
        const val ActiveTime16FieldNum = 10
        const val LocalTimestampFieldNum = 11
        const val TemperatureFieldNum = 12
        const val TemperatureMinFieldNum = 14
        const val TemperatureMaxFieldNum = 15
        const val ActivityTimeFieldNum = 16
        const val ActiveCaloriesFieldNum = 19
        const val CurrentActivityTypeIntensityFieldNum = 24
        const val TimestampMin8FieldNum = 25
        const val Timestamp16FieldNum = 26
        const val HeartRateFieldNum = 27
        const val IntensityFieldNum = 28
        const val DurationMinFieldNum = 29
        const val DurationFieldNum = 30
        const val AscentFieldNum = 31
        const val DescentFieldNum = 32
        const val ModerateActivityMinutesFieldNum = 33
        const val VigorousActivityMinutesFieldNum = 34

        val monitoringMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // monitoring
            val monitoringMesg = Mesg("monitoring", MesgNum.MONITORING)
            monitoringMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            monitoringMesg.addField(Field("device_index", DeviceIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.DEVICE_INDEX))
            field_index++
            monitoringMesg.addField(Field("calories", CaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("distance", DistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            monitoringMesg.addField(Field("cycles", CyclesFieldNum, 134, 2.0, 0.0, "cycles", false, Profile.Type.UINT32))
            subfield_index = 0
            monitoringMesg.fields[field_index].subFields.add(SubField("steps", 134, 1.0, 0.0, "steps"))
            monitoringMesg.fields[field_index].subFields[subfield_index].addMap(5, 6L)
            monitoringMesg.fields[field_index].subFields[subfield_index].addMap(5, 1L)
            subfield_index++
            monitoringMesg.fields[field_index].subFields.add(SubField("strokes", 134, 2.0, 0.0, "strokes"))
            monitoringMesg.fields[field_index].subFields[subfield_index].addMap(5, 2L)
            monitoringMesg.fields[field_index].subFields[subfield_index].addMap(5, 5L)
            subfield_index++
            field_index++
            monitoringMesg.addField(Field("active_time", ActiveTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            monitoringMesg.addField(Field("activity_type", ActivityTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ACTIVITY_TYPE))
            field_index++
            monitoringMesg.addField(Field("activity_subtype", ActivitySubtypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ACTIVITY_SUBTYPE))
            field_index++
            monitoringMesg.addField(Field("activity_level", ActivityLevelFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ACTIVITY_LEVEL))
            field_index++
            monitoringMesg.addField(Field("distance_16", Distance16FieldNum, 132, 1.0, 0.0, "100 * m", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("cycles_16", Cycles16FieldNum, 132, 1.0, 0.0, "2 * cycles (steps)", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("active_time_16", ActiveTime16FieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("local_timestamp", LocalTimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.LOCAL_DATE_TIME))
            field_index++
            monitoringMesg.addField(Field("temperature", TemperatureFieldNum, 131, 100.0, 0.0, "C", false, Profile.Type.SINT16))
            field_index++
            monitoringMesg.addField(Field("temperature_min", TemperatureMinFieldNum, 131, 100.0, 0.0, "C", false, Profile.Type.SINT16))
            field_index++
            monitoringMesg.addField(Field("temperature_max", TemperatureMaxFieldNum, 131, 100.0, 0.0, "C", false, Profile.Type.SINT16))
            field_index++
            monitoringMesg.addField(Field("activity_time", ActivityTimeFieldNum, 132, 1.0, 0.0, "minutes", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("active_calories", ActiveCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("current_activity_type_intensity", CurrentActivityTypeIntensityFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            monitoringMesg.fields[field_index].components.add(FieldComponent(5, false, 5, 1.0, 0.0)) // activity_type
            monitoringMesg.fields[field_index].components.add(FieldComponent(28, false, 3, 1.0, 0.0)) // intensity
            field_index++
            monitoringMesg.addField(Field("timestamp_min_8", TimestampMin8FieldNum, 2, 1.0, 0.0, "min", false, Profile.Type.UINT8))
            field_index++
            monitoringMesg.addField(Field("timestamp_16", Timestamp16FieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("heart_rate", HeartRateFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            field_index++
            monitoringMesg.addField(Field("intensity", IntensityFieldNum, 2, 10.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            monitoringMesg.addField(Field("duration_min", DurationMinFieldNum, 132, 1.0, 0.0, "min", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("duration", DurationFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            monitoringMesg.addField(Field("ascent", AscentFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            monitoringMesg.addField(Field("descent", DescentFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            monitoringMesg.addField(Field("moderate_activity_minutes", ModerateActivityMinutesFieldNum, 132, 1.0, 0.0, "minutes", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg.addField(Field("vigorous_activity_minutes", VigorousActivityMinutesFieldNum, 132, 1.0, 0.0, "minutes", false, Profile.Type.UINT16))
            field_index++
            monitoringMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.MONITORING))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Must align to logging interval, for example, time must be 00:00:00 for daily log.
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
     * Get device_index field
     * Comment: Associates this data to device_info message. Not required for file with single device (sensor).
     *
     * @return device_index
     */
    var deviceIndex: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(deviceIndex) {
            setFieldValue(0, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get calories field
     * Units: kcal
     * Comment: Accumulated total calories. Maintained by MonitoringReader for each activity_type. See SDK documentation
     *
     * @return calories
     */
    var calories: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(calories) {
            setFieldValue(1, 0, calories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get distance field
     * Units: m
     * Comment: Accumulated distance. Maintained by MonitoringReader for each activity_type. See SDK documentation.
     *
     * @return distance
     */
    var distance: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(distance) {
            setFieldValue(2, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cycles field
     * Units: cycles
     * Comment: Accumulated cycles. Maintained by MonitoringReader for each activity_type. See SDK documentation.
     *
     * @return cycles
     */
    var cycles: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cycles) {
            setFieldValue(3, 0, cycles, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get steps field
     * Units: steps
     *
     * @return steps
     */
    var steps: Long?
        get() {
            return getFieldLongValue(3, 0, Profile.SubFields.MONITORING_MESG_CYCLES_FIELD_STEPS)
        }
        set(steps) {
            setFieldValue(3, 0, steps, Profile.SubFields.MONITORING_MESG_CYCLES_FIELD_STEPS)
        }

    /**
     * Get strokes field
     * Units: strokes
     *
     * @return strokes
     */
    var strokes: Float?
        get() {
            return getFieldFloatValue(3, 0, Profile.SubFields.MONITORING_MESG_CYCLES_FIELD_STROKES)
        }
        set(strokes) {
            setFieldValue(3, 0, strokes, Profile.SubFields.MONITORING_MESG_CYCLES_FIELD_STROKES)
        }

    /**
     * Get active_time field
     * Units: s
     *
     * @return active_time
     */
    var activeTime: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activeTime) {
            setFieldValue(4, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_type field
     *
     * @return activity_type
     */
    var activityType: ActivityType?
        get() {
            val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ActivityType.fromValue(value)
        }
        set(activityType) {
            setFieldValue(5, 0, activityType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_subtype field
     *
     * @return activity_subtype
     */
    var activitySubtype: ActivitySubtype?
        get() {
            val value = getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ActivitySubtype.fromValue(value)
        }
        set(activitySubtype) {
            setFieldValue(6, 0, activitySubtype?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_level field
     *
     * @return activity_level
     */
    var activityLevel: ActivityLevel?
        get() {
            val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ActivityLevel.fromValue(value)
        }
        set(activityLevel) {
            setFieldValue(7, 0, activityLevel?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get distance_16 field
     * Units: 100 * m
     *
     * @return distance_16
     */
    var distance16: Int?
        get() {
            return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(distance16) {
            setFieldValue(8, 0, distance16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cycles_16 field
     * Units: 2 * cycles (steps)
     *
     * @return cycles_16
     */
    var cycles16: Int?
        get() {
            return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cycles16) {
            setFieldValue(9, 0, cycles16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get active_time_16 field
     * Units: s
     *
     * @return active_time_16
     */
    var activeTime16: Int?
        get() {
            return getFieldIntegerValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activeTime16) {
            setFieldValue(10, 0, activeTime16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get local_timestamp field
     * Comment: Must align to logging interval, for example, time must be 00:00:00 for daily log.
     *
     * @return local_timestamp
     */
    var localTimestamp: Long?
        get() {
            return getFieldLongValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(localTimestamp) {
            setFieldValue(11, 0, localTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get temperature field
     * Units: C
     * Comment: Avg temperature during the logging interval ended at timestamp
     *
     * @return temperature
     */
    var temperature: Float?
        get() {
            return getFieldFloatValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(temperature) {
            setFieldValue(12, 0, temperature, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get temperature_min field
     * Units: C
     * Comment: Min temperature during the logging interval ended at timestamp
     *
     * @return temperature_min
     */
    var temperatureMin: Float?
        get() {
            return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(temperatureMin) {
            setFieldValue(14, 0, temperatureMin, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get temperature_max field
     * Units: C
     * Comment: Max temperature during the logging interval ended at timestamp
     *
     * @return temperature_max
     */
    var temperatureMax: Float?
        get() {
            return getFieldFloatValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(temperatureMax) {
            setFieldValue(15, 0, temperatureMax, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getActivityTime(): Array<Int?>? {
        return getFieldIntegerValues(16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of activity_time
     */
    fun getNumActivityTime(): Int {
        return getNumFieldValues(16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get activity_time field
     * Units: minutes
     * Comment: Indexed using minute_activity_level enum
     *
     * @param index of activity_time
     * @return activity_time
     */
    fun getActivityTime(index: Int): Int? {
        return getFieldIntegerValue(16, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set activity_time field
     * Units: minutes
     * Comment: Indexed using minute_activity_level enum
     *
     * @param index of activity_time
     * @param activityTime The new activityTime value to be set
     */
    fun setActivityTime(index: Int, activityTime: Int?) {
        setFieldValue(16, index, activityTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get active_calories field
     * Units: kcal
     *
     * @return active_calories
     */
    var activeCalories: Int?
        get() {
            return getFieldIntegerValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activeCalories) {
            setFieldValue(19, 0, activeCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get current_activity_type_intensity field
     * Comment: Indicates single type / intensity for duration since last monitoring message.
     *
     * @return current_activity_type_intensity
     */
    var currentActivityTypeIntensity: Byte?
        get() {
            return getFieldByteValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(currentActivityTypeIntensity) {
            setFieldValue(24, 0, currentActivityTypeIntensity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get timestamp_min_8 field
     * Units: min
     *
     * @return timestamp_min_8
     */
    var timestampMin8: Short?
        get() {
            return getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timestampMin8) {
            setFieldValue(25, 0, timestampMin8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get timestamp_16 field
     * Units: s
     *
     * @return timestamp_16
     */
    var timestamp16: Int?
        get() {
            return getFieldIntegerValue(26, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timestamp16) {
            setFieldValue(26, 0, timestamp16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get heart_rate field
     * Units: bpm
     *
     * @return heart_rate
     */
    var heartRate: Short?
        get() {
            return getFieldShortValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(heartRate) {
            setFieldValue(27, 0, heartRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get intensity field
     *
     * @return intensity
     */
    var intensity: Float?
        get() {
            return getFieldFloatValue(28, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(intensity) {
            setFieldValue(28, 0, intensity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get duration_min field
     * Units: min
     *
     * @return duration_min
     */
    var durationMin: Int?
        get() {
            return getFieldIntegerValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(durationMin) {
            setFieldValue(29, 0, durationMin, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get duration field
     * Units: s
     *
     * @return duration
     */
    var duration: Long?
        get() {
            return getFieldLongValue(30, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(duration) {
            setFieldValue(30, 0, duration, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ascent field
     * Units: m
     *
     * @return ascent
     */
    var ascent: Float?
        get() {
            return getFieldFloatValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ascent) {
            setFieldValue(31, 0, ascent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get descent field
     * Units: m
     *
     * @return descent
     */
    var descent: Float?
        get() {
            return getFieldFloatValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(descent) {
            setFieldValue(32, 0, descent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get moderate_activity_minutes field
     * Units: minutes
     *
     * @return moderate_activity_minutes
     */
    var moderateActivityMinutes: Int?
        get() {
            return getFieldIntegerValue(33, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(moderateActivityMinutes) {
            setFieldValue(33, 0, moderateActivityMinutes, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get vigorous_activity_minutes field
     * Units: minutes
     *
     * @return vigorous_activity_minutes
     */
    var vigorousActivityMinutes: Int?
        get() {
            return getFieldIntegerValue(34, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(vigorousActivityMinutes) {
            setFieldValue(34, 0, vigorousActivityMinutes, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
