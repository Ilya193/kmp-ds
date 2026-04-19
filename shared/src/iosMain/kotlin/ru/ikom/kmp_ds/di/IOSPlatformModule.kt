package ru.ikom.kmp_ds.di

import androidx.datastore.core.DataStore
import androidx.datastore.core.okio.OkioStorage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesSerializer
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import kotlinx.cinterop.ExperimentalForeignApi
import okio.FileSystem
import okio.Path.Companion.toPath
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask
import ru.ikom.kmp_ds.di.datastore.createDataStore
import ru.ikom.kmp_ds.di.datastore.dataStoreFileName

class IOSPlatformModule : PlatformModule {
    override val httpClient: HttpClient = HttpClient(Darwin)

    @OptIn(ExperimentalForeignApi::class)
    override val dataStore: DataStore<Preferences> =
        createDataStore(
            storage = OkioStorage(
                fileSystem = FileSystem.SYSTEM,
                serializer = PreferencesSerializer,
                producePath = {
                    val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                        directory = NSDocumentDirectory,
                        inDomain = NSUserDomainMask,
                        appropriateForURL = null,
                        create = false,
                        error = null,
                    )
                    (requireNotNull(documentDirectory).path + "/$dataStoreFileName").toPath()
                }
            )
        )
}