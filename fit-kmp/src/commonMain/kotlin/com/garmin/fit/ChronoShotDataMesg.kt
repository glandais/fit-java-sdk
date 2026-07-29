/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ChronoShotDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class ChronoShotDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ShotSpeedFieldNum = 0
        const val ShotNumFieldNum = 1

        val chronoShotDataMesg: Mesg = run {
            // chrono_shot_data
            val chronoShotDataMesg = Mesg("chrono_shot_data", MesgNum.CHRONO_SHOT_DATA)
            chronoShotDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.DATE_TIME))
            chronoShotDataMesg.addField(Field("shot_speed", ShotSpeedFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            chronoShotDataMesg.addField(Field("shot_num", ShotNumFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            chronoShotDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.CHRONO_SHOT_DATA))

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
     * Get shot_speed field
     * Units: m/s
     *
     * @return shot_speed
     */
    var shotSpeed: Float?
        get() {
            return getFieldFloatValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(shotSpeed) {
            setFieldValue(0, 0, shotSpeed, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get shot_num field
     *
     * @return shot_num
     */
    var shotNum: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(shotNum) {
            setFieldValue(1, 0, shotNum, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
