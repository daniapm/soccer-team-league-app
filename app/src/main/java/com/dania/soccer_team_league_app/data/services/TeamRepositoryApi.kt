package com.dania.soccer_team_league_app.data.services

import com.dania.soccer_team_league_app.data.remote.model.TeamsResponse
import retrofit2.http.GET

interface TeamRepositoryApi {

    @GET("search_all_teams.php?l=Spanish%20La%20Liga")
    suspend fun getTeam(): TeamsResponse

}
