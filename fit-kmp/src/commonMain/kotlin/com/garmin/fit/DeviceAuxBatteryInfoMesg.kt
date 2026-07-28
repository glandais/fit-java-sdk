/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DeviceAuxBatteryInfoMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class DeviceAuxBatteryInfoMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val DeviceIndexFieldNum = 0
        const val BatteryVoltageFieldNum = 1
        const val BatteryStatusFieldNum = 2
        const val BatteryIdentifierFieldNum = 3

        val deviceAuxBatteryInfoMesg: Mesg = run {
            // device_aux_battery_info
            val deviceAuxBatteryInfoMesg = Mesg("device_aux_battery_info", MesgNum.DEVICE_AUX_BATTERY_INFO)
            deviceAuxBatteryInfoMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            deviceAuxBatteryInfoMesg.addField(Field("device_index", DeviceIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.DEVICE_INDEX))
            deviceAuxBatteryInfoMesg.addField(Field("battery_voltage", BatteryVoltageFieldNum, 132, 256.0, 0.0, "V", false, Profile.Type.UINT16))
            deviceAuxBatteryInfoMesg.addField(Field("battery_status", BatteryStatusFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.BATTERY_STATUS))
            deviceAuxBatteryInfoMesg.addField(Field("battery_identifier", BatteryIdentifierFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            deviceAuxBatteryInfoMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.DEVICE_AUX_BATTERY_INFO))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    fun getDeviceIndex(): Short? {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set device_index field
     *
     * @param deviceIndex The new deviceIndex value to be set
     */
    fun setDeviceIndex(deviceIndex: Short?) {
        setFieldValue(0, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get battery_voltage field
     * Units: V
     *
     * @return battery_voltage
     */
    fun getBatteryVoltage(): Float? {
        return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set battery_voltage field
     * Units: V
     *
     * @param batteryVoltage The new batteryVoltage value to be set
     */
    fun setBatteryVoltage(batteryVoltage: Float?) {
        setFieldValue(1, 0, batteryVoltage, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get battery_status field
     *
     * @return battery_status
     */
    fun getBatteryStatus(): Short? {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set battery_status field
     *
     * @param batteryStatus The new batteryStatus value to be set
     */
    fun setBatteryStatus(batteryStatus: Short?) {
        setFieldValue(2, 0, batteryStatus, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get battery_identifier field
     *
     * @return battery_identifier
     */
    fun getBatteryIdentifier(): Short? {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set battery_identifier field
     *
     * @param batteryIdentifier The new batteryIdentifier value to be set
     */
    fun setBatteryIdentifier(batteryIdentifier: Short?) {
        setFieldValue(3, 0, batteryIdentifier, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
