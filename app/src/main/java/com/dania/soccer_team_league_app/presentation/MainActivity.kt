package com.dania.soccer_team_league_app.presentation

import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.dania.soccer_team_league_app.R
import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.presentation.adapter.TeamListAdapter
import com.dania.soccer_team_league_app.presentation.viewmodel.TeamEvent
import com.dania.soccer_team_league_app.presentation.viewmodel.TeamViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progress: ProgressBar
    private lateinit var imageError: ImageView
    private lateinit var textError: TextView

    private val viewModel : TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        progress = findViewById(R.id.progress)
        imageError = findViewById(R.id.image_error)
        textError = findViewById(R.id.text_error)

        viewModel.getTeam()
        viewModel.event.observe(this, {
            when(it) {
                is TeamEvent.ShowLoading -> { showLoading() }
                is TeamEvent.ShowError -> { showError() }
                is TeamEvent.SetTeams -> { showTeam(it.teams) }
            }
        })
    }

    private fun showTeam(teams: List<Team>) {
        goneView()
        val mAdapter = TeamListAdapter(teams)
        recyclerView.adapter = mAdapter
    }

    private fun showLoading() {
        progress.isVisible = true
        imageError.isGone = true
        textError.isGone = true
    }

    private fun showError() {
        progress.isGone = true
        imageError.isVisible = true
        textError.isVisible = true
    }

    private fun goneView() {
        progress.isGone = true
        imageError.isGone = true
        textError.isGone = true
    }

}
