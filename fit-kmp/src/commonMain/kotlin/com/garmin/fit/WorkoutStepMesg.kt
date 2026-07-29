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
    var messageIndex: Int?
        get() {
            return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(messageIndex) {
            setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get wkt_step_name field
     *
     * @return wkt_step_name
     */
    var wktStepName: String?
        get() {
            return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(wktStepName) {
            setFieldValue(0, 0, wktStepName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get duration_type field
     *
     * @return duration_type
     */
    var durationType: WktStepDuration?
        get() {
            val value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return WktStepDuration.fromValue(value)
        }
        set(durationType) {
            setFieldValue(1, 0, durationType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get duration_value field
     *
     * @return duration_value
     */
    var durationValue: Long?
        get() {
            return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(durationValue) {
            setFieldValue(2, 0, durationValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get duration_time field
     * Units: s
     *
     * @return duration_time
     */
    var durationTime: Float?
        get() {
            return getFieldFloatValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_TIME)
        }
        set(durationTime) {
            setFieldValue(2, 0, durationTime, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_TIME)
        }

    /**
     * Get duration_distance field
     * Units: m
     *
     * @return duration_distance
     */
    var durationDistance: Float?
        get() {
            return getFieldFloatValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_DISTANCE)
        }
        set(durationDistance) {
            setFieldValue(2, 0, durationDistance, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_DISTANCE)
        }

    /**
     * Get duration_hr field
     * Units: % or bpm
     *
     * @return duration_hr
     */
    var durationHr: Long?
        get() {
            return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_HR)
        }
        set(durationHr) {
            setFieldValue(2, 0, durationHr, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_HR)
        }

    /**
     * Get duration_calories field
     * Units: calories
     *
     * @return duration_calories
     */
    var durationCalories: Long?
        get() {
            return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_CALORIES)
        }
        set(durationCalories) {
            setFieldValue(2, 0, durationCalories, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_CALORIES)
        }

    /**
     * Get duration_step field
     * Comment: message_index of step to loop back to. Steps are assumed to be in the order by message_index. custom_name and intensity members are undefined for this duration type.
     *
     * @return duration_step
     */
    var durationStep: Long?
        get() {
            return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_STEP)
        }
        set(durationStep) {
            setFieldValue(2, 0, durationStep, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_STEP)
        }

    /**
     * Get duration_power field
     * Units: % or watts
     *
     * @return duration_power
     */
    var durationPower: Long?
        get() {
            return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_POWER)
        }
        set(durationPower) {
            setFieldValue(2, 0, durationPower, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_POWER)
        }

    /**
     * Get duration_reps field
     *
     * @return duration_reps
     */
    var durationReps: Long?
        get() {
            return getFieldLongValue(2, 0, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_REPS)
        }
        set(durationReps) {
            setFieldValue(2, 0, durationReps, Profile.SubFields.WORKOUT_STEP_MESG_DURATION_VALUE_FIELD_DURATION_REPS)
        }

    /**
     * Get target_type field
     *
     * @return target_type
     */
    var targetType: WktStepTarget?
        get() {
            val value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return WktStepTarget.fromValue(value)
        }
        set(targetType) {
            setFieldValue(3, 0, targetType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get target_value field
     *
     * @return target_value
     */
    var targetValue: Long?
        get() {
            return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(targetValue) {
            setFieldValue(4, 0, targetValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get target_speed_zone field
     * Comment: speed zone (1-10);Custom =0;
     *
     * @return target_speed_zone
     */
    var targetSpeedZone: Long?
        get() {
            return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_SPEED_ZONE)
        }
        set(targetSpeedZone) {
            setFieldValue(4, 0, targetSpeedZone, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_SPEED_ZONE)
        }

    /**
     * Get target_hr_zone field
     * Comment: hr zone (1-5);Custom =0;
     *
     * @return target_hr_zone
     */
    var targetHrZone: Long?
        get() {
            return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_HR_ZONE)
        }
        set(targetHrZone) {
            setFieldValue(4, 0, targetHrZone, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_HR_ZONE)
        }

    /**
     * Get target_cadence_zone field
     * Comment: Zone (1-?); Custom = 0;
     *
     * @return target_cadence_zone
     */
    var targetCadenceZone: Long?
        get() {
            return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_CADENCE_ZONE)
        }
        set(targetCadenceZone) {
            setFieldValue(4, 0, targetCadenceZone, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_CADENCE_ZONE)
        }

    /**
     * Get target_power_zone field
     * Comment: Power Zone ( 1-7); Custom = 0;
     *
     * @return target_power_zone
     */
    var targetPowerZone: Long?
        get() {
            return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_POWER_ZONE)
        }
        set(targetPowerZone) {
            setFieldValue(4, 0, targetPowerZone, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_POWER_ZONE)
        }

    /**
     * Get repeat_steps field
     * Comment: # of repetitions
     *
     * @return repeat_steps
     */
    var repeatSteps: Long?
        get() {
            return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_STEPS)
        }
        set(repeatSteps) {
            setFieldValue(4, 0, repeatSteps, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_STEPS)
        }

    /**
     * Get repeat_time field
     * Units: s
     *
     * @return repeat_time
     */
    var repeatTime: Float?
        get() {
            return getFieldFloatValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_TIME)
        }
        set(repeatTime) {
            setFieldValue(4, 0, repeatTime, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_TIME)
        }

    /**
     * Get repeat_distance field
     * Units: m
     *
     * @return repeat_distance
     */
    var repeatDistance: Float?
        get() {
            return getFieldFloatValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_DISTANCE)
        }
        set(repeatDistance) {
            setFieldValue(4, 0, repeatDistance, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_DISTANCE)
        }

    /**
     * Get repeat_calories field
     * Units: calories
     *
     * @return repeat_calories
     */
    var repeatCalories: Long?
        get() {
            return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_CALORIES)
        }
        set(repeatCalories) {
            setFieldValue(4, 0, repeatCalories, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_CALORIES)
        }

    /**
     * Get repeat_hr field
     * Units: % or bpm
     *
     * @return repeat_hr
     */
    var repeatHr: Long?
        get() {
            return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_HR)
        }
        set(repeatHr) {
            setFieldValue(4, 0, repeatHr, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_HR)
        }

    /**
     * Get repeat_power field
     * Units: % or watts
     *
     * @return repeat_power
     */
    var repeatPower: Long?
        get() {
            return getFieldLongValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_POWER)
        }
        set(repeatPower) {
            setFieldValue(4, 0, repeatPower, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_REPEAT_POWER)
        }

    /**
     * Get target_stroke_type field
     *
     * @return target_stroke_type
     */
    var targetStrokeType: SwimStroke?
        get() {
            val value = getFieldShortValue(4, 0, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_STROKE_TYPE) ?: return null
            return SwimStroke.fromValue(value)
        }
        set(targetStrokeType) {
            setFieldValue(4, 0, targetStrokeType?.value, Profile.SubFields.WORKOUT_STEP_MESG_TARGET_VALUE_FIELD_TARGET_STROKE_TYPE)
        }

    /**
     * Get custom_target_value_low field
     *
     * @return custom_target_value_low
     */
    var customTargetValueLow: Long?
        get() {
            return getFieldLongValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(customTargetValueLow) {
            setFieldValue(5, 0, customTargetValueLow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get custom_target_speed_low field
     * Units: m/s
     *
     * @return custom_target_speed_low
     */
    var customTargetSpeedLow: Float?
        get() {
            return getFieldFloatValue(5, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_SPEED_LOW)
        }
        set(customTargetSpeedLow) {
            setFieldValue(5, 0, customTargetSpeedLow, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_SPEED_LOW)
        }

    /**
     * Get custom_target_heart_rate_low field
     * Units: % or bpm
     *
     * @return custom_target_heart_rate_low
     */
    var customTargetHeartRateLow: Long?
        get() {
            return getFieldLongValue(5, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_HEART_RATE_LOW)
        }
        set(customTargetHeartRateLow) {
            setFieldValue(5, 0, customTargetHeartRateLow, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_HEART_RATE_LOW)
        }

    /**
     * Get custom_target_cadence_low field
     * Units: rpm
     *
     * @return custom_target_cadence_low
     */
    var customTargetCadenceLow: Long?
        get() {
            return getFieldLongValue(5, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_CADENCE_LOW)
        }
        set(customTargetCadenceLow) {
            setFieldValue(5, 0, customTargetCadenceLow, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_CADENCE_LOW)
        }

    /**
     * Get custom_target_power_low field
     * Units: % or watts
     *
     * @return custom_target_power_low
     */
    var customTargetPowerLow: Long?
        get() {
            return getFieldLongValue(5, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_POWER_LOW)
        }
        set(customTargetPowerLow) {
            setFieldValue(5, 0, customTargetPowerLow, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_LOW_FIELD_CUSTOM_TARGET_POWER_LOW)
        }

    /**
     * Get custom_target_value_high field
     *
     * @return custom_target_value_high
     */
    var customTargetValueHigh: Long?
        get() {
            return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(customTargetValueHigh) {
            setFieldValue(6, 0, customTargetValueHigh, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get custom_target_speed_high field
     * Units: m/s
     *
     * @return custom_target_speed_high
     */
    var customTargetSpeedHigh: Float?
        get() {
            return getFieldFloatValue(6, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_SPEED_HIGH)
        }
        set(customTargetSpeedHigh) {
            setFieldValue(6, 0, customTargetSpeedHigh, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_SPEED_HIGH)
        }

    /**
     * Get custom_target_heart_rate_high field
     * Units: % or bpm
     *
     * @return custom_target_heart_rate_high
     */
    var customTargetHeartRateHigh: Long?
        get() {
            return getFieldLongValue(6, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_HEART_RATE_HIGH)
        }
        set(customTargetHeartRateHigh) {
            setFieldValue(6, 0, customTargetHeartRateHigh, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_HEART_RATE_HIGH)
        }

    /**
     * Get custom_target_cadence_high field
     * Units: rpm
     *
     * @return custom_target_cadence_high
     */
    var customTargetCadenceHigh: Long?
        get() {
            return getFieldLongValue(6, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_CADENCE_HIGH)
        }
        set(customTargetCadenceHigh) {
            setFieldValue(6, 0, customTargetCadenceHigh, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_CADENCE_HIGH)
        }

    /**
     * Get custom_target_power_high field
     * Units: % or watts
     *
     * @return custom_target_power_high
     */
    var customTargetPowerHigh: Long?
        get() {
            return getFieldLongValue(6, 0, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_POWER_HIGH)
        }
        set(customTargetPowerHigh) {
            setFieldValue(6, 0, customTargetPowerHigh, Profile.SubFields.WORKOUT_STEP_MESG_CUSTOM_TARGET_VALUE_HIGH_FIELD_CUSTOM_TARGET_POWER_HIGH)
        }

    /**
     * Get intensity field
     *
     * @return intensity
     */
    var intensity: Intensity?
        get() {
            val value = getFieldShortValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return Intensity.fromValue(value)
        }
        set(intensity) {
            setFieldValue(7, 0, intensity?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get notes field
     *
     * @return notes
     */
    var notes: String?
        get() {
            return getFieldStringValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(notes) {
            setFieldValue(8, 0, notes, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get equipment field
     *
     * @return equipment
     */
    var equipment: WorkoutEquipment?
        get() {
            val value = getFieldShortValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return WorkoutEquipment.fromValue(value)
        }
        set(equipment) {
            setFieldValue(9, 0, equipment?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get exercise_category field
     *
     * @return exercise_category
     */
    var exerciseCategory: Int?
        get() {
            return getFieldIntegerValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(exerciseCategory) {
            setFieldValue(10, 0, exerciseCategory, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get exercise_name field
     *
     * @return exercise_name
     */
    var exerciseName: Int?
        get() {
            return getFieldIntegerValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(exerciseName) {
            setFieldValue(11, 0, exerciseName, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get exercise_weight field
     * Units: kg
     *
     * @return exercise_weight
     */
    var exerciseWeight: Float?
        get() {
            return getFieldFloatValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(exerciseWeight) {
            setFieldValue(12, 0, exerciseWeight, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get weight_display_unit field
     *
     * @return weight_display_unit
     */
    var weightDisplayUnit: Int?
        get() {
            return getFieldIntegerValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(weightDisplayUnit) {
            setFieldValue(13, 0, weightDisplayUnit, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get secondary_target_type field
     *
     * @return secondary_target_type
     */
    var secondaryTargetType: WktStepTarget?
        get() {
            val value = getFieldShortValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD) ?: return null
            return WktStepTarget.fromValue(value)
        }
        set(secondaryTargetType) {
            setFieldValue(19, 0, secondaryTargetType?.value, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get secondary_target_value field
     *
     * @return secondary_target_value
     */
    var secondaryTargetValue: Long?
        get() {
            return getFieldLongValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(secondaryTargetValue) {
            setFieldValue(20, 0, secondaryTargetValue, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get secondary_target_speed_zone field
     * Comment: speed zone (1-10);Custom =0;
     *
     * @return secondary_target_speed_zone
     */
    var secondaryTargetSpeedZone: Long?
        get() {
            return getFieldLongValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_SPEED_ZONE)
        }
        set(secondaryTargetSpeedZone) {
            setFieldValue(20, 0, secondaryTargetSpeedZone, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_SPEED_ZONE)
        }

    /**
     * Get secondary_target_hr_zone field
     * Comment: hr zone (1-5);Custom =0;
     *
     * @return secondary_target_hr_zone
     */
    var secondaryTargetHrZone: Long?
        get() {
            return getFieldLongValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_HR_ZONE)
        }
        set(secondaryTargetHrZone) {
            setFieldValue(20, 0, secondaryTargetHrZone, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_HR_ZONE)
        }

    /**
     * Get secondary_target_cadence_zone field
     * Comment: Zone (1-?); Custom = 0;
     *
     * @return secondary_target_cadence_zone
     */
    var secondaryTargetCadenceZone: Long?
        get() {
            return getFieldLongValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_CADENCE_ZONE)
        }
        set(secondaryTargetCadenceZone) {
            setFieldValue(20, 0, secondaryTargetCadenceZone, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_CADENCE_ZONE)
        }

    /**
     * Get secondary_target_power_zone field
     * Comment: Power Zone ( 1-7); Custom = 0;
     *
     * @return secondary_target_power_zone
     */
    var secondaryTargetPowerZone: Long?
        get() {
            return getFieldLongValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_POWER_ZONE)
        }
        set(secondaryTargetPowerZone) {
            setFieldValue(20, 0, secondaryTargetPowerZone, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_POWER_ZONE)
        }

    /**
     * Get secondary_target_stroke_type field
     *
     * @return secondary_target_stroke_type
     */
    var secondaryTargetStrokeType: SwimStroke?
        get() {
            val value = getFieldShortValue(20, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_STROKE_TYPE) ?: return null
            return SwimStroke.fromValue(value)
        }
        set(secondaryTargetStrokeType) {
            setFieldValue(20, 0, secondaryTargetStrokeType?.value, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_TARGET_VALUE_FIELD_SECONDARY_TARGET_STROKE_TYPE)
        }

    /**
     * Get secondary_custom_target_value_low field
     *
     * @return secondary_custom_target_value_low
     */
    var secondaryCustomTargetValueLow: Long?
        get() {
            return getFieldLongValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(secondaryCustomTargetValueLow) {
            setFieldValue(21, 0, secondaryCustomTargetValueLow, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get secondary_custom_target_speed_low field
     * Units: m/s
     *
     * @return secondary_custom_target_speed_low
     */
    var secondaryCustomTargetSpeedLow: Float?
        get() {
            return getFieldFloatValue(21, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_LOW)
        }
        set(secondaryCustomTargetSpeedLow) {
            setFieldValue(21, 0, secondaryCustomTargetSpeedLow, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_LOW)
        }

    /**
     * Get secondary_custom_target_heart_rate_low field
     * Units: % or bpm
     *
     * @return secondary_custom_target_heart_rate_low
     */
    var secondaryCustomTargetHeartRateLow: Long?
        get() {
            return getFieldLongValue(21, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_LOW)
        }
        set(secondaryCustomTargetHeartRateLow) {
            setFieldValue(21, 0, secondaryCustomTargetHeartRateLow, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_LOW)
        }

    /**
     * Get secondary_custom_target_cadence_low field
     * Units: rpm
     *
     * @return secondary_custom_target_cadence_low
     */
    var secondaryCustomTargetCadenceLow: Long?
        get() {
            return getFieldLongValue(21, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_LOW)
        }
        set(secondaryCustomTargetCadenceLow) {
            setFieldValue(21, 0, secondaryCustomTargetCadenceLow, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_LOW)
        }

    /**
     * Get secondary_custom_target_power_low field
     * Units: % or watts
     *
     * @return secondary_custom_target_power_low
     */
    var secondaryCustomTargetPowerLow: Long?
        get() {
            return getFieldLongValue(21, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_POWER_LOW)
        }
        set(secondaryCustomTargetPowerLow) {
            setFieldValue(21, 0, secondaryCustomTargetPowerLow, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_LOW_FIELD_SECONDARY_CUSTOM_TARGET_POWER_LOW)
        }

    /**
     * Get secondary_custom_target_value_high field
     *
     * @return secondary_custom_target_value_high
     */
    var secondaryCustomTargetValueHigh: Long?
        get() {
            return getFieldLongValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }
        set(secondaryCustomTargetValueHigh) {
            setFieldValue(22, 0, secondaryCustomTargetValueHigh, Fit.SUBFIELD_INDEX_MAIN_FIELD)
        }

    /**
     * Get secondary_custom_target_speed_high field
     * Units: m/s
     *
     * @return secondary_custom_target_speed_high
     */
    var secondaryCustomTargetSpeedHigh: Float?
        get() {
            return getFieldFloatValue(22, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_HIGH)
        }
        set(secondaryCustomTargetSpeedHigh) {
            setFieldValue(22, 0, secondaryCustomTargetSpeedHigh, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_SPEED_HIGH)
        }

    /**
     * Get secondary_custom_target_heart_rate_high field
     * Units: % or bpm
     *
     * @return secondary_custom_target_heart_rate_high
     */
    var secondaryCustomTargetHeartRateHigh: Long?
        get() {
            return getFieldLongValue(22, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_HIGH)
        }
        set(secondaryCustomTargetHeartRateHigh) {
            setFieldValue(22, 0, secondaryCustomTargetHeartRateHigh, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_HEART_RATE_HIGH)
        }

    /**
     * Get secondary_custom_target_cadence_high field
     * Units: rpm
     *
     * @return secondary_custom_target_cadence_high
     */
    var secondaryCustomTargetCadenceHigh: Long?
        get() {
            return getFieldLongValue(22, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_HIGH)
        }
        set(secondaryCustomTargetCadenceHigh) {
            setFieldValue(22, 0, secondaryCustomTargetCadenceHigh, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_CADENCE_HIGH)
        }

    /**
     * Get secondary_custom_target_power_high field
     * Units: % or watts
     *
     * @return secondary_custom_target_power_high
     */
    var secondaryCustomTargetPowerHigh: Long?
        get() {
            return getFieldLongValue(22, 0, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_POWER_HIGH)
        }
        set(secondaryCustomTargetPowerHigh) {
            setFieldValue(22, 0, secondaryCustomTargetPowerHigh, Profile.SubFields.WORKOUT_STEP_MESG_SECONDARY_CUSTOM_TARGET_VALUE_HIGH_FIELD_SECONDARY_CUSTOM_TARGET_POWER_HIGH)
        }
}
