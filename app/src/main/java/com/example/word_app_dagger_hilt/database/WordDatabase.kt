package com.example.word_app_dagger_hilt.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.word_app_dagger_hilt.model.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordDatabase:RoomDatabase() {

    abstract fun wordDao():WordDAO
}