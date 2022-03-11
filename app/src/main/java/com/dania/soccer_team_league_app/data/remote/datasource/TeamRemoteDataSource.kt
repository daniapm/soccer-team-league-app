package com.dania.soccer_team_league_app.data.remote.datasource

import com.dania.soccer_team_league_app.data.di.provider.ServiceFactory
import com.dania.soccer_team_league_app.data.services.TeamRepositoryApi
import javax.inject.Inject

class TeamRemoteDataSource @Inject constructor() {
    val teamRepositoryApi: TeamRepositoryApi by lazy {
        ServiceFactory.provideTeamRepositoryApi()
    }
}