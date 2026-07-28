/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ExdDataConceptConfigurationMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ExdDataConceptConfigurationMesg : Mesg {

    companion object {
        const val ScreenIndexFieldNum = 0
        const val ConceptFieldFieldNum = 1
        const val FieldIdFieldNum = 2
        const val ConceptIndexFieldNum = 3
        const val DataPageFieldNum = 4
        const val ConceptKeyFieldNum = 5
        const val ScalingFieldNum = 6
        const val DataUnitsFieldNum = 8
        const val QualifierFieldNum = 9
        const val DescriptorFieldNum = 10
        const val IsSignedFieldNum = 11

        val exdDataConceptConfigurationMesg: Mesg = run {
            var field_index = 0
            // exd_data_concept_configuration
            val exdDataConceptConfigurationMesg = Mesg("exd_data_concept_configuration", MesgNum.EXD_DATA_CONCEPT_CONFIGURATION)
            exdDataConceptConfigurationMesg.addField(Field("screen_index", ScreenIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("concept_field", ConceptFieldFieldNum, 13, 1.0, 0.0, "", false, Profile.Type.BYTE))
            exdDataConceptConfigurationMesg.fields[field_index].components.add(FieldComponent(2, false, 4, 1.0, 0.0)) // field_id
            exdDataConceptConfigurationMesg.fields[field_index].components.add(FieldComponent(3, false, 4, 1.0, 0.0)) // concept_index
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("field_id", FieldIdFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("concept_index", ConceptIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("data_page", DataPageFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("concept_key", ConceptKeyFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("scaling", ScalingFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("data_units", DataUnitsFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EXD_DATA_UNITS))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("qualifier", QualifierFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EXD_QUALIFIERS))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("descriptor", DescriptorFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.EXD_DESCRIPTORS))
            field_index++
            exdDataConceptConfigurationMesg.addField(Field("is_signed", IsSignedFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            field_index++
            exdDataConceptConfigurationMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.EXD_DATA_CONCEPT_CONFIGURATION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get screen_index field
     *
     * @return screen_index
     */
    fun getScreenIndex(): Short? {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set screen_index field
     *
     * @param screenIndex The new screenIndex value to be set
     */
    fun setScreenIndex(screenIndex: Short?) {
        setFieldValue(0, 0, screenIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get concept_field field
     *
     * @return concept_field
     */
    fun getConceptField(): Byte? {
        return getFieldByteValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set concept_field field
     *
     * @param conceptField The new conceptField value to be set
     */
    fun setConceptField(conceptField: Byte?) {
        setFieldValue(1, 0, conceptField, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get field_id field
     *
     * @return field_id
     */
    fun getFieldId(): Short? {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set field_id field
     *
     * @param fieldId The new fieldId value to be set
     */
    fun setFieldId(fieldId: Short?) {
        setFieldValue(2, 0, fieldId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get concept_index field
     *
     * @return concept_index
     */
    fun getConceptIndex(): Short? {
        return getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set concept_index field
     *
     * @param conceptIndex The new conceptIndex value to be set
     */
    fun setConceptIndex(conceptIndex: Short?) {
        setFieldValue(3, 0, conceptIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data_page field
     *
     * @return data_page
     */
    fun getDataPage(): Short? {
        return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set data_page field
     *
     * @param dataPage The new dataPage value to be set
     */
    fun setDataPage(dataPage: Short?) {
        setFieldValue(4, 0, dataPage, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get concept_key field
     *
     * @return concept_key
     */
    fun getConceptKey(): Short? {
        return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set concept_key field
     *
     * @param conceptKey The new conceptKey value to be set
     */
    fun setConceptKey(conceptKey: Short?) {
        setFieldValue(5, 0, conceptKey, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get scaling field
     *
     * @return scaling
     */
    fun getScaling(): Short? {
        return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set scaling field
     *
     * @param scaling The new scaling value to be set
     */
    fun setScaling(scaling: Short?) {
        setFieldValue(6, 0, scaling, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get data_units field
     *
     * @return data_units
     */
    fun getDataUnits(): ExdDataUnits? {
        val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return ExdDataUnits.fromValue(value)
    }

    /**
     * Set data_units field
     *
     * @param dataUnits The new dataUnits value to be set
     */
    fun setDataUnits(dataUnits: ExdDataUnits?) {
        setFieldValue(8, 0, dataUnits?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get qualifier field
     *
     * @return qualifier
     */
    fun getQualifier(): ExdQualifiers? {
        val value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return ExdQualifiers.fromValue(value)
    }

    /**
     * Set qualifier field
     *
     * @param qualifier The new qualifier value to be set
     */
    fun setQualifier(qualifier: ExdQualifiers?) {
        setFieldValue(9, 0, qualifier?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get descriptor field
     *
     * @return descriptor
     */
    fun getDescriptor(): ExdDescriptors? {
        val value = getFieldShortValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return ExdDescriptors.fromValue(value)
    }

    /**
     * Set descriptor field
     *
     * @param descriptor The new descriptor value to be set
     */
    fun setDescriptor(descriptor: ExdDescriptors?) {
        setFieldValue(10, 0, descriptor?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get is_signed field
     *
     * @return is_signed
     */
    fun getIsSigned(): Bool? {
        val value = getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set is_signed field
     *
     * @param isSigned The new isSigned value to be set
     */
    fun setIsSigned(isSigned: Bool?) {
        setFieldValue(11, 0, isSigned?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
