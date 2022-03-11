package com.dania.soccer_team_league_app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TeamData::class], version = 1)
abstract class AppDatabase : RoomDatabase(){

    abstract fun teamDao(): TeamDao
}
