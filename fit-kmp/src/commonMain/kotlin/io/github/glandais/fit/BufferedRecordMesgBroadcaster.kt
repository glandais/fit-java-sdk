// Hand-written multiplatform port of BufferedRecordMesgBroadcaster.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

class BufferedRecordMesgBroadcaster : RecordMesgListener {
    private val bufferedRecordMesg: BufferedRecordMesg = BufferedRecordMesg()
    private val listeners: ArrayList<BufferedRecordMesgListener> = ArrayList()

    fun addListener(mesgListener: BufferedRecordMesgListener) {
        listeners.add(mesgListener)
    }

    fun removeListener(mesgListener: BufferedRecordMesgListener) {
        listeners.remove(mesgListener)
    }

    override fun onMesg(mesg: RecordMesg) {
        bufferedRecordMesg.setFields(mesg)

        for (listener in listeners) {
            listener.onMesg(bufferedRecordMesg)
        }
    }
}
