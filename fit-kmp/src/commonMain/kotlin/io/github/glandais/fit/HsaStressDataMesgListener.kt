/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaStressDataMesgListener.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

fun interface HsaStressDataMesgListener {
    fun onMesg(mesg: HsaStressDataMesg)
}
