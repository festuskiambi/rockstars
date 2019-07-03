package com.example.data.source.local

import com.example.data.toLocalEntityRockStarList
import com.example.data.toRoomRockStar
import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.repository.rockstar.ILocalRockStarRepository

/**
 * Created by Festus Kiambi on 7/3/19.
 */

class LocalRockStarRepositoryImpl(private val rockStarDao: RoomRockStarDao): ILocalRockStarRepository{

    override suspend fun createBookMark(rockStar: Entity.RockStar): Result<Exception, Unit> {
        rockStarDao.insertRockStar(rockStar.toRoomRockStar)
        return Result.build { Unit }
    }

    override suspend fun getBookmarks(): Result<Exception, List<Entity.RockStar>> {
        return Result.build {  rockStarDao.getRockStars().toLocalEntityRockStarList()}
    }

    override suspend fun deleteBookMark(rockStar: Entity.RockStar): Result<Exception, Unit> {
        rockStarDao.deleteRockStar(rockStar.toRoomRockStar)
        return Result.build { Unit }
    }

}