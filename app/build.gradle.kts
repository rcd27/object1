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
            if (this.name == "release") {
                isMinifyEnabled = true
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
    }
}

dependencies {
    // change to api project, because it must be recompiled each time
    implementation(project(":core"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.2.71")
    implementation("androidx.appcompat:appcompat:1.0.0")
    implementation("androidx.core:core-ktx:1.0.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    androidTestImplementation("androidx.test:runner:1.1.0-beta02")
    androidTestImplementation("androidx.test:rules:1.1.0-beta02")
    androidTestImplementation("androidx.test.uiautomator:uiautomator-v18:2.2.0-alpha1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.1.0-beta02")
}

tasks.register("unitTestsReport", JacocoReport::class.java ) {
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
