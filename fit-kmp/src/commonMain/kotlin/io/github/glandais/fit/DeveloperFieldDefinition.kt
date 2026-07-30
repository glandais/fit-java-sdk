// Hand-written multiplatform port of DeveloperFieldDefinition.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

class DeveloperFieldDefinition : FieldDefinitionBase {
    private var fieldDescriptionMesg: FieldDescriptionMesg? = null
    private var developerDataIdMesg: DeveloperDataIdMesg? = null
    private var size: Int = 0
    private var type: Int = 0
    private var num: Short = 0

    constructor() {
        fieldDescriptionMesg = null
        type = FitBaseType.UINT8.toInt()
    }

    constructor(mesg: FieldDescriptionMesg?, developerDataIdMesg: DeveloperDataIdMesg?) {
        setFieldDescription(mesg)
        this.developerDataIdMesg = developerDataIdMesg
    }

    constructor(field: DeveloperField) : this(field.getFieldDefinition()) {
        this.size = field.getSize()
    }

    constructor(other: DeveloperFieldDefinition) {
        setFieldDescription(other.fieldDescriptionMesg)
        this.developerDataIdMesg = other.developerDataIdMesg
        size = other.getSize()
    }

    fun getAppVersion(): Long {
        var value: Long? = null

        if (isDefined()) {
            value = developerDataIdMesg!!.applicationVersion
        }

        if (null == value) {
            return Fit.UINT32_INVALID
        }

        return value
    }

    fun getAppId(): Array<Byte?>? {
        if (isDefined()) {
            return developerDataIdMesg!!.getApplicationId()
        }

        return null
    }

    fun getDeveloperDataIndex(): Short {
        var value: Short? = null
        if (isDefined()) {
            value = fieldDescriptionMesg!!.developerDataIndex
        }

        if (null == value) {
            return Fit.UINT8_INVALID
        }

        return value
    }

    fun isDefined(): Boolean {
        return (fieldDescriptionMesg != null) && (developerDataIdMesg != null)
    }

    fun getFieldName(): String? {
        if (isDefined()) {
            return fieldDescriptionMesg!!.getFieldName(0)
        }

        return null
    }

    fun getScale(): Short {
        if (isDefined() &&
            (fieldDescriptionMesg!!.scale != null) &&
            (fieldDescriptionMesg!!.scale != Fit.UINT8_INVALID)) {
            return fieldDescriptionMesg!!.scale!!
        }

        return Fit.FIELD_DEFAULT_SCALE.toShort()
    }

    fun getOffset(): Short {
        if (isDefined() &&
            (fieldDescriptionMesg!!.offset != null) &&
            (fieldDescriptionMesg!!.offset != Fit.SINT8_INVALID)) {
            return fieldDescriptionMesg!!.offset!!.toShort()
        }

        return Fit.FIELD_DEFAULT_OFFSET.toShort()
    }

    fun getUnits(): String? {
        if (isDefined()) {
            return fieldDescriptionMesg!!.getUnits(0)
        }

        return null
    }

    fun getDefaultField(): DeveloperField {
        return DeveloperField(this)
    }

    // protected in Java; internal because Mesg calls it.
    internal fun write(out: OutputStream) {
        try {
            out.write(fieldDescriptionMesg!!.fieldDefinitionNumber!!.toInt())
            out.write(size)
            out.write(fieldDescriptionMesg!!.developerDataIndex!!.toInt())
        } catch (e: IOException) {
            throw FitRuntimeException(e)
        }
    }

    fun getNum(): Short {
        return num
    }

    fun setNum(num: Short) {
        this.num = num
    }

    override fun getSize(): Int {
        return size
    }

    override fun setSize(size: Int) {
        this.size = size
    }

    fun getType(): Int {
        return type
    }

    /**
     * Retrieve the Overridden Native Field Number
     *
     * @return Overridden field number if field overrides a value, [Fit.UINT8_INVALID] otherwise.
     */
    fun getNativeOverride(): Short {
        if (isDefined()) {
            val nativeNum = fieldDescriptionMesg!!.nativeFieldNum
            if (null != nativeNum) {
                return nativeNum
            }
        }

        return Fit.UINT8_INVALID
    }

    // package-private in Java
    internal fun setFieldDescription(description: FieldDescriptionMesg?) {
        this.fieldDescriptionMesg = description
        this.num = fieldDescriptionMesg!!.fieldDefinitionNumber!!
        this.type = fieldDescriptionMesg!!.fitBaseTypeId!!.toInt()
    }

    // package-private in Java
    internal fun setDeveloperDataIdMesg(developerDataIdMesg: DeveloperDataIdMesg?) {
        this.developerDataIdMesg = developerDataIdMesg
    }
}
