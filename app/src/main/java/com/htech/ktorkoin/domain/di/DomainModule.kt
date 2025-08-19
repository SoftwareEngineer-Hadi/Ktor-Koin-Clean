package com.htech.ktorkoin.domain.di

import com.htech.ktorkoin.domain.usecase.CreatePostUseCase
import com.htech.ktorkoin.domain.usecase.GetPostsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetPostsUseCase(get()) }
    factory { CreatePostUseCase(get()) }
}