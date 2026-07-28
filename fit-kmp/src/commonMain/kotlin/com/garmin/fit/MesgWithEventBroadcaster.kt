// Hand-written multiplatform port of MesgWithEventBroadcaster.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

class MesgWithEventBroadcaster : MesgWithEventListener {
    private val MAX_GROUPS = 256
    private val DEFAULT_GROUP = 255
    private val BEGIN_END_GROUP = 254

    private val listeners: ArrayList<MesgWithEventListener> = ArrayList()
    private val startedEvents: ArrayList<ArrayList<MesgWithEvent>> = ArrayList()

    init {
        for (i in 0 until MAX_GROUPS) {
            startedEvents.add(ArrayList())
        }
    }

    fun addListener(mesgObserver: MesgWithEventListener) {
        listeners.add(mesgObserver)
    }

    fun removeListener(mesgObserver: MesgWithEventListener) {
        listeners.remove(mesgObserver)
    }

    override fun onMesg(mesg: MesgWithEvent) {
        val broadcastMesg = Factory.createMesg(mesg as Mesg) as MesgWithEvent
        var group = DEFAULT_GROUP

        if (broadcastMesg.getEventGroup() != null) {
            group = broadcastMesg.getEventGroup()!!.toInt()
        }

        if (broadcastMesg.getEventType() == null) {
            return  // Invalid so ignore.
        }

        // Convert depreciated events types for backwards compatibility.
        when (broadcastMesg.getEventType()) {
            EventType.BEGIN_DEPRECIATED -> {
                group = BEGIN_END_GROUP
                broadcastMesg.setEventType(EventType.START)
            }

            EventType.END_DEPRECIATED -> {
                group = BEGIN_END_GROUP
                broadcastMesg.setEventType(EventType.STOP)
            }

            EventType.CONSECUTIVE_DEPRECIATED -> {
                broadcastMesg.setEventType(EventType.STOP)
            }

            EventType.END_ALL_DEPRECIATED -> {
                group = BEGIN_END_GROUP
                broadcastMesg.setEventType(EventType.STOP_ALL)
            }

            else -> {}
        }

        when (broadcastMesg.getEventType()) {
            EventType.START -> {
                // NOTE: mirrors the original Java `for (i = 0; i < size; i++)` loop, which
                // increments `i` unconditionally even after `remove(i)` shrinks the list
                // (so the element shifted into slot `i` is skipped) -- preserved as-is for fidelity.
                var i = 0
                while (i < startedEvents[group].size) {
                    if (startedEvents[group][i].getEvent() == broadcastMesg.getEvent()) {
                        val stopEvent = Factory.createMesg(startedEvents[group][i] as Mesg) as MesgWithEvent
                        val timestamp = broadcastMesg.getTimestamp()
                        stopEvent.setEventType(EventType.STOP)

                        if (timestamp != null) {
                            stopEvent.setTimestamp(timestamp)
                        }

                        broadcast(stopEvent)
                        startedEvents[group].removeAt(i)
                    }
                    i++
                }

                startedEvents[group].add(Factory.createMesg(broadcastMesg as Mesg) as MesgWithEvent)
            }

            EventType.STOP, EventType.STOP_DISABLE -> {
                // Same unconditional-increment quirk as above, preserved for fidelity.
                var i = 0
                while (i < startedEvents[group].size) {
                    if (startedEvents[group][i].getEvent() == broadcastMesg.getEvent()) {
                        startedEvents[group].removeAt(i)
                    }
                    i++
                }
            }

            EventType.STOP_ALL -> {
                for (i in 0 until startedEvents[group].size) {
                    if (startedEvents[group][i].getEvent() != broadcastMesg.getEvent()) {
                        val stopEvent = Factory.createMesg(startedEvents[group][i] as Mesg) as MesgWithEvent
                        val timestamp = broadcastMesg.getTimestamp()
                        stopEvent.setEventType(EventType.STOP)

                        if (timestamp != null) {
                            stopEvent.setTimestamp(timestamp)
                        }

                        broadcast(stopEvent)
                    }
                }

                startedEvents[group].clear()
                broadcastMesg.setEventType(EventType.STOP)
            }

            EventType.STOP_DISABLE_ALL -> {
                for (i in 0 until startedEvents[group].size) {
                    if (startedEvents[group][i].getEvent() != broadcastMesg.getEvent()) {
                        val stopEvent = Factory.createMesg(startedEvents[group][i] as Mesg) as MesgWithEvent
                        val timestamp = broadcastMesg.getTimestamp()
                        stopEvent.setEventType(EventType.STOP_DISABLE)

                        if (timestamp != null) {
                            stopEvent.setTimestamp(timestamp)
                        }

                        broadcast(stopEvent)
                    }
                }

                startedEvents[group].clear()
                broadcastMesg.setEventType(EventType.STOP_DISABLE)
            }

            else -> {}
        }

        broadcast(broadcastMesg)
    }

    private fun broadcast(mesg: MesgWithEvent) {
        for (listener in listeners) {
            listener.onMesg(mesg)
        }
    }
}
