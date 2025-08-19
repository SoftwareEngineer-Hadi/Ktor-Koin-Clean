package com.htech.ktorkoin.domain.usecase

import com.htech.ktorkoin.core.Either
import com.htech.ktorkoin.core.Failure
import com.htech.ktorkoin.domain.entity.Post
import com.htech.ktorkoin.domain.repository.PostRepository

class CreatePostUseCase(private val repo: PostRepository) {
    data class Params(val userId:Int,val title:String,val body:String)
    suspend operator fun invoke(params: Params): Either<Failure, Post> = repo.createPost(params.userId,params.title,params.body)

}