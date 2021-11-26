package com.dania.soccer_team_league_app.commons

private const val HOST = "https://"

fun String.toUrl(): String = if (this.contains(HOST)) {
    this
} else {
    HOST + this
}