package com.example.domain.usecase.rockstars

import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.repository.rockstar.IRemoteRockStarRepository
import java.lang.Exception

/**
 * Created by Festus Kiambi on 7/1/19.
 */
class RemoteRockStarUseCaseImpl(private val repository: IRemoteRockStarRepository): IRemoteRockStarUseCase {
    override suspend fun getRockStars(): Result<Exception, List<Entity.RockStar>> {
      return  repository.getRockStars()
    }
}