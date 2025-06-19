// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    id("com.google.dagger.hilt.android") version "2.56.1" apply false
    id("com.google.gms.google-services") version "4.4.2" apply false
     {
        id ("kotlin-kapt")
        id ("dagger.hilt.android.plugin")
         //kapt ("com.google.dagger:hilt-compiler:2.48")
         //kapt ("androidx.room:room-compiler:2.6.1")
    }


}