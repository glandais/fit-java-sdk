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
