buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.3.0-alpha10")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.2.61")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class) {
        val projectDir = project.projectDir
        delete(files("$projectDir/coverage", "$projectDir/build", "/app/build"))
    }
}