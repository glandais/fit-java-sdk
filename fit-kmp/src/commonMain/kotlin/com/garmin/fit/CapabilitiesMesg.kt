/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CapabilitiesMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class CapabilitiesMesg : Mesg {

    companion object {
        const val LanguagesFieldNum = 0
        const val SportsFieldNum = 1
        const val WorkoutsSupportedFieldNum = 21
        const val ConnectivitySupportedFieldNum = 23

        val capabilitiesMesg: Mesg = run {
            // capabilities
            val capabilitiesMesg = Mesg("capabilities", MesgNum.CAPABILITIES)
            capabilitiesMesg.addField(Field("languages", LanguagesFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            capabilitiesMesg.addField(Field("sports", SportsFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.SPORT_BITS_0))
            capabilitiesMesg.addField(Field("workouts_supported", WorkoutsSupportedFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.WORKOUT_CAPABILITIES))
            capabilitiesMesg.addField(Field("connectivity_supported", ConnectivitySupportedFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.CONNECTIVITY_CAPABILITIES))
            capabilitiesMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.CAPABILITIES))

    constructor(mesg: Mesg?) : super(mesg)

    fun getLanguages(): Array<Short?>? {
        return getFieldShortValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of languages
     */
    fun getNumLanguages(): Int {
        return getNumFieldValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get languages field
     * Comment: Use language_bits_x types where x is index of array.
     *
     * @param index of languages
     * @return languages
     */
    fun getLanguages(index: Int): Short? {
        return getFieldShortValue(0, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set languages field
     * Comment: Use language_bits_x types where x is index of array.
     *
     * @param index of languages
     * @param languages The new languages value to be set
     */
    fun setLanguages(index: Int, languages: Short?) {
        setFieldValue(0, index, languages, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getSports(): Array<Short?>? {
        return getFieldShortValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of sports
     */
    fun getNumSports(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sports field
     * Comment: Use sport_bits_x types where x is index of array.
     *
     * @param index of sports
     * @return sports
     */
    fun getSports(index: Int): Short? {
        return getFieldShortValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set sports field
     * Comment: Use sport_bits_x types where x is index of array.
     *
     * @param index of sports
     * @param sports The new sports value to be set
     */
    fun setSports(index: Int, sports: Short?) {
        setFieldValue(1, index, sports, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get workouts_supported field
     *
     * @return workouts_supported
     */
    fun getWorkoutsSupported(): Long? {
        return getFieldLongValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set workouts_supported field
     *
     * @param workoutsSupported The new workoutsSupported value to be set
     */
    fun setWorkoutsSupported(workoutsSupported: Long?) {
        setFieldValue(21, 0, workoutsSupported, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get connectivity_supported field
     *
     * @return connectivity_supported
     */
    fun getConnectivitySupported(): Long? {
        return getFieldLongValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set connectivity_supported field
     *
     * @param connectivitySupported The new connectivitySupported value to be set
     */
    fun setConnectivitySupported(connectivitySupported: Long?) {
        setFieldValue(23, 0, connectivitySupported, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
