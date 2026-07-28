// Hand-written multiplatform port of MesgDefinition.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

class MesgDefinition {
    internal var num: Int = MesgNum.INVALID
    internal var localNum: Int = 0
    internal var arch: Int = Fit.ARCH_ENDIAN_BIG
    internal val fields: ArrayList<FieldDefinition> = ArrayList()
    internal val developerFields: ArrayList<DeveloperFieldDefinition> = ArrayList()

    // protected in Java; internal because Decode instantiates definitions.
    internal constructor()

    constructor(mesg: Mesg) {
        num = mesg.num
        localNum = mesg.localNum
        arch = Fit.ARCH_ENDIAN_BIG

        if (localNum >= Fit.MAX_LOCAL_MESGS) {
            throw FitRuntimeException("Invalid local message number " + localNum + ".  Local message number must be < " + Fit.MAX_LOCAL_MESGS + ".")
        }

        for (field in mesg.fields) {
            fields.add(FieldDefinition(field))
        }

        for (field in mesg.developerFields) {
            developerFields.add(DeveloperFieldDefinition(field))
        }
    }

    fun getNum(): Int {
        return num
    }

    fun getLocalNum(): Int {
        return localNum
    }

    fun getArch(): Int {
        return arch
    }

    fun getFields(): ArrayList<FieldDefinition> {
        return fields
    }

    fun getField(num: Int): FieldDefinition? {
        for (field in fields) {
            if (field.num == num) {
                return field
            }
        }

        return null
    }

    fun addField(fieldDef: FieldDefinition) {
        fields.add(fieldDef)
    }

    fun addDeveloperField(fieldDef: DeveloperFieldDefinition) {
        developerFields.add(fieldDef)
    }

    fun getDeveloperFieldTotalSize(): Int {
        var rv = 0

        for (devField in developerFields) {
            rv += devField.getSize()
        }

        return rv
    }

    fun write(out: OutputStream) {
        try {
            var headerByte = Fit.HDR_TYPE_DEF_BIT or (localNum and Fit.HDR_TYPE_MASK)
            if (!developerFields.isEmpty()) {
                headerByte = headerByte or Fit.HDR_DEV_FIELDS_BIT
            }

            out.write(headerByte) // Message definition record header.
            out.write(0) // Reserved
            out.write(Fit.ARCH_ENDIAN_BIG)
            out.write(num shr 8)
            out.write(num)
            out.write(fields.size)

            for (field in fields) {
                field.write(out)
            }

            if (!developerFields.isEmpty()) {
                out.write(developerFields.size)

                for (field in developerFields) {
                    field.write(out)
                }
            }
        } catch (e: IOException) {
            throw FitRuntimeException(e)
        }
    }

    fun supports(mesg: Mesg): Boolean {
        return supports(MesgDefinition(mesg))
    }

    fun supports(mesgDef: MesgDefinition?): Boolean {
        if (mesgDef == null) {
            return false
        }

        if (num != mesgDef.num) {
            return false
        }

        if (localNum != mesgDef.localNum) {
            return false
        }

        for (fieldDef in mesgDef.fields) {
            val supportedFieldDef = getField(fieldDef.num)

            if (supportedFieldDef == null) {
                return false
            }

            if (fieldDef.size > supportedFieldDef.size) {
                return false
            }
        }

        // Check to make sure that all field developer fields are defined
        for (fieldDef in mesgDef.developerFields) {
            val supportedDef = getDeveloperField(fieldDef.getDeveloperDataIndex(), fieldDef.getNum().toInt())

            // There is a Field Definition that we don't have a description for
            if (supportedDef == null) {
                return false
            }

            // The definition is a larger size that we dont support
            if (fieldDef.getSize() > supportedDef.getSize()) {
                return false
            }
        }

        return true
    }

    private fun getDeveloperField(developerIndex: Short, num: Int): DeveloperFieldDefinition? {
        for (field in developerFields) {
            if ((field.getNum().toInt() == num) && (field.getDeveloperDataIndex() == developerIndex)) {
                return field
            }
        }

        return null
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        if (other !is MesgDefinition) {
            return false
        }

        if (num != other.num) {
            return false
        }

        if (localNum != other.localNum) {
            return false
        }

        if (fields.size != other.fields.size) {
            return false
        }

        for (i in 0 until fields.size) {
            if (fields[i] != other.fields[i]) {
                return false
            }
        }

        return true
    }

    override fun hashCode(): Int {
        var hashCode = 1

        hashCode = (hashCode * 31) + num.hashCode()
        hashCode = (hashCode * 47) + localNum.hashCode()
        hashCode = (hashCode * 19) + fields.hashCode()

        return hashCode
    }

    fun getDeveloperFields(): Iterable<DeveloperFieldDefinition> {
        return developerFields
    }
}
