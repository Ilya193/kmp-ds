package ru.ikom.kmp_ds.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

class IOSPlatformModule : PlatformModule {
    override val httpClient: HttpClient = HttpClient(Darwin)
}