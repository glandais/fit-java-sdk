/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Spo2DataMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class Spo2DataMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ReadingSpo2FieldNum = 0
        const val ReadingConfidenceFieldNum = 1
        const val ModeFieldNum = 2

        val spo2DataMesg: Mesg = run {
            // spo2_data
            val spo2DataMesg = Mesg("spo2_data", MesgNum.SPO2_DATA)
            spo2DataMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            spo2DataMesg.addField(Field("reading_spo2", ReadingSpo2FieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            spo2DataMesg.addField(Field("reading_confidence", ReadingConfidenceFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            spo2DataMesg.addField(Field("mode", ModeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPO2_MEASUREMENT_TYPE))
            spo2DataMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SPO2_DATA))

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
     * Get reading_spo2 field
     * Units: percent
     *
     * @return reading_spo2
     */
    var readingSpo2: Short?
        get() {
            return getFieldShortValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(readingSpo2) {
            setFieldValue(0, 0, readingSpo2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get reading_confidence field
     *
     * @return reading_confidence
     */
    var readingConfidence: Short?
        get() {
            return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(readingConfidence) {
            setFieldValue(1, 0, readingConfidence, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get mode field
     * Comment: Mode when data was captured
     *
     * @return mode
     */
    var mode: Spo2MeasurementType?
        get() {
            val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Spo2MeasurementType.fromValue(value)
        }
        set(mode) {
            setFieldValue(2, 0, mode?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
