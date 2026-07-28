# DESIGN.md — Conversion du SDK FIT Java (21.205.0) vers Kotlin Multiplatform

Document normatif. Tous les agents (classify.py, conv_*.py, overrides, build) DOIVENT
appliquer ces règles à la lettre. En cas de doute : ce document fait foi, pas le goût
personnel de l'agent.

---

## 0. Principes généraux

- **Package unique** : tout le code généré et overridé est dans `com.garmin.fit`.
  Un fichier `X.java` produit exactement un fichier `X.kt` de même nom de base
  (ex. `RecordMesg.java` -> `RecordMesg.kt`). Aucun sous-package.
- **Sortie** : `fit-kmp/src/commonMain/kotlin/com/garmin/fit/` (généré + overrides
  commonMain) et `fit-kmp/src/jvmMain/kotlin/com/garmin/fit/` (overrides jvmMain).
- **En-tête obligatoire** de chaque fichier généré par script :

```kotlin
/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from <NomFichier>.java (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package com.garmin.fit
```

  Les overrides manuels portent l'en-tête
  `// Hand-written multiplatform port of <NomFichier>.java — keep in sync (see overrides/hashes.json).`
  ou `// Multiplatform support file (no Java counterpart).`
- **Stabilité d'API** : on conserve les NOMS DE MÉTHODES Java (`getTimestamp()`,
  `setSpeed(...)`, `addListener(...)`, `getFieldIntegerValue(...)`, etc.). On ne
  convertit PAS les getters/setters en propriétés Kotlin. Deux exceptions
  globales, appliquées par TOUS les scripts (regex de réécriture) :
  1. Enums : `X.getByValue(v)` -> `X.fromValue(v)` et `x.getValue()` -> `x.value`
     (uniquement quand le receveur est une valeur d'enum du profil — en pratique :
     réécrire `\.getValue\(\)` -> `.value` dans le code généré mesgs/profile qui
     manipule des enums, et `(\w+)\.getByValue\(` -> `\1.fromValue(`).
  2. Accès collections : `list.get(i)` -> `list[i]`, `list.set(i, v)` -> `list[i] = v`,
     `list.size()` -> `list.size`, `map.put(k, v)` -> `map[k] = v`,
     `map.get(k)` -> `map[k]`, `map.containsKey(k)` -> `k in map` (ou `map.containsKey(k)`).
- **Pas de dépendance externe** en commonMain : uniquement kotlin-stdlib.
- **Corrections au classifieur (BUGS CONNUS de l'inventaire, à corriger dans
  classify.py)** :
  - La règle « public enum » doit matcher UNIQUEMENT la déclaration top-level :
    regex ancrée en début de ligne `^public enum \w+`. Sinon `Fit.java`
    (enum imbriqué `ProtocolVersion`) et `Decode.java` (enums imbriqués `RETURN`,
    `STATE`) tombent à tort dans `enums`. **`Fit.java` et `Decode.java` sont CORE**
    (overrides manuels). Après correction : enums = 102, core = 36.
  - `DateTime.java` et `LocalDateTime.java` contiennent `getStringFromValue` et
    tombent donc dans `constants` (c'est voulu par le contrat), MAIS
    `conv_constants.py` doit les SAUTER (liste `SKIP_HANDWRITTEN =
    {"DateTime.java", "LocalDateTime.java"}`) : ils sont fournis en overrides
    commonMain (voir §3) avec entrée dans `hashes.json`.
  - `BufferedRecordMesg.java` (`extends RecordMesg`) reste en core (override),
    conformément à l'inventaire.

---

## 1. Mapping des types Java -> Kotlin

### 1.1 Scalaires

| Java (boxed / primitif)      | Kotlin                          |
|------------------------------|---------------------------------|
| `Byte` / `byte`              | `Byte?` / `Byte`                |
| `Short` / `short`            | `Short?` / `Short`              |
| `Integer` / `int`            | `Int?` / `Int`                  |
| `Long` / `long`              | `Long?` / `Long`                |
| `Float` / `float`            | `Float?` / `Float`              |
| `Double` / `double`          | `Double?` / `Double`            |
| `Boolean` / `boolean`        | `Boolean?` / `Boolean`          |
| `String` (retour/param API)  | `String?` (nullable partout où Java peut retourner/accepter null) |
| `Object`                     | `Any?`                          |
| `java.math.BigInteger`       | `ULong?` (valeurs UINT64 ; voir 1.4) |
| `java.math.BigDecimal`       | `Double` (interne uniquement, voir 1.4) |

Règle : **tout type boxed Java devient le type Kotlin nullable équivalent** ;
tout primitif devient le type non-null. Les scripts appliquent cette table
mécaniquement sur les signatures.

### 1.2 Tableaux

| Java              | Kotlin              |
|-------------------|---------------------|
| `byte[]`          | `ByteArray`         |
| `short[]`, `int[]`, `long[]`, `float[]`, `double[]` | `ShortArray`, `IntArray`, `LongArray`, `FloatArray`, `DoubleArray` |
| `Byte[]`, `Short[]`, `Integer[]`, `Long[]`, `Float[]`, `Double[]` | `Array<Byte?>`, `Array<Short?>`, `Array<Int?>`, `Array<Long?>`, `Array<Float?>`, `Array<Double?>` |
| `String[]`        | `Array<String?>`    |
| `BigInteger[]`    | `Array<ULong?>`     |
| `MesgDefinition[]`| `Array<MesgDefinition?>` (éléments nullables : slots locaux) |

Les getters de tableaux des mesgs (`getFieldFloatValues`...) retournent
`Array<T?>` car les éléments invalides sont null en Java.

### 1.3 Littéraux et casts

| Java                          | Kotlin                     |
|-------------------------------|----------------------------|
| `(short)5`, `(byte)3`         | `5` (si le contexte attend Int, voir enums §6.1) sinon `5.toShort()` / `3.toByte()` |
| `631065600000l` / `...L`      | `631065600000L`            |
| `0x7FFF` affecté à Short      | `0x7FFF.toShort()`         |
| `Short.decode("0xFF")`        | `0xFF.toShort()`           |
| `Integer.decode(...)`, `Long.decode(...)` | littéral + `.toInt()` / `.toLong()` si nécessaire |
| `1.0f`                        | `1.0f`                     |
| `x instanceof Foo`            | `x is Foo`                 |
| `(Foo) x`                     | `x as Foo`                 |
| `a.equals(b)`                 | `a == b`                   |
| `new Foo(...)`                | `Foo(...)`                 |

**Élargissement int->double** : Java élargit silencieusement (`new Field(..., 1, 0, ...)`
vers des paramètres `double`). Kotlin non. Les scripts DOIVENT émettre des littéraux
`Double` aux positions scale/offset de `Field(...)` et `FieldComponent(...)`
(voir §6.4) : `1` -> `1.0`, `500` -> `500.0`.

### 1.4 BigInteger / BigDecimal (core uniquement, jamais dans le code généré)

Vérifié : aucun `*Mesg.java` généré n'utilise BigInteger ; seuls `Mesg.java`,
`FieldBase.java`, `DecoderBase.java` en dépendent.
- Valeurs FIT UINT64 : représentées par **`ULong`** en Kotlin (stockées comme
  `ULong` dans `FieldBase.values: ArrayList<Any?>`). Les méthodes Java
  `getBigIntegerValue*` / `getFieldBigIntegerValue*` sont renommées
  **`getULongValue*` / `getFieldULongValue*`** et retournent `ULong?`.
  `Fit.UINT64_INVALID` = `0xFFFFFFFFFFFFFFFFuL`.
- Les calculs de précision BigDecimal (expansion de composants dans
  `DecoderBase.java` l.334-344, scaling dans `FieldBase.java`) sont réécrits :
  chemin non signé 64 bits en arithmétique `ULong` (le pattern Java
  `BigInteger.valueOf(bits).add(ONE.shiftLeft(64))` == `bitsValue.toULong()`),
  le reste en `Double`. Perte de précision théorique au-delà de 2^53 acceptée et
  documentée en commentaire dans l'override.

### 1.5 Exemple avant/après (getter mesg)

```java
public Long getAccumulatedPower() {
    return getFieldLongValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
}
public void setAccumulatedPower(Long accumulatedPower) {
    setFieldValue(29, 0, accumulatedPower, Fit.SUBFIELD_INDEX_MAIN_FIELD);
}
```

```kotlin
fun getAccumulatedPower(): Long? {
    return getFieldLongValue(29, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD)
}
fun setAccumulatedPower(accumulatedPower: Long?) {
    setFieldValue(29, 0, accumulatedPower, Fit.SUBFIELD_INDEX_MAIN_FIELD)
}
```

---

## 2. IO : remplacement des flux JDK en commonMain

### 2.1 Stratégie : shims homonymes dans `com.garmin.fit`

On recrée en commonMain des classes portant **les mêmes noms simples que les
classes java.io utilisées** (le code étant dans un package unique, aucune
réécriture d'appel n'est nécessaire : les scripts se contentent de SUPPRIMER
tous les `import java.*`). Fichier support override :
`overrides/commonMain/Streams.kt` (pas de contrepartie .java).

API exacte (implémentation triviale sur ByteArray, à écrire dans Streams.kt) :

```kotlin
open class IOException(message: String? = null, cause: Throwable? = null)
    : Exception(message, cause)

abstract class InputStream {
    abstract fun read(): Int                          // 0..255, ou -1 en fin
    open fun read(b: ByteArray): Int
    open fun read(b: ByteArray, off: Int, len: Int): Int
    open fun available(): Int = 0
    open fun skip(n: Long): Long
    open fun mark(readlimit: Int) {}
    open fun reset() {}
    open fun markSupported(): Boolean = false
    open fun close() {}
}

open class ByteArrayInputStream(protected val buf: ByteArray,
                                offset: Int = 0, length: Int = buf.size) : InputStream() {
    protected var pos: Int = offset
    protected var markPos: Int = offset
    protected val count: Int = minOf(offset + length, buf.size)
    // read()/read(b,off,len)/available()/skip() ; mark(readlimit) mémorise pos ;
    // reset() restaure ; markSupported() = true. Sémantique identique au JDK.
}

abstract class OutputStream {
    abstract fun write(b: Int)                        // écrit l'octet bas
    open fun write(b: ByteArray)
    open fun write(b: ByteArray, off: Int, len: Int)
    open fun flush() {}
    open fun close() {}
}

open class ByteArrayOutputStream(initialCapacity: Int = 32) : OutputStream() {
    fun toByteArray(): ByteArray
    fun size(): Int
    fun reset()
}

class DataOutputStream(private val out: OutputStream) : OutputStream() {
    override fun write(b: Int) = out.write(b)
    fun writeByte(v: Int) = out.write(v)
    // n'implémenter QUE ce que le code core utilise (writeByte + write) ;
    // toute écriture multi-octets du SDK est déjà little-endian manuelle.
}
```

`ByteArrayDataInputStream.kt` (override du .java du même nom) étend
`ByteArrayInputStream` et garde son API Java (position, etc.).

### 2.2 Lecture binaire : remplacement de `java.nio.ByteBuffer`

Fichier support `overrides/commonMain/EndianIo.kt` — extensions internes :

```kotlin
internal fun ByteArray.getInt8(off: Int): Byte
internal fun ByteArray.getUInt8(off: Int): Short          // 0..255
internal fun ByteArray.getInt16(off: Int, bigEndian: Boolean): Short
internal fun ByteArray.getUInt16(off: Int, bigEndian: Boolean): Int
internal fun ByteArray.getInt32(off: Int, bigEndian: Boolean): Int
internal fun ByteArray.getUInt32(off: Int, bigEndian: Boolean): Long
internal fun ByteArray.getInt64(off: Int, bigEndian: Boolean): Long
internal fun ByteArray.getUInt64(off: Int, bigEndian: Boolean): ULong
internal fun ByteArray.getFloat32(off: Int, bigEndian: Boolean): Float   // Float.fromBits
internal fun ByteArray.getFloat64(off: Int, bigEndian: Boolean): Double  // Double.fromBits
```

Les overrides de `Decoder.kt`, `DecoderBase.kt`, `DeveloperField*.kt` et
`FieldBase.kt` utilisent ces extensions à la place de ByteBuffer/ByteOrder.

### 2.3 Chaînes et charset (`FieldBase.java`)

Le décodage `CharsetDecoder`/UTF-8 de FieldBase est remplacé par :
`bytes.copyOfRange(0, len).decodeToString()` (UTF-8, kotlin-stdlib common) avec
troncature au premier octet 0x00 ; encodage : `str.encodeToByteArray()` + 0x00
terminal. Comportement sur séquences invalides : caractère de remplacement
U+FFFD (celui de `decodeToString`), accepté.

### 2.4 UUID (`DeveloperField`, `DeveloperFieldDescription`)

Fichier support `overrides/commonMain/Uuid.kt` :

```kotlin
class Uuid(val mostSignificantBits: Long, val leastSignificantBits: Long) {
    override fun toString(): String   // format canonique 8-4-4-4-12 minuscule
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
    companion object {
        fun fromString(name: String): Uuid
        fun fromBytes(bytes: ByteArray): Uuid   // 16 octets big-endian
    }
}
```

Toute occurrence de `java.util.UUID` dans les overrides devient `Uuid`.

### 2.5 CRC16 sans `java.util.zip`

`CRC16.kt` (override) : classe simple, plus d'interface `Checksum` :

```kotlin
class CRC16 {
    fun update(b: Int)
    fun update(b: ByteArray, off: Int, len: Int)
    fun getValue(): Long
    fun reset()
}
```

`CRC.kt` : port direct (arithmétique pure, aucune dépendance).

### 2.6 Répartition commonMain / jvmMain

- **jvmMain (seul fichier issu de l'inventaire `jvmOnlyCandidates`)** :
  `FileEncoder.kt` — utilise `java.io.File`, `java.io.FileOutputStream`,
  `java.io.RandomAccessFile` DIRECTEMENT (qualifiés `java.io.*` pour éviter la
  collision avec les shims common). API Java conservée
  (`open(File)`, `write(Mesg)`, `close()`...).
- **jvmMain, fichiers support** : `DateTimeJvm.kt` (voir §3),
  `InteropStreams.kt` (facultatif : `fun java.io.InputStream.readAllToByteArray()`
  helper pour alimenter le décodeur depuis un flux JVM).
- **Encodage multiplateforme** : `BufferEncoder.kt` (commonMain) est le chemin
  d'encodage officiel pour js/linuxX64 (il produit un `ByteArray` via
  `close(): ByteArray`).
- Les méthodes core prenant `InputStream` (Decode.read, FitDecoder.decode,
  DecoderBase.isFIT...) restent en commonMain avec le shim `InputStream` ;
  surcharges `ByteArray` conservées telles quelles.

---

## 3. DateTime / LocalDateTime sans `java.util.Date`

Overrides commonMain `DateTime.kt` et `LocalDateTime.kt` (sources trackées dans
`hashes.json` ; `conv_constants.py` les saute, cf. §0).

Représentation : identique au Java — `timestamp: Long` = secondes depuis l'époque
FIT (1989-12-31T00:00:00Z) + `fractionalTimestamp: Double` ∈ [0,1).

```kotlin
class DateTime : Comparable<DateTime> {
    private var timestamp: Long
    private var fractionalTimestamp: Double

    constructor(timestamp: Long)
    constructor(timestamp: Long, fractionalTimestamp: Double)
    constructor(other: DateTime)

    fun getTimestamp(): Long                 // non-null (Java retournait Long boxed jamais null)
    fun getFractionalTimestamp(): Double
    fun convertSystemTimeToUTC(offset: Long)
    fun add(dateTime: DateTime); fun add(timestamp: Long); fun add(fractionalTimestamp: Double)
    override fun compareTo(other: DateTime): Int
    fun after(t1: DateTime): Boolean
    fun before(t1: DateTime): Boolean
    fun equals(dateTime: DateTime): Boolean          // conserve la surcharge Java

    /** Remplace getDate()/getInstant() : millisecondes epoch Unix. */
    fun getUnixEpochMillis(): Long =
        timestamp * 1000 + (fractionalTimestamp * 1000).roundToLong() + OFFSET

    /** ISO-8601 UTC "yyyy-MM-ddTHH:mm:ssZ", calculé par arithmétique civile pure. */
    override fun toString(): String

    companion object {
        const val MIN: Long = 0x10000000
        val INVALID: Long = Fit.UINT32_INVALID
        const val OFFSET: Long = 631065600000L
        fun getStringFromValue(value: Long?): String     // via stringMap (MIN -> "MIN")
        fun getValueFromString(value: String): Long
        fun fromUnixEpochMillis(ms: Long): DateTime =
            DateTime((ms - OFFSET) / 1000, ((ms - OFFSET) % 1000) / 1000.0)
    }
}
```

`LocalDateTime.kt` : même approche (mêmes constantes/méthodes que le .java, sans
java.time).

**jvmMain `DateTimeJvm.kt`** (extensions de confort, API Java historique) :

```kotlin
fun DateTime.getDate(): java.util.Date = java.util.Date(getUnixEpochMillis())
fun DateTime.getInstant(): java.time.Instant = java.time.Instant.ofEpochMilli(getUnixEpochMillis())
fun DateTime.Companion.from(instant: java.time.Instant): DateTime = fromUnixEpochMillis(instant.toEpochMilli())
```

Le constructeur Java `DateTime(java.util.Date)` disparaît de commonMain ;
équivalent : `DateTime.fromUnixEpochMillis(date.getTime())`.

---

## 4. Conventions Kotlin

1. **Enums** : voir template §6.1. Propriété `value`, `companion object` avec
   `fromValue(value: Short?): X` et `getStringFromValue(value: X): String`.
2. **Membres statiques** : classe utilitaire 100 % statique (GarminProduct,
   Factory, Profile, CRC…) -> `object` Kotlin. Classe mixte (Mesg, Fit,
   RecordMesg…) -> `companion object` pour les membres statiques.
   `public static final int X = <littéral>` -> `const val X: Int = ...` ;
   initialiseur non littéral (référence à `Fit.*`, expression) -> `val`.
   Le script décide : littéral décimal/hexa pur => `const`.
3. **Interfaces listener** (une méthode abstraite) -> `fun interface` :

   ```java
   public interface RecordMesgListener {
       public void onMesg(RecordMesg mesg);
   }
   ```
   ```kotlin
   fun interface RecordMesgListener {
       fun onMesg(mesg: RecordMesg)
   }
   ```
4. **Collections** : `ArrayList`/`HashMap`/`HashSet`/`LinkedHashMap` existent en
   Kotlin common — garder les mêmes noms. `List<T>` en position de champ mutable
   -> `MutableList<T>` (en pratique instancié `ArrayList()`). `LinkedList` ->
   `ArrayList`. `TreeMap` (MonitoringReader uniquement) -> `HashMap` + itération
   `keys.sorted()` aux points d'usage. `Collections.sort(l, c)` ->
   `l.sortWith(c)` ; `Collections.unmodifiableList(l)` -> `l` (retourné typé
   `List<T>`). `Iterator` explicite -> boucles `for`/`removeAll` idiomatiques
   dans les overrides.
5. **switch/case** -> `when` sans fallthrough (le SDK n'utilise pas de
   fallthrough dans les fichiers en scope) :
   `switch (mesg.getNum()) { case MesgNum.RECORD: ... break; default: ... }` ->
   `when (mesg.getNum()) { MesgNum.RECORD -> { ... } else -> { ... } }`.
6. **Thread-safety** : AUCUN `synchronized` détecté dans les 495 fichiers en
   scope. Si un rejeu futur en rencontre : le supprimer et logguer un WARNING
   (contrat mono-thread documenté dans le README de fit-kmp). Pas d'expect/actual
   pour les verrous.
7. **Exceptions** : `FitRuntimeException.kt` (override commonMain) :

   ```kotlin
   class FitRuntimeException : RuntimeException {
       constructor(message: String) : super(message)
       constructor(message: String, cause: Throwable) : super(message, cause)
       constructor(cause: Throwable) : super(cause)
   }
   ```
   `try { } catch (java.io.IOException e)` -> `catch (e: IOException)` (shim).
   `throws IOException` dans les signatures : supprimé (annotation facultative
   `@Throws` NON utilisée).
8. **Visibilité** : `public` -> défaut (rien) ; `protected` -> `protected` (sur
   classes ouvertes) ; `private` -> `private` ; package-private -> `internal`.
   `Mesg`, `FieldBase`, `DecoderBase` et leurs membres surchargés doivent être
   `open`/`abstract` comme en Java ; le constructeur `protected Mesg(String,int)`
   passe `internal` (les companions générés des mesgs doivent l'appeler).
9. **Nullabilité** : les paramètres/retours d'API publics suivent §1.1 (boxed ->
   nullable). Le pattern Java `if (x == null) { return null; }` ->
   `val x = ... ?: return null`.
10. **Champs `values()` d'enum** : `for (Sport s : Sport.values())` ->
    `for (s in Sport.entries)`.

---

## 5. Structure exacte de `fit-kmp/`

```
fit-kmp/
├── settings.gradle.kts
├── build.gradle.kts
├── gradle.properties
└── src/
    ├── commonMain/kotlin/com/garmin/fit/   # ~460 fichiers générés + overrides commonMain
    └── jvmMain/kotlin/com/garmin/fit/      # overrides jvmMain uniquement
```

`convert.py` : supprime et régénère intégralement `fit-kmp/src/` ; crée
`settings.gradle.kts`, `build.gradle.kts`, `gradle.properties` seulement s'ils
sont absents (templates embarqués dans convert.py, contenu ci-dessous).

**settings.gradle.kts** :

```kotlin
rootProject.name = "fit-kmp"
```

**build.gradle.kts** (Kotlin 2.2.0 : plage Gradle supportée 7.6.3–8.14, OK pour
Gradle 8.14.4) :

```kotlin
plugins {
    kotlin("multiplatform") version "2.2.0"
}

group = "com.garmin.fit"
version = "21.205.0"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
    jvm()
    js {
        nodejs()
    }
    linuxX64()

    sourceSets {
        commonMain {
            dependencies { /* aucune dépendance externe */ }
        }
        commonTest {
            dependencies { implementation(kotlin("test")) }
        }
    }
}
```

**gradle.properties** :

```properties
kotlin.code.style=official
org.gradle.jvmargs=-Xmx2g
```

Cibles js et linuxX64 compilent le même commonMain ; seul jvmMain ajoute
FileEncoder + interop java.io/java.time.

---

## 6. Templates par catégorie scriptée

Tous les scripts partagent un module utilitaire `converter/jtok.py` (regex
communes : mapping de types §1, réécritures §0, suppression des imports,
translittération des littéraux §1.3, extraction du javadoc conservé en KDoc).

### 6.1 `conv_enums.py` — 102 fichiers (tous à valeur `short`)

Avant (Sport.java) :

```java
public enum Sport {
    GENERIC((short)0),
    ...
    INVALID((short)255);
    protected short value;
    private Sport(short value) { this.value = value; }
    public static Sport getByValue(final Short value) { ... return Sport.INVALID; }
    public static String getStringFromValue( Sport value ) { return value.name(); }
    public short getValue() { return value; }
}
```

Après (Sport.kt) — squelette EXACT à produire :

```kotlin
enum class Sport(rawValue: Int) {
    GENERIC(0),
    RUNNING(1),
    // ... une entrée par constante, valeur = littéral Java sans cast ...
    INVALID(255);

    val value: Short = rawValue.toShort()

    companion object {
        fun fromValue(value: Short?): Sport {
            return entries.firstOrNull { it.value == value } ?: INVALID
        }

        fun getStringFromValue(value: Sport): String = value.name
    }
}
```

Notes : le constructeur prend `Int` (littéraux propres), la propriété exposée
`value` est `Short` comme en Java. Pas de méthode `getValue()` ni `getByValue()`
(cf. réécritures globales §0). Le script extrait `(NOM, littéral)` par regex
`^\s*(\w+)\(\(short\)(\d+)\)` et le corps est 100 % template.

### 6.2 `conv_constants.py` — 99 fichiers moins {DateTime.java, LocalDateTime.java} (skippés)

Type de base variable (int, long…) : lu sur `public static final <T> NOM = ...`
et sur le paramètre de `getStringFromValue(<Boxed> value)`.

Avant (GarminProduct.java, type int) :

```java
public class GarminProduct {
    public static final int HRM1 = 1;
    public static final int AXH01 = 2; // AXH01 HRM chipset
    ...
    private static final Map<Integer, String> stringMap;
    static { stringMap = new HashMap<>(); stringMap.put(HRM1, "HRM1"); ... }
    public static String getStringFromValue( Integer value ) { ... return ""; }
    public static Integer getValueFromString( String value ) { ... return INVALID; }
}
```

Après (GarminProduct.kt) :

```kotlin
object GarminProduct {
    const val HRM1 = 1
    const val AXH01 = 2 // AXH01 HRM chipset
    // ... commentaires de fin de ligne conservés ...
    val INVALID = Fit.UINT16_INVALID          // val (initialiseur non littéral)

    private val stringMap: Map<Int, String> = mapOf(
        HRM1 to "HRM1",
        AXH01 to "AXH01",
        // ... reprend exactement les stringMap.put(...) du bloc static ...
    )

    fun getStringFromValue(value: Int?): String = stringMap[value] ?: ""

    fun getValueFromString(value: String): Int {
        for ((k, v) in stringMap) {
            if (v == value) return k
        }
        return INVALID
    }
}
```

Si le fichier Java n'a pas de constante `INVALID`, `getValueFromString` retourne
ce que le Java retourne (recopier l'expression). Type long -> `Map<Long, String>`
et signatures `Long?`/`Long`.

### 6.3 `conv_listeners.py` — 129 interfaces triviales

Template unique :

```kotlin
fun interface <Nom> {
    fun <méthode>(<params types mappés §1>)
}
```

Exemple : `RecordMesgListener` -> `fun interface RecordMesgListener { fun onMesg(mesg: RecordMesg) }`.
(Les 4 interfaces non triviales listées par l'inventaire — MesgWithEvent,
MesgBroadcastPlugin, MesgSource, BufferedMesgListener — sont en core/overrides,
converties en `interface` normale.)

### 6.4 `conv_mesgs.py` — 124 classes `extends Mesg`

Squelette cible (RecordMesg.kt) :

```kotlin
class RecordMesg : Mesg {

    companion object {
        const val TimestampFieldNum = 253
        const val PositionLatFieldNum = 0
        // ... tous les *FieldNum ...

        val recordMesg: Mesg = run {
            var field_index = 0
            val recordMesg = Mesg("record", MesgNum.RECORD)
            recordMesg.addField(Field("timestamp", TimestampFieldNum, 134, 1.0, 0.0, "s", false, Profile.Type.DATE_TIME))
            field_index++
            // ...
            recordMesg.addField(Field("altitude", AltitudeFieldNum, 132, 5.0, 500.0, "m", false, Profile.Type.UINT16))
            recordMesg.fields[field_index].components.add(FieldComponent(78, false, 16, 5.0, 500.0)) // enhanced_altitude
            field_index++
            // ... traduction ligne à ligne du bloc static Java ...
            recordMesg
        }
    }

    constructor() : super(Factory.createMesg(MesgNum.RECORD))
    constructor(mesg: Mesg?) : super(mesg)

    /**
     * Get timestamp field
     * Units: s
     */
    fun getTimestamp(): DateTime? {
        return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD))
    }

    fun setTimestamp(timestamp: DateTime?) {
        setFieldValue(253, 0, timestamp?.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD)
    }
    // ... autres accesseurs ...
}
```

Règles mécaniques (ordre d'application) :
1. Nom du champ statique : `protected static final Mesg xxxMesg` + bloc
   `static { ... }` -> `val xxxMesg: Mesg = run { ... dernière expression xxxMesg }`
   dans le companion. Réécritures internes : `new X(` -> `X(`,
   `fields.get(i)` -> `fields[i]`, `;` supprimés, scale/offset -> littéraux `.0`
   (4e et 5e args de `Field`, 4e et 5e de `FieldComponent`, idem `SubField` :
   tout argument numérique en position déclarée `double` dans la classe cible
   reçoit `.0` s'il est entier).
2. Constructeurs : toujours les deux formes ci-dessus (`MesgNum.<X>` extrait du
   `super(Factory.createMesg(MesgNum.X))` Java).
3. Accesseurs — table de patterns (T ∈ {Byte, Short, Integer, Long, Float,
   Double, String} ; T' = type Kotlin mappé) :

   | Pattern Java (corps)                                        | Kotlin émis |
   |-------------------------------------------------------------|-------------|
   | `public T getX() { return getFieldTValue(a, b, c); }`       | `fun getX(): T'? { return getFieldTValue(a, b, c) }` |
   | `public T[] getXs() { return getFieldTValues(a, c); }`      | `fun getXs(): Array<T'?> { return getFieldTValues(a, c) }` |
   | `public int getNumX() { return getNumFieldValues(a, c); }`  | `fun getNumX(): Int { return getNumFieldValues(a, c) }` |
   | `public void setX(T x) { setFieldValue(...); }`             | `fun setX(x: T'?) { setFieldValue(...) }` |
   | `public DateTime getX() { return timestampToDateTime(getFieldLongValue(...)); }` | `fun getX(): DateTime? { return timestampToDateTime(getFieldLongValue(...)) }` |
   | `public void setX(DateTime x) { setFieldValue(a, b, x.getTimestamp(), c); }` | `fun setX(x: DateTime?) { setFieldValue(a, b, x?.getTimestamp(), c) }` |
   | enum getter :<br>`Short value = getFieldShortValue(...); if (value == null) return null; return E.getByValue(value);` | `fun getX(): E? {`<br>`    val value = getFieldShortValue(...) ?: return null`<br>`    return E.fromValue(value)`<br>`}` |
   | enum setter : `setFieldValue(a, b, x.value, c)` ou `x.getValue()` | `fun setX(x: E?) { setFieldValue(a, b, x?.value, c) }` |
   | variantes subfield par nom : mêmes patterns avec `"nom"` en 3e arg | identiques, chaîne conservée |

4. Javadoc conservé tel quel en KDoc.
5. Toute méthode ne matchant aucun pattern => le script ÉCHOUE avec un message
   listant fichier+ligne (pas de sortie silencieusement fausse).

### 6.5 `conv_profile.py` — 5 fichiers (Profile.java, Factory.java, FitMessages.java, FitListener.java, MesgBroadcaster.java)

Fichiers réguliers mais hétérogènes : conversion par mini-translateur dédié par
fichier (chacun a une forme fixe).

- **Profile.java** -> `object Profile { object SubFields { const val ... /* ou val si init non littéral */ }
  enum class Type(rawValue: Int) { ...; val value: Short = rawValue.toShort() ... } ... }`.
  Les classes internes 100 % constantes deviennent des `object` imbriqués ;
  l'enum imbriqué `Type` suit le template §6.1 (référencé partout comme
  `Profile.Type.UINT8` — inchangé).
- **Factory.java** -> `object Factory` ; `switch(mesg.getNum())` -> `when (mesg.getNum())` :

  ```kotlin
  object Factory {
      fun createMesg(mesg: Mesg): Mesg {
          return when (mesg.getNum()) {
              MesgNum.FILE_ID -> FileIdMesg(mesg)
              // ...
              else -> Mesg(mesg)
          }
      }
      fun createMesg(num: Int): Mesg { ... }
      fun createField(mesgNum: Int, fieldNum: Int): Field { ... }
  }
  ```
- **FitMessages.java** -> classe avec champs
  `internal val fileIdMesgs = ArrayList<FileIdMesg>()` (le Java y accède en
  package-private depuis FitListener) et getters
  `fun getFileIdMesgs(): List<FileIdMesg> = fileIdMesgs`.
- **FitListener.java** -> `class FitListener : MesgListener, DeveloperFieldDescriptionListener`,
  `@Override` -> `override fun`, gros `switch` -> `when` avec branches
  `MesgNum.FILE_ID -> fitMessages.fileIdMesgs.add(FileIdMesg(mesg))`.
- **MesgBroadcaster.java** -> classe ; champs
  `private final List<XxxMesgListener> xxx;` + init constructeur ->
  `private val xxxMesgListeners = ArrayList<XxxMesgListener>()` ; surcharges
  `fun addListener(l: XxxMesgListener)` conservées ; `run(...)`/`onMesg(...)`
  avec `switch` -> `when`. `implements A, B, C` -> `: A, B, C` avec `override`.

Comme pour conv_mesgs.py : toute construction inattendue => échec bruyant du
script.

---

## 7. Fichiers core : répartition et overrides

### 7.1 `overrides/commonMain/` (35 ports de .java — tous sauf FileEncoder)

Accumulator.kt, BufferEncoder.kt, BufferedMesgBroadcaster.kt,
BufferedMesgListener.kt, BufferedRecordMesg.kt, BufferedRecordMesgBroadcaster.kt,
ByteArrayDataInputStream.kt, CRC.kt, CRC16.kt, Decode.kt (†), Decoder.kt,
DecoderBase.kt, DeveloperField.kt, DeveloperFieldDefinition.kt,
DeveloperFieldDescription.kt, Field.kt, FieldBase.kt, FieldComponent.kt,
FieldDefinition.kt, FieldDefinitionBase.kt, Fit.kt (†), FitDecoder.kt,
FitRuntimeException.kt, FileUtil.kt, Mesg.kt, MesgBroadcastPlugin.kt,
MesgDefinition.kt, MesgFilterBase.kt, MesgSource.kt, MesgWithEvent.kt,
MesgWithEventBroadcaster.kt, MonitoringReader.kt, ProtocolValidator.kt,
ProtocolValidatorFactory.kt, SubField.kt
— plus DateTime.kt et LocalDateTime.kt (catégorie constants, skippés par script, §3).
(† = reclassés core après correction du classifieur, §0.)

### 7.2 `overrides/commonMain/`, fichiers support SANS contrepartie .java

Streams.kt (§2.1), EndianIo.kt (§2.2), Uuid.kt (§2.4).

### 7.3 `overrides/jvmMain/`

FileEncoder.kt (port de FileEncoder.java, java.io qualifié), DateTimeJvm.kt
(support), InteropStreams.kt (support, facultatif).

### 7.4 `overrides/hashes.json`

```json
{
  "commonMain/Mesg.kt":        { "source": "Mesg.java",        "sha256": "<hex du .java>" },
  "commonMain/DateTime.kt":    { "source": "DateTime.java",    "sha256": "..." },
  "commonMain/Streams.kt":     { "source": null,               "sha256": null },
  "jvmMain/FileEncoder.kt":    { "source": "FileEncoder.java", "sha256": "..." }
}
```

`convert.py` au rejeu : recalcule le sha256 de chaque `source` non null ; si
différent -> `WARNING: override commonMain/Mesg.kt: Mesg.java a changé, re-vérifier
le port manuel` (liste complète en fin d'exécution, code retour 0). Les entrées
`source: null` ne déclenchent jamais de warning. Après vérification manuelle,
mise à jour du hash via `python3 converter/convert.py --update-hashes`.

### 7.5 Points d'attention pour les auteurs d'overrides

- `Mesg.kt` : `open class`, constructeur `internal constructor(name: String, num: Int)`,
  copie `constructor(mesg: Mesg?)` ; champs `fields: ArrayList<Field>` et
  `developerFields: ArrayList<DeveloperField>` en `internal` (accédés par le code
  généré companion des mesgs) ; `getFieldULongValue*` remplace
  `getFieldBigIntegerValue*` (§1.4) ; `timestampToDateTime(value: Long?): DateTime?`.
- `FieldBase.kt` : `values: ArrayList<Any?>` ; types stockés possibles :
  Byte/Short/Int/Long/ULong/Float/Double/String/ByteArray ; `getULongValue*`
  remplace `getBigIntegerValue*`.
- `Fit.kt` : `object Fit` + `enum class ProtocolVersion` imbriqué ; constantes
  `*_INVALID` typées comme en Java (`UINT8_INVALID: Short = 0xFF.toShort()`,
  `UINT32_INVALID: Long = 0xFFFFFFFFL`, `UINT64_INVALID: ULong = ULong.MAX_VALUE`) ;
  `baseTypeMinMap`/`baseTypeMaxMap`/`baseTypeInvalidMap` : `HashMap<Int, Any>`.
- `Decode.kt` : enums imbriqués `RETURN`, `STATE` -> `enum class` imbriqués
  (noms conservés : `Decode.RETURN.MESG`...).
- Ordre de conversion conseillé : Streams/EndianIo/Uuid -> Fit -> CRC/CRC16 ->
  FieldBase/Field/SubField/FieldComponent -> Mesg/MesgDefinition ->
  DecoderBase/Decoder/Decode -> le reste.
