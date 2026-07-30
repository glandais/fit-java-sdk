// Hand-written multiplatform port of MesgBroadcastPlugin.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

/**
 * Defines the interface that must be implemented
 * to create an application specific plugin for
 * the BufferedMesgBroadcaster
 *
 */
interface MesgBroadcastPlugin {
    fun onBroadcast(mesgs: List<Mesg>)
    fun onIncomingMesg(mesg: Mesg)
}
