/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from AviationAttitudeMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class AviationAttitudeMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val SystemTimeFieldNum = 1
        const val PitchFieldNum = 2
        const val RollFieldNum = 3
        const val AccelLateralFieldNum = 4
        const val AccelNormalFieldNum = 5
        const val TurnRateFieldNum = 6
        const val StageFieldNum = 7
        const val AttitudeStageCompleteFieldNum = 8
        const val TrackFieldNum = 9
        const val ValidityFieldNum = 10

        val aviationAttitudeMesg: Mesg = run {
            // aviation_attitude
            val aviationAttitudeMesg = Mesg("aviation_attitude", MesgNum.AVIATION_ATTITUDE)
            aviationAttitudeMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            aviationAttitudeMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            aviationAttitudeMesg.addField(Field("system_time", SystemTimeFieldNum, 134, 1.0, 0.0, "ms", false, Profile.Type.UINT32))
            aviationAttitudeMesg.addField(Field("pitch", PitchFieldNum, 131, 10430.38, 0.0, "radians", false, Profile.Type.SINT16))
            aviationAttitudeMesg.addField(Field("roll", RollFieldNum, 131, 10430.38, 0.0, "radians", false, Profile.Type.SINT16))
            aviationAttitudeMesg.addField(Field("accel_lateral", AccelLateralFieldNum, 131, 100.0, 0.0, "m/s^2", false, Profile.Type.SINT16))
            aviationAttitudeMesg.addField(Field("accel_normal", AccelNormalFieldNum, 131, 100.0, 0.0, "m/s^2", false, Profile.Type.SINT16))
            aviationAttitudeMesg.addField(Field("turn_rate", TurnRateFieldNum, 131, 1024.0, 0.0, "radians/second", false, Profile.Type.SINT16))
            aviationAttitudeMesg.addField(Field("stage", StageFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.ATTITUDE_STAGE))
            aviationAttitudeMesg.addField(Field("attitude_stage_complete", AttitudeStageCompleteFieldNum, 2, 1.0, 0.0, "%", false, Profile.Type.UINT8))
            aviationAttitudeMesg.addField(Field("track", TrackFieldNum, 132, 10430.38, 0.0, "radians", false, Profile.Type.UINT16))
            aviationAttitudeMesg.addField(Field("validity", ValidityFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.ATTITUDE_VALIDITY))
            aviationAttitudeMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.AVIATION_ATTITUDE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Timestamp message was output
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Timestamp message was output
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Fractional part of timestamp, added to timestamp
     *
     * @return timestamp_ms
     */
    fun getTimestampMs(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Fractional part of timestamp, added to timestamp
     *
     * @param timestampMs The new timestampMs value to be set
     */
    fun setTimestampMs(timestampMs: Int?) {
        setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getSystemTime(): Array<Long?>? {
        return getFieldLongValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of system_time
     */
    fun getNumSystemTime(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get system_time field
     * Units: ms
     * Comment: System time associated with sample expressed in ms.
     *
     * @param index of system_time
     * @return system_time
     */
    fun getSystemTime(index: Int): Long? {
        return getFieldLongValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set system_time field
     * Units: ms
     * Comment: System time associated with sample expressed in ms.
     *
     * @param index of system_time
     * @param systemTime The new systemTime value to be set
     */
    fun setSystemTime(index: Int, systemTime: Long?) {
        setFieldValue(1, index, systemTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getPitch(): Array<Float?>? {
        return getFieldFloatValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of pitch
     */
    fun getNumPitch(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get pitch field
     * Units: radians
     * Comment: Range -PI/2 to +PI/2
     *
     * @param index of pitch
     * @return pitch
     */
    fun getPitch(index: Int): Float? {
        return getFieldFloatValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set pitch field
     * Units: radians
     * Comment: Range -PI/2 to +PI/2
     *
     * @param index of pitch
     * @param pitch The new pitch value to be set
     */
    fun setPitch(index: Int, pitch: Float?) {
        setFieldValue(2, index, pitch, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getRoll(): Array<Float?>? {
        return getFieldFloatValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of roll
     */
    fun getNumRoll(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get roll field
     * Units: radians
     * Comment: Range -PI to +PI
     *
     * @param index of roll
     * @return roll
     */
    fun getRoll(index: Int): Float? {
        return getFieldFloatValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set roll field
     * Units: radians
     * Comment: Range -PI to +PI
     *
     * @param index of roll
     * @param roll The new roll value to be set
     */
    fun setRoll(index: Int, roll: Float?) {
        setFieldValue(3, index, roll, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAccelLateral(): Array<Float?>? {
        return getFieldFloatValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of accel_lateral
     */
    fun getNumAccelLateral(): Int {
        return getNumFieldValues(4, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_lateral field
     * Units: m/s^2
     * Comment: Range -78.4 to +78.4 (-8 Gs to 8 Gs)
     *
     * @param index of accel_lateral
     * @return accel_lateral
     */
    fun getAccelLateral(index: Int): Float? {
        return getFieldFloatValue(4, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accel_lateral field
     * Units: m/s^2
     * Comment: Range -78.4 to +78.4 (-8 Gs to 8 Gs)
     *
     * @param index of accel_lateral
     * @param accelLateral The new accelLateral value to be set
     */
    fun setAccelLateral(index: Int, accelLateral: Float?) {
        setFieldValue(4, index, accelLateral, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAccelNormal(): Array<Float?>? {
        return getFieldFloatValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of accel_normal
     */
    fun getNumAccelNormal(): Int {
        return getNumFieldValues(5, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get accel_normal field
     * Units: m/s^2
     * Comment: Range -78.4 to +78.4 (-8 Gs to 8 Gs)
     *
     * @param index of accel_normal
     * @return accel_normal
     */
    fun getAccelNormal(index: Int): Float? {
        return getFieldFloatValue(5, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set accel_normal field
     * Units: m/s^2
     * Comment: Range -78.4 to +78.4 (-8 Gs to 8 Gs)
     *
     * @param index of accel_normal
     * @param accelNormal The new accelNormal value to be set
     */
    fun setAccelNormal(index: Int, accelNormal: Float?) {
        setFieldValue(5, index, accelNormal, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTurnRate(): Array<Float?>? {
        return getFieldFloatValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of turn_rate
     */
    fun getNumTurnRate(): Int {
        return getNumFieldValues(6, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get turn_rate field
     * Units: radians/second
     * Comment: Range -8.727 to +8.727 (-500 degs/sec to +500 degs/sec)
     *
     * @param index of turn_rate
     * @return turn_rate
     */
    fun getTurnRate(index: Int): Float? {
        return getFieldFloatValue(6, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set turn_rate field
     * Units: radians/second
     * Comment: Range -8.727 to +8.727 (-500 degs/sec to +500 degs/sec)
     *
     * @param index of turn_rate
     * @param turnRate The new turnRate value to be set
     */
    fun setTurnRate(index: Int, turnRate: Float?) {
        setFieldValue(6, index, turnRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getStage(): Array<AttitudeStage> {
        val values = getFieldShortValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)!!
        return Array(values.size) { i -> AttitudeStage.fromValue(values[i]) }
    }

    /**
     * @return number of stage
     */
    fun getNumStage(): Int {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get stage field
     *
     * @param index of stage
     * @return stage
     */
    fun getStage(index: Int): AttitudeStage? {
        val value = getFieldShortValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return AttitudeStage.fromValue(value)
    }

    /**
     * Set stage field
     *
     * @param index of stage
     * @param stage The new stage value to be set
     */
    fun setStage(index: Int, stage: AttitudeStage?) {
        setFieldValue(7, index, stage?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getAttitudeStageComplete(): Array<Short?>? {
        return getFieldShortValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of attitude_stage_complete
     */
    fun getNumAttitudeStageComplete(): Int {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get attitude_stage_complete field
     * Units: %
     * Comment: The percent complete of the current attitude stage. Set to 0 for attitude stages 0, 1 and 2 and to 100 for attitude stage 3 by AHRS modules that do not support it. Range - 100
     *
     * @param index of attitude_stage_complete
     * @return attitude_stage_complete
     */
    fun getAttitudeStageComplete(index: Int): Short? {
        return getFieldShortValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set attitude_stage_complete field
     * Units: %
     * Comment: The percent complete of the current attitude stage. Set to 0 for attitude stages 0, 1 and 2 and to 100 for attitude stage 3 by AHRS modules that do not support it. Range - 100
     *
     * @param index of attitude_stage_complete
     * @param attitudeStageComplete The new attitudeStageComplete value to be set
     */
    fun setAttitudeStageComplete(index: Int, attitudeStageComplete: Short?) {
        setFieldValue(8, index, attitudeStageComplete, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getTrack(): Array<Float?>? {
        return getFieldFloatValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of track
     */
    fun getNumTrack(): Int {
        return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get track field
     * Units: radians
     * Comment: Track Angle/Heading Range 0 - 2pi
     *
     * @param index of track
     * @return track
     */
    fun getTrack(index: Int): Float? {
        return getFieldFloatValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set track field
     * Units: radians
     * Comment: Track Angle/Heading Range 0 - 2pi
     *
     * @param index of track
     * @param track The new track value to be set
     */
    fun setTrack(index: Int, track: Float?) {
        setFieldValue(9, index, track, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getValidity(): Array<Int?>? {
        return getFieldIntegerValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of validity
     */
    fun getNumValidity(): Int {
        return getNumFieldValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get validity field
     *
     * @param index of validity
     * @return validity
     */
    fun getValidity(index: Int): Int? {
        return getFieldIntegerValue(10, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set validity field
     *
     * @param index of validity
     * @param validity The new validity value to be set
     */
    fun setValidity(index: Int, validity: Int?) {
        setFieldValue(10, index, validity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
