package com.htech.ktorkoin.data.remote

import com.htech.ktorkoin.core.Either
import com.htech.ktorkoin.core.Failure
import com.htech.ktorkoin.data.dto.NewPostRequest
import com.htech.ktorkoin.data.dto.PostDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

interface PostRemoteDataSource {
    suspend fun getPosts(): Either<Failure, List<PostDto>>
    suspend fun createPost(body: NewPostRequest): Either<Failure, PostDto>
}

class PostRemoteDataSourceImpl(
    private val client: HttpClient
) : PostRemoteDataSource {
    override suspend fun getPosts(): Either<Failure, List<PostDto>> {
        return safeCall {
            client.get { ApiRoutes.POSTS }
        }
    }

    override suspend fun createPost(body: NewPostRequest): Either<Failure, PostDto> {
        return safeCall {
            client.post(ApiRoutes.POSTS) {
                setBody(body)
            }
        }
    }

    private suspend inline fun <reified T> safeCall(crossinline block: suspend () -> HttpResponse): Either<Failure, T> {
        return try {
            val response = block()
            if (response.status.isSuccess()) {
                Either.Right(response.body())
            } else {
                Either.Left(Failure.Server("HTTP ${response.status.value}"))
            }
        } catch (e: Exception) {
            val failure = when (e) {
                is kotlinx.serialization.SerializationException -> Failure.Serialization(e.message)
                is java.net.UnknownHostException,
                is java.net.SocketTimeoutException -> Failure.Network(e.message)

                else -> Failure.Unknown(e.message)
            }
            Either.Left(failure)
        }
    }

}