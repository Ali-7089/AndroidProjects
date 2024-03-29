plugins {
    id("com.android.application")
}

android {
    namespace = "com.deliyummy"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.deliyummy"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation( fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation( "com.github.rupomsoft:Toast-Silicon:1.0.0")
    implementation ("com.razorpay:razorpay-java:1.3.8")
    implementation ("nl.dionsegijn:konfetti:1.3.2")
    implementation ("com.google.android.gms:play-services-maps:18.1.0")
    implementation ("nl.dionsegijn:konfetti-xml:2.0.1")
    implementation ("com.github.suchoX:PlacePicker:1.1.2")
    implementation ("com.google.android.gms:play-services-maps:18.1.0")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("com.google.android.libraries.places:places:3.2.0")
    implementation ("com.google.android.material:material:1.9.0")
    implementation ("com.google.android.libraries.places:places:3.2.0")
    implementation ("com.google.android.gms:play-services-location:21.0.1")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.google.firebase:firebase-auth:22.1.1")
    implementation ("androidx.recyclerview:recyclerview:1.3.1")
    implementation ("com.google.firebase:firebase-database:20.2.2")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    android.defaultConfig.vectorDrawables.useSupportLibrary = true
    // Retrofit dependencies
    implementation ("com.squareup.retrofit2:retrofit:2.4.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.4.0")

    // glide image dependency
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.11.0")
}

