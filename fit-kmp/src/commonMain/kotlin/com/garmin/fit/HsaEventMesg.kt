/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaEventMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class HsaEventMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val EventIdFieldNum = 0

        val hsaEventMesg: Mesg = run {
            // hsa_event
            val hsaEventMesg = Mesg("hsa_event", MesgNum.HSA_EVENT)
            hsaEventMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            hsaEventMesg.addField(Field("event_id", EventIdFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            hsaEventMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HSA_EVENT))

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
     * Get event_id field
     * Comment: Event ID. Health SDK use only
     *
     * @return event_id
     */
    fun getEventId(): Short? {
        return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set event_id field
     * Comment: Event ID. Health SDK use only
     *
     * @param eventId The new eventId value to be set
     */
    fun setEventId(eventId: Short?) {
        setFieldValue(0, 0, eventId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
