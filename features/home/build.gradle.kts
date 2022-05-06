plugins {
    id("com.android.application")
    kotlin("android")
    id("android-base")
}

android {
    buildFeatures {
        viewBinding = true
        compose = true
    }
}

dependencies {
    implementation(project(":app"))
}