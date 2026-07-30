/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TrainingSettingsMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class TrainingSettingsMesg : Mesg {

    companion object {
        const val TargetDistanceFieldNum = 31
        const val TargetSpeedFieldNum = 32
        const val TargetTimeFieldNum = 33
        const val PreciseTargetSpeedFieldNum = 153

        val trainingSettingsMesg: Mesg = run {
            // training_settings
            val trainingSettingsMesg = Mesg("training_settings", MesgNum.TRAINING_SETTINGS)
            trainingSettingsMesg.addField(Field("target_distance", TargetDistanceFieldNum, 134, 100.0, 0.0, "m", false, Profile.Type.UINT32))
            trainingSettingsMesg.addField(Field("target_speed", TargetSpeedFieldNum, 132, 1000.0, 0.0, "m/s", false, Profile.Type.UINT16))
            trainingSettingsMesg.addField(Field("target_time", TargetTimeFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            trainingSettingsMesg.addField(Field("precise_target_speed", PreciseTargetSpeedFieldNum, 134, 1000000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            trainingSettingsMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.TRAINING_SETTINGS))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get target_distance field
     * Units: m
     *
     * @return target_distance
     */
    var targetDistance: Float?
        get() {
            return getFieldFloatValue(31, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(targetDistance) {
            setFieldValue(31, 0, targetDistance, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get target_speed field
     * Units: m/s
     *
     * @return target_speed
     */
    var targetSpeed: Float?
        get() {
            return getFieldFloatValue(32, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(targetSpeed) {
            setFieldValue(32, 0, targetSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get target_time field
     * Units: s
     *
     * @return target_time
     */
    var targetTime: Long?
        get() {
            return getFieldLongValue(33, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(targetTime) {
            setFieldValue(33, 0, targetTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get precise_target_speed field
     * Units: m/s
     * Comment: A more precise target speed field
     *
     * @return precise_target_speed
     */
    var preciseTargetSpeed: Float?
        get() {
            return getFieldFloatValue(153, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(preciseTargetSpeed) {
            setFieldValue(153, 0, preciseTargetSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
