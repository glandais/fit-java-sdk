// Hand-written multiplatform port of BufferedMesgListener.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

interface BufferedMesgListener : MesgListener {
    fun flushMesgs()
}
