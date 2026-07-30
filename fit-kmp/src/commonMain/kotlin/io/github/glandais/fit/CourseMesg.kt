/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CourseMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var sport: Sport?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Sport.fromValue(value)
        }
        set(sport) {
            setFieldValue(4, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(5, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get capabilities field
     *
     * @return capabilities
     */
    var capabilities: Long?
        get() {
            return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(capabilities) {
            setFieldValue(6, 0, capabilities, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    var subSport: SubSport?
        get() {
            val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SubSport.fromValue(value)
        }
        set(subSport) {
            setFieldValue(7, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
