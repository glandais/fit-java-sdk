/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FieldDescriptionMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var developerDataIndex: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(developerDataIndex) {
            setFieldValue(0, 0, developerDataIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get field_definition_number field
     *
     * @return field_definition_number
     */
    var fieldDefinitionNumber: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fieldDefinitionNumber) {
            setFieldValue(1, 0, fieldDefinitionNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get fit_base_type_id field
     *
     * @return fit_base_type_id
     */
    var fitBaseTypeId: Short?
        get() {
            return getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fitBaseTypeId) {
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
    var array: Short?
        get() {
            return getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(array) {
            setFieldValue(4, 0, array, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get components field
     *
     * @return components
     */
    var components: String?
        get() {
            return getFieldStringValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(components) {
            setFieldValue(5, 0, components, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get scale field
     *
     * @return scale
     */
    var scale: Short?
        get() {
            return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(scale) {
            setFieldValue(6, 0, scale, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get offset field
     *
     * @return offset
     */
    var offset: Byte?
        get() {
            return getFieldByteValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(offset) {
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
    var bits: String?
        get() {
            return getFieldStringValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bits) {
            setFieldValue(9, 0, bits, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get accumulate field
     *
     * @return accumulate
     */
    var accumulate: String?
        get() {
            return getFieldStringValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(accumulate) {
            setFieldValue(10, 0, accumulate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get fit_base_unit_id field
     *
     * @return fit_base_unit_id
     */
    var fitBaseUnitId: Int?
        get() {
            return getFieldIntegerValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fitBaseUnitId) {
            setFieldValue(13, 0, fitBaseUnitId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get native_mesg_num field
     *
     * @return native_mesg_num
     */
    var nativeMesgNum: Int?
        get() {
            return getFieldIntegerValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(nativeMesgNum) {
            setFieldValue(14, 0, nativeMesgNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get native_field_num field
     *
     * @return native_field_num
     */
    var nativeFieldNum: Short?
        get() {
            return getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(nativeFieldNum) {
            setFieldValue(15, 0, nativeFieldNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
