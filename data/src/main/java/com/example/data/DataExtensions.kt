package com.example.data

import com.example.data.datamodels.ApiRockStar
import com.example.data.datamodels.RoomRockStar
import com.example.data.datamodels.RoomUser
import com.example.domain.entity.Entity

/**
 * Created by Festus Kiambi on 7/1/19.
 */

internal val ApiRockStar.toEntityRockStar: Entity.RockStar
    get() = Entity.RockStar(
        this.id,
        this.index,
        this.name,
        this.picture,
        this.about
    )

internal val RoomRockStar.toEntityRockStar: Entity.RockStar
    get() = Entity.RockStar(
        this.id,
        this.index,
        this.name,
        this.picture,
        this.about
    )

internal val Entity.RockStar.toRoomRockStar: RoomRockStar
    get() = RoomRockStar(
        this.id,
        this.index,
        this.name,
        this.picture,
        this.about
    )

internal val Entity.User.toRoomUser: RoomUser
    get() = RoomUser(
        this.id,
        this.name,
        this.picture
    )

internal val RoomUser.toEntityUser: Entity.User
    get() = Entity.User(
        this.id,
        this.name,
        this.picture
    )

internal fun List<ApiRockStar>.toRemoteEntityRockstarList(): List<Entity.RockStar> = this.flatMap {
    listOf(it.toEntityRockStar)
}

internal fun List<RoomRockStar>.toLocalEntityRockStarList(): List<Entity.RockStar> = this.flatMap {
    listOf(it.toEntityRockStar)
}