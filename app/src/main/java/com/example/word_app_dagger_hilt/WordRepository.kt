package com.example.word_app_dagger_hilt

import com.example.word_app_dagger_hilt.model.Word

interface WordRepository {
    suspend fun insertWords(word:Word)
    suspend fun getAllWord():List<Word>
}