/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FieldDescriptionMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class FieldDescriptionMesg : Mesg {

    companion object {
        const val DeveloperDataIndexFieldNum = 0
        const val FieldDefinitionNumberFieldNum = 1
        const val FitBaseTypeIdFieldNum = 2
        const val FieldNameFieldNum = 3
        const val ArrayFieldNum = 4
        const val ComponentsFieldNum = 5
        const val ScaleFieldNum = 6
        const val OffsetFieldNum = 7
        const val UnitsFieldNum = 8
        const val BitsFieldNum = 9
        const val AccumulateFieldNum = 10
        const val FitBaseUnitIdFieldNum = 13
        const val NativeMesgNumFieldNum = 14
        const val NativeFieldNumFieldNum = 15

        val fieldDescriptionMesg: Mesg = run {
            // field_description
            val fieldDescriptionMesg = Mesg("field_description", MesgNum.FIELD_DESCRIPTION)
            fieldDescriptionMesg.addField(Field("developer_data_index", DeveloperDataIndexFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            fieldDescriptionMesg.addField(Field("field_definition_number", FieldDefinitionNumberFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            fieldDescriptionMesg.addField(Field("fit_base_type_id", FitBaseTypeIdFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.FIT_BASE_TYPE))
            fieldDescriptionMesg.addField(Field("field_name", FieldNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            fieldDescriptionMesg.addField(Field("array", ArrayFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            fieldDescriptionMesg.addField(Field("components", ComponentsFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            fieldDescriptionMesg.addField(Field("scale", ScaleFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            fieldDescriptionMesg.addField(Field("offset", OffsetFieldNum, 1, 1.0, 0.0, "", false, Profile.Type.SINT8))
            fieldDescriptionMesg.addField(Field("units", UnitsFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            fieldDescriptionMesg.addField(Field("bits", BitsFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            fieldDescriptionMesg.addField(Field("accumulate", AccumulateFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            fieldDescriptionMesg.addField(Field("fit_base_unit_id", FitBaseUnitIdFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.FIT_BASE_UNIT))
            fieldDescriptionMesg.addField(Field("native_mesg_num", NativeMesgNumFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESG_NUM))
            fieldDescriptionMesg.addField(Field("native_field_num", NativeFieldNumFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            fieldDescriptionMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.FIELD_DESCRIPTION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get developer_data_index field
     *
     * @return developer_data_index
     */
    fun getDeveloperDataIndex(): Short? {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set developer_data_index field
     *
     * @param developerDataIndex The new developerDataIndex value to be set
     */
    fun setDeveloperDataIndex(developerDataIndex: Short?) {
        setFieldValue(0, 0, developerDataIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get field_definition_number field
     *
     * @return field_definition_number
     */
    fun getFieldDefinitionNumber(): Short? {
        return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set field_definition_number field
     *
     * @param fieldDefinitionNumber The new fieldDefinitionNumber value to be set
     */
    fun setFieldDefinitionNumber(fieldDefinitionNumber: Short?) {
        setFieldValue(1, 0, fieldDefinitionNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get fit_base_type_id field
     *
     * @return fit_base_type_id
     */
    fun getFitBaseTypeId(): Short? {
        return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set fit_base_type_id field
     *
     * @param fitBaseTypeId The new fitBaseTypeId value to be set
     */
    fun setFitBaseTypeId(fitBaseTypeId: Short?) {
        setFieldValue(2, 0, fitBaseTypeId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getFieldName(): Array<String?>? {
        return getFieldStringValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of field_name
     */
    fun getNumFieldName(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get field_name field
     *
     * @param index of field_name
     * @return field_name
     */
    fun getFieldName(index: Int): String? {
        return getFieldStringValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set field_name field
     *
     * @param index of field_name
     * @param fieldName The new fieldName value to be set
     */
    fun setFieldName(index: Int, fieldName: String?) {
        setFieldValue(3, index, fieldName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get array field
     *
     * @return array
     */
    fun getArray(): Short? {
        return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set array field
     *
     * @param array The new array value to be set
     */
    fun setArray(array: Short?) {
        setFieldValue(4, 0, array, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get components field
     *
     * @return components
     */
    fun getComponents(): String? {
        return getFieldStringValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set components field
     *
     * @param components The new components value to be set
     */
    fun setComponents(components: String?) {
        setFieldValue(5, 0, components, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get scale field
     *
     * @return scale
     */
    fun getScale(): Short? {
        return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set scale field
     *
     * @param scale The new scale value to be set
     */
    fun setScale(scale: Short?) {
        setFieldValue(6, 0, scale, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get offset field
     *
     * @return offset
     */
    fun getOffset(): Byte? {
        return getFieldByteValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set offset field
     *
     * @param offset The new offset value to be set
     */
    fun setOffset(offset: Byte?) {
        setFieldValue(7, 0, offset, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getUnits(): Array<String?>? {
        return getFieldStringValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of units
     */
    fun getNumUnits(): Int {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get units field
     *
     * @param index of units
     * @return units
     */
    fun getUnits(index: Int): String? {
        return getFieldStringValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set units field
     *
     * @param index of units
     * @param units The new units value to be set
     */
    fun setUnits(index: Int, units: String?) {
        setFieldValue(8, index, units, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get bits field
     *
     * @return bits
     */
    fun getBits(): String? {
        return getFieldStringValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set bits field
     *
     * @param bits The new bits value to be set
     */
    fun setBits(bits: String?) {
        setFieldValue(9, 0, bits, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accumulate field
     *
     * @return accumulate
     */
    fun getAccumulate(): String? {
        return getFieldStringValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accumulate field
     *
     * @param accumulate The new accumulate value to be set
     */
    fun setAccumulate(accumulate: String?) {
        setFieldValue(10, 0, accumulate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get fit_base_unit_id field
     *
     * @return fit_base_unit_id
     */
    fun getFitBaseUnitId(): Int? {
        return getFieldIntegerValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set fit_base_unit_id field
     *
     * @param fitBaseUnitId The new fitBaseUnitId value to be set
     */
    fun setFitBaseUnitId(fitBaseUnitId: Int?) {
        setFieldValue(13, 0, fitBaseUnitId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get native_mesg_num field
     *
     * @return native_mesg_num
     */
    fun getNativeMesgNum(): Int? {
        return getFieldIntegerValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set native_mesg_num field
     *
     * @param nativeMesgNum The new nativeMesgNum value to be set
     */
    fun setNativeMesgNum(nativeMesgNum: Int?) {
        setFieldValue(14, 0, nativeMesgNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get native_field_num field
     *
     * @return native_field_num
     */
    fun getNativeFieldNum(): Short? {
        return getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set native_field_num field
     *
     * @param nativeFieldNum The new nativeFieldNum value to be set
     */
    fun setNativeFieldNum(nativeFieldNum: Short?) {
        setFieldValue(15, 0, nativeFieldNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
