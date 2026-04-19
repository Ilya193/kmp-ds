package ru.ikom.kmp_ds

import android.content.Context
import ru.ikom.kmp_ds.di.AndroidPlatformModule
import ru.ikom.kmp_ds.di.DefaultKMPModule
import ru.ikom.kmp_ds.di.KMPModule
import ru.ikom.kmp_ds.di.PlatformModule
import ru.ikom.kmp_ds.domain.PostsRepository

interface AppContainer {
    val postsRepository: PostsRepository
}

class DefaultAppContainer(
    private val context: Context
) : AppContainer {
    private val platformModule: PlatformModule = AndroidPlatformModule(context)

    private val kmpModule: KMPModule = DefaultKMPModule(platformModule)

    override val postsRepository: PostsRepository = kmpModule.postsRepository
}