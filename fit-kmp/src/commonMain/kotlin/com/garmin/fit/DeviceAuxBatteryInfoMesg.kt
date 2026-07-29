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
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    var deviceIndex: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(deviceIndex) {
            setFieldValue(0, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get battery_voltage field
     * Units: V
     *
     * @return battery_voltage
     */
    var batteryVoltage: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(batteryVoltage) {
            setFieldValue(1, 0, batteryVoltage, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get battery_status field
     *
     * @return battery_status
     */
    var batteryStatus: Short?
        get() {
            return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(batteryStatus) {
            setFieldValue(2, 0, batteryStatus, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get battery_identifier field
     *
     * @return battery_identifier
     */
    var batteryIdentifier: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(batteryIdentifier) {
            setFieldValue(3, 0, batteryIdentifier, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
