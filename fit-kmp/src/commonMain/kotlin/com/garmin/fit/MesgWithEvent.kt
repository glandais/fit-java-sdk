// Hand-written multiplatform port of MesgWithEvent.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

interface MesgWithEvent {
    fun getTimestamp(): DateTime?
    fun setTimestamp(timestamp: DateTime?)
    fun getEvent(): Event?
    fun setEvent(event: Event?)
    fun getEventType(): EventType?
    fun setEventType(eventType: EventType?)
    fun getEventGroup(): Short?
    fun setEventGroup(eventGroup: Short?)
}
