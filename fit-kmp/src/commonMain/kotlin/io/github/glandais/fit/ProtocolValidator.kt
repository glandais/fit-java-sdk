// Hand-written multiplatform port of ProtocolValidator.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

internal interface ProtocolValidator {
    /**
     * Validate if a Message is compatible with the version
     * @param mesg Message to validate
     * @return true if message is compatible false otherwise
     */
    fun validateMesg(mesg: Mesg): Boolean

    /**
     * Validate if a Message Definition is compatible with the version
     * @param defn Definition
     * @return true if Definition is compatible false otherwise
     */
    fun validateMesgDefn(defn: MesgDefinition): Boolean
}
