// Hand-written multiplatform port of MesgSource.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

interface MesgSource {
    fun addListener(mesgListener: MesgListener)
}
