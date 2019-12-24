package com.example.dictionary.ui.main.repository

import androidx.lifecycle.LiveData
import com.example.dictionary.db.dao.EngWordDao
import com.example.dictionary.db.model.Words

class EngUzbRepository(
    private val dao: EngWordDao
) {
    val allWords: LiveData<List<Words>> = dao.getAlphabetizedEngWords()

    suspend fun insert(wordList: ArrayList<Words>){
        dao.insertEngWord(wordList)
    }
}