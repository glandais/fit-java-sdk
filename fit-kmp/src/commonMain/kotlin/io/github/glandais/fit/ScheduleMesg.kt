/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ScheduleMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var manufacturer: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(manufacturer) {
            setFieldValue(0, 0, manufacturer, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get product field
     * Comment: Corresponds to file_id of scheduled workout / course.
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
            return getFieldIntegerValue(1, 0, Profile.SubFields.SCHEDULE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }
        set(faveroProduct) {
            setFieldValue(1, 0, faveroProduct, Profile.SubFields.SCHEDULE_MESG_PRODUCT_FIELD_FAVERO_PRODUCT)
        }

    /**
     * Get garmin_product field
     *
     * @return garmin_product
     */
    var garminProduct: Int?
        get() {
            return getFieldIntegerValue(1, 0, Profile.SubFields.SCHEDULE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
        }
        set(garminProduct) {
            setFieldValue(1, 0, garminProduct, Profile.SubFields.SCHEDULE_MESG_PRODUCT_FIELD_GARMIN_PRODUCT)
        }

    /**
     * Get serial_number field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @return serial_number
     */
    var serialNumber: Long?
        get() {
            return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(serialNumber) {
            setFieldValue(2, 0, serialNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get time_created field
     * Comment: Corresponds to file_id of scheduled workout / course.
     *
     * @return time_created
     */
    var timeCreated: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timeCreated) {
            setFieldValue(3, 0, timeCreated?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get completed field
     * Comment: TRUE if this activity has been started
     *
     * @return completed
     */
    var completed: Bool?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(completed) {
            setFieldValue(4, 0, completed?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get type field
     *
     * @return type
     */
    var type: Schedule?
        get() {
            val value = getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Schedule.fromValue(value)
        }
        set(type) {
            setFieldValue(5, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get scheduled_time field
     *
     * @return scheduled_time
     */
    var scheduledTime: Long?
        get() {
            return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(scheduledTime) {
            setFieldValue(6, 0, scheduledTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
