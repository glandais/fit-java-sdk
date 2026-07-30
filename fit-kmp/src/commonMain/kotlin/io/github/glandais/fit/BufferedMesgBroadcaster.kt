// Hand-written multiplatform port of BufferedMesgBroadcaster.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

/**
 * BufferedMesgBroadcaster intercepts the incoming messages
 * from the given decode stream, buffers them, and offers
 * an opportunity to edit the messages before broadcasting
 * the messages to all registered listeners.
 *
 * To edit the messages, a MesgBroadcastPlugin must be
 * registered. All registered MesgBroadcastPlugins are given
 * the opportunity to see each message as they are decoded,
 * as well as to see and edit the final list of
 * messages before broadcast to listeners
 */
open class BufferedMesgBroadcaster : MesgBroadcaster {
    private val mesgs: ArrayList<Mesg>
    private val plugins: ArrayList<MesgBroadcastPlugin>

    /**
     * Constructor.
     *
     * Calls the super constructor and initializes lists
     */
    constructor() : super() {
        mesgs = ArrayList()
        plugins = ArrayList()
    }

    /**
     * Constructor.
     *
     * Calls the super constructor and initializes lists
     *
     * @param decode The com.garmin.fit.Decode object.
     */
    constructor(decode: Decode) : super(decode) {
        mesgs = ArrayList()
        plugins = ArrayList()
    }

    /**
     * Registers a plugin, which the class will call on onMesg and broadcast
     * @param plugin The MesgBroadcastPlugin object to be registered
     */
    fun registerMesgBroadcastPlugin(plugin: MesgBroadcastPlugin) {
        plugins.add(plugin)
    }

    /**
     * Buffers incoming messages and passes them on to any registered plugins
     *
     * @param mesg The com.garmin.fit.Mesg to be processed
     */
    override fun onMesg(mesg: Mesg) {
        mesgs.add(mesg)

        // Pass the message to each plugin. This gives the
        // plugin a chance to peek the incoming messages
        for (plugin in plugins) {
            plugin.onIncomingMesg(mesg)
        }
    }

    /**
     * Passes the reference to the list of messages to any registered plugins.
     * Sends each message to the MesgBroadcast class to be broadcast to any listeners
     */
    fun broadcast() {
        for (plugin in plugins) {
            plugin.onBroadcast(mesgs)
        }

        for (mesg in mesgs) {
            super.onMesg(mesg)
        }
    }
}
