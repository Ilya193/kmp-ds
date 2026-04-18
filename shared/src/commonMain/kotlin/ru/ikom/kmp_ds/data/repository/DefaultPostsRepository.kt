package ru.ikom.kmp_ds.data.repository

import ru.ikom.kmp_ds.data.remote.PostsRemoteDataSource
import ru.ikom.kmp_ds.domain.PostsRepository

class DefaultPostsRepository(
    private val postsRemoteDataSource: PostsRemoteDataSource
) : PostsRepository {
    override suspend fun getPosts(): String {
        return postsRemoteDataSource.getPosts()
    }
}