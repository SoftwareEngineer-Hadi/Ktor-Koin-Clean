package com.htech.ktorkoin.presentation.post

import com.htech.ktorkoin.domain.entity.Post

sealed class PostUiState {
    object Idle : PostUiState()
    object Loading : PostUiState()
    data class Error(val message: String) : PostUiState()
    data class ListData(val posts: List<Post>) : PostUiState()
    data class Created(val post: Post) : PostUiState()
}