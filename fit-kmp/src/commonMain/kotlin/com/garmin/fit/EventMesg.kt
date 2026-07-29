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
    override var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event field
     *
     * @return event
     */
    override var event: Event?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Event.fromValue(value)
        }
        set(event) {
            setFieldValue(0, 0, event?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event_type field
     *
     * @return event_type
     */
    override var eventType: EventType?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return EventType.fromValue(value)
        }
        set(eventType) {
            setFieldValue(1, 0, eventType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get data16 field
     *
     * @return data16
     */
    var data16: Int?
        get() {
            return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(data16) {
            setFieldValue(2, 0, data16, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get data field
     *
     * @return data
     */
    var data: Long?
        get() {
            return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(data) {
            setFieldValue(3, 0, data, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get timer_trigger field
     *
     * @return timer_trigger
     */
    var timerTrigger: TimerTrigger?
        get() {
            val value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIMER_TRIGGER) ?: return null
            return TimerTrigger.fromValue(value)
        }
        set(timerTrigger) {
            setFieldValue(3, 0, timerTrigger?.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIMER_TRIGGER)
        }

    /**
     * Get course_point_index field
     *
     * @return course_point_index
     */
    var coursePointIndex: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_COURSE_POINT_INDEX)
        }
        set(coursePointIndex) {
            setFieldValue(3, 0, coursePointIndex, Profile.SubFields.EVENT_MESG_DATA_FIELD_COURSE_POINT_INDEX)
        }

    /**
     * Get battery_level field
     * Units: V
     *
     * @return battery_level
     */
    var batteryLevel: Float?
        get() {
            return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_BATTERY_LEVEL)
        }
        set(batteryLevel) {
            setFieldValue(3, 0, batteryLevel, Profile.SubFields.EVENT_MESG_DATA_FIELD_BATTERY_LEVEL)
        }

    /**
     * Get virtual_partner_speed field
     * Units: m/s
     *
     * @return virtual_partner_speed
     */
    var virtualPartnerSpeed: Float?
        get() {
            return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_VIRTUAL_PARTNER_SPEED)
        }
        set(virtualPartnerSpeed) {
            setFieldValue(3, 0, virtualPartnerSpeed, Profile.SubFields.EVENT_MESG_DATA_FIELD_VIRTUAL_PARTNER_SPEED)
        }

    /**
     * Get hr_high_alert field
     * Units: bpm
     *
     * @return hr_high_alert
     */
    var hrHighAlert: Short?
        get() {
            return getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_HIGH_ALERT)
        }
        set(hrHighAlert) {
            setFieldValue(3, 0, hrHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_HIGH_ALERT)
        }

    /**
     * Get hr_low_alert field
     * Units: bpm
     *
     * @return hr_low_alert
     */
    var hrLowAlert: Short?
        get() {
            return getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_LOW_ALERT)
        }
        set(hrLowAlert) {
            setFieldValue(3, 0, hrLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_HR_LOW_ALERT)
        }

    /**
     * Get speed_high_alert field
     * Units: m/s
     *
     * @return speed_high_alert
     */
    var speedHighAlert: Float?
        get() {
            return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_HIGH_ALERT)
        }
        set(speedHighAlert) {
            setFieldValue(3, 0, speedHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_HIGH_ALERT)
        }

    /**
     * Get speed_low_alert field
     * Units: m/s
     *
     * @return speed_low_alert
     */
    var speedLowAlert: Float?
        get() {
            return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_LOW_ALERT)
        }
        set(speedLowAlert) {
            setFieldValue(3, 0, speedLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPEED_LOW_ALERT)
        }

    /**
     * Get cad_high_alert field
     * Units: rpm
     *
     * @return cad_high_alert
     */
    var cadHighAlert: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_HIGH_ALERT)
        }
        set(cadHighAlert) {
            setFieldValue(3, 0, cadHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_HIGH_ALERT)
        }

    /**
     * Get cad_low_alert field
     * Units: rpm
     *
     * @return cad_low_alert
     */
    var cadLowAlert: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_LOW_ALERT)
        }
        set(cadLowAlert) {
            setFieldValue(3, 0, cadLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CAD_LOW_ALERT)
        }

    /**
     * Get power_high_alert field
     * Units: watts
     *
     * @return power_high_alert
     */
    var powerHighAlert: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_HIGH_ALERT)
        }
        set(powerHighAlert) {
            setFieldValue(3, 0, powerHighAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_HIGH_ALERT)
        }

    /**
     * Get power_low_alert field
     * Units: watts
     *
     * @return power_low_alert
     */
    var powerLowAlert: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_LOW_ALERT)
        }
        set(powerLowAlert) {
            setFieldValue(3, 0, powerLowAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_POWER_LOW_ALERT)
        }

    /**
     * Get time_duration_alert field
     * Units: s
     *
     * @return time_duration_alert
     */
    var timeDurationAlert: Float?
        get() {
            return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIME_DURATION_ALERT)
        }
        set(timeDurationAlert) {
            setFieldValue(3, 0, timeDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_TIME_DURATION_ALERT)
        }

    /**
     * Get distance_duration_alert field
     * Units: m
     *
     * @return distance_duration_alert
     */
    var distanceDurationAlert: Float?
        get() {
            return getFieldFloatValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_DISTANCE_DURATION_ALERT)
        }
        set(distanceDurationAlert) {
            setFieldValue(3, 0, distanceDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_DISTANCE_DURATION_ALERT)
        }

    /**
     * Get calorie_duration_alert field
     * Units: calories
     *
     * @return calorie_duration_alert
     */
    var calorieDurationAlert: Long?
        get() {
            return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_CALORIE_DURATION_ALERT)
        }
        set(calorieDurationAlert) {
            setFieldValue(3, 0, calorieDurationAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_CALORIE_DURATION_ALERT)
        }

    /**
     * Get fitness_equipment_state field
     *
     * @return fitness_equipment_state
     */
    var fitnessEquipmentState: FitnessEquipmentState?
        get() {
            val value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_FITNESS_EQUIPMENT_STATE) ?: return null
            return FitnessEquipmentState.fromValue(value)
        }
        set(fitnessEquipmentState) {
            setFieldValue(3, 0, fitnessEquipmentState?.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_FITNESS_EQUIPMENT_STATE)
        }

    /**
     * Get sport_point field
     *
     * @return sport_point
     */
    var sportPoint: Long?
        get() {
            return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPORT_POINT)
        }
        set(sportPoint) {
            setFieldValue(3, 0, sportPoint, Profile.SubFields.EVENT_MESG_DATA_FIELD_SPORT_POINT)
        }

    /**
     * Get gear_change_data field
     *
     * @return gear_change_data
     */
    var gearChangeData: Long?
        get() {
            return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_GEAR_CHANGE_DATA)
        }
        set(gearChangeData) {
            setFieldValue(3, 0, gearChangeData, Profile.SubFields.EVENT_MESG_DATA_FIELD_GEAR_CHANGE_DATA)
        }

    /**
     * Get rider_position field
     * Comment: Indicates the rider position value.
     *
     * @return rider_position
     */
    var riderPosition: RiderPositionType?
        get() {
            val value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_RIDER_POSITION) ?: return null
            return RiderPositionType.fromValue(value)
        }
        set(riderPosition) {
            setFieldValue(3, 0, riderPosition?.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_RIDER_POSITION)
        }

    /**
     * Get comm_timeout field
     *
     * @return comm_timeout
     */
    var commTimeout: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_COMM_TIMEOUT)
        }
        set(commTimeout) {
            setFieldValue(3, 0, commTimeout, Profile.SubFields.EVENT_MESG_DATA_FIELD_COMM_TIMEOUT)
        }

    /**
     * Get dive_alert field
     *
     * @return dive_alert
     */
    var diveAlert: DiveAlert?
        get() {
            val value = getFieldShortValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_DIVE_ALERT) ?: return null
            return DiveAlert.fromValue(value)
        }
        set(diveAlert) {
            setFieldValue(3, 0, diveAlert?.value, Profile.SubFields.EVENT_MESG_DATA_FIELD_DIVE_ALERT)
        }

    /**
     * Get auto_activity_detect_duration field
     * Units: min
     *
     * @return auto_activity_detect_duration
     */
    var autoActivityDetectDuration: Int?
        get() {
            return getFieldIntegerValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_AUTO_ACTIVITY_DETECT_DURATION)
        }
        set(autoActivityDetectDuration) {
            setFieldValue(3, 0, autoActivityDetectDuration, Profile.SubFields.EVENT_MESG_DATA_FIELD_AUTO_ACTIVITY_DETECT_DURATION)
        }

    /**
     * Get radar_threat_alert field
     * Comment: The first byte is the radar_threat_level_max, the second byte is the radar_threat_count, third bytes is the average approach speed, and the 4th byte is the max approach speed
     *
     * @return radar_threat_alert
     */
    var radarThreatAlert: Long?
        get() {
            return getFieldLongValue(3, 0, Profile.SubFields.EVENT_MESG_DATA_FIELD_RADAR_THREAT_ALERT)
        }
        set(radarThreatAlert) {
            setFieldValue(3, 0, radarThreatAlert, Profile.SubFields.EVENT_MESG_DATA_FIELD_RADAR_THREAT_ALERT)
        }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override var eventGroup: Short?
        get() {
            return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(eventGroup) {
            setFieldValue(4, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @return score
     */
    var score: Int?
        get() {
            return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(score) {
            setFieldValue(7, 0, score, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get opponent_score field
     * Comment: Do not populate directly. Autogenerated by decoder for sport_point subfield components
     *
     * @return opponent_score
     */
    var opponentScore: Int?
        get() {
            return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(opponentScore) {
            setFieldValue(8, 0, opponentScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get front_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Front gear number. 1 is innermost.
     *
     * @return front_gear_num
     */
    var frontGearNum: Short?
        get() {
            return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(frontGearNum) {
            setFieldValue(9, 0, frontGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get front_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of front teeth.
     *
     * @return front_gear
     */
    var frontGear: Short?
        get() {
            return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(frontGear) {
            setFieldValue(10, 0, frontGear, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get rear_gear_num field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Rear gear number. 1 is innermost.
     *
     * @return rear_gear_num
     */
    var rearGearNum: Short?
        get() {
            return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rearGearNum) {
            setFieldValue(11, 0, rearGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get rear_gear field
     * Comment: Do not populate directly. Autogenerated by decoder for gear_change subfield components. Number of rear teeth.
     *
     * @return rear_gear
     */
    var rearGear: Short?
        get() {
            return getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rearGear) {
            setFieldValue(12, 0, rearGear, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    var deviceIndex: Short?
        get() {
            return getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(deviceIndex) {
            setFieldValue(13, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_type field
     * Comment: Activity Type associated with an auto_activity_detect event
     *
     * @return activity_type
     */
    var activityType: ActivityType?
        get() {
            val value = getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ActivityType.fromValue(value)
        }
        set(activityType) {
            setFieldValue(14, 0, activityType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_timestamp field
     * Units: s
     * Comment: Timestamp of when the event started
     *
     * @return start_timestamp
     */
    var startTimestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(startTimestamp) {
            setFieldValue(15, 0, startTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get auto_activity_detect_start_timestamp field
     * Units: s
     * Comment: Auto Activity Detect Start Timestamp.
     *
     * @return auto_activity_detect_start_timestamp
     */
    var autoActivityDetectStartTimestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(15, 0, Profile.SubFields.EVENT_MESG_START_TIMESTAMP_FIELD_AUTO_ACTIVITY_DETECT_START_TIMESTAMP))
        }
        set(autoActivityDetectStartTimestamp) {
            setFieldValue(15, 0, autoActivityDetectStartTimestamp?.getTimestamp(), Profile.SubFields.EVENT_MESG_START_TIMESTAMP_FIELD_AUTO_ACTIVITY_DETECT_START_TIMESTAMP)
        }

    /**
     * Get radar_threat_level_max field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @return radar_threat_level_max
     */
    var radarThreatLevelMax: RadarThreatLevelType?
        get() {
            val value = getFieldShortValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return RadarThreatLevelType.fromValue(value)
        }
        set(radarThreatLevelMax) {
            setFieldValue(21, 0, radarThreatLevelMax?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get radar_threat_count field
     * Comment: Do not populate directly. Autogenerated by decoder for threat_alert subfield components.
     *
     * @return radar_threat_count
     */
    var radarThreatCount: Short?
        get() {
            return getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(radarThreatCount) {
            setFieldValue(22, 0, radarThreatCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get radar_threat_avg_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @return radar_threat_avg_approach_speed
     */
    var radarThreatAvgApproachSpeed: Float?
        get() {
            return getFieldFloatValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(radarThreatAvgApproachSpeed) {
            setFieldValue(23, 0, radarThreatAvgApproachSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get radar_threat_max_approach_speed field
     * Units: m/s
     * Comment: Do not populate directly. Autogenerated by decoder for radar_threat_alert subfield components
     *
     * @return radar_threat_max_approach_speed
     */
    var radarThreatMaxApproachSpeed: Float?
        get() {
            return getFieldFloatValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(radarThreatMaxApproachSpeed) {
            setFieldValue(24, 0, radarThreatMaxApproachSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
