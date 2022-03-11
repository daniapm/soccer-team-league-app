package com.dania.soccer_team_league_app.data.di.provider

import com.dania.soccer_team_league_app.data.services.TeamRepositoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceFactory {

    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/2/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Singleton
    @Provides
    fun provideTeamRepositoryApi(): TeamRepositoryApi =
        provideRetrofit().create(TeamRepositoryApi::class.java)
}