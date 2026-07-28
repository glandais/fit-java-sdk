/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from MetZoneMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class MetZoneMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val HighBpmFieldNum = 1
        const val CaloriesFieldNum = 2
        const val FatCaloriesFieldNum = 3

        val metZoneMesg: Mesg = run {
            // met_zone
            val metZoneMesg = Mesg("met_zone", MesgNum.MET_ZONE)
            metZoneMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            metZoneMesg.addField(Field("high_bpm", HighBpmFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            metZoneMesg.addField(Field("calories", CaloriesFieldNum, 132, 10.0, 0.0, "kcal / min", false, Profile.Type.UINT16))
            metZoneMesg.addField(Field("fat_calories", FatCaloriesFieldNum, 2, 10.0, 0.0, "kcal / min", false, Profile.Type.UINT8))
            metZoneMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.MET_ZONE))

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
     * Get high_bpm field
     *
     * @return high_bpm
     */
    fun getHighBpm(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set high_bpm field
     *
     * @param highBpm The new highBpm value to be set
     */
    fun setHighBpm(highBpm: Short?) {
        setFieldValue(1, 0, highBpm, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get calories field
     * Units: kcal / min
     *
     * @return calories
     */
    fun getCalories(): Float? {
        return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set calories field
     * Units: kcal / min
     *
     * @param calories The new calories value to be set
     */
    fun setCalories(calories: Float?) {
        setFieldValue(2, 0, calories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get fat_calories field
     * Units: kcal / min
     *
     * @return fat_calories
     */
    fun getFatCalories(): Float? {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set fat_calories field
     * Units: kcal / min
     *
     * @param fatCalories The new fatCalories value to be set
     */
    fun setFatCalories(fatCalories: Float?) {
        setFieldValue(3, 0, fatCalories, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
