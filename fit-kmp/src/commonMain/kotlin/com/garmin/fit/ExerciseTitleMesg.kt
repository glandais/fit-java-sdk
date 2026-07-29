/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ExerciseTitleMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ExerciseTitleMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val ExerciseCategoryFieldNum = 0
        const val ExerciseNameFieldNum = 1
        const val WktStepNameFieldNum = 2

        val exerciseTitleMesg: Mesg = run {
            // exercise_title
            val exerciseTitleMesg = Mesg("exercise_title", MesgNum.EXERCISE_TITLE)
            exerciseTitleMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            exerciseTitleMesg.addField(Field("exercise_category", ExerciseCategoryFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.EXERCISE_CATEGORY))
            exerciseTitleMesg.addField(Field("exercise_name", ExerciseNameFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            exerciseTitleMesg.addField(Field("wkt_step_name", WktStepNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            exerciseTitleMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.EXERCISE_TITLE))

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
     * Get exercise_category field
     *
     * @return exercise_category
     */
    var exerciseCategory: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(exerciseCategory) {
            setFieldValue(0, 0, exerciseCategory, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get exercise_name field
     *
     * @return exercise_name
     */
    var exerciseName: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(exerciseName) {
            setFieldValue(1, 0, exerciseName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getWktStepName(): Array<String?>? {
        return getFieldStringValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of wkt_step_name
     */
    fun getNumWktStepName(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get wkt_step_name field
     *
     * @param index of wkt_step_name
     * @return wkt_step_name
     */
    fun getWktStepName(index: Int): String? {
        return getFieldStringValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set wkt_step_name field
     *
     * @param index of wkt_step_name
     * @param wktStepName The new wktStepName value to be set
     */
    fun setWktStepName(index: Int, wktStepName: String?) {
        setFieldValue(2, index, wktStepName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
