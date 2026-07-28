/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from HsaConfigurationDataMesgListener.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

fun interface HsaConfigurationDataMesgListener {
    fun onMesg(mesg: HsaConfigurationDataMesg)
}
