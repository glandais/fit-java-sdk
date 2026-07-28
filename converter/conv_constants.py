"""Converts Java "constants" classes (Garmin FIT SDK) into Kotlin `object`s.

Contract: def convert(files: list[Path], out_dir: Path) -> list[Path]

See DESIGN.md section 6.2 for the exact template this module must produce.
A "constants" file (per classify.py) is a top-level class containing
`getStringFromValue`, e.g. GarminProduct, Manufacturer, SportBits0, MesgNum,
PlankExerciseName, ... (~99 files, two of which -- DateTime.java and
LocalDateTime.java -- are hand-ported overrides and must be skipped here,
cf. DESIGN.md §0/§3).

Each in-scope file declares:
  - a flat list of `public static final <int|short|long> NAME = <expr>;`
    fields (one base type per file, optionally followed by an end-of-line
    `// comment`), the last of which is conventionally `INVALID`;
  - a `private static final Map<Boxed, String> stringMap;` populated in a
    static initializer with `stringMap.put(NAME, "NAME");` calls, in
    declaration order;
  - `getStringFromValue(Boxed value)` / `getValueFromString(String value)`
    static methods with a fixed, mechanical body.

The Kotlin output is a single `object <Name>` with `const val`/`val` fields,
a `stringMap` built with `mapOf(...)`, and the two lookup functions.
"""

from __future__ import annotations

import re
from pathlib import Path

HEADER_TEMPLATE = (
    "/////////////////////////////////////////////////////////////////////////////////////////////\n"
    "// Converted from {name}.java (Garmin FIT SDK 21.205.0) by converter/convert.py.\n"
    "// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.\n"
    "/////////////////////////////////////////////////////////////////////////////////////////////\n"
    "package com.garmin.fit\n"
)

# DateTime.java / LocalDateTime.java are constants-shaped (they contain
# getStringFromValue) but are hand-written multiplatform overrides instead
# (DESIGN.md §0, §3). conv_constants.py must not touch them.
SKIP_HANDWRITTEN = {"DateTime.java", "LocalDateTime.java"}

# Top-level class declaration, e.g. "public class GarminProduct  {".
CLASS_DECL_RE = re.compile(r"^public\s+class\s+(\w+)\b", re.MULTILINE)

# The boxed parameter type of getStringFromValue tells us the base numeric
# type of every constant in the file (int/short/long <-> Integer/Short/Long).
GET_STRING_FROM_VALUE_RE = re.compile(
    r"getStringFromValue\(\s*(Integer|Short|Long|Byte)\s+value\s*\)"
)

# One `public static final <type> NAME = <expr>;` field declaration, with an
# optional trailing end-of-line comment.
FIELD_RE = re.compile(
    r"^\s*public\s+static\s+final\s+(int|short|long|byte)\s+(\w+)\s*=\s*([^;]+?)\s*;"
    r"(?:\s*//\s*(.*?))?\s*$",
    re.MULTILINE,
)

# One `stringMap.put(NAME, "NAME");` entry inside the static initializer.
STRING_MAP_PUT_RE = re.compile(r"stringMap\.put\(\s*(\w+)\s*,\s*\"([^\"]*)\"\s*\)")

# A bare Java integer literal (decimal or hex, optional leading '-', optional
# trailing 'l'/'L' long suffix) -- as opposed to a reference expression like
# `Fit.UINT16_INVALID`.
LITERAL_RE = re.compile(r"^(-?)(0[xX][0-9A-Fa-f]+|\d+)([lL]?)$")

JAVA_TO_KOTLIN_TYPE = {"int": "Int", "short": "Short", "long": "Long", "byte": "Byte"}
BOXED_TO_JAVA_TYPE = {"Integer": "int", "Short": "short", "Long": "long", "Byte": "byte"}


def _parse_literal(expr: str) -> tuple[int, bool, bool] | None:
    """Parse a bare Java integer literal.

    Returns (value, is_hex, has_long_suffix) or None if `expr` is not a bare
    literal (e.g. a reference expression such as `Fit.UINT16_INVALID`).
    """
    m = LITERAL_RE.match(expr.strip())
    if not m:
        return None
    sign, digits, suffix = m.groups()
    value = int(digits, 16) if digits.lower().startswith("0x") else int(digits)
    if sign == "-":
        value = -value
    return value, digits.lower().startswith("0x"), suffix != ""


def _java_literal_value(expr: str) -> int | None:
    """Return the exact numeric value a Java field initializer evaluates to,
    or None if `expr` is not a bare integer literal.

    Java hex literals without an `L`/`l` suffix are of type `int` (32-bit),
    regardless of the field's declared type: a hex literal with the sign bit
    set (e.g. `0x80000000`, `0xF0000000`) therefore denotes a *negative* int,
    which is then sign-extended when implicitly widened to `long`. This must
    be reproduced exactly, since Kotlin hex literals do not sign-extend from
    32 bits when written directly as `Long` (e.g. `0xF0000000L` in Kotlin
    means +4026531840, not the -268435456 that Java produces).
    """
    parsed = _parse_literal(expr)
    if parsed is None:
        return None
    value, is_hex, has_long_suffix = parsed
    if is_hex and not has_long_suffix and value >= (1 << 31):
        value -= 1 << 32
    return value


def _format_kotlin_literal(value: int, kotlin_type: str) -> str:
    suffix = "L" if kotlin_type == "Long" else ""
    return f"{value}{suffix}"


def _extract_class_name(text: str) -> str:
    m = CLASS_DECL_RE.search(text)
    if not m:
        raise ValueError("no top-level 'public class <Name>' declaration found")
    return m.group(1)


def _extract_value_type(text: str, class_name: str) -> str:
    m = GET_STRING_FROM_VALUE_RE.search(text)
    if not m:
        raise ValueError(f"no getStringFromValue(<Boxed> value) found in {class_name}")
    return m.group(1)


class Field:
    __slots__ = ("name", "java_type", "kotlin_type", "raw_expr", "comment", "kotlin_value")

    def __init__(self, name: str, java_type: str, raw_expr: str, comment: str | None):
        self.name = name
        self.java_type = java_type
        self.kotlin_type = JAVA_TO_KOTLIN_TYPE[java_type]
        self.raw_expr = raw_expr.strip()
        self.comment = comment
        literal_value = _java_literal_value(self.raw_expr)
        self.kotlin_value = (
            _format_kotlin_literal(literal_value, self.kotlin_type)
            if literal_value is not None
            else self.raw_expr
        )

    @property
    def is_literal(self) -> bool:
        return _java_literal_value(self.raw_expr) is not None


def _parse_fields(text: str, class_name: str, expected_java_type: str) -> list[Field]:
    fields: list[Field] = []
    seen: set[str] = set()
    for java_type, name, raw_expr, comment in FIELD_RE.findall(text):
        if java_type != expected_java_type:
            raise ValueError(
                f"{class_name}: mixed field base types ({expected_java_type} vs {java_type} "
                f"for {name})"
            )
        fields.append(Field(name, java_type, raw_expr, comment or None))
        seen.add(name)
    if not fields:
        raise ValueError(f"no 'public static final {expected_java_type}' fields parsed in {class_name}")
    return fields


def _parse_string_map(text: str, class_name: str, fields_by_name: dict[str, Field]) -> list[tuple[str, str]]:
    entries: list[tuple[str, str]] = []
    for name, label in STRING_MAP_PUT_RE.findall(text):
        if name not in fields_by_name:
            raise ValueError(f"{class_name}: stringMap.put references unknown constant {name!r}")
        entries.append((name, label))
    return entries


def convert_one(java_path: Path) -> str:
    text = java_path.read_text(encoding="utf-8")
    class_name = _extract_class_name(text)
    boxed_type = _extract_value_type(text, class_name)
    expected_java_type = BOXED_TO_JAVA_TYPE[boxed_type]
    kotlin_type = JAVA_TO_KOTLIN_TYPE[expected_java_type]

    fields = _parse_fields(text, class_name, expected_java_type)
    fields_by_name = {f.name: f for f in fields}
    string_map_entries = _parse_string_map(text, class_name, fields_by_name)

    if "INVALID" in fields_by_name:
        invalid_expr = "INVALID"
    else:
        # No file in the current inventory lacks INVALID (DESIGN.md §6.2), but
        # stay faithful to the Java fallback (`return INVALID;`) rather than
        # failing silently if a future SDK version omits it: recopy whatever
        # getValueFromString's Java body returns.
        m = re.search(r"getValueFromString[\s\S]*?return\s+([^;]+);\s*\}\s*\}\s*$", text)
        invalid_expr = m.group(1).strip() if m else "INVALID"

    lines: list[str] = []
    lines.append(HEADER_TEMPLATE.format(name=class_name))
    lines.append(f"object {class_name} {{")
    for f in fields:
        decl = "const val" if f.is_literal else "val"
        # Type explicite : un littéral entier nu serait inféré Int alors que le
        # type Java peut être short/long/byte (stringMap et signatures typés).
        line = f"    {decl} {f.name}: {f.kotlin_type} = {f.kotlin_value}"
        if f.comment:
            line += f" // {f.comment}"
        lines.append(line)
    lines.append("")

    lines.append(f"    private val stringMap: Map<{kotlin_type}, String> = mapOf(")
    for i, (name, label) in enumerate(string_map_entries):
        comma = "," if i < len(string_map_entries) - 1 else ""
        lines.append(f"        {name} to \"{label}\"{comma}")
    lines.append("    )")
    lines.append("")

    lines.append(f"    fun getStringFromValue(value: {kotlin_type}?): String = stringMap[value] ?: \"\"")
    lines.append("")
    lines.append(f"    fun getValueFromString(value: String): {kotlin_type} {{")
    lines.append("        for ((k, v) in stringMap) {")
    lines.append("            if (v == value) return k")
    lines.append("        }")
    lines.append(f"        return {invalid_expr}")
    lines.append("    }")
    lines.append("}")
    lines.append("")
    return "\n".join(lines)


def convert(files: list[Path], out_dir: Path) -> list[Path]:
    out_dir.mkdir(parents=True, exist_ok=True)
    written: list[Path] = []
    for java_path in files:
        if java_path.name in SKIP_HANDWRITTEN:
            continue
        kotlin_text = convert_one(java_path)
        out_path = out_dir / f"{java_path.stem}.kt"
        out_path.write_text(kotlin_text, encoding="utf-8")
        written.append(out_path)
    return written


if __name__ == "__main__":
    import sys

    src_dir = Path(sys.argv[1]) if len(sys.argv) > 1 else Path(__file__).resolve().parent.parent / "src/main/java/com/garmin/fit"
    out_dir = Path(sys.argv[2]) if len(sys.argv) > 2 else Path("/tmp/conv_constants_out")

    names = sys.argv[3:] if len(sys.argv) > 3 else [
        "GarminProduct.java",
        "Manufacturer.java",
        "SportBits0.java",
        "MesgNum.java",
        "PlankExerciseName.java",
    ]
    test_files = [src_dir / n for n in names]
    missing = [str(p) for p in test_files if not p.exists()]
    if missing:
        raise SystemExit(f"missing input files: {missing}")

    result = convert(test_files, out_dir)
    print(f"Wrote {len(result)} .kt files to {out_dir}")
    for p in result:
        print(f"  {p}")
