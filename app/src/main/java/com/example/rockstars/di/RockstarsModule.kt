package com.example.rockstars.di

import com.example.data.source.remote.RemoteRemoteRockStarRepositoryImpl
import com.example.domain.repository.rockstar.IRemoteRockStarRepository
import com.example.domain.usecase.rockstars.IRemoteRockStarUseCase
import com.example.domain.usecase.rockstars.RemoteRockStarUseCaseImpl
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 7/2/19.
 */

val rockStarsModule = module {

    factory { RemoteRemoteRockStarRepositoryImpl(get()) as IRemoteRockStarRepository }

    factory { RemoteRockStarUseCaseImpl(get()) as IRemoteRockStarUseCase }



}