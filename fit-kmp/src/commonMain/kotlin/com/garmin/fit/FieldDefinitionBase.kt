// Hand-written multiplatform port of FieldDefinitionBase.java — keep in sync (see overrides/hashes.json).
package com.garmin.fit

abstract class FieldDefinitionBase {
    abstract fun getSize(): Int

    abstract fun setSize(size: Int)
}
