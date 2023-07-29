plugins {

    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version Versions.KOTLIN_VERSION
}

android {
    namespace = "com.indipage.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_VERSION
    }
}

dependencies {
    implementation(project(":domain"))
    // AndroidX
    implementation(AndroidX.APP_COMPAT)
    implementation(AndroidX.CORE_KTX)
    // Matrial Design
    implementation(Google.MATERIAL)
    // Test Dependency
    androidTestImplementation(TestDependencies.EXT_JUNIT)
    androidTestImplementation(TestDependencies.ESPRESSO_CORE)
    testImplementation(TestDependencies.JUNIT)
    //Hilt
    implementation(Google.HILT_ANDROID)
    kapt(Google.HILT_ANDROID_COMPILER)
    // Third-Party
    implementation(SquareUp.RETROFIT2)
    implementation(SquareUp.RETROFIT2_CONVERTER_GSON)
    implementation(SquareUp.OKHTTP3)
    implementation(SquareUp.OKHTTP3_LOGGING)
    implementation(SquareUp.OKHTTP3_BOM)
    implementation(Jakewharton.TIMBER)
    implementation(Jakewharton.CONVERTER)

    implementation(KotlinX.KOTLINX_COROUTINE)
}