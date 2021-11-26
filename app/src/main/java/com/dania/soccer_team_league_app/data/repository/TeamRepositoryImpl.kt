package com.dania.soccer_team_league_app.data.repository

import com.dania.soccer_team_league_app.commons.Result
import com.dania.soccer_team_league_app.data.remote.datasource.TeamRemoteDataSource
import com.dania.soccer_team_league_app.data.remote.model.mapToDomain
import com.dania.soccer_team_league_app.domain.model.Teams
import com.dania.soccer_team_league_app.domain.repository.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class TeamRepositoryImpl(private val remoteDataSource: TeamRemoteDataSource) : TeamRepository {
    override suspend fun getTeam(): Result<Teams, Exception> = try {
        val teams = withContext(Dispatchers.IO) {
            remoteDataSource.teamRepositoryApi.getTeam().mapToDomain()
        }
        Result.Success(teams)
    } catch (e: Exception) {
        Result.Error(e)
    }
}
