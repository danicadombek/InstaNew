// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.gms.google-services") version "4.4.0" apply false
    id("com.google.dagger.hilt.android") version "2.49" apply false
    kotlin("kapt") version "1.9.21"
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.2.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10" ) // Use the latest version
        classpath ("com.google.gms:google-services:4.4.0")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.49")
        classpath("com.google.gms:google-services:4.4.0")
    }
}