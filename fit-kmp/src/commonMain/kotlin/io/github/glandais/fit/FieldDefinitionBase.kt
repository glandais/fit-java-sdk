// Hand-written multiplatform port of FieldDefinitionBase.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

abstract class FieldDefinitionBase {
    abstract fun getSize(): Int

    abstract fun setSize(size: Int)
}
