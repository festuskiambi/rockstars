package com.example.domain.repository.rockstar

import com.example.domain.entity.Entity
import com.example.domain.common.Result
import java.lang.Exception

/**
 * Created by Festus Kiambi on 7/1/19.
 */
interface RockStarRepository {

    fun getRockStars(): Result<Exception, List<Entity.RockStar>>
}