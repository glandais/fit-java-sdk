/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DeveloperDataIdMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class DeveloperDataIdMesg : Mesg {

    companion object {
        const val DeveloperIdFieldNum = 0
        const val ApplicationIdFieldNum = 1
        const val ManufacturerIdFieldNum = 2
        const val DeveloperDataIndexFieldNum = 3
        const val ApplicationVersionFieldNum = 4

        val developerDataIdMesg: Mesg = run {
            // developer_data_id
            val developerDataIdMesg = Mesg("developer_data_id", MesgNum.DEVELOPER_DATA_ID)
            developerDataIdMesg.addField(Field("developer_id", DeveloperIdFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            developerDataIdMesg.addField(Field("application_id", ApplicationIdFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            developerDataIdMesg.addField(Field("manufacturer_id", ManufacturerIdFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MANUFACTURER))
            developerDataIdMesg.addField(Field("developer_data_index", DeveloperDataIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            developerDataIdMesg.addField(Field("application_version", ApplicationVersionFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            developerDataIdMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.DEVELOPER_DATA_ID))

    constructor(mesg: Mesg?) : super(mesg)

    fun getDeveloperId(): Array<Byte?>? {
        return getFieldByteValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of developer_id
     */
    fun getNumDeveloperId(): Int {
        return getNumFieldValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get developer_id field
     *
     * @param index of developer_id
     * @return developer_id
     */
    fun getDeveloperId(index: Int): Byte? {
        return getFieldByteValue(0, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set developer_id field
     *
     * @param index of developer_id
     * @param developerId The new developerId value to be set
     */
    fun setDeveloperId(index: Int, developerId: Byte?) {
        setFieldValue(0, index, developerId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getApplicationId(): Array<Byte?>? {
        return getFieldByteValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of application_id
     */
    fun getNumApplicationId(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get application_id field
     *
     * @param index of application_id
     * @return application_id
     */
    fun getApplicationId(index: Int): Byte? {
        return getFieldByteValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set application_id field
     *
     * @param index of application_id
     * @param applicationId The new applicationId value to be set
     */
    fun setApplicationId(index: Int, applicationId: Byte?) {
        setFieldValue(1, index, applicationId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get manufacturer_id field
     *
     * @return manufacturer_id
     */
    var manufacturerId: Int?
        get() {
            return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(manufacturerId) {
            setFieldValue(2, 0, manufacturerId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get developer_data_index field
     *
     * @return developer_data_index
     */
    var developerDataIndex: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(developerDataIndex) {
            setFieldValue(3, 0, developerDataIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get application_version field
     *
     * @return application_version
     */
    var applicationVersion: Long?
        get() {
            return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(applicationVersion) {
            setFieldValue(4, 0, applicationVersion, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
