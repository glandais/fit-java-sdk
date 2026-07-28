/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentIdMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class SegmentIdMesg : Mesg {

    companion object {
        const val NameFieldNum = 0
        const val UuidFieldNum = 1
        const val SportFieldNum = 2
        const val EnabledFieldNum = 3
        const val UserProfilePrimaryKeyFieldNum = 4
        const val DeviceIdFieldNum = 5
        const val DefaultRaceLeaderFieldNum = 6
        const val DeleteStatusFieldNum = 7
        const val SelectionTypeFieldNum = 8

        val segmentIdMesg: Mesg = run {
            // segment_id
            val segmentIdMesg = Mesg("segment_id", MesgNum.SEGMENT_ID)
            segmentIdMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            segmentIdMesg.addField(Field("uuid", UuidFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            segmentIdMesg.addField(Field("sport", SportFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SPORT))
            segmentIdMesg.addField(Field("enabled", EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            segmentIdMesg.addField(Field("user_profile_primary_key", UserProfilePrimaryKeyFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            segmentIdMesg.addField(Field("device_id", DeviceIdFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            segmentIdMesg.addField(Field("default_race_leader", DefaultRaceLeaderFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            segmentIdMesg.addField(Field("delete_status", DeleteStatusFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SEGMENT_DELETE_STATUS))
            segmentIdMesg.addField(Field("selection_type", SelectionTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SEGMENT_SELECTION_TYPE))
            segmentIdMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SEGMENT_ID))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get name field
     * Comment: Friendly name assigned to segment
     *
     * @return name
     */
    override fun getName(): String? {
        return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set name field
     * Comment: Friendly name assigned to segment
     *
     * @param name The new name value to be set
     */
    fun setName(name: String?) {
        setFieldValue(0, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get uuid field
     * Comment: UUID of the segment
     *
     * @return uuid
     */
    fun getUuid(): String? {
        return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set uuid field
     * Comment: UUID of the segment
     *
     * @param uuid The new uuid value to be set
     */
    fun setUuid(uuid: String?) {
        setFieldValue(1, 0, uuid, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get sport field
     * Comment: Sport associated with the segment
     *
     * @return sport
     */
    fun getSport(): Sport? {
        val value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Sport.fromValue(value)
    }

    /**
     * Set sport field
     * Comment: Sport associated with the segment
     *
     * @param sport The new sport value to be set
     */
    fun setSport(sport: Sport?) {
        setFieldValue(2, 0, sport?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get enabled field
     * Comment: Segment enabled for evaluation
     *
     * @return enabled
     */
    fun getEnabled(): Bool? {
        val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Bool.fromValue(value)
    }

    /**
     * Set enabled field
     * Comment: Segment enabled for evaluation
     *
     * @param enabled The new enabled value to be set
     */
    fun setEnabled(enabled: Bool?) {
        setFieldValue(3, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get user_profile_primary_key field
     * Comment: Primary key of the user that created the segment
     *
     * @return user_profile_primary_key
     */
    fun getUserProfilePrimaryKey(): Long? {
        return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set user_profile_primary_key field
     * Comment: Primary key of the user that created the segment
     *
     * @param userProfilePrimaryKey The new userProfilePrimaryKey value to be set
     */
    fun setUserProfilePrimaryKey(userProfilePrimaryKey: Long?) {
        setFieldValue(4, 0, userProfilePrimaryKey, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get device_id field
     * Comment: ID of the device that created the segment
     *
     * @return device_id
     */
    fun getDeviceId(): Long? {
        return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set device_id field
     * Comment: ID of the device that created the segment
     *
     * @param deviceId The new deviceId value to be set
     */
    fun setDeviceId(deviceId: Long?) {
        setFieldValue(5, 0, deviceId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get default_race_leader field
     * Comment: Index for the Leader Board entry selected as the default race participant
     *
     * @return default_race_leader
     */
    fun getDefaultRaceLeader(): Short? {
        return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set default_race_leader field
     * Comment: Index for the Leader Board entry selected as the default race participant
     *
     * @param defaultRaceLeader The new defaultRaceLeader value to be set
     */
    fun setDefaultRaceLeader(defaultRaceLeader: Short?) {
        setFieldValue(6, 0, defaultRaceLeader, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get delete_status field
     * Comment: Indicates if any segments should be deleted
     *
     * @return delete_status
     */
    fun getDeleteStatus(): SegmentDeleteStatus? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SegmentDeleteStatus.fromValue(value)
    }

    /**
     * Set delete_status field
     * Comment: Indicates if any segments should be deleted
     *
     * @param deleteStatus The new deleteStatus value to be set
     */
    fun setDeleteStatus(deleteStatus: SegmentDeleteStatus?) {
        setFieldValue(7, 0, deleteStatus?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get selection_type field
     * Comment: Indicates how the segment was selected to be sent to the device
     *
     * @return selection_type
     */
    fun getSelectionType(): SegmentSelectionType? {
        val value = getFieldShortValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SegmentSelectionType.fromValue(value)
    }

    /**
     * Set selection_type field
     * Comment: Indicates how the segment was selected to be sent to the device
     *
     * @param selectionType The new selectionType value to be set
     */
    fun setSelectionType(selectionType: SegmentSelectionType?) {
        setFieldValue(8, 0, selectionType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
