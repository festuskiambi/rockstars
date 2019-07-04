package com.example.domain.rockstar

import com.example.domain.entity.Entity
import com.example.domain.repository.rockstar.IRemoteRockStarRepository
import com.example.domain.usecase.rockstars.RockStarUseCaseImpl
import com.example.domain.common.Result
import com.example.domain.common.RockstarsError
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by Festus Kiambi on 7/1/19.
 */
class RockStarUseCaseImplTest {

    private val repositoryRemote: IRemoteRockStarRepository = mockk()

    val useCase = RockStarUseCaseImpl(repositoryRemote)

    fun getRockStar(
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
        val rockStarList = listOf(getRockStar(), getRockStar())
        coEvery { repositoryRemote.getRockStars() } returns Result.build { rockStarList }

        val result = useCase.getRockStars()

        coVerify { repositoryRemote.getRockStars() }
        if (result is Result.Value) assertEquals(result.value, rockStarList)
        else assertTrue { false }
    }

    @Test
    fun `On get rockStars error`() = runBlocking {
        coEvery { repositoryRemote.getRockStars() } returns Result.build { throw RockstarsError.RemoteIOException }

        val  result = useCase.getRockStars()

        coVerify { repositoryRemote.getRockStars() }
        assertTrue { result is Result.Error }
    }
}