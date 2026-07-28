plugins {
    kotlin("multiplatform") version "2.4.20-Beta2"
    id("com.vanniktech.maven.publish") version "0.37.0"
}

kotlin {
    jvmToolchain(21)
    jvm()

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

// La licence FIT vit à la racine du dépôt (build Gradle autonome dans fit-kmp/).
val fitLicense = layout.projectDirectory.file("../LICENSE.txt")

tasks.named<Jar>("jvmJar") {
    from(fitLicense) { into("META-INF") }
}

mavenPublishing {
    publishToMavenCentral()

    // Ne signer que si une clé est réellement disponible (donc en CI). Signer
    // inconditionnellement ferait échouer `./gradlew publishToMavenLocal`, qui est la
    // commande utilisée pour inspecter un artefact avant release.
    val hasSigningKey =
        providers.gradleProperty("signingInMemoryKey").isPresent ||
            providers.gradleProperty("signing.keyId").isPresent ||
            providers.environmentVariable("ORG_GRADLE_PROJECT_signingInMemoryKey").isPresent
    if (hasSigningKey) {
        signAllPublications()
    }

    coordinates(group.toString(), "fit-kmp", version.toString())

    pom {
        name.set("fit-kmp")
        description.set(
            "Kotlin Multiplatform port of the Garmin FIT Java SDK — JVM and WASI targets",
        )
        url.set("https://github.com/glandais/fit-java-sdk")
        licenses {
            license {
                name.set("Flexible and Interoperable Data Transfer (FIT) Protocol License Agreement")
                url.set("https://github.com/glandais/fit-java-sdk/blob/main/LICENSE.txt")
            }
        }
        developers {
            developer {
                id.set("glandais")
                name.set("Gabriel Landais")
                url.set("https://github.com/glandais")
            }
        }
        scm {
            url.set("https://github.com/glandais/fit-java-sdk")
            connection.set("scm:git:git://github.com/glandais/fit-java-sdk.git")
            developerConnection.set("scm:git:git@github.com:glandais/fit-java-sdk.git")
        }
    }
}
