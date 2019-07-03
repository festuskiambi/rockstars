package com.example.domain.usecase.rockstars

import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.repository.rockstar.ILocalRockStarRepository

/**
 * Created by Festus Kiambi on 7/3/19.
 */
class LocalBookMarkUseCaseImpl(private val repository: ILocalRockStarRepository): ILocalBookMarkUseCase {
    override fun createBookMark(rockStar: Entity.RockStar): Result<Exception, Unit> {
        return  repository.createBookMark(rockStar)
    }
}