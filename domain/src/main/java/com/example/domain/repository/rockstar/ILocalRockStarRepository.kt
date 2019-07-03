package com.example.domain.repository.rockstar

import com.example.domain.common.Result
import com.example.domain.entity.Entity

/**
 * Created by Festus Kiambi on 7/3/19.
 */
interface ILocalRockStarRepository {

  suspend fun createBookMark(rockStar: Entity.RockStar): Result<Exception, Unit>

  suspend fun getBookmarks(): Result<Exception, List<Entity.RockStar>>

  suspend fun deleteBookMark(rockStar: Entity.RockStar): Result<Exception, Unit>
}