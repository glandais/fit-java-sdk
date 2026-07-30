/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from FileCreatorMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class FileCreatorMesg : Mesg {

    companion object {
        const val SoftwareVersionFieldNum = 0
        const val HardwareVersionFieldNum = 1

        val fileCreatorMesg: Mesg = run {
            // file_creator
            val fileCreatorMesg = Mesg("file_creator", MesgNum.FILE_CREATOR)
            fileCreatorMesg.addField(Field("software_version", SoftwareVersionFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            fileCreatorMesg.addField(Field("hardware_version", HardwareVersionFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            fileCreatorMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.FILE_CREATOR))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get software_version field
     *
     * @return software_version
     */
    var softwareVersion: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(softwareVersion) {
            setFieldValue(0, 0, softwareVersion, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get hardware_version field
     *
     * @return hardware_version
     */
    var hardwareVersion: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(hardwareVersion) {
            setFieldValue(1, 0, hardwareVersion, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
