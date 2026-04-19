package ru.ikom.kmp_ds.domain

import kotlinx.coroutines.flow.Flow

interface PostsRepository {
    suspend fun getPosts(): String
    fun getPostsAsFlow(): Flow<String?>
}