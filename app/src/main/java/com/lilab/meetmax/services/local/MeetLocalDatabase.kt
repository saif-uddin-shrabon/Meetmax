package com.lilab.meetmax.services.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lilab.meetmax.services.model.PostData

@Database(entities = [PostData::class], version = 3)
abstract class MeetLocalDatabase : RoomDatabase() {
    companion object{
        fun getInstance(context: Context) =
            Room.databaseBuilder(context, MeetLocalDatabase::class.java, "meetmax_db")
                .fallbackToDestructiveMigration().build()
    }


    abstract fun postDao(): PostDao

}