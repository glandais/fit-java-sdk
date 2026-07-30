// Hand-written multiplatform port of MesgFilterBase.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

abstract class MesgFilterBase : MesgSource, MesgListener {
    private val mesgListeners: ArrayList<MesgListener> = ArrayList()

    override fun onMesg(mesg: Mesg) {
        for (mesgListener in mesgListeners) {
            mesgListener.onMesg(mesg)
        }
    }

    override fun addListener(mesgListener: MesgListener) {
        if ((mesgListener != null) && !mesgListeners.contains(mesgListener)) {
            mesgListeners.add(mesgListener)
        }
    }

    fun removeListener(mesgListener: MesgListener) {
        if (mesgListener != null) {
            mesgListeners.remove(mesgListener)
        }
    }
}
