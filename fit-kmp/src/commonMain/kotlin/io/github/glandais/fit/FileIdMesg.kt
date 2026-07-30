/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FileIdMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var type: File?
        get() {
            val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return File.fromValue(value)
        }
        set(type) {
            setFieldValue(0, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get manufacturer field
     *
     * @return manufacturer
     */
    var manufacturer: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(manufacturer) {
            setFieldValue(1, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get product field
     *
     * @return product
     */
    var product: Int?
        get() {
            return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(product) {
            setFieldValue(2, 0, product, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get favero_product field
     *
     * @return favero_product
     */
    var faveroProduct: Int?
        get() {
            return getFieldIntegerValue(2, 0, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }
        set(faveroProduct) {
            setFieldValue(2, 0, faveroProduct, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    var garminProduct: Int?
        get() {
            return getFieldIntegerValue(2, 0, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
        }
        set(garminProduct) {
            setFieldValue(2, 0, garminProduct, Profile.SubFields.FILE_ID_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
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
     * Get time_created field
     * Comment: Only set for files that are can be created/erased.
     *
     * @return time_created
     */
    var timeCreated: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timeCreated) {
            setFieldValue(4, 0, timeCreated?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get number field
     * Comment: Only set for files that are not created/erased.
     *
     * @return number
     */
    var number: Int?
        get() {
            return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(number) {
            setFieldValue(5, 0, number, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get product_name field
     * Comment: Optional free form string to indicate the devices name or model
     *
     * @return product_name
     */
    var productName: String?
        get() {
            return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(productName) {
            setFieldValue(8, 0, productName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
