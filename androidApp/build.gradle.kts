plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.hello_world.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.hello_world.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui) // Core Compose UI
    implementation(libs.compose.foundation) // Optional: Layout components
    implementation(libs.compose.ui.tooling.preview) // Preview support in Android Studio
    implementation(libs.compose.material3) // Material Design components
    implementation(libs.androidx.activity.compose) // Compose activity support
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1") // Optional: Lifecycle extensions
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1") // Optional: ViewModel in Compose
    debugImplementation(libs.compose.ui.tooling) // UI debugging tools
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.5.4") // Optional: UI tests
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.5.4") // Optional: Manifest for UI tests
}