package com.htech.ktorkoin.presentation.di

import com.htech.ktorkoin.presentation.viewModel.PostViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::PostViewModel)
}