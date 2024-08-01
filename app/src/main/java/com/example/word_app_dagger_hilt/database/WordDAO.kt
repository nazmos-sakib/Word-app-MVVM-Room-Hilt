package com.example.word_app_dagger_hilt.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.RoomDatabase
import com.example.word_app_dagger_hilt.model.Word

@Dao
interface WordDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word:Word)

    @Query("SELECT * FROM words")
    suspend fun getAllWords():List<Word>
}