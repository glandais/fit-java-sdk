/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from OhrSettingsMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class OhrSettingsMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val EnabledFieldNum = 0

        val ohrSettingsMesg: Mesg = run {
            // ohr_settings
            val ohrSettingsMesg = Mesg("ohr_settings", MesgNum.OHR_SETTINGS)
            ohrSettingsMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            ohrSettingsMesg.addField(Field("enabled", EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SWITCH))
            ohrSettingsMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.OHR_SETTINGS))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enabled field
     *
     * @return enabled
     */
    fun getEnabled(): Switch? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Switch.fromValue(value)
    }

    /**
     * Set enabled field
     *
     * @param enabled The new enabled value to be set
     */
    fun setEnabled(enabled: Switch?) {
        setFieldValue(0, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
