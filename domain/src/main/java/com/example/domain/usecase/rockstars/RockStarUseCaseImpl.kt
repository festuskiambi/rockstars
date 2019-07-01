package com.example.domain.usecase.rockstars

import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.repository.rockstar.IRockStarRepository
import java.lang.Exception

/**
 * Created by Festus Kiambi on 7/1/19.
 */
class RockStarUseCaseImpl(val repository: IRockStarRepository): IRockStarUseCase {
    override suspend fun getRockStars(): Result<Exception, List<Entity.RockStar>> {
      return  repository.getRockStars()
    }
}