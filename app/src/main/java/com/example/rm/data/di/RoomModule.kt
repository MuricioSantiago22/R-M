package com.example.rm.data.di

import android.content.Context
import androidx.room.Room
import com.example.rm.data.local.db.RMDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val RM_DATABASE_NAME = "r&m_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context)=
        Room.databaseBuilder(context, RMDataBase::class.java,RM_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideGetCharacterData(db:RMDataBase)= db.getCharacterDataDao()
}