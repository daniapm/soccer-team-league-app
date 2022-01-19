package com.dania.soccer_team_league_app.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dania.soccer_team_league_app.commons.Result
import com.dania.soccer_team_league_app.domain.usecase.GetTeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamUseCase: GetTeamUseCase
) : ViewModel() {

    private val eventMutableLiveData = MutableLiveData<TeamEvent>()
    val event: LiveData<TeamEvent> get() = eventMutableLiveData

    fun getTeam() {
        viewModelScope.launch {
            eventMutableLiveData.value = TeamEvent.ShowLoading
            when (val teams = getTeamUseCase.invoke()) {
                is Result.Success -> {
                    eventMutableLiveData.value = TeamEvent.SetTeams(teams.value.teams)
                }
                is Result.Error -> eventMutableLiveData.value = TeamEvent.ShowError
            }
        }

    }

}
