package ru.ikom.kmp_ds.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

class AndroidPlatformModule : PlatformModule {
    override val httpClient: HttpClient = HttpClient(OkHttp)
}