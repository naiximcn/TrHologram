plugins {
    id("java")
    id("io.izzel.taboolib") version "1.18"
    id("org.jetbrains.kotlin.jvm") version "1.5.10"
}
    
group = "me.arasple.mc.trhologram"
version = "2.4-pre6"
description = "Modern & Advanced Hologram-Plugin for Minecraft Servers"

taboolib {
    install(
        "common",
        "common-5",
        "platform-bukkit",
        "module-configuration",
        "module-chat",
        "module-lang",
        "module-nms",
        "module-nms-util",
        "module-metrics",
        "module-kether"
    )

    description {
        contributors {
            name("Arasple")
        }
        dependencies {
            name("PlaceholderAPI").optional(true)
        }
    }

    classifier = null
    version = "6.0.0-pre50"
}

repositories {
    mavenCentral()
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.codemc.org/repository/maven-public")
}

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib")
    compileOnly("ink.ptms.core:v11604:11604:all")
    compileOnly("ink.ptms.core:v11600:11600:all")
    compileOnly("ink.ptms.core:v11300:11300:all")
    compileOnly("ink.ptms.core:v11200:11200:all")
    compileOnly("ink.ptms.core:v10900:10900:all")
    compileOnly("me.clip:placeholderapi:2.10.9")
    compileOnly(fileTree("libs"))
}