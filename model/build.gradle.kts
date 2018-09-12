import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinVersion: String by extra
buildscript {
    var kotlinVersion: String by extra
    kotlinVersion = "1.2.61"
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", kotlinVersion))
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
    implementation(kotlin("stdlib-jdk8", kotlinVersion))
    testImplementation(kotlin("stdlib-jdk8", kotlinVersion))
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