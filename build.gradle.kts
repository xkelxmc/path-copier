import java.util.Properties

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.21"
    id("org.jetbrains.intellij.platform") version "2.2.1"
}

group = "com.github.xkelxmc"
version = "1.0.0"

val localProperties = Properties().apply {
    val file = file("local.properties")
    if (file.exists()) {
        file.inputStream().use { load(it) }
    }
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2024.1")
        bundledPlugin("Git4Idea")
        instrumentationTools()
    }
}

kotlin {
    jvmToolchain(17)
}

tasks {
    patchPluginXml {
        sinceBuild.set("241")
        untilBuild.set("253.*")
    }

    runIde {
        autoReload.set(true)
    }

    publishPlugin {
        token.set(localProperties.getProperty("publishToken") ?: providers.environmentVariable("PUBLISH_TOKEN").orNull)
    }
}
