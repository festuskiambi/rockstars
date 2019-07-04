package com.example.data

import com.example.data.datamodels.RoomRockStar
import com.example.data.source.local.LocalRockStarRepositoryImpl
import com.example.data.source.local.RoomRockStarDao
import com.example.domain.common.Result
import com.example.domain.entity.Entity
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
class LocalRockStarRepositoryImplTest {

    private val rockStarDao: RoomRockStarDao = mockk()
    private val repository = LocalRockStarRepositoryImpl(rockStarDao)

    private fun getRockStar(
        id: String = "5d134ac7d79b92c00074f892",
        index: Int = 0,
        picture: String = """
        https://optimetriks.com/wp-content/uploads/2017/06/Screenshot-2019-05-10-at-16.49.22-e1557496456531-540x540.png
        """,
        name: String = "Marc",
        about: String = "CCO"
    ) = Entity.RockStar(id, index, name, picture, about)

    private fun getRoomRockStar(
        id: String = "5d134ac7d79b92c00074f892",
        index: Int = 0,
        name: String = "Marc",
        picture: String = """
        https://optimetriks.com/wp-content/uploads/2017/06/Screenshot-2019-05-10-at-16.49.22-e1557496456531-540x540.png
        """,
        about: String = "CCO"
    ) = RoomRockStar(id, index, name, picture, about)

    @Before
    fun setUpRedundantMocks() {
        clearAllMocks()
    }


    @Test
    fun `on get bookmarks success`() = runBlocking {
        val roomRockStarsList = listOf(getRoomRockStar())
        val rockStarsList = listOf(getRockStar())

        coEvery { rockStarDao.getRockStars() } returns roomRockStarsList

        val result = repository.getBookmarks()

        coVerify { rockStarDao.getRockStars() }
        if (result is Result.Value) assertEquals(result.value, rockStarsList)
        else assertTrue { false }
    }


    @Test
    fun `on create bookmark`() = runBlocking {
        val testBookmark = getRockStar()
        val testRoomRockStar = getRoomRockStar()

        coEvery { rockStarDao.insertRockStar(testRoomRockStar) } returns 0

        repository.createBookMark(testBookmark)

        coVerify { rockStarDao.insertRockStar(testRoomRockStar) }
    }

    @Test
    fun `on delete bookmark`() = runBlocking {
        val testBookmark = getRockStar()
        val testRoomRockStar = getRoomRockStar()

        coEvery { rockStarDao.deleteRockStar(testRoomRockStar) } returns Unit

        repository.deleteBookMark(testBookmark)

        coVerify { rockStarDao.deleteRockStar(testRoomRockStar) }
    }
}