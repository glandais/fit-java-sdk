/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CourseMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class CourseMesg : Mesg {

    companion object {
        const val SportFieldNum = 4
        const val NameFieldNum = 5
        const val CapabilitiesFieldNum = 6
        const val SubSportFieldNum = 7

        val courseMesg: Mesg = run {
            // course
            val courseMesg = Mesg("course", MesgNum.COURSE)
            courseMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            courseMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            courseMesg.addField(Field("capabilities", CapabilitiesFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.COURSE_CAPABILITIES))
            courseMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            courseMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.COURSE))

    constructor(mesg: Mesg?) : super(mesg)

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
     * Get name field
     *
     * @return name
     */
    override fun getName(): String? {
        return getFieldStringValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set name field
     *
     * @param name The new name value to be set
     */
    fun setName(name: String?) {
        setFieldValue(5, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get capabilities field
     *
     * @return capabilities
     */
    fun getCapabilities(): Long? {
        return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set capabilities field
     *
     * @param capabilities The new capabilities value to be set
     */
    fun setCapabilities(capabilities: Long?) {
        setFieldValue(6, 0, capabilities, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    fun getSubSport(): SubSport? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SubSport.fromValue(value)
    }

    /**
     * Set sub_sport field
     *
     * @param subSport The new subSport value to be set
     */
    fun setSubSport(subSport: SubSport?) {
        setFieldValue(7, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
