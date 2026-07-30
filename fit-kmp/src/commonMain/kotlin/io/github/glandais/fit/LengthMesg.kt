/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from LengthMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get timestamp field
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
     * Get start_time field
     *
     * @return start_time
     */
    var startTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(startTime) {
            setFieldValue(2, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_elapsed_time field
     * Units: s
     *
     * @return total_elapsed_time
     */
    var totalElapsedTime: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalElapsedTime) {
            setFieldValue(3, 0, totalElapsedTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_timer_time field
     * Units: s
     *
     * @return total_timer_time
     */
    var totalTimerTime: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalTimerTime) {
            setFieldValue(4, 0, totalTimerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_strokes field
     * Units: strokes
     *
     * @return total_strokes
     */
    var totalStrokes: Int?
        get() {
            return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalStrokes) {
            setFieldValue(5, 0, totalStrokes, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    var avgSpeed: Float?
        get() {
            return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgSpeed) {
            setFieldValue(6, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get swim_stroke field
     * Units: swim_stroke
     *
     * @return swim_stroke
     */
    var swimStroke: SwimStroke?
        get() {
            val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SwimStroke.fromValue(value)
        }
        set(swimStroke) {
            setFieldValue(7, 0, swimStroke?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_swimming_cadence field
     * Units: strokes/min
     *
     * @return avg_swimming_cadence
     */
    var avgSwimmingCadence: Short?
        get() {
            return getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgSwimmingCadence) {
            setFieldValue(9, 0, avgSwimmingCadence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event_group field
     *
     * @return event_group
     */
    override var eventGroup: Short?
        get() {
            return getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(eventGroup) {
            setFieldValue(10, 0, eventGroup, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get total_calories field
     * Units: kcal
     *
     * @return total_calories
     */
    var totalCalories: Int?
        get() {
            return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(totalCalories) {
            setFieldValue(11, 0, totalCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get length_type field
     *
     * @return length_type
     */
    var lengthType: LengthType?
        get() {
            val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return LengthType.fromValue(value)
        }
        set(lengthType) {
            setFieldValue(12, 0, lengthType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get player_score field
     *
     * @return player_score
     */
    var playerScore: Int?
        get() {
            return getFieldIntegerValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(playerScore) {
            setFieldValue(18, 0, playerScore, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get opponent_score field
     *
     * @return opponent_score
     */
    var opponentScore: Int?
        get() {
            return getFieldIntegerValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(opponentScore) {
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
    var enhancedAvgRespirationRate: Float?
        get() {
            return getFieldFloatValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedAvgRespirationRate) {
            setFieldValue(22, 0, enhancedAvgRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_max_respiration_rate field
     * Units: Breaths/min
     *
     * @return enhanced_max_respiration_rate
     */
    var enhancedMaxRespirationRate: Float?
        get() {
            return getFieldFloatValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedMaxRespirationRate) {
            setFieldValue(23, 0, enhancedMaxRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_respiration_rate field
     *
     * @return avg_respiration_rate
     */
    var avgRespirationRate: Short?
        get() {
            return getFieldShortValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRespirationRate) {
            setFieldValue(24, 0, avgRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_respiration_rate field
     *
     * @return max_respiration_rate
     */
    var maxRespirationRate: Short?
        get() {
            return getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxRespirationRate) {
            setFieldValue(25, 0, maxRespirationRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
