package com.dania.soccer_team_league_app.data.repository

import com.dania.soccer_team_league_app.data.remote.model.TeamResponse
import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.domain.repository.TeamRepository
import retrofit2.http.GET

interface TeamRepositoryApi {

    @GET("search_all_teams.php?l=Spanish%20La%20Liga")
    suspend fun getTeam(): List<TeamResponse>

}
