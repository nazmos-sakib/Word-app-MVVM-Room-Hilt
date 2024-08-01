package com.example.word_app_dagger_hilt.DI

import com.example.word_app_dagger_hilt.WordRepository
import com.example.word_app_dagger_hilt.WordRepositoryImpl
import com.example.word_app_dagger_hilt.database.WordDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
object WordsModelViewModule {

    @Provides
    fun provideWordRepository(wordDAO: WordDAO): WordRepository{
        return WordRepositoryImpl(wordDAO)
    }
}