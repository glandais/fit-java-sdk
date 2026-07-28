// Hand-written multiplatform port of FitDecoder.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

class FitDecoder {

    fun decode(inputStream: InputStream): FitMessages {
        val decode = Decode()
        val fitListener = FitListener()

        try {
            decode.read(inputStream, fitListener, null)
        } catch (fre: FitRuntimeException) {
            // If a FIT file with 0 data size is encountered, attempt to
            // process the next chained FIT file in the input stream.
            if (decode.getInvalidFileDataSize()) {
                decode.nextFile()
                decode.read(inputStream, fitListener, null)
            } else {
                throw fre
            }
        }

        return fitListener.getFitMessages()
    }

    fun decode(inputStream: InputStream, plugin: MesgBroadcastPlugin): FitMessages {
        val decode = Decode()
        val fitListener = FitListener()
        val mesgBroadcaster = BufferedMesgBroadcaster(decode)

        mesgBroadcaster.registerMesgBroadcastPlugin(plugin)
        mesgBroadcaster.addListener(fitListener)

        try {
            mesgBroadcaster.run(inputStream)
            mesgBroadcaster.broadcast()
        } catch (fre: FitRuntimeException) {
            // If a FIT file with 0 data size is encountered, attempt to
            // process the next chained FIT file in the input stream.
            if (decode.getInvalidFileDataSize()) {
                decode.nextFile()
                mesgBroadcaster.run(inputStream)
                mesgBroadcaster.broadcast()
            } else {
                throw fre
            }
        }

        return fitListener.getFitMessages()
    }
}
