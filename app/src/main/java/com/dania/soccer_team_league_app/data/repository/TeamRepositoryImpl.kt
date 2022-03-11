package com.dania.soccer_team_league_app.data.repository

import com.dania.soccer_team_league_app.commons.NetworkUtil
import com.dania.soccer_team_league_app.commons.Result
import com.dania.soccer_team_league_app.data.db.TeamDao
import com.dania.soccer_team_league_app.data.db.mapToDomain
import com.dania.soccer_team_league_app.data.remote.datasource.TeamRemoteDataSource
import com.dania.soccer_team_league_app.data.remote.model.mapToData
import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.domain.repository.TeamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val remoteDataSource: TeamRemoteDataSource,
    private val teamDao: TeamDao,
    private val networkUtil: NetworkUtil
) : TeamRepository {

    override suspend fun getTeam(): Result<Flow<List<Team>>, java.lang.Exception> = try {
        if (networkUtil.hasConnection()) {
            val teams = withContext(Dispatchers.IO) {
                remoteDataSource.teamRepositoryApi.getTeam().mapToData()
            }
            teamDao.insertAll(teams)
        }
        Result.Success(teamDao.getAllTeam().map { teams -> teams.map { it.mapToDomain() } })
    } catch (e: Exception) {
        Result.Error(e)
    }
}
