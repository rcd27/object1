import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(28)

    defaultConfig {
        applicationId = "com.zstas.objectone"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "0.0.1"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        //      FIXME: duplicated code. Make same rules for all flavors
        getByName("debug") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    testOptions {
        unitTests.apply {
            isReturnDefaultValues = true
        }
    }
    packagingOptions.exclude("META-INF/main.kotlin_module")
}

dependencies {
    implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))

    // Android Framework
    // -----------------
    implementation("com.google.android.material:material:1.0.0-rc02")


    // Testing
    // -------
    testImplementation("junit:junit:4.12")
    testImplementation("android.arch.core:core-testing:1.1.1")
    testImplementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))
}

repositories {
    mavenCentral()
    maven("http://repository.jetbrains.com/all")
}