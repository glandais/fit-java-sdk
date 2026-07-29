/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from TankUpdateMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class TankUpdateMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val SensorFieldNum = 0
        const val PressureFieldNum = 1

        val tankUpdateMesg: Mesg = run {
            // tank_update
            val tankUpdateMesg = Mesg("tank_update", MesgNum.TANK_UPDATE)
            tankUpdateMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            tankUpdateMesg.addField(Field("sensor", SensorFieldNum, 140, 1.0, 0.0, "", false, Profile.Type.ANT_CHANNEL_ID))
            tankUpdateMesg.addField(Field("pressure", PressureFieldNum, 132, 100.0, 0.0, "bar", false, Profile.Type.UINT16))
            tankUpdateMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.TANK_UPDATE))

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
     * Get pressure field
     * Units: bar
     *
     * @return pressure
     */
    var pressure: Float?
        get() {
            return getFieldFloatValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(pressure) {
            setFieldValue(1, 0, pressure, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
