/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from PowerZoneMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class PowerZoneMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val HighValueFieldNum = 1
        const val NameFieldNum = 2

        val powerZoneMesg: Mesg = run {
            // power_zone
            val powerZoneMesg = Mesg("power_zone", MesgNum.POWER_ZONE)
            powerZoneMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            powerZoneMesg.addField(Field("high_value", HighValueFieldNum, 132, 1.0, 0.0, "watts", false, Profile.Type.UINT16))
            powerZoneMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            powerZoneMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.POWER_ZONE))

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
     * Get high_value field
     * Units: watts
     *
     * @return high_value
     */
    var highValue: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(highValue) {
            setFieldValue(1, 0, highValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(2, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
