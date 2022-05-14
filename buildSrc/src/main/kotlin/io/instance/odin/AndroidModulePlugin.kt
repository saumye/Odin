package io.instance.odin

import AppCoordinates
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

class AndroidModulePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        // Configure common android build parameters.
        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion = "android-31"
                defaultConfig {
                    minSdk = 21
                    targetSdk = 31
                    versionCode = AppCoordinates.APP_VERSION_CODE
                    versionName = AppCoordinates.APP_VERSION_NAME
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                buildFeatures.buildConfig = false
                // Set both the Java and Kotlin compilers to target Java 8.
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
                project.tasks.withType(KotlinCompile::class.java).configureEach {
                    (kotlinOptions as KotlinJvmOptions).apply {
                        jvmTarget = JavaVersion.VERSION_1_8.toString()
                    }
                }
            }
        }
    }
}