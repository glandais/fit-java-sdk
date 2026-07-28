"""
classify.py — Classification des 495 fichiers .java du SDK FIT en catégories,
selon le contrat défini dans DESIGN.md.

Contrat :
    def classify(src_dir: Path) -> dict[str, list[Path]]
    Clés retournées : 'enums', 'constants', 'listeners', 'mesgs', 'profile', 'core'.

Règles (voir DESIGN.md §0 et §7) :
  - 'public enum' au niveau top-level uniquement (ancré en début de ligne) -> enums.
    (Corrige le bug de l'inventaire initial qui classait à tort Fit.java et
    Decode.java, à cause de leurs enums imbriqués ProtocolVersion/RETURN/STATE.)
  - Profile.java, Factory.java, FitMessages.java, FitListener.java,
    MesgBroadcaster.java -> profile (priorité la plus haute : ces noms sont
    vérifiés avant toute autre règle).
  - Classe top-level 'extends Mesg' (pas MesgXxx, pas RecordMesg...) -> mesgs.
  - Interface top-level avec exactement une méthode abstraite dont le nom
    commence par 'on' (pattern listener trivial) -> listeners.
  - Classe contenant 'getStringFromValue' (et non déjà classée ci-dessus) -> constants.
    (DateTime.java et LocalDateTime.java tombent ici, c'est voulu : c'est
    conv_constants.py qui doit ensuite les sauter, cf. DESIGN.md §0/§3.)
  - Tout le reste -> core.

Ordre d'application (important, cf. tests de non-régression dans DESIGN.md) :
    profile -> enums -> mesgs -> listeners -> constants -> core
"""

from __future__ import annotations

import re
from pathlib import Path

# Fichiers profil, classés en priorité avant toute autre règle.
PROFILE_FILES = {
    "Profile.java",
    "Factory.java",
    "FitMessages.java",
    "FitListener.java",
    "MesgBroadcaster.java",
}

# Ancré en début de ligne : ne matche que la déclaration top-level, pas les
# enums imbriqués (ex. Fit.ProtocolVersion, Decode.RETURN, Decode.STATE).
_ENUM_RE = re.compile(r"^public enum \w+", re.MULTILINE)

# Classe top-level qui étend directement Mesg (pas RecordMesg, pas MesgXxx...).
_MESG_RE = re.compile(r"\bclass\s+\w+\s+extends\s+Mesg\b")

# Interface top-level.
_INTERFACE_RE = re.compile(r"\bpublic interface\s+(\w+)\s*\{")

# Signature de méthode abstraite dans le corps d'une interface :
# capture uniquement le nom de la méthode.
_METHOD_RE = re.compile(r"(?:public\s+)?[\w<>\[\],\s]+?\s(\w+)\s*\([^)]*\)\s*;")


def _is_trivial_listener(text: str) -> bool:
    """True si `text` est une interface top-level avec exactement une méthode
    abstraite, dont le nom commence par 'on' (pattern listener, DESIGN.md §0)."""
    m = _INTERFACE_RE.search(text)
    if not m:
        return False
    body = text[m.end():]
    methods = [name for name in _METHOD_RE.findall(body) if name]
    return len(methods) == 1 and methods[0].startswith("on")


def classify(src_dir: Path) -> dict[str, list[Path]]:
    """Classe tous les .java de `src_dir` (non récursif) selon le contrat."""
    cats: dict[str, list[Path]] = {
        "enums": [],
        "constants": [],
        "listeners": [],
        "mesgs": [],
        "profile": [],
        "core": [],
    }

    for f in sorted(src_dir.glob("*.java")):
        text = f.read_text(encoding="utf-8")
        name = f.name

        if name in PROFILE_FILES:
            cats["profile"].append(f)
        elif _ENUM_RE.search(text):
            cats["enums"].append(f)
        elif _MESG_RE.search(text):
            cats["mesgs"].append(f)
        elif _is_trivial_listener(text):
            cats["listeners"].append(f)
        elif "getStringFromValue" in text:
            cats["constants"].append(f)
        else:
            cats["core"].append(f)

    return cats


def _main() -> None:
    src_dir = Path(__file__).resolve().parent.parent / "src/main/java/com/garmin/fit"
    cats = classify(src_dir)

    total = sum(len(v) for v in cats.values())
    all_files = {f for v in cats.values() for f in v}
    n_input = len(list(src_dir.glob("*.java")))

    print(f"Fichiers .java trouvés : {n_input}")
    for k in ("enums", "constants", "listeners", "mesgs", "profile", "core"):
        print(f"  {k:10s}: {len(cats[k])}")
    print(f"  {'total':10s}: {total}")

    if total != n_input or len(all_files) != n_input:
        raise SystemExit(
            f"ERREUR: classification incohérente (total={total}, "
            f"fichiers uniques={len(all_files)}, attendu={n_input})"
        )

    expected = {"enums": 102, "constants": 99, "listeners": 129, "mesgs": 124, "profile": 5, "core": 36}
    mismatches = {k: (len(cats[k]), expected[k]) for k in expected if len(cats[k]) != expected[k]}
    if mismatches:
        print(f"WARNING: comptes différents de l'inventaire de référence: {mismatches}")
    else:
        print("OK: comptes conformes à l'inventaire de référence (DESIGN.md).")


if __name__ == "__main__":
    _main()
