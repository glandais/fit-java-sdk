/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CoursePointMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

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
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(1, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get position_lat field
     * Units: semicircles
     *
     * @return position_lat
     */
    fun getPositionLat(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set position_lat field
     * Units: semicircles
     *
     * @param positionLat The new positionLat value to be set
     */
    fun setPositionLat(positionLat: Int?) {
        setFieldValue(2, 0, positionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get position_long field
     * Units: semicircles
     *
     * @return position_long
     */
    fun getPositionLong(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set position_long field
     * Units: semicircles
     *
     * @param positionLong The new positionLong value to be set
     */
    fun setPositionLong(positionLong: Int?) {
        setFieldValue(3, 0, positionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get distance field
     * Units: m
     *
     * @return distance
     */
    fun getDistance(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set distance field
     * Units: m
     *
     * @param distance The new distance value to be set
     */
    fun setDistance(distance: Float?) {
        setFieldValue(4, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get type field
     *
     * @return type
     */
    fun getType(): CoursePoint? {
        val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return CoursePoint.fromValue(value)
    }

    /**
     * Set type field
     *
     * @param type The new type value to be set
     */
    fun setType(type: CoursePoint?) {
        setFieldValue(5, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get name field
     *
     * @return name
     */
    override fun getName(): String? {
        return getFieldStringValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set name field
     *
     * @param name The new name value to be set
     */
    fun setName(name: String?) {
        setFieldValue(6, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get favorite field
     *
     * @return favorite
     */
    fun getFavorite(): Bool? {
        val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set favorite field
     *
     * @param favorite The new favorite value to be set
     */
    fun setFavorite(favorite: Bool?) {
        setFieldValue(8, 0, favorite?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
