#!/usr/bin/env python3
"""conv_mesgs.py — conversion des ~124 classes `extends Mesg` du SDK FIT Java
vers Kotlin Multiplatform (voir converter/DESIGN.md §6.4).

Contrat (imposé par convert.py) :

    def convert(files: list[Path], out_dir: Path) -> list[Path]

Le module est volontairement 100 % « pattern-driven » : chaque construction Java
rencontrée doit correspondre à un patron connu, sinon `ConversionError` est levée
avec fichier + ligne. Aucune conversion silencieusement approximative.
"""

from __future__ import annotations

import re
import sys
from pathlib import Path

SDK_VERSION = "21.205.0"


class ConversionError(Exception):
    """Construction Java non reconnue : le script doit échouer bruyamment."""


# ---------------------------------------------------------------------------
# Utilitaires généraux
# ---------------------------------------------------------------------------

def _line_of(src: str, pos: int) -> int:
    return src.count("\n", 0, pos) + 1


def _where(path: Path, src: str, pos: int) -> str:
    return f"{path.name}:{_line_of(src, pos)}"


def _match_brace(src: str, open_idx: int, path: Path) -> int:
    """Retourne l'index de l'accolade fermante appariée à src[open_idx] == '{'."""
    if src[open_idx] != "{":
        raise ConversionError(f"{_where(path, src, open_idx)}: '{{' attendu")
    depth = 0
    i = open_idx
    n = len(src)
    while i < n:
        c = src[i]
        if c == '"':
            i += 1
            while i < n and src[i] != '"':
                i += 2 if src[i] == "\\" else 1
        elif c == "'":
            i += 1
            while i < n and src[i] != "'":
                i += 2 if src[i] == "\\" else 1
        elif c == "/" and i + 1 < n and src[i + 1] == "*":
            i = src.index("*/", i) + 1
        elif c == "/" and i + 1 < n and src[i + 1] == "/":
            i = src.index("\n", i)
        elif c == "{":
            depth += 1
        elif c == "}":
            depth -= 1
            if depth == 0:
                return i
        i += 1
    raise ConversionError(f"{_where(path, src, open_idx)}: accolade non fermée")


def _split_args(text: str) -> list[str]:
    """Découpe une liste d'arguments au niveau parenthèse 0 (chaînes respectées)."""
    args: list[str] = []
    cur = ""
    depth = 0
    i = 0
    n = len(text)
    while i < n:
        c = text[i]
        if c == '"':
            cur += c
            i += 1
            while i < n and text[i] != '"':
                if text[i] == "\\":
                    cur += text[i]
                    i += 1
                cur += text[i]
                i += 1
            cur += '"'
        elif c in "([":
            depth += 1
            cur += c
        elif c in ")]":
            depth -= 1
            cur += c
        elif c == "," and depth == 0:
            args.append(cur.strip())
            cur = ""
        else:
            cur += c
        i += 1
    if cur.strip() or args:
        args.append(cur.strip())
    return args


_INT_RE = re.compile(r"^-?\d+$")
_DEC_RE = re.compile(r"^-?\d+\.\d+([eE][-+]?\d+)?$")


def _to_double_literal(arg: str, ctx: str) -> str:
    """Élargissement int->double explicite (DESIGN §1.3)."""
    if _INT_RE.match(arg):
        return arg + ".0"
    if _DEC_RE.match(arg):
        return arg
    raise ConversionError(
        f"{ctx}: littéral numérique attendu en position scale/offset, trouvé « {arg} »"
    )


def _to_long_literal(arg: str, ctx: str) -> str:
    if _INT_RE.match(arg):
        return arg + "L"
    raise ConversionError(f"{ctx}: littéral entier attendu, trouvé « {arg} »")


# ---------------------------------------------------------------------------
# Mapping de types (DESIGN §1.1 / §1.2)
# ---------------------------------------------------------------------------

_PRIMITIVES = {
    "int": "Int",
    "short": "Short",
    "long": "Long",
    "byte": "Byte",
    "float": "Float",
    "double": "Double",
    "boolean": "Boolean",
    "char": "Char",
}

_BOXED = {
    "Byte": "Byte",
    "Short": "Short",
    "Integer": "Int",
    "Long": "Long",
    "Float": "Float",
    "Double": "Double",
    "Boolean": "Boolean",
    "String": "String",
    "Object": "Any",
}


def _map_type(java_type: str, ctx: str) -> str:
    """Type Java -> type Kotlin (nullable si boxed / référence)."""
    jt = java_type.strip()
    if jt == "void":
        return "Unit"
    if jt.endswith("[]"):
        base = jt[:-2].strip()
        if base in _BOXED:
            return f"Array<{_BOXED[base]}?>"
        if base in _PRIMITIVES:
            raise ConversionError(
                f"{ctx}: tableau primitif « {jt} » inattendu dans un Mesg généré"
            )
        # tableau d'enums du profil : getByValue/fromValue ne rend jamais null
        return f"Array<{base}>"
    if jt in _PRIMITIVES:
        return _PRIMITIVES[jt]
    if jt in _BOXED:
        return _BOXED[jt] + "?"
    if not re.fullmatch(r"[A-Z]\w*", jt):
        raise ConversionError(f"{ctx}: type Java non supporté « {jt} »")
    # DateTime, LocalDateTime, enums du profil...
    return jt + "?"


def _parse_params(params: str, ctx: str) -> list[tuple[str, str, str]]:
    """« final Mesg mesg, int index » -> [(nom, typeJava, typeKotlin), ...]"""
    out: list[tuple[str, str, str]] = []
    if not params.strip():
        return out
    for raw in _split_args(params):
        p = raw.replace("final ", "").strip()
        m = re.fullmatch(r"([\w.\[\]]+)\s+(\w+)", p)
        if not m:
            raise ConversionError(f"{ctx}: paramètre non reconnu « {raw} »")
        out.append((m.group(2), m.group(1), _map_type(m.group(1), ctx)))
    return out


# ---------------------------------------------------------------------------
# Bloc statique : traduction ligne à ligne (DESIGN §6.4 règle 1)
# ---------------------------------------------------------------------------

_ST_DECL_INT = re.compile(r"^int (\w+) = (-?\d+);$")
_ST_ASSIGN_INT = re.compile(r"^(\w+) = (-?\d+);$")
_ST_INCR = re.compile(r"^(\w+)\+\+;$")
_ST_NEW_MESG = re.compile(r'^(\w+) = new Mesg\((".*?"), (MesgNum\.\w+)\);$')
_ST_ADD_FIELD = re.compile(r"^(\w+)\.addField\(new Field\((.*)\)\);$")
_ST_ADD_SUBFIELD = re.compile(
    r"^(\w+)\.fields\.get\((\w+)\)\.subFields\.add\(new SubField\((.*)\)\);$"
)
_ST_ADD_MAP = re.compile(
    r"^(\w+)\.fields\.get\((\w+)\)\.subFields\.get\((\w+)\)\.addMap\((.*)\);$"
)
_ST_ADD_COMPONENT = re.compile(
    r"^(\w+)\.fields\.get\((\w+)\)\.components\.add\(new FieldComponent\((.*)\)\);$"
)
_ST_ADD_SUB_COMPONENT = re.compile(
    r"^(\w+)\.fields\.get\((\w+)\)\.subFields\.get\((\w+)\)"
    r"\.addComponent\(new FieldComponent\((.*)\)\);$"
)

# positions (0-based) des arguments déclarés `double` dans les constructeurs cibles
_DOUBLE_POSITIONS = {
    "Field": (3, 4),        # Field(name, num, type, scale, offset, units, accum, profileType)
    "SubField": (2, 3),     # SubField(name, type, scale, offset, units)
    "FieldComponent": (3, 4),  # FieldComponent(fieldNum, accumulate, bits, scale, offset)
}
_ARITY = {"Field": 8, "SubField": 5, "FieldComponent": 5}


def _ctor_args(kind: str, raw: str, ctx: str) -> str:
    args = _split_args(raw)
    if len(args) != _ARITY[kind]:
        raise ConversionError(
            f"{ctx}: {kind}(...) attendu avec {_ARITY[kind]} arguments, {len(args)} trouvés"
        )
    for pos in _DOUBLE_POSITIONS[kind]:
        args[pos] = _to_double_literal(args[pos], ctx)
    return ", ".join(args)


def _convert_static_block(block: str, mesg_var: str, path: Path, base_line: int) -> list[str]:
    """Traduit le corps du bloc `static { ... }` en instructions Kotlin."""
    out: list[str] = []
    declared: set[str] = set()
    seen_mesg_ctor = False
    # `static {int field_index = 0;` : la 1re instruction peut être collée
    for offset, raw_line in enumerate(block.split("\n")):
        line = raw_line.strip()
        if not line:
            continue
        ctx = f"{path.name}:{base_line + offset}"

        # commentaire de fin de ligne conservé
        trailing = ""
        code = line
        cpos = _comment_pos(line)
        if cpos is not None:
            trailing = " " + line[cpos:].strip()
            code = line[:cpos].strip()
        if not code:
            out.append(trailing.strip())
            continue

        m = _ST_DECL_INT.match(code)
        if m:
            declared.add(m.group(1))
            out.append(f"var {m.group(1)} = {m.group(2)}" + trailing)
            continue

        m = _ST_ASSIGN_INT.match(code)
        if m:
            if m.group(1) not in declared:
                raise ConversionError(f"{ctx}: affectation de « {m.group(1)} » non déclaré")
            out.append(f"{m.group(1)} = {m.group(2)}" + trailing)
            continue

        m = _ST_INCR.match(code)
        if m:
            if m.group(1) not in declared:
                raise ConversionError(f"{ctx}: incrément de « {m.group(1)} » non déclaré")
            out.append(f"{m.group(1)}++" + trailing)
            continue

        m = _ST_NEW_MESG.match(code)
        if m:
            if m.group(1) != mesg_var:
                raise ConversionError(
                    f"{ctx}: initialisation de « {m.group(1)} » au lieu de « {mesg_var} »"
                )
            seen_mesg_ctor = True
            out.append(f"val {mesg_var} = Mesg({m.group(2)}, {m.group(3)})" + trailing)
            continue

        m = _ST_ADD_FIELD.match(code)
        if m:
            _check_var(m.group(1), mesg_var, ctx)
            out.append(
                f"{mesg_var}.addField(Field({_ctor_args('Field', m.group(2), ctx)}))" + trailing
            )
            continue

        m = _ST_ADD_SUBFIELD.match(code)
        if m:
            _check_var(m.group(1), mesg_var, ctx)
            args = _ctor_args("SubField", m.group(3), ctx)
            out.append(
                f"{mesg_var}.fields[{m.group(2)}].subFields.add(SubField({args}))" + trailing
            )
            continue

        m = _ST_ADD_MAP.match(code)
        if m:
            _check_var(m.group(1), mesg_var, ctx)
            map_args = _split_args(m.group(4))
            if len(map_args) != 2:
                raise ConversionError(f"{ctx}: addMap(...) attend 2 arguments")
            map_args[1] = _to_long_literal(map_args[1], ctx)
            out.append(
                f"{mesg_var}.fields[{m.group(2)}].subFields[{m.group(3)}]"
                f".addMap({', '.join(map_args)})" + trailing
            )
            continue

        m = _ST_ADD_COMPONENT.match(code)
        if m:
            _check_var(m.group(1), mesg_var, ctx)
            args = _ctor_args("FieldComponent", m.group(3), ctx)
            out.append(
                f"{mesg_var}.fields[{m.group(2)}].components.add(FieldComponent({args}))" + trailing
            )
            continue

        m = _ST_ADD_SUB_COMPONENT.match(code)
        if m:
            _check_var(m.group(1), mesg_var, ctx)
            args = _ctor_args("FieldComponent", m.group(4), ctx)
            out.append(
                f"{mesg_var}.fields[{m.group(2)}].subFields[{m.group(3)}]"
                f".addComponent(FieldComponent({args}))" + trailing
            )
            continue

        raise ConversionError(f"{ctx}: instruction de bloc statique non reconnue : « {code} »")

    if not seen_mesg_ctor:
        raise ConversionError(
            f"{path.name}: bloc statique sans « {mesg_var} = new Mesg(...) »"
        )
    out.append(mesg_var)
    return out


def _check_var(found: str, expected: str, ctx: str) -> None:
    if found != expected:
        raise ConversionError(f"{ctx}: variable « {found} » inattendue (attendu « {expected} »)")


def _comment_pos(line: str) -> int | None:
    """Position d'un `//` hors chaîne, ou None."""
    i = 0
    n = len(line)
    while i < n:
        c = line[i]
        if c == '"':
            i += 1
            while i < n and line[i] != '"':
                i += 2 if line[i] == "\\" else 1
        elif c == "/" and i + 1 < n and line[i + 1] == "/":
            return i
        i += 1
    return None


# ---------------------------------------------------------------------------
# Accesseurs : table de patrons (DESIGN §6.4 règle 3)
# ---------------------------------------------------------------------------

_SCALAR_GET = re.compile(
    r"^return (getField(?:Byte|Short|Integer|Long|Float|Double|String|ULong)Value)\((.*)\);$"
)
_ARRAY_GET = re.compile(
    r"^return (getField(?:Byte|Short|Integer|Long|Float|Double|String|ULong)Values)\((.*)\);$"
)
_NUM_GET = re.compile(r"^return getNumFieldValues\((.*)\);$")
_DATETIME_GET = re.compile(r"^return timestampToDateTime\((getFieldLongValue\(.*\))\);$")
_SET = re.compile(r"^setFieldValue\((.*)\);$")
_ENUM_GET = re.compile(
    r"^Short value = (getFieldShortValue\(.*?\)); "
    r"if \(value == null\) \{ return null; \} "
    r"return (\w+)\.getByValue\(value\);$"
)
_ENUM_ARRAY_GET = re.compile(
    r"^Short\[\] values = (getFieldShortValues\(.*?\)); "
    r"(\w+)\[\] (\w+) = new \2\[values\.length\]; "
    r"for\(int i = 0; i < values\.length; i\+\+\)\s*\{ "
    r"\3\[i\] = \2\.getByValue\(values\[i\]\); \} "
    r"return \3;$"
)


def _normalize_body(body: str) -> str:
    return re.sub(r"\s+", " ", body).strip()


def _convert_setter_value(expr: str, params: list[tuple[str, str, str]], ctx: str) -> str:
    """3e argument de setFieldValue : valeur brute, enum ou DateTime."""
    names = {p[0] for p in params}
    m = re.fullmatch(r"(\w+)", expr)
    if m and m.group(1) in names:
        return m.group(1)
    m = re.fullmatch(r"(\w+)\.value", expr)
    if m and m.group(1) in names:
        return f"{m.group(1)}?.value"
    m = re.fullmatch(r"(\w+)\.getValue\(\)", expr)
    if m and m.group(1) in names:
        return f"{m.group(1)}?.value"
    m = re.fullmatch(r"(\w+)\.getTimestamp\(\)", expr)
    if m and m.group(1) in names:
        return f"{m.group(1)}?.getTimestamp()"
    raise ConversionError(f"{ctx}: valeur de setFieldValue non reconnue : « {expr} »")


def _convert_method(
    ret_java: str,
    name: str,
    params: list[tuple[str, str, str]],
    body: str,
    ctx: str,
    is_override: bool,
) -> list[str]:
    nb = _normalize_body(body)
    kparams = ", ".join(f"{p[0]}: {p[2]}" for p in params)
    prefix = "override fun" if is_override else "fun"

    def sig(ret_kt: str | None) -> str:
        if ret_kt is None:
            return f"{prefix} {name}({kparams}) {{"
        return f"{prefix} {name}({kparams}): {ret_kt} {{"

    # --- getters scalaires ------------------------------------------------
    m = _SCALAR_GET.match(nb)
    if m:
        return [sig(_map_type(ret_java, ctx)), f"    return {m.group(1)}({m.group(2)})", "}"]

    # --- getters tableau --------------------------------------------------
    m = _ARRAY_GET.match(nb)
    if m:
        # Mesg.getFieldTValues retourne null si le champ est absent (comme en Java).
        return [sig(_map_type(ret_java, ctx) + "?"), f"    return {m.group(1)}({m.group(2)})", "}"]

    # --- getNumXxx --------------------------------------------------------
    m = _NUM_GET.match(nb)
    if m:
        if ret_java != "int":
            raise ConversionError(f"{ctx}: getNumFieldValues doit retourner int")
        return [sig("Int"), f"    return getNumFieldValues({m.group(1)})", "}"]

    # --- getter DateTime --------------------------------------------------
    m = _DATETIME_GET.match(nb)
    if m:
        if ret_java != "DateTime":
            raise ConversionError(f"{ctx}: timestampToDateTime doit retourner DateTime")
        return [sig("DateTime?"), f"    return timestampToDateTime({m.group(1)})", "}"]

    # --- getter enum ------------------------------------------------------
    m = _ENUM_GET.match(nb)
    if m:
        if ret_java != m.group(2):
            raise ConversionError(
                f"{ctx}: getByValue sur « {m.group(2)} » mais retour « {ret_java} »"
            )
        return [
            sig(ret_java + "?"),
            f"    val value = {m.group(1)} ?: return null",
            f"    return {m.group(2)}.fromValue(value)",
            "}",
        ]

    # --- getter tableau d'enums -------------------------------------------
    m = _ENUM_ARRAY_GET.match(nb)
    if m:
        if ret_java != m.group(2) + "[]":
            raise ConversionError(
                f"{ctx}: tableau d'enums « {m.group(2)} » mais retour « {ret_java} »"
            )
        return [
            sig(f"Array<{m.group(2)}>"),
            # !! : le Java lève une NPE si le champ est absent (values.length) — comportement conservé.
            f"    val values = {m.group(1)}!!",
            f"    return Array(values.size) {{ i -> {m.group(2)}.fromValue(values[i]) }}",
            "}",
        ]

    # --- setters ----------------------------------------------------------
    m = _SET.match(nb)
    if m:
        if ret_java != "void":
            raise ConversionError(f"{ctx}: setFieldValue dans une méthode non-void")
        args = _split_args(m.group(1))
        if len(args) != 4:
            raise ConversionError(f"{ctx}: setFieldValue attend 4 arguments")
        args[2] = _convert_setter_value(args[2], params, ctx)
        return [sig(None), f"    setFieldValue({', '.join(args)})", "}"]

    raise ConversionError(f"{ctx}: méthode « {name} » : corps non reconnu : « {nb[:160]} »")


# ---------------------------------------------------------------------------
# Interfaces implémentées
# ---------------------------------------------------------------------------

_MESG_WITH_EVENT_MEMBERS = {
    ("getTimestamp", 0),
    ("setTimestamp", 1),
    ("getEvent", 0),
    ("setEvent", 1),
    ("getEventType", 0),
    ("setEventType", 1),
    ("getEventGroup", 0),
    ("setEventGroup", 1),
}

_KNOWN_INTERFACES = {"MesgWithEvent": _MESG_WITH_EVENT_MEMBERS}


# ---------------------------------------------------------------------------
# Parsing d'un fichier
# ---------------------------------------------------------------------------

_RE_CLASS = re.compile(
    r"^public class (\w+) extends Mesg\s*(?:implements\s+([\w\s,]+?))?\s*\{", re.M
)
_RE_JAVADOC = re.compile(r"/\*\*.*?\*/", re.S)
_RE_BLOCKCOMMENT = re.compile(r"/\*.*?\*/", re.S)
_RE_LINECOMMENT = re.compile(r"//[^\n]*")
_RE_CONST = re.compile(r"public static final int (\w+) = (-?\d+|0[xX][0-9A-Fa-f]+);")
_RE_MESG_FIELD = re.compile(r"protected static final\s+Mesg (\w+);")
_RE_STATIC = re.compile(r"static\s*\{")
_RE_METHOD = re.compile(r"public\s+([\w.\[\]]+)\s+(\w+)\s*\(([^)]*)\)\s*\{")
_RE_CTOR = re.compile(r"public\s+(\w+)\s*\(([^)]*)\)\s*\{")
_RE_SUPER_FACTORY = re.compile(r"^super\(Factory\.createMesg\((MesgNum\.\w+)\)\);$")


def _convert_file(path: Path) -> tuple[str, str]:
    src = path.read_text(encoding="utf-8")
    cm = _RE_CLASS.search(src)
    if not cm:
        raise ConversionError(f"{path.name}: déclaration « public class X extends Mesg » absente")
    cls = cm.group(1)
    ifaces = [x.strip() for x in (cm.group(2) or "").split(",") if x.strip()]
    for iface in ifaces:
        if iface not in _KNOWN_INTERFACES:
            raise ConversionError(f"{path.name}: interface non supportée « {iface} »")
    override_members: set[tuple[str, int]] = set()
    for iface in ifaces:
        override_members |= _KNOWN_INTERFACES[iface]

    body_open = src.index("{", cm.start())
    body_close = _match_brace(src, body_open, path)

    consts: list[str] = []
    mesg_var: str | None = None
    static_lines: list[str] = []
    ctor_default: str | None = None
    ctor_copy = False
    members: list[list[str]] = []
    pending_doc: list[str] = []

    i = body_open + 1
    end = body_close
    while i < end:
        if src[i].isspace():
            i += 1
            continue

        m = _RE_JAVADOC.match(src, i)
        if m:
            doc = [ln.strip() for ln in m.group(0).split("\n")]
            pending_doc = [doc[0]] + [(" " + ln if ln else "") for ln in doc[1:]]
            i = m.end()
            continue
        m = _RE_BLOCKCOMMENT.match(src, i)
        if m:
            i = m.end()
            continue
        m = _RE_LINECOMMENT.match(src, i)
        if m:
            i = m.end()
            continue

        m = _RE_CONST.match(src, i)
        if m:
            consts.append(f"const val {m.group(1)} = {m.group(2)}")
            pending_doc = []
            i = m.end()
            continue

        m = _RE_MESG_FIELD.match(src, i)
        if m:
            if mesg_var is not None:
                raise ConversionError(f"{_where(path, src, i)}: second champ Mesg statique")
            mesg_var = m.group(1)
            pending_doc = []
            i = m.end()
            continue

        m = _RE_STATIC.match(src, i)
        if m:
            if mesg_var is None:
                raise ConversionError(f"{_where(path, src, i)}: bloc statique sans champ Mesg")
            open_idx = src.index("{", i)
            close_idx = _match_brace(src, open_idx, path)
            block = src[open_idx + 1 : close_idx]
            static_lines = _convert_static_block(
                block, mesg_var, path, _line_of(src, open_idx)
            )
            pending_doc = []
            i = close_idx + 1
            continue

        m = _RE_CTOR.match(src, i)
        if m and m.group(1) == cls:
            open_idx = src.index("{", m.end() - 1)
            close_idx = _match_brace(src, open_idx, path)
            cbody = _normalize_body(src[open_idx + 1 : close_idx])
            params = _parse_params(m.group(2), _where(path, src, i))
            if not params:
                sm = _RE_SUPER_FACTORY.match(cbody)
                if not sm:
                    raise ConversionError(
                        f"{_where(path, src, i)}: constructeur par défaut non reconnu : « {cbody} »"
                    )
                ctor_default = sm.group(1)
            elif len(params) == 1 and params[0][1] == "Mesg":
                if cbody != "super(mesg);":
                    raise ConversionError(
                        f"{_where(path, src, i)}: constructeur de copie non reconnu : « {cbody} »"
                    )
                ctor_copy = True
            else:
                raise ConversionError(
                    f"{_where(path, src, i)}: constructeur non supporté ({m.group(2)})"
                )
            pending_doc = []
            i = close_idx + 1
            continue

        m = _RE_METHOD.match(src, i)
        if m:
            open_idx = src.index("{", m.end() - 1)
            close_idx = _match_brace(src, open_idx, path)
            ctx = _where(path, src, i)
            params = _parse_params(m.group(3), ctx)
            is_override = (m.group(2), len(params)) in override_members
            # getName() redéfinit Mesg.getName() (open, retour String?) — cf. override Mesg.kt.
            if m.group(2) == "getName" and not params:
                is_override = True
            lines = _convert_method(
                m.group(1), m.group(2), params, src[open_idx + 1 : close_idx], ctx, is_override
            )
            members.append(pending_doc + lines)
            pending_doc = []
            i = close_idx + 1
            continue

        snippet = src[i : i + 90].split("\n")[0]
        raise ConversionError(
            f"{_where(path, src, i)}: membre de classe non reconnu : « {snippet} »"
        )

    if mesg_var is None or not static_lines:
        raise ConversionError(f"{path.name}: champ/bloc statique Mesg manquant")
    if ctor_default is None or not ctor_copy:
        raise ConversionError(f"{path.name}: les deux constructeurs attendus sont absents")

    return cls, _emit(path, cls, ifaces, consts, mesg_var, static_lines,
                      ctor_default, members)


# ---------------------------------------------------------------------------
# Émission du Kotlin
# ---------------------------------------------------------------------------

def _emit(
    path: Path,
    cls: str,
    ifaces: list[str],
    consts: list[str],
    mesg_var: str,
    static_lines: list[str],
    ctor_default: str,
    members: list[list[str]],
) -> str:
    supertypes = ", ".join(["Mesg"] + ifaces)
    out: list[str] = []
    bar = "/" * 93
    out.append(bar)
    out.append(
        f"// Converted from {path.name} (Garmin FIT SDK {SDK_VERSION}) by converter/convert.py."
    )
    out.append("// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.")
    out.append(bar)
    out.append("package com.garmin.fit")
    out.append("")
    out.append(f"open class {cls} : {supertypes} {{")
    out.append("")
    out.append("    companion object {")
    for c in consts:
        out.append(f"        {c}")
    if consts:
        out.append("")
    out.append(f"        val {mesg_var}: Mesg = run {{")
    for line in static_lines:
        out.append(f"            {line}" if line else "")
    out.append("        }")
    out.append("    }")
    out.append("")
    out.append(f"    constructor() : super(Factory.createMesg({ctor_default}))")
    out.append("")
    out.append("    constructor(mesg: Mesg?) : super(mesg)")
    for lines in members:
        out.append("")
        for line in lines:
            out.append(f"    {line}" if line else "")
    out.append("}")
    return "\n".join(out) + "\n"


# ---------------------------------------------------------------------------
# Point d'entrée du contrat
# ---------------------------------------------------------------------------

def convert(files, out_dir) -> list[Path]:
    out_dir = Path(out_dir)
    out_dir.mkdir(parents=True, exist_ok=True)
    written: list[Path] = []
    for f in sorted(Path(p) for p in files):
        cls, text = _convert_file(f)
        target = out_dir / f"{cls}.kt"
        target.write_text(text, encoding="utf-8")
        written.append(target)
    return written


if __name__ == "__main__":
    if len(sys.argv) < 3:
        print("usage: conv_mesgs.py <out_dir> <XxxMesg.java> ...", file=sys.stderr)
        raise SystemExit(2)
    res = convert([Path(p) for p in sys.argv[2:]], Path(sys.argv[1]))
    for p in res:
        print(p)
