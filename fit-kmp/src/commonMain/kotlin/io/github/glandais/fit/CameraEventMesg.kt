/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CameraEventMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class CameraEventMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val TimestampMsFieldNum = 0
        const val CameraEventTypeFieldNum = 1
        const val CameraFileUuidFieldNum = 2
        const val CameraOrientationFieldNum = 3

        val cameraEventMesg: Mesg = run {
            // camera_event
            val cameraEventMesg = Mesg("camera_event", MesgNum.CAMERA_EVENT)
            cameraEventMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            cameraEventMesg.addField(Field("timestamp_ms", TimestampMsFieldNum, 132, 1.0, 0.0, "ms", false, Profile.Type.UINT16))
            cameraEventMesg.addField(Field("camera_event_type", CameraEventTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.CAMERA_EVENT_TYPE))
            cameraEventMesg.addField(Field("camera_file_uuid", CameraFileUuidFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            cameraEventMesg.addField(Field("camera_orientation", CameraOrientationFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.CAMERA_ORIENTATION_TYPE))
            cameraEventMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.CAMERA_EVENT))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp.
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
     * Comment: Millisecond part of the timestamp.
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
     * Get camera_event_type field
     *
     * @return camera_event_type
     */
    var cameraEventType: CameraEventType?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return CameraEventType.fromValue(value)
        }
        set(cameraEventType) {
            setFieldValue(1, 0, cameraEventType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get camera_file_uuid field
     *
     * @return camera_file_uuid
     */
    var cameraFileUuid: String?
        get() {
            return getFieldStringValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(cameraFileUuid) {
            setFieldValue(2, 0, cameraFileUuid, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get camera_orientation field
     *
     * @return camera_orientation
     */
    var cameraOrientation: CameraOrientationType?
        get() {
            val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return CameraOrientationType.fromValue(value)
        }
        set(cameraOrientation) {
            setFieldValue(3, 0, cameraOrientation?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
