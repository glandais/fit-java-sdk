/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HrZoneMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HrZoneMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val HighBpmFieldNum = 1
        const val NameFieldNum = 2

        val hrZoneMesg: Mesg = run {
            // hr_zone
            val hrZoneMesg = Mesg("hr_zone", MesgNum.HR_ZONE)
            hrZoneMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            hrZoneMesg.addField(Field("high_bpm", HighBpmFieldNum, 2, 1.0, 0.0, "bpm", false, Profile.Type.UINT8))
            hrZoneMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            hrZoneMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HR_ZONE))

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
     * Get high_bpm field
     * Units: bpm
     *
     * @return high_bpm
     */
    fun getHighBpm(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set high_bpm field
     * Units: bpm
     *
     * @param highBpm The new highBpm value to be set
     */
    fun setHighBpm(highBpm: Short?) {
        setFieldValue(1, 0, highBpm, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
