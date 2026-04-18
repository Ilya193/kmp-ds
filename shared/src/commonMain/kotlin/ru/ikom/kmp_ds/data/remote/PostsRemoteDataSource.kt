package ru.ikom.kmp_ds.data.remote

interface PostsRemoteDataSource {
    suspend fun getPosts(): String
}