/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ChronoShotSessionMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class ChronoShotSessionMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val MinSpeedFieldNum = 0
        const val MaxSpeedFieldNum = 1
        const val AvgSpeedFieldNum = 2
        const val ShotCountFieldNum = 3
        const val ProjectileTypeFieldNum = 4
        const val GrainWeightFieldNum = 5
        const val StandardDeviationFieldNum = 6

        val chronoShotSessionMesg: Mesg = run {
            // chrono_shot_session
            val chronoShotSessionMesg = Mesg("chrono_shot_session", MesgNum.CHRONO_SHOT_SESSION)
            chronoShotSessionMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            chronoShotSessionMesg.addField(Field("min_speed", MinSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            chronoShotSessionMesg.addField(Field("max_speed", MaxSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            chronoShotSessionMesg.addField(Field("avg_speed", AvgSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            chronoShotSessionMesg.addField(Field("shot_count", ShotCountFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            chronoShotSessionMesg.addField(Field("projectile_type", ProjectileTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.PROJECTILE_TYPE))
            chronoShotSessionMesg.addField(Field("grain_weight", GrainWeightFieldNum, 134, 10.0, 0.0, "gr", false, Profile.Type.UINT32))
            chronoShotSessionMesg.addField(Field("standard_deviation", StandardDeviationFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            chronoShotSessionMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.CHRONO_SHOT_SESSION))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     *
     * @return timestamp
     */
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get min_speed field
     * Units: m/s
     *
     * @return min_speed
     */
    var minSpeed: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(minSpeed) {
            setFieldValue(0, 0, minSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_speed field
     * Units: m/s
     *
     * @return max_speed
     */
    var maxSpeed: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxSpeed) {
            setFieldValue(1, 0, maxSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_speed field
     * Units: m/s
     *
     * @return avg_speed
     */
    var avgSpeed: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgSpeed) {
            setFieldValue(2, 0, avgSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get shot_count field
     *
     * @return shot_count
     */
    var shotCount: Int?
        get() {
            return getFieldIntegerValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(shotCount) {
            setFieldValue(3, 0, shotCount, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get projectile_type field
     *
     * @return projectile_type
     */
    var projectileType: ProjectileType?
        get() {
            val value = getFieldShortValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return ProjectileType.fromValue(value)
        }
        set(projectileType) {
            setFieldValue(4, 0, projectileType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get grain_weight field
     * Units: gr
     *
     * @return grain_weight
     */
    var grainWeight: Float?
        get() {
            return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(grainWeight) {
            setFieldValue(5, 0, grainWeight, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get standard_deviation field
     * Units: m/s
     *
     * @return standard_deviation
     */
    var standardDeviation: Float?
        get() {
            return getFieldFloatValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(standardDeviation) {
            setFieldValue(6, 0, standardDeviation, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
