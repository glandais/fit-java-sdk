/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaConfigurationDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HsaConfigurationDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val DataFieldNum = 0
        const val DataSizeFieldNum = 1

        val hsaConfigurationDataMesg: Mesg = run {
            // hsa_configuration_data
            val hsaConfigurationDataMesg = Mesg("hsa_configuration_data", MesgNum.HSA_CONFIGURATION_DATA)
            hsaConfigurationDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaConfigurationDataMesg.addField(Field("data", DataFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            hsaConfigurationDataMesg.addField(Field("data_size", DataSizeFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            hsaConfigurationDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_CONFIGURATION_DATA))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Encoded configuration data
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Encoded configuration data
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getData(): Array<Byte?>? {
        return getFieldByteValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of data
     */
    fun getNumData(): Int {
        return getNumFieldValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data field
     * Comment: Encoded configuration data. Health SDK use only
     *
     * @param index of data
     * @return data
     */
    fun getData(index: Int): Byte? {
        return getFieldByteValue(0, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set data field
     * Comment: Encoded configuration data. Health SDK use only
     *
     * @param index of data
     * @param data The new data value to be set
     */
    fun setData(index: Int, data: Byte?) {
        setFieldValue(0, index, data, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data_size field
     * Comment: Size in bytes of data field
     *
     * @return data_size
     */
    fun getDataSize(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set data_size field
     * Comment: Size in bytes of data field
     *
     * @param dataSize The new dataSize value to be set
     */
    fun setDataSize(dataSize: Short?) {
        setFieldValue(1, 0, dataSize, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
