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
     * Get device_type field
     *
     * @return device_type
     */
    fun getDeviceType(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set device_type field
     *
     * @param deviceType The new deviceType value to be set
     */
    fun setDeviceType(deviceType: Short?) {
        setFieldValue(1, 0, deviceType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get ble_device_type field
     *
     * @return ble_device_type
     */
    fun getBleDeviceType(): Short? {
        return getFieldShortValue(1, 0, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_BLE_DEVICE_TYPE)
    }

    /**
     * Set ble_device_type field
     *
     * @param bleDeviceType The new bleDeviceType value to be set
     */
    fun setBleDeviceType(bleDeviceType: Short?) {
        setFieldValue(1, 0, bleDeviceType, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_BLE_DEVICE_TYPE)
    }

    /**
     * Get antplus_device_type field
     *
     * @return antplus_device_type
     */
    fun getAntplusDeviceType(): Short? {
        return getFieldShortValue(1, 0, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANTPLUS_DEVICE_TYPE)
    }

    /**
     * Set antplus_device_type field
     *
     * @param antplusDeviceType The new antplusDeviceType value to be set
     */
    fun setAntplusDeviceType(antplusDeviceType: Short?) {
        setFieldValue(1, 0, antplusDeviceType, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANTPLUS_DEVICE_TYPE)
    }

    /**
     * Get ant_device_type field
     *
     * @return ant_device_type
     */
    fun getAntDeviceType(): Short? {
        return getFieldShortValue(1, 0, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANT_DEVICE_TYPE)
    }

    /**
     * Set ant_device_type field
     *
     * @param antDeviceType The new antDeviceType value to be set
     */
    fun setAntDeviceType(antDeviceType: Short?) {
        setFieldValue(1, 0, antDeviceType, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_ANT_DEVICE_TYPE)
    }

    /**
     * Get local_device_type field
     *
     * @return local_device_type
     */
    fun getLocalDeviceType(): Short? {
        return getFieldShortValue(1, 0, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_LOCAL_DEVICE_TYPE)
    }

    /**
     * Set local_device_type field
     *
     * @param localDeviceType The new localDeviceType value to be set
     */
    fun setLocalDeviceType(localDeviceType: Short?) {
        setFieldValue(1, 0, localDeviceType, Profile.SubFields.DEVICE_INFO_MESG_DEVICE_TYPE_FIELD_LOCAL_DEVICE_TYPE)
    }

    /**
     * Get manufacturer field
     *
     * @return manufacturer
     */
    fun getManufacturer(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set manufacturer field
     *
     * @param manufacturer The new manufacturer value to be set
     */
    fun setManufacturer(manufacturer: Int?) {
        setFieldValue(2, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get serial_number field
     *
     * @return serial_number
     */
    fun getSerialNumber(): Long? {
        return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set serial_number field
     *
     * @param serialNumber The new serialNumber value to be set
     */
    fun setSerialNumber(serialNumber: Long?) {
        setFieldValue(3, 0, serialNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get product field
     *
     * @return product
     */
    fun getProduct(): Int? {
        return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set product field
     *
     * @param product The new product value to be set
     */
    fun setProduct(product: Int?) {
        setFieldValue(4, 0, product, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get favero_product field
     *
     * @return favero_product
     */
    fun getFaveroProduct(): Int? {
        return getFieldIntegerValue(4, 0, Profile.SubFields.DEVICE_INFO_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
    }

    /**
     * Set favero_product field
     *
     * @param faveroProduct The new faveroProduct value to be set
     */
    fun setFaveroProduct(faveroProduct: Int?) {
        setFieldValue(4, 0, faveroProduct, Profile.SubFields.DEVICE_INFO_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
    }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    fun getGarminProduct(): Int? {
        return getFieldIntegerValue(4, 0, Profile.SubFields.DEVICE_INFO_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
    }

    /**
     * Set garmin_product field
     *
     * @param garminProduct The new garminProduct value to be set
     */
    fun setGarminProduct(garminProduct: Int?) {
        setFieldValue(4, 0, garminProduct, Profile.SubFields.DEVICE_INFO_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
    }

    /**
     * Get software_version field
     *
     * @return software_version
     */
    fun getSoftwareVersion(): Float? {
        return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set software_version field
     *
     * @param softwareVersion The new softwareVersion value to be set
     */
    fun setSoftwareVersion(softwareVersion: Float?) {
        setFieldValue(5, 0, softwareVersion, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get hardware_version field
     *
     * @return hardware_version
     */
    fun getHardwareVersion(): Short? {
        return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set hardware_version field
     *
     * @param hardwareVersion The new hardwareVersion value to be set
     */
    fun setHardwareVersion(hardwareVersion: Short?) {
        setFieldValue(6, 0, hardwareVersion, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get cum_operating_time field
     * Units: s
     * Comment: Reset by new battery or charge.
     *
     * @return cum_operating_time
     */
    fun getCumOperatingTime(): Long? {
        return getFieldLongValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set cum_operating_time field
     * Units: s
     * Comment: Reset by new battery or charge.
     *
     * @param cumOperatingTime The new cumOperatingTime value to be set
     */
    fun setCumOperatingTime(cumOperatingTime: Long?) {
        setFieldValue(7, 0, cumOperatingTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get battery_voltage field
     * Units: V
     *
     * @return battery_voltage
     */
    fun getBatteryVoltage(): Float? {
        return getFieldFloatValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set battery_voltage field
     * Units: V
     *
     * @param batteryVoltage The new batteryVoltage value to be set
     */
    fun setBatteryVoltage(batteryVoltage: Float?) {
        setFieldValue(10, 0, batteryVoltage, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get battery_status field
     *
     * @return battery_status
     */
    fun getBatteryStatus(): Short? {
        return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set battery_status field
     *
     * @param batteryStatus The new batteryStatus value to be set
     */
    fun setBatteryStatus(batteryStatus: Short?) {
        setFieldValue(11, 0, batteryStatus, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sensor_position field
     * Comment: Indicates the location of the sensor
     *
     * @return sensor_position
     */
    fun getSensorPosition(): BodyLocation? {
        val value = getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return BodyLocation.fromValue(value)
    }

    /**
     * Set sensor_position field
     * Comment: Indicates the location of the sensor
     *
     * @param sensorPosition The new sensorPosition value to be set
     */
    fun setSensorPosition(sensorPosition: BodyLocation?) {
        setFieldValue(18, 0, sensorPosition?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get descriptor field
     * Comment: Used to describe the sensor or location
     *
     * @return descriptor
     */
    fun getDescriptor(): String? {
        return getFieldStringValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set descriptor field
     * Comment: Used to describe the sensor or location
     *
     * @param descriptor The new descriptor value to be set
     */
    fun setDescriptor(descriptor: String?) {
        setFieldValue(19, 0, descriptor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get ant_transmission_type field
     *
     * @return ant_transmission_type
     */
    fun getAntTransmissionType(): Short? {
        return getFieldShortValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set ant_transmission_type field
     *
     * @param antTransmissionType The new antTransmissionType value to be set
     */
    fun setAntTransmissionType(antTransmissionType: Short?) {
        setFieldValue(20, 0, antTransmissionType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get ant_device_number field
     *
     * @return ant_device_number
     */
    fun getAntDeviceNumber(): Int? {
        return getFieldIntegerValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set ant_device_number field
     *
     * @param antDeviceNumber The new antDeviceNumber value to be set
     */
    fun setAntDeviceNumber(antDeviceNumber: Int?) {
        setFieldValue(21, 0, antDeviceNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get ant_network field
     *
     * @return ant_network
     */
    fun getAntNetwork(): AntNetwork? {
        val value = getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return AntNetwork.fromValue(value)
    }

    /**
     * Set ant_network field
     *
     * @param antNetwork The new antNetwork value to be set
     */
    fun setAntNetwork(antNetwork: AntNetwork?) {
        setFieldValue(22, 0, antNetwork?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get source_type field
     *
     * @return source_type
     */
    fun getSourceType(): SourceType? {
        val value = getFieldShortValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SourceType.fromValue(value)
    }

    /**
     * Set source_type field
     *
     * @param sourceType The new sourceType value to be set
     */
    fun setSourceType(sourceType: SourceType?) {
        setFieldValue(25, 0, sourceType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get product_name field
     * Comment: Optional free form string to indicate the devices name or model
     *
     * @return product_name
     */
    fun getProductName(): String? {
        return getFieldStringValue(27, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set product_name field
     * Comment: Optional free form string to indicate the devices name or model
     *
     * @param productName The new productName value to be set
     */
    fun setProductName(productName: String?) {
        setFieldValue(27, 0, productName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get battery_level field
     * Units: %
     *
     * @return battery_level
     */
    fun getBatteryLevel(): Short? {
        return getFieldShortValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set battery_level field
     * Units: %
     *
     * @param batteryLevel The new batteryLevel value to be set
     */
    fun setBatteryLevel(batteryLevel: Short?) {
        setFieldValue(32, 0, batteryLevel, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
