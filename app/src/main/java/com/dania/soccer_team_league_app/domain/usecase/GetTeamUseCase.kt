package com.dania.soccer_team_league_app.domain.usecase

import com.dania.soccer_team_league_app.commons.Result
import com.dania.soccer_team_league_app.domain.model.Teams
import com.dania.soccer_team_league_app.domain.repository.TeamRepository
import java.lang.Exception

class GetTeamUseCase(private val teamRepository: TeamRepository) {

    suspend operator fun invoke(): Result<Teams, Exception> = teamRepository.getTeam()
}