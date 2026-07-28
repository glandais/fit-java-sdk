/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from GpsMetadataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class GpsMetadataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val PositionLatFieldNum = 1
        const val PositionLongFieldNum = 2
        const val EnhancedAltitudeFieldNum = 3
        const val EnhancedSpeedFieldNum = 4
        const val HeadingFieldNum = 5
        const val UtcTimestampFieldNum = 6
        const val VelocityFieldNum = 7

        val gpsMetadataMesg: Mesg = run {
            // gps_metadata
            val gpsMetadataMesg = Mesg("gps_metadata", MesgNum.GPS_METADATA)
            gpsMetadataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            gpsMetadataMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            gpsMetadataMesg.addField(Field("position_lat", PositionLatFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            gpsMetadataMesg.addField(Field("position_long", PositionLongFieldNum, 133, 1.0, 0.0, "semicircles", false, Profile.Type.SINT32))
            gpsMetadataMesg.addField(Field("enhanced_altitude", EnhancedAltitudeFieldNum, 134, 5.0, 500.0, "m", false, Profile.Type.UINT32))
            gpsMetadataMesg.addField(Field("enhanced_speed", EnhancedSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            gpsMetadataMesg.addField(Field("heading", HeadingFieldNum, 132, 100.0, 0.0, "degrees", false, Profile.Type.UINT16))
            gpsMetadataMesg.addField(Field("utc_timestamp", UtcTimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            gpsMetadataMesg.addField(Field("velocity", VelocityFieldNum, 131, 100.0, 0.0, "m/s", false, Profile.Type.SINT16))
            gpsMetadataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.GPS_METADATA))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp.
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp.
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the timestamp.
     *
     * @return timestamp_ms
     */
    fun getTimestampMs(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the timestamp.
     *
     * @param timestampMs The new timestampMs value to be set
     */
    fun setTimestampMs(timestampMs: Int?) {
        setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get position_lat field
     * Units: semicircles
     *
     * @return position_lat
     */
    fun getPositionLat(): Int? {
        return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set position_lat field
     * Units: semicircles
     *
     * @param positionLat The new positionLat value to be set
     */
    fun setPositionLat(positionLat: Int?) {
        setFieldValue(1, 0, positionLat, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get position_long field
     * Units: semicircles
     *
     * @return position_long
     */
    fun getPositionLong(): Int? {
        return getFieldIntegerValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set position_long field
     * Units: semicircles
     *
     * @param positionLong The new positionLong value to be set
     */
    fun setPositionLong(positionLong: Int?) {
        setFieldValue(2, 0, positionLong, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_altitude field
     * Units: m
     *
     * @return enhanced_altitude
     */
    fun getEnhancedAltitude(): Float? {
        return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_altitude field
     * Units: m
     *
     * @param enhancedAltitude The new enhancedAltitude value to be set
     */
    fun setEnhancedAltitude(enhancedAltitude: Float?) {
        setFieldValue(3, 0, enhancedAltitude, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enhanced_speed field
     * Units: m/s
     *
     * @return enhanced_speed
     */
    fun getEnhancedSpeed(): Float? {
        return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set enhanced_speed field
     * Units: m/s
     *
     * @param enhancedSpeed The new enhancedSpeed value to be set
     */
    fun setEnhancedSpeed(enhancedSpeed: Float?) {
        setFieldValue(4, 0, enhancedSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get heading field
     * Units: degrees
     *
     * @return heading
     */
    fun getHeading(): Float? {
        return getFieldFloatValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set heading field
     * Units: degrees
     *
     * @param heading The new heading value to be set
     */
    fun setHeading(heading: Float?) {
        setFieldValue(5, 0, heading, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get utc_timestamp field
     * Units: s
     * Comment: Used to correlate UTC to system time if the timestamp of the message is in system time. This UTC time is derived from the GPS data.
     *
     * @return utc_timestamp
     */
    fun getUtcTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set utc_timestamp field
     * Units: s
     * Comment: Used to correlate UTC to system time if the timestamp of the message is in system time. This UTC time is derived from the GPS data.
     *
     * @param utcTimestamp The new utcTimestamp value to be set
     */
    fun setUtcTimestamp(utcTimestamp: DateTime?) {
        setFieldValue(6, 0, utcTimestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getVelocity(): Array<Float?>? {
        return getFieldFloatValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of velocity
     */
    fun getNumVelocity(): Int {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get velocity field
     * Units: m/s
     * Comment: velocity[0] is lon velocity. Velocity[1] is lat velocity. Velocity[2] is altitude velocity.
     *
     * @param index of velocity
     * @return velocity
     */
    fun getVelocity(index: Int): Float? {
        return getFieldFloatValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set velocity field
     * Units: m/s
     * Comment: velocity[0] is lon velocity. Velocity[1] is lat velocity. Velocity[2] is altitude velocity.
     *
     * @param index of velocity
     * @param velocity The new velocity value to be set
     */
    fun setVelocity(index: Int, velocity: Float?) {
        setFieldValue(7, index, velocity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
