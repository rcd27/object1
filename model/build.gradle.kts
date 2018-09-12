import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version: String by extra
buildscript {
    var kotlin_version: String by extra
    kotlin_version = "1.2.61"
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlin_version))
    }
}

// TODO: figure out if we need `java-library` at all
plugins {
    `java-library`
}

apply {
    plugin("kotlin")
}

dependencies {
    implementation(kotlin("stdlib-jdk8", kotlin_version))
    testImplementation(kotlin("stdlib-jdk8", kotlin_version))
    testImplementation("junit:junit:4.12")
}

repositories {
    mavenCentral()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}