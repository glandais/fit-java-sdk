// Hand-written multiplatform port of SubField.java — keep in sync (see overrides/hashes.json).
//
// Note: the Java accessors getName()/getType()/getUnits() are replaced by direct access to the
// internal properties name/type/units (a Kotlin internal fun getName() would clash on the JVM
// with the mangled getter of the internal property `name`). All users are in-module.
package com.garmin.fit

class SubField {
    private class SubFieldMap(private val refFieldNum: Int, private val refFieldValue: Long) {

        fun canMesgSupport(mesg: Mesg): Boolean {
            val field = mesg.getField(refFieldNum)

            if (field != null) {
                val value = field.getLongValue(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
                if (value != null) {
                    if (value == refFieldValue) {
                        return true
                    }
                }
            }

            return false
        }
    }

    internal var name: String = "unknown"
    internal var type: Int = 0
    internal var scale: Double = 1.0
    internal var offset: Double = 0.0
    internal var units: String = ""
    private var maps: ArrayList<SubFieldMap> = ArrayList()
    internal var components: ArrayList<FieldComponent> = ArrayList()

    internal constructor(subField: SubField?) {
        if (subField == null) {
            return
        }

        this.name = subField.name
        this.type = subField.type
        this.scale = subField.scale
        this.offset = subField.offset
        this.units = subField.units
        this.maps = subField.maps
        this.components = subField.components
    }

    internal constructor(name: String, type: Int, scale: Double, offset: Double, units: String) {
        this.name = name
        this.type = type
        this.scale = scale
        this.offset = offset
        this.units = units
    }

    internal fun addMap(refFieldNum: Int, refFieldValue: Long) {
        maps.add(SubFieldMap(refFieldNum, refFieldValue))
    }

    internal fun addComponent(component: FieldComponent) {
        components.add(component)
    }

    fun canMesgSupport(mesg: Mesg): Boolean {
        for (map in maps) {
            if (map.canMesgSupport(mesg)) {
                return true
            }
        }
        return false
    }
}
