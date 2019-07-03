package com.example.domain.usecase.user

import com.example.domain.common.Result
import com.example.domain.entity.Entity
import com.example.domain.repository.user.ILocalUserRepository

/**
 * Created by Festus Kiambi on 7/3/19.
 */
class LocalUserUseCaseImpl(private val iLocalUserRepository: ILocalUserRepository): ILocalUserUseCase {
    override suspend fun createOrUpdateUser(user: Entity.User): Result<Exception, Unit> {
        return iLocalUserRepository.createOrUpdateUser(user)
    }
}