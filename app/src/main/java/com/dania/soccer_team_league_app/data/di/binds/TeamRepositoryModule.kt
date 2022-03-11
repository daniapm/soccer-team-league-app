package com.dania.soccer_team_league_app.data.di.binds

import com.dania.soccer_team_league_app.data.repository.TeamRepositoryImpl
import com.dania.soccer_team_league_app.domain.repository.TeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class TeamRepositoryModule {

    @Binds
    abstract fun bindTeamRepository(
        teamRepositoryImpl: TeamRepositoryImpl
    ) : TeamRepository
}
