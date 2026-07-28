/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SlaveDeviceMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

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
    fun getManufacturer(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set manufacturer field
     *
     * @param manufacturer The new manufacturer value to be set
     */
    fun setManufacturer(manufacturer: Int?) {
        setFieldValue(0, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get product field
     *
     * @return product
     */
    fun getProduct(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set product field
     *
     * @param product The new product value to be set
     */
    fun setProduct(product: Int?) {
        setFieldValue(1, 0, product, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get favero_product field
     *
     * @return favero_product
     */
    fun getFaveroProduct(): Int? {
        return getFieldIntegerValue(1, 0, Profile.SubFields.SLAVE_DEVICE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
    }

    /**
     * Set favero_product field
     *
     * @param faveroProduct The new faveroProduct value to be set
     */
    fun setFaveroProduct(faveroProduct: Int?) {
        setFieldValue(1, 0, faveroProduct, Profile.SubFields.SLAVE_DEVICE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
    }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    fun getGarminProduct(): Int? {
        return getFieldIntegerValue(1, 0, Profile.SubFields.SLAVE_DEVICE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
    }

    /**
     * Set garmin_product field
     *
     * @param garminProduct The new garminProduct value to be set
     */
    fun setGarminProduct(garminProduct: Int?) {
        setFieldValue(1, 0, garminProduct, Profile.SubFields.SLAVE_DEVICE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
    }
}
