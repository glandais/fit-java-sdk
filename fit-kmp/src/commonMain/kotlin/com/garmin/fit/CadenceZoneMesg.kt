/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CadenceZoneMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class CadenceZoneMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val HighValueFieldNum = 0
        const val NameFieldNum = 1

        val cadenceZoneMesg: Mesg = run {
            // cadence_zone
            val cadenceZoneMesg = Mesg("cadence_zone", MesgNum.CADENCE_ZONE)
            cadenceZoneMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            cadenceZoneMesg.addField(Field("high_value", HighValueFieldNum, 2, 1.0, 0.0, "rpm", false, Profile.Type.UINT8))
            cadenceZoneMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            cadenceZoneMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.CADENCE_ZONE))

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
     * Units: rpm
     *
     * @return high_value
     */
    var highValue: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
