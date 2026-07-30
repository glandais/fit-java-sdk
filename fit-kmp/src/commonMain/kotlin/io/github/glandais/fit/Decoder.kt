// Hand-written multiplatform port of Decoder.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

class Decoder(bytes: ByteArray) : DecoderBase(bytes) {

    private val developerDataIds = HashMap<Short, DeveloperDataIdMesg>()
    private val developerFields = HashMap<Short, HashMap<Short, FieldDescriptionMesg>>()

    /**
     * Reads a .FIT file and passes messages to the listeners
     *
     * @throws Exception if an error occurs while reading
     */
    fun read() {
        while (stream!!.available() > 0) {
            resetCrc()
            decodeNextFile(stream!!)
        }
    }

    private fun decodeNextFile(stream: ByteArrayDataInputStream) {
        if (!isFIT(stream)) {
            throw FitRuntimeException("The file is not a valid FIT file.")
        }

        val position = stream.getPosition()

        // Read the file header
        val fileHeader = readHeader()

        val headerSize = fileHeader[0].toInt()
        val dataSize = fileHeader.getInt32(4, false) // little endian

        // Read data messages and definitions
        while (stream.getPosition() < (position + headerSize + dataSize)) {
            decodeRecord()
        }

        // Read and check the CRC
        val fileCrc = stream.readUShort()

        if (fileCrc.toLong() != getCrcValue()) {
            throw FitRuntimeException("FIT decode error: File CRC failed.")
        }
    }

    private fun decodeRecord() {
        val recordHeader = stream!!.peek().toInt()

        if ((recordHeader and CompressedHeaderMask) == CompressedHeaderMask) {
            decodeCompressedTimestampDataMessage()
            return
        }

        if ((recordHeader and MesgDefinitionMask) == MesgHeaderMask) {
            decodeMessage()
            return
        }

        if ((recordHeader and MesgDefinitionMask) == MesgDefinitionMask) {
            decodeMessageDefinition()
            return
        }

        throw FitRuntimeException("Invalid record header: 0x" + recordHeader.toString(16))
    }

    private fun decodeMessageDefinition() {
        val recordHeader = readByte()
        val localMesgIndex = recordHeader and LocalMesgNumMask

        val localMesgDef = MesgDefinition()
        localMesgDefs[localMesgIndex] = localMesgDef
        localMesgDef.localNum = localMesgIndex

        @Suppress("UNUSED_VARIABLE")
        val reservedByte = readByte()
        localMesgDef.arch = readByte()
        localMesgDef.num = readUShort()

        if (localMesgDef.arch == Fit.ARCH_ENDIAN_BIG) {
            localMesgDef.num = (localMesgDef.num shr 8) or ((localMesgDef.num and 0xFF) shl 8)
        } else if (localMesgDef.arch != Fit.ARCH_ENDIAN_LITTLE) {
            throw FitRuntimeException("FIT decode error: Endian " + localMesgDef.arch + " not supported. Error at byte: " + stream!!.getPosition())
        }

        val numFields = readByte()

        for (fieldIndex in 0 until numFields) {
            localMesgDef.fields.add(FieldDefinition())
            localMesgDef.fields[fieldIndex].num = (readByte() and 0xFF)
            localMesgDef.fields[fieldIndex].size = (readByte() and 0xFF)
            localMesgDef.fields[fieldIndex].type = (readByte() and 0xFF)
        }

        if ((recordHeader and DevDataMask) == DevDataMask) {
            val numDevFields = readByte()

            for (fieldIndex in 0 until numDevFields) {

                val developerFieldDefinition = DeveloperFieldDefinition()

                developerFieldDefinition.setNum((readByte() and 0xFF).toShort())
                developerFieldDefinition.setSize(readByte() and 0xFF)

                val developerDataId: Short = (readByte() and 0xFF).toShort()
                developerFieldDefinition.setDeveloperDataIdMesg(developerDataIds[developerDataId])

                if (developerFields[developerDataId]!!.containsKey(developerFieldDefinition.getNum())) {
                    val fieldDescription = developerFields[developerDataId]!![developerFieldDefinition.getNum()]
                    developerFieldDefinition.setFieldDescription(fieldDescription)
                }

                localMesgDef.developerFields.add(developerFieldDefinition)
            }
        }

        for (mesgDefListener in mesgDefListeners) {
            mesgDefListener.onMesgDefinition(localMesgDef)
        }
    }

    private fun decodeMessage() {
        val recordHeader = readByte()
        val localMesgIndex = recordHeader and LocalMesgNumMask
        val mesgDef = localMesgDefs[localMesgIndex]
            ?: throw FitRuntimeException("Message Definition Not Found")

        val mesg = Factory.createMesg(mesgDef.num)
        mesg.localNum = localMesgIndex

        mesg.setDecoderMessageIndex(decoderMesgIndex++)

        for (fieldIndex in 0 until mesgDef.fields.size) {
            val fieldDef = mesgDef.fields[fieldIndex]
            var field = Factory.createField(mesg.num, fieldDef.num)

            val typeSize = Fit.baseTypeSizes[(fieldDef.type and Fit.BASE_TYPE_NUM_MASK)]
            val elements = fieldDef.size / typeSize

            val bytesRead = readBytes(fieldData, 0, fieldDef.size)

            if (bytesRead != fieldDef.size) {
                throw FitRuntimeException("End of file found while reading field data.")
            }

            if (((fieldDef.type and Fit.BASE_TYPE_ENDIAN_FLAG) != 0) && ((mesgDef.arch and Fit.ARCH_ENDIAN_MASK) != Fit.ARCH_ENDIAN_BIG)) {
                flipFieldDataByteOrder(typeSize, elements)
            }

            // For unknown fields the factory will create a field with the type set to 0, i.e. enum
            // In this situation we should use the type found in the fieldDef instead
            if (field.getName() == "unknown") {
                field = Field("unknown", fieldDef.num, fieldDef.type, 1.0, 0.0, "", false, Profile.Type.fromBaseType(fieldDef.type))
            }

            val profileSize = Fit.baseTypeSizes[(field.type and Fit.BASE_TYPE_NUM_MASK)]

            if (typeSize != profileSize) {
                continue
            }

            field.read(ByteArrayInputStream(fieldData), bytesRead)

            // Allow messages containing the accumulated field to set the accumulated value
            if (field.getIsAccumulated()) {
                for (i in 0 until field.getNumValues()) {
                    var value = (field.getRawValue(i) as Number).toLong()
                    for (containingField in mesg.fields) {
                        for (component in containingField.components) {
                            if ((component.fieldNum == field.num) && (component.accumulate)) {
                                value = ((((value / field.scale) - field.offset) + component.offset) * component.scale).toLong()
                            }
                        }
                    }
                    accumulator.set(mesg.num, field.getNum(), value)
                }
            }

            if (field.getNumValues() > 0) {
                mesg.addField(field)
            }
        }

        // Now that the entire message is decoded we may evaluate subfields and expand components
        if (!skipExpandComponents) {
            for (i in 0 until mesg.fields.size) {
                // Determine the active subfield and expand if it has any components
                val activeSubfield = mesg.getActiveSubFieldIndex(mesg.fields[i].getNum())

                if (activeSubfield == Fit.SUBFIELD_INDEX_MAIN_FIELD) {
                    if (mesg.fields[i].components.size > 0) {
                        // Expand the main field components
                        expandComponents(mesg, mesg.fields[i], mesg.fields[i].components)
                    }
                } else {
                    if (mesg.fields[i].subFields[activeSubfield].components.size > 0) {
                        // Expand the subfield components
                        expandComponents(mesg, mesg.fields[i], mesg.fields[i].subFields[activeSubfield].components)
                    }
                }
            }
        }

        for (fieldIndex in 0 until mesgDef.developerFields.size) {
            val fieldDef = mesgDef.developerFields[fieldIndex]

            val bytesRead = readBytes(fieldData, 0, fieldDef.getSize())

            if (bytesRead != fieldDef.getSize()) {
                throw FitRuntimeException("End of file found while reading field data.")
            }

            val field = DeveloperField(fieldDef)

            // Ignore field if type is not supported.
            if ((fieldDef.getType() and Fit.BASE_TYPE_NUM_MASK) < Fit.BASE_TYPES) {
                val typeSize = Fit.baseTypeSizes[(fieldDef.getType() and Fit.BASE_TYPE_NUM_MASK)]
                val elements = fieldDef.getSize() / typeSize

                if (((fieldDef.getType() and Fit.BASE_TYPE_ENDIAN_FLAG) != 0) &&
                    ((mesgDef.arch and Fit.ARCH_ENDIAN_MASK) != Fit.ARCH_ENDIAN_BIG)
                ) {
                    flipFieldDataByteOrder(typeSize, elements)
                }

                field.read(ByteArrayInputStream(fieldData), fieldDef.getSize())

                if (field.getNumValues() > 0) {
                    mesg.addDeveloperField(field)
                }
            }
        }

        // Save the Developer Data ID and Field Description messages for decoding dev data
        when (mesg.num) {
            MesgNum.DEVELOPER_DATA_ID -> {
                val devIdMesg = DeveloperDataIdMesg(mesg)
                val index = devIdMesg.developerDataIndex!!
                developerDataIds[index] = devIdMesg
                developerFields[index] = HashMap()
            }

            MesgNum.FIELD_DESCRIPTION -> {
                val fieldDescriptionMesg = FieldDescriptionMesg(mesg)
                val index = fieldDescriptionMesg.developerDataIndex!!
                if (developerFields.containsKey(index)) {
                    developerFields[index]!![fieldDescriptionMesg.fieldDefinitionNumber!!] = fieldDescriptionMesg

                    val description = DeveloperFieldDescription(developerDataIds[index]!!, fieldDescriptionMesg)
                    for (listener in devFieldDescListeners) {
                        listener.onDescription(description)
                    }
                }
            }
        }

        for (mesgListener in mesgListeners) {
            mesgListener.onMesg(mesg)
        }
    }
}
