/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from VideoDescriptionMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class VideoDescriptionMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val MessageCountFieldNum = 0
        const val TextFieldNum = 1

        val videoDescriptionMesg: Mesg = run {
            // video_description
            val videoDescriptionMesg = Mesg("video_description", MesgNum.VIDEO_DESCRIPTION)
            videoDescriptionMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            videoDescriptionMesg.addField(Field("message_count", MessageCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            videoDescriptionMesg.addField(Field("text", TextFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            videoDescriptionMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.VIDEO_DESCRIPTION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     * Comment: Long descriptions will be split into multiple parts
     *
     * @return message_index
     */
    fun getMessageIndex(): Int? {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_index field
     * Comment: Long descriptions will be split into multiple parts
     *
     * @param messageIndex The new messageIndex value to be set
     */
    fun setMessageIndex(messageIndex: Int?) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get message_count field
     * Comment: Total number of description parts
     *
     * @return message_count
     */
    fun getMessageCount(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_count field
     * Comment: Total number of description parts
     *
     * @param messageCount The new messageCount value to be set
     */
    fun setMessageCount(messageCount: Int?) {
        setFieldValue(0, 0, messageCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get text field
     *
     * @return text
     */
    fun getText(): String? {
        return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set text field
     *
     * @param text The new text value to be set
     */
    fun setText(text: String?) {
        setFieldValue(1, 0, text, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
