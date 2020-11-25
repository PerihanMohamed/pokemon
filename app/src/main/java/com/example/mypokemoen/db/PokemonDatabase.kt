package com.example.mypokemoen.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mypokemoen.model.Poekmon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton



@Database(
    entities = [Poekmon::class], // Tell the database the entries will hold data of this type
    version = 1 ,
    exportSchema =false
)


abstract class PokemonDatabase :RoomDatabase() {



    abstract fun pokemonDao (): PokemonDao

//    companion object {
//        // Singleton prevents multiple instances of database opening at the
//        // same time.
//        @Volatile
//        private var INSTANCE: PokemonDatabase? = null
//
//        @Provides
//        @Singleton
//        fun getDatabase(context: Context): PokemonDatabase {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    PokemonDatabase::class.java,
//                    "word_database"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
//    }



}