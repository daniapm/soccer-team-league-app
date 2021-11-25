package com.dania.soccer_team_league_app.data

import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.domain.repository.TeamRepository

class TeamRepositoryImpl : TeamRepository {
    override suspend fun getTeam(): List<Team> {
        TODO("Not yet implemented")
    }
}
