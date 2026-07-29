/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaBodyBatteryDataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HsaBodyBatteryDataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ProcessingIntervalFieldNum = 0
        const val LevelFieldNum = 1
        const val ChargedFieldNum = 2
        const val UnchargedFieldNum = 3

        val hsaBodyBatteryDataMesg: Mesg = run {
            // hsa_body_battery_data
            val hsaBodyBatteryDataMesg = Mesg("hsa_body_battery_data", MesgNum.HSA_BODY_BATTERY_DATA)
            hsaBodyBatteryDataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaBodyBatteryDataMesg.addField(Field("processing_interval", ProcessingIntervalFieldNum, 132, 1.0, 0.0, "s", false, Profile.Type.UINT16))
            hsaBodyBatteryDataMesg.addField(Field("level", LevelFieldNum, 1, 1.0, 0.0, "percent", false, Profile.Type.SINT8))
            hsaBodyBatteryDataMesg.addField(Field("charged", ChargedFieldNum, 131, 1.0, 0.0, "", false, Profile.Type.SINT16))
            hsaBodyBatteryDataMesg.addField(Field("uncharged", UnchargedFieldNum, 131, 1.0, 0.0, "", false, Profile.Type.SINT16))
            hsaBodyBatteryDataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_BODY_BATTERY_DATA))

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
     * Get processing_interval field
     * Units: s
     * Comment: Processing interval length in seconds
     *
     * @return processing_interval
     */
    var processingInterval: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(processingInterval) {
            setFieldValue(0, 0, processingInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getLevel(): Array<Byte?>? {
        return getFieldByteValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of level
     */
    fun getNumLevel(): Int {
        return getNumFieldValues(1, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get level field
     * Units: percent
     * Comment: Body battery level: [0,100] Blank: -16
     *
     * @param index of level
     * @return level
     */
    fun getLevel(index: Int): Byte? {
        return getFieldByteValue(1, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set level field
     * Units: percent
     * Comment: Body battery level: [0,100] Blank: -16
     *
     * @param index of level
     * @param level The new level value to be set
     */
    fun setLevel(index: Int, level: Byte?) {
        setFieldValue(1, index, level, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getCharged(): Array<Short?>? {
        return getFieldShortValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of charged
     */
    fun getNumCharged(): Int {
        return getNumFieldValues(2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get charged field
     * Comment: Body battery charged value
     *
     * @param index of charged
     * @return charged
     */
    fun getCharged(index: Int): Short? {
        return getFieldShortValue(2, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set charged field
     * Comment: Body battery charged value
     *
     * @param index of charged
     * @param charged The new charged value to be set
     */
    fun setCharged(index: Int, charged: Short?) {
        setFieldValue(2, index, charged, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getUncharged(): Array<Short?>? {
        return getFieldShortValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of uncharged
     */
    fun getNumUncharged(): Int {
        return getNumFieldValues(3, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get uncharged field
     * Comment: Body battery uncharged value
     *
     * @param index of uncharged
     * @return uncharged
     */
    fun getUncharged(index: Int): Short? {
        return getFieldShortValue(3, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set uncharged field
     * Comment: Body battery uncharged value
     *
     * @param index of uncharged
     * @param uncharged The new uncharged value to be set
     */
    fun setUncharged(index: Int, uncharged: Short?) {
        setFieldValue(3, index, uncharged, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
