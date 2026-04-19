package ru.ikom.kmp_ds.data.repository

import kotlinx.coroutines.flow.Flow
import ru.ikom.kmp_ds.data.local.PostsLocalDataSource
import ru.ikom.kmp_ds.data.remote.PostsRemoteDataSource
import ru.ikom.kmp_ds.domain.PostsRepository

class DefaultPostsRepository(
    private val postsRemoteDataSource: PostsRemoteDataSource,
    private val postsLocalDataSource: PostsLocalDataSource
) : PostsRepository {
    override suspend fun getPosts(): String {
        val posts = postsRemoteDataSource.getPosts()
        postsLocalDataSource.savePosts(posts)
        return posts
    }

    override fun getPostsAsFlow(): Flow<String?> {
        return postsLocalDataSource.getPostsAsFlow()
    }
}