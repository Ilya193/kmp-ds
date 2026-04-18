package ru.ikom.kmp_ds

import android.app.Application
import ru.ikom.kmp_ds.di.AndroidPlatformModule
import ru.ikom.kmp_ds.di.DefaultKMPModule
import ru.ikom.kmp_ds.di.KMPModule
import ru.ikom.kmp_ds.di.PlatformModule

class App : Application() {

    private val platformModule: PlatformModule = AndroidPlatformModule()

    private val kmpModule: KMPModule = DefaultKMPModule(platformModule)

    val appContainer: AppContainer = DefaultAppContainer(kmpModule)

    override fun onCreate() {
        super.onCreate()
    }
}