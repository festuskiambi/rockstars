package com.example.rockstars.di

import com.example.data.source.local.LocalUserRepositoryImpl
import com.example.domain.repository.user.ILocalUserRepository
import com.example.domain.usecase.user.ILocalUserUseCase
import com.example.domain.usecase.user.LocalUserUseCaseImpl
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 7/4/19.
 */

val userModule = module {

    factory { LocalUserUseCaseImpl(get()) as ILocalUserUseCase }

    factory { LocalUserRepositoryImpl(get()) as ILocalUserRepository }
}