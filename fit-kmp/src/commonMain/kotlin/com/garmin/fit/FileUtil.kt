// Hand-written multiplatform port of FileUtil.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

object FileUtil {

    fun split(input: InputStream): Collection<ByteArray> {
        val files = ArrayList<ByteArray>()

        try {
            val data = ByteArray(input.available())
            var pos = 0
            var fileHdrSize: Byte
            var fileDataSize: Int
            var fileSize: Int

            input.read(data)

            while (pos < data.size) {
                fileHdrSize = data[pos]
                fileDataSize = data[pos + 4].toInt() and 0xFF
                fileDataSize = fileDataSize or ((data[pos + 5].toInt() and 0xFF) shl 8)
                fileDataSize = fileDataSize or ((data[pos + 6].toInt() and 0xFF) shl 16)
                fileDataSize = fileDataSize or ((data[pos + 7].toInt() and 0xFF) shl 24)

                if (data[pos + 8] != '.'.code.toByte()) {
                    break
                }

                if (data[pos + 9] != 'F'.code.toByte()) {
                    break
                }

                if (data[pos + 10] != 'I'.code.toByte()) {
                    break
                }

                if (data[pos + 11] != 'T'.code.toByte()) {
                    break
                }

                fileSize = fileHdrSize + fileDataSize + 2

                if ((pos + fileSize) > data.size) {
                    break
                }

                files.add(data.copyOfRange(pos, pos + fileSize))
                pos += fileSize
            }

            if (pos < data.size) {
                files.add(data.copyOfRange(pos, data.size))
            }
        } catch (e: IOException) {
        }

        return files
    }

    fun prepend(
        files: Collection<ByteArray>, fromFileType: File,
        toFileType: File
    ): Collection<ByteArray> {
        val fromFiles = ArrayList<ByteArray>()
        val toFiles = ArrayList<ByteArray>()
        val returnFiles = ArrayList<ByteArray>()

        // Read each file to get list of files to prepend.
        for (file in files) {
            val decode = Decode()
            var decodeReturn: Decode.RETURN
            var decodeComplete = false
            var datum: Int
            val fileStream = ByteArrayInputStream(file)

            while (!decodeComplete) {
                datum = fileStream.read()

                if (datum < 0) {
                    println("end of stream")
                    break // Unexpected end of stream.
                }

                decodeReturn = decode.read(datum.toByte())

                when (decodeReturn) {
                    Decode.RETURN.MESG -> {
                        val mesg = decode.getMesg()!!

                        if (mesg.name == "file_id") {
                            val fileIdMesg = FileIdMesg(mesg)

                            if (fileIdMesg.type == fromFileType) {
                                fromFiles.add(file)
                            }

                            if (fileIdMesg.type == toFileType) {
                                toFiles.add(file)
                            }

                            decodeComplete = true
                        }
                    }

                    Decode.RETURN.END_OF_FILE -> {
                        decodeComplete = true
                    }

                    else -> {
                    }
                }
            }
        }

        // Create list of prepended files.
        for (file in files) {
            if (toFiles.contains(file)) {
                val newFile: ByteArray
                var newFileLength = file.size
                var newFilePos = 0

                for (fromFile in fromFiles) {
                    newFileLength += fromFile.size
                }

                newFile = ByteArray(newFileLength)

                for (fromFile in fromFiles) {
                    fromFile.copyInto(newFile, newFilePos, 0, fromFile.size)
                    newFilePos += fromFile.size
                }

                file.copyInto(newFile, newFilePos, 0, file.size)

                returnFiles.add(newFile)
            } else {
                returnFiles.add(file) // No files to prepend so pass straight through.
            }
        }

        return returnFiles
    }
}
