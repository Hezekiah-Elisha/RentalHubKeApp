// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    id("com.google.devtools.ksp") version "2.2.20-Beta1-2.0.2" apply false
}

buildscript {
    dependencies {
        // This part to copy paste
        classpath("io.kotzilla:kotzilla-plugin:1.2.0-Beta1")
    }
}