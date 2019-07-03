package com.example.domain.usecase.rockstars

import com.example.domain.entity.Entity
import com.example.domain.common.Result

/**
 * Created by Festus Kiambi on 7/3/19.
 */

interface ILocalBookMarkUseCase {

    fun createBookMark(rockStar: Entity.RockStar): Result<Exception, Unit>
}