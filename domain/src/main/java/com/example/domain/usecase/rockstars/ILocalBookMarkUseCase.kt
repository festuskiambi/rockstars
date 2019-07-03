package com.example.domain.usecase.rockstars

import com.example.domain.entity.Entity
import com.example.domain.common.Result

/**
 * Created by Festus Kiambi on 7/3/19.
 */

interface ILocalBookMarkUseCase {

    suspend fun createBookMark(rockStar: Entity.RockStar): Result<Exception, Unit>

    suspend fun getBookmarks(): Result<Exception, List<Entity.RockStar>>

    suspend fun deleteBookMark(rockStar: Entity.RockStar): Result<Exception, Unit>
}