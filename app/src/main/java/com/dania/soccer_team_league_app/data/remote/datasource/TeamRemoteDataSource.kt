package com.dania.soccer_team_league_app.data.remote.datasource

import com.dania.soccer_team_league_app.data.di.ServiceFactory
import com.dania.soccer_team_league_app.data.services.TeamRepositoryApi

class TeamRemoteDataSource {
    val teamRepositoryApi : TeamRepositoryApi by lazy {
        ServiceFactory.createRepository(TeamRepositoryApi::class.java)
    }
}