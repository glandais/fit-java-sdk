/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FileIdMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class FileIdMesg : Mesg {

    companion object {
        const val TypeFieldNum = 0
        const val ManufacturerFieldNum = 1
        const val ProductFieldNum = 2
        const val SerialNumberFieldNum = 3
        const val TimeCreatedFieldNum = 4
        const val NumberFieldNum = 5
        const val ProductNameFieldNum = 8

        val fileIdMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // file_id
            val fileIdMesg = Mesg("file_id", MesgNum.FILE_ID)
            fileIdMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.FILE))
            field_index++
            fileIdMesg.addField(Field("manufacturer", ManufacturerFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MANUFACTURER))
            field_index++
            fileIdMesg.addField(Field("product", ProductFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            subfield_index = 0
            fileIdMesg.fields[field_index].subFields.add(SubField("favero_product", 132, 1.0, 0.0, ""))
            fileIdMesg.fields[field_index].subFields[subfield_index].addMap(1, 263L)
            subfield_index++
            fileIdMesg.fields[field_index].subFields.add(SubField("garmin_product", 132, 1.0, 0.0, ""))
            fileIdMesg.fields[field_index].subFields[subfield_index].addMap(1, 1L)
            fileIdMesg.fields[field_index].subFields[subfield_index].addMap(1, 15L)
            fileIdMesg.fields[field_index].subFields[subfield_index].addMap(1, 13L)
            fileIdMesg.fields[field_index].subFields[subfield_index].addMap(1, 89L)
            subfield_index++
            field_index++
            fileIdMesg.addField(Field("serial_number", SerialNumberFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.UINT32Z))
            field_index++
            fileIdMesg.addField(Field("time_created", TimeCreatedFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            fileIdMesg.addField(Field("number", NumberFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            fileIdMesg.addField(Field("product_name", ProductNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            fileIdMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.FILE_ID))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get type field
     *
     * @return type
     */
    fun getType(): File? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return File.fromValue(value)
    }

    /**
     * Set type field
     *
     * @param type The new type value to be set
     */
    fun setType(type: File?) {
        setFieldValue(0, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get manufacturer field
     *
     * @return manufacturer
     */
    fun getManufacturer(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set manufacturer field
     *
     * @param manufacturer The new manufacturer value to be set
     */
    fun setManufacturer(manufacturer: Int?) {
        setFieldValue(1, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get product field
     *
     * @return product
     */
    fun getProduct(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set product field
     *
     * @param product The new product value to be set
     */
    fun setProduct(product: Int?) {
        setFieldValue(2, 0, product, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get favero_product field
     *
     * @return favero_product
     */
    fun getFaveroProduct(): Int? {
        return getFieldIntegerValue(2, 0, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
    }

    /**
     * Set favero_product field
     *
     * @param faveroProduct The new faveroProduct value to be set
     */
    fun setFaveroProduct(faveroProduct: Int?) {
        setFieldValue(2, 0, faveroProduct, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
    }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    fun getGarminProduct(): Int? {
        return getFieldIntegerValue(2, 0, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
    }

    /**
     * Set garmin_product field
     *
     * @param garminProduct The new garminProduct value to be set
     */
    fun setGarminProduct(garminProduct: Int?) {
        setFieldValue(2, 0, garminProduct, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
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
     * Get time_created field
     * Comment: Only set for files that are can be created/erased.
     *
     * @return time_created
     */
    fun getTimeCreated(): DateTime? {
        return timestampToDateTime(getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set time_created field
     * Comment: Only set for files that are can be created/erased.
     *
     * @param timeCreated The new timeCreated value to be set
     */
    fun setTimeCreated(timeCreated: DateTime?) {
        setFieldValue(4, 0, timeCreated?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get number field
     * Comment: Only set for files that are not created/erased.
     *
     * @return number
     */
    fun getNumber(): Int? {
        return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set number field
     * Comment: Only set for files that are not created/erased.
     *
     * @param number The new number value to be set
     */
    fun setNumber(number: Int?) {
        setFieldValue(5, 0, number, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get product_name field
     * Comment: Optional free form string to indicate the devices name or model
     *
     * @return product_name
     */
    fun getProductName(): String? {
        return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set product_name field
     * Comment: Optional free form string to indicate the devices name or model
     *
     * @param productName The new productName value to be set
     */
    fun setProductName(productName: String?) {
        setFieldValue(8, 0, productName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
