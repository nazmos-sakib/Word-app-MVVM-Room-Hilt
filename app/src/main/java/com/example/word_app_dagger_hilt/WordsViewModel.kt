package com.example.word_app_dagger_hilt

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.word_app_dagger_hilt.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject  constructor(
    private val wordRepository: WordRepository
):ViewModel() {
    fun saveWord(text: String) = liveData {
        try {
            wordRepository.insertWords(Word(0,text))
            emit(true)
        } catch (e:Exception){
            emit(false)
        }
    }

    fun getAllWords() = liveData {
        emit(wordRepository.getAllWord())
    }

}