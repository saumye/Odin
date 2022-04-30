plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("android-base") {
            id = "android-base"
            implementationClass = "io.instance.odin.AndroidModulePlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.kgp)
    implementation(libs.agp)
    implementation(libs.dokka.gradle.plugin)
    implementation(libs.dokka.core)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}