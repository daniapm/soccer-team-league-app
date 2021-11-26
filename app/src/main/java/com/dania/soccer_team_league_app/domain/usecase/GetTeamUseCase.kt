package com.dania.soccer_team_league_app.domain.usecase

import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.domain.repository.TeamRepository

class GetTeamUseCase(private val teamRepository: TeamRepository) {

    suspend operator fun invoke(): List<Team> = teamRepository.getTeam()
}