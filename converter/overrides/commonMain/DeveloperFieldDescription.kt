// Hand-written multiplatform port of DeveloperFieldDescription.java — keep in sync (see overrides/hashes.json).
// java.util.UUID replaced by Uuid (DESIGN.md §2.4).
package com.garmin.fit

/**
 * Description of a Developer Field
 */
class DeveloperFieldDescription internal constructor(
    private val developerId: DeveloperDataIdMesg,
    private val fieldDescription: FieldDescriptionMesg
) {

    /**
     * Retrieves the Application Version of the generating Field
     * @return 0xFFFF if there is no version encoded in the file
     */
    fun getApplicationVersion(): Long {
        val applicationVer = developerId.getApplicationVersion()
        if (applicationVer == null) {
            return 0xFFFFL
        }

        return applicationVer
    }

    /**
     * Retrieves the Application Id of the generating Field
     * @return Application Id or `null` if there is no valid Application Id for the description
     */
    fun getApplicationId(): Uuid? {
        val appId = developerId.getApplicationId()
        if (appId == null || appId.size != 16) {
            return null
        }

        val primitiveId = ByteArray(appId.size)

        for (i in appId.indices) {
            val b = appId[i]
            if (b != null) {
                primitiveId[i] = b
            } else {
                primitiveId[i] = 0xFF.toByte()
            }
        }

        return Uuid.fromBytes(primitiveId)
    }

    /**
     * Retrieves the Field Definition Number of the generating Field
     * @return Field Definition Number
     */
    fun getFieldDefinitionNumber(): Short {
        val num = fieldDescription.getFieldDefinitionNumber()
        if (num == null) {
            return 0xFF.toShort()
        }

        return num
    }
}
