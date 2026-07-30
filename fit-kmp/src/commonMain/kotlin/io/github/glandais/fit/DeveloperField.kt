// Hand-written multiplatform port of DeveloperField.java — keep in sync (see overrides/hashes.json).
// java.util.UUID replaced by Uuid (DESIGN.md §2.4); getAppUUID() name kept.
package io.github.glandais.fit

class DeveloperField : FieldBase {
    private var fieldDefinition: DeveloperFieldDefinition

    constructor(def: DeveloperFieldDefinition) : super() {
        this.fieldDefinition = def
    }

    constructor(descriptionMesg: FieldDescriptionMesg?, developerDataIdMesg: DeveloperDataIdMesg?) : super() {
        this.fieldDefinition = DeveloperFieldDefinition(descriptionMesg, developerDataIdMesg)
    }

    constructor(other: DeveloperField) : super(other) {
        this.fieldDefinition = other.fieldDefinition
    }

    fun isDefined(): Boolean {
        return fieldDefinition.isDefined()
    }

    fun getNum(): Int {
        return fieldDefinition.getNum().toInt()
    }

    override fun getUnits(): String? {
        return fieldDefinition.getUnits()
    }

    override fun getType(): Int {
        return fieldDefinition.getType()
    }

    override fun getOffset(): Double {
        return fieldDefinition.getOffset().toDouble()
    }

    override fun getScale(): Double {
        return fieldDefinition.getScale().toDouble()
    }

    override fun getFieldName(): String? {
        return fieldDefinition.getFieldName()
    }

    fun getDeveloperDataIndex(): Short {
        return fieldDefinition.getDeveloperDataIndex()
    }

    fun getAppVersion(): Long {
        return fieldDefinition.getAppVersion()
    }

    fun getAppId(): Array<Byte?>? {
        return fieldDefinition.getAppId()
    }

    fun getAppUUID(): Uuid {
        // Java would NPE on a null appId or null array element; !! keeps that behaviour.
        val appId = fieldDefinition.getAppId()!!
        val primativeId = ByteArray(appId.size)

        for (i in appId.indices) {
            primativeId[i] = appId[i]!!
        }

        return Uuid.fromBytes(primativeId)
    }

    internal override fun getSubField(subFieldName: String?): SubField? {
        // Developer fields do not support sub-fields
        return null
    }

    internal override fun getSubField(subFieldIndex: Int): SubField? {
        // Developer fields do not support sub-fields
        return null
    }

    // package-private in Java
    internal fun getFieldDefinition(): DeveloperFieldDefinition {
        return fieldDefinition
    }

    /**
     * Get the Native override of the field
     *
     * @return The Field Number of the Overridden Field, [Fit.UINT8_INVALID] otherwise.
     */
    fun getNativeOverride(): Short {
        return fieldDefinition.getNativeOverride()
    }
}
