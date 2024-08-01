package com.example.word_app_dagger_hilt.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//room database
@Entity(tableName = "words")
data class Word (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val word:String
)