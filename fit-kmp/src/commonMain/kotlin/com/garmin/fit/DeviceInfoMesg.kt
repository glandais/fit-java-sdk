/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DeviceInfoMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class DeviceInfoMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val DeviceIndexFieldNum = 0
        const val DeviceTypeFieldNum = 1
        const val ManufacturerFieldNum = 2
        const val SerialNumberFieldNum = 3
        const val ProductFieldNum = 4
        const val SoftwareVersionFieldNum = 5
        const val HardwareVersionFieldNum = 6
        const val CumOperatingTimeFieldNum = 7
        const val BatteryVoltageFieldNum = 10
        const val BatteryStatusFieldNum = 11
        const val SensorPositionFieldNum = 18
        const val DescriptorFieldNum = 19
        const val AntTransmissionTypeFieldNum = 20
        const val AntDeviceNumberFieldNum = 21
        const val AntNetworkFieldNum = 22
        const val SourceTypeFieldNum = 25
        const val ProductNameFieldNum = 27
        const val BatteryLevelFieldNum = 32

        val deviceInfoMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // device_info
            val deviceInfoMesg = Mesg("device_info", MesgNum.DEVICE_INFO)
            deviceInfoMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            deviceInfoMesg.addField(Field("device_index", DeviceIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.DEVICE_INDEX))
            field_index++
            deviceInfoMesg.addField(Field("device_type", DeviceTypeFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            subfield_index = 0
            deviceInfoMesg.fields[field_index].subFields.add(SubField("ble_device_type", 2, 1.0, 0.0, ""))
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(25, 3L)
            subfield_index++
            deviceInfoMesg.fields[field_index].subFields.add(SubField("antplus_device_type", 2, 1.0, 0.0, ""))
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(25, 1L)
            subfield_index++
            deviceInfoMesg.fields[field_index].subFields.add(SubField("ant_device_type", 2, 1.0, 0.0, ""))
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(25, 0L)
            subfield_index++
            deviceInfoMesg.fields[field_index].subFields.add(SubField("local_device_type", 2, 1.0, 0.0, ""))
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(25, 5L)
            subfield_index++
            field_index++
            deviceInfoMesg.addField(Field("manufacturer", ManufacturerFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MANUFACTURER))
            field_index++
            deviceInfoMesg.addField(Field("serial_number", SerialNumberFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.UINT32Z))
            field_index++
            deviceInfoMesg.addField(Field("product", ProductFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            subfield_index = 0
            deviceInfoMesg.fields[field_index].subFields.add(SubField("favero_product", 132, 1.0, 0.0, ""))
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(2, 263L)
            subfield_index++
            deviceInfoMesg.fields[field_index].subFields.add(SubField("garmin_product", 132, 1.0, 0.0, ""))
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(2, 1L)
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(2, 15L)
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(2, 13L)
            deviceInfoMesg.fields[field_index].subFields[subfield_index].addMap(2, 89L)
            subfield_index++
            field_index++
            deviceInfoMesg.addField(Field("software_version", SoftwareVersionFieldNum, 132, 100.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            deviceInfoMesg.addField(Field("hardware_version", HardwareVersionFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            deviceInfoMesg.addField(Field("cum_operating_time", CumOperatingTimeFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            field_index++
            deviceInfoMesg.addField(Field("battery_voltage", BatteryVoltageFieldNum, 132, 256.0, 0.0, "V", false, Profile.Type.UINT16))
            field_index++
            deviceInfoMesg.addField(Field("battery_status", BatteryStatusFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.BATTERY_STATUS))
            field_index++
            deviceInfoMesg.addField(Field("sensor_position", SensorPositionFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BODY_LOCATION))
            field_index++
            deviceInfoMesg.addField(Field("descriptor", DescriptorFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            deviceInfoMesg.addField(Field("ant_transmission_type", AntTransmissionTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            field_index++
            deviceInfoMesg.addField(Field("ant_device_number", AntDeviceNumberFieldNum, 139, 1.0, 0.0, "", false, Profile.Type.UINT16Z))
            field_index++
            deviceInfoMesg.addField(Field("ant_network", AntNetworkFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ANT_NETWORK))
            field_index++
            deviceInfoMesg.addField(Field("source_type", SourceTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SOURCE_TYPE))
            field_index++
            deviceInfoMesg.addField(Field("product_name", ProductNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            deviceInfoMesg.addField(Field("battery_level", BatteryLevelFieldNum, 2, 1.0, 0.0, "%", false, Profile.Type.UINT8))
            field_index++
            deviceInfoMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.DEVICE_INFO))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
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
     * Get device_type field
     *
     * @return device_type
     */
    var deviceType: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(deviceType) {
            setFieldValue(1, 0, deviceType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ble_device_type field
     *
     * @return ble_device_type
     */
    var bleDeviceType: Short?
        get() {
            return getFieldShortValue(1, 0, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_BLE_DEVICE_TYPE)
        }
        set(bleDeviceType) {
            setFieldValue(1, 0, bleDeviceType, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_BLE_DEVICE_TYPE)
        }

    /**
     * Get antplus_device_type field
     *
     * @return antplus_device_type
     */
    var antplusDeviceType: Short?
        get() {
            return getFieldShortValue(1, 0, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANTPLUS_DEVICE_TYPE)
        }
        set(antplusDeviceType) {
            setFieldValue(1, 0, antplusDeviceType, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANTPLUS_DEVICE_TYPE)
        }

    /**
     * Get ant_device_type field
     *
     * @return ant_device_type
     */
    var antDeviceType: Short?
        get() {
            return getFieldShortValue(1, 0, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANT_DEVICE_TYPE)
        }
        set(antDeviceType) {
            setFieldValue(1, 0, antDeviceType, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANT_DEVICE_TYPE)
        }

    /**
     * Get local_device_type field
     *
     * @return local_device_type
     */
    var localDeviceType: Short?
        get() {
            return getFieldShortValue(1, 0, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_LOCAL_DEVICE_TYPE)
        }
        set(localDeviceType) {
            setFieldValue(1, 0, localDeviceType, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_LOCAL_DEVICE_TYPE)
        }

    /**
     * Get manufacturer field
     *
     * @return manufacturer
     */
    var manufacturer: Int?
        get() {
            return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(manufacturer) {
            setFieldValue(2, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get serial_number field
     *
     * @return serial_number
     */
    var serialNumber: Long?
        get() {
            return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(serialNumber) {
            setFieldValue(3, 0, serialNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get product field
     *
     * @return product
     */
    var product: Int?
        get() {
            return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(product) {
            setFieldValue(4, 0, product, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get favero_product field
     *
     * @return favero_product
     */
    var faveroProduct: Int?
        get() {
            return getFieldIntegerValue(4, 0, Profile.SubFields.DEVICE_INFO_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }
        set(faveroProduct) {
            setFieldValue(4, 0, faveroProduct, Profile.SubFields.DEVICE_INFO_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    var garminProduct: Int?
        get() {
            return getFieldIntegerValue(4, 0, Profile.SubFields.DEVICE_INFO_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
        }
        set(garminProduct) {
            setFieldValue(4, 0, garminProduct, Profile.SubFields.DEVICE_INFO_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
        }

    /**
     * Get software_version field
     *
     * @return software_version
     */
    var softwareVersion: Float?
        get() {
            return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(softwareVersion) {
            setFieldValue(5, 0, softwareVersion, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get hardware_version field
     *
     * @return hardware_version
     */
    var hardwareVersion: Short?
        get() {
            return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(hardwareVersion) {
            setFieldValue(6, 0, hardwareVersion, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get cum_operating_time field
     * Units: s
     * Comment: Reset by new battery or charge.
     *
     * @return cum_operating_time
     */
    var cumOperatingTime: Long?
        get() {
            return getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cumOperatingTime) {
            setFieldValue(7, 0, cumOperatingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get battery_voltage field
     * Units: V
     *
     * @return battery_voltage
     */
    var batteryVoltage: Float?
        get() {
            return getFieldFloatValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(batteryVoltage) {
            setFieldValue(10, 0, batteryVoltage, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get battery_status field
     *
     * @return battery_status
     */
    var batteryStatus: Short?
        get() {
            return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(batteryStatus) {
            setFieldValue(11, 0, batteryStatus, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sensor_position field
     * Comment: Indicates the location of the sensor
     *
     * @return sensor_position
     */
    var sensorPosition: BodyLocation?
        get() {
            val value = getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return BodyLocation.fromValue(value)
        }
        set(sensorPosition) {
            setFieldValue(18, 0, sensorPosition?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get descriptor field
     * Comment: Used to describe the sensor or location
     *
     * @return descriptor
     */
    var descriptor: String?
        get() {
            return getFieldStringValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(descriptor) {
            setFieldValue(19, 0, descriptor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ant_transmission_type field
     *
     * @return ant_transmission_type
     */
    var antTransmissionType: Short?
        get() {
            return getFieldShortValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(antTransmissionType) {
            setFieldValue(20, 0, antTransmissionType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ant_device_number field
     *
     * @return ant_device_number
     */
    var antDeviceNumber: Int?
        get() {
            return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(antDeviceNumber) {
            setFieldValue(21, 0, antDeviceNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ant_network field
     *
     * @return ant_network
     */
    var antNetwork: AntNetwork?
        get() {
            val value = getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return AntNetwork.fromValue(value)
        }
        set(antNetwork) {
            setFieldValue(22, 0, antNetwork?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get source_type field
     *
     * @return source_type
     */
    var sourceType: SourceType?
        get() {
            val value = getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SourceType.fromValue(value)
        }
        set(sourceType) {
            setFieldValue(25, 0, sourceType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get product_name field
     * Comment: Optional free form string to indicate the devices name or model
     *
     * @return product_name
     */
    var productName: String?
        get() {
            return getFieldStringValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(productName) {
            setFieldValue(27, 0, productName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get battery_level field
     * Units: %
     *
     * @return battery_level
     */
    var batteryLevel: Short?
        get() {
            return getFieldShortValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(batteryLevel) {
            setFieldValue(32, 0, batteryLevel, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
