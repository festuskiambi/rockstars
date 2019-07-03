package com.example.domain.usecase.user

import com.example.domain.common.Result
import com.example.domain.entity.Entity

/**
 * Created by Festus Kiambi on 7/3/19.
 */
interface ILocalUserUseCase {

    suspend fun createOrUpdateUser(user: Entity.User): Result<Exception, Unit>
}