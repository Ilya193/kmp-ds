package ru.ikom.kmp_ds

import ru.ikom.kmp_ds.di.KMPModule
import ru.ikom.kmp_ds.domain.PostsRepository

interface AppContainer {
    val postsRepository: PostsRepository
}

class DefaultAppContainer(
    private val kmpModule: KMPModule
) : AppContainer {
    override val postsRepository: PostsRepository = kmpModule.postsRepository
}