/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ScheduleMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ScheduleMesg : Mesg {

    companion object {
        const val ManufacturerFieldNum = 0
        const val ProductFieldNum = 1
        const val SerialNumberFieldNum = 2
        const val TimeCreatedFieldNum = 3
        const val CompletedFieldNum = 4
        const val TypeFieldNum = 5
        const val ScheduledTimeFieldNum = 6

        val scheduleMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // schedule
            val scheduleMesg = Mesg("schedule", MesgNum.SCHEDULE)
            scheduleMesg.addField(Field("manufacturer", ManufacturerFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MANUFACTURER))
            field_index++
            scheduleMesg.addField(Field("product", ProductFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            subfield_index = 0
            scheduleMesg.fields[field_index].subFields.add(SubField("favero_product", 132, 1.0, 0.0, ""))
            scheduleMesg.fields[field_index].subFields[subfield_index].addMap(0, 263L)
            subfield_index++
            scheduleMesg.fields[field_index].subFields.add(SubField("garmin_product", 132, 1.0, 0.0, ""))
            scheduleMesg.fields[field_index].subFields[subfield_index].addMap(0, 1L)
            scheduleMesg.fields[field_index].subFields[subfield_index].addMap(0, 15L)
            scheduleMesg.fields[field_index].subFields[subfield_index].addMap(0, 13L)
            scheduleMesg.fields[field_index].subFields[subfield_index].addMap(0, 89L)
            subfield_index++
            field_index++
            scheduleMesg.addField(Field("serial_number", SerialNumberFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.UINT32Z))
            field_index++
            scheduleMesg.addField(Field("time_created", TimeCreatedFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            field_index++
            scheduleMesg.addField(Field("completed", CompletedFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            field_index++
            scheduleMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SCHEDULE))
            field_index++
            scheduleMesg.addField(Field("scheduled_time", ScheduledTimeFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.LOCAL_DATE_TIME))
            field_index++
            scheduleMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SCHEDULE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get manufacturer field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @return manufacturer
     */
    fun getManufacturer(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set manufacturer field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @param manufacturer The new manufacturer value to be set
     */
    fun setManufacturer(manufacturer: Int?) {
        setFieldValue(0, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get product field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @return product
     */
    fun getProduct(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set product field
     * Comment: Corresponds to file_id of scheduled workout / course.
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
        return getFieldIntegerValue(1, 0, Profile.SubFields.SCHEDULE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
    }

    /**
     * Set favero_product field
     *
     * @param faveroProduct The new faveroProduct value to be set
     */
    fun setFaveroProduct(faveroProduct: Int?) {
        setFieldValue(1, 0, faveroProduct, Profile.SubFields.SCHEDULE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
    }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    fun getGarminProduct(): Int? {
        return getFieldIntegerValue(1, 0, Profile.SubFields.SCHEDULE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
    }

    /**
     * Set garmin_product field
     *
     * @param garminProduct The new garminProduct value to be set
     */
    fun setGarminProduct(garminProduct: Int?) {
        setFieldValue(1, 0, garminProduct, Profile.SubFields.SCHEDULE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
    }

    /**
     * Get serial_number field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @return serial_number
     */
    fun getSerialNumber(): Long? {
        return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set serial_number field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @param serialNumber The new serialNumber value to be set
     */
    fun setSerialNumber(serialNumber: Long?) {
        setFieldValue(2, 0, serialNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time_created field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @return time_created
     */
    fun getTimeCreated(): DateTime? {
        return timestampToDateTime(getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set time_created field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @param timeCreated The new timeCreated value to be set
     */
    fun setTimeCreated(timeCreated: DateTime?) {
        setFieldValue(3, 0, timeCreated?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get completed field
     * Comment: TRUE if this activity has been started
     *
     * @return completed
     */
    fun getCompleted(): Bool? {
        val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set completed field
     * Comment: TRUE if this activity has been started
     *
     * @param completed The new completed value to be set
     */
    fun setCompleted(completed: Bool?) {
        setFieldValue(4, 0, completed?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get type field
     *
     * @return type
     */
    fun getType(): Schedule? {
        val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Schedule.fromValue(value)
    }

    /**
     * Set type field
     *
     * @param type The new type value to be set
     */
    fun setType(type: Schedule?) {
        setFieldValue(5, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get scheduled_time field
     *
     * @return scheduled_time
     */
    fun getScheduledTime(): Long? {
        return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set scheduled_time field
     *
     * @param scheduledTime The new scheduledTime value to be set
     */
    fun setScheduledTime(scheduledTime: Long?) {
        setFieldValue(6, 0, scheduledTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
