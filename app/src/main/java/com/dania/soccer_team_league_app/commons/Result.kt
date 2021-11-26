package com.dania.soccer_team_league_app.commons

sealed class Result<out Success, out Error> {
    data class Success<out Success>(val value: Success) : Result<Success, Nothing>()
    data class Error<out Error>(val reason: Error) : Result<Nothing, Error>()
}
