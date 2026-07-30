/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CoursePointMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class CoursePointMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val TimestampFieldNum = 1
        const val PositionLatFieldNum = 2
        const val PositionLongFieldNum = 3
        const val DistanceFieldNum = 4
        const val TypeFieldNum = 5
        const val NameFieldNum = 6
        const val FavoriteFieldNum = 8

        val coursePointMesg: Mesg = run {
            // course_point
            val coursePointMesg = Mesg("course_point", MesgNum.COURSE_POINT)
            coursePointMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            coursePointMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            coursePointMesg.addField(Field("position_lat", PositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            coursePointMesg.addField(Field("position_long", PositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            coursePointMesg.addField(Field("distance", DistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            coursePointMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.COURSE_POINT))
            coursePointMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            coursePointMesg.addField(Field("favorite", FavoriteFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            coursePointMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.COURSE_POINT))

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
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(1, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get position_lat field
     * Units: semicircles
     *
     * @return position_lat
     */
    var positionLat: Int?
        get() {
            return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(positionLat) {
            setFieldValue(2, 0, positionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get position_long field
     * Units: semicircles
     *
     * @return position_long
     */
    var positionLong: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(positionLong) {
            setFieldValue(3, 0, positionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get distance field
     * Units: m
     *
     * @return distance
     */
    var distance: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(distance) {
            setFieldValue(4, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get type field
     *
     * @return type
     */
    var type: CoursePoint?
        get() {
            val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return CoursePoint.fromValue(value)
        }
        set(type) {
            setFieldValue(5, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(6, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get favorite field
     *
     * @return favorite
     */
    var favorite: Bool?
        get() {
            val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(favorite) {
            setFieldValue(8, 0, favorite?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
