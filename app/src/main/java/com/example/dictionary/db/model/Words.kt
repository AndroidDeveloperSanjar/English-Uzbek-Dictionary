package com.example.dictionary.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Words(

    @PrimaryKey
    @ColumnInfo(name = "word")
    val word: String
)

