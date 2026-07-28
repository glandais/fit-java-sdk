/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentPointMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SegmentPointMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val PositionLatFieldNum = 1
        const val PositionLongFieldNum = 2
        const val DistanceFieldNum = 3
        const val AltitudeFieldNum = 4
        const val LeaderTimeFieldNum = 5
        const val EnhancedAltitudeFieldNum = 6

        val segmentPointMesg: Mesg = run {
            var field_index = 0
            // segment_point
            val segmentPointMesg = Mesg("segment_point", MesgNum.SEGMENT_POINT)
            segmentPointMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            segmentPointMesg.addField(Field("position_lat", PositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentPointMesg.addField(Field("position_long", PositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            segmentPointMesg.addField(Field("distance", DistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            field_index++
            segmentPointMesg.addField(Field("altitude", AltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            segmentPointMesg.fields[field_index].components.add(FieldComponent(6, false, 16, 5.0, 500.0)) // enhanced_altitude
            field_index++
            segmentPointMesg.addField(Field("leader_time", LeaderTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            segmentPointMesg.addField(Field("enhanced_altitude", EnhancedAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            field_index++
            segmentPointMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SEGMENT_POINT))

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
     * Get position_lat field
     * Units: semicircles
     *
     * @return position_lat
     */
    fun getPositionLat(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set position_lat field
     * Units: semicircles
     *
     * @param positionLat The new positionLat value to be set
     */
    fun setPositionLat(positionLat: Int?) {
        setFieldValue(1, 0, positionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get position_long field
     * Units: semicircles
     *
     * @return position_long
     */
    fun getPositionLong(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set position_long field
     * Units: semicircles
     *
     * @param positionLong The new positionLong value to be set
     */
    fun setPositionLong(positionLong: Int?) {
        setFieldValue(2, 0, positionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get distance field
     * Units: m
     * Comment: Accumulated distance along the segment at the described point
     *
     * @return distance
     */
    fun getDistance(): Float? {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set distance field
     * Units: m
     * Comment: Accumulated distance along the segment at the described point
     *
     * @param distance The new distance value to be set
     */
    fun setDistance(distance: Float?) {
        setFieldValue(3, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get altitude field
     * Units: m
     * Comment: Accumulated altitude along the segment at the described point
     *
     * @return altitude
     */
    fun getAltitude(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set altitude field
     * Units: m
     * Comment: Accumulated altitude along the segment at the described point
     *
     * @param altitude The new altitude value to be set
     */
    fun setAltitude(altitude: Float?) {
        setFieldValue(4, 0, altitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getLeaderTime(): Array<Float?>? {
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of leader_time
     */
    fun getNumLeaderTime(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get leader_time field
     * Units: s
     * Comment: Accumualted time each leader board member required to reach the described point. This value is zero for all leader board members at the starting point of the segment.
     *
     * @param index of leader_time
     * @return leader_time
     */
    fun getLeaderTime(index: Int): Float? {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set leader_time field
     * Units: s
     * Comment: Accumualted time each leader board member required to reach the described point. This value is zero for all leader board members at the starting point of the segment.
     *
     * @param index of leader_time
     * @param leaderTime The new leaderTime value to be set
     */
    fun setLeaderTime(index: Int, leaderTime: Float?) {
        setFieldValue(5, index, leaderTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_altitude field
     * Units: m
     * Comment: Accumulated altitude along the segment at the described point
     *
     * @return enhanced_altitude
     */
    fun getEnhancedAltitude(): Float? {
        return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_altitude field
     * Units: m
     * Comment: Accumulated altitude along the segment at the described point
     *
     * @param enhancedAltitude The new enhancedAltitude value to be set
     */
    fun setEnhancedAltitude(enhancedAltitude: Float?) {
        setFieldValue(6, 0, enhancedAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
