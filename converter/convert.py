#!/usr/bin/env python3
"""
convert.py — Orchestrateur rejouable de la conversion du SDK FIT Java vers
Kotlin Multiplatform (voir DESIGN.md).

Usage :
    python3 converter/convert.py [--update-hashes]

Étapes :
  1. Classification des .java (classify.py).
  2. Génération des .kt via conv_enums / conv_constants / conv_listeners /
     conv_mesgs / conv_profile (imports tolérants : un module manquant est
     affiché en SKIP au lieu de faire planter le script).
  3. Nettoyage puis recréation de fit-kmp/src/commonMain/kotlin/io/github/glandais/fit.
     (src/commonTest/, écrit à la main, est préservé.)
  4. Copie des overrides (converter/overrides/commonMain) vers
     fit-kmp/src/.../io/github/glandais/fit, avec suivi de overrides/hashes.json
     (création si absent, WARNING si le .java source correspondant a changé).
  5. Création (si absents) de settings.gradle.kts / build.gradle.kts /
     gradle.properties.
  6. Récapitulatif des fichiers générés par catégorie.

NE PLANTE PAS si conv_*.py n'existe pas encore (développement en parallèle) :
affiche `SKIP: <module> introuvable, catégorie <x> non générée.`
"""

from __future__ import annotations

import hashlib
import importlib
import shutil
import sys
from pathlib import Path

REPO_ROOT = Path(__file__).resolve().parent.parent
CONVERTER_DIR = REPO_ROOT / "converter"
SRC_JAVA_DIR = REPO_ROOT / "src/main/java/com/garmin/fit"
FIT_KMP_DIR = REPO_ROOT / "fit-kmp"
OVERRIDES_DIR = CONVERTER_DIR / "overrides"
HASHES_JSON = OVERRIDES_DIR / "hashes.json"

COMMON_MAIN_OUT = FIT_KMP_DIR / "src/commonMain/kotlin/io/github/glandais/fit"

# category -> (module name, function name) : chaque module expose
# convert(files: list[Path], out_dir: Path) -> list[Path]
CONV_MODULES = {
    "enums": "conv_enums",
    "constants": "conv_constants",
    "listeners": "conv_listeners",
    "mesgs": "conv_mesgs",
    "profile": "conv_profile",
}

# ---------------------------------------------------------------------------
# Templates Gradle (créés uniquement si absents, DESIGN.md §5)
# ---------------------------------------------------------------------------

SETTINGS_GRADLE_KTS = """rootProject.name = "fit-kmp"
"""

BUILD_GRADLE_KTS = """plugins {
    kotlin("multiplatform") version "2.4.20-Beta2"
}

kotlin {
    jvmToolchain(21)
    jvm()

    js(IR) {
        nodejs()
        browser()
    }

    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmWasi {
        wasmtime()
    }

    sourceSets {
        commonMain {
            dependencies { /* aucune dépendance externe */ }
        }
        commonTest {
            dependencies { implementation(kotlin("test")) }
        }
    }
}
"""

GRADLE_PROPERTIES = """kotlin.code.style=official
org.gradle.jvmargs=-Xmx2g
"""


def ensure_gradle_project_files() -> None:
    FIT_KMP_DIR.mkdir(parents=True, exist_ok=True)

    settings = FIT_KMP_DIR / "settings.gradle.kts"
    if not settings.exists():
        settings.write_text(SETTINGS_GRADLE_KTS, encoding="utf-8")
        print(f"CREATED: {settings.relative_to(REPO_ROOT)}")

    build = FIT_KMP_DIR / "build.gradle.kts"
    if not build.exists():
        build.write_text(BUILD_GRADLE_KTS, encoding="utf-8")
        print(f"CREATED: {build.relative_to(REPO_ROOT)}")

    props = FIT_KMP_DIR / "gradle.properties"
    if not props.exists():
        props.write_text(GRADLE_PROPERTIES, encoding="utf-8")
        print(f"CREATED: {props.relative_to(REPO_ROOT)}")


def clean_generated_sources() -> None:
    """Supprime fit-kmp/src/commonMain/ puis recrée l'arborescence vide.

    Seul commonMain est régénéré. src/commonTest/ est écrit à la main et doit
    survivre au rejeu — c'est le seul garde-fou du port contre le SDK Java.
    """
    stale_jvm_main = FIT_KMP_DIR / "src/jvmMain"
    if stale_jvm_main.exists():
        shutil.rmtree(stale_jvm_main)
    common_main_dir = FIT_KMP_DIR / "src/commonMain"
    if common_main_dir.exists():
        shutil.rmtree(common_main_dir)
    COMMON_MAIN_OUT.mkdir(parents=True, exist_ok=True)
    (FIT_KMP_DIR / "src/commonTest/kotlin/io/github/glandais/fit").mkdir(parents=True, exist_ok=True)


def run_classification() -> dict[str, list[Path]]:
    sys.path.insert(0, str(CONVERTER_DIR))
    import classify  # type: ignore

    importlib.reload(classify)
    return classify.classify(SRC_JAVA_DIR)


def run_converters(cats: dict[str, list[Path]]) -> dict[str, list[Path]]:
    """Appelle chaque conv_*.py disponible ; SKIP si le module n'existe pas
    encore ou ne respecte pas le contrat attendu."""
    generated: dict[str, list[Path]] = {}

    for category, module_name in CONV_MODULES.items():
        files = cats.get(category, [])
        module_path = CONVERTER_DIR / f"{module_name}.py"
        if not module_path.exists():
            print(f"SKIP: {module_name}.py introuvable, catégorie '{category}' ({len(files)} fichiers) non générée.")
            generated[category] = []
            continue
        try:
            sys.path.insert(0, str(CONVERTER_DIR))
            mod = importlib.import_module(module_name)
            importlib.reload(mod)
            out = mod.convert(files, COMMON_MAIN_OUT)
            generated[category] = list(out) if out else []
        except Exception as exc:  # noqa: BLE001 - on veut un SKIP tolérant, pas un crash
            print(f"SKIP: {module_name}.py a échoué ({exc!r}), catégorie '{category}' non générée.")
            generated[category] = []

    return generated


def sha256_of(path: Path) -> str:
    return hashlib.sha256(path.read_bytes()).hexdigest()


def load_hashes() -> dict:
    if HASHES_JSON.exists():
        import json

        return json.loads(HASHES_JSON.read_text(encoding="utf-8"))
    return {}


def save_hashes(hashes: dict) -> None:
    import json

    HASHES_JSON.parent.mkdir(parents=True, exist_ok=True)
    HASHES_JSON.write_text(json.dumps(hashes, indent=2, sort_keys=True) + "\n", encoding="utf-8")


def copy_overrides(update_hashes: bool) -> tuple[list[Path], list[str]]:
    """Copie overrides/commonMain -> COMMON_MAIN_OUT.
    Gère overrides/hashes.json (création + WARNING sur drift).
    Retourne (fichiers copiés, warnings)."""
    hashes = load_hashes()
    warnings: list[str] = []
    copied: list[Path] = []

    source_sets = {
        "commonMain": (OVERRIDES_DIR / "commonMain", COMMON_MAIN_OUT),
    }

    for source_set, (override_dir, out_dir) in source_sets.items():
        if not override_dir.exists():
            continue
        out_dir.mkdir(parents=True, exist_ok=True)
        for kt_file in sorted(override_dir.glob("*.kt")):
            dest = out_dir / kt_file.name
            shutil.copy2(kt_file, dest)
            copied.append(dest)

            key = f"{source_set}/{kt_file.name}"
            entry = hashes.get(key)
            java_name = entry["source"] if entry else None

            # Si l'entrée n'existe pas encore, on suppose une correspondance
            # <NomFichier>.kt -> <NomFichier>.java si ce dernier existe.
            if entry is None:
                candidate = SRC_JAVA_DIR / (kt_file.stem + ".java")
                java_name = candidate.name if candidate.exists() else None

            if java_name is None:
                hashes[key] = {"source": None, "sha256": None}
                continue

            java_path = SRC_JAVA_DIR / java_name
            if not java_path.exists():
                warnings.append(f"override {key}: source déclarée {java_name} introuvable dans {SRC_JAVA_DIR}")
                continue

            current_hash = sha256_of(java_path)

            if entry is None or update_hashes:
                hashes[key] = {"source": java_name, "sha256": current_hash}
            else:
                stored_hash = entry.get("sha256")
                if stored_hash != current_hash:
                    warnings.append(
                        f"override {key}: {java_name} a changé, re-vérifier le port manuel "
                        f"(hash stocké {stored_hash} != actuel {current_hash})"
                    )

    save_hashes(hashes)
    return copied, warnings


def main() -> int:
    update_hashes = "--update-hashes" in sys.argv[1:]

    print("== 1. Classification ==")
    cats = run_classification()
    for k in ("enums", "constants", "listeners", "mesgs", "profile", "core"):
        print(f"  {k:10s}: {len(cats.get(k, []))}")

    print("\n== 2. Nettoyage fit-kmp/src/ ==")
    clean_generated_sources()

    print("\n== 3. Génération (conv_*.py) ==")
    generated = run_converters(cats)

    print("\n== 4. Copie des overrides ==")
    copied_overrides, warnings = copy_overrides(update_hashes)
    print(f"  {len(copied_overrides)} fichiers override copiés.")

    print("\n== 5. Fichiers projet Gradle ==")
    ensure_gradle_project_files()

    print("\n== Récapitulatif ==")
    total_generated = 0
    for category in ("enums", "constants", "listeners", "mesgs", "profile"):
        n = len(generated.get(category, []))
        total_generated += n
        print(f"  générés {category:10s}: {n:4d} (source: {len(cats.get(category, []))})")
    print(f"  overrides copiés     : {len(copied_overrides):4d}")
    print(f"  core non traité      : {len(cats.get('core', []))} (couverts par les overrides ci-dessus, en principe)")
    print(f"  TOTAL .kt produits  : {total_generated + len(copied_overrides)}")

    if warnings:
        print("\n== WARNINGS (overrides à re-vérifier) ==")
        for w in warnings:
            print(f"  WARNING: {w}")
    else:
        print("\nAucun drift détecté sur les overrides.")

    return 0


if __name__ == "__main__":
    raise SystemExit(main())
