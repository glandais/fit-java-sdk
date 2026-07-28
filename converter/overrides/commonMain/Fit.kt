// Hand-written multiplatform port of Fit.java — keep in sync (see overrides/hashes.json).
// UINT64 values use ULong instead of java.math.BigInteger (DESIGN.md §1.4).
package com.garmin.fit

object Fit {
    var debug = false

    enum class ProtocolVersion(private val major: Int, private val minor: Int) {
        V1_0(1, 0),
        V2_0(2, 0);

        fun getVersion(): Int {
            return (major shl Fit.PROTOCOL_VERSION_MAJOR_SHIFT) or minor
        }

        fun getMajor(): Int {
            return major
        }

        fun getMinor(): Int {
            return minor
        }

        companion object {
            fun getHighestVersion(): ProtocolVersion {
                return V2_0
            }
        }
    }

    const val PROTOCOL_VERSION_MAJOR_SHIFT = 4
    val PROTOCOL_VERSION: Int = ProtocolVersion.getHighestVersion().getVersion()
    val PROTOCOL_VERSION_MAJOR_MASK: Int = (0x0F shl PROTOCOL_VERSION_MAJOR_SHIFT)
    const val PROTOCOL_VERSION_MINOR_MASK = 0x0F
    val PROTOCOL_VERSION_MAJOR: Int = ProtocolVersion.getHighestVersion().getMajor()
    val PROTOCOL_VERSION_MINOR: Int = ProtocolVersion.getHighestVersion().getMinor()

    const val PROFILE_VERSION_MAJOR = 21
    const val PROFILE_VERSION_MINOR = 205
    const val PROFILE_TYPE = "Release"
    const val PROFILE_VERSION_SCALE = 1000
    const val PROFILE_VERSION = PROFILE_VERSION_MAJOR * PROFILE_VERSION_SCALE + PROFILE_VERSION_MINOR

    const val ANTFS_FILE_DATA_TYPE = 128

    const val FILE_HDR_SIZE = 14

    const val HDR_SIZE = 1
    const val HDR_TIME_REC_BIT = 0x80
    const val HDR_TIME_TYPE_MASK = 0x60
    const val HDR_TIME_TYPE_SHIFT = 5
    const val HDR_TIME_OFFSET_MASK = 0x1F
    const val HDR_TYPE_DEF_BIT = 0x40
    const val HDR_DEV_FIELDS_BIT = 0x20
    const val HDR_TYPE_MASK = 0x0F
    const val MAX_LOCAL_MESGS = HDR_TYPE_MASK + 1

    const val CRC_SIZE = 2

    const val MAX_MESG_SIZE = 65535

    const val ARCH_ENDIAN_MASK = 0x01
    const val ARCH_ENDIAN_LITTLE = 0
    const val ARCH_ENDIAN_BIG = 1

    const val MAX_FIELD_SIZE = 255

    const val FIELD_NUM_INVALID = 255
    const val FIELD_NUM_MESSAGE_INDEX = 254
    const val FIELD_NUM_TIMESTAMP = 253
    const val FIELD_DEFAULT_SCALE = 1
    const val FIELD_DEFAULT_OFFSET = 0

    const val SUBFIELD_INDEX_ACTIVE_SUBFIELD = 65534
    const val SUBFIELD_INDEX_MAIN_FIELD = 65535
    const val SUBFIELD_NAME_MAIN_FIELD = ""

    const val BASE_TYPE_ENDIAN_FLAG = 0x80
    const val BASE_TYPE_RESERVED = 0x60
    const val BASE_TYPE_NUM_MASK = 0x1F

    val ENUM_MAX: Short = 0xFF.toShort()
    val ENUM_MIN: Short = 0x00.toShort()
    val ENUM_INVALID: Short = 0xFF.toShort()
    const val BASE_TYPE_ENUM = 0x00

    val SINT8_MAX: Byte = Byte.MAX_VALUE
    val SINT8_MIN: Byte = Byte.MIN_VALUE
    val SINT8_INVALID: Byte = 0x7F.toByte()
    const val BASE_TYPE_SINT8 = 0x01

    val UINT8_MAX: Short = 0xFF.toShort()
    val UINT8_MIN: Short = 0x00.toShort()
    val UINT8_INVALID: Short = 0xFF.toShort()
    const val BASE_TYPE_UINT8 = 0x02

    val SINT16_MAX: Short = Short.MAX_VALUE
    val SINT16_MIN: Short = Short.MIN_VALUE
    val SINT16_INVALID: Short = 0x7FFF.toShort()
    const val BASE_TYPE_SINT16 = 0x83

    const val UINT16_MAX: Int = 0xFFFF
    const val UINT16_MIN: Int = 0
    const val UINT16_INVALID: Int = 0xFFFF
    const val BASE_TYPE_UINT16 = 0x84

    const val SINT32_MAX: Int = Int.MAX_VALUE
    const val SINT32_MIN: Int = Int.MIN_VALUE
    const val SINT32_INVALID: Int = 0x7FFFFFFF
    const val BASE_TYPE_SINT32 = 0x85

    const val UINT32_MAX: Long = 0xFFFFFFFFL
    const val UINT32_MIN: Long = 0L
    const val UINT32_INVALID: Long = 0xFFFFFFFFL
    const val BASE_TYPE_UINT32 = 0x86

    const val STRING_INVALID = ""
    const val BASE_TYPE_STRING = 0x07
    const val STRING_MAX_BYTE_COUNT = MAX_FIELD_SIZE - 1 // Reserve 1 byte for the null terminator that is appended to all strings during encoding

    val FLOAT32_INVALID: Float = Float.fromBits(-1) // bit pattern 0xFFFFFFFF
    val FLOAT32_MAX: Float = Float.MAX_VALUE
    val FLOAT32_MIN: Float = -Float.MAX_VALUE
    const val BASE_TYPE_FLOAT32 = 0x88

    val FLOAT64_INVALID: Double = Double.fromBits(-1L) // bit pattern 0xFFFFFFFFFFFFFFFF
    val FLOAT64_MAX: Double = Double.MAX_VALUE
    val FLOAT64_MIN: Double = -Double.MAX_VALUE
    const val BASE_TYPE_FLOAT64 = 0x89

    val UINT8Z_MAX: Short = 0xFF.toShort()
    val UINT8Z_MIN: Short = 0x00.toShort()
    val UINT8Z_INVALID: Short = 0x00.toShort()
    const val BASE_TYPE_UINT8Z = 0x0A

    const val UINT16Z_MAX: Int = 0xFFFF
    const val UINT16Z_MIN: Int = 0
    const val UINT16Z_INVALID: Int = 0x0000
    const val BASE_TYPE_UINT16Z = 0x8B

    const val UINT32Z_MAX: Long = 0xFFFFFFFFL
    const val UINT32Z_MIN: Long = 0L
    const val UINT32Z_INVALID: Long = 0x00000000L
    const val BASE_TYPE_UINT32Z = 0x8C

    val BYTE_MAX: Short = 0xFF.toShort()
    val BYTE_MIN: Short = 0x00.toShort()
    val BYTE_INVALID: Short = 0xFF.toShort()
    const val BASE_TYPE_BYTE = 0x0D

    const val SINT64_MAX: Long = Long.MAX_VALUE
    const val SINT64_MIN: Long = Long.MIN_VALUE
    const val SINT64_INVALID: Long = 0x7FFFFFFFFFFFFFFFL
    const val BASE_TYPE_SINT64 = 0x8E

    val UINT64_MAX: ULong = 0xFFFFFFFFFFFFFFFFuL
    val UINT64_MIN: ULong = 0uL
    val UINT64_INVALID: ULong = 0xFFFFFFFFFFFFFFFFuL
    const val BASE_TYPE_UINT64 = 0x8F

    val UINT64Z_MAX: ULong = 0xFFFFFFFFFFFFFFFFuL
    val UINT64Z_MIN: ULong = 0uL
    val UINT64Z_INVALID: ULong = 0uL
    const val BASE_TYPE_UINT64Z = 0x90
    const val BASE_TYPES = 17

    val baseTypeSizes: IntArray = intArrayOf(1, 1, 1, 2, 2, 4, 4, 1, 4, 8, 1, 2, 4, 1, 8, 8, 8)

    val UTF8_BOM_BYTE_1: Byte = 0xEF.toByte()
    val UTF8_BOM_BYTE_2: Byte = 0xBB.toByte()
    val UTF8_BOM_BYTE_3: Byte = 0xBF.toByte()
    val UTF8_BOM_BYTES: ByteArray = byteArrayOf(UTF8_BOM_BYTE_1, UTF8_BOM_BYTE_2, UTF8_BOM_BYTE_3)
    const val UTF8_NUM_BOM_BYTES = 3
    const val UTF8_BOM: Char = '\uFEFF'

    // This flag enables deprecated behaviour in the SDK.
    //
    // As of 16.10:
    //
    //    If a get method is used on a field containing invalid
    //    values, null is returned. When disabled, an appropriate
    //    invalid value is returned instead.
    const val ENABLE_LEGACY_BEHAVIOUR = true

    val baseTypeInvalidMap: HashMap<Int, Any> = HashMap<Int, Any>(20).apply {
        put(BASE_TYPE_ENUM, ENUM_INVALID)
        put(BASE_TYPE_SINT8, SINT8_INVALID)
        put(BASE_TYPE_UINT8, UINT8_INVALID)
        put(BASE_TYPE_SINT16, SINT16_INVALID)
        put(BASE_TYPE_UINT16, UINT16_INVALID)
        put(BASE_TYPE_SINT32, SINT32_INVALID)
        put(BASE_TYPE_UINT32, UINT32_INVALID)
        put(BASE_TYPE_STRING, STRING_INVALID)
        put(BASE_TYPE_FLOAT32, FLOAT32_INVALID)
        put(BASE_TYPE_FLOAT64, FLOAT64_INVALID)
        put(BASE_TYPE_UINT8Z, UINT8Z_INVALID)
        put(BASE_TYPE_UINT16Z, UINT16Z_INVALID)
        put(BASE_TYPE_UINT32Z, UINT32Z_INVALID)
        put(BASE_TYPE_BYTE, BYTE_INVALID)
        put(BASE_TYPE_SINT64, SINT64_INVALID)
        put(BASE_TYPE_UINT64, UINT64_INVALID)
        put(BASE_TYPE_UINT64Z, UINT64Z_INVALID)
    }

    val baseTypeMinMap: HashMap<Int, Any> = HashMap<Int, Any>(20).apply {
        put(BASE_TYPE_ENUM, ENUM_MIN)
        put(BASE_TYPE_SINT8, SINT8_MIN)
        put(BASE_TYPE_UINT8, UINT8_MIN)
        put(BASE_TYPE_SINT16, SINT16_MIN)
        put(BASE_TYPE_UINT16, UINT16_MIN)
        put(BASE_TYPE_SINT32, SINT32_MIN)
        put(BASE_TYPE_UINT32, UINT32_MIN)
        put(BASE_TYPE_FLOAT32, FLOAT32_MIN)
        put(BASE_TYPE_FLOAT64, FLOAT64_MIN)
        put(BASE_TYPE_UINT8Z, UINT8Z_MIN)
        put(BASE_TYPE_UINT16Z, UINT16Z_MIN)
        put(BASE_TYPE_UINT32Z, UINT32Z_MIN)
        put(BASE_TYPE_BYTE, BYTE_MIN)
        put(BASE_TYPE_SINT64, SINT64_MIN)
        put(BASE_TYPE_UINT64, UINT64_MIN)
        put(BASE_TYPE_UINT64Z, UINT64Z_MIN)
    }

    val baseTypeMaxMap: HashMap<Int, Any> = HashMap<Int, Any>(20).apply {
        put(BASE_TYPE_ENUM, ENUM_MAX)
        put(BASE_TYPE_SINT8, SINT8_MAX)
        put(BASE_TYPE_UINT8, UINT8_MAX)
        put(BASE_TYPE_SINT16, SINT16_MAX)
        put(BASE_TYPE_UINT16, UINT16_MAX)
        put(BASE_TYPE_SINT32, SINT32_MAX)
        put(BASE_TYPE_UINT32, UINT32_MAX)
        //put(BASE_TYPE_STRING, STRING_MAX)
        put(BASE_TYPE_FLOAT32, FLOAT32_MAX)
        put(BASE_TYPE_FLOAT64, FLOAT64_MAX)
        put(BASE_TYPE_UINT8Z, UINT8Z_MAX)
        put(BASE_TYPE_UINT16Z, UINT16Z_MAX)
        put(BASE_TYPE_UINT32Z, UINT32Z_MAX)
        put(BASE_TYPE_BYTE, BYTE_MAX)
        put(BASE_TYPE_SINT64, SINT64_MAX)
        put(BASE_TYPE_UINT64, UINT64_MAX)
        put(BASE_TYPE_UINT64Z, UINT64Z_MAX)
    }
}
