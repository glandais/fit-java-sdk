/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from JumpMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class JumpMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val DistanceFieldNum = 0
        const val HeightFieldNum = 1
        const val RotationsFieldNum = 2
        const val HangTimeFieldNum = 3
        const val ScoreFieldNum = 4
        const val PositionLatFieldNum = 5
        const val PositionLongFieldNum = 6
        const val SpeedFieldNum = 7
        const val EnhancedSpeedFieldNum = 8

        val jumpMesg: Mesg = run {
            var field_index = 0
            // jump
            val jumpMesg = Mesg("jump", MesgNum.JUMP)
            jumpMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            jumpMesg.addField(Field("distance", DistanceFieldNum, 136, 1.0, 0.0, "m", false, Profile.Type.FLOAT32))
            field_index++
            jumpMesg.addField(Field("height", HeightFieldNum, 136, 1.0, 0.0, "m", false, Profile.Type.FLOAT32))
            field_index++
            jumpMesg.addField(Field("rotations", RotationsFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            jumpMesg.addField(Field("hang_time", HangTimeFieldNum, 136, 1.0, 0.0, "s", false, Profile.Type.FLOAT32))
            field_index++
            jumpMesg.addField(Field("score", ScoreFieldNum, 136, 1.0, 0.0, "", false, Profile.Type.FLOAT32))
            field_index++
            jumpMesg.addField(Field("position_lat", PositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            jumpMesg.addField(Field("position_long", PositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            field_index++
            jumpMesg.addField(Field("speed", SpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            jumpMesg.fields[field_index].components.add(FieldComponent(8, false, 16, 1000.0, 0.0)) // enhanced_speed
            field_index++
            jumpMesg.addField(Field("enhanced_speed", EnhancedSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            field_index++
            jumpMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.JUMP))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
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
     * Get distance field
     * Units: m
     *
     * @return distance
     */
    var distance: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(distance) {
            setFieldValue(0, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get height field
     * Units: m
     *
     * @return height
     */
    var height: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(height) {
            setFieldValue(1, 0, height, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get rotations field
     *
     * @return rotations
     */
    var rotations: Short?
        get() {
            return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rotations) {
            setFieldValue(2, 0, rotations, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get hang_time field
     * Units: s
     *
     * @return hang_time
     */
    var hangTime: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(hangTime) {
            setFieldValue(3, 0, hangTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get score field
     * Comment: A score for a jump calculated based on hang time, rotations, and distance.
     *
     * @return score
     */
    var score: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(score) {
            setFieldValue(4, 0, score, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get position_lat field
     * Units: semicircles
     *
     * @return position_lat
     */
    var positionLat: Int?
        get() {
            return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(positionLat) {
            setFieldValue(5, 0, positionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get position_long field
     * Units: semicircles
     *
     * @return position_long
     */
    var positionLong: Int?
        get() {
            return getFieldIntegerValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(positionLong) {
            setFieldValue(6, 0, positionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get speed field
     * Units: m/s
     *
     * @return speed
     */
    var speed: Float?
        get() {
            return getFieldFloatValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(speed) {
            setFieldValue(7, 0, speed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enhanced_speed field
     * Units: m/s
     *
     * @return enhanced_speed
     */
    var enhancedSpeed: Float?
        get() {
            return getFieldFloatValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(enhancedSpeed) {
            setFieldValue(8, 0, enhancedSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
