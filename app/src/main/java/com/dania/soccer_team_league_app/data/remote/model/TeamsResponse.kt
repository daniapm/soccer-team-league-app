package com.dania.soccer_team_league_app.data.remote.model

import com.dania.soccer_team_league_app.data.db.TeamData
import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @SerializedName("teams") val teams: List<TeamResponse>
)

fun TeamsResponse.mapToData(): List<TeamData> {
    return with(this) {
        teams.map { it.mapToData() }
    }
}

