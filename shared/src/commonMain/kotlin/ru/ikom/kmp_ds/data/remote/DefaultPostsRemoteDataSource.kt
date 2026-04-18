package ru.ikom.kmp_ds.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

class DefaultPostsRemoteDataSource(
    private val httpClient: HttpClient
) : PostsRemoteDataSource {
    override suspend fun getPosts(): String {
        val response = httpClient.get("https://api.ipify.org?format=json")
        return response.bodyAsText()
    }
}