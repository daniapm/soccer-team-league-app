package com.dania.soccer_team_league_app.data.di

import com.dania.soccer_team_league_app.data.remote.model.TeamResponse
import com.dania.soccer_team_league_app.data.repository.TeamRepositoryApi
import com.dania.soccer_team_league_app.domain.model.Team
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/2/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


object repositoryApi {
    val retrofitService: TeamRepositoryApi by lazy {
        retrofit.create(TeamRepositoryApi::class.java)
    }
}