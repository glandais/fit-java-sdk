/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AntRxMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class AntRxMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val FractionalTimestampFieldNum = 0
        const val MesgIdFieldNum = 1
        const val MesgDataFieldNum = 2
        const val ChannelNumberFieldNum = 3
        const val DataFieldNum = 4

        val antRxMesg: Mesg = run {
            var field_index = 0
            // ant_rx
            val antRxMesg = Mesg("ant_rx", MesgNum.ANT_RX)
            antRxMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            antRxMesg.addField(Field("fractional_timestamp", FractionalTimestampFieldNum, 132, 32768.0, 0.0, "s", false, Profile.Type.UINT16))
            field_index++
            antRxMesg.addField(Field("mesg_id", MesgIdFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            field_index++
            antRxMesg.addField(Field("mesg_data", MesgDataFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            antRxMesg.fields[field_index].components.add(FieldComponent(3, false, 8, 1.0, 0.0)) // channel_number
            antRxMesg.fields[field_index].components.add(FieldComponent(4, false, 8, 1.0, 0.0)) // data
            antRxMesg.fields[field_index].components.add(FieldComponent(4, false, 8, 1.0, 0.0)) // data
            antRxMesg.fields[field_index].components.add(FieldComponent(4, false, 8, 1.0, 0.0)) // data
            antRxMesg.fields[field_index].components.add(FieldComponent(4, false, 8, 1.0, 0.0)) // data
            antRxMesg.fields[field_index].components.add(FieldComponent(4, false, 8, 1.0, 0.0)) // data
            antRxMesg.fields[field_index].components.add(FieldComponent(4, false, 8, 1.0, 0.0)) // data
            antRxMesg.fields[field_index].components.add(FieldComponent(4, false, 8, 1.0, 0.0)) // data
            antRxMesg.fields[field_index].components.add(FieldComponent(4, false, 8, 1.0, 0.0)) // data
            field_index++
            antRxMesg.addField(Field("channel_number", ChannelNumberFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            antRxMesg.addField(Field("data", DataFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            field_index++
            antRxMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.ANT_RX))

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
     * Get fractional_timestamp field
     * Units: s
     *
     * @return fractional_timestamp
     */
    var fractionalTimestamp: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fractionalTimestamp) {
            setFieldValue(0, 0, fractionalTimestamp, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get mesg_id field
     *
     * @return mesg_id
     */
    var mesgId: Byte?
        get() {
            return getFieldByteValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(mesgId) {
            setFieldValue(1, 0, mesgId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getMesgData(): Array<Byte?>? {
        return getFieldByteValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of mesg_data
     */
    fun getNumMesgData(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get mesg_data field
     *
     * @param index of mesg_data
     * @return mesg_data
     */
    fun getMesgData(index: Int): Byte? {
        return getFieldByteValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set mesg_data field
     *
     * @param index of mesg_data
     * @param mesgData The new mesgData value to be set
     */
    fun setMesgData(index: Int, mesgData: Byte?) {
        setFieldValue(2, index, mesgData, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get channel_number field
     *
     * @return channel_number
     */
    var channelNumber: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(channelNumber) {
            setFieldValue(3, 0, channelNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getData(): Array<Byte?>? {
        return getFieldByteValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of data
     */
    fun getNumData(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data field
     *
     * @param index of data
     * @return data
     */
    fun getData(index: Int): Byte? {
        return getFieldByteValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set data field
     *
     * @param index of data
     * @param data The new data value to be set
     */
    fun setData(index: Int, data: Byte?) {
        setFieldValue(4, index, data, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
