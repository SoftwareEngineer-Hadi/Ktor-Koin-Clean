package com.htech.ktorkoin.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.htech.ktorkoin.core.Either
import com.htech.ktorkoin.domain.usecase.CreatePostUseCase
import com.htech.ktorkoin.domain.usecase.GetPostsUseCase
import com.htech.ktorkoin.presentation.post.PostUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostViewModel(
    private val getPosts: GetPostsUseCase,
    private val createPost: CreatePostUseCase
): ViewModel() {
    private val _state = MutableStateFlow<PostUiState> (PostUiState.Idle)
    val state: StateFlow<PostUiState> = _state

    fun loadPosts(){
        _state.value = PostUiState.Loading
        viewModelScope.launch {
            when(val res= getPosts()){
                is Either.Left-> _state.value = PostUiState.Error(res.value.message ?: "Unknown Error")
                is Either.Right-> _state.value = PostUiState.ListData(res.value)
            }
        }
    }

    fun addPost(userId: Int, title: String, body: String){
        _state.value = PostUiState.Loading
        viewModelScope.launch {
            when(val res= createPost(CreatePostUseCase.Params(userId, title, body))){
                is Either.Left -> _state.value = PostUiState.Error(res.value.message?:"Unknown Error")
                is Either.Right -> _state.value= PostUiState.Created(res.value)
            }
        }
    }
}