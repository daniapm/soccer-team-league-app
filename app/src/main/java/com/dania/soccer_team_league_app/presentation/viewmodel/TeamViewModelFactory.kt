package com.dania.soccer_team_league_app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dania.soccer_team_league_app.data.remote.datasource.TeamRemoteDataSource
import com.dania.soccer_team_league_app.data.repository.TeamRepositoryImpl
import com.dania.soccer_team_league_app.domain.usecase.GetTeamUseCase

class TeamViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TeamViewModel(GetTeamUseCase(TeamRepositoryImpl(TeamRemoteDataSource()))) as T
    }

}