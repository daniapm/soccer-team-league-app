package com.dania.soccer_team_league_app.presentation.viewmodel

import com.dania.soccer_team_league_app.domain.model.Team

sealed class TeamEvent {
    data class SetTeams(val teams: List<Team>) : TeamEvent()
    object ShowLoading : TeamEvent()
    object ShowError : TeamEvent()
}
