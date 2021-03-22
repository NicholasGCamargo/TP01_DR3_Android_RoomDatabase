package com.example.tp01_nicholas_camargo_dr3.database

import android.content.Context
import androidx.room.Room

class AppDatabaseService {
    companion object{
        private var instance : AppDatabase? = null
        private var database_name = "appDatabase.sql"
        fun getInstance(context: Context): AppDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    database_name
                )
                    .build()
            }
            return instance as AppDatabase
        }
    }
}