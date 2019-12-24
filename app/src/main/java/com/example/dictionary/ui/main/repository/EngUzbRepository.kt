package com.example.dictionary.ui.main.repository

import androidx.lifecycle.LiveData
import com.example.dictionary.db.dao.WordDao
import com.example.dictionary.db.model.Words

class EngUzbRepository(
    private val dao: WordDao
) {
    val allWords: LiveData<List<Words>> = dao.getAlphabetizedWords()

    suspend fun insert(wordList: ArrayList<Words>){
        dao.insert(wordList)
    }
}