package com.example.dictionary.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dictionary.db.WordDatabase
import com.example.dictionary.db.model.Words
import com.example.dictionary.ui.main.repository.EngUzbRepository
import kotlinx.coroutines.launch

class EngUzbViewModel(
    application: Application
): AndroidViewModel(application){

    private  var repository: EngUzbRepository

    var allWords: LiveData<List<Words>>

    init {
        val wordsDao = WordDatabase.getDB(application, viewModelScope).getDao()
        repository = EngUzbRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(wordList: ArrayList<Words>) = viewModelScope.launch {
        repository.insert(wordList)
    }

}