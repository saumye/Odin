version = LibraryAndroidCoordinates.LIBRARY_VERSION

plugins {
    id("com.android.library")
    kotlin("android")
    id("maven-publish")
    id("android-base")
    publish
}

android {
    lint {
        warningsAsErrors = true
        abortOnError = true
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.ext.junit)
}
