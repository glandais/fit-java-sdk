/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from StressLevelMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class StressLevelMesg : Mesg {

    companion object {
        const val StressLevelValueFieldNum = 0
        const val StressLevelTimeFieldNum = 1

        val stressLevelMesg: Mesg = run {
            // stress_level
            val stressLevelMesg = Mesg("stress_level", MesgNum.STRESS_LEVEL)
            stressLevelMesg.addField(Field("stress_level_value", StressLevelValueFieldNum, 131, 1.0, 0.0, "", false, Profile.Type.SINT16))
            stressLevelMesg.addField(Field("stress_level_time", StressLevelTimeFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            stressLevelMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.STRESS_LEVEL))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get stress_level_value field
     *
     * @return stress_level_value
     */
    fun getStressLevelValue(): Short? {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set stress_level_value field
     *
     * @param stressLevelValue The new stressLevelValue value to be set
     */
    fun setStressLevelValue(stressLevelValue: Short?) {
        setFieldValue(0, 0, stressLevelValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get stress_level_time field
     * Units: s
     * Comment: Time stress score was calculated
     *
     * @return stress_level_time
     */
    fun getStressLevelTime(): DateTime? {
        return timestampToDateTime(getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set stress_level_time field
     * Units: s
     * Comment: Time stress score was calculated
     *
     * @param stressLevelTime The new stressLevelTime value to be set
     */
    fun setStressLevelTime(stressLevelTime: DateTime?) {
        setFieldValue(1, 0, stressLevelTime?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
