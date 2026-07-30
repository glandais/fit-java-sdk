/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SportMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(3, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
