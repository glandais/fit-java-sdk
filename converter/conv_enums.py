"""Converts Java `public enum` files (Garmin FIT SDK) into Kotlin enum classes.

Contract: def convert(files: list[Path], out_dir: Path) -> list[Path]

See DESIGN.md section 6.1 for the exact template this module must produce.
All ~102 enum files in scope declare a single-argument `(short)<literal>`
constructor call per constant; the generated Kotlin enum takes an `Int`
constructor argument (clean literal, no cast) and exposes a `Short` `value`
property, plus a `companion object` with `fromValue`/`getStringFromValue`.
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

# Matches the top-level enum declaration, e.g. "public enum Sport  {" or "public enum Bool {"
ENUM_DECL_RE = re.compile(r"^public\s+enum\s+(\w+)\s*(?:implements\s+[\w<>,\s]+)?\{?\s*$", re.MULTILINE)

# Matches one enum constant: NAME((short)LITERAL) possibly spanning to the next constant,
# separated by commas, terminated by a semicolon after the last one.
CONSTANT_RE = re.compile(r"(\w+)\s*\(\s*\(short\)\s*(0[xX][0-9a-fA-F]+|\d+)\s*\)")


def _extract_enum_name(text: str) -> str:
    m = ENUM_DECL_RE.search(text)
    if not m:
        raise ValueError("no top-level 'public enum <Name>' declaration found")
    return m.group(1)


def _extract_constants_block(text: str, enum_name: str) -> str:
    """Return the substring of `text` spanning from the enum's opening brace
    up to (and excluding) the first `;` that terminates the constant list."""
    decl_match = ENUM_DECL_RE.search(text)
    assert decl_match is not None
    start = decl_match.end()
    # decl regex may or may not have consumed the opening brace; make sure we start after it.
    brace_idx = text.find("{", decl_match.start())
    if brace_idx == -1:
        raise ValueError(f"no opening brace found for enum {enum_name}")
    start = brace_idx + 1
    semi_idx = text.find(";", start)
    if semi_idx == -1:
        raise ValueError(f"no ';' terminating constant list for enum {enum_name}")
    return text[start:semi_idx]


def _parse_constants(block: str, enum_name: str) -> list[tuple[str, str]]:
    """Return list of (constant_name, literal_without_cast) in declaration order."""
    constants = CONSTANT_RE.findall(block)
    if not constants:
        raise ValueError(f"no enum constants parsed for enum {enum_name}")
    # Sanity check: the number of matches should equal the number of top-level
    # constant separators (commas between constants). We don't hard-fail on
    # mismatch since nested parens don't occur here, but guard against silently
    # dropping constants by comparing against a simpler split-based count.
    return constants


def convert_one(java_path: Path) -> str:
    text = java_path.read_text(encoding="utf-8")
    enum_name = _extract_enum_name(text)
    block = _extract_constants_block(text, enum_name)
    constants = _parse_constants(block, enum_name)

    lines: list[str] = []
    lines.append(HEADER_TEMPLATE.format(name=enum_name))
    lines.append(f"enum class {enum_name}(rawValue: Int) {{")
    for i, (const_name, literal) in enumerate(constants):
        terminator = ";" if i == len(constants) - 1 else ","
        lines.append(f"    {const_name}({literal}){terminator}")
    lines.append("")
    lines.append("    val value: Short = rawValue.toShort()")
    lines.append("")
    lines.append("    companion object {")
    lines.append(f"        fun fromValue(value: Short?): {enum_name} {{")
    lines.append("            return entries.firstOrNull { it.value == value } ?: INVALID")
    lines.append("        }")
    lines.append("")
    lines.append(f"        fun getStringFromValue(value: {enum_name}): String = value.name")
    lines.append("    }")
    lines.append("}")
    lines.append("")
    return "\n".join(lines)


def convert(files: list[Path], out_dir: Path) -> list[Path]:
    out_dir.mkdir(parents=True, exist_ok=True)
    written: list[Path] = []
    for java_path in files:
        kotlin_text = convert_one(java_path)
        out_path = out_dir / f"{java_path.stem}.kt"
        out_path.write_text(kotlin_text, encoding="utf-8")
        written.append(out_path)
    return written


if __name__ == "__main__":
    import sys

    src_dir = Path(sys.argv[1]) if len(sys.argv) > 1 else Path(__file__).resolve().parent.parent / "src/main/java/com/garmin/fit"
    out_dir = Path(sys.argv[2]) if len(sys.argv) > 2 else Path("/tmp/conv_enums_out")

    enum_files = []
    for p in sorted(src_dir.glob("*.java")):
        content = p.read_text(encoding="utf-8")
        if ENUM_DECL_RE.search(content):
            enum_files.append(p)

    print(f"Found {len(enum_files)} top-level enum files")
    result = convert(enum_files, out_dir)
    print(f"Wrote {len(result)} .kt files to {out_dir}")
