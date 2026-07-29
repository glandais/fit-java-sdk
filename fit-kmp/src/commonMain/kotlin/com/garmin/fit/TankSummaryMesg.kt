/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TankSummaryMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class TankSummaryMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val SensorFieldNum = 0
        const val StartPressureFieldNum = 1
        const val EndPressureFieldNum = 2
        const val VolumeUsedFieldNum = 3

        val tankSummaryMesg: Mesg = run {
            // tank_summary
            val tankSummaryMesg = Mesg("tank_summary", MesgNum.TANK_SUMMARY)
            tankSummaryMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            tankSummaryMesg.addField(Field("sensor", SensorFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.ANT_CHANNEL_ID))
            tankSummaryMesg.addField(Field("start_pressure", StartPressureFieldNum, 132, 100.0, 0.0, "bar", false, Profile.Type.UINT16))
            tankSummaryMesg.addField(Field("end_pressure", EndPressureFieldNum, 132, 100.0, 0.0, "bar", false, Profile.Type.UINT16))
            tankSummaryMesg.addField(Field("volume_used", VolumeUsedFieldNum, 134, 100.0, 0.0, "L", false, Profile.Type.UINT32))
            tankSummaryMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.TANK_SUMMARY))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
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
     * Get sensor field
     *
     * @return sensor
     */
    var sensor: Long?
        get() {
            return getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sensor) {
            setFieldValue(0, 0, sensor, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_pressure field
     * Units: bar
     *
     * @return start_pressure
     */
    var startPressure: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startPressure) {
            setFieldValue(1, 0, startPressure, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_pressure field
     * Units: bar
     *
     * @return end_pressure
     */
    var endPressure: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(endPressure) {
            setFieldValue(2, 0, endPressure, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get volume_used field
     * Units: L
     *
     * @return volume_used
     */
    var volumeUsed: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(volumeUsed) {
            setFieldValue(3, 0, volumeUsed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
