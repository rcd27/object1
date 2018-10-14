buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.0-alpha13")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.71")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class.java) {
    val projectDir = project.projectDir
    delete(files("$projectDir/coverage", "$projectDir/build", "/app/build"))
}