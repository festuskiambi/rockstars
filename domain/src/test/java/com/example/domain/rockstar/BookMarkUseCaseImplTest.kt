package com.example.domain.rockstar

import com.example.domain.entity.Entity
import com.example.domain.common.Result
import com.example.domain.common.RockstarsError

import com.example.domain.repository.rockstar.ILocalRockStarRepository
import com.example.domain.usecase.rockstars.BookMarkUseCaseImpl
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/**
 * Created by Festus Kiambi on 7/4/19.
 */

class BookMarkUseCaseImplTest {

    private val repository: ILocalRockStarRepository = mockk()

    private val useCase = BookMarkUseCaseImpl(repository)

    private fun getRockStar(
        id: String = "5d134ac7d79b92c00074f892",
        index: Int = 0,
        picture: String = """
        https://optimetriks.com/wp-content/uploads/2017/06/Screenshot-2019-05-10-at-16.49.22-e1557496456531-540x540.png
        """,
        name: String = "Marc",
        about: String = "CCO"
    ) = Entity.RockStar(id, index, name, picture, about)

    @Before
    fun setUpRedundantMocks() {
        clearAllMocks()
    }


    @Test
    fun `On get rockStars success`() = runBlocking {
        val bookmarkList = listOf(getRockStar(), getRockStar())
        coEvery { repository.getBookmarks() } returns Result.build { bookmarkList }

        val result = useCase.getBookmarks()

        coVerify { repository.getBookmarks() }
        if (result is Result.Value) assertEquals(result.value, bookmarkList)
        else assertTrue { false }
    }

    @Test
    fun `On get rockStars error`() = runBlocking {
        coEvery { repository.getBookmarks() } returns Result.build { throw RockstarsError.LocalIOException }

        val result = useCase.getBookmarks()

        coVerify { repository.getBookmarks() }
        assertTrue { result is Result.Error }
    }

    @Test
    fun `on delete a bookmark`() = runBlocking {
        val testRockstar = getRockStar()

        coEvery { repository.deleteBookMark(testRockstar) } returns Result.build { Unit }

        val result = useCase.deleteBookMark(testRockstar)

        coVerify { repository.deleteBookMark(testRockstar) }

        if (result is Result.Value) {
            //assert the value as being "true"
            assertTrue { true }
        } else {
            assertTrue { false }
        }
    }


    @Test
    fun `on create a bookmark`() = runBlocking {
        val testRockstar = getRockStar()

        coEvery { repository.createBookMark(testRockstar) } returns Result.build { Unit }

        val result = useCase.createBookMark(testRockstar)

        coVerify { repository.createBookMark(testRockstar) }

        if (result is Result.Value) {
            //assert the value as being "true"
            assertTrue { true }
        } else {
            assertTrue { false }
        }
    }
}