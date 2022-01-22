package com.dania.soccer_team_league_app.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dania.soccer_team_league_app.domain.model.Team

@Entity(tableName = "Teamdata")
data class TeamData(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "strTeam") val name: String,
    @ColumnInfo(name = "strStadium") val stadium: String,
    @ColumnInfo(name = "strTeamBadge") val badge: String,
    @ColumnInfo(name = "strDescriptionES") val description: String,
    @ColumnInfo(name = "intFormedYear") val formedYear: String,
    @ColumnInfo(name = "strTeamJersey") val jersey: String,
    @ColumnInfo(name = "strWebsite") val website: String?,
    @ColumnInfo(name = "strFacebook") val facebook: String?,
    @ColumnInfo(name = "strTwitter") val twitter: String?,
    @ColumnInfo(name = "strInstagram") val instagram: String?
)

fun TeamData.mapToDomain(): Team {
    return with(this) {
        Team(
            name = name,
            stadium = stadium,
            badge = badge,
            description = description,
            formedYear = formedYear,
            jersey = jersey,
            website = website,
            facebook = facebook,
            twitter = twitter,
            instagram = instagram
        )
    }
}