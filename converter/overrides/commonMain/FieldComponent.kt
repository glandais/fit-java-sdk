// Hand-written multiplatform port of FieldComponent.java — keep in sync (see overrides/hashes.json).
// Java members are protected (package access); internal here because the generated mesg
// companions and Decode access them cross-class within the module.
package com.garmin.fit

class FieldComponent internal constructor(
    internal val fieldNum: Int,
    internal val accumulate: Boolean,
    internal val bits: Int,
    internal val scale: Double,
    internal val offset: Double
)
