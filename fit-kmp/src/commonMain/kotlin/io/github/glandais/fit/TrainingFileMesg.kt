/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TrainingFileMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class TrainingFileMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TypeFieldNum = 0
        const val ManufacturerFieldNum = 1
        const val ProductFieldNum = 2
        const val SerialNumberFieldNum = 3
        const val TimeCreatedFieldNum = 4

        val trainingFileMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // training_file
            val trainingFileMesg = Mesg("training_file", MesgNum.TRAINING_FILE)
            trainingFileMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            trainingFileMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.FILE))
            field_index++
            trainingFileMesg.addField(Field("manufacturer", ManufacturerFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MANUFACTURER))
            field_index++
            trainingFileMesg.addField(Field("product", ProductFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            subfield_index = 0
            trainingFileMesg.fields[field_index].subFields.add(SubField("favero_product", 132, 1.0, 0.0, ""))
            trainingFileMesg.fields[field_index].subFields[subfield_index].addMap(1, 263L)
            subfield_index++
            trainingFileMesg.fields[field_index].subFields.add(SubField("garmin_product", 132, 1.0, 0.0, ""))
            trainingFileMesg.fields[field_index].subFields[subfield_index].addMap(1, 1L)
            trainingFileMesg.fields[field_index].subFields[subfield_index].addMap(1, 15L)
            trainingFileMesg.fields[field_index].subFields[subfield_index].addMap(1, 13L)
            trainingFileMesg.fields[field_index].subFields[subfield_index].addMap(1, 89L)
            subfield_index++
            field_index++
            trainingFileMesg.addField(Field("serial_number", SerialNumberFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.UINT32Z))
            field_index++
            trainingFileMesg.addField(Field("time_created", TimeCreatedFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            trainingFileMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.TRAINING_FILE))

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
            return getFieldIntegerValue(2, 0, Profile.SubFields.TRAINING_FILE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }
        set(faveroProduct) {
            setFieldValue(2, 0, faveroProduct, Profile.SubFields.TRAINING_FILE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    var garminProduct: Int?
        get() {
            return getFieldIntegerValue(2, 0, Profile.SubFields.TRAINING_FILE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
        }
        set(garminProduct) {
            setFieldValue(2, 0, garminProduct, Profile.SubFields.TRAINING_FILE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
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
}
