/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from ProjectileType.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class ProjectileType(rawValue: Int) {
    ARROW(0),
    RIFLE_CARTRIDGE(1),
    PISTOL_CARTRIDGE(2),
    SHOTSHELL(3),
    AIR_RIFLE_PELLET(4),
    OTHER(5),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): ProjectileType {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: ProjectileType): String = value.name
    }
}
