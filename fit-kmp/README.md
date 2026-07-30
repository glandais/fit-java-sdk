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
| JS (IR, node + browser) | `io.github.glandais:fit-kmp-js` |
| Wasm/WASI | `io.github.glandais:fit-kmp-wasm-wasi` |

Aucune dépendance externe hors `kotlin-stdlib`.

## Kotlin pur : pas de source set JVM

Tout le SDK vit dans `commonMain` — aucun `expect`/`actual`, aucune API `java.*`. Deux
conséquences par rapport au SDK Java :

- **`FileEncoder` n'existe pas.** L'encodage passe par `BufferEncoder`, qui rend le fichier
  complet sous forme de `ByteArray` ; l'écriture sur disque appartient à l'appelant.
- **`DateTime` n'expose ni `java.util.Date` ni `java.time.Instant`.** Le pont est
  `DateTime.fromUnixEpochMillis(ms)` et `dateTime.getUnixEpochMillis()`.

## Accesseurs

Les champs scalaires des messages sont des **propriétés Kotlin**, pas des paires
`getX()`/`setX()` (une propriété et une fonction homonyme entrent en collision de signature
sur JVM) :

```kotlin
val encoder = BufferEncoder(Fit.ProtocolVersion.V2_0)
encoder.write(
    RecordMesg().apply {
        localNum = 0
        timestamp = DateTime.fromUnixEpochMillis(startMs)
        power = 250
    },
)
val bytes: ByteArray = encoder.close()
```

Les champs **tableau** gardent l'API fonction (`getSpeed1s()`, `getNumSpeed1s()`,
`getSpeed1s(i)`, `setSpeed1s(i, v)`) : il n'y a pas de propriété indexée en Kotlin.

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

Les classes sont dans le package `io.github.glandais.fit` (et non `com.garmin.fit`), pour
qu'un projet puisse importer les deux SDK sans collision de noms.

> La version porte un suffixe `-kmp.N` (`21.205.0-kmp.1` = port KMP n°2 du SDK Java
> 21.205.0). Maven et Gradle le traitent comme un *pre-release qualifier* : épinglez une
> version exacte, les plages dynamiques ne le sélectionneront pas.

## Développement

Build autonome : toutes les commandes se lancent depuis `fit-kmp/`.

```sh
./gradlew allTests            # tests sur jvm, js (node + browser) et wasmWasi
./gradlew check               # + compilation de toutes les cibles
./gradlew publishToMavenLocal # artefacts non signés dans ~/.m2
```

Le test de référence est `GoldenCourseEncodeTest` : il réencode un fichier Course complet et
le compare **octet par octet** aux 277 octets produits par `com.garmin:fit:21.205.0`
(`GoldenCourseFixture`). Un échec signifie que le port et le SDK Java divergent sur le format —
ce n'est pas un golden à « mettre à jour », il se régénère depuis le SDK Java.

JDK 21+ requis pour lancer Gradle ; la compilation utilise le toolchain 21. Si votre JDK
par défaut ne convient pas, définissez `org.gradle.java.home` dans
`~/.gradle/gradle.properties` — **jamais** dans le `gradle.properties` du dépôt, cela
casserait la CI.

Les sources sous `src/commonMain` sont **régénérées intégralement** par
`python3 converter/convert.py` depuis la racine du dépôt : toute modification manuelle y
sera perdue. Les fichiers écrits à la main vivent dans `converter/overrides/`.
`src/commonTest/` est écrit à la main et survit au rejeu.

## Releasing

La publication est déclenchée par un tag `fit-kmp-v*` et effectuée par
`.github/workflows/fit-kmp-release.yml` (build, signature GPG, `publishAndReleaseToMavenCentral`,
puis création de la GitHub Release). Pas de semantic-release : la version est éditée à la main.

```sh
# 1. bump de la version
$EDITOR fit-kmp/gradle.properties      # version=21.205.0-kmp.3
git commit -am "fit-kmp 21.205.0-kmp.3"

# 2. tag (doit correspondre exactement à gradle.properties, le workflow le vérifie)
git tag fit-kmp-v21.205.0-kmp.3
git push origin main fit-kmp-v21.205.0-kmp.3
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
