package ru.ikom.kmp_ds

import android.app.Application

class App : Application() {

    val appContainer: AppContainer by lazy(LazyThreadSafetyMode.NONE) {
        DefaultAppContainer(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
    }
}