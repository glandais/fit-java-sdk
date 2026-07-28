# fit-kmp

Port Kotlin Multiplatform du [Garmin FIT Java SDK](https://developer.garmin.com/fit),
généré depuis les sources Java de ce dépôt par `converter/convert.py`.

Publié depuis ce fork sous `io.github.glandais` — le SDK Java upstream reste publié par
Garmin sous `com.garmin:fit`.

## Cibles

| Cible | Coordonnée |
|---|---|
| métadonnées KMP | `io.github.glandais:fit-kmp` |
| JVM | `io.github.glandais:fit-kmp-jvm` |
| Wasm/WASI | `io.github.glandais:fit-kmp-wasm-wasi` |

Aucune dépendance externe hors `kotlin-stdlib`.

## Utilisation

```kotlin
// build.gradle.kts d'un projet KMP
kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation("io.github.glandais:fit-kmp:21.205.0-kmp.1")
            }
        }
    }
}
```

Sur un projet JVM pur, `io.github.glandais:fit-kmp-jvm:<version>` fait l'affaire.

> La version porte un suffixe `-kmp.N` (`21.205.0-kmp.1` = port KMP n°1 du SDK Java
> 21.205.0). Maven et Gradle le traitent comme un *pre-release qualifier* : épinglez une
> version exacte, les plages dynamiques ne le sélectionneront pas.

## Développement

Build autonome : toutes les commandes se lancent depuis `fit-kmp/`.

```sh
./gradlew check              # compile et teste jvm + wasmWasi
./gradlew publishToMavenLocal # artefacts non signés dans ~/.m2
```

JDK 21+ requis pour lancer Gradle ; la compilation utilise le toolchain 21. Si votre JDK
par défaut ne convient pas, définissez `org.gradle.java.home` dans
`~/.gradle/gradle.properties` — **jamais** dans le `gradle.properties` du dépôt, cela
casserait la CI.

Les sources sous `src/commonMain` et `src/jvmMain` sont **régénérées intégralement** par
`python3 converter/convert.py` depuis la racine du dépôt : toute modification manuelle y
sera perdue. Les fichiers écrits à la main vivent dans `converter/overrides/`.

## Releasing

La publication est déclenchée par un tag `fit-kmp-v*` et effectuée par
`.github/workflows/fit-kmp-release.yml` (build, signature GPG, `publishAndReleaseToMavenCentral`,
puis création de la GitHub Release). Pas de semantic-release : la version est éditée à la main.

```sh
# 1. bump de la version
$EDITOR fit-kmp/gradle.properties      # version=21.205.0-kmp.2
git commit -am "fit-kmp 21.205.0-kmp.2"

# 2. tag (doit correspondre exactement à gradle.properties, le workflow le vérifie)
git tag fit-kmp-v21.205.0-kmp.2
git push origin main fit-kmp-v21.205.0-kmp.2
```

Secrets requis sur le dépôt GitHub : `CENTRAL_USERNAME`, `CENTRAL_TOKEN` (user token du
Sonatype Central Portal), `GPG_PRIVATE_KEY` (clé ASCII-armored) et `GPG_PASSPHRASE`.

`publishAndReleaseToMavenCentral` stage **et** release automatiquement : aucune validation
manuelle sur le Portal. L'artefact apparaît sur
[central.sonatype.com](https://central.sonatype.com/artifact/io.github.glandais/fit-kmp)
en quelques minutes, l'index de recherche suit sous ~30 min.

## Licence

Couvert par la FIT Protocol License Agreement de Garmin — voir
[`LICENSE.txt`](../LICENSE.txt) à la racine du dépôt.
