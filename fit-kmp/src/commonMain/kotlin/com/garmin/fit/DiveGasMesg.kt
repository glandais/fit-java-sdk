/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DiveGasMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class DiveGasMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val HeliumContentFieldNum = 0
        const val OxygenContentFieldNum = 1
        const val StatusFieldNum = 2
        const val ModeFieldNum = 3

        val diveGasMesg: Mesg = run {
            // dive_gas
            val diveGasMesg = Mesg("dive_gas", MesgNum.DIVE_GAS)
            diveGasMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            diveGasMesg.addField(Field("helium_content", HeliumContentFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            diveGasMesg.addField(Field("oxygen_content", OxygenContentFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            diveGasMesg.addField(Field("status", StatusFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DIVE_GAS_STATUS))
            diveGasMesg.addField(Field("mode", ModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.DIVE_GAS_MODE))
            diveGasMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.DIVE_GAS))

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
     * Get helium_content field
     * Units: percent
     *
     * @return helium_content
     */
    fun getHeliumContent(): Short? {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set helium_content field
     * Units: percent
     *
     * @param heliumContent The new heliumContent value to be set
     */
    fun setHeliumContent(heliumContent: Short?) {
        setFieldValue(0, 0, heliumContent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get oxygen_content field
     * Units: percent
     *
     * @return oxygen_content
     */
    fun getOxygenContent(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set oxygen_content field
     * Units: percent
     *
     * @param oxygenContent The new oxygenContent value to be set
     */
    fun setOxygenContent(oxygenContent: Short?) {
        setFieldValue(1, 0, oxygenContent, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get status field
     *
     * @return status
     */
    fun getStatus(): DiveGasStatus? {
        val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DiveGasStatus.fromValue(value)
    }

    /**
     * Set status field
     *
     * @param status The new status value to be set
     */
    fun setStatus(status: DiveGasStatus?) {
        setFieldValue(2, 0, status?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get mode field
     *
     * @return mode
     */
    fun getMode(): DiveGasMode? {
        val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return DiveGasMode.fromValue(value)
    }

    /**
     * Set mode field
     *
     * @param mode The new mode value to be set
     */
    fun setMode(mode: DiveGasMode?) {
        setFieldValue(3, 0, mode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
