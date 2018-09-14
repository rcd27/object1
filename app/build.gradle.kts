import com.sun.jndi.toolkit.url.Uri

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("jacoco")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.zstas.objectone"
        minSdkVersion(21)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        all {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    lintOptions {
        check("Interoperability")
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.2.61")
    implementation("androidx.appcompat:appcompat:1.0.0-rc02")
    implementation("androidx.core:core-ktx:1.0.0-rc02")
    implementation("androidx.legacy:legacy-support-v4:1.0.0-rc02")

    testImplementation("junit:junit:4.12")
    androidTestImplementation("androidx.test:runner:1.1.0-alpha4")
    androidTestImplementation("androidx.test:rules:1.1.0-alpha4")
    androidTestImplementation("androidx.test.uiautomator:uiautomator-v18:2.2.0-alpha1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.0-alpha4")
}

tasks {
    val unitTestsReport by registering(JacocoReport::class) {
        dependsOn("testDebugUnitTest")
        group = "reports"
        description = "Generate Jacoco test-coverage report"
        classDirectories = fileTree("${project.buildDir}/tmp/kotlin-classes/debugUnitTest/")
        sourceDirectories = files("${project.projectDir}/src/main/java")
        executionData = files("${project.buildDir}/jacoco/testDebugUnitTest.exec")
        reports {
            html.isEnabled = true
            html.destination = file("${project.projectDir}/../coverage/app")
        }
    }
}