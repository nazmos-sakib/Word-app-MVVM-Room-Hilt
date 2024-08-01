package com.example.word_app_dagger_hilt.DI

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.word_app_dagger_hilt.database.WordDAO
import com.example.word_app_dagger_hilt.database.WordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideWordsDatabase(@ApplicationContext context: Context): WordDatabase{
        return Room.databaseBuilder(
            context,
            WordDatabase::class.java,
            "words.DB"
        ).build()
    }

    @Provides
    fun provideWordsDOA(wordDatabase: WordDatabase):WordDAO{
        return wordDatabase.wordDao()
    }
}