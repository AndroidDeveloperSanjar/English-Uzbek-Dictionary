package com.example.dictionary.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionary.db.model.Words

@Dao
interface WordDao {
    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Words>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(wordList: ArrayList<Words>)

}