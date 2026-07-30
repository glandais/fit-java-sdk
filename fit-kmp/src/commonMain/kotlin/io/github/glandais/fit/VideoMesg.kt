/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from VideoMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class VideoMesg : Mesg {

    companion object {
        const val UrlFieldNum = 0
        const val HostingProviderFieldNum = 1
        const val DurationFieldNum = 2

        val videoMesg: Mesg = run {
            // video
            val videoMesg = Mesg("video", MesgNum.VIDEO)
            videoMesg.addField(Field("url", UrlFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            videoMesg.addField(Field("hosting_provider", HostingProviderFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            videoMesg.addField(Field("duration", DurationFieldNum, 134, 1.0, 0.0, "ms", false, Profile.Type.UINT32))
            videoMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.VIDEO))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get url field
     *
     * @return url
     */
    var url: String?
        get() {
            return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(url) {
            setFieldValue(0, 0, url, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get hosting_provider field
     *
     * @return hosting_provider
     */
    var hostingProvider: String?
        get() {
            return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(hostingProvider) {
            setFieldValue(1, 0, hostingProvider, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get duration field
     * Units: ms
     * Comment: Playback time of video
     *
     * @return duration
     */
    var duration: Long?
        get() {
            return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(duration) {
            setFieldValue(2, 0, duration, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
