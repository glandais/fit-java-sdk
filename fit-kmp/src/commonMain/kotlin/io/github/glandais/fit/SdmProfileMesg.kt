/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SdmProfileMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class SdmProfileMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val EnabledFieldNum = 0
        const val SdmAntIdFieldNum = 1
        const val SdmCalFactorFieldNum = 2
        const val OdometerFieldNum = 3
        const val SpeedSourceFieldNum = 4
        const val SdmAntIdTransTypeFieldNum = 5
        const val OdometerRolloverFieldNum = 7

        val sdmProfileMesg: Mesg = run {
            // sdm_profile
            val sdmProfileMesg = Mesg("sdm_profile", MesgNum.SDM_PROFILE)
            sdmProfileMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            sdmProfileMesg.addField(Field("enabled", EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            sdmProfileMesg.addField(Field("sdm_ant_id", SdmAntIdFieldNum, 139, 1.0, 0.0, "", false, Profile.Type.UINT16Z))
            sdmProfileMesg.addField(Field("sdm_cal_factor", SdmCalFactorFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            sdmProfileMesg.addField(Field("odometer", OdometerFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            sdmProfileMesg.addField(Field("speed_source", SpeedSourceFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            sdmProfileMesg.addField(Field("sdm_ant_id_trans_type", SdmAntIdTransTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            sdmProfileMesg.addField(Field("odometer_rollover", OdometerRolloverFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            sdmProfileMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SDM_PROFILE))

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
     * Get enabled field
     *
     * @return enabled
     */
    var enabled: Bool?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(enabled) {
            setFieldValue(0, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sdm_ant_id field
     *
     * @return sdm_ant_id
     */
    var sdmAntId: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sdmAntId) {
            setFieldValue(1, 0, sdmAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sdm_cal_factor field
     * Units: %
     *
     * @return sdm_cal_factor
     */
    var sdmCalFactor: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sdmCalFactor) {
            setFieldValue(2, 0, sdmCalFactor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get odometer field
     * Units: m
     *
     * @return odometer
     */
    var odometer: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(odometer) {
            setFieldValue(3, 0, odometer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get speed_source field
     * Comment: Use footpod for speed source instead of GPS
     *
     * @return speed_source
     */
    var speedSource: Bool?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(speedSource) {
            setFieldValue(4, 0, speedSource?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sdm_ant_id_trans_type field
     *
     * @return sdm_ant_id_trans_type
     */
    var sdmAntIdTransType: Short?
        get() {
            return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sdmAntIdTransType) {
            setFieldValue(5, 0, sdmAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get odometer_rollover field
     * Comment: Rollover counter that can be used to extend the odometer
     *
     * @return odometer_rollover
     */
    var odometerRollover: Short?
        get() {
            return getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(odometerRollover) {
            setFieldValue(7, 0, odometerRollover, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
