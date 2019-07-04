package com.example.rockstars.di

import com.example.data.source.local.LocalUserRepositoryImpl
import com.example.domain.repository.user.ILocalUserRepository
import com.example.domain.usecase.user.IUserUseCase
import com.example.domain.usecase.user.UserUseCaseImpl
import com.example.rockstars.profile.viewmodel.UserProfileViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 7/4/19.
 */

val userModule = module {

    factory { UserUseCaseImpl(get()) as IUserUseCase }

    factory { LocalUserRepositoryImpl(get()) as ILocalUserRepository }

    viewModel { UserProfileViewModel(get(), get()) }
}