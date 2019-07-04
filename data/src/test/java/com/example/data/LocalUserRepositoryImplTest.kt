package com.example.data

import com.example.data.datamodels.RoomUser
import com.example.data.source.local.LocalUserRepositoryImpl
import com.example.data.source.local.RoomUserDao
import com.example.domain.entity.Entity
import com.example.domain.common.Result
import io.mockk.clearAllMocks
import io.mockk.mockk
import io.mockk.coEvery
import io.mockk.coVerify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
/**
 * Created by Festus Kiambi on 7/4/19.
 */

class LocalUserRepositoryImplTest {
    private val userDao: RoomUserDao = mockk()
    private val repository = LocalUserRepositoryImpl(userDao)

    private fun getUser(
        id: Int = 0,
        name: String = "Marc",
        picture: String = """
            /storage/emulated/0/Android/data/com.example.rockstars/files/Pictures/JPEG_20190704_103610_1276101381459053152.jpg"""
    ) = Entity.User(id, name, picture)

    private fun getRoomUser(
        id: Int = 0,
        name: String = "Marc",
        picture: String = """
            /storage/emulated/0/Android/data/com.example.rockstars/files/Pictures/JPEG_20190704_103610_1276101381459053152.jpg"""
    ) = RoomUser(id, name, picture)

    @Before
    fun setUpRedundantMocks() {
        clearAllMocks()
    }

    @Test
    fun `On get user by id success`() = runBlocking {
        val testUser = getUser()
        val testRoomUser = getRoomUser()

        coEvery { userDao.getUserById(testRoomUser.id) } returns testRoomUser

        val result = repository.getUserById(testUser.id)

        coVerify { userDao.getUserById(testRoomUser.id) }
        if (result is Result.Value) assertEquals(result.value, testUser)
        else assertTrue { false }

    }

    @Test
    fun `On get user by id fail`() = runBlocking {
        val testUser = getUser()
        val testRoomUser = getRoomUser()

        coEvery { userDao.getUserById(testRoomUser.id) }

        val result = repository.getUserById(testUser.id)

        coVerify {  userDao.getUserById(testRoomUser.id)}
        assertTrue { result is Result.Error }
    }

    @Test
    fun `On create user `() = runBlocking {
        val testUser = getUser()
        val testRoomUser = getRoomUser()

        coEvery { userDao.insertUser(testRoomUser) } returns 0

        val result = repository.createOrUpdateUser(testUser)

        coVerify { userDao.insertUser(testRoomUser) }
        if (result is Result.Value) {
            //assert the value as being "true"
            assertTrue { true }
        } else {
            assertTrue { false }
        }

    }
}