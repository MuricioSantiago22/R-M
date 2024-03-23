package com.example.rm.presentation.di

import com.example.rm.domain.paged.CharacterListSource
import com.example.rm.presentation.viewModel.CharacterListViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
object ViewModelModule {

    @Provides
    fun provideCharacterListViewModel(
        characterListSource: CharacterListSource
    ):CharacterListViewModel{
        return CharacterListViewModel(characterListSource)}
}