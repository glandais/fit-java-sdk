/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from CameraEventMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

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
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    /**
     * Set timestamp field
     * Units: s
     * Comment: Whole second part of the timestamp.
     *
     * @param timestamp The new timestamp value to be set
     */
    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the timestamp.
     *
     * @return timestamp_ms
     */
    fun getTimestampMs(): Int? {
        return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set timestamp_ms field
     * Units: ms
     * Comment: Millisecond part of the timestamp.
     *
     * @param timestampMs The new timestampMs value to be set
     */
    fun setTimestampMs(timestampMs: Int?) {
        setFieldValue(0, 0, timestampMs, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get camera_event_type field
     *
     * @return camera_event_type
     */
    fun getCameraEventType(): CameraEventType? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return CameraEventType.fromValue(value)
    }

    /**
     * Set camera_event_type field
     *
     * @param cameraEventType The new cameraEventType value to be set
     */
    fun setCameraEventType(cameraEventType: CameraEventType?) {
        setFieldValue(1, 0, cameraEventType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get camera_file_uuid field
     *
     * @return camera_file_uuid
     */
    fun getCameraFileUuid(): String? {
        return getFieldStringValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set camera_file_uuid field
     *
     * @param cameraFileUuid The new cameraFileUuid value to be set
     */
    fun setCameraFileUuid(cameraFileUuid: String?) {
        setFieldValue(2, 0, cameraFileUuid, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get camera_orientation field
     *
     * @return camera_orientation
     */
    fun getCameraOrientation(): CameraOrientationType? {
        val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return CameraOrientationType.fromValue(value)
    }

    /**
     * Set camera_orientation field
     *
     * @param cameraOrientation The new cameraOrientation value to be set
     */
    fun setCameraOrientation(cameraOrientation: CameraOrientationType?) {
        setFieldValue(3, 0, cameraOrientation?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
