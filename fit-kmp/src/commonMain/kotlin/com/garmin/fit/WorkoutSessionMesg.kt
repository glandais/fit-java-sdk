/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WorkoutSessionMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class WorkoutSessionMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val SportFieldNum = 0
        const val SubSportFieldNum = 1
        const val NumValidStepsFieldNum = 2
        const val FirstStepIndexFieldNum = 3
        const val PoolLengthFieldNum = 4
        const val PoolLengthUnitFieldNum = 5

        val workoutSessionMesg: Mesg = run {
            // workout_session
            val workoutSessionMesg = Mesg("workout_session", MesgNum.WORKOUT_SESSION)
            workoutSessionMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            workoutSessionMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            workoutSessionMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            workoutSessionMesg.addField(Field("num_valid_steps", NumValidStepsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            workoutSessionMesg.addField(Field("first_step_index", FirstStepIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            workoutSessionMesg.addField(Field("pool_length", PoolLengthFieldNum, 132, 100.0, 0.0, "m", false, Profile.Type.UINT16))
            workoutSessionMesg.addField(Field("pool_length_unit", PoolLengthUnitFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DISPLAY_MEASURE))
            workoutSessionMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.WORKOUT_SESSION))

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
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Sport.fromValue(value)
        }
        set(sport) {
            setFieldValue(0, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    var subSport: SubSport?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SubSport.fromValue(value)
        }
        set(subSport) {
            setFieldValue(1, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get num_valid_steps field
     *
     * @return num_valid_steps
     */
    var numValidSteps: Int?
        get() {
            return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(numValidSteps) {
            setFieldValue(2, 0, numValidSteps, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get first_step_index field
     *
     * @return first_step_index
     */
    var firstStepIndex: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(firstStepIndex) {
            setFieldValue(3, 0, firstStepIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get pool_length field
     * Units: m
     *
     * @return pool_length
     */
    var poolLength: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(poolLength) {
            setFieldValue(4, 0, poolLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get pool_length_unit field
     *
     * @return pool_length_unit
     */
    var poolLengthUnit: DisplayMeasure?
        get() {
            val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return DisplayMeasure.fromValue(value)
        }
        set(poolLengthUnit) {
            setFieldValue(5, 0, poolLengthUnit?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
