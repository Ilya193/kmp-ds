package ru.ikom.kmp_ds

import ru.ikom.kmp_ds.di.AndroidPlatformModule
import ru.ikom.kmp_ds.di.DefaultKMPModule
import ru.ikom.kmp_ds.di.KMPModule
import ru.ikom.kmp_ds.di.PlatformModule
import ru.ikom.kmp_ds.domain.PostsRepository

interface AppContainer {
    val postsRepository: PostsRepository
}

class DefaultAppContainer : AppContainer {
    private val platformModule: PlatformModule = AndroidPlatformModule()

    private val kmpModule: KMPModule = DefaultKMPModule(platformModule)

    override val postsRepository: PostsRepository = kmpModule.postsRepository
}