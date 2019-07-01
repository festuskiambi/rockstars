package com.example.domain.usecase.rockstars

import com.example.domain.common.Result
import com.example.domain.entity.Entity
import java.lang.Exception

/**
 * Created by Festus Kiambi on 7/1/19.
 */
interface IRockStarUseCase {

   suspend fun getRockStars(): Result<Exception, List<Entity.RockStar>>

}