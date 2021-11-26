package com.dania.soccer_team_league_app.presentation

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.dania.soccer_team_league_app.R
import com.dania.soccer_team_league_app.commons.toUrl
import com.dania.soccer_team_league_app.domain.model.Team
import com.squareup.picasso.Picasso

class TeamDetailActivity : AppCompatActivity() {

    private lateinit var teamName: TextView
    private lateinit var teamDescription: TextView
    private lateinit var teamFormedYear: TextView
    private lateinit var teamBadged: ImageView
    private lateinit var teamJersey: ImageView
    private lateinit var teamWebsite: TextView
    private lateinit var teamFacebook: TextView
    private lateinit var teamInstagram: TextView
    private lateinit var teamTwitter: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_detail)

        init()
        setupViews()
    }

    private fun init() {
        teamName = findViewById(R.id.detail_team_name)
        teamDescription = findViewById(R.id.detail_team_description)
        teamFormedYear = findViewById(R.id.detail_formed_year_description)
        teamBadged = findViewById(R.id.detail_team_badged)
        teamJersey = findViewById(R.id.detail_team_jersey)
        teamWebsite = findViewById(R.id.detail_team_website)
        teamFacebook = findViewById(R.id.detail_team_facebook)
        teamInstagram = findViewById(R.id.detail_team_instagram)
        teamTwitter = findViewById(R.id.detail_team_twitter)
    }

    private fun setupViews() {
        val extras = intent.extras?.get(TEAM_TAG) as Team
        with(extras) {
            teamName.text = name
            teamDescription.text = description
            teamFormedYear.text = formedYear
            Picasso.get().load(badge).into(teamBadged)
            Picasso.get().load(jersey).into(teamJersey)
            website?.let {
                teamWebsite.isVisible = true
                teamWebsite.setOnClickListener { navigateToUrl(website) }
            }
            facebook?.let {
                teamFacebook.isVisible = true
                teamFacebook.setOnClickListener { navigateToUrl(facebook) }
            }
            instagram?.let {
                teamInstagram.isVisible = true
                teamInstagram.setOnClickListener { navigateToUrl(instagram) }
            }
            twitter?.let {
                teamTwitter.isVisible = true
                teamTwitter.setOnClickListener { navigateToUrl(twitter) }
            }
        }
    }

    private fun navigateToUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url.toUrl()))
        startActivity(intent)
    }

    companion object {
        const val TEAM_TAG = "team"
    }
}