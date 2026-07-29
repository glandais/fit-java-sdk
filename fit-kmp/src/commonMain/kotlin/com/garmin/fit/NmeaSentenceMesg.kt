/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from NmeaSentenceMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class NmeaSentenceMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val SentenceFieldNum = 1

        val nmeaSentenceMesg: Mesg = run {
            // nmea_sentence
            val nmeaSentenceMesg = Mesg("nmea_sentence", MesgNum.NMEA_SENTENCE)
            nmeaSentenceMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            nmeaSentenceMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            nmeaSentenceMesg.addField(Field("sentence", SentenceFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            nmeaSentenceMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.NMEA_SENTENCE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Timestamp message was output
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
     * Get timestamp_ms field
     * Units: ms
     * Comment: Fractional part of timestamp, added to timestamp
     *
     * @return timestamp_ms
     */
    var timestampMs: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(timestampMs) {
            setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get sentence field
     * Comment: NMEA sentence
     *
     * @return sentence
     */
    var sentence: String?
        get() {
            return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(sentence) {
            setFieldValue(1, 0, sentence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
