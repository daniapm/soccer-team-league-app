package com.dania.soccer_team_league_app.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val name: String,
    val stadium: String,
    val badge: String,
    val description: String,
    val formedYear: String,
    val jersey: String,
    val website: String?,
    val facebook: String?,
    val twitter: String?,
    val instagram: String?
) : Parcelable
