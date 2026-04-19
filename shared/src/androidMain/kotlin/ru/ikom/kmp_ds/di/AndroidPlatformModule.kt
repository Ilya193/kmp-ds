package ru.ikom.kmp_ds.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.FileStorage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesFileSerializer
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import ru.ikom.kmp_ds.di.datastore.createDataStore
import ru.ikom.kmp_ds.di.datastore.dataStoreFileName

class AndroidPlatformModule(
    private val context: Context
) : PlatformModule {
    override val httpClient: HttpClient = HttpClient(OkHttp)

    override val dataStore: DataStore<Preferences> =
        createDataStore(
            storage = FileStorage(
                serializer = PreferencesFileSerializer,
                produceFile = { context.filesDir.resolve(dataStoreFileName) }
            )
        )
}