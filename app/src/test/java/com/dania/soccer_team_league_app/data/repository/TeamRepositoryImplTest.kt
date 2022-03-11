package com.dania.soccer_team_league_app.data.repository

import com.dania.soccer_team_league_app.commons.NetworkUtil
import com.dania.soccer_team_league_app.data.db.TeamDao
import com.dania.soccer_team_league_app.data.db.TeamData
import com.dania.soccer_team_league_app.data.remote.datasource.TeamRemoteDataSource
import com.dania.soccer_team_league_app.data.remote.model.TeamResponse
import com.dania.soccer_team_league_app.domain.repository.TeamRepository
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TeamRepositoryImplTest : TestCase() {

    lateinit var teamRepository: TeamRepository

    //Mock Api
    lateinit var remoteDataSource: TeamRemoteDataSource
    lateinit var teamFromApi: TeamResponse

    //Mock Dao
    lateinit var teamDao: TeamDao
    lateinit var teamFromDao: Flow<List<TeamData>>

    lateinit var networkUtil: NetworkUtil

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    override fun setUp() {
        //Mocking remoteDataSource
        remoteDataSource = mock()
        teamFromApi = TeamResponse(
            "name", "stadium", "badge",
            "descripcion", "year", "jersey",
            "website", "facebook", "instagram", "twiter"
        )

        Dispatchers.setMain(testDispatcher)
        runBlocking {
            whenever(remoteDataSource.teamRepositoryApi.getTeam()).thenReturn(teamFromApi)
        }

        //Mocking TeamDao
        teamDao = mock()
        teamFromDao = TeamData(
            1, "name", "stadium", "badge",
            "descripcion", "year", "jersey",
            "website", "facebook", "instagram", "twiter"
        ) as Flow<List<TeamData>>
        whenever(teamDao.getAllTeam()).thenReturn(teamFromDao)

        networkUtil = mock()
        teamRepository = TeamRepositoryImpl(remoteDataSource, teamDao, networkUtil)

    }

    @Test
    suspend fun `repository Asks For TeamToDao`() {
        teamRepository.getTeam()
        //Verificamos que se llame al metodo siquiera una vez
        verify(teamDao, times(1)).getAllTeam()
    }

    @Test
    suspend fun `if Dao Returns Team Then Repository Returns SameTeam`() {
        val team = teamRepository.getTeam()
        assertEquals(team, teamFromDao)
    }

    @Test(expected = IllegalStateException::class)
    suspend fun `when Dao Fails Recovering Team An IllegalStateException Is Thrown`() {
        doAnswer { throw IllegalStateException() }.`when`(teamDao).getAllTeam()
        teamRepository.getTeam()
    }

    @Test
    suspend fun `when Dao Fails Recovering Team The Exception Is Propagated`() {
        val exception = IllegalStateException()
        doAnswer { throw exception }.`when`(teamDao).getAllTeam()

        try {
            teamRepository.getTeam()
            fail()
        } catch (e: Exception) {
            assertEquals(e, exception)
        }
    }
}
