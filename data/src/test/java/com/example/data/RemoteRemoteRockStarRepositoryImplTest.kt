package com.example.data

import com.example.data.datamodels.ApiRockStar
import com.example.data.source.remote.ApiInterface
import com.example.data.source.remote.RemoteRemoteRockStarRepositoryImpl
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
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class RemoteRemoteRockStarRepositoryImplTest {

    private val apiInterface: ApiInterface = mockk()
    val repository = RemoteRemoteRockStarRepositoryImpl(apiInterface)

    fun getRockStar(
        id: String = "5d134ac7d79b92c00074f892",
        index: Int = 0,
        picture: String = """
        https://optimetriks.com/wp-content/uploads/2017/06/Screenshot-2019-05-10-at-16.49.22-e1557496456531-540x540.png
        """,
        name: String = "Marc",
        about: String = "CCO"
    ) = Entity.RockStar(id, index, name, picture, about)

    fun getApiRockStar(
        id: String = "5d134ac7d79b92c00074f892",
        index: Int = 0,
        picture: String = """
        https://optimetriks.com/wp-content/uploads/2017/06/Screenshot-2019-05-10-at-16.49.22-e1557496456531-540x540.png
        """,
        name: String = "Marc",
        about: String = "CCO"
    ) = ApiRockStar(name,about,index,id,picture)

    @Before
    fun setUpRedundantMocks() {
        clearAllMocks()
    }

    @Test
    fun `on get remote rockStars success`() = runBlocking {

        val apiRockStarsList = listOf(getApiRockStar())

        val rockStarsList = listOf(getRockStar())

        coEvery { apiInterface.getRockStars().body() } returns apiRockStarsList

        val result = repository.getRockStars()

        coVerify { apiInterface.getRockStars() }
        if (result is Result.Value) assertEquals(result.value, rockStarsList)
        else assertTrue { false }
    }


    @Test
    fun `on get remote rockStars failure`() = runBlocking {

        coEvery { apiInterface.getRockStars().body()} returns null

        val result = repository.getRockStars()

        coVerify { apiInterface.getRockStars() }
        assertTrue { result is Result.Error }
    }

}