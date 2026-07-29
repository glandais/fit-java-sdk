/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WatchfaceSettingsMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class WatchfaceSettingsMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val ModeFieldNum = 0
        const val LayoutFieldNum = 1

        val watchfaceSettingsMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // watchface_settings
            val watchfaceSettingsMesg = Mesg("watchface_settings", MesgNum.WATCHFACE_SETTINGS)
            watchfaceSettingsMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            watchfaceSettingsMesg.addField(Field("mode", ModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WATCHFACE_MODE))
            field_index++
            watchfaceSettingsMesg.addField(Field("layout", LayoutFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            subfield_index = 0
            watchfaceSettingsMesg.fields[field_index].subFields.add(SubField("digital_layout", 0, 1.0, 0.0, ""))
            watchfaceSettingsMesg.fields[field_index].subFields[subfield_index].addMap(0, 0L)
            subfield_index++
            watchfaceSettingsMesg.fields[field_index].subFields.add(SubField("analog_layout", 0, 1.0, 0.0, ""))
            watchfaceSettingsMesg.fields[field_index].subFields[subfield_index].addMap(0, 1L)
            subfield_index++
            field_index++
            watchfaceSettingsMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.WATCHFACE_SETTINGS))

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
     * Get mode field
     *
     * @return mode
     */
    var mode: WatchfaceMode?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return WatchfaceMode.fromValue(value)
        }
        set(mode) {
            setFieldValue(0, 0, mode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get layout field
     *
     * @return layout
     */
    var layout: Byte?
        get() {
            return getFieldByteValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(layout) {
            setFieldValue(1, 0, layout, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get digital_layout field
     *
     * @return digital_layout
     */
    var digitalLayout: DigitalWatchfaceLayout?
        get() {
            val value = getFieldShortValue(1, 0, Profile.SubFields.WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_DIGITAL_LAYOUT) ?: return null
            return DigitalWatchfaceLayout.fromValue(value)
        }
        set(digitalLayout) {
            setFieldValue(1, 0, digitalLayout?.value, Profile.SubFields.WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_DIGITAL_LAYOUT)
        }

    /**
     * Get analog_layout field
     *
     * @return analog_layout
     */
    var analogLayout: AnalogWatchfaceLayout?
        get() {
            val value = getFieldShortValue(1, 0, Profile.SubFields.WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_ANALOG_LAYOUT) ?: return null
            return AnalogWatchfaceLayout.fromValue(value)
        }
        set(analogLayout) {
            setFieldValue(1, 0, analogLayout?.value, Profile.SubFields.WATCHFACE_SETTINGS_MESG_LAYOUT_FIELD_ANALOG_LAYOUT)
        }
}
