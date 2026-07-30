/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaEventMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

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
    var timestamp: DateTime?
        get() {
            return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
        }
        set(timestamp) {
            setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get event_id field
     * Comment: Event ID. Health SDK use only
     *
     * @return event_id
     */
    var eventId: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(eventId) {
            setFieldValue(0, 0, eventId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
