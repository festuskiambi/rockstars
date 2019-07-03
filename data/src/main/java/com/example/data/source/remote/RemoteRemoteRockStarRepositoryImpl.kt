package com.example.data.source.remote

import com.example.data.toRemoteEntityRockstarList
import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.repository.rockstar.IRemoteRockStarRepository

/**
 * Created by Festus Kiambi on 7/1/19.
 */

class RemoteRemoteRockStarRepositoryImpl(private val apiInterface: ApiInterface) : IRemoteRockStarRepository {
    override suspend fun getRockStars(): Result<Exception, List<Entity.RockStar>> {
        val res = apiInterface.getRockStars().body()
        return Result.build { apiInterface.getRockStars().body()!!.toRemoteEntityRockstarList() }
    }
}