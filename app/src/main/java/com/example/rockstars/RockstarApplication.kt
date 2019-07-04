package com.example.rockstars

import android.app.Application
import com.example.rockstars.di.localModule
import com.example.rockstars.di.networkModule
import com.example.rockstars.di.rockStarsModule
import com.example.rockstars.di.userModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Festus Kiambi on 7/2/19.
 */
class RockstarApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@RockstarApplication)
            // declare modules
            modules(listOf(networkModule, rockStarsModule, localModule, userModule))
        }

    }
}