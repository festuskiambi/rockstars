package com.example.data.source.local

import com.example.data.toEntityUser
import com.example.data.toRoomUser
import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.repository.user.ILocalUserRepository

/**
 * Created by Festus Kiambi on 7/4/19.
 */
class LocalUserRepositoryImpl(private val userDao: RoomUserDao) : ILocalUserRepository {
    override suspend fun getUserById(userId: Int): Result<java.lang.Exception, Entity.User> {
        return  Result.build { userDao.getUserById(userId).toEntityUser }
    }

    override suspend fun createOrUpdateUser(user: Entity.User): Result<Exception, Unit> {
        userDao.insertUser(user.toRoomUser)
        return Result.build { Unit }
    }
}