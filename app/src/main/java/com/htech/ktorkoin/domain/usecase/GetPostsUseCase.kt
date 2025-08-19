package com.htech.ktorkoin.domain.usecase

import com.htech.ktorkoin.core.Either
import com.htech.ktorkoin.core.Failure
import com.htech.ktorkoin.domain.entity.Post
import com.htech.ktorkoin.domain.repository.PostRepository

class GetPostsUseCase(private val repo: PostRepository) {
    suspend operator fun invoke(): Either<Failure,List<Post>> = repo.getPosts()
}