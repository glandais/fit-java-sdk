/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WorkoutMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class WorkoutMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val SportFieldNum = 4
        const val CapabilitiesFieldNum = 5
        const val NumValidStepsFieldNum = 6
        const val WktNameFieldNum = 8
        const val SubSportFieldNum = 11
        const val PoolLengthFieldNum = 14
        const val PoolLengthUnitFieldNum = 15
        const val WktDescriptionFieldNum = 17

        val workoutMesg: Mesg = run {
            // workout
            val workoutMesg = Mesg("workout", MesgNum.WORKOUT)
            workoutMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            workoutMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            workoutMesg.addField(Field("capabilities", CapabilitiesFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.WORKOUT_CAPABILITIES))
            workoutMesg.addField(Field("num_valid_steps", NumValidStepsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            workoutMesg.addField(Field("wkt_name", WktNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            workoutMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            workoutMesg.addField(Field("pool_length", PoolLengthFieldNum, 132, 100.0, 0.0, "m", false, Profile.Type.UINT16))
            workoutMesg.addField(Field("pool_length_unit", PoolLengthUnitFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            workoutMesg.addField(Field("wkt_description", WktDescriptionFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            workoutMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.WORKOUT))

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
     * Get sport field
     *
     * @return sport
     */
    fun getSport(): Sport? {
        val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Sport.fromValue(value)
    }

    /**
     * Set sport field
     *
     * @param sport The new sport value to be set
     */
    fun setSport(sport: Sport?) {
        setFieldValue(4, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get capabilities field
     *
     * @return capabilities
     */
    fun getCapabilities(): Long? {
        return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set capabilities field
     *
     * @param capabilities The new capabilities value to be set
     */
    fun setCapabilities(capabilities: Long?) {
        setFieldValue(5, 0, capabilities, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get num_valid_steps field
     * Comment: number of valid steps
     *
     * @return num_valid_steps
     */
    fun getNumValidSteps(): Int? {
        return getFieldIntegerValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set num_valid_steps field
     * Comment: number of valid steps
     *
     * @param numValidSteps The new numValidSteps value to be set
     */
    fun setNumValidSteps(numValidSteps: Int?) {
        setFieldValue(6, 0, numValidSteps, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get wkt_name field
     *
     * @return wkt_name
     */
    fun getWktName(): String? {
        return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set wkt_name field
     *
     * @param wktName The new wktName value to be set
     */
    fun setWktName(wktName: String?) {
        setFieldValue(8, 0, wktName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    fun getSubSport(): SubSport? {
        val value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SubSport.fromValue(value)
    }

    /**
     * Set sub_sport field
     *
     * @param subSport The new subSport value to be set
     */
    fun setSubSport(subSport: SubSport?) {
        setFieldValue(11, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pool_length field
     * Units: m
     *
     * @return pool_length
     */
    fun getPoolLength(): Float? {
        return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set pool_length field
     * Units: m
     *
     * @param poolLength The new poolLength value to be set
     */
    fun setPoolLength(poolLength: Float?) {
        setFieldValue(14, 0, poolLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pool_length_unit field
     *
     * @return pool_length_unit
     */
    fun getPoolLengthUnit(): DisplayMeasure? {
        val value = getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DisplayMeasure.fromValue(value)
    }

    /**
     * Set pool_length_unit field
     *
     * @param poolLengthUnit The new poolLengthUnit value to be set
     */
    fun setPoolLengthUnit(poolLengthUnit: DisplayMeasure?) {
        setFieldValue(15, 0, poolLengthUnit?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get wkt_description field
     * Comment: Description of the workout
     *
     * @return wkt_description
     */
    fun getWktDescription(): String? {
        return getFieldStringValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set wkt_description field
     * Comment: Description of the workout
     *
     * @param wktDescription The new wktDescription value to be set
     */
    fun setWktDescription(wktDescription: String?) {
        setFieldValue(17, 0, wktDescription, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
