package com.example.dictionary.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dictionary.db.UzbWordDatabase
import com.example.dictionary.db.model.Words
import com.example.dictionary.ui.main.repository.UzbEngRepository
import kotlinx.coroutines.launch

class UzbEngViewModel(
    application: Application
): AndroidViewModel(application){

    private  var repository: UzbEngRepository

    var allWords: LiveData<List<Words>>

    init {
        val wordsDao = UzbWordDatabase.getDB(application).getUzbDao()
        repository = UzbEngRepository(wordsDao)
        allWords = repository.allWords
    }

    fun insert(wordList: ArrayList<Words>) = viewModelScope.launch {
        repository.insert(wordList)
    }

}