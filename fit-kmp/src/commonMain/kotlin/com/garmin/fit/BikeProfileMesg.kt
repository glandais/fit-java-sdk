/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from BikeProfileMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class BikeProfileMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val NameFieldNum = 0
        const val SportFieldNum = 1
        const val SubSportFieldNum = 2
        const val OdometerFieldNum = 3
        const val BikeSpdAntIdFieldNum = 4
        const val BikeCadAntIdFieldNum = 5
        const val BikeSpdcadAntIdFieldNum = 6
        const val BikePowerAntIdFieldNum = 7
        const val CustomWheelsizeFieldNum = 8
        const val AutoWheelsizeFieldNum = 9
        const val BikeWeightFieldNum = 10
        const val PowerCalFactorFieldNum = 11
        const val AutoWheelCalFieldNum = 12
        const val AutoPowerZeroFieldNum = 13
        const val IdFieldNum = 14
        const val SpdEnabledFieldNum = 15
        const val CadEnabledFieldNum = 16
        const val SpdcadEnabledFieldNum = 17
        const val PowerEnabledFieldNum = 18
        const val CrankLengthFieldNum = 19
        const val EnabledFieldNum = 20
        const val BikeSpdAntIdTransTypeFieldNum = 21
        const val BikeCadAntIdTransTypeFieldNum = 22
        const val BikeSpdcadAntIdTransTypeFieldNum = 23
        const val BikePowerAntIdTransTypeFieldNum = 24
        const val OdometerRolloverFieldNum = 37
        const val FrontGearNumFieldNum = 38
        const val FrontGearFieldNum = 39
        const val RearGearNumFieldNum = 40
        const val RearGearFieldNum = 41
        const val ShimanoDi2EnabledFieldNum = 44

        val bikeProfileMesg: Mesg = run {
            // bike_profile
            val bikeProfileMesg = Mesg("bike_profile", MesgNum.BIKE_PROFILE)
            bikeProfileMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            bikeProfileMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            bikeProfileMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            bikeProfileMesg.addField(Field("sub_sport", SubSportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SUB_SPORT))
            bikeProfileMesg.addField(Field("odometer", OdometerFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            bikeProfileMesg.addField(Field("bike_spd_ant_id", BikeSpdAntIdFieldNum, 139, 1.0, 0.0, "", false, Profile.Type.UINT16Z))
            bikeProfileMesg.addField(Field("bike_cad_ant_id", BikeCadAntIdFieldNum, 139, 1.0, 0.0, "", false, Profile.Type.UINT16Z))
            bikeProfileMesg.addField(Field("bike_spdcad_ant_id", BikeSpdcadAntIdFieldNum, 139, 1.0, 0.0, "", false, Profile.Type.UINT16Z))
            bikeProfileMesg.addField(Field("bike_power_ant_id", BikePowerAntIdFieldNum, 139, 1.0, 0.0, "", false, Profile.Type.UINT16Z))
            bikeProfileMesg.addField(Field("custom_wheelsize", CustomWheelsizeFieldNum, 132, 1000.0, 0.0, "m", false, Profile.Type.UINT16))
            bikeProfileMesg.addField(Field("auto_wheelsize", AutoWheelsizeFieldNum, 132, 1000.0, 0.0, "m", false, Profile.Type.UINT16))
            bikeProfileMesg.addField(Field("bike_weight", BikeWeightFieldNum, 132, 10.0, 0.0, "kg", false, Profile.Type.UINT16))
            bikeProfileMesg.addField(Field("power_cal_factor", PowerCalFactorFieldNum, 132, 10.0, 0.0, "%", false, Profile.Type.UINT16))
            bikeProfileMesg.addField(Field("auto_wheel_cal", AutoWheelCalFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            bikeProfileMesg.addField(Field("auto_power_zero", AutoPowerZeroFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            bikeProfileMesg.addField(Field("id", IdFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            bikeProfileMesg.addField(Field("spd_enabled", SpdEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            bikeProfileMesg.addField(Field("cad_enabled", CadEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            bikeProfileMesg.addField(Field("spdcad_enabled", SpdcadEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            bikeProfileMesg.addField(Field("power_enabled", PowerEnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            bikeProfileMesg.addField(Field("crank_length", CrankLengthFieldNum, 2, 2.0, -110.0, "mm", false, Profile.Type.UINT8))
            bikeProfileMesg.addField(Field("enabled", EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            bikeProfileMesg.addField(Field("bike_spd_ant_id_trans_type", BikeSpdAntIdTransTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            bikeProfileMesg.addField(Field("bike_cad_ant_id_trans_type", BikeCadAntIdTransTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            bikeProfileMesg.addField(Field("bike_spdcad_ant_id_trans_type", BikeSpdcadAntIdTransTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            bikeProfileMesg.addField(Field("bike_power_ant_id_trans_type", BikePowerAntIdTransTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            bikeProfileMesg.addField(Field("odometer_rollover", OdometerRolloverFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            bikeProfileMesg.addField(Field("front_gear_num", FrontGearNumFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            bikeProfileMesg.addField(Field("front_gear", FrontGearFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            bikeProfileMesg.addField(Field("rear_gear_num", RearGearNumFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            bikeProfileMesg.addField(Field("rear_gear", RearGearFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            bikeProfileMesg.addField(Field("shimano_di2_enabled", ShimanoDi2EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            bikeProfileMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.BIKE_PROFILE))

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
     * Get name field
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(0, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sport field
     *
     * @return sport
     */
    var sport: Sport?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Sport.fromValue(value)
        }
        set(sport) {
            setFieldValue(1, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sub_sport field
     *
     * @return sub_sport
     */
    var subSport: SubSport?
        get() {
            val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SubSport.fromValue(value)
        }
        set(subSport) {
            setFieldValue(2, 0, subSport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
     * Get bike_spd_ant_id field
     *
     * @return bike_spd_ant_id
     */
    var bikeSpdAntId: Int?
        get() {
            return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikeSpdAntId) {
            setFieldValue(4, 0, bikeSpdAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bike_cad_ant_id field
     *
     * @return bike_cad_ant_id
     */
    var bikeCadAntId: Int?
        get() {
            return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikeCadAntId) {
            setFieldValue(5, 0, bikeCadAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bike_spdcad_ant_id field
     *
     * @return bike_spdcad_ant_id
     */
    var bikeSpdcadAntId: Int?
        get() {
            return getFieldIntegerValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikeSpdcadAntId) {
            setFieldValue(6, 0, bikeSpdcadAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bike_power_ant_id field
     *
     * @return bike_power_ant_id
     */
    var bikePowerAntId: Int?
        get() {
            return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikePowerAntId) {
            setFieldValue(7, 0, bikePowerAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get custom_wheelsize field
     * Units: m
     *
     * @return custom_wheelsize
     */
    var customWheelsize: Float?
        get() {
            return getFieldFloatValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(customWheelsize) {
            setFieldValue(8, 0, customWheelsize, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get auto_wheelsize field
     * Units: m
     *
     * @return auto_wheelsize
     */
    var autoWheelsize: Float?
        get() {
            return getFieldFloatValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(autoWheelsize) {
            setFieldValue(9, 0, autoWheelsize, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bike_weight field
     * Units: kg
     *
     * @return bike_weight
     */
    var bikeWeight: Float?
        get() {
            return getFieldFloatValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikeWeight) {
            setFieldValue(10, 0, bikeWeight, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get power_cal_factor field
     * Units: %
     *
     * @return power_cal_factor
     */
    var powerCalFactor: Float?
        get() {
            return getFieldFloatValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(powerCalFactor) {
            setFieldValue(11, 0, powerCalFactor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get auto_wheel_cal field
     *
     * @return auto_wheel_cal
     */
    var autoWheelCal: Bool?
        get() {
            val value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(autoWheelCal) {
            setFieldValue(12, 0, autoWheelCal?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get auto_power_zero field
     *
     * @return auto_power_zero
     */
    var autoPowerZero: Bool?
        get() {
            val value = getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(autoPowerZero) {
            setFieldValue(13, 0, autoPowerZero?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get id field
     *
     * @return id
     */
    var id: Short?
        get() {
            return getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(id) {
            setFieldValue(14, 0, id, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get spd_enabled field
     *
     * @return spd_enabled
     */
    var spdEnabled: Bool?
        get() {
            val value = getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(spdEnabled) {
            setFieldValue(15, 0, spdEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cad_enabled field
     *
     * @return cad_enabled
     */
    var cadEnabled: Bool?
        get() {
            val value = getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(cadEnabled) {
            setFieldValue(16, 0, cadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get spdcad_enabled field
     *
     * @return spdcad_enabled
     */
    var spdcadEnabled: Bool?
        get() {
            val value = getFieldShortValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(spdcadEnabled) {
            setFieldValue(17, 0, spdcadEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get power_enabled field
     *
     * @return power_enabled
     */
    var powerEnabled: Bool?
        get() {
            val value = getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(powerEnabled) {
            setFieldValue(18, 0, powerEnabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get crank_length field
     * Units: mm
     *
     * @return crank_length
     */
    var crankLength: Float?
        get() {
            return getFieldFloatValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(crankLength) {
            setFieldValue(19, 0, crankLength, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enabled field
     *
     * @return enabled
     */
    var enabled: Bool?
        get() {
            val value = getFieldShortValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(enabled) {
            setFieldValue(20, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bike_spd_ant_id_trans_type field
     *
     * @return bike_spd_ant_id_trans_type
     */
    var bikeSpdAntIdTransType: Short?
        get() {
            return getFieldShortValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikeSpdAntIdTransType) {
            setFieldValue(21, 0, bikeSpdAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bike_cad_ant_id_trans_type field
     *
     * @return bike_cad_ant_id_trans_type
     */
    var bikeCadAntIdTransType: Short?
        get() {
            return getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikeCadAntIdTransType) {
            setFieldValue(22, 0, bikeCadAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bike_spdcad_ant_id_trans_type field
     *
     * @return bike_spdcad_ant_id_trans_type
     */
    var bikeSpdcadAntIdTransType: Short?
        get() {
            return getFieldShortValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikeSpdcadAntIdTransType) {
            setFieldValue(23, 0, bikeSpdcadAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bike_power_ant_id_trans_type field
     *
     * @return bike_power_ant_id_trans_type
     */
    var bikePowerAntIdTransType: Short?
        get() {
            return getFieldShortValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bikePowerAntIdTransType) {
            setFieldValue(24, 0, bikePowerAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get odometer_rollover field
     * Comment: Rollover counter that can be used to extend the odometer
     *
     * @return odometer_rollover
     */
    var odometerRollover: Short?
        get() {
            return getFieldShortValue(37, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(odometerRollover) {
            setFieldValue(37, 0, odometerRollover, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get front_gear_num field
     * Comment: Number of front gears
     *
     * @return front_gear_num
     */
    var frontGearNum: Short?
        get() {
            return getFieldShortValue(38, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(frontGearNum) {
            setFieldValue(38, 0, frontGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getFrontGear(): Array<Short?>? {
        return getFieldShortValues(39, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of front_gear
     */
    fun getNumFrontGear(): Int {
        return getNumFieldValues(39, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get front_gear field
     * Comment: Number of teeth on each gear 0 is innermost
     *
     * @param index of front_gear
     * @return front_gear
     */
    fun getFrontGear(index: Int): Short? {
        return getFieldShortValue(39, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set front_gear field
     * Comment: Number of teeth on each gear 0 is innermost
     *
     * @param index of front_gear
     * @param frontGear The new frontGear value to be set
     */
    fun setFrontGear(index: Int, frontGear: Short?) {
        setFieldValue(39, index, frontGear, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get rear_gear_num field
     * Comment: Number of rear gears
     *
     * @return rear_gear_num
     */
    var rearGearNum: Short?
        get() {
            return getFieldShortValue(40, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(rearGearNum) {
            setFieldValue(40, 0, rearGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getRearGear(): Array<Short?>? {
        return getFieldShortValues(41, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of rear_gear
     */
    fun getNumRearGear(): Int {
        return getNumFieldValues(41, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get rear_gear field
     * Comment: Number of teeth on each gear 0 is innermost
     *
     * @param index of rear_gear
     * @return rear_gear
     */
    fun getRearGear(index: Int): Short? {
        return getFieldShortValue(41, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set rear_gear field
     * Comment: Number of teeth on each gear 0 is innermost
     *
     * @param index of rear_gear
     * @param rearGear The new rearGear value to be set
     */
    fun setRearGear(index: Int, rearGear: Short?) {
        setFieldValue(41, index, rearGear, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get shimano_di2_enabled field
     *
     * @return shimano_di2_enabled
     */
    var shimanoDi2Enabled: Bool?
        get() {
            val value = getFieldShortValue(44, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(shimanoDi2Enabled) {
            setFieldValue(44, 0, shimanoDi2Enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
