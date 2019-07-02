package com.example.rockstars.di

import com.example.data.source.remote.ApiInterface
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Festus Kiambi on 7/2/19.
 */

val networkModule = module {
    factory { OkHttpClient.Builder().addInterceptor(get()).build() }

    single {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    factory{ get<Retrofit>().create(ApiInterface::class.java) }
}







