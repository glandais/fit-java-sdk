/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SoftwareMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SoftwareMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val VersionFieldNum = 3
        const val PartNumberFieldNum = 5

        val softwareMesg: Mesg = run {
            // software
            val softwareMesg = Mesg("software", MesgNum.SOFTWARE)
            softwareMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            softwareMesg.addField(Field("version", VersionFieldNum, 132, 100.0, 0.0, "", false, Profile.Type.UINT16))
            softwareMesg.addField(Field("part_number", PartNumberFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            softwareMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SOFTWARE))

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
     * Get version field
     *
     * @return version
     */
    fun getVersion(): Float? {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set version field
     *
     * @param version The new version value to be set
     */
    fun setVersion(version: Float?) {
        setFieldValue(3, 0, version, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get part_number field
     *
     * @return part_number
     */
    fun getPartNumber(): String? {
        return getFieldStringValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set part_number field
     *
     * @param partNumber The new partNumber value to be set
     */
    fun setPartNumber(partNumber: String?) {
        setFieldValue(5, 0, partNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
