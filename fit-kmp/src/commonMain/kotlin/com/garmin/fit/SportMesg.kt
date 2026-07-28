/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SportMesg : Mesg {

    companion object {
        const val SportFieldNum = 0
        const val SubSportFieldNum = 1
        const val NameFieldNum = 3

        val sportMesg: Mesg = run {
            // sport
            val sportMesg = Mesg("sport", MesgNum.SPORT)
            sportMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            sportMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            sportMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            sportMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SPORT))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get sport field
     *
     * @return sport
     */
    fun getSport(): Sport? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Sport.fromValue(value)
    }

    /**
     * Set sport field
     *
     * @param sport The new sport value to be set
     */
    fun setSport(sport: Sport?) {
        setFieldValue(0, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    fun getSubSport(): SubSport? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SubSport.fromValue(value)
    }

    /**
     * Set sub_sport field
     *
     * @param subSport The new subSport value to be set
     */
    fun setSubSport(subSport: SubSport?) {
        setFieldValue(1, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get name field
     *
     * @return name
     */
    override fun getName(): String? {
        return getFieldStringValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set name field
     *
     * @param name The new name value to be set
     */
    fun setName(name: String?) {
        setFieldValue(3, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
