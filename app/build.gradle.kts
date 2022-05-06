plugins {
    id("com.android.application")
    kotlin("android")
    id("android-base")
}

android {
    buildFeatures {
        compose = true
    }
    defaultConfig.applicationId = AppCoordinates.APP_ID

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraint.layout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.activity)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.compose.animation)
    implementation(libs.androidx.compose.lifecycle.viewmodel)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.foundation)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.ext.junit.ktx)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.espresso.core)
}
