/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ExdScreenConfigurationMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class ExdScreenConfigurationMesg : Mesg {

    companion object {
        const val ScreenIndexFieldNum = 0
        const val FieldCountFieldNum = 1
        const val LayoutFieldNum = 2
        const val ScreenEnabledFieldNum = 3

        val exdScreenConfigurationMesg: Mesg = run {
            // exd_screen_configuration
            val exdScreenConfigurationMesg = Mesg("exd_screen_configuration", MesgNum.EXD_SCREEN_CONFIGURATION)
            exdScreenConfigurationMesg.addField(Field("screen_index", ScreenIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            exdScreenConfigurationMesg.addField(Field("field_count", FieldCountFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            exdScreenConfigurationMesg.addField(Field("layout", LayoutFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EXD_LAYOUT))
            exdScreenConfigurationMesg.addField(Field("screen_enabled", ScreenEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            exdScreenConfigurationMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.EXD_SCREEN_CONFIGURATION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get screen_index field
     *
     * @return screen_index
     */
    var screenIndex: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(screenIndex) {
            setFieldValue(0, 0, screenIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get field_count field
     * Comment: number of fields in screen
     *
     * @return field_count
     */
    var fieldCount: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fieldCount) {
            setFieldValue(1, 0, fieldCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get layout field
     *
     * @return layout
     */
    var layout: ExdLayout?
        get() {
            val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ExdLayout.fromValue(value)
        }
        set(layout) {
            setFieldValue(2, 0, layout?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get screen_enabled field
     *
     * @return screen_enabled
     */
    var screenEnabled: Bool?
        get() {
            val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(screenEnabled) {
            setFieldValue(3, 0, screenEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
