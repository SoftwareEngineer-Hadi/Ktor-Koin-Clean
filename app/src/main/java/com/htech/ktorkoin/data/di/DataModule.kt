package com.htech.ktorkoin.data.di

import com.htech.ktorkoin.data.remote.ApiRoutes
import com.htech.ktorkoin.data.remote.KtorClientFactory
import com.htech.ktorkoin.data.remote.PostRemoteDataSource
import com.htech.ktorkoin.data.remote.PostRemoteDataSourceImpl
import com.htech.ktorkoin.data.repository.PostRepositoryImpl
import com.htech.ktorkoin.domain.repository.PostRepository
import org.koin.dsl.module

val dataModule = module {
    single { KtorClientFactory.create(ApiRoutes.BASE_URL) }
    single<PostRemoteDataSource> { PostRemoteDataSourceImpl(get()) }
    single<PostRepository> { PostRepositoryImpl(get()) }
}