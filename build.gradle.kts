plugins {
    kotlin("jvm") version "1.5.30"
    kotlin("kapt") version "1.5.30"
    idea
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.slf4j:slf4j-api:1.7.26")
    implementation("ch.qos.logback:logback-classic:1.2.3")
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:6.0.5")
}

tasks.jar {
    manifest {
        attributes("Main-Class" to "com.github.diceroller.DiceRoller")
    }

    from({
        val compileConfig = configurations.compileClasspath.get()
        compileConfig.map {
            if (it.isDirectory) it else zipTree(it)
        }
    })
}