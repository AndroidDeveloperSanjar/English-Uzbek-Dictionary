package com.example.dictionary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.dictionary.db.dao.WordDao
import com.example.dictionary.db.model.Words
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Words::class], version = 1, exportSchema = false)
abstract class WordDatabase : RoomDatabase(){

    abstract fun getDao(): WordDao

    companion object{
        @Volatile private var INSTANCE: WordDatabase ?= null
        fun getDB(
            context: Context, scope: CoroutineScope
        ): WordDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordDatabase::class.java,
                    "WordDB"
                ).addCallback(WordDatabaseCallback(scope))
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.getDao())
                }
            }
        }

        suspend fun populateDatabase(wordDao: WordDao) {
            wordDao.insert(createWordsList())
        }

        private fun createWordsList(): ArrayList<Words> {
            val wordsList = ArrayList<Words>()
            wordsList.add(Words("Sanjar"))
            return wordsList
        }

    }

}