package com.dania.soccer_team_league_app.presentation.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dania.soccer_team_league_app.R
import com.dania.soccer_team_league_app.domain.model.Team
import com.dania.soccer_team_league_app.presentation.TeamDetailActivity
import com.google.android.material.card.MaterialCardView
import com.squareup.picasso.Picasso

class TeamListAdapter(
    private val teamList: List<Team>,
) : RecyclerView.Adapter<TeamListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = teamList[position]
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(R.layout.team_item, parent, false),
            parent.context
        )
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    class ViewHolder(view: View,val context: Context) : RecyclerView.ViewHolder(view) {
        private val team_card: MaterialCardView = view.findViewById(R.id.team_card)
        private val nameTeam: TextView = view.findViewById(R.id.team_name)
        private val stadiumName: TextView = view.findViewById(R.id.team_stadium)
        private val teamBadge: ImageView = view.findViewById(R.id.team_badge)

        fun bind(teamList: Team) {
            nameTeam.text = teamList.name
            stadiumName.text = teamList.stadium
            teamBadge.loadUrl(teamList.badge)
            team_card.setOnClickListener {
                val intent = Intent(context, TeamDetailActivity::class.java)
                intent.putExtra(TeamDetailActivity.TEAM_TAG, teamList)
                context.startActivity(intent)
            }
        }

        private fun ImageView.loadUrl(url: String) {
            Picasso.get().load(url).into(this)
        }

    }

}
