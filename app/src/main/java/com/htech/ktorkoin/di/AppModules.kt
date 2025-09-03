package com.htech.ktorkoin.di

import com.htech.ktorkoin.data.di.dataModule
import com.htech.ktorkoin.domain.di.domainModule
import com.htech.ktorkoin.presentation.di.presentationModule

val appModules = listOf(dataModule, domainModule, presentationModule)