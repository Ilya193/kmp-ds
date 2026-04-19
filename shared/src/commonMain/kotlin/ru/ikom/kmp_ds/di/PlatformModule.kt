package ru.ikom.kmp_ds.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import io.ktor.client.HttpClient

interface PlatformModule {
    val httpClient: HttpClient
    val dataStore: DataStore<Preferences>
}