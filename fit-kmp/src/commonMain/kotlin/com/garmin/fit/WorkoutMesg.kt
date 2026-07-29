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
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sport field
     *
     * @return sport
     */
    var sport: Sport?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Sport.fromValue(value)
        }
        set(sport) {
            setFieldValue(4, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get capabilities field
     *
     * @return capabilities
     */
    var capabilities: Long?
        get() {
            return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(capabilities) {
            setFieldValue(5, 0, capabilities, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get num_valid_steps field
     * Comment: number of valid steps
     *
     * @return num_valid_steps
     */
    var numValidSteps: Int?
        get() {
            return getFieldIntegerValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(numValidSteps) {
            setFieldValue(6, 0, numValidSteps, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get wkt_name field
     *
     * @return wkt_name
     */
    var wktName: String?
        get() {
            return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(wktName) {
            setFieldValue(8, 0, wktName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    var subSport: SubSport?
        get() {
            val value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SubSport.fromValue(value)
        }
        set(subSport) {
            setFieldValue(11, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get pool_length field
     * Units: m
     *
     * @return pool_length
     */
    var poolLength: Float?
        get() {
            return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(poolLength) {
            setFieldValue(14, 0, poolLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get pool_length_unit field
     *
     * @return pool_length_unit
     */
    var poolLengthUnit: DisplayMeasure?
        get() {
            val value = getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(poolLengthUnit) {
            setFieldValue(15, 0, poolLengthUnit?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get wkt_description field
     * Comment: Description of the workout
     *
     * @return wkt_description
     */
    var wktDescription: String?
        get() {
            return getFieldStringValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(wktDescription) {
            setFieldValue(17, 0, wktDescription, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
