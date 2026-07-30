/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentFileMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class SegmentFileMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val FileUuidFieldNum = 1
        const val EnabledFieldNum = 3
        const val UserProfilePrimaryKeyFieldNum = 4
        const val LeaderTypeFieldNum = 7
        const val LeaderGroupPrimaryKeyFieldNum = 8
        const val LeaderActivityIdFieldNum = 9
        const val LeaderActivityIdStringFieldNum = 10
        const val DefaultRaceLeaderFieldNum = 11

        val segmentFileMesg: Mesg = run {
            // segment_file
            val segmentFileMesg = Mesg("segment_file", MesgNum.SEGMENT_FILE)
            segmentFileMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            segmentFileMesg.addField(Field("file_uuid", FileUuidFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            segmentFileMesg.addField(Field("enabled", EnabledFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.BOOL))
            segmentFileMesg.addField(Field("user_profile_primary_key", UserProfilePrimaryKeyFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            segmentFileMesg.addField(Field("leader_type", LeaderTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SEGMENT_LEADERBOARD_TYPE))
            segmentFileMesg.addField(Field("leader_group_primary_key", LeaderGroupPrimaryKeyFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            segmentFileMesg.addField(Field("leader_activity_id", LeaderActivityIdFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            segmentFileMesg.addField(Field("leader_activity_id_string", LeaderActivityIdStringFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            segmentFileMesg.addField(Field("default_race_leader", DefaultRaceLeaderFieldNum, 2, 1.0, 0.0, "", false, Profile.Type.UINT8))
            segmentFileMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SEGMENT_FILE))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     *
     * @return message_index
     */
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get file_uuid field
     * Comment: UUID of the segment file
     *
     * @return file_uuid
     */
    var fileUuid: String?
        get() {
            return getFieldStringValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(fileUuid) {
            setFieldValue(1, 0, fileUuid, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get enabled field
     * Comment: Enabled state of the segment file
     *
     * @return enabled
     */
    var enabled: Bool?
        get() {
            val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Bool.fromValue(value)
        }
        set(enabled) {
            setFieldValue(3, 0, enabled?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get user_profile_primary_key field
     * Comment: Primary key of the user that created the segment file
     *
     * @return user_profile_primary_key
     */
    var userProfilePrimaryKey: Long?
        get() {
            return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(userProfilePrimaryKey) {
            setFieldValue(4, 0, userProfilePrimaryKey, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    fun getLeaderType(): Array<SegmentLeaderboardType> {
        val values = getFieldShortValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)!!
        return Array(values.size) { i -> SegmentLeaderboardType.fromValue(values[i]) }
    }

    /**
     * @return number of leader_type
     */
    fun getNumLeaderType(): Int {
        return getNumFieldValues(7, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get leader_type field
     * Comment: Leader type of each leader in the segment file
     *
     * @param index of leader_type
     * @return leader_type
     */
    fun getLeaderType(index: Int): SegmentLeaderboardType? {
        val value = getFieldShortValue(7, index, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return SegmentLeaderboardType.fromValue(value)
    }

    /**
     * Set leader_type field
     * Comment: Leader type of each leader in the segment file
     *
     * @param index of leader_type
     * @param leaderType The new leaderType value to be set
     */
    fun setLeaderType(index: Int, leaderType: SegmentLeaderboardType?) {
        setFieldValue(7, index, leaderType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getLeaderGroupPrimaryKey(): Array<Long?>? {
        return getFieldLongValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of leader_group_primary_key
     */
    fun getNumLeaderGroupPrimaryKey(): Int {
        return getNumFieldValues(8, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get leader_group_primary_key field
     * Comment: Group primary key of each leader in the segment file
     *
     * @param index of leader_group_primary_key
     * @return leader_group_primary_key
     */
    fun getLeaderGroupPrimaryKey(index: Int): Long? {
        return getFieldLongValue(8, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set leader_group_primary_key field
     * Comment: Group primary key of each leader in the segment file
     *
     * @param index of leader_group_primary_key
     * @param leaderGroupPrimaryKey The new leaderGroupPrimaryKey value to be set
     */
    fun setLeaderGroupPrimaryKey(index: Int, leaderGroupPrimaryKey: Long?) {
        setFieldValue(8, index, leaderGroupPrimaryKey, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getLeaderActivityId(): Array<Long?>? {
        return getFieldLongValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of leader_activity_id
     */
    fun getNumLeaderActivityId(): Int {
        return getNumFieldValues(9, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get leader_activity_id field
     * Comment: Activity ID of each leader in the segment file
     *
     * @param index of leader_activity_id
     * @return leader_activity_id
     */
    fun getLeaderActivityId(index: Int): Long? {
        return getFieldLongValue(9, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set leader_activity_id field
     * Comment: Activity ID of each leader in the segment file
     *
     * @param index of leader_activity_id
     * @param leaderActivityId The new leaderActivityId value to be set
     */
    fun setLeaderActivityId(index: Int, leaderActivityId: Long?) {
        setFieldValue(9, index, leaderActivityId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    fun getLeaderActivityIdString(): Array<String?>? {
        return getFieldStringValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of leader_activity_id_string
     */
    fun getNumLeaderActivityIdString(): Int {
        return getNumFieldValues(10, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get leader_activity_id_string field
     * Comment: String version of the activity ID of each leader in the segment file. 21 characters long for each ID, express in decimal
     *
     * @param index of leader_activity_id_string
     * @return leader_activity_id_string
     */
    fun getLeaderActivityIdString(index: Int): String? {
        return getFieldStringValue(10, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set leader_activity_id_string field
     * Comment: String version of the activity ID of each leader in the segment file. 21 characters long for each ID, express in decimal
     *
     * @param index of leader_activity_id_string
     * @param leaderActivityIdString The new leaderActivityIdString value to be set
     */
    fun setLeaderActivityIdString(index: Int, leaderActivityIdString: String?) {
        setFieldValue(10, index, leaderActivityIdString, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get default_race_leader field
     * Comment: Index for the Leader Board entry selected as the default race participant
     *
     * @return default_race_leader
     */
    var defaultRaceLeader: Short?
        get() {
            return getFieldShortValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(defaultRaceLeader) {
            setFieldValue(11, 0, defaultRaceLeader, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
