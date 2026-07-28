/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HrmProfileMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HrmProfileMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val EnabledFieldNum = 0
        const val HrmAntIdFieldNum = 1
        const val LogHrvFieldNum = 2
        const val HrmAntIdTransTypeFieldNum = 3

        val hrmProfileMesg: Mesg = run {
            // hrm_profile
            val hrmProfileMesg = Mesg("hrm_profile", MesgNum.HRM_PROFILE)
            hrmProfileMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            hrmProfileMesg.addField(Field("enabled", EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            hrmProfileMesg.addField(Field("hrm_ant_id", HrmAntIdFieldNum, 139, 1.0, 0.0, "", false, Profile.Type.UINT16Z))
            hrmProfileMesg.addField(Field("log_hrv", LogHrvFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            hrmProfileMesg.addField(Field("hrm_ant_id_trans_type", HrmAntIdTransTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            hrmProfileMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HRM_PROFILE))

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
     * Get enabled field
     *
     * @return enabled
     */
    fun getEnabled(): Bool? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set enabled field
     *
     * @param enabled The new enabled value to be set
     */
    fun setEnabled(enabled: Bool?) {
        setFieldValue(0, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get hrm_ant_id field
     *
     * @return hrm_ant_id
     */
    fun getHrmAntId(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set hrm_ant_id field
     *
     * @param hrmAntId The new hrmAntId value to be set
     */
    fun setHrmAntId(hrmAntId: Int?) {
        setFieldValue(1, 0, hrmAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get log_hrv field
     *
     * @return log_hrv
     */
    fun getLogHrv(): Bool? {
        val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set log_hrv field
     *
     * @param logHrv The new logHrv value to be set
     */
    fun setLogHrv(logHrv: Bool?) {
        setFieldValue(2, 0, logHrv?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get hrm_ant_id_trans_type field
     *
     * @return hrm_ant_id_trans_type
     */
    fun getHrmAntIdTransType(): Short? {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set hrm_ant_id_trans_type field
     *
     * @param hrmAntIdTransType The new hrmAntIdTransType value to be set
     */
    fun setHrmAntIdTransType(hrmAntIdTransType: Short?) {
        setFieldValue(3, 0, hrmAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
