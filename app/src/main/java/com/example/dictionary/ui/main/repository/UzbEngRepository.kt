package com.example.dictionary.ui.main.repository

import androidx.lifecycle.LiveData
import com.example.dictionary.db.dao.UzbWordDao
import com.example.dictionary.db.model.Words

class UzbEngRepository(
    private val dao: UzbWordDao
) {

    val allWords: LiveData<List<Words>> = dao.getAlphabetizedUzbWords()

    suspend fun insert(wordList: ArrayList<Words>){
        dao.insertUzbWord(wordList)
    }
}