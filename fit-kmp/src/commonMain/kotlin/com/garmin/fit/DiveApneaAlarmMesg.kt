/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DiveApneaAlarmMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class DiveApneaAlarmMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val DepthFieldNum = 0
        const val TimeFieldNum = 1
        const val EnabledFieldNum = 2
        const val AlarmTypeFieldNum = 3
        const val SoundFieldNum = 4
        const val DiveTypesFieldNum = 5
        const val IdFieldNum = 6
        const val PopupEnabledFieldNum = 7
        const val TriggerOnDescentFieldNum = 8
        const val TriggerOnAscentFieldNum = 9
        const val RepeatingFieldNum = 10
        const val SpeedFieldNum = 11

        val diveApneaAlarmMesg: Mesg = run {
            // dive_apnea_alarm
            val diveApneaAlarmMesg = Mesg("dive_apnea_alarm", MesgNum.DIVE_APNEA_ALARM)
            diveApneaAlarmMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            diveApneaAlarmMesg.addField(Field("depth", DepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            diveApneaAlarmMesg.addField(Field("time", TimeFieldNum, 133, 1.0, 0.0, "s", false, Profile.Type.SINT32))
            diveApneaAlarmMesg.addField(Field("enabled", EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            diveApneaAlarmMesg.addField(Field("alarm_type", AlarmTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DIVE_ALARM_TYPE))
            diveApneaAlarmMesg.addField(Field("sound", SoundFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.TONE))
            diveApneaAlarmMesg.addField(Field("dive_types", DiveTypesFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            diveApneaAlarmMesg.addField(Field("id", IdFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            diveApneaAlarmMesg.addField(Field("popup_enabled", PopupEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            diveApneaAlarmMesg.addField(Field("trigger_on_descent", TriggerOnDescentFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            diveApneaAlarmMesg.addField(Field("trigger_on_ascent", TriggerOnAscentFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            diveApneaAlarmMesg.addField(Field("repeating", RepeatingFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            diveApneaAlarmMesg.addField(Field("speed", SpeedFieldNum, 133, 1000.0, 0.0, "mps", false, Profile.Type.SINT32))
            diveApneaAlarmMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.DIVE_APNEA_ALARM))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     * Comment: Index of the alarm
     *
     * @return message_index
     */
    fun getMessageIndex(): Int? {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_index field
     * Comment: Index of the alarm
     *
     * @param messageIndex The new messageIndex value to be set
     */
    fun setMessageIndex(messageIndex: Int?) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get depth field
     * Units: m
     * Comment: Depth setting (m) for depth type alarms
     *
     * @return depth
     */
    fun getDepth(): Float? {
        return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set depth field
     * Units: m
     * Comment: Depth setting (m) for depth type alarms
     *
     * @param depth The new depth value to be set
     */
    fun setDepth(depth: Float?) {
        setFieldValue(0, 0, depth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time field
     * Units: s
     * Comment: Time setting (s) for time type alarms
     *
     * @return time
     */
    fun getTime(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time field
     * Units: s
     * Comment: Time setting (s) for time type alarms
     *
     * @param time The new time value to be set
     */
    fun setTime(time: Int?) {
        setFieldValue(1, 0, time, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enabled field
     * Comment: Enablement flag
     *
     * @return enabled
     */
    fun getEnabled(): Bool? {
        val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set enabled field
     * Comment: Enablement flag
     *
     * @param enabled The new enabled value to be set
     */
    fun setEnabled(enabled: Bool?) {
        setFieldValue(2, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get alarm_type field
     * Comment: Alarm type setting
     *
     * @return alarm_type
     */
    fun getAlarmType(): DiveAlarmType? {
        val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DiveAlarmType.fromValue(value)
    }

    /**
     * Set alarm_type field
     * Comment: Alarm type setting
     *
     * @param alarmType The new alarmType value to be set
     */
    fun setAlarmType(alarmType: DiveAlarmType?) {
        setFieldValue(3, 0, alarmType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sound field
     * Comment: Tone and Vibe setting for the alarm.
     *
     * @return sound
     */
    fun getSound(): Tone? {
        val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Tone.fromValue(value)
    }

    /**
     * Set sound field
     * Comment: Tone and Vibe setting for the alarm.
     *
     * @param sound The new sound value to be set
     */
    fun setSound(sound: Tone?) {
        setFieldValue(4, 0, sound?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getDiveTypes(): Array<SubSport> {
        val values = getFieldShortValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)!!
        return Array(values.size) { i -> SubSport.fromValue(values[i]) }
    }

    /**
     * @return number of dive_types
     */
    fun getNumDiveTypes(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get dive_types field
     * Comment: Dive types the alarm will trigger on
     *
     * @param index of dive_types
     * @return dive_types
     */
    fun getDiveTypes(index: Int): SubSport? {
        val value = getFieldShortValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SubSport.fromValue(value)
    }

    /**
     * Set dive_types field
     * Comment: Dive types the alarm will trigger on
     *
     * @param index of dive_types
     * @param diveTypes The new diveTypes value to be set
     */
    fun setDiveTypes(index: Int, diveTypes: SubSport?) {
        setFieldValue(5, index, diveTypes?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get id field
     * Comment: Alarm ID
     *
     * @return id
     */
    fun getId(): Long? {
        return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set id field
     * Comment: Alarm ID
     *
     * @param id The new id value to be set
     */
    fun setId(id: Long?) {
        setFieldValue(6, 0, id, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get popup_enabled field
     * Comment: Show a visible pop-up for this alarm
     *
     * @return popup_enabled
     */
    fun getPopupEnabled(): Bool? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set popup_enabled field
     * Comment: Show a visible pop-up for this alarm
     *
     * @param popupEnabled The new popupEnabled value to be set
     */
    fun setPopupEnabled(popupEnabled: Bool?) {
        setFieldValue(7, 0, popupEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get trigger_on_descent field
     * Comment: Trigger the alarm on descent
     *
     * @return trigger_on_descent
     */
    fun getTriggerOnDescent(): Bool? {
        val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set trigger_on_descent field
     * Comment: Trigger the alarm on descent
     *
     * @param triggerOnDescent The new triggerOnDescent value to be set
     */
    fun setTriggerOnDescent(triggerOnDescent: Bool?) {
        setFieldValue(8, 0, triggerOnDescent?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get trigger_on_ascent field
     * Comment: Trigger the alarm on ascent
     *
     * @return trigger_on_ascent
     */
    fun getTriggerOnAscent(): Bool? {
        val value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set trigger_on_ascent field
     * Comment: Trigger the alarm on ascent
     *
     * @param triggerOnAscent The new triggerOnAscent value to be set
     */
    fun setTriggerOnAscent(triggerOnAscent: Bool?) {
        setFieldValue(9, 0, triggerOnAscent?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get repeating field
     * Comment: Repeat alarm each time threshold is crossed?
     *
     * @return repeating
     */
    fun getRepeating(): Bool? {
        val value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set repeating field
     * Comment: Repeat alarm each time threshold is crossed?
     *
     * @param repeating The new repeating value to be set
     */
    fun setRepeating(repeating: Bool?) {
        setFieldValue(10, 0, repeating?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get speed field
     * Units: mps
     * Comment: Ascent/descent rate (mps) setting for speed type alarms
     *
     * @return speed
     */
    fun getSpeed(): Float? {
        return getFieldFloatValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set speed field
     * Units: mps
     * Comment: Ascent/descent rate (mps) setting for speed type alarms
     *
     * @param speed The new speed value to be set
     */
    fun setSpeed(speed: Float?) {
        setFieldValue(11, 0, speed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
