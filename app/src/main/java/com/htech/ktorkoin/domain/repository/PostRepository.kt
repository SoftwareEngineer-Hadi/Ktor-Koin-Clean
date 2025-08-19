package com.htech.ktorkoin.domain.repository

import com.htech.ktorkoin.core.Either
import com.htech.ktorkoin.core.Failure
import com.htech.ktorkoin.domain.entity.Post

interface PostRepository {
    suspend fun getPosts(): Either<Failure,List<Post>>
    suspend fun createPost(userId:Int,title:String,body:String):Either<Failure,Post>
}