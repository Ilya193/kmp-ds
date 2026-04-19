package ru.ikom.kmp_ds.di

import ru.ikom.kmp_ds.data.local.DefaultPostsLocalDataSource
import ru.ikom.kmp_ds.data.remote.DefaultPostsRemoteDataSource
import ru.ikom.kmp_ds.data.repository.DefaultPostsRepository
import ru.ikom.kmp_ds.domain.PostsRepository

interface KMPModule {
    val postsRepository: PostsRepository
}

class DefaultKMPModule(
    private val platformModule: PlatformModule
) : KMPModule, PlatformModule by platformModule {

    override val postsRepository: PostsRepository =
        DefaultPostsRepository(
            postsRemoteDataSource = DefaultPostsRemoteDataSource(httpClient),
            postsLocalDataSource = DefaultPostsLocalDataSource(dataStore)
        )
}