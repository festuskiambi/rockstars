package com.example.rockstars.di

import com.example.data.source.local.LocalRockStarRepositoryImpl
import com.example.data.source.remote.RemoteRockStarRepositoryImpl
import com.example.domain.repository.rockstar.ILocalRockStarRepository
import com.example.domain.repository.rockstar.IRemoteRockStarRepository
import com.example.domain.usecase.rockstars.ILocalBookMarkUseCase
import com.example.domain.usecase.rockstars.IRemoteRockStarUseCase
import com.example.domain.usecase.rockstars.LocalBookMarkUseCaseImpl
import com.example.domain.usecase.rockstars.RemoteRockStarUseCaseImpl
import com.example.rockstars.base.AppDispatchers
import com.example.rockstars.bookmarks.viewmodel.BookmarkViewModel
import com.example.rockstars.home.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 7/2/19.
 */

val rockStarsModule = module {

    factory { RemoteRockStarRepositoryImpl(get()) as IRemoteRockStarRepository }

    factory { RemoteRockStarUseCaseImpl(get()) as IRemoteRockStarUseCase }

    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }

    viewModel { HomeViewModel(get(), get(), get()) }

    factory { LocalRockStarRepositoryImpl(get()) as ILocalRockStarRepository }

    factory { LocalBookMarkUseCaseImpl(get()) as ILocalBookMarkUseCase }

    viewModel { BookmarkViewModel(get(), get()) }

}
