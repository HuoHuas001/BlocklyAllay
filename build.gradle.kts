plugins {
    id("java-library")
    kotlin("jvm") version "2.1.0"
    id("org.allaymc.gradle.plugin") version "0.2.1"
    id("com.gradleup.shadow") version "9.2.2"
}

group = "cn.huohuas001.blocklyallay"
description = "BlocklyAllay plugin for AllayMC server"
version = "0.1.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

kotlin {
    jvmToolchain(21)
}

// See also https://github.com/AllayMC/AllayGradle
allay {
    // You can find the latest version here: https://central.sonatype.com/artifact/org.allaymc.allay/api
    api = "0.22.0"

    plugin {
        entrance = ".BlocklyAllay"
        authors += "HuoHuas001"
        website = "https://github.com/HuoHuas001/BlocklyAllay"
    }
}

dependencies {
    // Mozilla Rhino - 轻量级JavaScript引擎 (~3MB)
    implementation("org.mozilla:rhino:1.9.0")
}

tasks.shadowJar {
    archiveClassifier.set("")
    mergeServiceFiles()
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
