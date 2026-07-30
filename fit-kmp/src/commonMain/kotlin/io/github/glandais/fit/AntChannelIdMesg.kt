/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AntChannelIdMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var channelNumber: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(channelNumber) {
            setFieldValue(0, 0, channelNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
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
     * Get device_number field
     *
     * @return device_number
     */
    var deviceNumber: Int?
        get() {
            return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(deviceNumber) {
            setFieldValue(2, 0, deviceNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get transmission_type field
     *
     * @return transmission_type
     */
    var transmissionType: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(transmissionType) {
            setFieldValue(3, 0, transmissionType, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get device_index field
     *
     * @return device_index
     */
    var deviceIndex: Short?
        get() {
            return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(deviceIndex) {
            setFieldValue(4, 0, deviceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
