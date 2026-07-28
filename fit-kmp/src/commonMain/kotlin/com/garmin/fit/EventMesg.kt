/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from EventMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class EventMesg : Mesg, MesgWithEvent {

    companion object {
        const val TimestampFieldNum = 253
        const val EventFieldNum = 0
        const val EventTypeFieldNum = 1
        const val Data16FieldNum = 2
        const val DataFieldNum = 3
        const val EventGroupFieldNum = 4
        const val ScoreFieldNum = 7
        const val OpponentScoreFieldNum = 8
        const val FrontGearNumFieldNum = 9
        const val FrontGearFieldNum = 10
        const val RearGearNumFieldNum = 11
        const val RearGearFieldNum = 12
        const val DeviceIndexFieldNum = 13
        const val ActivityTypeFieldNum = 14
        const val StartTimestampFieldNum = 15
        const val RadarThreatLevelMaxFieldNum = 21
        const val RadarThreatCountFieldNum = 22
        const val RadarThreatAvgApproachSpeedFieldNum = 23
        const val RadarThreatMaxApproachSpeedFieldNum = 24

        val eventMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // event
            val eventMesg = Mesg("event", MesgNum.EVENT)
            eventMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            eventMesg.addField(Field("event", EventFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT))
            field_index++
            eventMesg.addField(Field("event_type", EventTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT_TYPE))
            field_index++
            eventMesg.addField(Field("data16", Data16FieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            eventMesg.fields[field_index].components.add(FieldComponent(3, false, 16, 1.0, 0.0)) // data
            field_index++
            eventMesg.addField(Field("data", DataFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            eventMesg.fields[field_index].subFields.add(SubField("timer_trigger", 0, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 0L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("course_point_index", 132, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 10L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("battery_level", 132, 1000.0, 0.0, "V"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 11L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("virtual_partner_speed", 132, 1000.0, 0.0, "m/s"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 12L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("hr_high_alert", 2, 1.0, 0.0, "bpm"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 13L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("hr_low_alert", 2, 1.0, 0.0, "bpm"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 14L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("speed_high_alert", 134, 1000.0, 0.0, "m/s"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 15L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("speed_low_alert", 134, 1000.0, 0.0, "m/s"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 16L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("cad_high_alert", 132, 1.0, 0.0, "rpm"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 17L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("cad_low_alert", 132, 1.0, 0.0, "rpm"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 18L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("power_high_alert", 132, 1.0, 0.0, "watts"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 19L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("power_low_alert", 132, 1.0, 0.0, "watts"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 20L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("time_duration_alert", 134, 1000.0, 0.0, "s"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 23L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("distance_duration_alert", 134, 100.0, 0.0, "m"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 24L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("calorie_duration_alert", 134, 1.0, 0.0, "calories"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 25L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("fitness_equipment_state", 0, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 27L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("sport_point", 134, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 33L)
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(7, false, 16, 1.0, 0.0))
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(8, false, 16, 1.0, 0.0))
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("gear_change_data", 134, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 42L)
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 43L)
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(11, false, 8, 1.0, 0.0))
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(12, false, 8, 1.0, 0.0))
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(9, false, 8, 1.0, 0.0))
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(10, false, 8, 1.0, 0.0))
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("rider_position", 0, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 44L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("comm_timeout", 132, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 47L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("dive_alert", 0, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 56L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("auto_activity_detect_duration", 132, 1.0, 0.0, "min"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 54L)
            subfield_index++
            eventMesg.fields[field_index].subFields.add(SubField("radar_threat_alert", 134, 1.0, 0.0, ""))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 75L)
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(21, false, 8, 1.0, 0.0))
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(22, false, 8, 1.0, 0.0))
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(23, false, 8, 10.0, 0.0))
            eventMesg.fields[field_index].subFields[subfield_index].addComponent(FieldComponent(24, false, 8, 10.0, 0.0))
            subfield_index++
            field_index++
            eventMesg.addField(Field("event_group", EventGroupFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            eventMesg.addField(Field("score", ScoreFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            eventMesg.addField(Field("opponent_score", OpponentScoreFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            eventMesg.addField(Field("front_gear_num", FrontGearNumFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            field_index++
            eventMesg.addField(Field("front_gear", FrontGearFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            field_index++
            eventMesg.addField(Field("rear_gear_num", RearGearNumFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            field_index++
            eventMesg.addField(Field("rear_gear", RearGearFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            field_index++
            eventMesg.addField(Field("device_index", DeviceIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.DEVICE_INDEX))
            field_index++
            eventMesg.addField(Field("activity_type", ActivityTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ACTIVITY_TYPE))
            field_index++
            eventMesg.addField(Field("start_timestamp", StartTimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            subfield_index = 0
            eventMesg.fields[field_index].subFields.add(SubField("auto_activity_detect_start_timestamp", 134, 1.0, 0.0, "s"))
            eventMesg.fields[field_index].subFields[subfield_index].addMap(0, 54L)
            subfield_index++
            field_index++
            eventMesg.addField(Field("radar_threat_level_max", RadarThreatLevelMaxFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.RADAR_THREAT_LEVEL_TYPE))
            field_index++
            eventMesg.addField(Field("radar_threat_count", RadarThreatCountFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            eventMesg.addField(Field("radar_threat_avg_approach_speed", RadarThreatAvgApproachSpeedFieldNum, 2, 10.0, 0.0, "m/s", false, Profile.Type.UINT8))
            field_index++
            eventMesg.addField(Field("radar_threat_max_approach_speed", RadarThreatMaxApproachSpeedFieldNum, 2, 10.0, 0.0, "m/s", false, Profile.Type.UINT8))
            field_index++
            eventMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.EVENT))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    override fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    override fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event field
     *
     * @return event
     */
    override fun getEvent(): Event? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Event.fromValue(value)
    }

    /**
     * Set event field
     *
     * @param event The new event value to be set
     */
    override fun setEvent(event: Event?) {
        setFieldValue(0, 0, event?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event_type field
     *
     * @return event_type
     */
    override fun getEventType(): EventType? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return EventType.fromValue(value)
    }

    /**
     * Set event_type field
     *
     * @param eventType The new eventType value to be set
     */
    override fun setEventType(eventType: EventType?) {
        setFieldValue(1, 0, eventType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data16 field
     *
     * @return data16
     */
    fun getData16(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set data16 field
     *
     * @param data16 The new data16 value to be set
     */
    fun setData16(data16: Int?) {
        setFieldValue(2, 0, data16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data field
     *
     * @return data
     */
    fun getData(): Long? {
        return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set data field
     *
     * @param data The new data value to be set
     */
    fun setData(data: Long?) {
        setFieldValue(3, 0, data, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timer_trigger field
     *
     * @return timer_trigger
     */
    fun getTimerTrigger(): TimerTrigger? {
        val value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIMER_TRIGGER) ?: return null
        return TimerTrigger.fromValue(value)
    }

    /**
     * Set timer_trigger field
     *
     * @param timerTrigger The new timerTrigger value to be set
     */
    fun setTimerTrigger(timerTrigger: TimerTrigger?) {
        setFieldValue(3, 0, timerTrigger?.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIMER_TRIGGER)
    }

    /**
     * Get course_point_index field
     *
     * @return course_point_index
     */
    fun getCoursePointIndex(): Int? {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_COURSE_POINT_INDEX)
    }

    /**
     * Set course_point_index field
     *
     * @param coursePointIndex The new coursePointIndex value to be set
     */
    fun setCoursePointIndex(coursePointIndex: Int?) {
        setFieldValue(3, 0, coursePointIndex, Profile.SubFields.EVENT_MESG_DATA_FIELD_COURSE_POINT_INDEX)
    }

    /**
     * Get battery_level field
     * Units: V
     *
     * @return battery_level
     */
    fun getBatteryLevel(): Float? {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_BATTERY_LEVEL)
    }

    /**
     * Set battery_level field
     * Units: V
     *
     * @param batteryLevel The new batteryLevel value to be set
     */
    fun setBatteryLevel(batteryLevel: Float?) {
        setFieldValue(3, 0, batteryLevel, Profile.SubFields.EVENT_MESG_DATA_FIELD_BATTERY_LEVEL)
    }

    /**
     * Get virtual_partner_speed field
     * Units: m/s
     *
     * @return virtual_partner_speed
     */
    fun getVirtualPartnerSpeed(): Float? {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_VIRTUAL_PARTNER_SPEED)
    }

    /**
     * Set virtual_partner_speed field
     * Units: m/s
     *
     * @param virtualPartnerSpeed The new virtualPartnerSpeed value to be set
     */
    fun setVirtualPartnerSpeed(virtualPartnerSpeed: Float?) {
        setFieldValue(3, 0, virtualPartnerSpeed, Profile.SubFields.EVENT_MESG_DATA_FIELD_VIRTUAL_PARTNER_SPEED)
    }

    /**
     * Get hr_high_alert field
     * Units: bpm
     *
     * @return hr_high_alert
     */
    fun getHrHighAlert(): Short? {
        return getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_HIGH_ALERT)
    }

    /**
     * Set hr_high_alert field
     * Units: bpm
     *
     * @param hrHighAlert The new hrHighAlert value to be set
     */
    fun setHrHighAlert(hrHighAlert: Short?) {
        setFieldValue(3, 0, hrHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_HIGH_ALERT)
    }

    /**
     * Get hr_low_alert field
     * Units: bpm
     *
     * @return hr_low_alert
     */
    fun getHrLowAlert(): Short? {
        return getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_LOW_ALERT)
    }

    /**
     * Set hr_low_alert field
     * Units: bpm
     *
     * @param hrLowAlert The new hrLowAlert value to be set
     */
    fun setHrLowAlert(hrLowAlert: Short?) {
        setFieldValue(3, 0, hrLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_LOW_ALERT)
    }

    /**
     * Get speed_high_alert field
     * Units: m/s
     *
     * @return speed_high_alert
     */
    fun getSpeedHighAlert(): Float? {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_HIGH_ALERT)
    }

    /**
     * Set speed_high_alert field
     * Units: m/s
     *
     * @param speedHighAlert The new speedHighAlert value to be set
     */
    fun setSpeedHighAlert(speedHighAlert: Float?) {
        setFieldValue(3, 0, speedHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_HIGH_ALERT)
    }

    /**
     * Get speed_low_alert field
     * Units: m/s
     *
     * @return speed_low_alert
     */
    fun getSpeedLowAlert(): Float? {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_LOW_ALERT)
    }

    /**
     * Set speed_low_alert field
     * Units: m/s
     *
     * @param speedLowAlert The new speedLowAlert value to be set
     */
    fun setSpeedLowAlert(speedLowAlert: Float?) {
        setFieldValue(3, 0, speedLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_LOW_ALERT)
    }

    /**
     * Get cad_high_alert field
     * Units: rpm
     *
     * @return cad_high_alert
     */
    fun getCadHighAlert(): Int? {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_HIGH_ALERT)
    }

    /**
     * Set cad_high_alert field
     * Units: rpm
     *
     * @param cadHighAlert The new cadHighAlert value to be set
     */
    fun setCadHighAlert(cadHighAlert: Int?) {
        setFieldValue(3, 0, cadHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_HIGH_ALERT)
    }

    /**
     * Get cad_low_alert field
     * Units: rpm
     *
     * @return cad_low_alert
     */
    fun getCadLowAlert(): Int? {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_LOW_ALERT)
    }

    /**
     * Set cad_low_alert field
     * Units: rpm
     *
     * @param cadLowAlert The new cadLowAlert value to be set
     */
    fun setCadLowAlert(cadLowAlert: Int?) {
        setFieldValue(3, 0, cadLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_LOW_ALERT)
    }

    /**
     * Get power_high_alert field
     * Units: watts
     *
     * @return power_high_alert
     */
    fun getPowerHighAlert(): Int? {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_HIGH_ALERT)
    }

    /**
     * Set power_high_alert field
     * Units: watts
     *
     * @param powerHighAlert The new powerHighAlert value to be set
     */
    fun setPowerHighAlert(powerHighAlert: Int?) {
        setFieldValue(3, 0, powerHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_HIGH_ALERT)
    }

    /**
     * Get power_low_alert field
     * Units: watts
     *
     * @return power_low_alert
     */
    fun getPowerLowAlert(): Int? {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_LOW_ALERT)
    }

    /**
     * Set power_low_alert field
     * Units: watts
     *
     * @param powerLowAlert The new powerLowAlert value to be set
     */
    fun setPowerLowAlert(powerLowAlert: Int?) {
        setFieldValue(3, 0, powerLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_LOW_ALERT)
    }

    /**
     * Get time_duration_alert field
     * Units: s
     *
     * @return time_duration_alert
     */
    fun getTimeDurationAlert(): Float? {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIME_DURATION_ALERT)
    }

    /**
     * Set time_duration_alert field
     * Units: s
     *
     * @param timeDurationAlert The new timeDurationAlert value to be set
     */
    fun setTimeDurationAlert(timeDurationAlert: Float?) {
        setFieldValue(3, 0, timeDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIME_DURATION_ALERT)
    }

    /**
     * Get distance_duration_alert field
     * Units: m
     *
     * @return distance_duration_alert
     */
    fun getDistanceDurationAlert(): Float? {
        return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_DISTANCE_DURATION_ALERT)
    }

    /**
     * Set distance_duration_alert field
     * Units: m
     *
     * @param distanceDurationAlert The new distanceDurationAlert value to be set
     */
    fun setDistanceDurationAlert(distanceDurationAlert: Float?) {
        setFieldValue(3, 0, distanceDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_DISTANCE_DURATION_ALERT)
    }

    /**
     * Get calorie_duration_alert field
     * Units: calories
     *
     * @return calorie_duration_alert
     */
    fun getCalorieDurationAlert(): Long? {
        return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CALORIE_DURATION_ALERT)
    }

    /**
     * Set calorie_duration_alert field
     * Units: calories
     *
     * @param calorieDurationAlert The new calorieDurationAlert value to be set
     */
    fun setCalorieDurationAlert(calorieDurationAlert: Long?) {
        setFieldValue(3, 0, calorieDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CALORIE_DURATION_ALERT)
    }

    /**
     * Get fitness_equipment_state field
     *
     * @return fitness_equipment_state
     */
    fun getFitnessEquipmentState(): FitnessEquipmentState? {
        val value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_FITNESS_EQUIPMENT_STATE) ?: return null
        return FitnessEquipmentState.fromValue(value)
    }

    /**
     * Set fitness_equipment_state field
     *
     * @param fitnessEquipmentState The new fitnessEquipmentState value to be set
     */
    fun setFitnessEquipmentState(fitnessEquipmentState: FitnessEquipmentState?) {
        setFieldValue(3, 0, fitnessEquipmentState?.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_FITNESS_EQUIPMENT_STATE)
    }

    /**
     * Get sport_point field
     *
     * @return sport_point
     */
    fun getSportPoint(): Long? {
        return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPORT_POINT)
    }

    /**
     * Set sport_point field
     *
     * @param sportPoint The new sportPoint value to be set
     */
    fun setSportPoint(sportPoint: Long?) {
        setFieldValue(3, 0, sportPoint, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPORT_POINT)
    }

    /**
     * Get gear_change_data field
     *
     * @return gear_change_data
     */
    fun getGearChangeData(): Long? {
        return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_GEAR_CHANGE_DATA)
    }

    /**
     * Set gear_change_data field
     *
     * @param gearChangeData The new gearChangeData value to be set
     */
    fun setGearChangeData(gearChangeData: Long?) {
        setFieldValue(3, 0, gearChangeData, Profile.SubFields.EVENT_MESG_DATA_FIELD_GEAR_CHANGE_DATA)
    }

    /**
     * Get rider_position field
     * Comment: Indicates the rider position value.
     *
     * @return rider_position
     */
    fun getRiderPosition(): RiderPositionType? {
        val value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_RIDER_POSITION) ?: return null
        return RiderPositionType.fromValue(value)
    }

    /**
     * Set rider_position field
     * Comment: Indicates the rider position value.
     *
     * @param riderPosition The new riderPosition value to be set
     */
    fun setRiderPosition(riderPosition: RiderPositionType?) {
        setFieldValue(3, 0, riderPosition?.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_RIDER_POSITION)
    }

    /**
     * Get comm_timeout field
     *
     * @return comm_timeout
     */
    fun getCommTimeout(): Int? {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_COMM_TIMEOUT)
    }

    /**
     * Set comm_timeout field
     *
     * @param commTimeout The new commTimeout value to be set
     */
    fun setCommTimeout(commTimeout: Int?) {
        setFieldValue(3, 0, commTimeout, Profile.SubFields.EVENT_MESG_DATA_FIELD_COMM_TIMEOUT)
    }

    /**
     * Get dive_alert field
     *
     * @return dive_alert
     */
    fun getDiveAlert(): DiveAlert? {
        val value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_DIVE_ALERT) ?: return null
        return DiveAlert.fromValue(value)
    }

    /**
     * Set dive_alert field
     *
     * @param diveAlert The new diveAlert value to be set
     */
    fun setDiveAlert(diveAlert: DiveAlert?) {
        setFieldValue(3, 0, diveAlert?.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_DIVE_ALERT)
    }

    /**
     * Get auto_activity_detect_duration field
     * Units: min
     *
     * @return auto_activity_detect_duration
     */
    fun getAutoActivityDetectDuration(): Int? {
        return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_AUTO_ACTIVITY_DETECT_DURATION)
    }

    /**
     * Set auto_activity_detect_duration field
     * Units: min
     *
     * @param autoActivityDetectDuration The new autoActivityDetectDuration value to be set
     */
    fun setAutoActivityDetectDuration(autoActivityDetectDuration: Int?) {
        setFieldValue(3, 0, autoActivityDetectDuration, Profile.SubFields.EVENT_MESG_DATA_FIELD_AUTO_ACTIVITY_DETECT_DURATION)
    }

    /**
     * Get radar_threat_alert field
     * Comment: The first byte is the radar_threat_level_max, the second byte is the radar_threat_count, third bytes is the average approach speed, and the 4th byte is the max approach speed
     *
     * @return radar_threat_alert
     */
    fun getRadarThreatAlert(): Long? {
        return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_RADAR_THREAT_ALERT)
    }

    /**
     * Set radar_threat_alert field
     * Comment: The first byte is the radar_threat_level_max, the second byte is the radar_threat_count, third bytes is the average approach speed, and the 4th byte is the max approach speed
     *
     * @param radarThreatAlert The new radarThreatAlert value to be set
     */
    fun setRadarThreatAlert(radarThreatAlert: Long?) {
        setFieldValue(3, 0, radarThreatAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_RADAR_THREAT_ALERT)
    }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override fun getEventGroup(): Short? {
        return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set event_group field
     *
     * @param eventGroup The new eventGroup value to be set
     */
    override fun setEventGroup(eventGroup: Short?) {
        setFieldValue(4, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @return score
     */
    fun getScore(): Int? {
        return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @param score The new score value to be set
     */
    fun setScore(score: Int?) {
        setFieldValue(7, 0, score, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get opponent_score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @return opponent_score
     */
    fun getOpponentScore(): Int? {
        return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set opponent_score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @param opponentScore The new opponentScore value to be set
     */
    fun setOpponentScore(opponentScore: Int?) {
        setFieldValue(8, 0, opponentScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get front_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Front gear number. 1 is innermost.
     *
     * @return front_gear_num
     */
    fun getFrontGearNum(): Short? {
        return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set front_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Front gear number. 1 is innermost.
     *
     * @param frontGearNum The new frontGearNum value to be set
     */
    fun setFrontGearNum(frontGearNum: Short?) {
        setFieldValue(9, 0, frontGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get front_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of front teeth.
     *
     * @return front_gear
     */
    fun getFrontGear(): Short? {
        return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set front_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of front teeth.
     *
     * @param frontGear The new frontGear value to be set
     */
    fun setFrontGear(frontGear: Short?) {
        setFieldValue(10, 0, frontGear, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get rear_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Rear gear number. 1 is innermost.
     *
     * @return rear_gear_num
     */
    fun getRearGearNum(): Short? {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set rear_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Rear gear number. 1 is innermost.
     *
     * @param rearGearNum The new rearGearNum value to be set
     */
    fun setRearGearNum(rearGearNum: Short?) {
        setFieldValue(11, 0, rearGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get rear_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of rear teeth.
     *
     * @return rear_gear
     */
    fun getRearGear(): Short? {
        return getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set rear_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of rear teeth.
     *
     * @param rearGear The new rearGear value to be set
     */
    fun setRearGear(rearGear: Short?) {
        setFieldValue(12, 0, rearGear, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    fun getDeviceIndex(): Short? {
        return getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set device_index field
     *
     * @param deviceIndex The new deviceIndex value to be set
     */
    fun setDeviceIndex(deviceIndex: Short?) {
        setFieldValue(13, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get activity_type field
     * Comment: Activity Type associated with an auto_activity_detect event
     *
     * @return activity_type
     */
    fun getActivityType(): ActivityType? {
        val value = getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return ActivityType.fromValue(value)
    }

    /**
     * Set activity_type field
     * Comment: Activity Type associated with an auto_activity_detect event
     *
     * @param activityType The new activityType value to be set
     */
    fun setActivityType(activityType: ActivityType?) {
        setFieldValue(14, 0, activityType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get start_timestamp field
     * Units: s
     * Comment: Timestamp of when the event started
     *
     * @return start_timestamp
     */
    fun getStartTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set start_timestamp field
     * Units: s
     * Comment: Timestamp of when the event started
     *
     * @param startTimestamp The new startTimestamp value to be set
     */
    fun setStartTimestamp(startTimestamp: DateTime?) {
        setFieldValue(15, 0, startTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get auto_activity_detect_start_timestamp field
     * Units: s
     * Comment: Auto Activity Detect Start Timestamp.
     *
     * @return auto_activity_detect_start_timestamp
     */
    fun getAutoActivityDetectStartTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(15, 0, Profile.SubFields.EVENT_MESG_START_TIMESTAMP_FIELD_AUTO_ACTIVITY_DETECT_START_TIMESTAMP))
    }

    /**
     * Set auto_activity_detect_start_timestamp field
     * Units: s
     * Comment: Auto Activity Detect Start Timestamp.
     *
     * @param autoActivityDetectStartTimestamp The new autoActivityDetectStartTimestamp value to be set
     */
    fun setAutoActivityDetectStartTimestamp(autoActivityDetectStartTimestamp: DateTime?) {
        setFieldValue(15, 0, autoActivityDetectStartTimestamp?.getTimestamp(), Profile.SubFields.EVENT_MESG_START_TIMESTAMP_FIELD_AUTO_ACTIVITY_DETECT_START_TIMESTAMP)
    }

    /**
     * Get radar_threat_level_max field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @return radar_threat_level_max
     */
    fun getRadarThreatLevelMax(): RadarThreatLevelType? {
        val value = getFieldShortValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return RadarThreatLevelType.fromValue(value)
    }

    /**
     * Set radar_threat_level_max field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @param radarThreatLevelMax The new radarThreatLevelMax value to be set
     */
    fun setRadarThreatLevelMax(radarThreatLevelMax: RadarThreatLevelType?) {
        setFieldValue(21, 0, radarThreatLevelMax?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get radar_threat_count field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @return radar_threat_count
     */
    fun getRadarThreatCount(): Short? {
        return getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set radar_threat_count field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @param radarThreatCount The new radarThreatCount value to be set
     */
    fun setRadarThreatCount(radarThreatCount: Short?) {
        setFieldValue(22, 0, radarThreatCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get radar_threat_avg_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @return radar_threat_avg_approach_speed
     */
    fun getRadarThreatAvgApproachSpeed(): Float? {
        return getFieldFloatValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set radar_threat_avg_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @param radarThreatAvgApproachSpeed The new radarThreatAvgApproachSpeed value to be set
     */
    fun setRadarThreatAvgApproachSpeed(radarThreatAvgApproachSpeed: Float?) {
        setFieldValue(23, 0, radarThreatAvgApproachSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get radar_threat_max_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @return radar_threat_max_approach_speed
     */
    fun getRadarThreatMaxApproachSpeed(): Float? {
        return getFieldFloatValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set radar_threat_max_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @param radarThreatMaxApproachSpeed The new radarThreatMaxApproachSpeed value to be set
     */
    fun setRadarThreatMaxApproachSpeed(radarThreatMaxApproachSpeed: Float?) {
        setFieldValue(24, 0, radarThreatMaxApproachSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
