package com.example.dictionary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dictionary.db.dao.EngWordDao
import com.example.dictionary.db.dao.UzbWordDao
import com.example.dictionary.db.model.Words

@Database(entities = [Words::class], version = 1, exportSchema = false)
abstract class UzbWordDatabase : RoomDatabase(){

    abstract fun getUzbDao(): UzbWordDao

    companion object{
        @Volatile private var INSTANCE: UzbWordDatabase ?= null
        fun getDB(
            context: Context
        ): UzbWordDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UzbWordDatabase::class.java,
                    "UzbWordDB"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}