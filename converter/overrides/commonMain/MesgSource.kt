// Hand-written multiplatform port of MesgSource.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

interface MesgSource {
    fun addListener(mesgListener: MesgListener)
}
