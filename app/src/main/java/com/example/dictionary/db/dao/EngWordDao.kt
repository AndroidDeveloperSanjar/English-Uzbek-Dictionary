package com.example.dictionary.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionary.db.model.Words

@Dao
interface EngWordDao {
    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedEngWords(): LiveData<List<Words>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertEngWord(wordList: ArrayList<Words>)

}