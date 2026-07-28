/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AntChannelIdMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class AntChannelIdMesg : Mesg {

    companion object {
        const val ChannelNumberFieldNum = 0
        const val DeviceTypeFieldNum = 1
        const val DeviceNumberFieldNum = 2
        const val TransmissionTypeFieldNum = 3
        const val DeviceIndexFieldNum = 4

        val antChannelIdMesg: Mesg = run {
            // ant_channel_id
            val antChannelIdMesg = Mesg("ant_channel_id", MesgNum.ANT_CHANNEL_ID)
            antChannelIdMesg.addField(Field("channel_number", ChannelNumberFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            antChannelIdMesg.addField(Field("device_type", DeviceTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            antChannelIdMesg.addField(Field("device_number", DeviceNumberFieldNum, 139, 1.0, 0.0, "", false, Profile.Type.UINT16Z))
            antChannelIdMesg.addField(Field("transmission_type", TransmissionTypeFieldNum, 10, 1.0, 0.0, "", false, Profile.Type.UINT8Z))
            antChannelIdMesg.addField(Field("device_index", DeviceIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.DEVICE_INDEX))
            antChannelIdMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.ANT_CHANNEL_ID))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get channel_number field
     *
     * @return channel_number
     */
    fun getChannelNumber(): Short? {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set channel_number field
     *
     * @param channelNumber The new channelNumber value to be set
     */
    fun setChannelNumber(channelNumber: Short?) {
        setFieldValue(0, 0, channelNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
     * Get device_number field
     *
     * @return device_number
     */
    fun getDeviceNumber(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set device_number field
     *
     * @param deviceNumber The new deviceNumber value to be set
     */
    fun setDeviceNumber(deviceNumber: Int?) {
        setFieldValue(2, 0, deviceNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get transmission_type field
     *
     * @return transmission_type
     */
    fun getTransmissionType(): Short? {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set transmission_type field
     *
     * @param transmissionType The new transmissionType value to be set
     */
    fun setTransmissionType(transmissionType: Short?) {
        setFieldValue(3, 0, transmissionType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    fun getDeviceIndex(): Short? {
        return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set device_index field
     *
     * @param deviceIndex The new deviceIndex value to be set
     */
    fun setDeviceIndex(deviceIndex: Short?) {
        setFieldValue(4, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
