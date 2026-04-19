package ru.ikom.kmp_ds.data.local

import kotlinx.coroutines.flow.Flow

interface PostsLocalDataSource {
    suspend fun savePosts(posts: String)
    suspend fun getPosts(): String?
    fun getPostsAsFlow(): Flow<String?>
}