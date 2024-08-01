package com.example.word_app_dagger_hilt

import com.example.word_app_dagger_hilt.database.WordDAO
import com.example.word_app_dagger_hilt.model.Word
import javax.inject.Inject

class WordRepositoryImpl(
    private val wordDAO: WordDAO
) : WordRepository {
    override suspend fun insertWords(word: Word) {
        wordDAO.insertWord(word)
    }

    override suspend fun getAllWord(): List<Word> {
        return wordDAO.getAllWords()
    }
}