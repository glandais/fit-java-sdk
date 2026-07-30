/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HrvMesg.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

open class HrvMesg : Mesg {

    companion object {
        const val TimeFieldNum = 0

        val hrvMesg: Mesg = run {
            // hrv
            val hrvMesg = Mesg("hrv", MesgNum.HRV)
            hrvMesg.addField(Field("time", TimeFieldNum, 132, 1000.0, 0.0, "s", false, Profile.Type.UINT16))
            hrvMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.HRV))

    constructor(mesg: Mesg?) : super(mesg)

    fun getTime(): Array<Float?>? {
        return getFieldFloatValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * @return number of time
     */
    fun getNumTime(): Int {
        return getNumFieldValues(0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Get time field
     * Units: s
     * Comment: Time between beats
     *
     * @param index of time
     * @return time
     */
    fun getTime(index: Int): Float? {
        return getFieldFloatValue(0, index, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }

    /**
     * Set time field
     * Units: s
     * Comment: Time between beats
     *
     * @param index of time
     * @param time The new time value to be set
     */
    fun setTime(index: Int, time: Float?) {
        setFieldValue(0, index, time, Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
}
