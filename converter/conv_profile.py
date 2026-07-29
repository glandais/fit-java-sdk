"""conv_profile.py — convert the 5 profile-dependent generated Java files to Kotlin.

Handled files (each has its own dedicated mini-translator, parsing the file by
regular blocks; any unexpected construct raises ConversionError loudly):
  - Profile.java         -> object Profile { object SubFields; enumValueName(); enum class Type }
  - Factory.java         -> object Factory (when() dispatch + mesgs table)
  - FitMessages.java     -> class FitMessages (internal ArrayList fields + getters)
  - FitListener.java     -> class FitListener : MesgListener, DeveloperFieldDescriptionListener
  - MesgBroadcaster.java -> class MesgBroadcaster (listener registries, when() dispatch)

Contract: def convert(files: list[Path], out_dir: Path) -> list[Path]
Python 3 stdlib only. See converter/DESIGN.md (§6.5) for the mapping rules.
"""

from __future__ import annotations

import re
import sys
from pathlib import Path


class ConversionError(Exception):
    """Raised loudly on any construct the translators do not recognise."""


DEFAULT_SDK_VERSION = "21.205.0"


def _sdk_version(src: str) -> str:
    m = re.search(r"Profile Version = (\d+(?:\.\d+)*)", src)
    return m.group(1) if m else DEFAULT_SDK_VERSION


def _header(java_name: str, version: str) -> str:
    bar = "/" * 93
    return (
        f"{bar}\n"
        f"// Converted from {java_name} (Garmin FIT SDK {version}) by converter/convert.py.\n"
        f"// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.\n"
        f"{bar}\n"
        "package com.garmin.fit\n"
    )


def _fail(java_name: str, line_no: int | None, msg: str) -> None:
    where = f"{java_name}:{line_no}" if line_no is not None else java_name
    raise ConversionError(f"{where}: {msg}")


def _line_of(src: str, pos: int) -> int:
    return src.count("\n", 0, pos) + 1


def _require(src: str, java_name: str, pattern: str, what: str) -> re.Match:
    m = re.search(pattern, src)
    if m is None:
        _fail(java_name, None, f"expected construct not found: {what}")
    return m


def _block(src: str, java_name: str, open_pos: int) -> tuple[str, int]:
    """Return (body, end_pos) of the {...} block whose '{' is at open_pos."""
    if src[open_pos] != "{":
        _fail(java_name, _line_of(src, open_pos), "expected '{'")
    depth = 0
    for i in range(open_pos, len(src)):
        c = src[i]
        if c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
            if depth == 0:
                return src[open_pos + 1 : i], i
    _fail(java_name, _line_of(src, open_pos), "unbalanced braces")
    raise AssertionError  # unreachable


_INT_LITERAL = re.compile(r"^(?:-?\d+|0[xX][0-9a-fA-F]+)$")


# ---------------------------------------------------------------------------
# Profile.java
# ---------------------------------------------------------------------------

def _convert_profile(src: str, java_name: str) -> str:
    out: list[str] = [_header(java_name, _sdk_version(src)), ""]
    out.append("object Profile {")

    # --- SubFields ---------------------------------------------------------
    m = _require(src, java_name, r"public class SubFields \{", "public class SubFields")
    body, _ = _block(src, java_name, src.index("{", m.start()))
    out.append("    object SubFields {")
    for raw in body.splitlines():
        line = raw.strip()
        if not line:
            out.append("")
            continue
        if line.startswith("//"):
            out.append(f"        {line}")
            continue
        cm = re.match(r"^public static final int (\w+) = (.+);$", line)
        if cm is None:
            _fail(java_name, None, f"SubFields: unrecognized line: {line!r}")
        name, value = cm.group(1), cm.group(2).strip()
        kw = "const val" if _INT_LITERAL.match(value) else "val"
        out.append(f"        {kw} {name} = {value}")
    # Trim leading/trailing blank lines inside the object body.
    while out and out[-1] == "":
        out.pop()
    out.append("    }")
    out.append("")

    # --- enumValueName -----------------------------------------------------
    m = _require(
        src,
        java_name,
        r"(?s)(/\*\*.*?\*/\s*)?public static String enumValueName\(Profile\.Type enumType, long enumVal\) \{",
        "enumValueName(Profile.Type, long)",
    )
    if m.group(1):
        for line in m.group(1).strip().splitlines():
            s = line.strip()
            out.append(f"     {s}" if s.startswith("*") else f"    {s}")
    sw = _require(
        src[m.start():], java_name, r"switch \(enumType\) \{", "switch (enumType) in enumValueName"
    )
    sw_body, _ = _block(src, java_name, src.index("{", m.start() + sw.start() + len("switch (enumType) ") - 1))

    out.append("    fun enumValueName(enumType: Type, enumVal: Long): String {")
    out.append('        var retVal = ""')
    out.append("        val shortVal = enumVal.toShort()")
    out.append("")
    out.append("        when (enumType) {")

    # Parse case blocks: labels, optional 'retVal = <expr>;', 'break;'.
    labels: list[str] = []
    expr: str | None = None
    branches: list[tuple[list[str], str]] = []
    is_default = False
    for raw in sw_body.splitlines():
        line = raw.strip()
        if not line:
            continue
        cm = re.match(r"^case (\w+):(?:\s*//.*)?$", line)
        if cm:
            labels.append(cm.group(1))
            continue
        if re.match(r"^default:(?:\s*//.*)?$", line):
            is_default = True
            continue
        em = re.match(r"^retVal = (.+);$", line)
        if em:
            if expr is not None:
                _fail(java_name, None, f"enumValueName: two statements in one case near {line!r}")
            expr = em.group(1)
            continue
        if line == "break;":
            if expr is not None:
                if not labels:
                    _fail(java_name, None, "enumValueName: retVal assignment without case label")
                branches.append((labels, _translate_enum_value_expr(expr)))
            labels, expr, is_default = [], None, False
            continue
        _fail(java_name, None, f"enumValueName: unrecognized line: {line!r}")
    if not branches:
        _fail(java_name, None, "enumValueName: no case branches parsed")
    for case_labels, kexpr in branches:
        heads = ", ".join(f"Type.{l}" for l in case_labels)
        out.append(f"            {heads} -> retVal = {kexpr}")
    out.append("            else -> {}")
    out.append("        }")
    out.append("")
    out.append("        // If we fail to convert this to a named enum value, return the string representation")
    out.append("        // of the numerical value.")
    out.append('        if (retVal == "") {')
    out.append("            retVal = enumVal.toString()")
    out.append("        }")
    out.append("")
    out.append("        return retVal")
    out.append("    }")
    out.append("")

    # --- enum Type ---------------------------------------------------------
    m = _require(src, java_name, r"public enum Type \{", "public enum Type")
    tbody, _ = _block(src, java_name, src.index("{", m.start()))
    semi = tbody.find(";")
    if semi < 0:
        _fail(java_name, None, "enum Type: missing ';' after constant list")
    names: list[str] = []
    for raw in tbody[:semi].split(","):
        n = raw.strip()
        if not n:
            continue
        if not re.match(r"^\w+$", n):
            _fail(java_name, None, f"enum Type: unrecognized constant: {n!r}")
        names.append(n)
    if not names:
        _fail(java_name, None, "enum Type: no constants parsed")

    # Java Profile.Type has no explicit value (pure ordinal enum): keep it a
    # plain Kotlin enum class (same names, same ordinals).
    out.append("    enum class Type {")
    for n in names[:-1]:
        out.append(f"        {n},")
    out.append(f"        {names[-1]};")
    out.append("")

    # fromBaseType switch
    fm = re.search(r"public static Type fromBaseType\(final int baseType\) \{", tbody)
    if fm is None:
        _fail(java_name, None, "enum Type: fromBaseType(int) not found")
    fbody, _ = _block(tbody, java_name, tbody.index("{", fm.start()))
    sw = re.search(r"switch\s*\(baseType\) \{", fbody)
    if sw is None:
        _fail(java_name, None, "fromBaseType: switch(baseType) not found")
    sw_body, _ = _block(fbody, java_name, fbody.index("{", sw.start()))

    fb_labels: list[str] = []
    fb_default = False
    fb_branches: list[tuple[list[str], bool, str]] = []
    for raw in sw_body.splitlines():
        line = raw.strip()
        if not line:
            continue
        cm = re.match(r"^case (Fit\.\w+):$", line)
        if cm:
            fb_labels.append(cm.group(1))
            continue
        if line == "default:":
            fb_default = True
            continue
        rm = re.match(r"^return Type\.(\w+);$", line)
        if rm:
            fb_branches.append((fb_labels, fb_default, rm.group(1)))
            fb_labels, fb_default = [], False
            continue
        _fail(java_name, None, f"fromBaseType: unrecognized line: {line!r}")
    if fb_labels or fb_default:
        _fail(java_name, None, "fromBaseType: dangling case labels without return")

    out.append("    companion object {")
    out.append("        fun fromBaseType(baseType: Int): Type {")
    out.append("            return when (baseType) {")
    for case_labels, has_default, target in fb_branches:
        if has_default:
            # 'case Fit.BASE_TYPE_ENUM: default:' -> else covers both.
            out.append(f"                else -> {target}")
        else:
            out.append(f"                {', '.join(case_labels)} -> {target}")
    out.append("            }")
    out.append("        }")
    out.append("    }")
    out.append("    }")
    out.append("}")
    out.append("")
    return _reindent_profile_companion(out)


def _reindent_profile_companion(out: list[str]) -> str:
    """Re-emit Profile.kt with the Type companion correctly indented."""
    text_lines: list[str] = []
    in_companion = False
    for line in out:
        if line == "    companion object {":
            in_companion = True
            text_lines.append("        companion object {")
            continue
        if in_companion:
            if line == "    }":
                in_companion = False
                text_lines.append("        }")
                continue
            text_lines.append("    " + line if line else line)
            continue
        text_lines.append(line)
    return "\n".join(text_lines)


def _translate_enum_value_expr(expr: str) -> str:
    """Translate a Java 'retVal = ...' RHS from Profile.enumValueName."""
    e = expr.strip()
    e = re.sub(r"(\w+)\.getByValue\(", r"\1.fromValue(", e)
    e = e.replace("(short)enumVal", "enumVal.toShort()")
    e = e.replace("(int)enumVal", "enumVal.toInt()")
    # Only known shapes may remain: Xxx.getStringFromValue(<arg>)
    if not re.match(
        r"^\w+\.getStringFromValue\((?:\w+\.fromValue\(shortVal\)|shortVal|enumVal(?:\.to(?:Short|Int)\(\))?)\)$",
        e,
    ):
        raise ConversionError(f"Profile.java: enumValueName: unrecognized expression: {expr!r}")
    return e


# ---------------------------------------------------------------------------
# Factory.java
# ---------------------------------------------------------------------------

def _convert_factory(src: str, java_name: str) -> str:
    # createMesg(Mesg) dispatch table
    m = _require(src, java_name, r"static public Mesg createMesg\(Mesg mesg\) \{", "createMesg(Mesg)")
    body, _ = _block(src, java_name, src.index("{", m.start()))
    pairs = re.findall(r"case MesgNum\.(\w+):\s*return new (\w+)\(mesg\);", body)
    n_cases = len(re.findall(r"case MesgNum\.\w+:", body))
    if not pairs or len(pairs) != n_cases:
        _fail(java_name, None, f"createMesg(Mesg): parsed {len(pairs)} pairs for {n_cases} cases")
    dm = re.search(r'return new Mesg\("unknown", MesgNum\.INVALID\);\s*$', body.strip(), re.S)
    if dm is None:
        _fail(java_name, None, "createMesg(Mesg): default return not recognized")

    # static mesgs table
    sm = _require(src, java_name, r"private static final Mesg mesgs\[\] = new Mesg\[(\d+)\];", "mesgs[] table")
    count = int(sm.group(1))
    st = _require(src, java_name, r"\n    static \{", "static initializer block")
    sbody, _ = _block(src, java_name, src.index("{", st.start()))
    refs = []
    for raw in sbody.splitlines():
        line = raw.strip()
        if not line or line == "int mesg_index = 0;" or line == "mesg_index++;":
            continue
        rm = re.match(r"^mesgs\[mesg_index\] = (\w+)\.(\w+);$", line)
        if rm is None:
            _fail(java_name, None, f"static block: unrecognized line: {line!r}")
        refs.append(f"{rm.group(1)}.{rm.group(2)}")
    if len(refs) != count:
        _fail(java_name, None, f"static block: {len(refs)} entries but mesgs[{count}] declared")

    # Assert the fixed-form helper methods exist as expected before templating them.
    expected_sigs = [
        r"static public Mesg createMesg\(int mesgNum\) \{",
        r"static public Mesg createMesg\(String mesgName\) \{",
        r"static public Field createField\(String mesgName, String fieldName\) \{",
        r"static public Field createField\(String mesgName, int fieldNum\) \{",
        r"static public Field createField\(int mesgNum, int fieldNum\) \{",
        r"static public Field createField\(int mesgNum, String fieldName\) \{",
        r"static public Field createField\(String mesgName, String fieldName, ArrayList<Object> values\) \{",
    ]
    for sig in expected_sigs:
        _require(src, java_name, sig, f"Factory method {sig}")
    n_methods = len(re.findall(r"static public \w+ \w+\(", src))
    if n_methods != len(expected_sigs) + 1:
        _fail(java_name, None, f"Factory declares {n_methods} static methods, expected {len(expected_sigs) + 1}")

    out: list[str] = [_header(java_name, _sdk_version(src)), ""]
    out.append("object Factory {")
    out.append("    fun createMesg(mesg: Mesg): Mesg {")
    out.append("        return when (mesg.getNum()) {")
    for num, cls in pairs:
        out.append(f"            MesgNum.{num} -> {cls}(mesg)")
    out.append('            else -> Mesg("unknown", MesgNum.INVALID)')
    out.append("        }")
    out.append("    }")
    out.append("")
    out.append("    fun createMesg(mesgNum: Int): Mesg {")
    out.append("        for (i in mesgs.indices) {")
    out.append("            if (mesgs[i].num == mesgNum) {")
    out.append("                return Mesg(mesgs[i])")
    out.append("            }")
    out.append("        }")
    out.append('        return Mesg("unknown", mesgNum)')
    out.append("    }")
    out.append("")
    out.append("    fun createMesg(mesgName: String?): Mesg {")
    out.append("        for (i in mesgs.indices) {")
    out.append("            if (mesgs[i].name == mesgName) {")
    out.append("                return Mesg(mesgs[i])")
    out.append("            }")
    out.append("        }")
    out.append("        return Mesg(mesgName ?: \"unknown\", MesgNum.INVALID)")
    out.append("    }")
    out.append("")
    out.append("    fun createField(mesgName: String?, fieldName: String?): Field {")
    out.append("        for (i in mesgs.indices) {")
    out.append("            if (mesgs[i].name == mesgName) {")
    out.append("                return Field(mesgs[i].getField(fieldName, false))")
    out.append("            }")
    out.append("        }")
    out.append("        return Field(fieldName ?: \"unknown\", Fit.FIELD_NUM_INVALID, 0, 1.0, 0.0, \"\", false, Profile.Type.ENUM)")
    out.append("    }")
    out.append("")
    out.append("    fun createField(mesgName: String?, fieldNum: Int): Field {")
    out.append("        for (i in mesgs.indices) {")
    out.append("            if (mesgs[i].name == mesgName) {")
    out.append("                return Field(mesgs[i].getField(fieldNum))")
    out.append("            }")
    out.append("        }")
    out.append("        return Field(\"unknown\", fieldNum, 0, 1.0, 0.0, \"\", false, Profile.Type.ENUM)")
    out.append("    }")
    out.append("")
    out.append("    fun createField(mesgNum: Int, fieldNum: Int): Field {")
    out.append("        for (i in mesgs.indices) {")
    out.append("            if (mesgs[i].num == mesgNum) {")
    out.append("                return Field(mesgs[i].getField(fieldNum))")
    out.append("            }")
    out.append("        }")
    out.append("        return Field(\"unknown\", fieldNum, 0, 1.0, 0.0, \"\", false, Profile.Type.ENUM)")
    out.append("    }")
    out.append("")
    out.append("    fun createField(mesgNum: Int, fieldName: String?): Field {")
    out.append("        for (i in mesgs.indices) {")
    out.append("            if (mesgs[i].num == mesgNum) {")
    out.append("                return Field(mesgs[i].getField(fieldName, false))")
    out.append("            }")
    out.append("        }")
    out.append("        return Field(fieldName ?: \"unknown\", Fit.FIELD_NUM_INVALID, 0, 1.0, 0.0, \"\", false, Profile.Type.ENUM)")
    out.append("    }")
    out.append("")
    out.append("    fun createField(mesgName: String?, fieldName: String?, values: ArrayList<Any?>): Field {")
    out.append("        val field = createField(mesgName, fieldName)")
    out.append("        field.values = values")
    out.append("        return field")
    out.append("    }")
    out.append("")
    out.append("    private val mesgs: Array<Mesg> = arrayOf(")
    for i, ref in enumerate(refs):
        comma = "," if i < len(refs) - 1 else ","
        out.append(f"        {ref}{comma}")
    out.append("    )")
    out.append("}")
    out.append("")
    return "\n".join(out)


# ---------------------------------------------------------------------------
# FitMessages.java
# ---------------------------------------------------------------------------

def _convert_fit_messages(src: str, java_name: str) -> str:
    fields = re.findall(r"final List<(\w+)> (\w+) = new ArrayList<>\(\);", src)
    if not fields:
        _fail(java_name, None, "no message list fields found")
    getters = re.findall(
        r"public List<(\w+)> (get\w+)\(\) \{\s*return Collections\.unmodifiableList\((\w+)\);\s*\}", src
    )
    if len(getters) != len(fields):
        _fail(java_name, None, f"{len(fields)} fields but {len(getters)} getters recognized")
    by_field = {name: (cls, getter) for cls, getter, name in getters}
    if set(by_field) != {name for _, name in fields}:
        _fail(java_name, None, "getter/field name mismatch")

    out: list[str] = [_header(java_name, _sdk_version(src)), ""]
    out.append("class FitMessages {")
    out.append("")
    # Le backing est interne (le décodeur y ajoute), l'accès public est une propriété
    # `List` en lecture seule : `messages.recordMesgs`. Une propriété *et* un
    # `getRecordMesgs()` entreraient en collision de signature sur JVM, donc la
    # propriété remplace le getter (DESIGN.md §3.bis).
    for cls, name in fields:
        out.append(f"    internal val _{name} = ArrayList<{cls}>()")
    out.append("")
    for cls, name in fields:
        gcls, getter = by_field[name]
        if gcls != cls:
            _fail(java_name, None, f"getter for {name} returns List<{gcls}> but field is List<{cls}>")
        out.append(f"    val {name}: List<{cls}> get() = _{name}")
        out.append("")
    while out[-1] == "":
        out.pop()
    out.append("}")
    out.append("")
    return "\n".join(out)


# ---------------------------------------------------------------------------
# FitListener.java
# ---------------------------------------------------------------------------

def _convert_fit_listener(src: str, java_name: str) -> str:
    _require(
        src,
        java_name,
        r"public class FitListener implements MesgListener, DeveloperFieldDescriptionListener \{",
        "class declaration",
    )
    m = _require(src, java_name, r"public void onMesg\(Mesg mesg\) \{", "onMesg(Mesg)")
    body, _ = _block(src, java_name, src.index("{", m.start()))
    cases = re.findall(
        r"case MesgNum\.(\w+):\s*fitMessages\.(\w+)\.add\(new (\w+)\(mesg\)\);\s*break;", body
    )
    n_cases = len(re.findall(r"case MesgNum\.\w+:", body))
    if not cases or len(cases) != n_cases:
        _fail(java_name, None, f"onMesg: parsed {len(cases)} branches for {n_cases} cases")
    _require(
        src,
        java_name,
        r"public void onDescription\(DeveloperFieldDescription desc\) \{\s*"
        r"fitMessages\.developerFieldDescriptionMesgs\.add\(desc\);\s*\}",
        "onDescription(DeveloperFieldDescription)",
    )

    out: list[str] = [_header(java_name, _sdk_version(src)), ""]
    out.append("import kotlin.jvm.JvmName")
    out.append("")
    out.append("open class FitListener : MesgListener, DeveloperFieldDescriptionListener {")
    out.append("")
    # @get:JvmName : évite le clash de signature JVM entre l'accesseur implicite de la
    # propriété protected et la méthode Java getFitMessages() conservée.
    out.append("    @get:JvmName(\"fitMessagesProtected\")")
    out.append("    protected val fitMessages = FitMessages()")
    out.append("")
    out.append("    fun getFitMessages(): FitMessages {")
    out.append("        return fitMessages")
    out.append("    }")
    out.append("")
    out.append("    override fun onMesg(mesg: Mesg) {")
    out.append("        when (mesg.getNum()) {")
    for num, listName, cls in cases:
        out.append(f"            MesgNum.{num} -> fitMessages._{listName}.add({cls}(mesg))")
    out.append("            else -> {}")
    out.append("        }")
    out.append("    }")
    out.append("")
    out.append("    override fun onDescription(desc: DeveloperFieldDescription) {")
    out.append("        fitMessages._developerFieldDescriptionMesgs.add(desc)")
    out.append("    }")
    out.append("}")
    out.append("")
    return "\n".join(out)


# ---------------------------------------------------------------------------
# MesgBroadcaster.java
# ---------------------------------------------------------------------------

def _convert_mesg_broadcaster(src: str, java_name: str) -> str:
    _require(
        src,
        java_name,
        r"public class MesgBroadcaster implements MesgListener, MesgDefinitionListener, MesgSource \{",
        "class declaration",
    )
    for pat, what in [
        (r"private final Decode decode;", "field decode"),
        (r"private final MesgWithEventBroadcaster mesgWithEventBroadcaster;", "field mesgWithEventBroadcaster"),
        (r"private final BufferedRecordMesgBroadcaster bufferedRecordMesgBroadcaster;", "field bufferedRecordMesgBroadcaster"),
        (r"public MesgBroadcaster\(\) \{\s*this\(new Decode\(\)\);\s*\}", "default constructor"),
        (r"public MesgBroadcaster\(Decode decode\) \{", "constructor (Decode)"),
        (r"public void setSystemTimeOffset\(long offset\) \{\s*decode\.setSystemTimeOffset\(offset\);\s*\}", "setSystemTimeOffset"),
        (
            r"public void run\(final InputStream in\) \{\s*try \{\s*"
            r"while \(decode\.bytesAvailable\(in\)\) \{.*?decode\.read\(in, this\);.*?decode\.nextFile\(\);.*?\}\s*"
            r"\} catch \(java\.io\.IOException e\) \{\s*\}\s*\}",
            "run(InputStream)",
        ),
        (
            r"public void onMesgDefinition\(final MesgDefinition mesgDefn\) \{\s*"
            r"for \(final MesgDefinitionListener mesgDefinitionListener : mesgDefinitionListeners\) \{\s*"
            r"mesgDefinitionListener\.onMesgDefinition\(mesgDefn\);\s*\}\s*\}",
            "onMesgDefinition",
        ),
    ]:
        if re.search(pat, src, re.S) is None:
            _fail(java_name, None, f"expected construct not found: {what}")

    # Listener list fields, in declaration order.
    list_fields = re.findall(r"private final List<(\w+)> (\w+);", src)
    if not list_fields:
        _fail(java_name, None, "no List<...> listener fields found")
    inits = set(re.findall(r"(\w+) = new ArrayList<\w+>\(\);", src))
    for _, name in list_fields:
        if name not in inits:
            _fail(java_name, None, f"field {name} not initialized in constructor")

    # addListener/removeListener methods, in order.
    methods = re.findall(
        r"(@Override\s+)?public void (addListener|removeListener)\((\w+) (\w+)\) \{\s*([^\n{}]+?);\s*\}",
        src,
    )
    n_decl = len(re.findall(r"public void (?:addListener|removeListener)\(", src))
    if len(methods) != n_decl:
        _fail(java_name, None, f"parsed {len(methods)} add/removeListener methods of {n_decl} declared")
    kmethods: list[str] = []
    for override_ann, mname, ptype, pname, stmt in methods:
        stmt = stmt.strip()
        if not re.match(r"^\w+\.(add|remove|addListener|removeListener)\(\w+\)$", stmt):
            _fail(java_name, None, f"{mname}({ptype}): unrecognized body: {stmt!r}")
        # MesgSource declares addListener(MesgListener) => override in Kotlin.
        is_override = bool(override_ann) or (mname == "addListener" and ptype == "MesgListener")
        kw = "override fun" if is_override else "fun"
        kmethods.append(f"    {kw} {mname}({pname}: {ptype}) {{\n        {stmt}\n    }}\n")

    # onMesg dispatch.
    m = _require(src, java_name, r"public void onMesg\(final Mesg mesg\) \{", "onMesg(Mesg)")
    body, _ = _block(src, java_name, src.index("{", m.start()))
    if re.search(
        r"for \(final MesgListener mesgListener : mesgListeners\) \{\s*mesgListener\.onMesg\(mesg\);\s*\}",
        body,
    ) is None:
        _fail(java_name, None, "onMesg: generic MesgListener loop not found")
    case_re = re.compile(
        r"case MesgNum\.(\w+):\s*"
        r"if \((\w+)\.size\(\) == 0\) \{\s*break;\s*\}\s*"
        r"final (\w+) (\w+) = new (\w+)\(mesg\);\s*"
        r"for \(final (\w+) mesgListener : (\w+)\) \{\s*mesgListener\.onMesg\((\w+)\);\s*\}\s*"
        r"(?:(\w+)\.onMesg\((\w+)\);\s*)?break;"
    )
    cases = case_re.findall(body)
    n_cases = len(re.findall(r"case MesgNum\.\w+:", body))
    if not cases or len(cases) != n_cases:
        _fail(java_name, None, f"onMesg: parsed {len(cases)} branches for {n_cases} cases")
    for num, guard_list, cls, var, cls2, _ltype, loop_list, loop_var, bcaster, bvar in cases:
        if cls != cls2 or var != loop_var or guard_list != loop_list or (bcaster and bvar != var):
            _fail(java_name, None, f"onMesg case MesgNum.{num}: inconsistent branch")
        if bcaster and bcaster not in ("mesgWithEventBroadcaster", "bufferedRecordMesgBroadcaster"):
            _fail(java_name, None, f"onMesg case MesgNum.{num}: unexpected broadcaster {bcaster!r}")

    version = _sdk_version(src)
    out: list[str] = [_header(java_name, version), ""]
    out.append("open class MesgBroadcaster(private val decode: Decode) : MesgListener, MesgDefinitionListener, MesgSource {")
    out.append("    private val mesgWithEventBroadcaster = MesgWithEventBroadcaster()")
    out.append("    private val bufferedRecordMesgBroadcaster = BufferedRecordMesgBroadcaster()")
    for cls, name in list_fields:
        out.append(f"    private val {name} = ArrayList<{cls}>()")
    out.append("")
    out.append("    constructor() : this(Decode())")
    out.append("")
    out.append("    fun setSystemTimeOffset(offset: Long) {")
    out.append("        decode.setSystemTimeOffset(offset)")
    out.append("    }")
    out.append("")
    out.append("    fun run(`in`: InputStream) {")
    out.append("        try {")
    out.append("            while (decode.bytesAvailable(`in`)) { // Try to read a file while more data is available.")
    out.append("                decode.read(`in`, this) // Run decoder.")
    out.append("                decode.nextFile() // Initialize to read next file (if any).")
    out.append("            }")
    out.append("        } catch (e: IOException) {")
    out.append("        }")
    out.append("    }")
    out.append("")
    for km in kmethods:
        out.append(km)
    out.append("    override fun onMesg(mesg: Mesg) {")
    out.append("        for (mesgListener in mesgListeners) {")
    out.append("            mesgListener.onMesg(mesg)")
    out.append("        }")
    out.append("")
    out.append("        when (mesg.getNum()) {")
    for num, guard_list, cls, var, _cls2, _ltype, _loop_list, _loop_var, bcaster, _bvar in cases:
        out.append(f"            MesgNum.{num} -> {{")
        out.append(f"                if ({guard_list}.size == 0) {{")
        out.append("                    return")
        out.append("                }")
        out.append(f"                val {var} = {cls}(mesg)")
        out.append(f"                for (mesgListener in {guard_list}) {{")
        out.append(f"                    mesgListener.onMesg({var})")
        out.append("                }")
        if bcaster:
            out.append(f"                {bcaster}.onMesg({var})")
        out.append("            }")
    out.append("            else -> {}")
    out.append("        }")
    out.append("    }")
    out.append("")
    out.append("    override fun onMesgDefinition(mesgDefn: MesgDefinition) {")
    out.append("        for (mesgDefinitionListener in mesgDefinitionListeners) {")
    out.append("            mesgDefinitionListener.onMesgDefinition(mesgDefn)")
    out.append("        }")
    out.append("    }")
    out.append("}")
    out.append("")
    return "\n".join(out)


# ---------------------------------------------------------------------------
# Entry point
# ---------------------------------------------------------------------------

_CONVERTERS = {
    "Profile.java": _convert_profile,
    "Factory.java": _convert_factory,
    "FitMessages.java": _convert_fit_messages,
    "FitListener.java": _convert_fit_listener,
    "MesgBroadcaster.java": _convert_mesg_broadcaster,
}


def convert(files: list[Path], out_dir: Path) -> list[Path]:
    out_dir = Path(out_dir)
    out_dir.mkdir(parents=True, exist_ok=True)
    written: list[Path] = []
    for f in files:
        f = Path(f)
        conv = _CONVERTERS.get(f.name)
        if conv is None:
            raise ConversionError(f"conv_profile.py: unexpected file {f} (not one of {sorted(_CONVERTERS)})")
        src = f.read_text(encoding="utf-8")
        kt = conv(src, f.name)
        # Sanity: balanced braces in generated Kotlin.
        if kt.count("{") != kt.count("}"):
            raise ConversionError(f"{f.name}: generated Kotlin has unbalanced braces")
        out_path = out_dir / (f.stem + ".kt")
        out_path.write_text(kt, encoding="utf-8")
        written.append(out_path)
    return written


if __name__ == "__main__":
    src_dir = Path(sys.argv[1]) if len(sys.argv) > 1 else Path("src/main/java/com/garmin/fit")
    out = Path(sys.argv[2]) if len(sys.argv) > 2 else Path("fit-kmp/src/commonMain/kotlin/com/garmin/fit")
    targets = [src_dir / n for n in _CONVERTERS]
    for p in convert(targets, out):
        print(p)
