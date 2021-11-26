package com.dania.soccer_team_league_app.data.remote.model

import com.dania.soccer_team_league_app.domain.model.Teams
import com.google.gson.annotations.SerializedName

data class TeamsResponse(
    @SerializedName("teams") val teams: List<TeamResponse>
)

fun TeamsResponse.mapToDomain(): Teams {
    return with(this) {
        Teams(
            teams = teams.map { it.mapToDomain() }
        )
    }
}
