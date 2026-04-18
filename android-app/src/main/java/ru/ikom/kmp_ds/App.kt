package ru.ikom.kmp_ds

import android.app.Application

class App : Application() {

    val appContainer: AppContainer = DefaultAppContainer()

    override fun onCreate() {
        super.onCreate()
    }
}