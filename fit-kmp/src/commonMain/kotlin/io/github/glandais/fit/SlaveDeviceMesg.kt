/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SlaveDeviceMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class SlaveDeviceMesg : Mesg {

    companion object {
        const val ManufacturerFieldNum = 0
        const val ProductFieldNum = 1

        val slaveDeviceMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // slave_device
            val slaveDeviceMesg = Mesg("slave_device", MesgNum.SLAVE_DEVICE)
            slaveDeviceMesg.addField(Field("manufacturer", ManufacturerFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MANUFACTURER))
            field_index++
            slaveDeviceMesg.addField(Field("product", ProductFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            subfield_index = 0
            slaveDeviceMesg.fields[field_index].subFields.add(SubField("favero_product", 132, 1.0, 0.0, ""))
            slaveDeviceMesg.fields[field_index].subFields[subfield_index].addMap(0, 263L)
            subfield_index++
            slaveDeviceMesg.fields[field_index].subFields.add(SubField("garmin_product", 132, 1.0, 0.0, ""))
            slaveDeviceMesg.fields[field_index].subFields[subfield_index].addMap(0, 1L)
            slaveDeviceMesg.fields[field_index].subFields[subfield_index].addMap(0, 15L)
            slaveDeviceMesg.fields[field_index].subFields[subfield_index].addMap(0, 13L)
            slaveDeviceMesg.fields[field_index].subFields[subfield_index].addMap(0, 89L)
            subfield_index++
            field_index++
            slaveDeviceMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SLAVE_DEVICE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get manufacturer field
     *
     * @return manufacturer
     */
    var manufacturer: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(manufacturer) {
            setFieldValue(0, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get product field
     *
     * @return product
     */
    var product: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(product) {
            setFieldValue(1, 0, product, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get favero_product field
     *
     * @return favero_product
     */
    var faveroProduct: Int?
        get() {
            return getFieldIntegerValue(1, 0, Profile.SubFields.SLAVE_DEVICE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }
        set(faveroProduct) {
            setFieldValue(1, 0, faveroProduct, Profile.SubFields.SLAVE_DEVICE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    var garminProduct: Int?
        get() {
            return getFieldIntegerValue(1, 0, Profile.SubFields.SLAVE_DEVICE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
        }
        set(garminProduct) {
            setFieldValue(1, 0, garminProduct, Profile.SubFields.SLAVE_DEVICE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
        }
}
