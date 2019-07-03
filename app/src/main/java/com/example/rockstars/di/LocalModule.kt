package com.example.rockstars.di

import com.example.data.source.local.RockStarDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 7/3/19.
 */

val localModule = module {
    single { RockStarDataBase.buildDatabase(androidContext()) }
    factory { (get() as RockStarDataBase).RoomRockStarDao() }
}