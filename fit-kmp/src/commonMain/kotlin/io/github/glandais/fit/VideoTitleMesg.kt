/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from VideoTitleMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class VideoTitleMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val MessageCountFieldNum = 0
        const val TextFieldNum = 1

        val videoTitleMesg: Mesg = run {
            // video_title
            val videoTitleMesg = Mesg("video_title", MesgNum.VIDEO_TITLE)
            videoTitleMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            videoTitleMesg.addField(Field("message_count", MessageCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            videoTitleMesg.addField(Field("text", TextFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            videoTitleMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.VIDEO_TITLE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     * Comment: Long titles will be split into multiple parts
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
     * Get message_count field
     * Comment: Total number of title parts
     *
     * @return message_count
     */
    var messageCount: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageCount) {
            setFieldValue(0, 0, messageCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get text field
     *
     * @return text
     */
    var text: String?
        get() {
            return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(text) {
            setFieldValue(1, 0, text, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
