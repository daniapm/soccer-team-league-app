package com.dania.soccer_team_league_app.domain.repository

import com.dania.soccer_team_league_app.domain.model.Team

interface TeamRepository {

    suspend fun getTeam(): List<Team>
}