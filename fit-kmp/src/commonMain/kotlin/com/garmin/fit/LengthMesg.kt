/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LengthMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class LengthMesg : Mesg, MesgWithEvent {

    companion object {
        const val MessageIndexFieldNum = 254
        const val TimestampFieldNum = 253
        const val EventFieldNum = 0
        const val EventTypeFieldNum = 1
        const val StartTimeFieldNum = 2
        const val TotalElapsedTimeFieldNum = 3
        const val TotalTimerTimeFieldNum = 4
        const val TotalStrokesFieldNum = 5
        const val AvgSpeedFieldNum = 6
        const val SwimStrokeFieldNum = 7
        const val AvgSwimmingCadenceFieldNum = 9
        const val EventGroupFieldNum = 10
        const val TotalCaloriesFieldNum = 11
        const val LengthTypeFieldNum = 12
        const val PlayerScoreFieldNum = 18
        const val OpponentScoreFieldNum = 19
        const val StrokeCountFieldNum = 20
        const val ZoneCountFieldNum = 21
        const val EnhancedAvgRespirationRateFieldNum = 22
        const val EnhancedMaxRespirationRateFieldNum = 23
        const val AvgRespirationRateFieldNum = 24
        const val MaxRespirationRateFieldNum = 25

        val lengthMesg: Mesg = run {
            var field_index = 0
            // length
            val lengthMesg = Mesg("length", MesgNum.LENGTH)
            lengthMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            lengthMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            lengthMesg.addField(Field("event", EventFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT))
            field_index++
            lengthMesg.addField(Field("event_type", EventTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EVENT_TYPE))
            field_index++
            lengthMesg.addField(Field("start_time", StartTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            lengthMesg.addField(Field("total_elapsed_time", TotalElapsedTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lengthMesg.addField(Field("total_timer_time", TotalTimerTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            lengthMesg.addField(Field("total_strokes", TotalStrokesFieldNum, 132, 1.0, 0.0, "strokes", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("avg_speed", AvgSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("swim_stroke", SwimStrokeFieldNum, 0, 1.0, 0.0, "swim_stroke", false, Profile.Type.SWIM_STROKE))
            field_index++
            lengthMesg.addField(Field("avg_swimming_cadence", AvgSwimmingCadenceFieldNum, 2, 1.0, 0.0, "strokes/min", false, Profile.Type.UINT8))
            field_index++
            lengthMesg.addField(Field("event_group", EventGroupFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            lengthMesg.addField(Field("total_calories", TotalCaloriesFieldNum, 132, 1.0, 0.0, "kcal", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("length_type", LengthTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.LENGTH_TYPE))
            field_index++
            lengthMesg.addField(Field("player_score", PlayerScoreFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("opponent_score", OpponentScoreFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("stroke_count", StrokeCountFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("zone_count", ZoneCountFieldNum, 132, 1.0, 0.0, "counts", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("enhanced_avg_respiration_rate", EnhancedAvgRespirationRateFieldNum, 132, 100.0, 0.0, "Breaths/min", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("enhanced_max_respiration_rate", EnhancedMaxRespirationRateFieldNum, 132, 100.0, 0.0, "Breaths/min", false, Profile.Type.UINT16))
            field_index++
            lengthMesg.addField(Field("avg_respiration_rate", AvgRespirationRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            lengthMesg.fields[field_index].components.add(FieldComponent(22, false, 8, 1.0, 0.0)) // enhanced_avg_respiration_rate
            field_index++
            lengthMesg.addField(Field("max_respiration_rate", MaxRespirationRateFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            lengthMesg.fields[field_index].components.add(FieldComponent(23, false, 8, 1.0, 0.0)) // enhanced_max_respiration_rate
            field_index++
            lengthMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.LENGTH))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     *
     * @return message_index
     */
    fun getMessageIndex(): Int? {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_index field
     *
     * @param messageIndex The new messageIndex value to be set
     */
    fun setMessageIndex(messageIndex: Int?) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    override fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
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
     * Get start_time field
     *
     * @return start_time
     */
    fun getStartTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set start_time field
     *
     * @param startTime The new startTime value to be set
     */
    fun setStartTime(startTime: DateTime?) {
        setFieldValue(2, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_elapsed_time field
     * Units: s
     *
     * @return total_elapsed_time
     */
    fun getTotalElapsedTime(): Float? {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_elapsed_time field
     * Units: s
     *
     * @param totalElapsedTime The new totalElapsedTime value to be set
     */
    fun setTotalElapsedTime(totalElapsedTime: Float?) {
        setFieldValue(3, 0, totalElapsedTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_timer_time field
     * Units: s
     *
     * @return total_timer_time
     */
    fun getTotalTimerTime(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_timer_time field
     * Units: s
     *
     * @param totalTimerTime The new totalTimerTime value to be set
     */
    fun setTotalTimerTime(totalTimerTime: Float?) {
        setFieldValue(4, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_strokes field
     * Units: strokes
     *
     * @return total_strokes
     */
    fun getTotalStrokes(): Int? {
        return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_strokes field
     * Units: strokes
     *
     * @param totalStrokes The new totalStrokes value to be set
     */
    fun setTotalStrokes(totalStrokes: Int?) {
        setFieldValue(5, 0, totalStrokes, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    fun getAvgSpeed(): Float? {
        return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_speed field
     * Units: m/s
     *
     * @param avgSpeed The new avgSpeed value to be set
     */
    fun setAvgSpeed(avgSpeed: Float?) {
        setFieldValue(6, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get swim_stroke field
     * Units: swim_stroke
     *
     * @return swim_stroke
     */
    fun getSwimStroke(): SwimStroke? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SwimStroke.fromValue(value)
    }

    /**
     * Set swim_stroke field
     * Units: swim_stroke
     *
     * @param swimStroke The new swimStroke value to be set
     */
    fun setSwimStroke(swimStroke: SwimStroke?) {
        setFieldValue(7, 0, swimStroke?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_swimming_cadence field
     * Units: strokes/min
     *
     * @return avg_swimming_cadence
     */
    fun getAvgSwimmingCadence(): Short? {
        return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_swimming_cadence field
     * Units: strokes/min
     *
     * @param avgSwimmingCadence The new avgSwimmingCadence value to be set
     */
    fun setAvgSwimmingCadence(avgSwimmingCadence: Short?) {
        setFieldValue(9, 0, avgSwimmingCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override fun getEventGroup(): Short? {
        return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set event_group field
     *
     * @param eventGroup The new eventGroup value to be set
     */
    override fun setEventGroup(eventGroup: Short?) {
        setFieldValue(10, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get total_calories field
     * Units: kcal
     *
     * @return total_calories
     */
    fun getTotalCalories(): Int? {
        return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set total_calories field
     * Units: kcal
     *
     * @param totalCalories The new totalCalories value to be set
     */
    fun setTotalCalories(totalCalories: Int?) {
        setFieldValue(11, 0, totalCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get length_type field
     *
     * @return length_type
     */
    fun getLengthType(): LengthType? {
        val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return LengthType.fromValue(value)
    }

    /**
     * Set length_type field
     *
     * @param lengthType The new lengthType value to be set
     */
    fun setLengthType(lengthType: LengthType?) {
        setFieldValue(12, 0, lengthType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get player_score field
     *
     * @return player_score
     */
    fun getPlayerScore(): Int? {
        return getFieldIntegerValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set player_score field
     *
     * @param playerScore The new playerScore value to be set
     */
    fun setPlayerScore(playerScore: Int?) {
        setFieldValue(18, 0, playerScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get opponent_score field
     *
     * @return opponent_score
     */
    fun getOpponentScore(): Int? {
        return getFieldIntegerValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set opponent_score field
     *
     * @param opponentScore The new opponentScore value to be set
     */
    fun setOpponentScore(opponentScore: Int?) {
        setFieldValue(19, 0, opponentScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getStrokeCount(): Array<Int?>? {
        return getFieldIntegerValues(20, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of stroke_count
     */
    fun getNumStrokeCount(): Int {
        return getNumFieldValues(20, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get stroke_count field
     * Units: counts
     * Comment: stroke_type enum used as the index
     *
     * @param index of stroke_count
     * @return stroke_count
     */
    fun getStrokeCount(index: Int): Int? {
        return getFieldIntegerValue(20, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set stroke_count field
     * Units: counts
     * Comment: stroke_type enum used as the index
     *
     * @param index of stroke_count
     * @param strokeCount The new strokeCount value to be set
     */
    fun setStrokeCount(index: Int, strokeCount: Int?) {
        setFieldValue(20, index, strokeCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getZoneCount(): Array<Int?>? {
        return getFieldIntegerValues(21, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of zone_count
     */
    fun getNumZoneCount(): Int {
        return getNumFieldValues(21, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get zone_count field
     * Units: counts
     * Comment: zone number used as the index
     *
     * @param index of zone_count
     * @return zone_count
     */
    fun getZoneCount(index: Int): Int? {
        return getFieldIntegerValue(21, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set zone_count field
     * Units: counts
     * Comment: zone number used as the index
     *
     * @param index of zone_count
     * @param zoneCount The new zoneCount value to be set
     */
    fun setZoneCount(index: Int, zoneCount: Int?) {
        setFieldValue(21, index, zoneCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_avg_respiration_rate field
     * Units: Breaths/min
     *
     * @return enhanced_avg_respiration_rate
     */
    fun getEnhancedAvgRespirationRate(): Float? {
        return getFieldFloatValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_avg_respiration_rate field
     * Units: Breaths/min
     *
     * @param enhancedAvgRespirationRate The new enhancedAvgRespirationRate value to be set
     */
    fun setEnhancedAvgRespirationRate(enhancedAvgRespirationRate: Float?) {
        setFieldValue(22, 0, enhancedAvgRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_max_respiration_rate field
     * Units: Breaths/min
     *
     * @return enhanced_max_respiration_rate
     */
    fun getEnhancedMaxRespirationRate(): Float? {
        return getFieldFloatValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_max_respiration_rate field
     * Units: Breaths/min
     *
     * @param enhancedMaxRespirationRate The new enhancedMaxRespirationRate value to be set
     */
    fun setEnhancedMaxRespirationRate(enhancedMaxRespirationRate: Float?) {
        setFieldValue(23, 0, enhancedMaxRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get avg_respiration_rate field
     *
     * @return avg_respiration_rate
     */
    fun getAvgRespirationRate(): Short? {
        return getFieldShortValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set avg_respiration_rate field
     *
     * @param avgRespirationRate The new avgRespirationRate value to be set
     */
    fun setAvgRespirationRate(avgRespirationRate: Short?) {
        setFieldValue(24, 0, avgRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get max_respiration_rate field
     *
     * @return max_respiration_rate
     */
    fun getMaxRespirationRate(): Short? {
        return getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set max_respiration_rate field
     *
     * @param maxRespirationRate The new maxRespirationRate value to be set
     */
    fun setMaxRespirationRate(maxRespirationRate: Short?) {
        setFieldValue(25, 0, maxRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
