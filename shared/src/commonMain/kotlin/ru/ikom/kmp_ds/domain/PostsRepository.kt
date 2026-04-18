package ru.ikom.kmp_ds.domain

import ru.ikom.kmp_ds.domain.model.PostDomain

interface PostsRepository {
    suspend fun getPosts(): String
}