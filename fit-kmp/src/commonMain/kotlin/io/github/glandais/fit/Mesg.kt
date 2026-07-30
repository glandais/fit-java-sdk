// Hand-written multiplatform port of Mesg.java — keep in sync (see overrides/hashes.json).
//
// Conversion notes (DESIGN.md):
// - getFieldBigIntegerValue* renamed getFieldULongValue* (returns ULong?/Array<ULong?>?).
// - getFieldBigDecimalValue* kept by name but returns Double?/Array<Double?>? (BigDecimal -> Double).
// - Protected Java fields (name, num, localNum, fields, developerFields, systemTimeOffset) are
//   internal: they are accessed cross-class in the same package (MesgDefinition, Decode,
//   encoders, generated mesg companions).
// - java.io replaced by the common stream shims (Streams.kt).
package io.github.glandais.fit

open class Mesg {
    // Identité du message (« record », « course »…). Stockée à part de la propriété
    // publique `name` : certains mesgs générés (CourseMesg, SportMesg…) ont un *champ FIT*
    // nommé `name` et redéfinissent la propriété ; sans ce découplage, écrire
    // `CourseMesg().name = "x"` renommerait silencieusement le message au lieu
    // d'alimenter le champ.
    internal var mesgName: String = "unknown"
    internal var num: Int = MesgNum.INVALID
    private var _localNum: Int = 0

    // Propriété publique (et non getLocalNum()/setLocalNum()) : sur JVM une paire
    // de fonctions entrerait en collision de signature avec l'accesseur généré.
    var localNum: Int
        get() = _localNum
        set(value) {
            if (value >= Fit.MAX_LOCAL_MESGS) {
                throw FitRuntimeException("Invalid local message number " + value
                        + ".  Local message number must be < " + Fit.MAX_LOCAL_MESGS + ".")
            }
            _localNum = value
        }
    internal val fields: ArrayList<Field> = ArrayList()
    internal val developerFields: ArrayList<DeveloperField> = ArrayList()
    internal var systemTimeOffset: Long = 0
    private var decoderMesgIndex: Int = 0

    constructor(mesg: Mesg?) {
        if (mesg == null) {
            return
        }

        this.mesgName = mesg.mesgName
        this.num = mesg.num
        this.localNum = mesg.localNum
        this.systemTimeOffset = mesg.systemTimeOffset
        this.decoderMesgIndex = mesg.decoderMesgIndex

        for (field in mesg.fields) {
            if (field.getNumValues() > 0) {
                this.fields.add(Field(field))
            }
        }

        for (field in mesg.developerFields) {
            if (field.getNumValues() > 0) {
                this.developerFields.add(DeveloperField(field))
            }
        }
    }

    // protected in Java; internal so the generated mesg companions can call it (DESIGN.md §4.8).
    internal constructor(name: String, num: Int) {
        this.mesgName = name
        this.num = num
    }

    /**
     * Removes all fields from this message that have been generated through
     * component expansion while decoding the source .FIT file.
     */
    fun removeExpandedFields() {
        val fieldsToRemove = ArrayList<Field>()

        for (field in fields) {
            if (field.getIsExpanded()) {
                fieldsToRemove.add(field)
            }
        }

        fields.removeAll(fieldsToRemove)
    }

    fun write(out: OutputStream) {
        write(out, null)
    }

    fun write(out: OutputStream, mesgDef: MesgDefinition?) {
        try {
            val headerByte = localNum and Fit.HDR_TYPE_MASK

            DataOutputStream(out).writeByte(headerByte) // Message record header.
        } catch (e: IOException) {
            throw FitRuntimeException(e)
        }

        val def = mesgDef ?: MesgDefinition(this)

        for (fieldDef in def.fields) {
            var field = this.getField(fieldDef.num)

            if (field == null) {
                field = Factory.createField(num, fieldDef.num)
            }

            field.write(out, fieldDef)
        }

        for (fieldDef in def.developerFields) {
            var field = getDeveloperField(fieldDef.getDeveloperDataIndex(), fieldDef.getNum().toInt())

            if (field == null) {
                // Get Default from Definition
                field = fieldDef.getDefaultField()
            }

            field.write(out, fieldDef)
        }
    }

    // `open val` et non `fun getName()` : les mesgs générés ayant un champ FIT "name"
    // (CourseMesg, SportMesg…) la redéfinissent en `override var` — Kotlin autorise
    // d'élargir un `val` en `var`, l'inverse d'une paire de fonctions qui entrerait en
    // collision de signature sur JVM.
    open val name: String?
        get() = mesgName

    fun getNum(): Int {
        return num
    }

    fun hasField(num: Int): Boolean {
        for (i in 0 until fields.size) {
            if (fields[i].num == num) {
                return true
            }
        }

        return false
    }

    fun addField(field: Field) {
        fields.add(field)
    }

    fun addDeveloperField(field: DeveloperField) {
        for (i in 0 until developerFields.size) {
            val fieldToCompare = developerFields[i]
            if ((fieldToCompare.getNum() == field.getNum()) &&
                (fieldToCompare.getDeveloperDataIndex() == field.getDeveloperDataIndex())) {
                developerFields[i] = field
                return
            }
        }

        developerFields.add(field)
    }

    fun setField(field: Field) {
        for (i in 0 until fields.size) {
            if (fields[i].num == field.num) {
                fields[i] = field
                return
            }
        }

        fields.add(field)
    }

    fun getNumFields(): Int {
        return fields.size
    }

    private fun getDeveloperField(developerIndex: Short, num: Int): DeveloperField? {
        for (field in developerFields) {
            if ((field.getDeveloperDataIndex() == developerIndex) &&
                (field.getNum() == num)) {
                return field
            }
        }

        return null
    }

    fun getField(num: Int): Field? {
        for (i in 0 until fields.size) {
            if (fields[i].num == num) {
                return fields[i]
            }
        }

        return null
    }

    fun getField(name: String?): Field? {
        return getField(name, true)
    }

    fun getField(name: String?, checkMesgSupportForSubFields: Boolean): Field? {
        for (i in 0 until fields.size) {
            if (fields[i].name == name) {
                return fields[i]
            }

            for (j in 0 until fields[i].subFields.size) {
                if ((fields[i].subFields[j].name == name) && (!checkMesgSupportForSubFields || (fields[i].subFields[j].canMesgSupport(this)))) {
                    return fields[i]
                }
            }
        }

        return null
    }

    /**
     * Returns the active subfield index of a given field for this message.
     *
     * @param num The field number for the field to be checked
     * @return the subfield index used for the field in this message
     */
    fun getActiveSubFieldIndex(num: Int): Int {
        val testField: Field? = Factory.createField(this.num, num)

        if (testField == null) {
            return Fit.SUBFIELD_INDEX_MAIN_FIELD
        }

        for (i in 0 until testField.subFields.size) {
            if (testField.subFields[i].canMesgSupport(this)) {
                return i
            }
        }

        return Fit.SUBFIELD_INDEX_MAIN_FIELD
    }

    /**
     * Returns the active subfield name of a given field for this message.
     *
     * @param num The field number for the field to be checked
     * @return the subfield name used for the field in this message
     */
    fun getActiveSubFieldName(num: Int): String {
        val testField: Field? = Factory.createField(this.num, num)

        if (testField == null) {
            return Fit.SUBFIELD_NAME_MAIN_FIELD
        }

        for (i in 0 until testField.subFields.size) {
            if (testField.subFields[i].canMesgSupport(this)) {
                return testField.subFields[i].name
            }
        }

        return Fit.SUBFIELD_NAME_MAIN_FIELD
    }

    fun getNumFieldValues(num: Int): Int {
        return getNumFieldValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getNumFieldValues(num: Int, subFieldIndex: Int): Int {
        val field = getField(num) ?: return 0

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getNumValues()
        }

        val subField = field.getSubField(subFieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getNumValues()
        } else {
            return 0
        }
    }

    fun getNumFieldValues(num: Int, subFieldName: String?): Int {
        val field = getField(num) ?: return 0

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getNumValues()
        } else {
            return 0
        }
    }

    fun getNumFieldValues(name: String?): Int {
        val field = getField(name, false) ?: return 0

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getNumValues()
        } else {
            return 0
        }
    }

    fun getFieldValue(num: Int): Any? {
        return getFieldValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldValue(num: Int, fieldArrayIndex: Int): Any? {
        return getFieldValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): Any? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): Any? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldValue(name: String?): Any? {
        return getFieldValue(name, 0)
    }

    fun getFieldValue(name: String?, fieldArrayIndex: Int): Any? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    fun getIsFieldAccumulated(num: Int): Boolean {
        val field = getField(num)
        if (field != null) {
            return field.getIsAccumulated()
        }
        return false
    }

    fun setFieldValue(num: Int, value: Any?) {
        setFieldValue(num, 0, value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun setFieldValue(num: Int, fieldArrayIndex: Int, value: Any?) {
        setFieldValue(num, fieldArrayIndex, value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun setFieldValue(num: Int, fieldArrayIndex: Int, value: Any?, subFieldIndex: Int) {
        var subFieldIdx = subFieldIndex
        if (subFieldIdx == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            subFieldIdx = getActiveSubFieldIndex(num)
        }

        var field = getField(num)

        if (field == null) {
            field = Factory.createField(this.num, num)
            addField(field)
        }

        field.setValue(fieldArrayIndex, value, subFieldIdx)
    }

    fun setFieldValue(num: Int, fieldArrayIndex: Int, value: Any?, subFieldName: String?) {
        var field = getField(num)

        if (field == null) {
            field = Factory.createField(this.num, num)
            addField(field)
        }

        field.setValue(fieldArrayIndex, value, subFieldName)
    }

    fun setFieldValue(name: String?, value: Any?) {
        setFieldValue(name, 0, value)
    }

    fun setFieldValue(name: String?, fieldArrayIndex: Int, value: Any?) {
        var field = getField(name, false)

        if (field == null) {
            field = Factory.createField(this.num, name)
            addField(field)
        }

        field.setValue(fieldArrayIndex, value, name)
    }

    fun getFieldBitsValue(num: Int, offset: Int, bits: Int, signed: Boolean): Long? {
        val field = getField(num) ?: return null

        return field.getBitsValue(offset, bits, signed)
    }

    fun getFieldBitsValue(name: String?, offset: Int, bits: Int, signed: Boolean): Long? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getBitsValue(offset, bits, signed)
        } else {
            return null
        }
    }

    fun getFieldByteValues(num: Int): Array<Byte?>? {
        return getFieldByteValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldByteValues(num: Int, subfieldIndex: Int): Array<Byte?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getByteValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldByteValues(num: Int, subfieldName: String?): Array<Byte?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getByteValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldByteValue(num: Int): Byte? {
        return getFieldByteValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldByteValue(num: Int, fieldArrayIndex: Int): Byte? {
        return getFieldByteValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldByteValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): Byte? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getByteValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getByteValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldByteValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): Byte? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getByteValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldByteValue(name: String?): Byte? {
        return getFieldByteValue(name, 0)
    }

    fun getFieldByteValue(name: String?, fieldArrayIndex: Int): Byte? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getByteValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    fun getFieldShortValues(num: Int): Array<Short?>? {
        return getFieldShortValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldShortValues(num: Int, subfieldIndex: Int): Array<Short?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getShortValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldShortValues(num: Int, subfieldName: String?): Array<Short?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getShortValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldShortValue(num: Int): Short? {
        return getFieldShortValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldShortValue(num: Int, fieldArrayIndex: Int): Short? {
        return getFieldShortValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldShortValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): Short? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getShortValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getShortValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldShortValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): Short? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getShortValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldShortValue(name: String?): Short? {
        return getFieldShortValue(name, 0)
    }

    fun getFieldShortValue(name: String?, fieldArrayIndex: Int): Short? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getShortValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    fun getFieldIntegerValues(num: Int): Array<Int?>? {
        return getFieldIntegerValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldIntegerValues(num: Int, subfieldIndex: Int): Array<Int?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getIntegerValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldIntegerValues(num: Int, subfieldName: String?): Array<Int?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getIntegerValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldIntegerValue(num: Int): Int? {
        return getFieldIntegerValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldIntegerValue(num: Int, fieldArrayIndex: Int): Int? {
        return getFieldIntegerValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldIntegerValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): Int? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getIntegerValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getIntegerValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldIntegerValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): Int? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getIntegerValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldIntegerValue(name: String?): Int? {
        return getFieldIntegerValue(name, 0)
    }

    fun getFieldIntegerValue(name: String?, fieldArrayIndex: Int): Int? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getIntegerValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    fun getFieldLongValues(num: Int): Array<Long?>? {
        return getFieldLongValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldLongValues(num: Int, subfieldIndex: Int): Array<Long?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getLongValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldLongValues(num: Int, subfieldName: String?): Array<Long?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getLongValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldLongValue(num: Int): Long? {
        return getFieldLongValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldLongValue(num: Int, fieldArrayIndex: Int): Long? {
        return getFieldLongValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldLongValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): Long? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getLongValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getLongValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldLongValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): Long? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getLongValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldLongValue(name: String?): Long? {
        return getFieldLongValue(name, 0)
    }

    fun getFieldLongValue(name: String?, fieldArrayIndex: Int): Long? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getLongValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    fun getFieldFloatValues(num: Int): Array<Float?>? {
        return getFieldFloatValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldFloatValues(num: Int, subfieldIndex: Int): Array<Float?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getFloatValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldFloatValues(num: Int, subfieldName: String?): Array<Float?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getFloatValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldFloatValue(num: Int): Float? {
        return getFieldFloatValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldFloatValue(num: Int, fieldArrayIndex: Int): Float? {
        return getFieldFloatValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldFloatValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): Float? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getFloatValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getFloatValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldFloatValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): Float? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getFloatValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldFloatValue(name: String?): Float? {
        return getFieldFloatValue(name, 0)
    }

    fun getFieldFloatValue(name: String?, fieldArrayIndex: Int): Float? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getFloatValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    fun getFieldDoubleValues(num: Int): Array<Double?>? {
        return getFieldDoubleValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldDoubleValues(num: Int, subfieldIndex: Int): Array<Double?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getDoubleValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldDoubleValues(num: Int, subfieldName: String?): Array<Double?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getDoubleValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldDoubleValue(num: Int): Double? {
        return getFieldDoubleValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldDoubleValue(num: Int, fieldArrayIndex: Int): Double? {
        return getFieldDoubleValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldDoubleValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): Double? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getDoubleValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getDoubleValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldDoubleValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): Double? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getDoubleValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldDoubleValue(name: String?): Double? {
        return getFieldDoubleValue(name, 0)
    }

    fun getFieldDoubleValue(name: String?, fieldArrayIndex: Int): Double? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getDoubleValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    fun getFieldStringValues(num: Int): Array<String?>? {
        return getFieldStringValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldStringValues(num: Int, subfieldIndex: Int): Array<String?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getStringValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldStringValues(num: Int, subfieldName: String?): Array<String?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getStringValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldStringValue(num: Int): String? {
        return getFieldStringValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldStringValue(num: Int, fieldArrayIndex: Int): String? {
        return getFieldStringValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldStringValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): String? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getStringValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getStringValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldStringValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): String? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getStringValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldStringValue(name: String?): String? {
        return getFieldStringValue(name, 0)
    }

    fun getFieldStringValue(name: String?, fieldArrayIndex: Int): String? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getStringValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    // getFieldULongValue* replaces the Java getFieldBigIntegerValue* family (DESIGN.md §1.4).
    fun getFieldULongValues(num: Int): Array<ULong?>? {
        return getFieldULongValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldULongValues(num: Int, subfieldIndex: Int): Array<ULong?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getULongValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldULongValues(num: Int, subfieldName: String?): Array<ULong?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getULongValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldULongValue(num: Int): ULong? {
        return getFieldULongValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldULongValue(num: Int, fieldArrayIndex: Int): ULong? {
        return getFieldULongValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldULongValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): ULong? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getULongValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getULongValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldULongValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): ULong? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getULongValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldULongValue(name: String?): ULong? {
        return getFieldULongValue(name, 0)
    }

    fun getFieldULongValue(name: String?, fieldArrayIndex: Int): ULong? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getULongValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    // getFieldBigDecimalValue* kept by name; BigDecimal mapped to Double (DESIGN.md §1.1/§1.4).
    fun getFieldBigDecimalValues(num: Int): Array<Double?>? {
        return getFieldBigDecimalValues(num, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldBigDecimalValues(num: Int, subfieldIndex: Int): Array<Double?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldIndex)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getBigDecimalValues(subfieldIndex)
        } else {
            return null
        }
    }

    fun getFieldBigDecimalValues(num: Int, subfieldName: String?): Array<Double?>? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subfieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getBigDecimalValues(subfieldName)
        } else {
            return null
        }
    }

    fun getFieldBigDecimalValue(num: Int): Double? {
        return getFieldBigDecimalValue(num, 0, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldBigDecimalValue(num: Int, fieldArrayIndex: Int): Double? {
        return getFieldBigDecimalValue(num, fieldArrayIndex, Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)
    }

    fun getFieldBigDecimalValue(num: Int, fieldArrayIndex: Int, subFieldIndex: Int): Double? {
        val field = getField(num) ?: return null

        if (subFieldIndex == Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD) {
            return field.getBigDecimalValue(fieldArrayIndex, getActiveSubFieldIndex(num))
        } else {
            val subField = field.getSubField(subFieldIndex)

            if ((subField == null) || (subField.canMesgSupport(this))) {
                return field.getBigDecimalValue(fieldArrayIndex, subFieldIndex)
            } else {
                return null
            }
        }
    }

    fun getFieldBigDecimalValue(num: Int, fieldArrayIndex: Int, subFieldName: String?): Double? {
        val field = getField(num) ?: return null

        val subField = field.getSubField(subFieldName)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getBigDecimalValue(fieldArrayIndex, subFieldName)
        } else {
            return null
        }
    }

    fun getFieldBigDecimalValue(name: String?): Double? {
        return getFieldBigDecimalValue(name, 0)
    }

    fun getFieldBigDecimalValue(name: String?, fieldArrayIndex: Int): Double? {
        val field = getField(name, false) ?: return null

        val subField = field.getSubField(name)

        if ((subField == null) || (subField.canMesgSupport(this))) {
            return field.getBigDecimalValue(fieldArrayIndex, name)
        } else {
            return null
        }
    }

    fun getFields(): Collection<Field> {
        // Java: Collections.unmodifiableCollection(fields)
        return fields
    }

    fun setFields(mesg: Mesg) {
        if (mesg.num != num) {
            return
        }

        for (field in mesg.fields) {
            setField(field)
        }
    }

    fun timestampToDateTime(timestamp: Long?): DateTime? {
        if (timestamp == null) {
            return null
        }

        val dateTime = DateTime(timestamp)
        dateTime.convertSystemTimeToUTC(systemTimeOffset)

        return dateTime
    }

    // protected in Java; internal because Decode calls it.
    internal fun setDecoderMessageIndex(decoderMesgIndex: Int) {
        this.decoderMesgIndex = decoderMesgIndex
    }

    fun getDecoderMesgIndex(): Int {
        return decoderMesgIndex
    }

    fun removeField(f: Field): Boolean {
        var removedItem = false
        if (f in this.fields) {
            this.fields.remove(f)
            removedItem = true
        }
        return removedItem
    }

    /**
     * Retrieve all developer fields in the message
     *
     * @return [Iterable] of all [DeveloperField]s in the message
     */
    fun getDeveloperFields(): Iterable<DeveloperField> {
        return developerFields
    }

    /**
     * Retrieve all fields that are equivalent to the requested field number
     *
     * @param fieldNum The Field Number from the Profile that we are looking for
     * @return [Iterable] of [FieldBase]s that are equivalent to the
     *         field number provided
     */
    fun getOverrideField(fieldNum: Short): Iterable<FieldBase> {
        val overrideFields = ArrayList<FieldBase>()

        val nativeField = getField(fieldNum.toInt())

        if (null != nativeField) {
            overrideFields.add(nativeField)
        }

        for (devField in developerFields) {
            if (devField.getNativeOverride() == fieldNum) {
                overrideFields.add(devField)
            }
        }

        return overrideFields
    }
}
