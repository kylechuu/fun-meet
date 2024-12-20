import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation("org.jetbrains.compose.runtime:runtime:1.5.0")
        }
        androidMain {
            dependencies {
                implementation("androidx.compose.ui:ui:1.5.4") // Compose UI
                implementation("androidx.compose.foundation:foundation:1.5.4") // Layouts
                implementation("androidx.compose.material3:material3:1.1.2") // Material Design
                implementation("androidx.activity:activity-compose:1.8.0") // Activity support for Compose
            }
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "com.example.hello_world"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    implementation(libs.androidx.runtime.android)
    implementation(libs.androidx.ui.tooling.preview.android)
}
