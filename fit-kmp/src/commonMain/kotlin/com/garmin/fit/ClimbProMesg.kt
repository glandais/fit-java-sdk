/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ClimbProMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ClimbProMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val PositionLatFieldNum = 0
        const val PositionLongFieldNum = 1
        const val ClimbProEventFieldNum = 2
        const val ClimbNumberFieldNum = 3
        const val ClimbCategoryFieldNum = 4
        const val CurrentDistFieldNum = 5

        val climbProMesg: Mesg = run {
            // climb_pro
            val climbProMesg = Mesg("climb_pro", MesgNum.CLIMB_PRO)
            climbProMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            climbProMesg.addField(Field("position_lat", PositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            climbProMesg.addField(Field("position_long", PositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            climbProMesg.addField(Field("climb_pro_event", ClimbProEventFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.CLIMB_PRO_EVENT))
            climbProMesg.addField(Field("climb_number", ClimbNumberFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            climbProMesg.addField(Field("climb_category", ClimbCategoryFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            climbProMesg.addField(Field("current_dist", CurrentDistFieldNum, 136, 1.0, 0.0, "m", false, Profile.Type.FLOAT32))
            climbProMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.CLIMB_PRO))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get position_lat field
     * Units: semicircles
     *
     * @return position_lat
     */
    fun getPositionLat(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set position_lat field
     * Units: semicircles
     *
     * @param positionLat The new positionLat value to be set
     */
    fun setPositionLat(positionLat: Int?) {
        setFieldValue(0, 0, positionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get position_long field
     * Units: semicircles
     *
     * @return position_long
     */
    fun getPositionLong(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set position_long field
     * Units: semicircles
     *
     * @param positionLong The new positionLong value to be set
     */
    fun setPositionLong(positionLong: Int?) {
        setFieldValue(1, 0, positionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get climb_pro_event field
     *
     * @return climb_pro_event
     */
    fun getClimbProEvent(): ClimbProEvent? {
        val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return ClimbProEvent.fromValue(value)
    }

    /**
     * Set climb_pro_event field
     *
     * @param climbProEvent The new climbProEvent value to be set
     */
    fun setClimbProEvent(climbProEvent: ClimbProEvent?) {
        setFieldValue(2, 0, climbProEvent?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get climb_number field
     *
     * @return climb_number
     */
    fun getClimbNumber(): Int? {
        return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set climb_number field
     *
     * @param climbNumber The new climbNumber value to be set
     */
    fun setClimbNumber(climbNumber: Int?) {
        setFieldValue(3, 0, climbNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get climb_category field
     *
     * @return climb_category
     */
    fun getClimbCategory(): Short? {
        return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set climb_category field
     *
     * @param climbCategory The new climbCategory value to be set
     */
    fun setClimbCategory(climbCategory: Short?) {
        setFieldValue(4, 0, climbCategory, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get current_dist field
     * Units: m
     *
     * @return current_dist
     */
    fun getCurrentDist(): Float? {
        return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set current_dist field
     * Units: m
     *
     * @param currentDist The new currentDist value to be set
     */
    fun setCurrentDist(currentDist: Float?) {
        setFieldValue(5, 0, currentDist, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
