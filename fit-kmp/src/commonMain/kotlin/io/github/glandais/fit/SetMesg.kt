/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SetMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class SetMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 254
        const val DurationFieldNum = 0
        const val RepetitionsFieldNum = 3
        const val WeightFieldNum = 4
        const val SetTypeFieldNum = 5
        const val StartTimeFieldNum = 6
        const val CategoryFieldNum = 7
        const val CategorySubtypeFieldNum = 8
        const val WeightDisplayUnitFieldNum = 9
        const val MessageIndexFieldNum = 10
        const val WktStepIndexFieldNum = 11

        val setMesg: Mesg = run {
            // set
            val setMesg = Mesg("set", MesgNum.SET)
            setMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            setMesg.addField(Field("duration", DurationFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            setMesg.addField(Field("repetitions", RepetitionsFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            setMesg.addField(Field("weight", WeightFieldNum, 132, 16.0, 0.0, "kg", false, Profile.Type.UINT16))
            setMesg.addField(Field("set_type", SetTypeFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.SET_TYPE))
            setMesg.addField(Field("start_time", StartTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            setMesg.addField(Field("category", CategoryFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.EXERCISE_CATEGORY))
            setMesg.addField(Field("category_subtype", CategorySubtypeFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            setMesg.addField(Field("weight_display_unit", WeightDisplayUnitFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.FIT_BASE_UNIT))
            setMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            setMesg.addField(Field("wkt_step_index", WktStepIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            setMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SET))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Comment: Timestamp of the set
     *
     * @return timestamp
     */
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(254, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get duration field
     * Units: s
     *
     * @return duration
     */
    var duration: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(duration) {
            setFieldValue(0, 0, duration, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get repetitions field
     * Comment: # of repitions of the movement
     *
     * @return repetitions
     */
    var repetitions: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(repetitions) {
            setFieldValue(3, 0, repetitions, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get weight field
     * Units: kg
     * Comment: Amount of weight applied for the set
     *
     * @return weight
     */
    var weight: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(weight) {
            setFieldValue(4, 0, weight, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get set_type field
     *
     * @return set_type
     */
    var setType: Short?
        get() {
            return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(setType) {
            setFieldValue(5, 0, setType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_time field
     * Comment: Start time of the set
     *
     * @return start_time
     */
    var startTime: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(startTime) {
            setFieldValue(6, 0, startTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getCategory(): Array<Int?>? {
        return getFieldIntegerValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of category
     */
    fun getNumCategory(): Int {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get category field
     *
     * @param index of category
     * @return category
     */
    fun getCategory(index: Int): Int? {
        return getFieldIntegerValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set category field
     *
     * @param index of category
     * @param category The new category value to be set
     */
    fun setCategory(index: Int, category: Int?) {
        setFieldValue(7, index, category, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCategorySubtype(): Array<Int?>? {
        return getFieldIntegerValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of category_subtype
     */
    fun getNumCategorySubtype(): Int {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get category_subtype field
     * Comment: Based on the associated category, see [category]_exercise_names
     *
     * @param index of category_subtype
     * @return category_subtype
     */
    fun getCategorySubtype(index: Int): Int? {
        return getFieldIntegerValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set category_subtype field
     * Comment: Based on the associated category, see [category]_exercise_names
     *
     * @param index of category_subtype
     * @param categorySubtype The new categorySubtype value to be set
     */
    fun setCategorySubtype(index: Int, categorySubtype: Int?) {
        setFieldValue(8, index, categorySubtype, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get weight_display_unit field
     *
     * @return weight_display_unit
     */
    var weightDisplayUnit: Int?
        get() {
            return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(weightDisplayUnit) {
            setFieldValue(9, 0, weightDisplayUnit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get message_index field
     *
     * @return message_index
     */
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(10, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get wkt_step_index field
     *
     * @return wkt_step_index
     */
    var wktStepIndex: Int?
        get() {
            return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(wktStepIndex) {
            setFieldValue(11, 0, wktStepIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
