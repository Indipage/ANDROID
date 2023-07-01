package com.indipage

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class IndiPageApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }

}