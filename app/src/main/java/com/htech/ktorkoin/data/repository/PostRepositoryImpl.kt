package com.htech.ktorkoin.data.repository

import com.htech.ktorkoin.core.Either
import com.htech.ktorkoin.core.Failure
import com.htech.ktorkoin.core.Mapper
import com.htech.ktorkoin.data.dto.NewPostRequest
import com.htech.ktorkoin.data.dto.PostDto
import com.htech.ktorkoin.data.remote.PostRemoteDataSource
import com.htech.ktorkoin.domain.entity.Post
import com.htech.ktorkoin.domain.repository.PostRepository


class DtoToEntityMapper : Mapper<PostDto, Post> {
    override fun map(input: PostDto): Post=Post (
        userId = input.userId,
        id = input.id ?: -1,
        title = input.title,
        body = input.body
    )

}

class PostRepositoryImpl (
    private val remote: PostRemoteDataSource,
    private val mapper: Mapper<PostDto,Post> = DtoToEntityMapper()
) : PostRepository {
    override suspend fun getPosts(): Either<Failure, List<Post>> {
       return when(val res =remote.getPosts()){
            is Either.Left -> res
            is Either.Right -> Either.Right(res.value.map { mapper.map(it) })
        }
    }

    override suspend fun createPost(
        userId: Int,
        title: String,
        body: String
    ): Either<Failure, Post> {
        return when(val res =remote.createPost(NewPostRequest(userId, title, body))){
            is Either.Left -> res
            is Either.Right -> Either.Right(mapper.map(res.value))
        }
    }

}