package com.example.domain.user

import com.example.domain.common.Result
import com.example.domain.common.RockstarsError
import com.example.domain.entity.Entity
import com.example.domain.repository.user.ILocalUserRepository
import com.example.domain.usecase.user.UserUseCaseImpl
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by Festus Kiambi on 7/4/19.
 */
class UserUseCaseImplTest {

    private val repository: ILocalUserRepository = mockk()

    private val useCase = UserUseCaseImpl(repository)
    private fun getUser(
        id: Int = 0,
        name: String = "Marc",
        picture: String = """
            /storage/emulated/0/Android/data/com.example.rockstars/files/Pictures/JPEG_20190704_103610_1276101381459053152.jpg"""
    ) = Entity.User(id, name, picture)

    @Before
    fun setUpRedundantMocks() {
        clearAllMocks()
    }

    @Test
    fun `On get user by id success`() = runBlocking {
        val testUser = getUser()

        coEvery { repository.getUserById(testUser.id) } returns Result.build { testUser }

        val result = useCase.getUserById(testUser.id)

        coVerify { repository.getUserById(testUser.id) }
        if (result is Result.Value) assertEquals(result.value, testUser)
        else assertTrue { false }

    }

    @Test
    fun `On get user by id fail`() = runBlocking {
        val testUser = getUser()

        coEvery { repository.getUserById(testUser.id) } returns Result.build { throw RockstarsError.LocalIOException }

        val result = useCase.getUserById(testUser.id)

        coVerify { repository.getUserById(testUser.id) }
        assertTrue { result is Result.Error }
    }

    @Test
    fun `On create user `() = runBlocking {
        val testUser = getUser()

        coEvery { repository.createOrUpdateUser(testUser) } returns Result.build { Unit }

        val result = useCase.createOrUpdateUser(testUser)

        coVerify { repository.createOrUpdateUser(testUser) }


        if (result is Result.Value) {
            //assert the value as being "true"
            assertTrue { true }
        } else {
            assertTrue { false }
        }

    }

}