package com.dania.soccer_team_league_app.data.di

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object ServiceFactory {

    private const val BASE_URL = "https://www.thesportsdb.com/api/v1/json/2/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()


    fun <T> createRepository(apiClass: Class<T>): T {
        return retrofit.create(apiClass)
    }
}