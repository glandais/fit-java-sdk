// Hand-written multiplatform port of Field.java — keep in sync (see overrides/hashes.json).
// Protected Java members are internal here: they are accessed cross-class (Mesg, Decode,
// generated mesg companions) inside the same package/module.
package com.garmin.fit

open class Field : FieldBase {
    internal var name: String = "unknown"
    internal var num: Int = Fit.FIELD_NUM_INVALID
    internal var type: Int = 0
    internal var scale: Double = 1.0
    internal var offset: Double = 0.0
    internal var units: String = ""
    internal var isAccumulated: Boolean = false
    internal var components: ArrayList<FieldComponent> = ArrayList()
    internal var subFields: ArrayList<SubField> = ArrayList()

    private var profileType: Profile.Type = Profile.Type.ENUM
    private var isExpandedField: Boolean = false

    constructor(field: Field?) : super(field) {
        if (field == null) {
            this.values = ArrayList()
            return
        }

        this.name = field.name
        this.num = field.num
        this.type = field.type
        this.profileType = field.profileType
        this.scale = field.scale
        this.offset = field.offset
        this.units = field.units
        this.isAccumulated = field.isAccumulated
        this.components = field.components
        this.subFields = field.subFields
        this.isExpandedField = field.isExpandedField
    }

    // protected in Java (package access); internal because Factory and the generated mesg
    // companions instantiate fields.
    internal constructor(name: String, num: Int, type: Int, scale: Double, offset: Double, units: String, accumulated: Boolean, profileType: Profile.Type) : super() {
        this.name = name
        this.num = num
        this.type = type
        this.profileType = profileType
        this.scale = scale
        this.offset = offset
        this.units = units
        this.isAccumulated = accumulated
    }

    fun getNum(): Int {
        return num
    }

    override fun getUnits(): String? {
        return this.units
    }

    override fun getType(): Int {
        return this.type
    }

    fun getProfileType(): Profile.Type {
        return this.profileType
    }

    override fun getOffset(): Double {
        return offset
    }

    override fun getScale(): Double {
        return scale
    }

    override fun getFieldName(): String? {
        return name
    }

    fun getIsAccumulated(): Boolean {
        return this.isAccumulated
    }

    internal fun setIsExpanded(newValue: Boolean) {
        isExpandedField = newValue
    }

    internal fun getIsExpanded(): Boolean {
        return isExpandedField
    }

    internal override fun getSubField(subFieldName: String?): SubField? {
        for (i in 0 until subFields.size) {
            if (subFields[i].name == subFieldName) {
                return subFields[i]
            }
        }

        return null
    }

    internal override fun getSubField(subFieldIndex: Int): SubField? {
        if ((subFieldIndex >= 0) && (subFieldIndex < subFields.size)) {
            return subFields[subFieldIndex]
        } else {
            return null
        }
    }
}
