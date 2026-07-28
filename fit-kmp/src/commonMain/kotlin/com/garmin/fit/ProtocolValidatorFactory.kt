// Hand-written multiplatform port of ProtocolValidatorFactory.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

object ProtocolValidatorFactory {

    /**
     * Factory method to create a ProtocolValidator object
     *
     * @param protocolVersion the protocol version
     * @return a ProtocolValidator object
     */
    internal fun getProtocolValidator(protocolVersion: Fit.ProtocolVersion): ProtocolValidator {
        return when (protocolVersion) {
            Fit.ProtocolVersion.V1_0 -> V1Validator()
            else -> V2Validator()
        }
    }
}

internal class V1Validator : ProtocolValidator {

    private fun hasDeveloperData(defn: MesgDefinition): Boolean {
        return defn.developerFields.size > 0
    }

    override fun validateMesgDefn(mesgDefinition: MesgDefinition): Boolean {
        if (hasDeveloperData(mesgDefinition)) {
            return false
        }

        for (def in mesgDefinition.getFields()) {
            val typeNum = def.getType() and Fit.BASE_TYPE_NUM_MASK
            if (typeNum > Fit.BASE_TYPE_BYTE) {
                // Byte was the last type added to 1.0
                return false
            }
        }

        return true
    }

    override fun validateMesg(mesg: Mesg): Boolean {
        if (hasDeveloperData(MesgDefinition(mesg))) {
            return false
        }

        for (fld in mesg.getFields()) {
            val typeNum = fld.getType() and Fit.BASE_TYPE_NUM_MASK
            if (typeNum > Fit.BASE_TYPE_BYTE) {
                // Byte was the last type added to 1.0
                return false
            }
        }

        return true
    }
}

internal class V2Validator : ProtocolValidator {

    override fun validateMesgDefn(defn: MesgDefinition): Boolean {
        return true
    }

    override fun validateMesg(mesg: Mesg): Boolean {
        return true
    }
}
