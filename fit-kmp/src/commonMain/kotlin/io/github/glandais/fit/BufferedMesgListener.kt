// Hand-written multiplatform port of BufferedMesgListener.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

interface BufferedMesgListener : MesgListener {
    fun flushMesgs()
}
