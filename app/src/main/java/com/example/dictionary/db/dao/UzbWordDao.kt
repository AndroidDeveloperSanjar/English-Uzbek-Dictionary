package com.example.dictionary.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionary.db.model.Words

@Dao
interface UzbWordDao {
    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedUzbWords(): LiveData<List<Words>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUzbWord(wordList: ArrayList<Words>)

}