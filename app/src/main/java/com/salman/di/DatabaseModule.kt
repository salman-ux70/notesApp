package com.salman.di

import android.app.Application
import androidx.room.Room

import com.salman.db.NotesDatabase
import com.salman.repo.Repository
import com.salman.repo.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(app: Application): NotesDatabase {
        return Room.databaseBuilder(
            app,
            NotesDatabase::class.java,
            "NotesDataBase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(db: NotesDatabase): Repository {
        return RepositoryImpl(db.dao)
    }

}