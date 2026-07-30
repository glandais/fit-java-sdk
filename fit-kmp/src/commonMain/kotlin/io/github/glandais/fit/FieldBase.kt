// Hand-written multiplatform port of FieldBase.java — keep in sync (see overrides/hashes.json).
//
// Conversion notes (DESIGN.md):
// - values stores Byte/Short/Int/Long/ULong/Float/Double/String (ULong replaces java.math.BigInteger
//   for FIT UINT64/UINT64Z values).
// - getBigIntegerValue* renamed getULongValue* (returns ULong?).
// - getBigDecimalValue* kept by name but returns Double? (BigDecimal -> Double, precision loss
//   beyond 2^53 accepted per DESIGN.md §1.4).
// - java.io streams replaced by the common shims of Streams.kt; DataInputStream/DataOutputStream
//   multi-byte big-endian accesses re-implemented locally (read*/write* helpers below).
// - UTF-8 encode/decode via kotlin-stdlib (invalid sequences produce U+FFFD, accepted §2.3).
package io.github.glandais.fit

import kotlin.math.roundToLong

abstract class FieldBase {
    internal var values: ArrayList<Any?>

    companion object {
        internal var forceShowInvalids: Boolean = !Fit.ENABLE_LEGACY_BEHAVIOUR
    }

    protected constructor() {
        this.values = ArrayList()
    }

    constructor(other: FieldBase?) {
        this.values = ArrayList()
        if (other != null) {
            for (value in other.values) {
                this.values.add(value)
            }
        }
    }

    // ULong is not a kotlin.Number: these helpers replace Java's ((Number) value).xxxValue()
    // pattern (BigInteger was a Number in Java, ULong is not in Kotlin).
    private fun isNumeric(value: Any?): Boolean = value is Number || value is ULong

    private fun numToDouble(value: Any): Double = when (value) {
        is ULong -> value.toDouble()
        else -> (value as Number).toDouble()
    }

    private fun numToLong(value: Any): Long = when (value) {
        is ULong -> value.toLong()
        else -> (value as Number).toLong()
    }

    private fun numToInt(value: Any): Int = when (value) {
        is ULong -> value.toInt()
        else -> (value as Number).toInt()
    }

    private fun numToShort(value: Any): Short = when (value) {
        is ULong -> value.toShort()
        else -> (value as Number).toShort()
    }

    private fun numToByte(value: Any): Byte = when (value) {
        is ULong -> value.toByte()
        else -> (value as Number).toByte()
    }

    private fun numToFloat(value: Any): Float = when (value) {
        is ULong -> value.toFloat()
        else -> (value as Number).toFloat()
    }

    fun getName(): String? {
        return getNameInternal(null)
    }

    private fun getNameInternal(subField: SubField?): String? {
        if (subField == null) {
            return getFieldName()
        } else {
            return subField.name
        }
    }

    fun getName(subFieldIndex: Int): String? {
        return getNameInternal(getSubField(subFieldIndex))
    }

    fun getName(subFieldName: String?): String? {
        return getNameInternal(getSubField(subFieldName))
    }

    abstract fun getUnits(): String?
    abstract fun getType(): Int
    protected abstract fun getOffset(): Double
    protected abstract fun getScale(): Double
    protected abstract fun getFieldName(): String?
    // protected in Java; internal here because Mesg (same package, not a subclass) calls them.
    internal abstract fun getSubField(subFieldName: String?): SubField?
    internal abstract fun getSubField(subFieldIndex: Int): SubField?

    fun getType(subFieldIndex: Int): Int {
        return getTypeInternal(getSubField(subFieldIndex))
    }

    fun getType(subFieldName: String?): Int {
        return getTypeInternal(getSubField(subFieldName))
    }

    private fun getTypeInternal(subField: SubField?): Int {
        if (subField == null) {
            return getType()
        } else {
            return subField.type
        }
    }

    fun getUnits(subFieldIndex: Int): String? {
        return getUnitsInternal(getSubField(subFieldIndex))
    }

    fun getUnits(subFieldName: String?): String? {
        return getUnitsInternal(getSubField(subFieldName))
    }

    private fun getUnitsInternal(subField: SubField?): String? {
        if (subField == null) {
            return getUnits()
        } else {
            return subField.units
        }
    }

    // package-private in Java
    internal fun getSize(): Int {
        var size = 0

        when (getType()) {
            Fit.BASE_TYPE_ENUM,
            Fit.BASE_TYPE_UINT8,
            Fit.BASE_TYPE_UINT8Z,
            Fit.BASE_TYPE_SINT8,
            Fit.BASE_TYPE_BYTE,
            Fit.BASE_TYPE_SINT16,
            Fit.BASE_TYPE_UINT16,
            Fit.BASE_TYPE_UINT16Z,
            Fit.BASE_TYPE_SINT32,
            Fit.BASE_TYPE_UINT32,
            Fit.BASE_TYPE_UINT32Z,
            Fit.BASE_TYPE_FLOAT32,
            Fit.BASE_TYPE_FLOAT64,
            Fit.BASE_TYPE_SINT64,
            Fit.BASE_TYPE_UINT64,
            Fit.BASE_TYPE_UINT64Z ->
                size = getNumValues() * Fit.baseTypeSizes[getType() and Fit.BASE_TYPE_NUM_MASK]

            Fit.BASE_TYPE_STRING -> {
                for (value in values) {
                    if (value == null) {
                        size += 1
                        continue
                    }
                    size += value.toString().encodeToByteArray().size + 1
                }
            }

            else -> {}
        }

        return size
    }

    // rawValue is already the correct quantity (scale/offsets applied) but possibly not the
    // correct underlying type
    fun addRawValue(rawValue: Any?) {
        if (rawValue == null) {
            values.add(null)
        }
        // Add a scaled/offset value as the underlying field type rather than double
        else if (rawValue is Double) {
            when (getType()) {
                Fit.BASE_TYPE_ENUM,
                Fit.BASE_TYPE_UINT8,
                Fit.BASE_TYPE_UINT8Z,
                Fit.BASE_TYPE_SINT16,
                Fit.BASE_TYPE_BYTE ->
                    values.add(rawValue.roundToLong().toShort())

                Fit.BASE_TYPE_SINT8 ->
                    values.add(rawValue.roundToLong().toByte())

                Fit.BASE_TYPE_UINT16,
                Fit.BASE_TYPE_UINT16Z,
                Fit.BASE_TYPE_SINT32 ->
                    values.add(rawValue.roundToLong().toInt())

                Fit.BASE_TYPE_UINT32,
                Fit.BASE_TYPE_UINT32Z ->
                    values.add(rawValue.roundToLong())

                Fit.BASE_TYPE_FLOAT32 ->
                    values.add(rawValue)

                Fit.BASE_TYPE_FLOAT64 ->
                    values.add(rawValue)

                Fit.BASE_TYPE_STRING ->
                    values.add(rawValue.toString())

                else -> {}
            }
        } else if ((rawValue is String) && (rawValue == "")) {
            when (getType()) {
                Fit.BASE_TYPE_ENUM -> values.add(Fit.ENUM_INVALID)
                Fit.BASE_TYPE_SINT8 -> values.add(Fit.SINT8_INVALID)
                Fit.BASE_TYPE_UINT8 -> values.add(Fit.UINT8_INVALID)
                Fit.BASE_TYPE_UINT8Z -> values.add(Fit.UINT8Z_INVALID)
                Fit.BASE_TYPE_SINT16 -> values.add(Fit.SINT16_INVALID)
                Fit.BASE_TYPE_UINT16 -> values.add(Fit.UINT16_INVALID)
                Fit.BASE_TYPE_UINT16Z -> values.add(Fit.UINT16Z_INVALID)
                Fit.BASE_TYPE_SINT32 -> values.add(Fit.SINT32_INVALID)
                Fit.BASE_TYPE_UINT32 -> values.add(Fit.UINT32_INVALID)
                Fit.BASE_TYPE_UINT32Z -> values.add(Fit.UINT32Z_INVALID)
                Fit.BASE_TYPE_STRING -> values.add(rawValue)
                Fit.BASE_TYPE_FLOAT32 -> values.add(Fit.FLOAT32_INVALID)
                Fit.BASE_TYPE_FLOAT64 -> values.add(Fit.FLOAT64_INVALID)
                Fit.BASE_TYPE_BYTE -> values.add(Fit.BYTE_INVALID)
                else -> {}
            }
        } else {
            values.add(rawValue)
        }
    }

    fun getNumValues(): Int {
        return values.size
    }

    internal fun isSignedInteger(): Boolean {
        return isSignedIntegerInternal(null)
    }

    internal fun isSignedInteger(subFieldIndex: Int): Boolean {
        return isSignedIntegerInternal(getSubField(subFieldIndex))
    }

    internal fun isSignedInteger(subFieldName: String?): Boolean {
        return isSignedIntegerInternal(getSubField(subFieldName))
    }

    fun isSignedIntegerInternal(subField: SubField?): Boolean {
        val type = if (subField == null) getType() else subField.type
        when (type) {
            Fit.BASE_TYPE_SINT8,
            Fit.BASE_TYPE_SINT16,
            Fit.BASE_TYPE_SINT32,
            Fit.BASE_TYPE_SINT64 ->
                return true

            else -> {}
        }

        return false
    }

    /**
     * Determines if a field is valid
     * @return true if the currently active SubField is valid
     */
    fun isValid(): Boolean {
        return isValid(0)
    }

    /**
     * Determines if an array member of a field is valid
     * @param index the index in the field array to check
     * @return true if the field member is valid
     */
    fun isValid(index: Int): Boolean {
        val type = getType(Fit.SUBFIELD_INDEX_ACTIVE_SUBFIELD)

        if (index >= values.size) {
            return false
        }

        val value = values[index]

        if (isNumeric(value)) {
            if (Fit.baseTypeInvalidMap[type] == value) {
                return false
            }
        }

        return true
    }

    fun getBitsValue(offset: Int, bits: Int, signed: Boolean): Long? {
        var off = offset
        var value: Long = 0
        var bitsInValue = 0
        var bitsInData: Int
        var index = 0

        while (bitsInValue < bits) {
            // Remove the scale and offset (which previously had been been fixed at 1/0)
            // Work in raw to avoid rounds.  Caller shall apply scale/offset
            val objData = getRawValueInternal(index++, null)

            if (objData == null) {
                return null
            }
            if (!isNumeric(objData)) {
                return null
            }
            var data = numToLong(objData)

            data = data shr off
            bitsInData = Fit.baseTypeSizes[getType() and Fit.BASE_TYPE_NUM_MASK] * 8 - off
            off -= Fit.baseTypeSizes[getType() and Fit.BASE_TYPE_NUM_MASK] * 8

            if (bitsInData > 0) {
                off = 0

                if (bitsInData > (bits - bitsInValue)) {
                    bitsInData = bits - bitsInValue
                }

                val mask = if (bitsInData == 64) -1L else (1L shl bitsInData) - 1
                value = value or ((data and mask) shl bitsInValue)
                bitsInValue += bitsInData
            }
        }

        if (signed) {
            val signBit = 1L shl (bits - 1)

            if ((value and signBit) != 0L) {
                value = -signBit + (value and (signBit - 1))
            }
        }

        return value
    }

    fun getRawValue(): Any? {
        return getRawValueInternal(0, null)
    }

    fun getRawValue(fieldArrayIndex: Int): Any? {
        return getRawValueInternal(fieldArrayIndex, null)
    }

    fun getRawValue(fieldArrayIndex: Int, subFieldIndex: Int): Any? {
        return getRawValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getRawValue(fieldArrayIndex: Int, subFieldName: String?): Any? {
        return getRawValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getRawValueInternal(fieldArrayIndex: Int, subField: SubField?): Any? {
        if (fieldArrayIndex >= values.size) {
            return null
        }

        return values[fieldArrayIndex]
    }

    fun getValue(): Any? {
        return getValueInternal(0, null)
    }

    fun getValue(fieldArrayIndex: Int): Any? {
        return getValueInternal(fieldArrayIndex, null)
    }

    fun getValue(fieldArrayIndex: Int, subFieldIndex: Int): Any? {
        return getValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getValue(fieldArrayIndex: Int, subFieldName: String?): Any? {
        return getValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getValueInternal(fieldArrayIndex: Int, subField: SubField?): Any? {
        val scale: Double
        val offset: Double

        if (fieldArrayIndex >= values.size) {
            return null
        }

        if (subField == null) {
            scale = getScale()
            offset = getOffset()
        } else {
            scale = subField.scale
            offset = subField.offset
        }

        val type = getTypeInternal(subField)
        val value = values[fieldArrayIndex]

        if (isNumeric(value)) {
            if (Fit.baseTypeInvalidMap[type] == value) {
                return Fit.baseTypeInvalidMap[type]
            }

            if ((scale != Fit.FIELD_DEFAULT_SCALE.toDouble()) || (offset != Fit.FIELD_DEFAULT_OFFSET.toDouble())) {
                // Java used BigDecimal for BigInteger (UINT64) values here; ULong values go through
                // Double arithmetic instead. Precision loss beyond 2^53 accepted (DESIGN.md §1.4).
                return numToDouble(value!!) / scale - offset
            }
        }

        return value
    }

    fun setValue(value: Any?) {
        setValueInternal(0, value, null)
    }

    fun setValue(fieldArrayIndex: Int, value: Any?) {
        setValueInternal(fieldArrayIndex, value, null)
    }

    fun setValue(value: Any?, subFieldIndex: Int) {
        setValueInternal(0, value, getSubField(subFieldIndex))
    }

    fun setValue(value: Any?, subFieldName: String?) {
        setValueInternal(0, value, getSubField(subFieldName))
    }

    fun setValue(fieldArrayIndex: Int, value: Any?, subFieldIndex: Int) {
        var subField: SubField? = null

        if (subFieldIndex != Fit.SUBFIELD_INDEX_MAIN_FIELD) {
            subField = getSubField(subFieldIndex)

            if (subField == null) {
                throw FitRuntimeException("com.garmin.fit.Field.setValue(): " + subFieldIndex + " is not a valid subfield index of " + getName() + ".")
            }
        }

        setValueInternal(fieldArrayIndex, value, subField)
    }

    fun setValue(fieldArrayIndex: Int, value: Any?, subFieldName: String?) {
        setValueInternal(fieldArrayIndex, value, getSubField(subFieldName))
    }

    // Java compared via BigDecimal(value.toString()); replaced by Double comparison
    // (precision loss beyond 2^53 accepted, DESIGN.md §1.4).
    private fun rangeCorrect(type: Int, value: Any): Any? {
        val min = Fit.baseTypeMinMap[type]
        val max = Fit.baseTypeMaxMap[type]
        if (min == null || max == null) {
            // Type does not have a range limit. Return value as is.
            return value
        }

        return try {
            val minVal = min.toString().toDouble()
            val maxVal = max.toString().toDouble()
            val v = value.toString().toDouble()
            if (v < minVal || v > maxVal) {
                Fit.baseTypeInvalidMap[type]
            } else {
                value
            }
        } catch (e: NumberFormatException) {
            Fit.baseTypeInvalidMap[type]
        }
    }

    protected fun setValueInternal(fieldArrayIndex: Int, value: Any?, subField: SubField?) {
        while (fieldArrayIndex >= getNumValues())
            addValue(Any())

        val scale: Double
        val offset: Double

        if (subField == null) {
            scale = getScale()
            offset = getOffset()
        } else {
            scale = subField.scale
            offset = subField.offset
        }

        if (value == null) {
            values[fieldArrayIndex] = null
        } else if (isNumeric(value) && ((scale != Fit.FIELD_DEFAULT_SCALE.toDouble()) || (offset != Fit.FIELD_DEFAULT_OFFSET.toDouble()))) {
            val rawValue = (numToDouble(value) + offset) * scale
            when (getType()) {
                Fit.BASE_TYPE_ENUM,
                Fit.BASE_TYPE_UINT8,
                Fit.BASE_TYPE_UINT8Z,
                Fit.BASE_TYPE_SINT16 ->
                    values[fieldArrayIndex] = rangeCorrect(getType(), rawValue.roundToLong())

                Fit.BASE_TYPE_SINT8 ->
                    values[fieldArrayIndex] = rangeCorrect(getType(), rawValue.roundToLong())

                Fit.BASE_TYPE_UINT16,
                Fit.BASE_TYPE_UINT16Z,
                Fit.BASE_TYPE_SINT32 ->
                    values[fieldArrayIndex] = rangeCorrect(getType(), rawValue.roundToLong())

                Fit.BASE_TYPE_UINT32,
                Fit.BASE_TYPE_UINT32Z ->
                    values[fieldArrayIndex] = rangeCorrect(getType(), rawValue.roundToLong())

                Fit.BASE_TYPE_FLOAT32 ->
                    values[fieldArrayIndex] = rangeCorrect(getType(), rawValue)

                Fit.BASE_TYPE_FLOAT64 ->
                    values[fieldArrayIndex] = rangeCorrect(getType(), rawValue)

                Fit.BASE_TYPE_STRING ->
                    values[fieldArrayIndex] = rawValue.toString()

                Fit.BASE_TYPE_SINT64 ->
                    // Java used BigDecimal/BigInteger; Double/Long arithmetic here (DESIGN.md §1.4).
                    values[fieldArrayIndex] = rangeCorrect(getType(), rawValue.toLong())

                Fit.BASE_TYPE_UINT64,
                Fit.BASE_TYPE_UINT64Z ->
                    // Negative raw values are kept as Long so rangeCorrect flags them invalid.
                    values[fieldArrayIndex] = rangeCorrect(getType(), if (rawValue < 0) rawValue.toLong() else rawValue.toULong())

                Fit.BASE_TYPE_BYTE ->
                    // Byte base types are only invalid if all bytes in an array are set to invalid.
                    values[fieldArrayIndex] = rawValue.roundToLong()

                else -> {}
            }
        } else {
            SetValueUnscaled(fieldArrayIndex, value)
        }
    }

    private fun SetValueUnscaled(fieldArrayIndex: Int, value: Any) {
        if ((value is String) && (value == "")) {
            when (getType()) {
                Fit.BASE_TYPE_ENUM,
                Fit.BASE_TYPE_SINT8,
                Fit.BASE_TYPE_UINT8,
                Fit.BASE_TYPE_UINT8Z,
                Fit.BASE_TYPE_SINT16,
                Fit.BASE_TYPE_UINT16,
                Fit.BASE_TYPE_UINT16Z,
                Fit.BASE_TYPE_SINT32,
                Fit.BASE_TYPE_UINT32,
                Fit.BASE_TYPE_UINT32Z,
                Fit.BASE_TYPE_FLOAT32,
                Fit.BASE_TYPE_FLOAT64,
                Fit.BASE_TYPE_BYTE,
                Fit.BASE_TYPE_SINT64,
                Fit.BASE_TYPE_UINT64,
                Fit.BASE_TYPE_UINT64Z ->
                    values[fieldArrayIndex] = Fit.baseTypeInvalidMap[getType()]

                Fit.BASE_TYPE_STRING ->
                    values[fieldArrayIndex] = rangeCorrect(getType(), value)

                else -> {}
            }
        } else if (value is String) {
            val byteCount = value.encodeToByteArray().size
            if (byteCount > Fit.STRING_MAX_BYTE_COUNT) {
                throw FitRuntimeException("Invalid string size. Byte count can not be greater than ${Fit.STRING_MAX_BYTE_COUNT} bytes.")
            }
            values[fieldArrayIndex] = value
        } else {
            values[fieldArrayIndex] = rangeCorrect(getType(), value)
        }
    }

    fun setRawValue(fieldArrayIndex: Int, rawValue: Any?) {
        while (fieldArrayIndex >= getNumValues()) {
            addValue(Any())
        }

        if (rawValue == null) {
            values[fieldArrayIndex] = null
        }
        // Add a scaled/offset value as the underlying field type rather than double
        else if (rawValue is Double) {
            when (getType()) {
                Fit.BASE_TYPE_ENUM,
                Fit.BASE_TYPE_UINT8,
                Fit.BASE_TYPE_UINT8Z,
                Fit.BASE_TYPE_SINT16,
                Fit.BASE_TYPE_BYTE ->
                    values[fieldArrayIndex] = rawValue.roundToLong().toShort()

                Fit.BASE_TYPE_SINT8 ->
                    values[fieldArrayIndex] = rawValue.roundToLong().toByte()

                Fit.BASE_TYPE_UINT16,
                Fit.BASE_TYPE_UINT16Z,
                Fit.BASE_TYPE_SINT32 ->
                    values[fieldArrayIndex] = rawValue.roundToLong().toInt()

                Fit.BASE_TYPE_UINT32,
                Fit.BASE_TYPE_UINT32Z ->
                    values[fieldArrayIndex] = rawValue.roundToLong()

                Fit.BASE_TYPE_FLOAT32 ->
                    values[fieldArrayIndex] = rawValue

                Fit.BASE_TYPE_FLOAT64 ->
                    values[fieldArrayIndex] = rawValue

                Fit.BASE_TYPE_SINT64 ->
                    values[fieldArrayIndex] = rawValue.roundToLong()

                Fit.BASE_TYPE_UINT64,
                Fit.BASE_TYPE_UINT64Z ->
                    // Java: BigInteger.valueOf(Math.round(...))
                    values[fieldArrayIndex] = rawValue.roundToLong().toULong()

                Fit.BASE_TYPE_STRING ->
                    values[fieldArrayIndex] = rawValue.toString()

                else -> {}
            }
        } else if (rawValue is ULong) {
            // Replaces the Java "rawValue instanceof BigDecimal" branch (64-bit component
            // expansion path, see DecoderBase): the 64-bit unsigned path now produces ULong.
            when (getType()) {
                Fit.BASE_TYPE_SINT64 ->
                    values[fieldArrayIndex] = rawValue.toLong()

                Fit.BASE_TYPE_UINT64,
                Fit.BASE_TYPE_UINT64Z ->
                    values[fieldArrayIndex] = rawValue

                else -> {}
            }
        } else {
            SetValueUnscaled(fieldArrayIndex, rawValue)
        }
    }

    fun addValue(value: Any?) {
        if (isNumeric(value) && (getType() == Fit.BASE_TYPE_STRING)) {
            var string = getStringValueInternal(0, null)

            if (string == null) {
                string = ""
            }

            string += Char(numToInt(value!!) and 0xFFFF)
            setValueInternal(0, string, null)
            return
        }

        values.add(value)
    }

    fun getByteValues(): Array<Byte?> {
        return getByteValues(null as SubField?)
    }

    fun getByteValues(subfieldIndex: Int): Array<Byte?> {
        return getByteValues(getSubField(subfieldIndex))
    }

    fun getByteValues(subfieldName: String?): Array<Byte?> {
        return getByteValues(getSubField(subfieldName))
    }

    protected fun getByteValues(subfield: SubField?): Array<Byte?> {
        val rv = arrayOfNulls<Byte>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getByteValueInternal(i, subfield)
        }

        return rv
    }

    fun getByteValue(): Byte? {
        return getByteValueInternal(0, null)
    }

    fun getByteValue(fieldArrayIndex: Int): Byte? {
        return getByteValueInternal(fieldArrayIndex, null)
    }

    fun getByteValue(fieldArrayIndex: Int, subFieldIndex: Int): Byte? {
        return getByteValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getByteValue(fieldArrayIndex: Int, subFieldName: String?): Byte? {
        return getByteValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getByteValueInternal(fieldArrayIndex: Int, subField: SubField?): Byte? {
        val value = getValueInternal(fieldArrayIndex, subField) ?: return null
        return numToByte(value)
    }

    fun getShortValues(): Array<Short?> {
        return getShortValues(null as SubField?)
    }

    fun getShortValues(subfieldIndex: Int): Array<Short?> {
        return getShortValues(getSubField(subfieldIndex))
    }

    fun getShortValues(subfieldName: String?): Array<Short?> {
        return getShortValues(getSubField(subfieldName))
    }

    protected fun getShortValues(subfield: SubField?): Array<Short?> {
        val rv = arrayOfNulls<Short>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getShortValueInternal(i, subfield)
        }

        return rv
    }

    fun getShortValue(): Short? {
        return getShortValueInternal(0, null)
    }

    fun getShortValue(fieldArrayIndex: Int): Short? {
        return getShortValueInternal(fieldArrayIndex, null)
    }

    fun getShortValue(fieldArrayIndex: Int, subFieldIndex: Int): Short? {
        return getShortValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getShortValue(fieldArrayIndex: Int, subFieldName: String?): Short? {
        return getShortValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getShortValueInternal(fieldArrayIndex: Int, subField: SubField?): Short? {
        val value = getValueInternal(fieldArrayIndex, subField) ?: return null
        return numToShort(value)
    }

    fun getIntegerValues(): Array<Int?> {
        return getIntegerValues(null as SubField?)
    }

    fun getIntegerValues(subfieldIndex: Int): Array<Int?> {
        return getIntegerValues(getSubField(subfieldIndex))
    }

    fun getIntegerValues(subfieldName: String?): Array<Int?> {
        return getIntegerValues(getSubField(subfieldName))
    }

    protected fun getIntegerValues(subfield: SubField?): Array<Int?> {
        val rv = arrayOfNulls<Int>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getIntegerValueInternal(i, subfield)
        }

        return rv
    }

    fun getIntegerValue(): Int? {
        return getIntegerValueInternal(0, null)
    }

    fun getIntegerValue(fieldArrayIndex: Int): Int? {
        return getIntegerValueInternal(fieldArrayIndex, null)
    }

    fun getIntegerValue(fieldArrayIndex: Int, subFieldIndex: Int): Int? {
        return getIntegerValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getIntegerValue(fieldArrayIndex: Int, subFieldName: String?): Int? {
        return getIntegerValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getIntegerValueInternal(fieldArrayIndex: Int, subField: SubField?): Int? {
        val value = getValueInternal(fieldArrayIndex, subField) ?: return null
        return numToInt(value)
    }

    fun getLongValues(): Array<Long?> {
        return getLongValues(null as SubField?)
    }

    fun getLongValues(subfieldIndex: Int): Array<Long?> {
        return getLongValues(getSubField(subfieldIndex))
    }

    fun getLongValues(subfieldName: String?): Array<Long?> {
        return getLongValues(getSubField(subfieldName))
    }

    protected fun getLongValues(subfield: SubField?): Array<Long?> {
        val rv = arrayOfNulls<Long>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getLongValueInternal(i, subfield)
        }

        return rv
    }

    fun getLongValue(): Long? {
        return getLongValueInternal(0, null)
    }

    fun getLongValue(fieldArrayIndex: Int): Long? {
        return getLongValueInternal(fieldArrayIndex, null)
    }

    fun getLongValue(fieldArrayIndex: Int, subFieldIndex: Int): Long? {
        return getLongValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getLongValue(fieldArrayIndex: Int, subFieldName: String?): Long? {
        return getLongValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getLongValueInternal(fieldArrayIndex: Int, subField: SubField?): Long? {
        val value = getValueInternal(fieldArrayIndex, subField) ?: return null
        return numToLong(value)
    }

    fun getFloatValues(): Array<Float?> {
        return getFloatValues(null as SubField?)
    }

    fun getFloatValues(subfieldIndex: Int): Array<Float?> {
        return getFloatValues(getSubField(subfieldIndex))
    }

    fun getFloatValues(subfieldName: String?): Array<Float?> {
        return getFloatValues(getSubField(subfieldName))
    }

    protected fun getFloatValues(subfield: SubField?): Array<Float?> {
        val rv = arrayOfNulls<Float>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getFloatValueInternal(i, subfield)
        }

        return rv
    }

    fun getFloatValue(): Float? {
        return getFloatValueInternal(0, null)
    }

    fun getFloatValue(fieldArrayIndex: Int): Float? {
        return getFloatValueInternal(fieldArrayIndex, null)
    }

    fun getFloatValue(fieldArrayIndex: Int, subFieldIndex: Int): Float? {
        return getFloatValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getFloatValue(fieldArrayIndex: Int, subFieldName: String?): Float? {
        return getFloatValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getFloatValueInternal(fieldArrayIndex: Int, subField: SubField?): Float? {
        val value = getValueInternal(fieldArrayIndex, subField) ?: return null
        return numToFloat(value)
    }

    fun getDoubleValues(): Array<Double?> {
        return getDoubleValues(null as SubField?)
    }

    fun getDoubleValues(subfieldIndex: Int): Array<Double?> {
        return getDoubleValues(getSubField(subfieldIndex))
    }

    fun getDoubleValues(subfieldName: String?): Array<Double?> {
        return getDoubleValues(getSubField(subfieldName))
    }

    protected fun getDoubleValues(subfield: SubField?): Array<Double?> {
        val rv = arrayOfNulls<Double>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getDoubleValueInternal(i, subfield)
        }

        return rv
    }

    fun getDoubleValue(): Double? {
        return getDoubleValueInternal(0, null)
    }

    fun getDoubleValue(fieldArrayIndex: Int): Double? {
        return getDoubleValueInternal(fieldArrayIndex, null)
    }

    fun getDoubleValue(fieldArrayIndex: Int, subFieldIndex: Int): Double? {
        return getDoubleValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getDoubleValue(fieldArrayIndex: Int, subFieldName: String?): Double? {
        return getDoubleValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getDoubleValueInternal(fieldArrayIndex: Int, subField: SubField?): Double? {
        val value = getValueInternal(fieldArrayIndex, subField) ?: return null
        return numToDouble(value)
    }

    // getULongValue* replaces the Java getBigIntegerValue* family (DESIGN.md §1.4).
    fun getULongValues(): Array<ULong?> {
        return getULongValues(null as SubField?)
    }

    fun getULongValues(subfieldIndex: Int): Array<ULong?> {
        return getULongValues(getSubField(subfieldIndex))
    }

    fun getULongValues(subfieldName: String?): Array<ULong?> {
        return getULongValues(getSubField(subfieldName))
    }

    protected fun getULongValues(subfield: SubField?): Array<ULong?> {
        val rv = arrayOfNulls<ULong>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getULongValueInternal(i, subfield)
        }

        return rv
    }

    fun getULongValue(): ULong? {
        return getULongValueInternal(0, null)
    }

    fun getULongValue(fieldArrayIndex: Int): ULong? {
        return getULongValueInternal(fieldArrayIndex, null)
    }

    fun getULongValue(fieldArrayIndex: Int, subFieldIndex: Int): ULong? {
        return getULongValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getULongValue(fieldArrayIndex: Int, subFieldName: String?): ULong? {
        return getULongValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getULongValueInternal(fieldArrayIndex: Int, subField: SubField?): ULong? {
        val value = getValueInternal(fieldArrayIndex, subField) ?: return null
        // Same strict cast semantics as the Java (BigInteger) cast.
        return value as ULong
    }

    // getBigDecimalValue* kept by name; BigDecimal mapped to Double (DESIGN.md §1.1/§1.4).
    fun getBigDecimalValues(): Array<Double?> {
        return getBigDecimalValues(null as SubField?)
    }

    fun getBigDecimalValues(subfieldIndex: Int): Array<Double?> {
        return getBigDecimalValues(getSubField(subfieldIndex))
    }

    fun getBigDecimalValues(subfieldName: String?): Array<Double?> {
        return getBigDecimalValues(getSubField(subfieldName))
    }

    protected fun getBigDecimalValues(subfield: SubField?): Array<Double?> {
        val rv = arrayOfNulls<Double>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getBigDecimalValueInternal(i, subfield)
        }

        return rv
    }

    fun getBigDecimalValue(): Double? {
        return getBigDecimalValueInternal(0, null)
    }

    fun getBigDecimalValue(fieldArrayIndex: Int): Double? {
        return getBigDecimalValueInternal(fieldArrayIndex, null)
    }

    fun getBigDecimalValue(fieldArrayIndex: Int, subFieldIndex: Int): Double? {
        return getBigDecimalValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getBigDecimalValue(fieldArrayIndex: Int, subFieldName: String?): Double? {
        return getBigDecimalValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getBigDecimalValueInternal(fieldArrayIndex: Int, subField: SubField?): Double? {
        val value = getValueInternal(fieldArrayIndex, subField) ?: return null
        // Java: new BigDecimal(value.toString())
        return value.toString().toDouble()
    }

    fun getStringValues(): Array<String?> {
        return getStringValues(null as SubField?)
    }

    fun getStringValues(subfieldIndex: Int): Array<String?> {
        return getStringValues(getSubField(subfieldIndex))
    }

    fun getStringValues(subfieldName: String?): Array<String?> {
        return getStringValues(getSubField(subfieldName))
    }

    protected fun getStringValues(subfield: SubField?): Array<String?> {
        val rv = arrayOfNulls<String>(getNumValues())

        for (i in 0 until getNumValues()) {
            rv[i] = getStringValueInternal(i, subfield)
        }

        return rv
    }

    fun getStringValue(): String? {
        return getStringValueInternal(0, null)
    }

    fun getStringValue(fieldArrayIndex: Int): String? {
        return getStringValueInternal(fieldArrayIndex, null)
    }

    fun getStringValue(fieldArrayIndex: Int, subFieldIndex: Int): String? {
        return getStringValueInternal(fieldArrayIndex, getSubField(subFieldIndex))
    }

    fun getStringValue(fieldArrayIndex: Int, subFieldName: String?): String? {
        return getStringValueInternal(fieldArrayIndex, getSubField(subFieldName))
    }

    protected fun getStringValueInternal(fieldArrayIndex: Int, subField: SubField?): String? {
        val value = getValueInternal(fieldArrayIndex, subField)
        val type = getTypeInternal(subField)

        if (value == null) {
            return null
        }

        if (!forceShowInvalids && Fit.baseTypeInvalidMap[type] == value) {
            return null
        }

        return value.toString()
    }

    // ---- Big-endian stream helpers (replace java.io.DataInputStream/DataOutputStream) ----

    private fun readUByte(ins: InputStream): Int {
        val b = ins.read()
        if (b < 0) {
            throw IOException("Unexpected end of stream")
        }
        return b
    }

    private fun readIntBE(ins: InputStream): Int {
        var v = 0
        for (i in 0 until 4) {
            v = (v shl 8) or readUByte(ins)
        }
        return v
    }

    private fun readLongBE(ins: InputStream): Long {
        var v = 0L
        for (i in 0 until 8) {
            v = (v shl 8) or readUByte(ins).toLong()
        }
        return v
    }

    private fun writeShortBE(out: OutputStream, v: Int) {
        out.write(v ushr 8)
        out.write(v)
    }

    private fun writeIntBE(out: OutputStream, v: Int) {
        out.write(v ushr 24)
        out.write(v ushr 16)
        out.write(v ushr 8)
        out.write(v)
    }

    private fun writeLongBE(out: OutputStream, v: Long) {
        for (i in 7 downTo 0) {
            out.write((v ushr (8 * i)).toInt())
        }
    }

    private fun writeULongBytesBE(out: OutputStream, v: ULong, size: Int) {
        for (i in 0 until size) {
            out.write(((v shr (8 * (size - 1 - i))) and 0xFFu).toInt())
        }
    }

    // package-private in Java; all multi-byte data is big-endian on this stream
    // (Decode re-orders little-endian input before calling read()).
    internal fun read(ins: InputStream, size: Int): Boolean {
        try {
            if (getType() == Fit.BASE_TYPE_STRING) {
                try {
                    val bytes = ByteArray(size)
                    ins.read(bytes, 0, size)

                    // Java used a CharsetDecoder ignoring malformed input; decodeToString()
                    // substitutes U+FFFD instead (accepted, DESIGN.md §2.3).
                    val decoded = bytes.decodeToString()
                    // Java String.split drops trailing empty strings.
                    val strings = decoded.split('\u0000').dropLastWhile { it.isEmpty() }
                    for (string in strings) {
                        values.add(string)
                    }
                } catch (e: IOException) {
                    return true
                }
            } else {
                var bytesLeft = size
                var invalid = true

                val type = getType()
                val baseTypeSize = Fit.baseTypeSizes[type and Fit.BASE_TYPE_NUM_MASK]
                val invalidValue = Fit.baseTypeInvalidMap[type]

                while (bytesLeft > 0) {
                    val value: Any
                    when (type) {
                        Fit.BASE_TYPE_ENUM,
                        Fit.BASE_TYPE_UINT8,
                        Fit.BASE_TYPE_UINT8Z -> {
                            value = readUByte(ins).toShort()
                        }

                        Fit.BASE_TYPE_SINT8 -> {
                            value = readUByte(ins).toByte()
                        }

                        Fit.BASE_TYPE_SINT16 -> {
                            value = ((readUByte(ins) shl 8) or readUByte(ins)).toShort()
                        }

                        Fit.BASE_TYPE_UINT16,
                        Fit.BASE_TYPE_UINT16Z -> {
                            value = (readUByte(ins) shl 8) or readUByte(ins)
                        }

                        Fit.BASE_TYPE_SINT32 -> {
                            value = readIntBE(ins)
                        }

                        Fit.BASE_TYPE_UINT32,
                        Fit.BASE_TYPE_UINT32Z,
                        Fit.BASE_TYPE_SINT64 -> {
                            var v = readUByte(ins).toLong()
                            for (i in 1 until baseTypeSize) {
                                v = (v shl 8) or readUByte(ins).toLong()
                            }
                            value = v
                        }

                        Fit.BASE_TYPE_FLOAT32 -> {
                            value = Float.fromBits(readIntBE(ins))
                        }

                        Fit.BASE_TYPE_FLOAT64 -> {
                            value = Double.fromBits(readLongBE(ins))
                        }

                        Fit.BASE_TYPE_BYTE -> {
                            value = readUByte(ins).toShort()
                        }

                        Fit.BASE_TYPE_UINT64,
                        Fit.BASE_TYPE_UINT64Z -> {
                            var v = 0uL
                            for (i in 0 until baseTypeSize) {
                                v = (v shl 8) or readUByte(ins).toULong()
                            }
                            value = v
                        }

                        else ->
                            return false
                    }

                    values.add(value)

                    if (value != invalidValue) {
                        invalid = false
                    }

                    bytesLeft -= Fit.baseTypeSizes[getType() and Fit.BASE_TYPE_NUM_MASK]
                }

                if (invalid && !forceShowInvalids) {
                    values.clear()
                }
            }
        } catch (e: IOException) {
            return false
        }

        return true
    }

    // protected in Java; internal because Mesg (same package, not a subclass) calls it.
    internal fun write(out: OutputStream, fieldDef: FieldDefinitionBase) {
        var bytesLeft = fieldDef.getSize() - getSize()

        write(out)

        // Fill remaining bytes with invalid.
        while (bytesLeft > 0) {
            writeValue(out, null)
            bytesLeft -= Fit.baseTypeSizes[getType() and Fit.BASE_TYPE_NUM_MASK]
        }
    }

    internal fun write(out: OutputStream) {
        for (value in values) {
            writeValue(out, value)
        }
    }

    private fun writeValue(out: OutputStream, value: Any?) {
        try {
            val data = DataOutputStream(out)

            if (value == null) {
                when (getType()) {
                    Fit.BASE_TYPE_ENUM ->
                        data.writeByte(Fit.ENUM_INVALID.toInt())
                    Fit.BASE_TYPE_UINT8 ->
                        data.writeByte(Fit.UINT8_INVALID.toInt())
                    Fit.BASE_TYPE_UINT8Z ->
                        data.writeByte(Fit.UINT8Z_INVALID.toInt())
                    Fit.BASE_TYPE_SINT8 ->
                        data.writeByte(Fit.SINT8_INVALID.toInt())
                    Fit.BASE_TYPE_BYTE ->
                        data.writeByte(Fit.BYTE_INVALID.toInt())
                    Fit.BASE_TYPE_SINT16 ->
                        writeShortBE(out, Fit.SINT16_INVALID.toInt())
                    Fit.BASE_TYPE_UINT16 ->
                        writeShortBE(out, Fit.UINT16_INVALID)
                    Fit.BASE_TYPE_UINT16Z ->
                        writeShortBE(out, Fit.UINT16Z_INVALID)
                    Fit.BASE_TYPE_SINT32 ->
                        writeIntBE(out, Fit.SINT32_INVALID)
                    Fit.BASE_TYPE_UINT32 ->
                        writeIntBE(out, Fit.UINT32_INVALID.toInt())
                    Fit.BASE_TYPE_UINT32Z ->
                        writeIntBE(out, Fit.UINT32Z_INVALID.toInt())
                    Fit.BASE_TYPE_SINT64 ->
                        writeLongBE(out, Fit.SINT64_INVALID)
                    Fit.BASE_TYPE_UINT64 ->
                        writeULongBytesBE(out, Fit.UINT64_INVALID, Fit.baseTypeSizes[getType() and Fit.BASE_TYPE_NUM_MASK])
                    Fit.BASE_TYPE_UINT64Z ->
                        writeULongBytesBE(out, Fit.UINT64Z_INVALID, Fit.baseTypeSizes[getType() and Fit.BASE_TYPE_NUM_MASK])
                    Fit.BASE_TYPE_STRING ->
                        data.writeByte(0)
                    Fit.BASE_TYPE_FLOAT32 ->
                        writeIntBE(out, Fit.FLOAT32_INVALID.toBits())
                    Fit.BASE_TYPE_FLOAT64 ->
                        writeLongBE(out, Fit.FLOAT64_INVALID.toBits())
                    else -> {}
                }
            } else { // if (value != null)
                when (getType()) {
                    Fit.BASE_TYPE_ENUM,
                    Fit.BASE_TYPE_UINT8,
                    Fit.BASE_TYPE_UINT8Z,
                    Fit.BASE_TYPE_SINT8,
                    Fit.BASE_TYPE_BYTE -> {
                        if (value is String) {
                            println("Field.write(): Field ${getFieldName()} value should not be string value $value")
                        }
                        data.writeByte(numToDouble(value).roundToLong().toInt())
                    }

                    Fit.BASE_TYPE_SINT16,
                    Fit.BASE_TYPE_UINT16,
                    Fit.BASE_TYPE_UINT16Z -> {
                        writeShortBE(out, numToDouble(value).roundToLong().toInt())
                    }

                    Fit.BASE_TYPE_SINT32,
                    Fit.BASE_TYPE_UINT32,
                    Fit.BASE_TYPE_UINT32Z -> {
                        writeIntBE(out, numToDouble(value).roundToLong().toInt())
                    }

                    Fit.BASE_TYPE_STRING -> {
                        out.write(value.toString().encodeToByteArray())
                        out.write(0)
                    }

                    Fit.BASE_TYPE_FLOAT32 -> {
                        writeIntBE(out, numToFloat(value).toBits())
                    }

                    Fit.BASE_TYPE_FLOAT64 -> {
                        writeLongBE(out, numToDouble(value).toBits())
                    }

                    Fit.BASE_TYPE_SINT64,
                    Fit.BASE_TYPE_UINT64,
                    Fit.BASE_TYPE_UINT64Z -> {
                        // Java: new BigDecimal(value.toString()).toBigInteger() then per-byte shift.
                        val bits: ULong = when (value) {
                            is ULong -> value
                            is Number -> value.toLong().toULong()
                            else -> value.toString().toDouble().toLong().toULong()
                        }
                        val size = Fit.baseTypeSizes[getType() and Fit.BASE_TYPE_NUM_MASK]
                        writeULongBytesBE(out, bits, size)
                    }

                    else -> {}
                }
            } // if (value != null)
        } catch (e: IOException) {
        }
    }
}
