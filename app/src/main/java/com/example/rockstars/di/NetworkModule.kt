package com.example.rockstars.di

import com.example.data.source.remote.ApiInterface
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Festus Kiambi on 7/2/19.
 */

val networkModule = module {

    factory { OkHttpClient.Builder().build() }

    factory {  Moshi.Builder().add(KotlinJsonAdapterFactory()).build()}


    single {
        Retrofit.Builder()
            .baseUrl("https://api.myjson.com/bins/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    factory{ get<Retrofit>().create(ApiInterface::class.java) }
}







