/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from SegmentLeaderboardEntryMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class SegmentLeaderboardEntryMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val NameFieldNum = 0
        const val TypeFieldNum = 1
        const val GroupPrimaryKeyFieldNum = 2
        const val ActivityIdFieldNum = 3
        const val SegmentTimeFieldNum = 4
        const val ActivityIdStringFieldNum = 5

        val segmentLeaderboardEntryMesg: Mesg = run {
            // segment_leaderboard_entry
            val segmentLeaderboardEntryMesg = Mesg("segment_leaderboard_entry", MesgNum.SEGMENT_LEADERBOARD_ENTRY)
            segmentLeaderboardEntryMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            segmentLeaderboardEntryMesg.addField(Field("name", NameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            segmentLeaderboardEntryMesg.addField(Field("type", TypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.SEGMENT_LEADERBOARD_TYPE))
            segmentLeaderboardEntryMesg.addField(Field("group_primary_key", GroupPrimaryKeyFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            segmentLeaderboardEntryMesg.addField(Field("activity_id", ActivityIdFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            segmentLeaderboardEntryMesg.addField(Field("segment_time", SegmentTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            segmentLeaderboardEntryMesg.addField(Field("activity_id_string", ActivityIdStringFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            segmentLeaderboardEntryMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.SEGMENT_LEADERBOARD_ENTRY))

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
     * Get name field
     * Comment: Friendly name assigned to leader
     *
     * @return name
     */
    override var name: String?
        get() {
            return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(name) {
            setFieldValue(0, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get type field
     * Comment: Leader classification
     *
     * @return type
     */
    var type: SegmentLeaderboardType?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return SegmentLeaderboardType.fromValue(value)
        }
        set(type) {
            setFieldValue(1, 0, type?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get group_primary_key field
     * Comment: Primary user ID of this leader
     *
     * @return group_primary_key
     */
    var groupPrimaryKey: Long?
        get() {
            return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(groupPrimaryKey) {
            setFieldValue(2, 0, groupPrimaryKey, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_id field
     * Comment: ID of the activity associated with this leader time
     *
     * @return activity_id
     */
    var activityId: Long?
        get() {
            return getFieldLongValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activityId) {
            setFieldValue(3, 0, activityId, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get segment_time field
     * Units: s
     * Comment: Segment Time (includes pauses)
     *
     * @return segment_time
     */
    var segmentTime: Float?
        get() {
            return getFieldFloatValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(segmentTime) {
            setFieldValue(4, 0, segmentTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get activity_id_string field
     * Comment: String version of the activity_id. 21 characters long, express in decimal
     *
     * @return activity_id_string
     */
    var activityIdString: String?
        get() {
            return getFieldStringValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(activityIdString) {
            setFieldValue(5, 0, activityIdString, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
