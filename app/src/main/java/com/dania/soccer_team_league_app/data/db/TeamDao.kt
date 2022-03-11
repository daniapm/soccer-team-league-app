package com.dania.soccer_team_league_app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {

    @Query("SELECT * FROM teamdata")
    fun getAllTeam(): Flow<List<TeamData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(teamData: List<TeamData>)
}
