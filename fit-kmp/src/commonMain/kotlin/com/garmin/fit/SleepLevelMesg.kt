/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SleepLevelMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SleepLevelMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val SleepLevelFieldNum = 0

        val sleepLevelMesg: Mesg = run {
            // sleep_level
            val sleepLevelMesg = Mesg("sleep_level", MesgNum.SLEEP_LEVEL)
            sleepLevelMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            sleepLevelMesg.addField(Field("sleep_level", SleepLevelFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SLEEP_LEVEL))
            sleepLevelMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SLEEP_LEVEL))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     *
     * @return timestamp
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sleep_level field
     *
     * @return sleep_level
     */
    fun getSleepLevel(): SleepLevel? {
        val value = getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SleepLevel.fromValue(value)
    }

    /**
     * Set sleep_level field
     *
     * @param sleepLevel The new sleepLevel value to be set
     */
    fun setSleepLevel(sleepLevel: SleepLevel?) {
        setFieldValue(0, 0, sleepLevel?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
