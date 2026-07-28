// Hand-written multiplatform port of Accumulator.java — keep in sync (see overrides/hashes.json).
// Package-private Java class -> internal.
package com.garmin.fit

internal class Accumulator {
    // Index by Mesg# and DestField#
    private val accumulatedFields: ArrayList<AccumulatedField> = ArrayList()

    fun set(mesgNum: Int, destFieldNum: Int, value: Long) {
        var accumField: AccumulatedField? = null
        var i = 0

        while (i < accumulatedFields.size) {
            accumField = accumulatedFields[i]

            if ((accumField.mesgNum == mesgNum) && (accumField.destFieldNum == destFieldNum)) {
                break
            }
            i++
        }

        if (i == accumulatedFields.size) {
            accumField = AccumulatedField(mesgNum, destFieldNum)
            accumulatedFields.add(accumField)
        }

        accumField!!.set(value)
    }

    fun accumulate(mesgNum: Int, destFieldNum: Int, value: Long, bits: Int): Long {
        var accumField: AccumulatedField? = null
        var i = 0

        while (i < accumulatedFields.size) {
            accumField = accumulatedFields[i]

            if ((accumField.mesgNum == mesgNum) && (accumField.destFieldNum == destFieldNum)) {
                break
            }
            i++
        }

        if (i == accumulatedFields.size) {
            accumField = AccumulatedField(mesgNum, destFieldNum)
            accumulatedFields.add(accumField)
        }

        return accumField!!.accumulate(value, bits)
    }

    private class AccumulatedField(val mesgNum: Int, val destFieldNum: Int /* Field# to accumulate into */) {
        var lastValue: Long = 0
        var accumulatedValue: Long = 0

        fun accumulate(value: Long, bits: Int): Long {
            val mask = (1L shl bits) - 1

            accumulatedValue += (value - lastValue) and mask
            lastValue = value

            return accumulatedValue
        }

        fun set(value: Long): Long {
            accumulatedValue = value
            this.lastValue = value
            return accumulatedValue
        }
    }
}
