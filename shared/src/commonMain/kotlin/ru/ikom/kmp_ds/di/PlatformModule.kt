package ru.ikom.kmp_ds.di

import io.ktor.client.HttpClient

interface PlatformModule {
    val httpClient: HttpClient
}