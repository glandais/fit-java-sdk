// Hand-written multiplatform port of MonitoringReader.java — keep in sync (see overrides/hashes.json).
// TreeMap has no common-stdlib counterpart: HashMap + `keys.sorted()` is used at every
// iteration point to preserve the ActivityType ordering of the Java implementation
// (see DESIGN.md §4.4).
package com.garmin.fit

class MonitoringReader(interval: Int) : MonitoringInfoMesgListener,
    MonitoringMesgListener, DeviceSettingsMesgListener, FileIdMesgListener {

    /**
     * This class consists of data members used to hold the cumulative totals
     * for calories and calories cycles, as well as distance and distance cycles.
     */
    private class ExtractState {
        var cyclesToCaloriesStartCycles: Float = 0f
        var cyclesToCaloriesStartCal: Int = 0
        var cyclesToDistanceStartCycles: Float = 0f
        var cyclesToDistanceStartDist: Float = 0f
    }

    private val accumulatedFieldNames = arrayOf(
        CYCLES_STRING,
        DISTANCE_STRING,
        ACTIVE_CAL_STRING,
        CALORIE_STRING,
        ACTIVE_TIME_STRING
    )

    private val instantaneousFieldNames = arrayOf(
        INTENSITY_STRING,
        HR_STRING,
        TEMPERATURE_STRING
    )

    private val summedInstantaneousFieldNames = arrayOf(
        ASCENT_STRING,
        DESCENT_STRING,
        MOD_ACTIVITY_MIN_STRING,
        VIG_ACTIVITY_MIN_STRING
    )

    private val listeners: ArrayList<MonitoringMesgListener>
    private val interval: Int
    private var outputDailyTotals: Boolean
    private var infoMesg: MonitoringInfoMesg? = null
    private var lastAccumMesg: MonitoringMesg? = null
    private var lastSummedInstMesg: MonitoringMesg? = null
    private val intervalMesgs: HashMap<ActivityType, ArrayList<MonitoringMesg>>
    private val lastMesgs: HashMap<ActivityType, MonitoringMesg>
    private var startTimestamp: Long = 0
    private var endTimestamp: Long = 0
    private var lastTimestamp: Long = 0
    private var localTimeOffset: Long
    private var mesgTimestamp: Long = 0 // Last message timestamp, not converted from
                                        // system time. Used to extract compressed
                                        // timestamp fields.
    private var systemToUtcTimestampOffset: Long
    private var systemToLocalTimestampOffset: Long
    private val summedInstantaneousFields: HashSet<String>
    private val extractStates: HashMap<ActivityType, ExtractState>
    private val includedFields: HashMap<String, Boolean>

    /**
     * @param interval
     *           Duration of time to be contained in the broadcast monitoring
     *           messages.
     */
    init {
        if ((interval < 0) || (interval > DAILY_INTERVAL)) {
            throw FitRuntimeException(
                interval.toString() +
                    "s is invalid.  Output interval duration must be between 1s and 86400s (1 day)."
            )
        }

        listeners = ArrayList()
        this.interval = interval
        outputDailyTotals = false
        intervalMesgs = HashMap()
        lastMesgs = HashMap()
        localTimeOffset = 0
        systemToUtcTimestampOffset = 0
        systemToLocalTimestampOffset = 0
        extractStates = HashMap()
        includedFields = HashMap()
        summedInstantaneousFields = HashSet()
        for (i in summedInstantaneousFieldNames.indices) {
            summedInstantaneousFields.add(summedInstantaneousFieldNames[i])
        }

        includedFields[CYCLES_STRING] = true
        includedFields[DISTANCE_STRING] = true
        includedFields[ACTIVE_CAL_STRING] = true
        includedFields[CALORIE_STRING] = true
        includedFields[ACTIVE_TIME_STRING] = true
        includedFields[INTENSITY_STRING] = true
        includedFields[HR_STRING] = true
        includedFields[TEMPERATURE_STRING] = true
        includedFields[ASCENT_STRING] = true
        includedFields[DESCENT_STRING] = true
        includedFields[MOD_ACTIVITY_MIN_STRING] = true
        includedFields[VIG_ACTIVITY_MIN_STRING] = true
    }

    fun setFieldIncluded(field: String, state: Boolean) {
        includedFields[field] = state
    }

    fun getFieldStates(): HashMap<String, Boolean> {
        return HashMap(includedFields)
    }

    fun excludeAllFields() {
        for (key in includedFields.keys.toList()) {
            includedFields[key] = false
        }
    }

    fun includeAllFields() {
        for (key in includedFields.keys.toList()) {
            includedFields[key] = true
        }
    }

    /**
     * Enables output of data from start of day instead of start of file.
     * Cumulative fields such as steps are accumulated from the start of the day
     * so daily totals can be computed from a file that does not include data for
     * earlier in the day.
     *
     * Instantaneous fields such as intensity and heart rate are not output
     * in this mode because data for the whole day is required.
     */
    fun outputDailyTotals() {
        if (interval != DAILY_INTERVAL) {
            throw FitRuntimeException("Interval must be 86400s to output daily totals")
        }

        outputDailyTotals = true
    }

    /**
     * Set offset in seconds from system time to UTC time. Used to convert system
     * timestamps to UTC.
     *
     * @param offset
     *           UTC offset in seconds
     */
    fun setSystemToUtcTimestampOffset(offset: Long) {
        systemToUtcTimestampOffset = offset
    }

    /**
     * Set offset in seconds from system time to local time. Used to convert
     * system timestamps to local time.
     *
     * @param offset
     *           local time offset in seconds
     */
    fun setSystemToLocalTimestampOffset(offset: Long) {
        systemToLocalTimestampOffset = offset
    }

    /**
     * Adds a listener for decoded monitoring data. Listener will receive
     * monitoring data at interval specified in constructor. Data in the
     * monitoring message is the total for the interval (not cumulative).
     *
     * @param mesgListener
     *           Listener for output monitoring data messages
     */
    fun addListener(mesgListener: MonitoringMesgListener) {
        listeners.add(mesgListener)
    }

    /**
     * Broadcast all pending monitoring data. Call after reading file to flush
     * partial intervals. If pending monitoring data does not align to interval
     * boundary then timestamp will correspond to end of data and duration
     * indicates partial interval.
     */
    fun broadcast() {
        while (broadcastInterval(false)) {
        }
    }

    private fun broadcastCompleteIntervals() {
        while (broadcastInterval(true)) {
        }
    }

    private fun broadcastInterval(broadcastCompleteIntervalsOnly: Boolean): Boolean {
        val broadcastMesgs = HashMap<ActivityType, MonitoringMesg>()
        var allActivityBroadcastMesg: MonitoringMesg? = null
        val allActivityTotals: MonitoringMesg

        if (endTimestamp == lastTimestamp) {
            return false // Already broadcast all pending data.
        }

        // Adjust start timestamp from start of file to start of day for daily total output.
        if (outputDailyTotals) {
            startTimestamp = modTimestampToLocalInterval(startTimestamp)
        }

        // Initialize end timestamp if required.
        if (endTimestamp < startTimestamp) {
            endTimestamp = modTimestampToLocalInterval(startTimestamp)
        }

        // If the last data timestamp is within the next interval then this interval is incomplete.
        if (broadcastCompleteIntervalsOnly && ((endTimestamp + interval) > lastTimestamp)) {
            return false
        }

        // Broadcast to end of interval.
        endTimestamp += interval

        // If start timestamp is already at end of interval then broadcast all pending data to the last message received.
        // This is the end of file case when broadcast() is called to flush all data.
        if (endTimestamp > lastTimestamp) {
            endTimestamp = lastTimestamp
        }

        for (activityType in intervalMesgs.keys.sorted()) {
            val mesgList = intervalMesgs[activityType]!!
            val mesg = computeInterval(activityType, mesgList)
            var i: Int

            if (mesg != null) {
                broadcastMesgs[activityType] = mesg

                if (mesg.getActivityType() == ActivityType.ALL) {
                    allActivityBroadcastMesg = mesg
                }
            }

            // Initialize for next interval by removing all messages up to the end of this interval.
            // One message at or before the end of the interval is retained to initialize the start of the next interval.
            i = 0
            while (i < mesgList.size) {
                if (mesgList[i].getTimestamp()!!.getTimestamp() > endTimestamp) {
                    break
                }

                i++
            }
            i-- // Decrement to point to the start message.
            while (i > 0) {
                mesgList.removeAt(--i)
            }
        }

        if (broadcastMesgs.size > 0) {
            val sortedActivityTypes = broadcastMesgs.keys.sorted()
            var mesg = broadcastMesgs[sortedActivityTypes[0]]!!

            // Compute totals for all activity.
            allActivityTotals = MonitoringMesg()
            allActivityTotals.setTimestamp(mesg.getTimestamp())
            allActivityTotals.setLocalTimestamp(mesg.getLocalTimestamp())
            allActivityTotals.setActivityType(ActivityType.ALL)
            allActivityTotals.setDuration(mesg.getDuration())

            for (activityType in sortedActivityTypes) {
                mesg = broadcastMesgs[activityType]!!

                if (mesg.getActivityType() != ActivityType.ALL) {
                    for (fieldName in accumulatedFieldNames) {
                        if (mesg.getFieldDoubleValue(fieldName) != null) {
                            if (allActivityTotals.getFieldDoubleValue(fieldName) == null) {
                                allActivityTotals.setFieldValue(fieldName, 0.0f)
                            }

                            allActivityTotals.setFieldValue(
                                fieldName,
                                allActivityTotals.getFieldDoubleValue(fieldName)!! +
                                    mesg.getFieldDoubleValue(fieldName)!!
                            )
                        }
                    }
                    for (fieldName in summedInstantaneousFieldNames) {
                        if (mesg.getFieldDoubleValue(fieldName) != null) {
                            if (allActivityTotals.getFieldDoubleValue(fieldName) == null) {
                                allActivityTotals.setFieldValue(fieldName, 0.0f)
                            }

                            allActivityTotals.setFieldValue(
                                fieldName,
                                allActivityTotals.getFieldDoubleValue(fieldName)!! +
                                    mesg.getFieldDoubleValue(fieldName)!!
                            )
                        }
                    }
                }
            }

            // Compute total calories if not logged by device.
            if (allActivityTotals.getCalories() == null) {
                if (infoMesg!!.getRestingMetabolicRate() != null) {
                    allActivityTotals.setCalories(
                        (allActivityTotals.getDuration()!! * infoMesg!!.getRestingMetabolicRate()!! / (24 * 3600)).toInt()
                    )

                    if (allActivityTotals.getActiveCalories() != null) {
                        allActivityTotals.setCalories(
                            allActivityTotals.getCalories()!! + allActivityTotals.getActiveCalories()!!
                        )
                    }
                }
            }

            // Add the totals to the broadcast messages.
            // If the device logged data for all activity then only set computed
            // totals for fields that are not logged by the device (don't override
            // device data).
            if (allActivityBroadcastMesg != null) {
                for (field in allActivityTotals.fields) {
                    if (allActivityBroadcastMesg.getField(field.getNum()) == null) {
                        allActivityBroadcastMesg.setField(field)
                    }
                }
            } else {
                broadcastMesgs[ActivityType.ALL] = allActivityTotals
            }

            // Broadcast messages to listeners.
            for (activityType in broadcastMesgs.keys.sorted()) {
                for (listener in listeners) {
                    listener.onMesg(broadcastMesgs[activityType]!!)
                }
            }

            // Initialize for next interval.
            startTimestamp = endTimestamp
        }

        return true
    }

    /**
     * Performs any device specific logic.
     *
     * @param mesg the message containing needed information.
     */
    override fun onMesg(mesg: FileIdMesg) {
        return
    }

    /**
     * Updates the stored information message and local time offset from
     * information contained in the passed in [MonitoringInfoMesg].
     *
     * @param mesg
     *           The message containing cycle conversion factors
     */
    override fun onMesg(mesg: MonitoringInfoMesg) {
        val utcTimestamp: DateTime
        val localTimestamp: LocalDateTime

        infoMesg = mesg
        utcTimestamp = infoMesg!!.getTimestamp()!!
        mesgTimestamp = utcTimestamp.getTimestamp()
        utcTimestamp.convertSystemTimeToUTC(systemToUtcTimestampOffset)
        infoMesg!!.setTimestamp(utcTimestamp)
        lastTimestamp = utcTimestamp.getTimestamp()

        if (infoMesg!!.getLocalTimestamp() != null) {
            localTimestamp = LocalDateTime(infoMesg!!.getLocalTimestamp()!!)
            localTimestamp.convertSystemTimeToLocal(systemToLocalTimestampOffset)
            localTimeOffset = localTimestamp.getTimestamp() - lastTimestamp
        } else {
            localTimeOffset = systemToLocalTimestampOffset - systemToUtcTimestampOffset
        }

        startTimestamp = lastTimestamp
    }

    /**
     * Extracts data from the passed in [MonitoringMesg] into a new message,
     * then updates the list of messages in the interval and the last message variable.
     *
     * @param mesg
     *           The message containing needed information
     */
    override fun onMesg(mesg: MonitoringMesg) {
        val nextMesg: MonitoringMesg
        var lastMesg: MonitoringMesg?
        var intervalMesgList: ArrayList<MonitoringMesg>?
        var intervalMesg: MonitoringMesg?

        if (infoMesg == null) {
            return // Can't process monitoring data messages without info
                   // message.
        }

        nextMesg = extract(mesg)

        // If activity type is not specified then the data applies to all.
        if (nextMesg.getActivityType() == null) {
            nextMesg.setActivityType(ActivityType.ALL)
        }

        // Ignore messages with no timestamp field (invalid).
        if (nextMesg.getTimestamp() == null) {
            return
        }

        // Wait for the next message with a different timestamp before
        // processing the last message because there can be multiple messages
        // (activity types) with the same timestamp.
        if (lastTimestamp != nextMesg.getTimestamp()!!.getTimestamp()) {
            // If we have all the messages for this interval.
            if ((lastTimestamp - modTimestampToLocalInterval(startTimestamp)) >= interval) {
                broadcastCompleteIntervals()
            }
        }

        // If the current activity type is logged then accumulated values for other activity types have not changed last since message.
        // This is an implied start for other activity types so insert a message with last known accumulated values.
        if (mesg.getCurrentActivityTypeIntensity() != null) {
            lastMesg = lastMesgs[nextMesg.getActivityType()!!]

            if (lastMesg == null) {
                intervalMesgList = ArrayList()
                intervalMesg = MonitoringMesg()
                intervalMesg.setActivityType(nextMesg.getActivityType())
                intervalMesg.setTimestamp(
                    DateTime(nextMesg.getTimestamp()!!.getTimestamp() - nextMesg.getActiveTime()!!.toLong())
                )
                intervalMesgList.add(intervalMesg)
                intervalMesgs[intervalMesg.getActivityType()!!] = intervalMesgList
            }

            for (otherActivityTypelastMesg in lastMesgs.keys.sorted().map { lastMesgs[it]!! }) {
                if (otherActivityTypelastMesg.getActivityType() != nextMesg.getActivityType()) {
                    val startMesg = MonitoringMesg()
                    startMesg.setTimestamp(nextMesg.getTimestamp())
                    startMesg.setActivityType(otherActivityTypelastMesg.getActivityType())

                    for (fieldName in accumulatedFieldNames) {
                        if (otherActivityTypelastMesg.getField(fieldName) != null) {
                            startMesg.setField(otherActivityTypelastMesg.getField(fieldName)!!)
                        }
                    }

                    intervalMesgs[startMesg.getActivityType()!!]!!.add(startMesg)
                }
            }
        }

        // Save the last message for decoding of accumulated fields.
        lastTimestamp = nextMesg.getTimestamp()!!.getTimestamp()
        lastMesg = lastMesgs[nextMesg.getActivityType()!!]
        if (lastMesg == null) {
            lastMesg = MonitoringMesg()
            lastMesgs[nextMesg.getActivityType()!!] = lastMesg
        }
        setFieldsFromMesg(lastMesg, nextMesg)

        // Add the next message to the list of messages in this interval.
        // Merge messages of the same activity type and timestamp.
        intervalMesgList = intervalMesgs[nextMesg.getActivityType()!!]
        intervalMesg = null

        if (intervalMesgList == null) {
            intervalMesgList = ArrayList()
            intervalMesgs[nextMesg.getActivityType()!!] = intervalMesgList
        }

        if (intervalMesgList.size > 0) {
            intervalMesg = intervalMesgList[intervalMesgList.size - 1]
        }

        if ((intervalMesg != null) &&
            nextMesg.getTimestamp()!!.equals(intervalMesg.getTimestamp()!!)
        ) {
            setFieldsFromMesg(intervalMesg, nextMesg)
        } else {
            intervalMesgList.add(nextMesg)
        }
    }

    /**
     * Sets the local and UTC time stamp offsets based on information from
     * the passed in [DeviceSettingsMesg]
     *
     * @param mesg
     *           The message containing needed information
     */
    override fun onMesg(mesg: DeviceSettingsMesg) {
        if (mesg.getUtcOffset() != null) {
            var timeZoneIndex = 0
            var offset: Long = mesg.getUtcOffset()!!

            setSystemToUtcTimestampOffset(offset)

            if (mesg.getActiveTimeZone() != null) {
                timeZoneIndex = mesg.getActiveTimeZone()!!.toInt()
            }

            if (mesg.getTimeZoneOffset(timeZoneIndex) != null) {
                // Java compound assignment (long += double) truncates back to long.
                offset = (offset + mesg.getTimeZoneOffset(timeZoneIndex)!!.toDouble() * 3600).toLong()
            }

            setSystemToLocalTimestampOffset(offset)
        }
    }

    private fun modTimestampToLocalInterval(timestamp: Long): Long {
        var result = timestamp
        result += localTimeOffset
        result -= result % interval
        result -= localTimeOffset
        return result
    }

    /**
     * Copies the fields from the source [MonitoringMesg] to the destination.
     *
     * @param destMesg
     *           Destination message
     * @param srcMesg
     *           Source message
     */
    private fun setFieldsFromMesg(destMesg: MonitoringMesg, srcMesg: MonitoringMesg) {
        for (field in srcMesg.fields.toList()) {
            destMesg.setField(Field(field))
        }
    }

    /**
     * Extracts and returns a [MonitoringMesg]. Expands compressed fields
     * before adding them to the returned message, and computes accumulated
     * distance and calories if necessary based on CyclesToDistance and
     * CyclestoCalories factors from the stored [MonitoringInfoMesg]
     *
     * @param inMesg
     *           Message to be extracted
     * @return
     *           Extracted message
     */
    private fun extract(inMesg: MonitoringMesg): MonitoringMesg {
        val out = MonitoringMesg()
        var activityTypeInfoIndex = Int.MAX_VALUE
        var lastMesg: MonitoringMesg? = null
        val timestamp: DateTime
        var extractState: ExtractState? = null

        // Timestamp
        if (inMesg.getTimestamp() != null) {
            mesgTimestamp = inMesg.getTimestamp()!!.getTimestamp()
        } else if (inMesg.getTimestamp16() != null) {
            mesgTimestamp += (inMesg.getTimestamp16()!!.toLong() - (mesgTimestamp and 0xFFFF)) and 0xFFFF
        } else if (inMesg.getTimestampMin8() != null) {
            mesgTimestamp /= 60 // Truncate to nearest minute.
            mesgTimestamp += (inMesg.getTimestampMin8()!!.toLong() - (mesgTimestamp and 0xFF)) and 0xFF
            mesgTimestamp *= 60 // Back to seconds.
        }
        timestamp = DateTime(mesgTimestamp)
        timestamp.convertSystemTimeToUTC(systemToUtcTimestampOffset)
        out.setTimestamp(timestamp)

        if (inMesg.getLocalTimestamp() != null) {
            out.setLocalTimestamp(inMesg.getLocalTimestamp())
        } else {
            out.setLocalTimestamp(timestamp.getTimestamp() + localTimeOffset)
        }

        // Activity Type
        if (inMesg.getActivityType() != null) {
            out.setActivityType(inMesg.getActivityType())
        }

        val outActivityType = out.getActivityType()
        // Get extraction state for this activity type.
        if (outActivityType != null) {
            extractState = extractStates[outActivityType]
        }
        if (extractState == null) {
            extractState = ExtractState()
            if (outActivityType != null) {
                extractStates[outActivityType] = extractState
            }
        }

        // Get index for activity info, if any. (cycles to distance/calories scale
        // factors).
        if (infoMesg!!.getNumActivityType() > 0) {
            for (i in 0 until infoMesg!!.getNumActivityType()) {
                if (infoMesg!!.getActivityType(i) == out.getActivityType()) {
                    activityTypeInfoIndex = i
                }
            }
        }

        val inActivityType = inMesg.getActivityType()
        // Get the last message for decoding rolling over accumulated fields.
        if (inActivityType != null) {
            lastMesg = lastMesgs[inActivityType]
        }

        if (lastMesg == null) {
            lastMesg = MonitoringMesg()
        }

        // Duration
        if (inMesg.getDuration() != null) {
            out.setDuration(inMesg.getDuration())
        } else if (inMesg.getDurationMin() != null) {
            out.setDuration(inMesg.getDurationMin()!!.toLong() * 60)
        }

        // Active time
        if (inMesg.getActiveTime() != null) {
            out.setActiveTime(inMesg.getActiveTime())
        } else if (inMesg.getActiveTime16() != null) {
            var time: Long = 0

            if (lastMesg.getActiveTime() != null) {
                time = (lastMesg.getActiveTime()!! + 0.5).toLong()
            }

            time += (inMesg.getActiveTime16()!!.toLong() - (time and 0xFFFF)) and 0xFFFF
            out.setActiveTime(time.toFloat())
        } else if (inMesg.getCurrentActivityTypeIntensity() != null) {
            // If this is the current activity type then time since last message is
            // active time in the current activity type.
            var time: Long = 0

            if (lastMesg.getActiveTime() != null) {
                time = (lastMesg.getActiveTime()!! + 0.5).toLong()
            }

            time += timestamp.getTimestamp() - lastTimestamp
            out.setActiveTime(time.toFloat())
        }

        // Cycles
        if (inMesg.getCycles() != null) {
            out.setCycles(inMesg.getCycles())
        } else if (inMesg.getCycles16() != null) {
            var cycles: Long = 0

            if (lastMesg.getCycles() != null) {
                cycles = (lastMesg.getCycles()!! * 2).toLong()
            }

            cycles += (inMesg.getCycles16()!!.toLong() - (cycles and 0xFFFF)) and 0xFFFF
            out.setCycles(cycles.toFloat() / 2)
        }

        // Distance
        if (inMesg.getDistance() != null) {
            out.setDistance(inMesg.getDistance())
        } else if (inMesg.getDistance16() != null) {
            var distance: Long = 0

            if (lastMesg.getDistance() != null) {
                distance = (lastMesg.getDistance()!! * 100).toLong()
            }

            distance += (inMesg.getDistance16()!!.toLong() - (distance and 0xFFFF)) and 0xFFFF
            out.setDistance(distance.toFloat() / 100)
        }

        // Active Calories
        if (inMesg.getActiveCalories() != null) {
            out.setActiveCalories(inMesg.getActiveCalories())
        }

        // Total Calories
        if (inMesg.getCalories() != null) {
            out.setCalories(inMesg.getCalories())
        }

        // Intensity
        if (inMesg.getIntensity() != null) {
            out.setIntensity(inMesg.getIntensity())
        }

        // Heart Rate
        if (inMesg.getHeartRate() != null) {
            out.setHeartRate(inMesg.getHeartRate())
        }

        // Temperature
        if (inMesg.getTemperature() != null) {
            out.setTemperature(inMesg.getTemperature())
        }

        // Ascent
        if (inMesg.getAscent() != null) {
            out.setAscent(inMesg.getAscent())
        }

        // Descent
        if (inMesg.getDescent() != null) {
            out.setDescent(inMesg.getDescent())
        }

        // Moderate activity minutes
        if (inMesg.getModerateActivityMinutes() != null) {
            out.setModerateActivityMinutes(inMesg.getModerateActivityMinutes())
        }

        // Vigorous activity minutes
        if (inMesg.getVigorousActivityMinutes() != null) {
            out.setVigorousActivityMinutes(inMesg.getVigorousActivityMinutes())
        }

        // Compute distance from cycles if not logged directly.
        if (out.getDistance() != null) {
            // Keep track of cycles at last logged distance to compute distance
            // from cycles.
            extractState.cyclesToDistanceStartDist = out.getDistance()!!
            extractState.cyclesToDistanceStartCycles = out.getCycles()!!
        } else if ((activityTypeInfoIndex < infoMesg!!.getNumCyclesToDistance()) &&
            (out.getCycles() != null)
        ) {
            // Compute distance from cycles since last reported distance.
            // Distance is computed from total cycles since last reported
            // distance instead of accumulating computed distance which would
            // accumulate error.
            out.setDistance(
                extractState.cyclesToDistanceStartDist +
                    (out.getCycles()!! - extractState.cyclesToDistanceStartCycles) *
                    infoMesg!!.getCyclesToDistance(activityTypeInfoIndex)!!
            )
        }

        // Compute active calories from cycles if not logged directly.
        if (out.getActiveCalories() != null) {
            // Keep track of cycles at last logged calories to compute calories
            // from cycles.
            extractState.cyclesToCaloriesStartCal = out.getActiveCalories()!!
            extractState.cyclesToCaloriesStartCycles = out.getCycles()!!
        } else if ((activityTypeInfoIndex < infoMesg!!.getNumCyclesToCalories()) &&
            (out.getCycles() != null)
        ) {
            // Compute calories from cycles since last reported calories.
            // Calories is computed from total cycles since last reported
            // calories instead of accumulating computed calories which would
            // accumulate error.
            out.setActiveCalories(
                (extractState.cyclesToCaloriesStartCal +
                    (out.getCycles()!! - extractState.cyclesToCaloriesStartCycles) *
                    infoMesg!!.getCyclesToCalories(activityTypeInfoIndex)!!).toInt()
            )
        }

        return out
    }

    /**
     * Returns a [MonitoringMesg] containing the interval information for
     * the given [ActivityType].
     *
     * @param activityType
     *           Desired activity type
     * @param intervalMesgs
     *           List of monitoring messages containing interval data
     * @return
     *           A monitoring message containing the totals of the given activity type
     *           over the interval
     */
    private fun computeInterval(
        activityType: ActivityType,
        intervalMesgs: ArrayList<MonitoringMesg>
    ): MonitoringMesg? {
        val intervalMesg = MonitoringMesg()
        val fields = ArrayList<ReaderField>()
        var intervalHasData = false
        var mesgInInterval = false

        if (intervalMesgs.size == 0) {
            return null
        }

        intervalMesg.setTimestamp(DateTime(endTimestamp))
        intervalMesg.setLocalTimestamp(endTimestamp + localTimeOffset)
        intervalMesg.setActivityType(activityType)
        intervalMesg.setDuration(endTimestamp - startTimestamp)

        for (fieldName in accumulatedFieldNames) {
            fields.add(AccumField(MonitoringMesg.monitoringMesg.getField(fieldName)))
        }

        for (fieldName in instantaneousFieldNames) {
            fields.add(InstField(MonitoringMesg.monitoringMesg.getField(fieldName)))
        }

        for (fieldName in summedInstantaneousFieldNames) {
            fields.add(SummedInstField(MonitoringMesg.monitoringMesg.getField(fieldName)))
        }

        for (mesg in intervalMesgs) {
            var updateMesg = true
            for (i in summedInstantaneousFieldNames.indices) {
                if (mesg.getField(summedInstantaneousFieldNames[i]) != null) {
                    updateMesg = false
                    lastSummedInstMesg = mesg
                }
                if (updateMesg) {
                    lastAccumMesg = mesg
                }
            }
        }

        for (mesg in intervalMesgs) {
            val mesgTimestamp = mesg.getTimestamp()!!.getTimestamp()

            if ((mesgTimestamp > startTimestamp) && (mesgTimestamp < (endTimestamp + interval))) {
                mesgInInterval = true
            }

            for (field in fields) {
                if (summedInstantaneousFields.contains((field as Field).getName() ?: "")) {
                    if ((mesgTimestamp > startTimestamp) && (mesgTimestamp <= endTimestamp)) {
                        field.onMesg(mesg)
                    }
                } else {
                    field.onMesg(mesg)
                }
            }
        }

        if (!mesgInInterval) {
            return null
        }

        for (field in fields) {
            if (field.setMesg(intervalMesg)) {
                intervalHasData = true
            }
        }

        if (!intervalHasData) {
            return null
        }

        return intervalMesg
    }

    // NOTE: the Java interface also declares `String getName()`, which is satisfied by the
    // inherited Field.getName(). Kotlin cannot use a final inherited class member to implement
    // an interface member, so getName() is dropped here and read directly off Field at the
    // single call site (all implementations extend Field, exactly as in Java).
    private interface ReaderField : MonitoringMesgListener {
        fun setMesg(mesg: MonitoringMesg): Boolean
        fun getVal(): Double
    }

    /**
     * This class represents a field with a value accumulates between messages
     * in the original fit file. Examples of this include calories and steps.
     */
    private inner class AccumField(field: Field?) : Field(field), ReaderField {
        private var startValue: Double?
        private var startValueTimestamp: Long
        private var endValue: Double?
        private var endValueTimestamp: Long

        init {
            // Initialize start value to start of day which is defined as 0.
            startValue = 0.0
            startValueTimestamp = startTimestamp + localTimeOffset
            startValueTimestamp -= startValueTimestamp % 86400
            startValueTimestamp -= localTimeOffset

            endValue = null
            endValueTimestamp = 0
        }

        /**
         * Stores this AccumField's processed data into the equivalent field
         * contained in the passed in [MonitoringMesg]. Returns false if
         * the data is invalid, and true if it is valid and has been put into the
         * message.
         *
         * @param mesg
         *          The message to update.
         *
         * @return
         *          Success or failure.
         */
        override fun setMesg(mesg: MonitoringMesg): Boolean {
            var value: Double

            if (endValue == null) {
                return false
            }

            value = endValue!! - startValue!!

            // Accumulated difference should always be positive.
            // If it is negative there is probably a error in the data logged by
            // the device.
            // Set the difference to zero and let the accumulated value catch up.
            if (value < 0) {
                value = 0.0
            }

            mesg.setFieldValue(this.getNum(), 0, value)

            return value != 0.0
        }

        override fun getVal(): Double {
            // Not used
            return -1.0
        }

        /**
         * Processes and stores data from the given [MonitoringMesg] into
         * this AccumField.
         *
         * @param mesg
         *          The mesg to process data from.
         */
        override fun onMesg(mesg: MonitoringMesg) {
            val field = mesg.getField(this.getNum())
            val mesgTimestamp = mesg.getTimestamp()!!.getTimestamp()
            var value: Double? = null

            if (includedFields[this.getName() ?: ""] != true) {
                return
            }

            if (field != null) {
                value = field.getDoubleValue()
            }

            if (mesgTimestamp <= startTimestamp) {
                if (value != null) {
                    startValue = value
                }

                startValueTimestamp = mesgTimestamp
            } else {
                // Interpolate start value if not aligned to start of interval.
                var lastAccumTimestamp: Long = 0
                if ((lastAccumMesg != null) && (lastAccumMesg!!.getTimestamp() != null)) {
                    lastAccumTimestamp = lastAccumMesg!!.getTimestamp()!!.getTimestamp()
                }
                if ((startValueTimestamp < startTimestamp) &&
                    ((startTimestamp >= lastAccumTimestamp) ||
                        ((lastSummedInstMesg == null) ||
                            (lastSummedInstMesg!!.getTimestamp()!!.getTimestamp() < startValueTimestamp)))
                ) {
                    if (value != null) {
                        if (startValueTimestamp == mesgTimestamp) {
                            startValueTimestamp -= (startTimestamp - startValueTimestamp)
                        }
                        startValue = startValue!! +
                            (value - startValue!!) * (startTimestamp - startValueTimestamp) /
                            (mesgTimestamp - startValueTimestamp)
                    }

                    startValueTimestamp = startTimestamp
                }

                // Interpolate end of interval if message data spans into next
                // interval.
                if (mesgTimestamp > endTimestamp) {
                    if (value != null) {
                        if (endValue == null) {
                            endValue = startValue
                            endValueTimestamp = startValueTimestamp
                        }
                        if (endValueTimestamp == mesgTimestamp) {
                            endValueTimestamp -= (mesgTimestamp - endTimestamp)
                        }
                        value = endValue!! +
                            (value - endValue!!) * (endTimestamp - endValueTimestamp) /
                            (mesgTimestamp - endValueTimestamp)
                    }
                }

                endValueTimestamp = mesgTimestamp

                if (value != null) {
                    endValue = value
                }
            }
        }
    }

    /**
     * This class represents a field that is contains an instantaneous value
     * in the original fit file. Examples of this include heart rate and intensity.
     */
    private inner class InstField(field: Field?) : Field(field), ReaderField {
        private var sum: Double = 0.0
        private var sumDuration: Double = 0.0
        private var sumEndTimestamp: Long

        init {
            sum = 0.0
            sumDuration = 0.0
            sumEndTimestamp = startTimestamp
        }

        /**
         * Stores this InstField's processed data into the equivalent field
         * contained in the passed in [MonitoringMesg]. Returns false if
         * the data is invalid, and true if it is valid and has been put into the
         * message.
         *
         * @param mesg
         *          The message to update.
         *
         * @return
         *          Success or failure.
         */
        override fun setMesg(mesg: MonitoringMesg): Boolean {
            if (sumDuration == 0.0) {
                return false
            }

            mesg.setFieldValue(this.getNum(), 0, sum / sumDuration)

            return true
        }

        /**
         * Returns the processed value stored in this field.
         *
         * @return
         *          A processed value.
         */
        override fun getVal(): Double {
            return sum / sumDuration
        }

        /**
         * Processes and stores data from the given [MonitoringMesg] into
         * this InstField.
         *
         * @param mesg
         *          The mesg to process data from.
         */
        override fun onMesg(mesg: MonitoringMesg) {
            val field = mesg.getField(this.getNum())
            val value: Double?
            val mesgDuration: Double
            var mesgTimestamp: Long

            // Ignore instantaneous data if outputting daily totals.
            // Instantaneous fields can not be computed for daily interval without data for the whole day.
            if (outputDailyTotals || includedFields[this.getName() ?: ""] != true) {
                return
            }

            mesgTimestamp = mesg.getTimestamp()!!.getTimestamp()

            if (mesgTimestamp > endTimestamp) {
                mesgTimestamp = endTimestamp
            }

            if (sumEndTimestamp >= mesgTimestamp) {
                return
            }

            mesgDuration = (mesgTimestamp - sumEndTimestamp).toDouble()
            sumEndTimestamp = mesgTimestamp

            if (field == null) {
                return
            }

            value = field.getDoubleValue()

            if (value == null) {
                return
            }

            sumDuration += mesgDuration
            sum += value * mesgDuration
        }
    }

    /**
     * This class represents a field that is contains an instantaneous value
     * in the original fit file, but should be summed over an interval instead of
     * averaged. Examples of this include ascent and moderate activity minutes.
     */
    private inner class SummedInstField(field: Field?) : Field(field), ReaderField {
        private var sum: Double = 0.0

        /**
         * Stores this SummedInstField's processed data into the equivalent field
         * contained in the passed in [MonitoringMesg]. Returns false if
         * the data is invalid, and true if it is valid and has been put into the
         * message.
         *
         * @param mesg
         *          The message to update.
         *
         * @return
         *          Success or failure.
         */
        override fun setMesg(mesg: MonitoringMesg): Boolean {
            if (sum == 0.0) {
                return false
            }

            mesg.setFieldValue(this.getNum(), 0, sum)

            return true
        }

        /**
         * Returns the processed value stored in this field.
         *
         * @return
         *          A processed value.
         */
        override fun getVal(): Double {
            return sum
        }

        /**
         * Processes and stores data from the given [MonitoringMesg] into
         * this SummedInstField.
         *
         * @param mesg
         *          The mesg to process data from.
         */
        override fun onMesg(mesg: MonitoringMesg) {
            val field = mesg.getField(this.getNum())
            val value: Double?
            var mesgTimestamp: Long

            if (includedFields[this.getName() ?: ""] != true) {
                return
            }

            mesgTimestamp = mesg.getTimestamp()!!.getTimestamp()

            if (mesgTimestamp > endTimestamp) {
                mesgTimestamp = endTimestamp
            }

            if (field == null) {
                return
            }

            value = field.getDoubleValue()

            if (value == null) {
                return
            }

            sum += value
        }
    }

    companion object {
        const val DAILY_INTERVAL: Int = 86400
        const val CYCLES_STRING: String = "cycles"
        const val DISTANCE_STRING: String = "distance"
        const val ACTIVE_CAL_STRING: String = "active_calories"
        const val CALORIE_STRING: String = "calories"
        const val ACTIVE_TIME_STRING: String = "active_time"
        const val INTENSITY_STRING: String = "intensity"
        const val HR_STRING: String = "heart_rate"
        const val TEMPERATURE_STRING: String = "temperature"
        const val ASCENT_STRING: String = "ascent"
        const val DESCENT_STRING: String = "descent"
        const val MOD_ACTIVITY_MIN_STRING: String = "moderate_activity_minutes"
        const val VIG_ACTIVITY_MIN_STRING: String = "vigorous_activity_minutes"
    }
}
