package com.example.dictionary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dictionary.db.dao.EngWordDao
import com.example.dictionary.db.model.Words

@Database(entities = [Words::class], version = 1, exportSchema = false)
abstract class EngWordDatabase : RoomDatabase(){

    abstract fun getEngDao(): EngWordDao

    companion object{
        @Volatile private var INSTANCE: EngWordDatabase ?= null
        fun getDB(
            context: Context
        ): EngWordDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EngWordDatabase::class.java,
                    "EngWordDB"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}