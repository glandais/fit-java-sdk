// Hand-written multiplatform port of FieldDefinition.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

class FieldDefinition : FieldDefinitionBase {
    internal var num: Int = Fit.FIELD_NUM_INVALID
    internal var size: Int = 0
    internal var type: Int = 0

    // protected in Java; internal because Decode instantiates definitions.
    internal constructor()

    constructor(field: Field) {
        num = field.getNum()
        size = field.getSize()
        type = field.getType()
    }

    // protected in Java; internal because MesgDefinition calls it.
    internal fun write(out: OutputStream) {
        try {
            out.write(num)
            out.write(size)
            out.write(type)
        } catch (e: IOException) {
        }
    }

    fun getNum(): Int {
        return num
    }

    override fun setSize(size: Int) {
        this.size = size
    }

    override fun getSize(): Int {
        return size
    }

    fun getType(): Int {
        return type
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other !is FieldDefinition) {
            return false
        }

        if (num != other.num) {
            return false
        }

        if (size != other.size) {
            return false
        }

        if (type != other.type) {
            return false
        }

        return true
    }

    override fun hashCode(): Int {
        var hashCode = 1

        hashCode = (hashCode * 47) + this.num.hashCode()
        hashCode = (hashCode * 31) + this.size.hashCode()
        hashCode = (hashCode * 19) + this.type.hashCode()

        return hashCode
    }
}
