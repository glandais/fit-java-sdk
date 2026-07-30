/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from DiveSummaryMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class DiveSummaryMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val ReferenceMesgFieldNum = 0
        const val ReferenceIndexFieldNum = 1
        const val AvgDepthFieldNum = 2
        const val MaxDepthFieldNum = 3
        const val SurfaceIntervalFieldNum = 4
        const val StartCnsFieldNum = 5
        const val EndCnsFieldNum = 6
        const val StartN2FieldNum = 7
        const val EndN2FieldNum = 8
        const val O2ToxicityFieldNum = 9
        const val DiveNumberFieldNum = 10
        const val BottomTimeFieldNum = 11
        const val AvgPressureSacFieldNum = 12
        const val AvgVolumeSacFieldNum = 13
        const val AvgRmvFieldNum = 14
        const val DescentTimeFieldNum = 15
        const val AscentTimeFieldNum = 16
        const val AvgAscentRateFieldNum = 17
        const val AvgDescentRateFieldNum = 22
        const val MaxAscentRateFieldNum = 23
        const val MaxDescentRateFieldNum = 24
        const val HangTimeFieldNum = 25

        val diveSummaryMesg: Mesg = run {
            // dive_summary
            val diveSummaryMesg = Mesg("dive_summary", MesgNum.DIVE_SUMMARY)
            diveSummaryMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            diveSummaryMesg.addField(Field("reference_mesg", ReferenceMesgFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESG_NUM))
            diveSummaryMesg.addField(Field("reference_index", ReferenceIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            diveSummaryMesg.addField(Field("avg_depth", AvgDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("max_depth", MaxDepthFieldNum, 134, 1000.0, 0.0, "m", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("surface_interval", SurfaceIntervalFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("start_cns", StartCnsFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            diveSummaryMesg.addField(Field("end_cns", EndCnsFieldNum, 2, 1.0, 0.0, "percent", false, Profile.Type.UINT8))
            diveSummaryMesg.addField(Field("start_n2", StartN2FieldNum, 132, 1.0, 0.0, "percent", false, Profile.Type.UINT16))
            diveSummaryMesg.addField(Field("end_n2", EndN2FieldNum, 132, 1.0, 0.0, "percent", false, Profile.Type.UINT16))
            diveSummaryMesg.addField(Field("o2_toxicity", O2ToxicityFieldNum, 132, 1.0, 0.0, "OTUs", false, Profile.Type.UINT16))
            diveSummaryMesg.addField(Field("dive_number", DiveNumberFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("bottom_time", BottomTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("avg_pressure_sac", AvgPressureSacFieldNum, 132, 100.0, 0.0, "bar/min", false, Profile.Type.UINT16))
            diveSummaryMesg.addField(Field("avg_volume_sac", AvgVolumeSacFieldNum, 132, 100.0, 0.0, "L/min", false, Profile.Type.UINT16))
            diveSummaryMesg.addField(Field("avg_rmv", AvgRmvFieldNum, 132, 100.0, 0.0, "L/min", false, Profile.Type.UINT16))
            diveSummaryMesg.addField(Field("descent_time", DescentTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("ascent_time", AscentTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("avg_ascent_rate", AvgAscentRateFieldNum, 133, 1000.0, 0.0, "m/s", false, Profile.Type.SINT32))
            diveSummaryMesg.addField(Field("avg_descent_rate", AvgDescentRateFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("max_ascent_rate", MaxAscentRateFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("max_descent_rate", MaxDescentRateFieldNum, 134, 1000.0, 0.0, "m/s", false, Profile.Type.UINT32))
            diveSummaryMesg.addField(Field("hang_time", HangTimeFieldNum, 134, 1000.0, 0.0, "s", false, Profile.Type.UINT32))
            diveSummaryMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.DIVE_SUMMARY))

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
     * Get reference_mesg field
     *
     * @return reference_mesg
     */
    var referenceMesg: Int?
        get() {
            return getFieldIntegerValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(referenceMesg) {
            setFieldValue(0, 0, referenceMesg, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get reference_index field
     *
     * @return reference_index
     */
    var referenceIndex: Int?
        get() {
            return getFieldIntegerValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(referenceIndex) {
            setFieldValue(1, 0, referenceIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return avg_depth
     */
    var avgDepth: Float?
        get() {
            return getFieldFloatValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgDepth) {
            setFieldValue(2, 0, avgDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_depth field
     * Units: m
     * Comment: 0 if above water
     *
     * @return max_depth
     */
    var maxDepth: Float?
        get() {
            return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxDepth) {
            setFieldValue(3, 0, maxDepth, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get surface_interval field
     * Units: s
     * Comment: Time since end of last dive
     *
     * @return surface_interval
     */
    var surfaceInterval: Long?
        get() {
            return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(surfaceInterval) {
            setFieldValue(4, 0, surfaceInterval, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_cns field
     * Units: percent
     *
     * @return start_cns
     */
    var startCns: Short?
        get() {
            return getFieldShortValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startCns) {
            setFieldValue(5, 0, startCns, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_cns field
     * Units: percent
     *
     * @return end_cns
     */
    var endCns: Short?
        get() {
            return getFieldShortValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(endCns) {
            setFieldValue(6, 0, endCns, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get start_n2 field
     * Units: percent
     *
     * @return start_n2
     */
    var startN2: Int?
        get() {
            return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(startN2) {
            setFieldValue(7, 0, startN2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get end_n2 field
     * Units: percent
     *
     * @return end_n2
     */
    var endN2: Int?
        get() {
            return getFieldIntegerValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(endN2) {
            setFieldValue(8, 0, endN2, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get o2_toxicity field
     * Units: OTUs
     *
     * @return o2_toxicity
     */
    var o2Toxicity: Int?
        get() {
            return getFieldIntegerValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(o2Toxicity) {
            setFieldValue(9, 0, o2Toxicity, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get dive_number field
     *
     * @return dive_number
     */
    var diveNumber: Long?
        get() {
            return getFieldLongValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(diveNumber) {
            setFieldValue(10, 0, diveNumber, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get bottom_time field
     * Units: s
     *
     * @return bottom_time
     */
    var bottomTime: Float?
        get() {
            return getFieldFloatValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(bottomTime) {
            setFieldValue(11, 0, bottomTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_pressure_sac field
     * Units: bar/min
     * Comment: Average pressure-based surface air consumption
     *
     * @return avg_pressure_sac
     */
    var avgPressureSac: Float?
        get() {
            return getFieldFloatValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgPressureSac) {
            setFieldValue(12, 0, avgPressureSac, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_volume_sac field
     * Units: L/min
     * Comment: Average volumetric surface air consumption
     *
     * @return avg_volume_sac
     */
    var avgVolumeSac: Float?
        get() {
            return getFieldFloatValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgVolumeSac) {
            setFieldValue(13, 0, avgVolumeSac, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_rmv field
     * Units: L/min
     * Comment: Average respiratory minute volume
     *
     * @return avg_rmv
     */
    var avgRmv: Float?
        get() {
            return getFieldFloatValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgRmv) {
            setFieldValue(14, 0, avgRmv, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get descent_time field
     * Units: s
     * Comment: Time to reach deepest level stop
     *
     * @return descent_time
     */
    var descentTime: Float?
        get() {
            return getFieldFloatValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(descentTime) {
            setFieldValue(15, 0, descentTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get ascent_time field
     * Units: s
     * Comment: Time after leaving bottom until reaching surface
     *
     * @return ascent_time
     */
    var ascentTime: Float?
        get() {
            return getFieldFloatValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(ascentTime) {
            setFieldValue(16, 0, ascentTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_ascent_rate field
     * Units: m/s
     * Comment: Average ascent rate, not including descents or stops
     *
     * @return avg_ascent_rate
     */
    var avgAscentRate: Float?
        get() {
            return getFieldFloatValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgAscentRate) {
            setFieldValue(17, 0, avgAscentRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get avg_descent_rate field
     * Units: m/s
     * Comment: Average descent rate, not including ascents or stops
     *
     * @return avg_descent_rate
     */
    var avgDescentRate: Float?
        get() {
            return getFieldFloatValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(avgDescentRate) {
            setFieldValue(22, 0, avgDescentRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_ascent_rate field
     * Units: m/s
     * Comment: Maximum ascent rate
     *
     * @return max_ascent_rate
     */
    var maxAscentRate: Float?
        get() {
            return getFieldFloatValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxAscentRate) {
            setFieldValue(23, 0, maxAscentRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get max_descent_rate field
     * Units: m/s
     * Comment: Maximum descent rate
     *
     * @return max_descent_rate
     */
    var maxDescentRate: Float?
        get() {
            return getFieldFloatValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(maxDescentRate) {
            setFieldValue(24, 0, maxDescentRate, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get hang_time field
     * Units: s
     * Comment: Time spent neither ascending nor descending
     *
     * @return hang_time
     */
    var hangTime: Float?
        get() {
            return getFieldFloatValue(25, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(hangTime) {
            setFieldValue(25, 0, hangTime, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
}
