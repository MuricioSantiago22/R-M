package com.example.rm.data.di

import com.example.rm.data.repository.CharacterListRepositoryImpl
import com.example.rm.domain.repository.CharacterListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideCharacterListRepository(
        characterListRepositoryImpl: CharacterListRepositoryImpl
    ):CharacterListRepository
}