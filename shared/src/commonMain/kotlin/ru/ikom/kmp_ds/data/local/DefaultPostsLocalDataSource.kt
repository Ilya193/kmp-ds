package ru.ikom.kmp_ds.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class DefaultPostsLocalDataSource(
    private val dataStore: DataStore<Preferences>
) : PostsLocalDataSource {

    override suspend fun savePosts(posts: String) {
        dataStore.updateData {
            it.toMutablePreferences().also { preferences ->
                preferences[POSTS_KEY] = posts
            }
        }
    }

    override suspend fun getPosts(): String? {
        return dataStore.data
            .map { preferences -> preferences[POSTS_KEY] }
            .firstOrNull { it != null }
    }

    override fun getPostsAsFlow(): Flow<String?> {
        return dataStore.data.map { preferences -> preferences[POSTS_KEY] }
    }

    companion object {
        private val POSTS_KEY = stringPreferencesKey("posts")
    }
}