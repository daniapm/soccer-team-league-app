package com.dania.soccer_team_league_app.data.repository

import com.dania.soccer_team_league_app.data.remote.datasource.TeamRemoteDataSource
import com.dania.soccer_team_league_app.data.remote.model.mapToDomain
import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.domain.repository.TeamRepository

class TeamRepositoryImpl(private val remoteDataSource: TeamRemoteDataSource) : TeamRepository {
    override suspend fun getTeam(): List<Team> {
        return remoteDataSource.teamRepositoryApi.getTeam().map { it.mapToDomain() }
    }
}
