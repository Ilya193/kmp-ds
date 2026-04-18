package ru.ikom.kmp_ds.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin

actual fun httpClient(): HttpClient {
    return HttpClient(Darwin)
}