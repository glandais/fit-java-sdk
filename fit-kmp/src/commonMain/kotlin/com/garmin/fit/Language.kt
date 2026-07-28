/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from Language.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit

enum class Language(rawValue: Int) {
    ENGLISH(0),
    FRENCH(1),
    ITALIAN(2),
    GERMAN(3),
    SPANISH(4),
    CROATIAN(5),
    CZECH(6),
    DANISH(7),
    DUTCH(8),
    FINNISH(9),
    GREEK(10),
    HUNGARIAN(11),
    NORWEGIAN(12),
    POLISH(13),
    PORTUGUESE(14),
    SLOVAKIAN(15),
    SLOVENIAN(16),
    SWEDISH(17),
    RUSSIAN(18),
    TURKISH(19),
    LATVIAN(20),
    UKRAINIAN(21),
    ARABIC(22),
    FARSI(23),
    BULGARIAN(24),
    ROMANIAN(25),
    CHINESE(26),
    JAPANESE(27),
    KOREAN(28),
    TAIWANESE(29),
    THAI(30),
    HEBREW(31),
    BRAZILIAN_PORTUGUESE(32),
    INDONESIAN(33),
    MALAYSIAN(34),
    VIETNAMESE(35),
    BURMESE(36),
    MONGOLIAN(37),
    CUSTOM(254),
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Language {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Language): String = value.name
    }
}
