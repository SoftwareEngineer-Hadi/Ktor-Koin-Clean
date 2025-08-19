package com.htech.ktorkoin.domain.entity

data class Post (
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)