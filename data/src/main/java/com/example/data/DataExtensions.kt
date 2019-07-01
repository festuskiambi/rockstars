package com.example.data

import com.example.data.datamodels.ApiRockStar
import com.example.domain.entity.Entity

/**
 * Created by Festus Kiambi on 7/1/19.
 */

internal val ApiRockStar.toEntityRockStar : Entity.RockStar
get() = Entity.RockStar(
    this.id ,
    this.index,
    this.name,
    this.picture,
    this.about
)

internal fun List<ApiRockStar>.toEntityRockstarList(): List<Entity.RockStar> = this.flatMap {
    listOf(it.toEntityRockStar)
}