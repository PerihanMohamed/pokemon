package com.example.mypokemoen.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.mypokemoen.db.PokemonDao
import com.example.mypokemoen.db.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton


@InstallIn(ApplicationComponent::class)
@Module
object DataBaseModule {
    @Singleton
    @Provides
     fun provideDB( @ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        PokemonDatabase::class.java,
        "your_db_name"
    ).allowMainThreadQueries().build() // The reason we can construct a database for the repo




    @Singleton
    @Provides
     fun provideDao(db: PokemonDatabase)  = db.pokemonDao()

}