package com.example.domain.usecase.rockstars

import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.repository.rockstar.ILocalRockStarRepository

/**
 * Created by Festus Kiambi on 7/3/19.
 */
class LocalBookMarkUseCaseImpl(private val repository: ILocalRockStarRepository): ILocalBookMarkUseCase {
    override suspend fun getBookmarks(): Result<Exception, List<Entity.RockStar>> {
        return  repository.getBookmarks()
    }

    override suspend fun deleteBookMark(rockStar: Entity.RockStar): Result<Exception, Unit> {
        return repository.deleteBookMark(rockStar)
    }

    override suspend fun createBookMark(rockStar: Entity.RockStar): Result<Exception, Unit> {
        return  repository.createBookMark(rockStar)
    }
}