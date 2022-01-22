package com.dania.soccer_team_league_app.data.di.provider

import android.content.Context
import androidx.room.Room
import com.dania.soccer_team_league_app.data.db.AppDatabase
import com.dania.soccer_team_league_app.data.db.TeamDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//DBModule is module class which tells Dagger Hilt how to provide a
// AppDatabase object when needed, also it is preferred to have only
@InstallIn(SingletonComponent::class)
@Module
object DbModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "SoccerDb"
        ).build()
    }

    @Provides
    fun provideTeamDao(database: AppDatabase): TeamDao {
        return database.teamDao()
    }
}

// one instance of db.
