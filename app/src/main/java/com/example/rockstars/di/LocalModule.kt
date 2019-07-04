package com.example.rockstars.di

import androidx.room.Room
import com.example.data.source.local.RockStarDataBase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

/**
 * Created by Festus Kiambi on 7/3/19.
 */

val localModule = module {
    single {
        Room.databaseBuilder(androidContext(), RockStarDataBase::class.java, "RockStarApp.db")
            .build()
    }

    single { (get<RockStarDataBase>().rockStarDao()) }

    single { (get<RockStarDataBase>().userDao()) }
}