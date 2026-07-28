/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from PowerZoneMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

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
     * Get high_value field
     * Units: watts
     *
     * @return high_value
     */
    fun getHighValue(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set high_value field
     * Units: watts
     *
     * @param highValue The new highValue value to be set
     */
    fun setHighValue(highValue: Int?) {
        setFieldValue(1, 0, highValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get name field
     *
     * @return name
     */
    override fun getName(): String? {
        return getFieldStringValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set name field
     *
     * @param name The new name value to be set
     */
    fun setName(name: String?) {
        setFieldValue(2, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
