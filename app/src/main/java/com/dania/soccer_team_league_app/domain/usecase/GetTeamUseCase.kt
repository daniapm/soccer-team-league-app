package com.dania.soccer_team_league_app.domain.usecase

import com.dania.soccer_team_league_app.commons.Result
import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.domain.repository.TeamRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeamUseCase @Inject constructor(private val teamRepository: TeamRepository) {

    suspend operator fun invoke(): Result<Flow<List<Team>>, Exception> = teamRepository.getTeam()
}