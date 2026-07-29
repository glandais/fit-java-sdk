/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ExdDataFieldConfigurationMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ExdDataFieldConfigurationMesg : Mesg {

    companion object {
        const val ScreenIndexFieldNum = 0
        const val ConceptFieldFieldNum = 1
        const val FieldIdFieldNum = 2
        const val ConceptCountFieldNum = 3
        const val DisplayTypeFieldNum = 4
        const val TitleFieldNum = 5

        val exdDataFieldConfigurationMesg: Mesg = run {
            var field_index = 0
            // exd_data_field_configuration
            val exdDataFieldConfigurationMesg = Mesg("exd_data_field_configuration", MesgNum.EXD_DATA_FIELD_CONFIGURATION)
            exdDataFieldConfigurationMesg.addField(Field("screen_index", ScreenIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataFieldConfigurationMesg.addField(Field("concept_field", ConceptFieldFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            exdDataFieldConfigurationMesg.fields[field_index].components.add(FieldComponent(2, false, 4, 1.0, 0.0)) // field_id
            exdDataFieldConfigurationMesg.fields[field_index].components.add(FieldComponent(3, false, 4, 1.0, 0.0)) // concept_count
            field_index++
            exdDataFieldConfigurationMesg.addField(Field("field_id", FieldIdFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataFieldConfigurationMesg.addField(Field("concept_count", ConceptCountFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataFieldConfigurationMesg.addField(Field("display_type", DisplayTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EXD_DISPLAY_TYPE))
            field_index++
            exdDataFieldConfigurationMesg.addField(Field("title", TitleFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            exdDataFieldConfigurationMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.EXD_DATA_FIELD_CONFIGURATION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get screen_index field
     *
     * @return screen_index
     */
    var screenIndex: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(screenIndex) {
            setFieldValue(0, 0, screenIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get concept_field field
     *
     * @return concept_field
     */
    var conceptField: Byte?
        get() {
            return getFieldByteValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(conceptField) {
            setFieldValue(1, 0, conceptField, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get field_id field
     *
     * @return field_id
     */
    var fieldId: Short?
        get() {
            return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fieldId) {
            setFieldValue(2, 0, fieldId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get concept_count field
     *
     * @return concept_count
     */
    var conceptCount: Short?
        get() {
            return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(conceptCount) {
            setFieldValue(3, 0, conceptCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get display_type field
     *
     * @return display_type
     */
    var displayType: ExdDisplayType?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ExdDisplayType.fromValue(value)
        }
        set(displayType) {
            setFieldValue(4, 0, displayType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getTitle(): Array<String?>? {
        return getFieldStringValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of title
     */
    fun getNumTitle(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get title field
     *
     * @param index of title
     * @return title
     */
    fun getTitle(index: Int): String? {
        return getFieldStringValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set title field
     *
     * @param index of title
     * @param title The new title value to be set
     */
    fun setTitle(index: Int, title: String?) {
        setFieldValue(5, index, title, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
