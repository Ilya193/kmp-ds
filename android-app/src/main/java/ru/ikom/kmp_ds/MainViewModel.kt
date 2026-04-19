package ru.ikom.kmp_ds

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.ikom.kmp_ds.domain.PostsRepository

class MainViewModel(
    private val postsRepository: PostsRepository
) : ViewModel() {

    val state = MutableStateFlow("")

    init {
        viewModelScope.launch {
            try {
                state.update { postsRepository.getPosts() }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                println(e)
            }
        }

        viewModelScope.launch {
            postsRepository.getPostsAsFlow().collect {
                println("s149 postsAsFlow $it")
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    class Factory(
        private val postsRepository: PostsRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(postsRepository) as T
        }
    }
}