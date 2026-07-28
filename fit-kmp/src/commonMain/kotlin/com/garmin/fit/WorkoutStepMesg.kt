/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from WorkoutStepMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

open class WorkoutStepMesg : Mesg {

    companion object {
        const val MessageIndexFieldNum = 254
        const val WktStepNameFieldNum = 0
        const val DurationTypeFieldNum = 1
        const val DurationValueFieldNum = 2
        const val TargetTypeFieldNum = 3
        const val TargetValueFieldNum = 4
        const val CustomTargetValueLowFieldNum = 5
        const val CustomTargetValueHighFieldNum = 6
        const val IntensityFieldNum = 7
        const val NotesFieldNum = 8
        const val EquipmentFieldNum = 9
        const val ExerciseCategoryFieldNum = 10
        const val ExerciseNameFieldNum = 11
        const val ExerciseWeightFieldNum = 12
        const val WeightDisplayUnitFieldNum = 13
        const val SecondaryTargetTypeFieldNum = 19
        const val SecondaryTargetValueFieldNum = 20
        const val SecondaryCustomTargetValueLowFieldNum = 21
        const val SecondaryCustomTargetValueHighFieldNum = 22

        val workoutStepMesg: Mesg = run {
            var field_index = 0
            var subfield_index = 0
            // workout_step
            val workoutStepMesg = Mesg("workout_step", MesgNum.WORKOUT_STEP)
            workoutStepMesg.addField(Field("message_index", MessageIndexFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.MESSAGE_INDEX))
            field_index++
            workoutStepMesg.addField(Field("wkt_step_name", WktStepNameFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            workoutStepMesg.addField(Field("duration_type", DurationTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WKT_STEP_DURATION))
            field_index++
            workoutStepMesg.addField(Field("duration_value", DurationValueFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            workoutStepMesg.fields[field_index].subFields.add(SubField("duration_time", 134, 1000.0, 0.0, "s"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 0L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 28L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("duration_distance", 134, 100.0, 0.0, "m"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 1L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("duration_hr", 134, 1.0, 0.0, "% or bpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 2L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 3L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("duration_calories", 134, 1.0, 0.0, "calories"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 4L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("duration_step", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 6L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 7L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 8L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 9L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 10L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 11L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 12L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 13L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("duration_power", 134, 1.0, 0.0, "% or watts"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 14L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 15L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("duration_reps", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 29L)
            subfield_index++
            field_index++
            workoutStepMesg.addField(Field("target_type", TargetTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WKT_STEP_TARGET))
            field_index++
            workoutStepMesg.addField(Field("target_value", TargetValueFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            workoutStepMesg.fields[field_index].subFields.add(SubField("target_speed_zone", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 0L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("target_hr_zone", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 1L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("target_cadence_zone", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 3L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("target_power_zone", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 4L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("repeat_steps", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 6L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("repeat_time", 134, 1000.0, 0.0, "s"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 7L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("repeat_distance", 134, 100.0, 0.0, "m"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 8L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("repeat_calories", 134, 1.0, 0.0, "calories"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 9L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("repeat_hr", 134, 1.0, 0.0, "% or bpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 10L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 11L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("repeat_power", 134, 1.0, 0.0, "% or watts"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 12L)
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(1, 13L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("target_stroke_type", 0, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 11L)
            subfield_index++
            field_index++
            workoutStepMesg.addField(Field("custom_target_value_low", CustomTargetValueLowFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            workoutStepMesg.fields[field_index].subFields.add(SubField("custom_target_speed_low", 134, 1000.0, 0.0, "m/s"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 0L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("custom_target_heart_rate_low", 134, 1.0, 0.0, "% or bpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 1L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("custom_target_cadence_low", 134, 1.0, 0.0, "rpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 3L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("custom_target_power_low", 134, 1.0, 0.0, "% or watts"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 4L)
            subfield_index++
            field_index++
            workoutStepMesg.addField(Field("custom_target_value_high", CustomTargetValueHighFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            workoutStepMesg.fields[field_index].subFields.add(SubField("custom_target_speed_high", 134, 1000.0, 0.0, "m/s"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 0L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("custom_target_heart_rate_high", 134, 1.0, 0.0, "% or bpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 1L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("custom_target_cadence_high", 134, 1.0, 0.0, "rpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 3L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("custom_target_power_high", 134, 1.0, 0.0, "% or watts"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(3, 4L)
            subfield_index++
            field_index++
            workoutStepMesg.addField(Field("intensity", IntensityFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.INTENSITY))
            field_index++
            workoutStepMesg.addField(Field("notes", NotesFieldNum, 7, 1.0, 0.0, "", false, Profile.Type.STRING))
            field_index++
            workoutStepMesg.addField(Field("equipment", EquipmentFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WORKOUT_EQUIPMENT))
            field_index++
            workoutStepMesg.addField(Field("exercise_category", ExerciseCategoryFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.EXERCISE_CATEGORY))
            field_index++
            workoutStepMesg.addField(Field("exercise_name", ExerciseNameFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.UINT16))
            field_index++
            workoutStepMesg.addField(Field("exercise_weight", ExerciseWeightFieldNum, 132, 100.0, 0.0, "kg", false, Profile.Type.UINT16))
            field_index++
            workoutStepMesg.addField(Field("weight_display_unit", WeightDisplayUnitFieldNum, 132, 1.0, 0.0, "", false, Profile.Type.FIT_BASE_UNIT))
            field_index++
            workoutStepMesg.addField(Field("secondary_target_type", SecondaryTargetTypeFieldNum, 0, 1.0, 0.0, "", false, Profile.Type.WKT_STEP_TARGET))
            field_index++
            workoutStepMesg.addField(Field("secondary_target_value", SecondaryTargetValueFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_target_speed_zone", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 0L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_target_hr_zone", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 1L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_target_cadence_zone", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 3L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_target_power_zone", 134, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 4L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_target_stroke_type", 0, 1.0, 0.0, ""))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 11L)
            subfield_index++
            field_index++
            workoutStepMesg.addField(Field("secondary_custom_target_value_low", SecondaryCustomTargetValueLowFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_custom_target_speed_low", 134, 1000.0, 0.0, "m/s"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 0L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_custom_target_heart_rate_low", 134, 1.0, 0.0, "% or bpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 1L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_custom_target_cadence_low", 134, 1.0, 0.0, "rpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 3L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_custom_target_power_low", 134, 1.0, 0.0, "% or watts"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 4L)
            subfield_index++
            field_index++
            workoutStepMesg.addField(Field("secondary_custom_target_value_high", SecondaryCustomTargetValueHighFieldNum, 134, 1.0, 0.0, "", false, Profile.Type.UINT32))
            subfield_index = 0
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_custom_target_speed_high", 134, 1000.0, 0.0, "m/s"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 0L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_custom_target_heart_rate_high", 134, 1.0, 0.0, "% or bpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 1L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_custom_target_cadence_high", 134, 1.0, 0.0, "rpm"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 3L)
            subfield_index++
            workoutStepMesg.fields[field_index].subFields.add(SubField("secondary_custom_target_power_high", 134, 1.0, 0.0, "% or watts"))
            workoutStepMesg.fields[field_index].subFields[subfield_index].addMap(19, 4L)
            subfield_index++
            field_index++
            workoutStepMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.WORKOUT_STEP))

    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get message_index field
     *
     * @return message_index
     */
    fun getMessageIndex(): Int? {
        return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set message_index field
     *
     * @param messageIndex The new messageIndex value to be set
     */
    fun setMessageIndex(messageIndex: Int?) {
        setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get wkt_step_name field
     *
     * @return wkt_step_name
     */
    fun getWktStepName(): String? {
        return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set wkt_step_name field
     *
     * @param wktStepName The new wktStepName value to be set
     */
    fun setWktStepName(wktStepName: String?) {
        setFieldValue(0, 0, wktStepName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get duration_type field
     *
     * @return duration_type
     */
    fun getDurationType(): WktStepDuration? {
        val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return WktStepDuration.fromValue(value)
    }

    /**
     * Set duration_type field
     *
     * @param durationType The new durationType value to be set
     */
    fun setDurationType(durationType: WktStepDuration?) {
        setFieldValue(1, 0, durationType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get duration_value field
     *
     * @return duration_value
     */
    fun getDurationValue(): Long? {
        return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set duration_value field
     *
     * @param durationValue The new durationValue value to be set
     */
    fun setDurationValue(durationValue: Long?) {
        setFieldValue(2, 0, durationValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get duration_time field
     * Units: s
     *
     * @return duration_time
     */
    fun getDurationTime(): Float? {
        return getFieldFloatValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_TIME)
    }

    /**
     * Set duration_time field
     * Units: s
     *
     * @param durationTime The new durationTime value to be set
     */
    fun setDurationTime(durationTime: Float?) {
        setFieldValue(2, 0, durationTime, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_TIME)
    }

    /**
     * Get duration_distance field
     * Units: m
     *
     * @return duration_distance
     */
    fun getDurationDistance(): Float? {
        return getFieldFloatValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_DISTANCE)
    }

    /**
     * Set duration_distance field
     * Units: m
     *
     * @param durationDistance The new durationDistance value to be set
     */
    fun setDurationDistance(durationDistance: Float?) {
        setFieldValue(2, 0, durationDistance, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_DISTANCE)
    }

    /**
     * Get duration_hr field
     * Units: % or bpm
     *
     * @return duration_hr
     */
    fun getDurationHr(): Long? {
        return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_HR)
    }

    /**
     * Set duration_hr field
     * Units: % or bpm
     *
     * @param durationHr The new durationHr value to be set
     */
    fun setDurationHr(durationHr: Long?) {
        setFieldValue(2, 0, durationHr, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_HR)
    }

    /**
     * Get duration_calories field
     * Units: calories
     *
     * @return duration_calories
     */
    fun getDurationCalories(): Long? {
        return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_CALORIES)
    }

    /**
     * Set duration_calories field
     * Units: calories
     *
     * @param durationCalories The new durationCalories value to be set
     */
    fun setDurationCalories(durationCalories: Long?) {
        setFieldValue(2, 0, durationCalories, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_CALORIES)
    }

    /**
     * Get duration_step field
     * Comment: message_index of step to loop back to. Steps are assumed to be in the order by message_index. custom_name and intensity members are undefined for this duration type.
     *
     * @return duration_step
     */
    fun getDurationStep(): Long? {
        return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_STEP)
    }

    /**
     * Set duration_step field
     * Comment: message_index of step to loop back to. Steps are assumed to be in the order by message_index. custom_name and intensity members are undefined for this duration type.
     *
     * @param durationStep The new durationStep value to be set
     */
    fun setDurationStep(durationStep: Long?) {
        setFieldValue(2, 0, durationStep, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_STEP)
    }

    /**
     * Get duration_power field
     * Units: % or watts
     *
     * @return duration_power
     */
    fun getDurationPower(): Long? {
        return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_POWER)
    }

    /**
     * Set duration_power field
     * Units: % or watts
     *
     * @param durationPower The new durationPower value to be set
     */
    fun setDurationPower(durationPower: Long?) {
        setFieldValue(2, 0, durationPower, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_POWER)
    }

    /**
     * Get duration_reps field
     *
     * @return duration_reps
     */
    fun getDurationReps(): Long? {
        return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_REPS)
    }

    /**
     * Set duration_reps field
     *
     * @param durationReps The new durationReps value to be set
     */
    fun setDurationReps(durationReps: Long?) {
        setFieldValue(2, 0, durationReps, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_REPS)
    }

    /**
     * Get target_type field
     *
     * @return target_type
     */
    fun getTargetType(): WktStepTarget? {
        val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return WktStepTarget.fromValue(value)
    }

    /**
     * Set target_type field
     *
     * @param targetType The new targetType value to be set
     */
    fun setTargetType(targetType: WktStepTarget?) {
        setFieldValue(3, 0, targetType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get target_value field
     *
     * @return target_value
     */
    fun getTargetValue(): Long? {
        return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set target_value field
     *
     * @param targetValue The new targetValue value to be set
     */
    fun setTargetValue(targetValue: Long?) {
        setFieldValue(4, 0, targetValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get target_speed_zone field
     * Comment: speed zone (1-10);Custom =0;
     *
     * @return target_speed_zone
     */
    fun getTargetSpeedZone(): Long? {
        return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_SPEED_ZONE)
    }

    /**
     * Set target_speed_zone field
     * Comment: speed zone (1-10);Custom =0;
     *
     * @param targetSpeedZone The new targetSpeedZone value to be set
     */
    fun setTargetSpeedZone(targetSpeedZone: Long?) {
        setFieldValue(4, 0, targetSpeedZone, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_SPEED_ZONE)
    }

    /**
     * Get target_hr_zone field
     * Comment: hr zone (1-5);Custom =0;
     *
     * @return target_hr_zone
     */
    fun getTargetHrZone(): Long? {
        return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_HR_ZONE)
    }

    /**
     * Set target_hr_zone field
     * Comment: hr zone (1-5);Custom =0;
     *
     * @param targetHrZone The new targetHrZone value to be set
     */
    fun setTargetHrZone(targetHrZone: Long?) {
        setFieldValue(4, 0, targetHrZone, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_HR_ZONE)
    }

    /**
     * Get target_cadence_zone field
     * Comment: Zone (1-?); Custom = 0;
     *
     * @return target_cadence_zone
     */
    fun getTargetCadenceZone(): Long? {
        return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_CADENCE_ZONE)
    }

    /**
     * Set target_cadence_zone field
     * Comment: Zone (1-?); Custom = 0;
     *
     * @param targetCadenceZone The new targetCadenceZone value to be set
     */
    fun setTargetCadenceZone(targetCadenceZone: Long?) {
        setFieldValue(4, 0, targetCadenceZone, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_CADENCE_ZONE)
    }

    /**
     * Get target_power_zone field
     * Comment: Power Zone ( 1-7); Custom = 0;
     *
     * @return target_power_zone
     */
    fun getTargetPowerZone(): Long? {
        return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_POWER_ZONE)
    }

    /**
     * Set target_power_zone field
     * Comment: Power Zone ( 1-7); Custom = 0;
     *
     * @param targetPowerZone The new targetPowerZone value to be set
     */
    fun setTargetPowerZone(targetPowerZone: Long?) {
        setFieldValue(4, 0, targetPowerZone, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_POWER_ZONE)
    }

    /**
     * Get repeat_steps field
     * Comment: # of repetitions
     *
     * @return repeat_steps
     */
    fun getRepeatSteps(): Long? {
        return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_STEPS)
    }

    /**
     * Set repeat_steps field
     * Comment: # of repetitions
     *
     * @param repeatSteps The new repeatSteps value to be set
     */
    fun setRepeatSteps(repeatSteps: Long?) {
        setFieldValue(4, 0, repeatSteps, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_STEPS)
    }

    /**
     * Get repeat_time field
     * Units: s
     *
     * @return repeat_time
     */
    fun getRepeatTime(): Float? {
        return getFieldFloatValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_TIME)
    }

    /**
     * Set repeat_time field
     * Units: s
     *
     * @param repeatTime The new repeatTime value to be set
     */
    fun setRepeatTime(repeatTime: Float?) {
        setFieldValue(4, 0, repeatTime, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_TIME)
    }

    /**
     * Get repeat_distance field
     * Units: m
     *
     * @return repeat_distance
     */
    fun getRepeatDistance(): Float? {
        return getFieldFloatValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_DISTANCE)
    }

    /**
     * Set repeat_distance field
     * Units: m
     *
     * @param repeatDistance The new repeatDistance value to be set
     */
    fun setRepeatDistance(repeatDistance: Float?) {
        setFieldValue(4, 0, repeatDistance, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_DISTANCE)
    }

    /**
     * Get repeat_calories field
     * Units: calories
     *
     * @return repeat_calories
     */
    fun getRepeatCalories(): Long? {
        return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_CALORIES)
    }

    /**
     * Set repeat_calories field
     * Units: calories
     *
     * @param repeatCalories The new repeatCalories value to be set
     */
    fun setRepeatCalories(repeatCalories: Long?) {
        setFieldValue(4, 0, repeatCalories, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_CALORIES)
    }

    /**
     * Get repeat_hr field
     * Units: % or bpm
     *
     * @return repeat_hr
     */
    fun getRepeatHr(): Long? {
        return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_HR)
    }

    /**
     * Set repeat_hr field
     * Units: % or bpm
     *
     * @param repeatHr The new repeatHr value to be set
     */
    fun setRepeatHr(repeatHr: Long?) {
        setFieldValue(4, 0, repeatHr, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_HR)
    }

    /**
     * Get repeat_power field
     * Units: % or watts
     *
     * @return repeat_power
     */
    fun getRepeatPower(): Long? {
        return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_POWER)
    }

    /**
     * Set repeat_power field
     * Units: % or watts
     *
     * @param repeatPower The new repeatPower value to be set
     */
    fun setRepeatPower(repeatPower: Long?) {
        setFieldValue(4, 0, repeatPower, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_POWER)
    }

    /**
     * Get target_stroke_type field
     *
     * @return target_stroke_type
     */
    fun getTargetStrokeType(): SwimStroke? {
        val value = getFieldShortValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_STROKE_TYPE) ?: return null
        return SwimStroke.fromValue(value)
    }

    /**
     * Set target_stroke_type field
     *
     * @param targetStrokeType The new targetStrokeType value to be set
     */
    fun setTargetStrokeType(targetStrokeType: SwimStroke?) {
        setFieldValue(4, 0, targetStrokeType?.value, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_STROKE_TYPE)
    }

    /**
     * Get custom_target_value_low field
     *
     * @return custom_target_value_low
     */
    fun getCustomTargetValueLow(): Long? {
        return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set custom_target_value_low field
     *
     * @param customTargetValueLow The new customTargetValueLow value to be set
     */
    fun setCustomTargetValueLow(customTargetValueLow: Long?) {
        setFieldValue(5, 0, customTargetValueLow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get custom_target_speed_low field
     * Units: m/s
     *
     * @return custom_target_speed_low
     */
    fun getCustomTargetSpeedLow(): Float? {
        return getFieldFloatValue(5, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_SPEED_LOW)
    }

    /**
     * Set custom_target_speed_low field
     * Units: m/s
     *
     * @param customTargetSpeedLow The new customTargetSpeedLow value to be set
     */
    fun setCustomTargetSpeedLow(customTargetSpeedLow: Float?) {
        setFieldValue(5, 0, customTargetSpeedLow, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_SPEED_LOW)
    }

    /**
     * Get custom_target_heart_rate_low field
     * Units: % or bpm
     *
     * @return custom_target_heart_rate_low
     */
    fun getCustomTargetHeartRateLow(): Long? {
        return getFieldLongValue(5, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_HEART_RATE_LOW)
    }

    /**
     * Set custom_target_heart_rate_low field
     * Units: % or bpm
     *
     * @param customTargetHeartRateLow The new customTargetHeartRateLow value to be set
     */
    fun setCustomTargetHeartRateLow(customTargetHeartRateLow: Long?) {
        setFieldValue(5, 0, customTargetHeartRateLow, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_HEART_RATE_LOW)
    }

    /**
     * Get custom_target_cadence_low field
     * Units: rpm
     *
     * @return custom_target_cadence_low
     */
    fun getCustomTargetCadenceLow(): Long? {
        return getFieldLongValue(5, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_CADENCE_LOW)
    }

    /**
     * Set custom_target_cadence_low field
     * Units: rpm
     *
     * @param customTargetCadenceLow The new customTargetCadenceLow value to be set
     */
    fun setCustomTargetCadenceLow(customTargetCadenceLow: Long?) {
        setFieldValue(5, 0, customTargetCadenceLow, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_CADENCE_LOW)
    }

    /**
     * Get custom_target_power_low field
     * Units: % or watts
     *
     * @return custom_target_power_low
     */
    fun getCustomTargetPowerLow(): Long? {
        return getFieldLongValue(5, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_POWER_LOW)
    }

    /**
     * Set custom_target_power_low field
     * Units: % or watts
     *
     * @param customTargetPowerLow The new customTargetPowerLow value to be set
     */
    fun setCustomTargetPowerLow(customTargetPowerLow: Long?) {
        setFieldValue(5, 0, customTargetPowerLow, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_POWER_LOW)
    }

    /**
     * Get custom_target_value_high field
     *
     * @return custom_target_value_high
     */
    fun getCustomTargetValueHigh(): Long? {
        return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set custom_target_value_high field
     *
     * @param customTargetValueHigh The new customTargetValueHigh value to be set
     */
    fun setCustomTargetValueHigh(customTargetValueHigh: Long?) {
        setFieldValue(6, 0, customTargetValueHigh, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get custom_target_speed_high field
     * Units: m/s
     *
     * @return custom_target_speed_high
     */
    fun getCustomTargetSpeedHigh(): Float? {
        return getFieldFloatValue(6, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_SPEED_HIGH)
    }

    /**
     * Set custom_target_speed_high field
     * Units: m/s
     *
     * @param customTargetSpeedHigh The new customTargetSpeedHigh value to be set
     */
    fun setCustomTargetSpeedHigh(customTargetSpeedHigh: Float?) {
        setFieldValue(6, 0, customTargetSpeedHigh, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_SPEED_HIGH)
    }

    /**
     * Get custom_target_heart_rate_high field
     * Units: % or bpm
     *
     * @return custom_target_heart_rate_high
     */
    fun getCustomTargetHeartRateHigh(): Long? {
        return getFieldLongValue(6, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_HEART_RATE_HIGH)
    }

    /**
     * Set custom_target_heart_rate_high field
     * Units: % or bpm
     *
     * @param customTargetHeartRateHigh The new customTargetHeartRateHigh value to be set
     */
    fun setCustomTargetHeartRateHigh(customTargetHeartRateHigh: Long?) {
        setFieldValue(6, 0, customTargetHeartRateHigh, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_HEART_RATE_HIGH)
    }

    /**
     * Get custom_target_cadence_high field
     * Units: rpm
     *
     * @return custom_target_cadence_high
     */
    fun getCustomTargetCadenceHigh(): Long? {
        return getFieldLongValue(6, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_CADENCE_HIGH)
    }

    /**
     * Set custom_target_cadence_high field
     * Units: rpm
     *
     * @param customTargetCadenceHigh The new customTargetCadenceHigh value to be set
     */
    fun setCustomTargetCadenceHigh(customTargetCadenceHigh: Long?) {
        setFieldValue(6, 0, customTargetCadenceHigh, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_CADENCE_HIGH)
    }

    /**
     * Get custom_target_power_high field
     * Units: % or watts
     *
     * @return custom_target_power_high
     */
    fun getCustomTargetPowerHigh(): Long? {
        return getFieldLongValue(6, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_POWER_HIGH)
    }

    /**
     * Set custom_target_power_high field
     * Units: % or watts
     *
     * @param customTargetPowerHigh The new customTargetPowerHigh value to be set
     */
    fun setCustomTargetPowerHigh(customTargetPowerHigh: Long?) {
        setFieldValue(6, 0, customTargetPowerHigh, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_POWER_HIGH)
    }

    /**
     * Get intensity field
     *
     * @return intensity
     */
    fun getIntensity(): Intensity? {
        val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return Intensity.fromValue(value)
    }

    /**
     * Set intensity field
     *
     * @param intensity The new intensity value to be set
     */
    fun setIntensity(intensity: Intensity?) {
        setFieldValue(7, 0, intensity?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get notes field
     *
     * @return notes
     */
    fun getNotes(): String? {
        return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set notes field
     *
     * @param notes The new notes value to be set
     */
    fun setNotes(notes: String?) {
        setFieldValue(8, 0, notes, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get equipment field
     *
     * @return equipment
     */
    fun getEquipment(): WorkoutEquipment? {
        val value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return WorkoutEquipment.fromValue(value)
    }

    /**
     * Set equipment field
     *
     * @param equipment The new equipment value to be set
     */
    fun setEquipment(equipment: WorkoutEquipment?) {
        setFieldValue(9, 0, equipment?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get exercise_category field
     *
     * @return exercise_category
     */
    fun getExerciseCategory(): Int? {
        return getFieldIntegerValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set exercise_category field
     *
     * @param exerciseCategory The new exerciseCategory value to be set
     */
    fun setExerciseCategory(exerciseCategory: Int?) {
        setFieldValue(10, 0, exerciseCategory, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get exercise_name field
     *
     * @return exercise_name
     */
    fun getExerciseName(): Int? {
        return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set exercise_name field
     *
     * @param exerciseName The new exerciseName value to be set
     */
    fun setExerciseName(exerciseName: Int?) {
        setFieldValue(11, 0, exerciseName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get exercise_weight field
     * Units: kg
     *
     * @return exercise_weight
     */
    fun getExerciseWeight(): Float? {
        return getFieldFloatValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set exercise_weight field
     * Units: kg
     *
     * @param exerciseWeight The new exerciseWeight value to be set
     */
    fun setExerciseWeight(exerciseWeight: Float?) {
        setFieldValue(12, 0, exerciseWeight, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get weight_display_unit field
     *
     * @return weight_display_unit
     */
    fun getWeightDisplayUnit(): Int? {
        return getFieldIntegerValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set weight_display_unit field
     *
     * @param weightDisplayUnit The new weightDisplayUnit value to be set
     */
    fun setWeightDisplayUnit(weightDisplayUnit: Int?) {
        setFieldValue(13, 0, weightDisplayUnit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get secondary_target_type field
     *
     * @return secondary_target_type
     */
    fun getSecondaryTargetType(): WktStepTarget? {
        val value = getFieldShortValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
        return WktStepTarget.fromValue(value)
    }

    /**
     * Set secondary_target_type field
     *
     * @param secondaryTargetType The new secondaryTargetType value to be set
     */
    fun setSecondaryTargetType(secondaryTargetType: WktStepTarget?) {
        setFieldValue(19, 0, secondaryTargetType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get secondary_target_value field
     *
     * @return secondary_target_value
     */
    fun getSecondaryTargetValue(): Long? {
        return getFieldLongValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set secondary_target_value field
     *
     * @param secondaryTargetValue The new secondaryTargetValue value to be set
     */
    fun setSecondaryTargetValue(secondaryTargetValue: Long?) {
        setFieldValue(20, 0, secondaryTargetValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get secondary_target_speed_zone field
     * Comment: speed zone (1-10);Custom =0;
     *
     * @return secondary_target_speed_zone
     */
    fun getSecondaryTargetSpeedZone(): Long? {
        return getFieldLongValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_SPEED_ZONE)
    }

    /**
     * Set secondary_target_speed_zone field
     * Comment: speed zone (1-10);Custom =0;
     *
     * @param secondaryTargetSpeedZone The new secondaryTargetSpeedZone value to be set
     */
    fun setSecondaryTargetSpeedZone(secondaryTargetSpeedZone: Long?) {
        setFieldValue(20, 0, secondaryTargetSpeedZone, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_SPEED_ZONE)
    }

    /**
     * Get secondary_target_hr_zone field
     * Comment: hr zone (1-5);Custom =0;
     *
     * @return secondary_target_hr_zone
     */
    fun getSecondaryTargetHrZone(): Long? {
        return getFieldLongValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_HR_ZONE)
    }

    /**
     * Set secondary_target_hr_zone field
     * Comment: hr zone (1-5);Custom =0;
     *
     * @param secondaryTargetHrZone The new secondaryTargetHrZone value to be set
     */
    fun setSecondaryTargetHrZone(secondaryTargetHrZone: Long?) {
        setFieldValue(20, 0, secondaryTargetHrZone, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_HR_ZONE)
    }

    /**
     * Get secondary_target_cadence_zone field
     * Comment: Zone (1-?); Custom = 0;
     *
     * @return secondary_target_cadence_zone
     */
    fun getSecondaryTargetCadenceZone(): Long? {
        return getFieldLongValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_CADENCE_ZONE)
    }

    /**
     * Set secondary_target_cadence_zone field
     * Comment: Zone (1-?); Custom = 0;
     *
     * @param secondaryTargetCadenceZone The new secondaryTargetCadenceZone value to be set
     */
    fun setSecondaryTargetCadenceZone(secondaryTargetCadenceZone: Long?) {
        setFieldValue(20, 0, secondaryTargetCadenceZone, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_CADENCE_ZONE)
    }

    /**
     * Get secondary_target_power_zone field
     * Comment: Power Zone ( 1-7); Custom = 0;
     *
     * @return secondary_target_power_zone
     */
    fun getSecondaryTargetPowerZone(): Long? {
        return getFieldLongValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_POWER_ZONE)
    }

    /**
     * Set secondary_target_power_zone field
     * Comment: Power Zone ( 1-7); Custom = 0;
     *
     * @param secondaryTargetPowerZone The new secondaryTargetPowerZone value to be set
     */
    fun setSecondaryTargetPowerZone(secondaryTargetPowerZone: Long?) {
        setFieldValue(20, 0, secondaryTargetPowerZone, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_POWER_ZONE)
    }

    /**
     * Get secondary_target_stroke_type field
     *
     * @return secondary_target_stroke_type
     */
    fun getSecondaryTargetStrokeType(): SwimStroke? {
        val value = getFieldShortValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_STROKE_TYPE) ?: return null
        return SwimStroke.fromValue(value)
    }

    /**
     * Set secondary_target_stroke_type field
     *
     * @param secondaryTargetStrokeType The new secondaryTargetStrokeType value to be set
     */
    fun setSecondaryTargetStrokeType(secondaryTargetStrokeType: SwimStroke?) {
        setFieldValue(20, 0, secondaryTargetStrokeType?.value, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_STROKE_TYPE)
    }

    /**
     * Get secondary_custom_target_value_low field
     *
     * @return secondary_custom_target_value_low
     */
    fun getSecondaryCustomTargetValueLow(): Long? {
        return getFieldLongValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set secondary_custom_target_value_low field
     *
     * @param secondaryCustomTargetValueLow The new secondaryCustomTargetValueLow value to be set
     */
    fun setSecondaryCustomTargetValueLow(secondaryCustomTargetValueLow: Long?) {
        setFieldValue(21, 0, secondaryCustomTargetValueLow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get secondary_custom_target_speed_low field
     * Units: m/s
     *
     * @return secondary_custom_target_speed_low
     */
    fun getSecondaryCustomTargetSpeedLow(): Float? {
        return getFieldFloatValue(21, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_LOW)
    }

    /**
     * Set secondary_custom_target_speed_low field
     * Units: m/s
     *
     * @param secondaryCustomTargetSpeedLow The new secondaryCustomTargetSpeedLow value to be set
     */
    fun setSecondaryCustomTargetSpeedLow(secondaryCustomTargetSpeedLow: Float?) {
        setFieldValue(21, 0, secondaryCustomTargetSpeedLow, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_LOW)
    }

    /**
     * Get secondary_custom_target_heart_rate_low field
     * Units: % or bpm
     *
     * @return secondary_custom_target_heart_rate_low
     */
    fun getSecondaryCustomTargetHeartRateLow(): Long? {
        return getFieldLongValue(21, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_LOW)
    }

    /**
     * Set secondary_custom_target_heart_rate_low field
     * Units: % or bpm
     *
     * @param secondaryCustomTargetHeartRateLow The new secondaryCustomTargetHeartRateLow value to be set
     */
    fun setSecondaryCustomTargetHeartRateLow(secondaryCustomTargetHeartRateLow: Long?) {
        setFieldValue(21, 0, secondaryCustomTargetHeartRateLow, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_LOW)
    }

    /**
     * Get secondary_custom_target_cadence_low field
     * Units: rpm
     *
     * @return secondary_custom_target_cadence_low
     */
    fun getSecondaryCustomTargetCadenceLow(): Long? {
        return getFieldLongValue(21, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_LOW)
    }

    /**
     * Set secondary_custom_target_cadence_low field
     * Units: rpm
     *
     * @param secondaryCustomTargetCadenceLow The new secondaryCustomTargetCadenceLow value to be set
     */
    fun setSecondaryCustomTargetCadenceLow(secondaryCustomTargetCadenceLow: Long?) {
        setFieldValue(21, 0, secondaryCustomTargetCadenceLow, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_LOW)
    }

    /**
     * Get secondary_custom_target_power_low field
     * Units: % or watts
     *
     * @return secondary_custom_target_power_low
     */
    fun getSecondaryCustomTargetPowerLow(): Long? {
        return getFieldLongValue(21, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_POWER_LOW)
    }

    /**
     * Set secondary_custom_target_power_low field
     * Units: % or watts
     *
     * @param secondaryCustomTargetPowerLow The new secondaryCustomTargetPowerLow value to be set
     */
    fun setSecondaryCustomTargetPowerLow(secondaryCustomTargetPowerLow: Long?) {
        setFieldValue(21, 0, secondaryCustomTargetPowerLow, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_POWER_LOW)
    }

    /**
     * Get secondary_custom_target_value_high field
     *
     * @return secondary_custom_target_value_high
     */
    fun getSecondaryCustomTargetValueHigh(): Long? {
        return getFieldLongValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set secondary_custom_target_value_high field
     *
     * @param secondaryCustomTargetValueHigh The new secondaryCustomTargetValueHigh value to be set
     */
    fun setSecondaryCustomTargetValueHigh(secondaryCustomTargetValueHigh: Long?) {
        setFieldValue(22, 0, secondaryCustomTargetValueHigh, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get secondary_custom_target_speed_high field
     * Units: m/s
     *
     * @return secondary_custom_target_speed_high
     */
    fun getSecondaryCustomTargetSpeedHigh(): Float? {
        return getFieldFloatValue(22, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_HIGH)
    }

    /**
     * Set secondary_custom_target_speed_high field
     * Units: m/s
     *
     * @param secondaryCustomTargetSpeedHigh The new secondaryCustomTargetSpeedHigh value to be set
     */
    fun setSecondaryCustomTargetSpeedHigh(secondaryCustomTargetSpeedHigh: Float?) {
        setFieldValue(22, 0, secondaryCustomTargetSpeedHigh, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_HIGH)
    }

    /**
     * Get secondary_custom_target_heart_rate_high field
     * Units: % or bpm
     *
     * @return secondary_custom_target_heart_rate_high
     */
    fun getSecondaryCustomTargetHeartRateHigh(): Long? {
        return getFieldLongValue(22, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_HIGH)
    }

    /**
     * Set secondary_custom_target_heart_rate_high field
     * Units: % or bpm
     *
     * @param secondaryCustomTargetHeartRateHigh The new secondaryCustomTargetHeartRateHigh value to be set
     */
    fun setSecondaryCustomTargetHeartRateHigh(secondaryCustomTargetHeartRateHigh: Long?) {
        setFieldValue(22, 0, secondaryCustomTargetHeartRateHigh, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_HIGH)
    }

    /**
     * Get secondary_custom_target_cadence_high field
     * Units: rpm
     *
     * @return secondary_custom_target_cadence_high
     */
    fun getSecondaryCustomTargetCadenceHigh(): Long? {
        return getFieldLongValue(22, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_HIGH)
    }

    /**
     * Set secondary_custom_target_cadence_high field
     * Units: rpm
     *
     * @param secondaryCustomTargetCadenceHigh The new secondaryCustomTargetCadenceHigh value to be set
     */
    fun setSecondaryCustomTargetCadenceHigh(secondaryCustomTargetCadenceHigh: Long?) {
        setFieldValue(22, 0, secondaryCustomTargetCadenceHigh, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_HIGH)
    }

    /**
     * Get secondary_custom_target_power_high field
     * Units: % or watts
     *
     * @return secondary_custom_target_power_high
     */
    fun getSecondaryCustomTargetPowerHigh(): Long? {
        return getFieldLongValue(22, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_POWER_HIGH)
    }

    /**
     * Set secondary_custom_target_power_high field
     * Units: % or watts
     *
     * @param secondaryCustomTargetPowerHigh The new secondaryCustomTargetPowerHigh value to be set
     */
    fun setSecondaryCustomTargetPowerHigh(secondaryCustomTargetPowerHigh: Long?) {
        setFieldValue(22, 0, secondaryCustomTargetPowerHigh, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_POWER_HIGH)
    }
}
