package com.dania.soccer_team_league_app.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dania.soccer_team_league_app.commons.Result
import com.dania.soccer_team_league_app.commons.getOrAwaitValue
import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.domain.usecase.GetTeamUseCase
import com.dania.soccer_team_league_app.presentation.viewmodel.TeamEvent
import com.dania.soccer_team_league_app.presentation.viewmodel.TeamViewModel
import com.dania.soccer_team_league_app.teams
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

@ExperimentalCoroutinesApi
class TeamViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK
    private lateinit var getTeamUseCase: GetTeamUseCase

    private lateinit var viewModel: TeamViewModel

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        MockKAnnotations.init(this@TeamViewModelTest)
        Dispatchers.setMain(testDispatcher)
        viewModel = TeamViewModel(getTeamUseCase)
    }

    @Test
    fun `when use case is result success`() {
        coEvery {
            getTeamUseCase.invoke()
        } returns teams as Result<Flow<List<Team>>, Exception>

        viewModel.getTeam()

        Assert.assertTrue(viewModel.event.getOrAwaitValue() is TeamEvent.SetTeams)
    }

    @Test
    fun `when use case is result error`() {
        coEvery {
            getTeamUseCase.invoke()
        } returns Result.Error(Exception())

        viewModel.getTeam()

        Assert.assertTrue(viewModel.event.getOrAwaitValue() is TeamEvent.ShowError)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}