package com.htech.ktorkoin.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class NewPostRequest(
    val userId: Int,
    val title: String,
    val body: String
)
