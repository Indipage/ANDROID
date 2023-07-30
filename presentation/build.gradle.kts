plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    kotlin("plugin.serialization") version Versions.KOTLIN_VERSION

}

android {
    namespace = "com.indipage.presentation"
    compileSdk = Configuration.COMPILE_SDK

    defaultConfig {
        minSdk = Configuration.MIN_SDK
        targetSdk = Configuration.TARGET_SDK

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
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core-ui"))
    implementation(project(":domain"))
    // Kotlin
    implementation(KotlinX.KOTLINX_SERIALIZATION)
    // AndroidX
    implementation(AndroidX.ACTIVITY)
    implementation(AndroidX.APP_COMPAT)
    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.LIFECYCLE_RUNTIME)
    implementation(AndroidX.PAGING)
    implementation(AndroidX.LIFECYCLE_VIEWMODEL_KTX)
    implementation(AndroidX.NAVIGATION_CONPONENT_FRAGMENT)
    implementation(AndroidX.NAVIGATION_CONPONENT_UI)
    implementation(AndroidX.CONSTRAINT_LAYOUT)

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
    implementation(ThirdParty.COIL)
    implementation(ThirdParty.ZXING)
}