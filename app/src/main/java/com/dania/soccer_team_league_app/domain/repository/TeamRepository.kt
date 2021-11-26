package com.dania.soccer_team_league_app.domain.repository

import com.dania.soccer_team_league_app.commons.Result
import com.dania.soccer_team_league_app.domain.model.Teams
import java.lang.Exception

interface TeamRepository {

    suspend fun getTeam(): Result<Teams, Exception>
}