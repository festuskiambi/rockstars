package com.example.data.source.remote

import com.example.data.datamodels.ApiRockStar
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Festus Kiambi on 7/1/19.
 */
interface ApiInterface {

    @GET("https://api.myjson.com/bins/19791b")
    suspend fun getRockSatars(): Response<List<ApiRockStar>>
}