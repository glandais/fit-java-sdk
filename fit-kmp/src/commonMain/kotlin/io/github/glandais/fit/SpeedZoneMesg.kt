/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SpeedZoneMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class SpeedZoneMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val HighValueFieldNum = 0
        const val NameFieldNum = 1

        val speedZoneMesg: Mesg = run {
            // speed_zone
            val speedZoneMesg = Mesg("speed_zone", MesgNum.SPEED_ZONE)
            speedZoneMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            speedZoneMesg.addField(Field("high_value", HighValueFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            speedZoneMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            speedZoneMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SPEED_ZONE))

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
     * Units: m/s
     *
     * @return high_value
     */
    var highValue: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(highValue) {
            setFieldValue(0, 0, highValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(1, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
