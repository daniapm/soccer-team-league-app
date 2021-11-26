package com.dania.soccer_team_league_app.data.remote.model

import com.dania.soccer_team_league_app.domain.model.Team
import com.google.gson.annotations.SerializedName

data class TeamResponse(
    @SerializedName("strTeam") val name: String?,
    @SerializedName("strStadium") val stadium: String?,
    @SerializedName("strTeamBadge") val badge: String?,
    @SerializedName("strDescriptionES") val description: String?,
    @SerializedName("intFormedYear") val formedYear: String?,
    @SerializedName("strTeamJersey") val jersey: String?,
    @SerializedName("strWebsite") val website: String?,
    @SerializedName("strFacebook") val facebook: String?,
    @SerializedName("strTwitter") val twitter: String?,
    @SerializedName("strInstagram") val instagram: String?,
)

fun TeamResponse.mapToDomain(): Team {
    return with(this) {
        Team(
            name = name.orEmpty(),
            stadium = stadium.orEmpty(),
            badge = badge.orEmpty(),
            description = description.orEmpty(),
            formedYear = formedYear.orEmpty(),
            jersey = jersey.orEmpty(),
            website = website,
            facebook = facebook,
            twitter = twitter,
            instagram = instagram
        )
    }
}
